/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiciel;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

/**
 *
 * Cette classe reçoit toutes les données de capteur
 * elle gère les parcelles ainsi que les modes d'arrosages
 * @author Yoan
 * @version 1
 */
public class Rpi {
    private double humi;
    private double temp;
    private ArrayList<Pied> parcelles;
    
    /**
     * Création d'une classe Rpi et initialisation des paramètre
     * de la classe
     * @param humi
     *      l'humidité reçus par la carte
     * @param temp
     *      la température reçut par une carte
     * 
     */
    public Rpi(double humi, double temp ) {
        this.humi = humi;
        this.temp = temp;
        
        parcelles=new ArrayList();
        
    }

    public double getHumi() {
        return humi;
    }

    public double getTemp() {
        return temp;
    }

    public ArrayList<Pied> getParcelles() {
        return parcelles;
    }

    public void setHumi(double humi) {
        this.humi = humi;
    }

    public void setTemp(double temp) {
        this.temp = temp;
    }

    public void setParcelles(ArrayList<Pied> parcelles) {
        this.parcelles = parcelles;
    }
    
    /**
     * Cete fonction rajoute une parcelle a la liste de parcelle
     * enregistrée dans la carte
     * @param p
     *      Une parcelle
     * 
     * 
     */
    public void addpied(Pied p){
        parcelles.add(p);
    }
    
    public void addpied2(Pied p) throws SQLException{
        System.out.println("mdr ui");
        Connection cnx= DriverManager.getConnection("jdbc:sqlite:Jardin2.sqlite");
        System.out.println("connexion ui");
        Statement lien= cnx.createStatement();
        System.out.println("statement: check");
        
        ResultSet rs;
        rs=lien.executeQuery("INSERT INTO ");
        
        lien.close();
        cnx.close();
    }
}
