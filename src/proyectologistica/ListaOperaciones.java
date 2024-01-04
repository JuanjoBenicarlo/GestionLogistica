/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectologistica;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.WindowConstants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author sorli
 */
public class ListaOperaciones extends JFrame {

 private JList lista2;

 
 final ResultSet listaValores;

 public ListaOperaciones(ResultSet lista) {
    this.listaValores = lista;
    this.setVisible(true);
    
 }
 public void initGUI() {
    setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    setTitle("Lista Operaciones");
    getContentPane().setLayout(null);
    
    {
        lista2 = new JList();
        DefaultListModel modeloLista = new DefaultListModel();
        try {

            while (this.listaValores.next()) {
                modeloLista.addElement("Operacion numero "+this.listaValores.getString("idOperacion")+" con coste asociado "+this.listaValores.getString("coste"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        lista2.setModel(modeloLista);
        getContentPane().add(lista2);
        lista2.setBounds(10, 30, 380, 150);
    }
    
    setSize(440, 300);
   }
}
