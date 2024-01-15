/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectologistica;

/**
 *
 * @author sorli
 */
public class RutaAereaDAO extends RutaDAO{
    private boolean espacioShengen, bultoVertical, sistemaIzado;
    
    public RutaAereaDAO(Ruta ruta, boolean shengen, boolean vertical, boolean izado){
        super (ruta);
        this.espacioShengen = shengen;
        this.bultoVertical = vertical;
        this.sistemaIzado = izado;
        
    }
    public RutaAereaDAO(Ruta ruta){
        super (ruta);
        
        
    }
    public String insertar(int op){
        
        return "insert into ruta (ciudadOrigen, ciudadDestino, paisOrigen, paisDestino, idOperacion, espacioShengen, bultoVertical, sistemaIzado) values ('"+this.ciudadOrigen+"','"+this.ciudadDestino+"','"+this.paisOrigen+"','"+this.paisDestino+"','"+op+"',"+convierteBooleano(this.espacioShengen)+","+convierteBooleano(this.bultoVertical)+","+convierteBooleano(this.sistemaIzado)+");";
	
    }
    public String insertar(){
        return "insert into ruta (ciudadOrigen, ciudadDestino, paisOrigen, paisDestino, openTop, canalPanama, canalSuez) values ('"+this.ciudadOrigen+"','"+this.ciudadDestino+"','"+this.paisOrigen+"','"+this.paisDestino+"',"+convierteBooleano(this.espacioShengen)+","+convierteBooleano(this.bultoVertical)+","+convierteBooleano(this.sistemaIzado)+");";
    }
    
    public int convierteBooleano (boolean parametro){
        return parametro ? 1:0;
    }
    
}