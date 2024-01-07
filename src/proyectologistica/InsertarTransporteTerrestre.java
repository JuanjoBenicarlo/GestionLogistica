/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectologistica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author sorli
 */
public class InsertarTransporteTerrestre extends InsertarTransporte{
    private JComboBox operaciones;
    private JTextField companiaFerroviaria;
    
    
    public InsertarTransporteTerrestre(ResultSet lista) {
        super(lista);
    
    }
     public void initGUI() {
         
         super.initGUI();
         companiaFerroviaria = new JTextField("Escriba Compania Ferroviaria");
         getContentPane().add(companiaFerroviaria);
         companiaFerroviaria.setBounds(10, 50, 200, 20);
         
                
   }
   private void seleccionOperacion (ActionEvent evt){
       System.out.println("Se me ha seleccionado "+ operaciones.getSelectedItem());
   }
}
