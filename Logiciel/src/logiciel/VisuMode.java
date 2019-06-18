/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiciel;

import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JComponent;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 *
 * @author p1802204
 */
public class VisuMode extends JComponent {
    private MaFenetre fen;

    public VisuMode(MaFenetre en) {
        this.fen=fen;
    }
    
    
    
    
    
    @Override
    public void paintComponent(Graphics g){
        int x=0;
        int y=0;
        g.setColor(Color.WHITE);
        for(int i=0; i<fen.getDonnées().getParcelles().size();i++){
            if(fen.getDonnées().getParcelles().get(i).clicked==true){
                
            }
        }
    }
    
    @Override
    public Dimension getPreferredSize(){
        int x=0;
        int y=0;
        
        x=
        y=(fen.getDonnées().getParcelles().size()*120);
        
        return new Dimension(x,y);
    }
}
