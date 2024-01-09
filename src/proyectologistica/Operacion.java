/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectologistica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Operacion es la base de todo. Algunas clases como Facturacion heredaran 
 * de ella y añadiran atributos y metodos de la transaccion economica vinculada
 * al trafico de mercancias de cada Operacion
 * No la voy a hacer abstracta ni interfaz ya que creo que tiene mas sentido
 * con implementacion en sí misma
 * @author sorli
 */
public class Operacion {
    
    //Una operacion puede tener muchas rutas asociadas
    //Ruta es una clase abstracta de la que heredan las rutas segun
    //sean terrestres, aereas o maritimas
    protected List <Ruta> listaRuta = new ArrayList <>();
    

    protected int idOperacion;
    protected float coste;
    
    //Constructor
    public Operacion(){
        
    }
    
    protected void anadeRuta(Ruta ruta){
        listaRuta.add(ruta);
    }
    
    protected String insertar() {
        Conexion conexion = new Conexion();
        OperacionDAO operacionDAO = new OperacionDAO(this.idOperacion, this.coste);
        return conexion.ejecutar(operacionDAO.insertar()); 
    }

    
    protected ResultSet consultarRutaPorOperacion(int pkidOp){
        Conexion conexion = new Conexion();
        OperacionDAO operacionDAO = new OperacionDAO();
        return conexion.consultar(operacionDAO.consultarRutaForeignKeyOp(pkidOp));  
    }
    
    protected ResultSet consultarTodo(){
        Conexion conexion = new Conexion();
        OperacionDAO operacionDAO = new OperacionDAO();
        return conexion.consultar(operacionDAO.retornaTodo());
    }
    
    protected int ultimaInsercion(){
        ResultSet resultado;
        int temporal = 0;
        Conexion conexion = new Conexion();
        OperacionDAO operacionDAO = new OperacionDAO();
        resultado = conexion.consultar(operacionDAO.retornaTodo());
        try {
            while (resultado.next()) {
                if (resultado.getInt("idOperacion")> temporal){
                    temporal = resultado.getInt("idOperacion");
                }
                
                
                
            }   } catch (SQLException ex) {
            Logger.getLogger(Operacion.class.getName()).log(Level.SEVERE, null, ex);
         
            }
        return temporal;
    }
       
}
