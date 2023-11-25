/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectologistica;

/**
 * La clase Ruta la hago abstracta porque no tiene 
 * sentido que cree objetos de ella ni que defina su implementacion
 * Simplemente la he hecho porque agrupa cosas comunes de las distintas
 * rutas, (terrestres, aéreas y marítimas), que son las que si que pueden ocurrir
 * en la realidad
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
    
    protected abstract void setPOrg(String paisOrg);
    
    protected abstract void setPDest(String paisDest);
}
