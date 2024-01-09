package proyectologistica;



public class RutaMaritimaDAO extends RutaDAO{
    private boolean openTop, canalSuez, canalPanama;
    
    public RutaMaritimaDAO(Ruta ruta, boolean open, boolean suez, boolean panam){
        super (ruta);
        this.openTop = open;
        this.canalSuez = suez;
        this.canalPanama = panam;
        
    }
    public RutaMaritimaDAO(Ruta ruta){
        super (ruta);
        
        
    }
    public String insertar(int op){
        
        return "insert into ruta (ciudadOrigen, ciudadDestino, paisOrigen, paisDestino, idOperacion, openTop, canalPanama, canalSuez) values ('"+this.ciudadOrigen+"','"+this.ciudadDestino+"','"+this.paisOrigen+"','"+this.paisDestino+"','"+op+"',"+convierteBooleano(this.openTop)+","+convierteBooleano(this.canalSuez)+","+convierteBooleano(this.canalPanama)+");";
	
    }
    public String insertar(){
        return "insert into ruta (ciudadOrigen, ciudadDestino, paisOrigen, paisDestino, openTop, canalPanama, canalSuez) values ('"+this.ciudadOrigen+"','"+this.ciudadDestino+"','"+this.paisOrigen+"','"+this.paisDestino+"',"+convierteBooleano(this.openTop)+","+convierteBooleano(this.canalSuez)+","+convierteBooleano(this.canalPanama)+");";
    }
    
    public int convierteBooleano (boolean parametro){
        return parametro ? 1:0;
    }
    
}