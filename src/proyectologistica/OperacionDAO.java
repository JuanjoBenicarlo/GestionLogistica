/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectologistica;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sorli
 */
public class OperacionDAO {
    protected List <Ruta> listaRuta = new ArrayList <>();
    
    protected int idOperacion;
    protected float coste;
    
    public OperacionDAO(){
        
    }
    
    public OperacionDAO(int id, float inv){
        this.idOperacion = id;
        this.coste = inv;
    }
    
   
    public String consultar(){
        return "select * from operacion where idOperacion='"+this.idOperacion+"'";
    }
    public String consultarRutaForeignKeyOp(int idOp){
        return "select * from ruta where idOperacion='"+idOp+"'";
    }
    
    public String retornaTodo(){
        return "select * from operacion";
        
    }
    
    public String insertar(){
        return "insert into operacion (coste) values (0)";
    }
    
 
}
