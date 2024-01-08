/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectologistica;

/**
 *
 * @author sorli
 */
public class RutaTerrestre extends Ruta {
    private String companiaFerroviaria = "";
    
    protected RutaTerrestre(){
        super();
    }
    
    protected RutaTerrestre(String ciudadOrg, String ciudadDest, String paisOrg, String paisDest){
        super(ciudadOrg, ciudadDest, paisOrg, paisDest); 
       
    }
    
    protected RutaTerrestre(String ciudadOrg, String ciudadDest, String paisOrg, String paisDest, String tren){
        super(ciudadOrg, ciudadDest, paisOrg, paisDest); 
        this.companiaFerroviaria = tren;
       
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
    
    protected void setTren (String tren){
        this.companiaFerroviaria = tren;
    }
    protected String insertar() {
        Conexion conexion = new Conexion();
        RutaTerrestreDAO rutaDAO = new RutaTerrestreDAO(this,this.companiaFerroviaria);
        return conexion.ejecutar(rutaDAO.insertar()); 
    }
    protected String insertar(int op) {
        Conexion conexion = new Conexion();
        RutaTerrestreDAO rutaDAO = new RutaTerrestreDAO(this,this.companiaFerroviaria);
        return conexion.ejecutar(rutaDAO.insertar(op)); 
    }
    
}
