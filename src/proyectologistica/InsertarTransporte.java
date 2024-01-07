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
/**
 *
 * @author sorli
 */
public class InsertarTransporte extends JFrame {
    private JComboBox operaciones;
    //private JList lista2;
    final ResultSet listaValores;
    
    public InsertarTransporte(ResultSet lista) {
        this.listaValores = lista;
        this.setVisible(true);
    
    }
    
    public void initGUI() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        setTitle("Lista Operaciones");
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
            operaciones.setBounds(10, 30, 380, 15);
        }
        setSize(440, 300);
   }
}
    

