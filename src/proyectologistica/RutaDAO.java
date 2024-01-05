package proyectologistica;

public class RutaDAO {
	protected String ciudadOrigen;
    protected String ciudadDestino;
    protected String paisOrigen;
    protected String paisDestino;
    
    protected int idOp;
    
	public RutaDAO() {
		
	}
	public RutaDAO(Ruta ruta) {
	this.ciudadOrigen = ruta.ciudadOrigen;
	this.ciudadDestino = ruta.ciudadDestino;
	this.paisOrigen = ruta.paisOrigen;
	this.paisDestino = ruta.paisDestino;
		
	}
	public RutaDAO(int op) {
		this.idOp = op;
	}
	public RutaDAO(Ruta ruta, int op) {
	this.ciudadOrigen = ruta.ciudadOrigen;
	this.ciudadDestino = ruta.ciudadDestino;
	this.paisOrigen = ruta.paisOrigen;
	this.paisDestino = ruta.paisDestino;
	
	this.idOp = op;
		
	}
	public String insertar(){
		return "insert into ruta (ciudadOrigen, ciudadDestino, paisOrigen, paisDestino, idOp) values ('"+this.ciudadOrigen+"','"+this.ciudadDestino+"','"+this.paisOrigen+"','"+this.paisDestino+"','"+this.idOp+"')";
	}

}
