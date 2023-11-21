/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectologistica;

/**
 *
 * @author sorli
 */
public abstract class Ruta {
    protected String ciudadOrigen;
    protected String ciudadDestino;
    protected String paisOrigen;
    protected String paisDestino;
    
    protected Ruta(){
        
    }
    protected Ruta (String ciudadOrg, String ciudadDest, String paisOrg, String paisDest){
        this.ciudadOrigen = ciudadOrg;
        this.ciudadDestino = ciudadDest;
        this.paisOrigen = paisOrg;
        this.paisDestino = paisDest;
    }
    protected void estableceRuta(String ciudadOrg, String ciudadDest, String paisOrg, String paisDest) {
        this.ciudadOrigen = ciudadOrg;
        this.ciudadDestino = ciudadDest;
        this.paisOrigen = paisOrg;
        this.paisDestino = paisDest;
    }
    
    protected abstract void setCOrg(String ciudadOrg);
    
    protected abstract void setCDest(String ciudadDest);
}
