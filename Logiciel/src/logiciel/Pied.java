/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiciel;

/**
 *
 * Cette classe contient toutes les données d'unes parcelles
 * <p>
 * elle est caractérisé par : 
 * </p>
 * <ul>
 * <li>Le numéro de la parcelle</li>
 * <li> Le nom de ce qui est planté dans la parcelle</li>
 * <li>l'humidité minimale toléré par la plante</li>
 * <li>l'humidité maximum toléré par la plante</li>
 * 
 * </ul>
 * @author Yoan
 * @version 1
 */
public class Pied {
    String numparcelle;
    String plante;
    double humimin;
    double humimax;
    String mode;
    
    private double limitclickdown;
    private double limitclickup;
    private double limitclickleft;
    private double limitclickright;
    boolean clicked=false;
    
    public Pied(String numparcelle, String plante, double humimin, double humimax, String mode) {
        this.numparcelle = numparcelle;
        this.plante = plante;
        this.humimin = humimin;
        this.humimax = humimax;
        this.mode = mode;
    }
    
    
    
    
    public void setLimitclickleft(double limitclickleft) {
        this.limitclickleft = limitclickleft;
    }

    public void setLimitclickright(double limitclickright) {
        this.limitclickright = limitclickright;
    }
    
     public void setLimitclickdown(double limitclickdown) {
        this.limitclickdown = limitclickdown;
    }
    public void setLimitclickup(double limitclickup) {
        this.limitclickup = limitclickup;
    }
    
    
    
    
    
    public double getLimitclickdown() {
        return limitclickdown;
    }
    public double getLimitclickup() {
        return limitclickup;
    }

    public double getLimitclickleft() {
        return limitclickleft;
    }

    public double getLimitclickright() {
        return limitclickright;
    }    
    
    public double getHumimin() {
        return humimin;
    }

    public double getHumimax() {
        return humimax;
    }
    
    public String getNumparcelle() {
        return numparcelle;
    }

    public String getPlante() {
        return plante;
    }
    
    public String getMode() {
        return mode;
    }

    
    
    
    public void setHumimin(double humimin) {
        this.humimin = humimin;
    }

    public void setHumimax(double humimax) {
        this.humimax = humimax;
    }

    public void setNumparcelle(String numparcelle) {
        this.numparcelle = numparcelle;
    }

    public void setPlante(String plante) {
        this.plante = plante;
    }

    

    public void setMode(String mode) {
        this.mode = mode;
    }
    
    
}
