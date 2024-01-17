package proyectologistica;

public class Consultor extends Usuario {

    
    //Constructor de la Clase Administrador
    public Consultor(int pk, String dni, String pwd, String tfn){
        super(pk, dni, pwd, tfn);
    }
    
    //Sobreescribo el constructor en función de los parametros que le pase
    public Consultor(String dni, String pwd){
        super(dni, pwd, "user");
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