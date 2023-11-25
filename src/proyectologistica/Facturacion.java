/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectologistica;

/**
 * Facturacion anade detalles de Facturacion asociados a la operacion
 * @author sorli
 */
public class Facturacion extends Operacion {
    private String divisa;
    private boolean exWorks;
    
    //En el constructor de Facturacion llamo al constructor
    //de su Superclase
    public Facturacion (){
        super();
    }
    
    //Para favorecer encapsulamiento y modularidad
    //hago metodos que me permitan acceder a los 
    //atributos privados
    //La visibilidad de estos metodos sera a nivel de todo el paquete
    
    protected void setexWorks (boolean parametro){
        this.exWorks = parametro;
    }
    protected boolean getexWorks(){
        return this.exWorks;
    }
    protected void setDivisa (String parametro){
        this.divisa = parametro;
    }
    protected String getDivisa(){
        return this.divisa;
    }
}
