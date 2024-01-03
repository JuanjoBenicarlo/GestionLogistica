/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectologistica;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;


/**
 *
 * @author sorli
 */
public class Main extends JFrame {

    //Declaro objetos para tener 2 pestañas con dos tab y otra para la gestion de usuarios.
    private JPanel panel1;
    private JPanel panel2;

    private JPanel panel3;
    private JTabbedPane panelPestanas;
    

    //Para introducir la operacion concreta que quiero conultar
    private JTextField idOperacionConsultar;

    //Para introducir login y password para autenticarme
    private JTextField textoLogin;
    private JTextField textoPassword;
    
    private JTextField insertarLogin = null;
    private JTextField insertarPassword = null;

    //Variable global a los metodos de la clase para que todos sepan el rol y sus privilegios
    //0 no logado, (valos por defecto)
    //1 consultor
    //2 admin
    private int rolPrivilegios = 0;
    
    //Actualizable mediante los radiobutton
    private int usuarioAAnadir = 0;

    Conexion conexion_prueba;
    
    //Me creo objetos para acceder a la BDD
    Usuario usuario = new Administrador(77, "772", "hh", "676");
    UsuarioDAO accesoUsuarioBDD = new UsuarioDAO(usuario);
    
    Operacion operacion = new Operacion();
    OperacionDAO accesoOperacionBDD = new OperacionDAO();

    public static void main(String[] args) {
        Main marcoAplicacion = new Main();
        marcoAplicacion.setVisible(true);
        System.out.println("Inicializando aplicación Proyecto Logistica");

        //conexion_prueba.abrirConexion();
        //Usuario usuario = new Administrador (77,"772","hh","676");
        //Usuario usuario = new Administrador (17,"89786756","h1h","Administrador");
        //UsuarioDAO accesoUsuarioBDD = new UsuarioDAO (usuario);
        //System.out.println(conexion_prueba.ejecutar(accesoUsuarioBDD.insertar()));
        //System.out.println(conexion_prueba.ejecutar("insert into usuario (idusuario,login,password,rol)values ('53223681','saris','villarreal','admin')"));
    }

    public Main() {
        conexion_prueba = new Conexion();
        conexion_prueba.abrirConexion();
        inicializaInterfaces();
    }

    private void inicializaInterfaces() {

        Usuario usuario = new Administrador(69, "sarafo", "h2h", "Administradora");
        UsuarioDAO accesoUsuarioBDD = new UsuarioDAO(usuario);
        //System.out.println(conexion_prueba.ejecutar(accesoUsuarioBDD.insertar()));
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        setTitle("Mi Aplicación para Proyecto Logística");
        {
            panelPestanas = new JTabbedPane();
            getContentPane().add(panelPestanas);
            {
                panel1 = new JPanel();
                panelPestanas.addTab("Consultar tráfico", panel1);

                idOperacionConsultar = new JTextField("Identificador de Operación");

                JButton boton1 = new JButton("Consultar Operacion");
                JButton boton2 = new JButton("Lista Operaciones");

                boton1.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        botonConsultarOperacionActionPerformed(evt);
                    }

                });

