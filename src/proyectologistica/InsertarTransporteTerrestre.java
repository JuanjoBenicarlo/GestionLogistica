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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author sorli
 */
public class InsertarTransporteTerrestre extends InsertarTransporte{
    private JTextField companiaFerroviaria;
    
    
    public InsertarTransporteTerrestre(ResultSet lista) {
        super(lista);
    
    }
    public void initGUI() {
         
        super.initGUI();
        companiaFerroviaria = new JTextField("Escriba Compania Ferroviaria");
        getContentPane().add(companiaFerroviaria);
        companiaFerroviaria.setBounds(10, 50, 200, 20);
        JButton boton = new JButton("Registrar");
        getContentPane().add(boton);
        boton.setBounds(10, 200, 200, 20);

        boton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                registrarActionPerformed(evt);
            }

        });
         
                
   }
   private void seleccionOperacion (ActionEvent evt){
       System.out.println("Se me ha seleccionado "+ super.operaciones.getSelectedItem());
   }
   private void registrarActionPerformed(ActionEvent evt) {
       int op;
       op = Integer.parseInt((String) super.operaciones.getSelectedItem());
       RutaTerrestre ruta = new RutaTerrestre(super.ciudadOrigen.getText(),super.ciudadDestino.getText(),super.paisOrigen.getText(),super.paisDestino.getText(),this.companiaFerroviaria.getText());
        
        if (super.operaciones.getSelectedIndex() < (super.operaciones.getItemCount()-1))
  
            ruta.insertar(op);
        else
            
            ruta.insertar();
        
        
    }
            
}

