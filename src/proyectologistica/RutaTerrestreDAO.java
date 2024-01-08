/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectologistica;

/**
 *
 * @author sorli
 */
public class RutaTerrestreDAO extends RutaDAO{
    private String companiaFerroviaria;
    
    public RutaTerrestreDAO(Ruta ruta, String tren){
        super (ruta);
        this.companiaFerroviaria = tren;
        
    }
    public RutaTerrestreDAO(Ruta ruta){
        super (ruta);
        
        
    }
    public String insertar(int op){
        
        return "insert into ruta (ciudadOrigen, ciudadDestino, paisOrigen, paisDestino, idOperacion, companiaFerroviaria) values ('"+this.ciudadOrigen+"','"+this.ciudadDestino+"','"+this.paisOrigen+"','"+this.paisDestino+"','"+op+"','"+this.companiaFerroviaria+"')";
	
    }
    public String insertar(){
        return "insert into ruta (ciudadOrigen, ciudadDestino, paisOrigen, paisDestino, companiaFerroviaria) values ('"+this.ciudadOrigen+"','"+this.ciudadDestino+"','"+this.paisOrigen+"','"+this.paisDestino+"','"+this.companiaFerroviaria+"')";
    }
    
}
