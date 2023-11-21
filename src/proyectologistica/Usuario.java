/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectologistica;

/**
 * Clase abstracta que no implementa ningun metodo ya que, de ella
 * heredaran distintos tipos de usuario que implementaran de diferente
 * manera los metodos aqui listados aprovechando el polimorfismo 
 * 
 * @author sorli
 */
public abstract class Usuario {
    protected String DNI;
    protected String password;
    protected String tfno;
    
    //Constructor de la clase Usuario
    protected Usuario (String dni, String pwd, String tfn){
        this.DNI = dni;
        this.password = pwd;
        this.tfno = tfn;
    }
    
    //Para favorecer encapsulado habilito metodos para acceder a atributos privados y setearlos
    protected abstract String getTfno ();
    
    //Sobrecargo el metodo con diferentes implementaciones en funcion del parametro que le pase
    protected abstract String getTfno (String dni);
    
    protected abstract void setTfno (String tfn);
    
    //Metodo abstracto en la clase abstracta Usuario me permitira, segun permisos consultar Operacion
    protected abstract void consultaOperacion(String idOperacion);
    
    //Sobrecargo este metodo en funcion de lo que le pase como parametro.
    //Para la query a la BDD podre pasarle el identificador de la Operacion, el objeto de 
    //la clase Operacion o alguna de sus subclases, el DNI Cliente, etc
    
    
    protected abstract void consultaOperacion(Operacion operacion);
    
    //Metodo abstracto en la clase abstracta Usuario me permitira, segun permisos, crear Operacion
    protected abstract void creaOperacion(Operacion operacion);
    
}
