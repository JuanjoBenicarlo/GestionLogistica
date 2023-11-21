/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectologistica;

/**
 * Administrador hereda de Usuario. Como Usuario es una clase abstracta debo implementar aquí
 * todos sus metodos
 * Administrador ser un Usuario que tendrá ciertos permisos
 * @author sorli
 */
public class Administrador extends Usuario {

    
    //Constructor de la Clase Administrador
    public Administrador(String dni, String pwd, String tfn){
        super(dni, pwd, tfn);
    }
    
    @Override
    protected String getTfno() {
        return this.tfno;
    }

    @Override
    protected String getTfno(String dni) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void setTfno(String tfn) {
        this.tfno = tfn;
    }

    @Override
    protected void consultaOperacion(String idOperacion) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void consultaOperacion(Operacion operacion) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    protected void creaOperacion(Operacion operacion) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
