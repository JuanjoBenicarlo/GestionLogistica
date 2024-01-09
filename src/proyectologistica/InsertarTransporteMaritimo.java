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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.WindowConstants;

/**
 *
 * @author sorli
 */
public class InsertarTransporteMaritimo extends InsertarTransporte{
    private JCheckBox openTop, canalSuez, canalPanama;
    
    
    public InsertarTransporteMaritimo(ResultSet lista) {
        super(lista);
    
    }
    public void initGUI() {
         
        super.initGUI();
        openTop = new JCheckBox();
        canalSuez = new JCheckBox();
        canalPanama = new JCheckBox();
        
        openTop.setText("Open Top");
        canalSuez.setText("Canal Suez");
        canalPanama.setText("Canal Panama");
        
        getContentPane().add(openTop);
        getContentPane().add(canalSuez);
        getContentPane().add(canalPanama);
        
        openTop.setBounds(10, 50, 100, 20);
        canalSuez.setBounds(150, 50, 100, 20);
        canalPanama.setBounds(250, 50, 100, 20);
        
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
       RutaMaritima ruta = new RutaMaritima(super.ciudadOrigen.getText(),super.ciudadDestino.getText(),super.paisOrigen.getText(),super.paisDestino.getText(),openTop.isSelected(), canalSuez.isSelected(), canalPanama.isSelected());
        
        if (super.operaciones.getSelectedIndex() < (super.operaciones.getItemCount()-1))
  
            ruta.insertar(op);
        else
            
            ruta.insertar();
        
        
    }
            
}