                boton2.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        botonConsultarTodoActionPerformed(evt);
                    }

                });

                panel1.add(boton1);
                panel1.add(idOperacionConsultar);
                panel1.add(boton2);

                //getContentPane().add(BorderLayout.CENTER, panel1);
                setVisible(true);

            }
            {
                panel2 = new JPanel();
                //panelPestanas.addTab("Pestaña 2", new ImageIcon(“img/informacion.png”), panel2); 
                panelPestanas.addTab("Insertar tráfico", panel2);

                JButton boton3 = new JButton("Introducir nuevo transporte");

                boton3.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        botonIntroducirTransporteActionPerformed(evt);
                    }

                });

                JRadioButton radioBoton1 = new JRadioButton("Transporte Terrestre");
                JRadioButton radioBoton2 = new JRadioButton("Transporte Aéreo");
                JRadioButton radioBoton3 = new JRadioButton("Transporte Marítimo");

                //Los vinculo a un ButtonGroup para que sólo pueda haber uno seleccionado
                ButtonGroup grupoRadioBoton = new ButtonGroup();
                grupoRadioBoton.add(radioBoton1);
                grupoRadioBoton.add(radioBoton2);
                grupoRadioBoton.add(radioBoton3);

                panel2.add(radioBoton1);
                panel2.add(radioBoton2);
                panel2.add(radioBoton3);

                panel2.add(boton3);

                setVisible(true);
            }
            {
                panel3 = new JPanel();

                panelPestanas.addTab("Gestión de Usuarios", panel3);
                //FlowLayout personalizacionLayoutTab3 = new FlowLayout();
                //getContentPane().setLayout(personalizacionLayoutTab3);


                JButton boton4 = new JButton("añadir nuevo usuario");

                boton4.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        botonAnadirUsuarioActionPerformed(evt);
                    }

                });

                textoLogin = new JTextField("Usuario");
                textoPassword = new JTextField("Password");
                JButton boton5 = new JButton("Login");

                boton5.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        botonAutenticarseAsignarRol(evt);
                    }

                });

                JRadioButton radioBoton4 = new JRadioButton("Administrador");
                JRadioButton radioBoton5 = new JRadioButton("Consultor");
                
                radioBoton4.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        botonAnadirAdmin(evt);
                    }
                });
                radioBoton5.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        botonAnadirUsuario(evt);
                    }
                });

                //Los vinculo a un ButtonGroup para que sólo pueda haber uno seleccionado
                ButtonGroup grupoRadioBoton = new ButtonGroup();
                grupoRadioBoton.add(radioBoton4);
                grupoRadioBoton.add(radioBoton5);
                
                insertarLogin = new JTextField("Usuario");
                insertarPassword = new JTextField("Password");

                panel3.add(textoLogin,  BorderLayout.WEST);
                panel3.add(textoPassword,  BorderLayout.EAST);
                panel3.add(boton5,  BorderLayout.NORTH);

                panel3.add(radioBoton4,  BorderLayout.SOUTH);
                panel3.add(radioBoton5,  BorderLayout.SOUTH);

                panel3.add(insertarLogin,  BorderLayout.WEST);
                panel3.add(insertarPassword,  BorderLayout.EAST);
                panel3.add(boton4,  BorderLayout.SOUTH);

                setVisible(true);
            }
        }
        setSize(800, 600);
    }

    private void botonConsultarOperacionActionPerformed(ActionEvent evt) {
        
        FileWriter escritorFactura = null; 
        

        System.out.println("Me han presionado el botón para buscar una idOperacion concreta");
        
        
        ResultSet queryLista;
        String texto = idOperacionConsultar.getText();
        int idOp = Integer.parseInt(texto);
        int contador = 0;
        queryLista = operacion.consultarRutaPorOperacion(idOp);
        
        try {
            escritorFactura = new FileWriter("Factura_Rutas_generada.txt");
            escritorFactura.write("Ciudad Origen ");
            escritorFactura.write("Pais Origen ");
            escritorFactura.write("Ciudad Destino ");
            escritorFactura.write("Pais Destino\n");
            while (queryLista.next()) {
                
                //System.out.println(datosLeidos[contador][0]);
                //System.out.println(queryLista.getString("paisOrigen"));
                //System.out.println(queryLista.getString("ciudadDestino"));
                //System.out.println(queryLista.getString("paisDestino"));
                escritorFactura.write(queryLista.getString("ciudadOrigen")+" ");
                escritorFactura.write(queryLista.getString("paisOrigen")+ " ");
                escritorFactura.write(queryLista.getString("ciudadDestino")+" ");
                escritorFactura.write(queryLista.getString("paisDestino")+"\n");
                contador++;
            }
            escritorFactura.close();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
        
    }

    private void botonConsultarTodoActionPerformed(ActionEvent evt) {
        //Código para el evento
        System.out.println("Me han presionado el botón para hacer una query de todo lo que tenga");
        ResultSet queryLista;
        //queryLista = usuario.consultar(42);
        queryLista = operacion.consultarTodo();

        try {

            while (queryLista.next()) {

                System.out.println(queryLista.getString("idOperacion"));
                System.out.println(queryLista.getString("coste"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void botonIntroducirTransporteActionPerformed(ActionEvent evt) {
        //Código para el evento
        System.out.println("Me han presionado el botón para buscar una idOperacion concreta");
        System.out.println(conexion_prueba.ejecutar("insert into usuario (idusuario,login,password,rol)values ('53223','chipie','chipiron','admin')"));
    }
    private void botonAnadirUsuario(ActionEvent evt) {
        //Código para el evento
        System.out.println("Me han presionado el botón para buscar una idOperacion concreta");
        usuarioAAnadir = 1;
    }
    private void botonAnadirAdmin(ActionEvent evt) {
        //Código para el evento
        System.out.println("Me han presionado el botón para buscar una idOperacion concreta");
        usuarioAAnadir = 2;
    }
    private void botonAnadirUsuarioActionPerformed(ActionEvent evt) {
        
        System.out.println("Me han presionado el botón para buscar una idOperacion concreta");
        if (usuarioAAnadir == 2){
            if (rolPrivilegios == 2){
            System.out.println(conexion_prueba.ejecutar("insert into usuario (login,password,rol)values ('"+insertarLogin.getText()+" ','"+insertarPassword.getText()+"','admin')"));
            }
            else{
                //Sacar un warning
                JOptionPane.showMessageDialog(this, "Debes ser administrador para crear otro administrador","Privilegios insuficientes",JOptionPane.WARNING_MESSAGE);
                System.out.println("lo siento. No tienes privilegios para crear Administrador");
            }
        }
        else if (usuarioAAnadir == 1)
            System.out.println(conexion_prueba.ejecutar("insert into usuario (login,password,rol)values ('"+insertarLogin.getText()+" ','"+insertarPassword.getText()+"','user')"));
    }

    private void botonAutenticarseAsignarRol(ActionEvent evt) {
        String passwordLeido = "password";
        String passwordBDD = "a";
        String rolBDD = "a";

        //Valido login y password contra la tabla usuario
        //marco un flag en funcion del rol
        System.out.println("Me han presionado el botón para autenticar login y password");
        ResultSet queryLista;
        //queryLista = usuario.consultar(42);
        queryLista = usuario.consultarPorLogin(textoLogin.getText());
        passwordLeido = textoPassword.getText();

        try {

            while (queryLista.next()) {
                passwordBDD = queryLista.getString("password");
                rolBDD = queryLista.getString("rol");
                System.out.println(queryLista.getString("rol"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            rolPrivilegios = 0;
        }
        if (passwordBDD.equals(passwordLeido)) {
            if (rolBDD.equals("admin")) {
                rolPrivilegios = 2;
            } else {
                rolPrivilegios = 1;
            }
        } else {
            rolPrivilegios = 0;
        }
        System.out.println("el rol es " + rolPrivilegios);

    }
}
