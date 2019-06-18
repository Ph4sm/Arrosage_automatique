/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiciel;

import javax.swing.JFrame;
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
 *
 * <b>
 * Cette classe gère l'affichage de la fenetre chargé de modifié
 * le type d'arrosage pour les plantes sélectionnées;
 * </b>
 * @author p1802204
 */
public class FenetreArrosage extends JFrame{
    
    MaFenetre fen;
    
    JLabel selectp;
    JLabel selectm;
    JButton Conti;
    JButton Auto;
    JButton Agen;
    JPanel pano;
    

    public FenetreArrosage(MaFenetre fen) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Sélection de type");
        this.fen=fen;
        
        innitPannel();
    }
    
    public void innitPannel(){
        selectp= new JLabel("Parcelle(s) Sélectionnée(s)");
        selectm=new JLabel("Sélection du mode");
        
        Conti=new JButton("CONTINU");
        Auto=new JButton("AUTOMATIQUE");
        Agen=new JButton("AGENDA");
        
         
        pano =new JPanel();
        
        pano.setLayout(new GridBagLayout());
        
        GridBagConstraints gc= new GridBagConstraints();
        
        gc.fill=GridBagConstraints.BOTH;
        
        
        gc.gridx=0;
        gc.gridy=0;
        gc.gridwidth=1;
        gc.gridheight=1;
        gc.insets=new Insets(10,10,10,10);
        pano.add(selectp, gc);
        
        gc.gridx=1;
        gc.gridy=0;
        gc.gridwidth=1;
        gc.gridheight=1;
        gc.insets=new Insets(10,10,10,10);
        pano.add(selectm, gc);
        
        gc.gridx=1;
        gc.gridy=1;
        gc.gridwidth=1;
        gc.gridheight=1;
        gc.insets=new Insets(10,10,10,10);
        pano.add(Conti, gc);
        
        gc.gridx=1;
        gc.gridy=2;
        gc.gridwidth=1;
        gc.gridheight=1;
        gc.insets=new Insets(10,10,10,10);
        pano.add(Auto, gc);
        
        gc.gridx=1;
        gc.gridy=3;
        gc.gridwidth=1;
        gc.gridheight=2;
        gc.insets=new Insets(10,10,10,10);
        pano.add(Agen, gc);
        
        
        this.setContentPane(pano);
        this.pack();
        
        
    }
    
    
    
}
