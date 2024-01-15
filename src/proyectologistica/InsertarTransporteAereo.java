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
public class InsertarTransporteAereo extends InsertarTransporte{
    private JCheckBox espacioShengen, bultoVertical, sistemaIzado;
    
    
    public InsertarTransporteAereo(ResultSet lista) {
        super(lista);
    
    }
    public void initGUI() {
         
        super.initGUI();
        espacioShengen = new JCheckBox();
        bultoVertical = new JCheckBox();
        sistemaIzado = new JCheckBox();
        
        espacioShengen.setText("Espacio Shengen");
        bultoVertical.setText("Bulto vertical");
        sistemaIzado.setText("Sistema de izado");
        
        getContentPane().add(espacioShengen);
        getContentPane().add(bultoVertical);
        getContentPane().add(sistemaIzado);
        
        espacioShengen.setBounds(10, 52, 100, 20);
        bultoVertical.setBounds(150, 52, 100, 20);
        sistemaIzado.setBounds(250, 52, 100, 20);
        
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
        RutaAerea ruta = new RutaAerea(super.ciudadOrigen.getText(),super.ciudadDestino.getText(),super.paisOrigen.getText(),super.paisDestino.getText(),espacioShengen.isSelected(), bultoVertical.isSelected(), sistemaIzado.isSelected());
        Operacion operacion = new Operacion();
                
        if (super.operaciones.getSelectedIndex() < (super.operaciones.getItemCount()-1)){
            op = Integer.parseInt((String) super.operaciones.getSelectedItem());
            ruta.insertar(op);
        }
        else{
            operacion.insertar();
            ruta.insertar(operacion.ultimaInsercion());
        }
        
    }
            
}

