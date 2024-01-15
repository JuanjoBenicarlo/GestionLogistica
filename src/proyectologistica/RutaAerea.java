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
    protected boolean sistemaIzado;
    protected int numeroBultos;
    protected String operadora;
    
    protected RutaAerea(){
        super();
    }
    
    protected RutaAerea(String ciudadOrg, String ciudadDest, String paisOrg, String paisDest){
        super(ciudadOrg, ciudadDest, paisOrg, paisDest); 
    }
    
    protected RutaAerea(String ciudadOrg, String ciudadDest, String paisOrg, String paisDest, int op){
        super(ciudadOrg, ciudadDest, paisOrg, paisDest, op); 
    }
    
    protected RutaAerea(String ciudadOrg, String ciudadDest, String paisOrg, String paisDest, boolean shengen, boolean vertical, boolean izado){
        super(ciudadOrg, ciudadDest, paisOrg, paisDest); 
        this.espacioShengen = shengen;
        this.bultoVertical = vertical;
        this.sistemaIzado = izado;
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
    
    protected String insertar() {
        Conexion conexion = new Conexion();
        RutaAereaDAO rutaDAO = new RutaAereaDAO(this,this.espacioShengen, this.bultoVertical, this.sistemaIzado);
        return conexion.ejecutar(rutaDAO.insertar()); 
    }
    protected String insertar(int op) {
        Conexion conexion = new Conexion();
        RutaAereaDAO rutaDAO = new RutaAereaDAO(this,this.espacioShengen, this.bultoVertical, this.sistemaIzado);
        String prueba = rutaDAO.insertar(op);
        System.out.println(prueba);
        //return conexion.ejecutar(rutaDAO.insertar(op)); 
        return conexion.ejecutar(prueba); 
    }
    
}
