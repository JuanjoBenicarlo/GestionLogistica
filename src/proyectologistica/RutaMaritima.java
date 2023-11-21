/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectologistica;

/**
 * 
 * @author sorli
 */
public class RutaMaritima extends Ruta {

    
    protected String nombreBarco;
    protected boolean canalPanama;
    protected boolean canalSuez;
    protected int cantidadContenedores;
    protected boolean openTop;
    
    protected RutaMaritima(){
        super();
    }
    
    protected RutaMaritima(String ciudadOrg, String ciudadDest, String paisOrg, String paisDest){
        super(ciudadOrg, ciudadDest, paisOrg, paisDest); 
        this.canalPanama = false;
        this.canalSuez = false;
        this.openTop = false;
    }
    
    
    protected void usoCanalSuez(boolean uso){
        this.canalSuez = uso;
    }
    
    protected boolean usoCanalSuez(){
        return this.canalSuez;
    }
    
    protected void usoCanalPanama(boolean uso){
        this.canalPanama = uso;
    }
    
    protected boolean usoCanalPanama(){
        return this.canalPanama;
    }
    
    protected void setCOrg(String ciudadOrg){
        this.ciudadOrigen = ciudadOrg;
    }
    
    protected void setCDest(String ciudadDest){
        this.ciudadDestino = ciudadDest;
    }
    
    protected String nombreBarco (){
        return this.nombreBarco;
    }
}
