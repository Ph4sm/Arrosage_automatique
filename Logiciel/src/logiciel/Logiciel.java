/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiciel;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * il s'agit du main du logiciel ou l'on peut créer l'interface graphique
 * a partir de la classe MaFenetre
 * @author p1802204
 */
public class Logiciel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
        
        Pied p1= new Pied("Parcelle n°1", "tomate", 20,80, "Automatique");
        Pied p2= new Pied("Parcelle n°2", "riz", 50,99, "Automatique");
        Pied p3= new Pied("Parcelle n°3", "maïs", 30,50, "Agenda");
        Pied p4=new Pied("Parcelle n°4","blé",14,52,"Constant");
        Rpi données=new Rpi(20, 5);
        /*
        données.getParcelles().add(p1);
        données.getParcelles().add(p2);
        données.getParcelles().add(p3);
        */
        données.addpied(p1);
        données.addpied(p2);
        données.addpied(p3);
        //données.addpied(p4);
        MaFenetre f=new MaFenetre(données);
        f.setVisible(true);
                       
            
        
        for(int i=0; i<f.getDonnées().getParcelles().size();i++){
            System.out.println(f.getDonnées().getParcelles().get(i).numparcelle);
        }               
        
        
    }   
    
}
