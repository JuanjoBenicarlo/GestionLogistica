
package proyectologistica;

/**
 * Esta clase hereda de la clase abstracta Ruta
 * @author sorli
 */
public class RutaMaritima extends Ruta {

    
    private String nombreBarco;
    private boolean canalPanama;
    private boolean canalSuez;
    private int cantidadContenedores;
    private boolean openTop;
    
    protected RutaMaritima(){
        super();
    }
    
    protected RutaMaritima(String ciudadOrg, String ciudadDest, String paisOrg, String paisDest){
        super(ciudadOrg, ciudadDest, paisOrg, paisDest); 
        this.canalPanama = false;
        this.canalSuez = false;
        this.openTop = false;
    }
    
    protected RutaMaritima(String ciudadOrg, String ciudadDest, String paisOrg, String paisDest, boolean open, boolean suez, boolean panam){
        super(ciudadOrg, ciudadDest, paisOrg, paisDest); 
        this.canalPanama = panam;
        this.canalSuez = suez;
        this.openTop = open;
    }
    
    //Para favorecer encapsulamiento y modularidad
    //hago metodos que me permitan acceder a los 
    //atributos privados
    //La visibilidad de estos metodos sera a nivel de todo el paquete
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

    protected void setNBarco (String barco){
        this.nombreBarco = barco;
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
    
    protected void setCantidadContenedores (int contenedores){
        this.cantidadContenedores = contenedores;
    }
    
    protected int getCantidadContenedores (){
        return this.cantidadContenedores;
    }
    
    protected void setOpenTop(boolean OT){
        this.openTop = OT;
    }
    
    protected boolean getOpenTop(){
        return this.openTop;
    }
    
    protected String insertar() {
        Conexion conexion = new Conexion();
        RutaMaritimaDAO rutaDAO = new RutaMaritimaDAO(this,this.openTop, this.canalPanama, this.canalSuez);
        return conexion.ejecutar(rutaDAO.insertar()); 
    }
    protected String insertar(int op) {
        Conexion conexion = new Conexion();
        RutaMaritimaDAO rutaDAO = new RutaMaritimaDAO(this,this.openTop, this.canalPanama, this.canalSuez);
        String prueba = rutaDAO.insertar(op);
        System.out.println(prueba);
        //return conexion.ejecutar(rutaDAO.insertar(op)); 
        return conexion.ejecutar(prueba); 
    }
}
