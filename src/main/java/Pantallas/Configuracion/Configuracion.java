/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pantallas.Configuracion;

import Logica.parametrosDeConfiguracion;
import java.awt.*;
import Objetos.Carrera;
import Objetos.Profesor;
import Objetos.Salon;


/**
 *
 * @author dario
 */

public class Configuracion extends javax.swing.JFrame {

    
    /**
     * Creates new form NewJFrame
     */

    public Configuracion() {
        Carrera.cargarDatos();
        Profesor.cargarDatos();
        Salon.cargarDatos();
        this.setTitle("Configuración");
        initComponents();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        //Este if verifica que interfaz es la preferida por el usuario leyendo el archivo de configuracion y la ejecuta

        if(parametrosDeConfiguracion.getInterfazConfiguracion().equals("config1")){
            setContentPane(new pantallaConfig1(this.getRootPane()));
        }else{
            setContentPane(new pantallaConfig2(this.getRootPane()));
            this.setPreferredSize(new Dimension(800,500));
        }
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables

    // End of variables declaration//GEN-END:variables
}
