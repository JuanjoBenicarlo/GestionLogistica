/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectologistica;

/**
 *
 * @author sorli
 */
public class RutaAerea extends Ruta {
    
    protected int numeroEscalas;
    protected boolean espacioShengen;
    protected boolean bultoVertical;
    protected boolean SistemaIzado;
    protected int numeroBultos;
    protected String operadora;
    
    protected RutaAerea(){
        super();
    }
    
    protected RutaAerea(String ciudadOrg, String ciudadDest, String paisOrg, String paisDest){
        super(ciudadOrg, ciudadDest, paisOrg, paisDest); 
    }
    
    protected void setCOrg(String ciudadOrg){
        this.ciudadOrigen = ciudadOrg;
    }
    
    protected void setCDest(String ciudadDest){
        this.ciudadDestino = ciudadDest;
    }
    
    protected void setPOrg(String paisOrg) {
        this.paisOrigen = paisOrg;
    }

    protected String getPOrg(){
        return this.paisOrigen;
    }

    protected void setPDest(String paisDest) {
        this.paisDestino = paisDest;
    }
    
    protected String getPDest(){
        return this.paisDestino;
    }
    
}
