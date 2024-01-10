/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectologistica;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;
/**
 *
 * @author sorli
 */
public class InsertarTransporte extends JFrame {
    protected JComboBox operaciones;
    protected JTextField ciudadOrigen, ciudadDestino, paisOrigen, paisDestino;
    //private JList lista2;
    final ResultSet listaValores;
    
    public InsertarTransporte(ResultSet lista) {
        this.listaValores = lista;
        this.setVisible(true);
    
    }
    
    public void initGUI() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        setTitle("Insertar Transporte");
        getContentPane().setLayout(null);
        {
            operaciones = new JComboBox();
            DefaultComboBoxModel modeloLista = new DefaultComboBoxModel();
            try {

                while (this.listaValores.next()) {
                    modeloLista.addElement(this.listaValores.getString("idOperacion"));

                }

            } catch (SQLException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            modeloLista.addElement("Anadir la ruta sobre nueva operacion aun no existente");
            operaciones.setModel(modeloLista);
            getContentPane().add(operaciones);
            operaciones.setBounds(10, 30, 380, 20);
            ciudadOrigen = new JTextField("Escriba Ciudad Origen");
            getContentPane().add(ciudadOrigen);
            ciudadOrigen.setBounds(10, 80, 200, 20);
            ciudadDestino = new JTextField("Escriba Ciudad Destino");
            getContentPane().add(ciudadDestino);
            ciudadDestino.setBounds(10, 110, 200, 20);
            paisOrigen = new JTextField("Escriba Pais Origen");
            getContentPane().add(paisOrigen);
            paisOrigen.setBounds(10, 140, 200, 20);
            paisDestino = new JTextField("Escriba Pais Destino");
            getContentPane().add(paisDestino);
            paisDestino.setBounds(10, 170, 200, 20);
        }
        setSize(440, 300);
   }
}
    

