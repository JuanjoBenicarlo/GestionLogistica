/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectologistica;


import java.sql.ResultSet;

/**
 * Clase abstracta que no implementa ningun metodo ya que, de ella
 * heredaran distintos tipos de usuario que implementaran de diferente
 * manera los metodos aqui listados aprovechando el polimorfismo 
 * 
 * @author sorli
 */
public abstract class Usuario {
    protected int id;
    protected String DNI;
    protected String password;
    protected String rol;
    
    //Constructor de la clase Usuario
    protected Usuario (int pkid, String dni, String pwd, String rol){
        this.id = pkid;
        this.DNI = dni;
        this.password = pwd;
        this.rol = rol;
    }
  //Constructor de la clase Usuario
    protected Usuario (String dni, String pwd, String rol){
        this.DNI = dni;
        this.password = pwd;
        this.rol = rol;
    }
    protected String insertar() {
        Conexion conexion = new Conexion();
        UsuarioDAO usuarioDAO = new UsuarioDAO(this.DNI, this.password, this.rol);
        return conexion.ejecutar(usuarioDAO.insertar()); 
    }
    
    protected ResultSet consultar(int pkidUsuario){
        Conexion conexion = new Conexion();
        UsuarioDAO usuarioDAO = new UsuarioDAO(this.id, this.DNI, 
        this.password, this.rol);
        return conexion.consultar(usuarioDAO.consultar(pkidUsuario));  
    }
    
    protected ResultSet consultarPorLogin(String login){
        Conexion conexion = new Conexion();
        UsuarioDAO usuarioDAO = new UsuarioDAO(this.id, this.DNI, 
        this.password, this.rol);
        return conexion.consultar(usuarioDAO.consultar(login));  
    }

    protected String eliminar() {
        Conexion conexion = new Conexion();
        UsuarioDAO usuarioDAO = new UsuarioDAO(this.DNI);
        return conexion.ejecutar(usuarioDAO.eliminar()); 
    }
    
    protected ResultSet retornaTodo(){
        Conexion conexion = new Conexion();
        UsuarioDAO usuarioDAO = new UsuarioDAO(this);
        return conexion.consultar(usuarioDAO.retornaTodo()); 
    }
    
    protected int getId (){
        return this.id;
    }
    
    protected String getDNI (){
        return this.DNI;
    }
    
    protected String getPwd (){
        return this.password;
    }
    
    protected String getRol(){
        return this.rol;
    }

    
    //Metodo abstracto en la clase abstracta Usuario me permitira, segun permisos consultar Operacion
    protected abstract void consultaOperacion(String idOperacion);
    
    //Sobrecargo este metodo en funcion de lo que le pase como parametro.
    //Para la query a la BDD podre pasarle el identificador de la Operacion, el objeto de 
    //la clase Operacion o alguna de sus subclases, el DNI Cliente, etc
    
    
    protected abstract void consultaOperacion(Operacion operacion);
    
    //Metodo abstracto en la clase abstracta Usuario me permitira, segun permisos, crear Operacion
    protected abstract void creaOperacion(Operacion operacion);
    
}
