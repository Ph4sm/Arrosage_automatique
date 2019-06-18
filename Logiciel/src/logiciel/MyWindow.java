/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiciel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javafx.scene.layout.Border;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 *
 * @author Louis
 */
public class MyWindow extends JFrame implements ActionListener, KeyListener{
    private String recup;
    private String min;
    private String max;
    private JPanel panel;
    //private Rpi donnée;
    private MaFenetre fen;
    
    
    private JLabel title = new JLabel("Rentrez les informations de votre nouvelle plante :", SwingConstants.CENTER);
    private JLabel nb_parcelle = new JLabel("Parcelle : ");
    private javax.swing.border.Border border = LineBorder.createGrayLineBorder();
    private JTextField nomPlante = new JTextField("");
    private JLabel humiditemin = new JLabel("Humidité minimale pour la plante : ");
    private JLabel humiditemax = new JLabel("Humidité maximale pour la plante : ");
    
    
    private JTextField hummin = new JTextField();
    private JTextField hummax = new JTextField();
    String hmin=hummin.getText();
    String hmax=hummax.getText();
    
    private JLabel modeArrosage = new JLabel("Mode d'arrosage : ");
    private String[] tab = {"Constant", "Automatique", "Agenda"};
    private JComboBox mode = new JComboBox(tab);
    private JButton enregistrer = new JButton("Enregistrer");
    
    public MyWindow(Rpi donnée, MaFenetre fen){
        this.setTitle("Ajout de plante");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.fen=fen;
        panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints cont = new GridBagConstraints();
        cont.fill = GridBagConstraints.BOTH;
        
        
        
        cont.gridx=0;
        cont.gridy=1;
        cont.insets=new Insets(5,5,5,5);
        panel.add(nb_parcelle, cont);
        
        //cont.gridx=0;
        cont.gridy=2;
        panel.add(nomPlante, cont);
        nomPlante.setColumns(10);
        
        //cont.gridx=0;
        cont.gridy=3;
        panel.add(humiditemin, cont);
        
        cont.gridx=1;
        cont.gridy=3;
        panel.add(hummin, cont);
        hummin.setColumns(8);
        
        cont.gridx=0;
        cont.gridy=4;
        panel.add(humiditemax, cont);
        
        cont.gridx=1;
        cont.gridy=4;
        panel.add(hummax, cont);
        hummin.setColumns(8);
        
        //cont.gridx=1;
        cont.gridy=0;
        title.setBorder(border);
        panel.add(title, cont);
        
        cont.gridx=0;
        cont.gridy=5;
        panel.add(modeArrosage, cont);
        
        cont.gridy=6;
        panel.add(mode, cont);
        
        cont.gridx=2;
        panel.add(enregistrer, cont);
        
        this.setContentPane(panel);
        this.pack();
        
        nomPlante.addKeyListener(this);
        hummin.addKeyListener(this);
        hummax.addKeyListener(this);
        enregistrer.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==enregistrer){
            int nbligne=1;
            String num="Parcelle n°";
            String s=(String) mode.getSelectedItem();
            num=num+(fen.getDonnées().getParcelles().size()+1);
            Double min2=Double.parseDouble(min);
            Double max2=Double.parseDouble(max);
            Pied pi=new Pied(num,recup,min2,max2,s);
            //donnée.equals(pi);
            fen.getDonnées().addpied(pi);
            //fen.setContentPane(fen.pano);
            fen.initPannel();
            /*
            if(fen.getDonnées().getParcelles().size()%3==1){
                nbligne++;
            }
            fen.getVp().setSize(fen.getVp().getWidth(),
                    (fen.getVp().getHeight()+120)*nbligne);
            fen.setSize(fen.getWidth(),(fen.getHeight()+120)*nbligne );
            */
            
            
            repaint();
            
            this.setVisible(false);
            fen.setVisible(true);
            
            
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getSource()==nomPlante){
            recup=nomPlante.getText();            
        }
        if(e.getSource()==hummin){
            min=hummin.getText();
        }
        if(e.getSource()==hummax){
            max=hummax.getText();
        }
    }
}