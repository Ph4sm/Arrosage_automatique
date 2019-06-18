/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiciel;

import grovepi.GrovePi;
import grovepi.sensors.TemperatureAndHumiditySensor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


/**
 * <b>
 * Cette classe gère l'affichage graphique de la fenêtre d'affichage
 * de toutes les parcelles sur la Grove Pi.
 * </b>
 * <p>
 * Une fenêtre est caractérisé par:
 * </p>
 * <p>
 * -des données provennant de la carte
 * </p>
 * <p>
 * -Un composant VisuParcelle qui donne une forme graphique au données de la parcelle
 * récupéré par la carte
 * </p>
 * @author Yoan
 * @version 1
 */
public class MaFenetre extends JFrame implements ActionListener,
        MouseListener{
    
    private Rpi données;
    private VisuParcelle vp;
    private MyWindow mw;
    private FenetreArrosage fa;
    
    JPanel pano;
    JButton addparcelle;
    JButton mode;
    JLabel temp;
    JLabel humi;
    
    public static final int DIGITAL_PIN_5 = 5;
    
    /**
     * Constructeur de MaFenetre
     * a la construction de l'objet on crée une fenètre SWING
     * 
     * @param données
     *      objet contenant toutes les données de la cartes
     * 
     */
    public MaFenetre(Rpi données) {
        this.données = données;
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Gestion de parcelle");
        
        initPannel();
    }

    public VisuParcelle getVp() {
        return vp;
    }
    
    
    
    public Rpi getDonnées() {
        return données;
    }

    public void setDonnées(Rpi données) {
        this.données = données;
    }
    
    
    public void initPannel(){
        mode= new JButton("Définir arrosage");
        
        addparcelle=new JButton("Ajouter une parcelle");
        
        GrovePi pi = new GrovePi();
        TemperatureAndHumiditySensor th = new TemperatureAndHumiditySensor(pi, DIGITAL_PIN_5, TemperatureAndHumiditySensor.Model.DHT22);
        th.update();
        
        String température=Double.toString(th.getTemperature());
        String s="";
        s=s+" Température : "+température+"°C";
        temp=new JLabel(s);
        
        String humidité=Double.toString(th.getHumidity());
        String h="";
        h=h+"Humidité : "+humidité+"%";
        humi=new JLabel(h);
        
        
        pano =new JPanel();
        
        pano.setLayout(new GridBagLayout());
        
        GridBagConstraints gc= new GridBagConstraints();
        
        gc.fill=GridBagConstraints.BOTH;
        
        gc.gridx=0;
        gc.gridy=0;
        gc.gridwidth=1;
        gc.gridheight=2;
        gc.insets=new Insets(10,10,10,10);
        pano.add(addparcelle, gc);
        
        gc.gridx=1;
        gc.gridy=0;
        pano.add(mode, gc);
        
        gc.gridx=2;
        gc.gridy=0;
        gc.gridwidth=1;
        gc.gridheight=1;
        gc.insets=new Insets(0, 10, 0, 10);
        pano.add(temp, gc);
        
        gc.gridx=2;
        gc.gridy=1;
        gc.gridwidth=1;
        gc.gridheight=1;
        gc.insets=new Insets(0, 10, 0, 10);
        pano.add(humi, gc);
        
        vp= new VisuParcelle(données);
        gc.gridx=0;
        gc.gridy=2;
        gc.gridwidth=3;
        gc.insets= new Insets(10,10,10,10);
        pano.add(vp,gc);
        
        this.setContentPane(pano);
        this.pack();
        
        addparcelle.addActionListener(this);
        mode.addActionListener(this);
        vp.addMouseListener(this);
     
    }
     
    
    public Pied getParcelleclicked(Pied pl){
        System.out.println(pl.getPlante());
        pl.clicked=true;    
        return pl;
    }
        
    
    @Override
    public void actionPerformed(ActionEvent e) {  
        if(e.getSource()==addparcelle){
            mw=new MyWindow(données, this);
            mw.setVisible(true);
            
            this.setVisible(false);
            
            
        }
        if(e.getSource()==mode){
            fa=new FenetreArrosage(this);
            fa.setVisible(true);
            
            this.setVisible(false);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {    }

    @Override
    public void mousePressed(MouseEvent e) {    }

    @Override
    public void mouseReleased(MouseEvent e) {
        String p;
        Pied pl;
        for(int i=0; i<données.getParcelles().size();i++){
            if(e.getY()<données.getParcelles().get(i).getLimitclickdown()
                    && e.getY()>données.getParcelles().get(i).getLimitclickup()
                    &&e.getX()>données.getParcelles().get(i).getLimitclickleft()
                    &&e.getX()<données.getParcelles().get(i).getLimitclickright()){
                pl=données.getParcelles().get(i);
            
            getParcelleclicked(pl);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {    }

    @Override
    public void mouseExited(MouseEvent e) {    }   
    
}
