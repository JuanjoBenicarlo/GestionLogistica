/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectologistica;


/**
 *
 * @author sorli
 */
public class UsuarioDAO {
    protected int id;
    protected String DNI;
    protected String password;
    protected String rol;
    
    public UsuarioDAO (Usuario usuario){
        this.DNI = usuario.getDNI();
        this.password = usuario.getPwd();
        this.rol = usuario.getRol();
        this.id = usuario.getId();
    }
    
    public UsuarioDAO (int id, String dni, String pwd, String rol){
        this.DNI = dni;
        this.password = pwd;
        this.rol = rol;
        this.id = id;
    }
    public UsuarioDAO (String dni){
        this.DNI = dni;
    }
    public String insertar(){
        return "insert into usuario (login, password,rol)values ('"+this.DNI+"','"+this.password+"','"+this.rol+"')";
    }
    public String consultar(){
        return "select * from usuario where idusuario='"+this.id+"'";
    }
    public String consultar(int pkUsuario){
        return "select * from usuario where idusuario='"+pkUsuario+"'";
    }
    
    //Sobrecargo este metodo y cuando le paso String consulto por login
    public String consultar(String login){
        return "select * from usuario where login='"+login+"'";
    }
   
    public String buscar(String palabra){

        return "select * from usuario where idusuario like '"+palabra +"%";
    }
    public String eliminar(){
        return "delete from producto where idusuario='"+this.DNI+"'";
    }
    
    public String retornaTodo(){
        return "select * from usuario";
        
    }
}

