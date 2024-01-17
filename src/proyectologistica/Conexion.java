/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectologistica;

/**
 *
 * @author sorli
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    private Statement statement;
    private Connection connection;
    private String jdbc;
    private String ruta;
    private String usuario;
    private String contra;
    
    //Constructor de la clase Conexion
    //Contiene todos los datos concretos para conectarme a la BDD MySQL
    public Conexion(){
        this.connection = null;
        this.statement = null;
        this.jdbc = "com.mysql.jdbc.Driver";
        //this.ruta = "jdbc:mysql://localhost:3306/proyectologistica";
        this.ruta = "jdbc:mysql://103.241.67.238:3306/proyectologistica";
        this.usuario ="juanjo";
        this.contra ="juanjo"; 
    }
    
    //Intenta establecer conexion contra la BDD
    protected void abrirConexion(){
        try {
            Class.forName(this.jdbc);
            this.connection = DriverManager.getConnection(
        this.ruta,this.usuario, this.contra);
            this.statement = this.connection.createStatement();
        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    //Intenta abrir conexion contra la BDD y ejecuta a continuacion
    //una operacion SQL que esta contenida en un String que le paso como parametro
    //Ese String vendra de las clases DAO
    //El String que me retorna sirve solo para saber si la operacion ha sido exitosa
    public String ejecutar(String sentencia){
        try {
            this.abrirConexion();
            this.statement.executeUpdate(sentencia);
            return "Operacion exitosa";
        }catch(SQLException e){
        return e.toString();}
    }
 
    //Consulta a la base de datos con la query que le paso como parametro
    //proveniente de las clases DAO
    //Me retornara un ResultSet ya que utilizo esta fncion para las operaciones SQL
    //de consulta, (del tipo SELECT FROM...)
    
    public ResultSet consultar(String sentencia){
        ResultSet resultado=null;
        try {
            this.abrirConexion();
            resultado = statement.executeQuery(sentencia);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return resultado; 
    }
    

}
