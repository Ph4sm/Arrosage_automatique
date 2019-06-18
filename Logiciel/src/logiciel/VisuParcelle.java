/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiciel;

import javax.swing.JComponent;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
/**
 *<b>
 * Cette classe gère la forme graphique qui sera donnée a chaque parcelle
 * </b>
 * <p>
 * cette classe est caractérisée par : 
 * </p>
 * <p>- les données renvoyée par la carte Rpi</p>
 * <p>-une valeur qui indique la limite de la zone de la parcelle en ordonnée</p>
 * 
 * @author Yoan
 * @version 1
 */
public class VisuParcelle extends JComponent {
    private Rpi donnée;
    private double limitclickdown;
    private double limitclickup;
    private int nbligne=1;
    private int cpt=1;
    private Dimension d;
    
    

    public VisuParcelle( Rpi donnée) {
        this.donnée = donnée;
    }

    public Rpi getDonnée() {
        return donnée;
    }

    public double getLimitclickdown() {
        return limitclickdown;
    }
    public double getLimitclickup() {
        return limitclickup;
    }

    public Dimension getD() {
        return d;
    }
    
    

    public void setDonnée(Rpi donnée) {
        this.donnée = donnée;
    }

    public void setLimitclickdown(double limitclickdown) {
        this.limitclickdown = limitclickdown;
    }
    public void setLimitclickup(double limitclickup) {
        this.limitclickup = limitclickup;
    }
    
    
    
    @Override
    public void paintComponent(Graphics g){
        int x=0;
        int y=0;
        
        getPreferredSize();
        for(int i=0; i<donnée.getParcelles().size();i++){
            
            g.setColor(Color.GREEN);
            g.drawRect(x, y, 100, 100);
            g.setColor(Color.BLACK);
            g.drawString(donnée.getParcelles().get(i).getNumparcelle(), x+10, y+15);
            g.drawString(donnée.getParcelles().get(i).getPlante(), x+10, y+30);
            g.drawString(donnée.getParcelles().get(i).getHumimin()+"%", x+10, y+45);
            g.drawString(donnée.getParcelles().get(i).getHumimax()+"%", x+10, y+60);
            g.drawString(donnée.getParcelles().get(i).getMode(), x+10, y+75);
            
            donnée.getParcelles().get(i).setLimitclickdown(y+100);
            donnée.getParcelles().get(i).setLimitclickup(y);
            donnée.getParcelles().get(i).setLimitclickleft(x);
            donnée.getParcelles().get(i).setLimitclickright(x+100);
            x+=120;
                if(cpt==3){
                    y+=120;
                    x=0;
                    cpt=0;
                }
                cpt++;
        }
        
        
    }
    
    @Override
    public Dimension getPreferredSize(){
        int x=0;
        int y=0;
        
        
        x=((donnée.getParcelles().size()*100)/2)
                +(20*3);
        y=((2*100)+20)*donnée.getParcelles().size()/3;
        d=new Dimension(x,y);
        return d;
    }
    
    
}
