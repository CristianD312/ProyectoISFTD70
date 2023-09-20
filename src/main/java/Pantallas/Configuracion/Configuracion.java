/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pantallas.Configuracion;
import Logica.Conexion;
import Logica.parametrosDeConfiguracion;
import Objetos.Carrera;
import Objetos.Profesor;
import Objetos.Salon;
import Pantallas.ElementosPersonalizados.TablaCarreras;
import Pantallas.ElementosPersonalizados.TablaProfesores;
import Pantallas.ElementosPersonalizados.TablaSalones;
import com.formdev.flatlaf.*;
import com.formdev.flatlaf.intellijthemes.*;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author dario
 */

public class Configuracion extends javax.swing.JFrame {
    Conexion conexion;
    ArrayList<Profesor> profesores;
    ArrayList<Carrera> carreras;
    ArrayList<Salon> salones;
    /**
     * Creates new form NewJFrame
     */

    public Configuracion() {
        UIManager.put( "Button.arc", 20 );
        conexion = new Conexion();
        //le da la conexion a cada uno de los objetos para que puedan crear un arraylist de sí mismos reflejando la base de datos
        Carrera.setConexion(conexion.getConexion());
        Profesor.setConexion(conexion.getConexion());
        Salon.setConexion(conexion.getConexion());
        //Carga los datos en el array interno de la clase
        Carrera.cargarDatos();
        Profesor.cargarDatos();
        Salon.cargarDatos();
        //relaciona el array interno de la clase con los array de la pantalla configuracion (están sincronizados, cualquier cambien en unoo afecta el otro)
        profesores = Profesor.getProfesores();
        carreras = Carrera.getCarreras();
        salones = Salon.getSalones();
        //carga de componentes
        initComponents();
        parametrosDeConfiguracion.cargarParametros();
        if(parametrosDeConfiguracion.getTema().equals("Oscuro")){
            ponerTemaOscuro();
            botonTema.setText("Tema Claro");
        } else if (parametrosDeConfiguracion.getTema().equals("Claro")) {
            ponerTemaClaro();
            botonTema.setText("Tema Oscuro");
        }
    }
    private void ponerTemaOscuro(){
        try {
            UIManager.setLookAndFeel(new FlatMonokaiProIJTheme());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void ponerTemaClaro(){
        try {
            UIManager.setLookAndFeel(new FlatMaterialLighterIJTheme());
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        panelDePestañas = new javax.swing.JTabbedPane();
        tabSalones = new javax.swing.JLayeredPane();
        tablaSalonesScroll = new javax.swing.JScrollPane();
        tablaSalones = new javax.swing.JTable();
        modificarSalon = new javax.swing.JButton();
        agregarSalon = new javax.swing.JButton();
        tabProfesores = new javax.swing.JLayeredPane();
        tablaProfesoresScroll = new javax.swing.JScrollPane();
        tablaProfesores = new javax.swing.JTable();
        modificarProfesor = new javax.swing.JButton();
        agregarProfesor = new javax.swing.JButton();
        eliminarProfesor = new javax.swing.JButton();
        tabCarreras = new javax.swing.JLayeredPane();
        tablaCarrerasScroll = new javax.swing.JScrollPane();
        tablaCarreras = new javax.swing.JTable();
        modificarCarrera = new javax.swing.JButton();
        agregarCarrera = new javax.swing.JButton();
        eliminarCarrera = new javax.swing.JButton();
        tabConfiguracion = new javax.swing.JLayeredPane();
        botonTema = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bdURL = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        bdUser = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        bdPass = new javax.swing.JPasswordField();
        guardarBD = new javax.swing.JButton();
        hacerBackup = new javax.swing.JButton();
        restaurarDesdeBackup = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelDePestañas.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        tablaSalones.setAutoCreateRowSorter(true);
        tablaSalones.setModel(new TablaSalones(salones));
        tablaSalones.setShowVerticalLines(true);
        tablaSalonesScroll.setViewportView(tablaSalones);

        modificarSalon.setText("Modificar");
        modificarSalon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarSalonActionPerformed(evt);
            }
        });

        agregarSalon.setText("Agregar");
        agregarSalon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarSalonActionPerformed(evt);
            }
        });

        tabSalones.setLayer(tablaSalonesScroll, javax.swing.JLayeredPane.DEFAULT_LAYER);
        tabSalones.setLayer(modificarSalon, javax.swing.JLayeredPane.DEFAULT_LAYER);
        tabSalones.setLayer(agregarSalon, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout tabSalonesLayout = new javax.swing.GroupLayout(tabSalones);
        tabSalones.setLayout(tabSalonesLayout);
        tabSalonesLayout.setHorizontalGroup(
            tabSalonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tablaSalonesScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
            .addGroup(tabSalonesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(modificarSalon)
                .addGap(18, 18, 18)
                .addComponent(agregarSalon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        tabSalonesLayout.setVerticalGroup(
            tabSalonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabSalonesLayout.createSequentialGroup()
                .addComponent(tablaSalonesScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(tabSalonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modificarSalon)
                    .addComponent(agregarSalon))
                .addContainerGap())
        );

        panelDePestañas.addTab("Salones", tabSalones);

        tablaProfesores.setAutoCreateRowSorter(true);
        tablaProfesores.setModel(new TablaProfesores(profesores));
        tablaProfesores.setFillsViewportHeight(true);
        tablaProfesores.setShowVerticalLines(true);
        tablaProfesoresScroll.setViewportView(tablaProfesores);

        modificarProfesor.setText("Modificar");
        modificarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarProfesorActionPerformed(evt);
            }
        });

        agregarProfesor.setText("Agregar");
        agregarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarProfesorActionPerformed(evt);
            }
        });

        eliminarProfesor.setText("Eliminar");
        eliminarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarProfesorActionPerformed(evt);
            }
        });

        tabProfesores.setLayer(tablaProfesoresScroll, javax.swing.JLayeredPane.DEFAULT_LAYER);
        tabProfesores.setLayer(modificarProfesor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        tabProfesores.setLayer(agregarProfesor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        tabProfesores.setLayer(eliminarProfesor, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout tabProfesoresLayout = new javax.swing.GroupLayout(tabProfesores);
        tabProfesores.setLayout(tabProfesoresLayout);
        tabProfesoresLayout.setHorizontalGroup(
            tabProfesoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tablaProfesoresScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabProfesoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(modificarProfesor)
                .addGap(18, 18, 18)
                .addComponent(agregarProfesor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(eliminarProfesor)
                .addContainerGap())
        );
        tabProfesoresLayout.setVerticalGroup(
            tabProfesoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabProfesoresLayout.createSequentialGroup()
                .addComponent(tablaProfesoresScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(tabProfesoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(agregarProfesor)
                    .addComponent(eliminarProfesor)
                    .addComponent(modificarProfesor))
                .addGap(7, 7, 7))
        );

        panelDePestañas.addTab("Profesores", tabProfesores);

        tablaCarreras.setModel(new TablaCarreras(carreras)
        );
        tablaCarreras.setFillsViewportHeight(true);
        tablaCarreras.setShowVerticalLines(true);
        tablaCarrerasScroll.setViewportView(tablaCarreras);

        modificarCarrera.setText("Modificar");
        modificarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarCarreraActionPerformed(evt);
            }
        });

        agregarCarrera.setText("Agregar");
        agregarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarCarreraActionPerformed(evt);
            }
        });

        eliminarCarrera.setText("Eliminar");
        eliminarCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarCarreraActionPerformed(evt);
            }
        });

        tabCarreras.setLayer(tablaCarrerasScroll, javax.swing.JLayeredPane.DEFAULT_LAYER);
        tabCarreras.setLayer(modificarCarrera, javax.swing.JLayeredPane.DEFAULT_LAYER);
        tabCarreras.setLayer(agregarCarrera, javax.swing.JLayeredPane.DEFAULT_LAYER);
        tabCarreras.setLayer(eliminarCarrera, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout tabCarrerasLayout = new javax.swing.GroupLayout(tabCarreras);
        tabCarreras.setLayout(tabCarrerasLayout);
        tabCarrerasLayout.setHorizontalGroup(
            tabCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tablaCarrerasScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 763, Short.MAX_VALUE)
            .addGroup(tabCarrerasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(modificarCarrera)
                .addGap(18, 18, 18)
                .addComponent(agregarCarrera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(eliminarCarrera)
                .addContainerGap())
        );
        tabCarrerasLayout.setVerticalGroup(
            tabCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabCarrerasLayout.createSequentialGroup()
                .addComponent(tablaCarrerasScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabCarrerasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modificarCarrera)
                    .addComponent(agregarCarrera)
                    .addComponent(eliminarCarrera))
                .addContainerGap())
        );

        panelDePestañas.addTab("Carreras", tabCarreras);

        botonTema.setText("Tema  Oscuro");
        botonTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTemaActionPerformed(evt);
            }
        });

        jLabel1.setText("Opciones Graficas:");

        jLabel2.setText("Base de datos:");

        jLabel4.setText("URL");

        jLabel5.setText("Usuario");

        jLabel6.setText("Contraseña");

        guardarBD.setText("Guardar");
        guardarBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarBDActionPerformed(evt);
            }
        });

        hacerBackup.setText("Respaldar base de datos");
        hacerBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hacerBackupActionPerformed(evt);
            }
        });

        restaurarDesdeBackup.setText("Restaurar desde respaldo");
        restaurarDesdeBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restaurarDesdeBackupActionPerformed(evt);
            }
        });

        jLabel7.setText("Datos de conexión:");

        jLabel8.setText("Copia de respaldo");

        tabConfiguracion.setLayer(botonTema, javax.swing.JLayeredPane.DEFAULT_LAYER);
        tabConfiguracion.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        tabConfiguracion.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        tabConfiguracion.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        tabConfiguracion.setLayer(bdURL, javax.swing.JLayeredPane.DEFAULT_LAYER);
        tabConfiguracion.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);
        tabConfiguracion.setLayer(bdUser, javax.swing.JLayeredPane.DEFAULT_LAYER);
        tabConfiguracion.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        tabConfiguracion.setLayer(bdPass, javax.swing.JLayeredPane.DEFAULT_LAYER);
        tabConfiguracion.setLayer(guardarBD, javax.swing.JLayeredPane.DEFAULT_LAYER);
        tabConfiguracion.setLayer(hacerBackup, javax.swing.JLayeredPane.DEFAULT_LAYER);
        tabConfiguracion.setLayer(restaurarDesdeBackup, javax.swing.JLayeredPane.DEFAULT_LAYER);
        tabConfiguracion.setLayer(jLabel7, javax.swing.JLayeredPane.DEFAULT_LAYER);
        tabConfiguracion.setLayer(jLabel8, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout tabConfiguracionLayout = new javax.swing.GroupLayout(tabConfiguracion);
        tabConfiguracion.setLayout(tabConfiguracionLayout);
        tabConfiguracionLayout.setHorizontalGroup(
            tabConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabConfiguracionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabConfiguracionLayout.createSequentialGroup()
                        .addGroup(tabConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addComponent(bdURL)
                                .addComponent(bdUser)
                                .addComponent(bdPass, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(tabConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonTema, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(tabConfiguracionLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(guardarBD))
                    .addComponent(restaurarDesdeBackup)
                    .addComponent(jLabel8)
                    .addComponent(hacerBackup))
                .addContainerGap(379, Short.MAX_VALUE))
        );
        tabConfiguracionLayout.setVerticalGroup(
            tabConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabConfiguracionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(botonTema))
                .addGap(1, 1, 1)
                .addComponent(jLabel4)
                .addGap(23, 23, 23)
                .addComponent(bdURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(bdUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bdPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guardarBD)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(hacerBackup)
                .addGap(18, 18, 18)
                .addComponent(restaurarDesdeBackup)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        panelDePestañas.addTab("Configuración", tabConfiguracion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDePestañas)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelDePestañas)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void modificarSalonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarSalonActionPerformed
        //su hay algún elemento de la tabla seleccionado se ejecuta el if
        if(tablaSalones.getSelectedRow() != -1) {
            //crea una nueva instancia de formulario profesor y le pasa los datos del profesor a modificar
            Salon salon = null;
            for (Salon sal : salones) {
                if (sal.getId_salon() == (int) tablaSalones.getValueAt(tablaSalones.getSelectedRow(), 0)) {
                    salon = sal;
                    break;
                }
            }
            if (salon != null) {
                JFrame ventana = new FormularioSalon(conexion, salon);

                //centra la nueva pestaña y la posiciona por encima de todas
                ventana.setLocationRelativeTo(this);
                ventana.setAlwaysOnTop(true);

                //desactiva la pestaña de configuracion mientras
                this.setFocusable(false);
                this.setEnabled(false);
                //por temas de scope tengo que hacer esto, sino no puedo rreferenciar a la pestaña de configuracion dentro del windowadapter
                JFrame ventanaConfig = this;
                //esto hace que cuando se cierre la ventana formulario, la pantalla de configuracion recupere el foco
                ventana.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        ventanaConfig.setEnabled(true);
                        ventanaConfig.setFocusable(true);
                        tablaSalones.updateUI();
                    }
                });
                ventana.setVisible(true);
            }
            } else {
                //en caso de no tener ningun salon para modificar tira un mensaje de error
                JOptionPane.showMessageDialog(this, "Por favor seleccione el Salón que desea modificar", "Error", JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_modificarSalonActionPerformed

    private void agregarSalonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarSalonActionPerformed
        //crea una ventana de formulario salon vacia
        JFrame ventana = new FormularioSalon(conexion);
        //centra la nueva pestaña y la posiciona por encima de todas
        ventana.setLocationRelativeTo(this);
        ventana.setAlwaysOnTop(true);

        //desactiva la pestaña de configuracion mientras
        this.setFocusable(false);
        this.setEnabled(false);
        //por temas de scope tengo que hacer esto, sino no puedo rreferenciar a la pestaña de configuracion dentro del windowadapter
        JFrame ventanaConfig = this;
        //esto hace que cuando se cierre la ventana formulario, la pantalla de configuracion recupere el foco
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                ventanaConfig.setEnabled(true);
                ventanaConfig.setFocusable(true);
                tablaSalones.updateUI();
            }
        });
        ventana.setVisible(true);
    }//GEN-LAST:event_agregarSalonActionPerformed

    private void eliminarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarCarreraActionPerformed
        if(0 == JOptionPane.showConfirmDialog(this,"¿Desea proceder?","Confirmación",JOptionPane.YES_NO_OPTION)){
            for(Carrera carrera: carreras){
                if(carrera.getId_carrera() == (int)tablaCarreras.getValueAt(tablaCarreras.getSelectedRow(),0)){
                    carrera.borrarCarrera();
                    tablaCarreras.updateUI();
                    break;
                }
            }
        }
    }//GEN-LAST:event_eliminarCarreraActionPerformed

    private void agregarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarCarreraActionPerformed
        //crea una ventana de formulario salon vacia
        JFrame ventana = new FormularioCarrera(conexion);
        //centra la nueva pestaña y la posiciona por encima de todas
        ventana.setLocationRelativeTo(this);
        ventana.setAlwaysOnTop(true);

        //desactiva la pestaña de configuracion mientras
        this.setFocusable(false);
        this.setEnabled(false);
        //por temas de scope tengo que hacer esto, sino no puedo rreferenciar a la pestaña de configuracion dentro del windowadapter
        JFrame ventanaConfig = this;
        //esto hace que cuando se cierre la ventana formulario, la pantalla de configuracion recupere el foco
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                ventanaConfig.setEnabled(true);
                ventanaConfig.setFocusable(true);
                tablaCarreras.updateUI();
            }
        });
        ventana.setVisible(true);
    }//GEN-LAST:event_agregarCarreraActionPerformed

    private void modificarCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarCarreraActionPerformed
        //su hay algun elemento de la tabla seleccionado se ejecuta el if
        if(tablaCarreras.getSelectedRow() != -1) {
            //crea una nueva instancia de formulario profesor y le pasa los datos del profesor a modificar
            Carrera carrera = null;
            for (Carrera carr : carreras) {
                if (carr.getId_carrera() == (int) tablaCarreras.getValueAt(tablaCarreras.getSelectedRow(), 0)) {
                    carrera = carr;
                    break;
                }
            }
            if (carrera != null) {
                System.out.println(carrera.getId_carrera());
                System.out.println(carrera.getNombre());
                JFrame ventana = new FormularioCarrera(conexion, carrera);

                //centra la nueva pestaña y la posiciona por encima de todas
                ventana.setLocationRelativeTo(this);
                ventana.setAlwaysOnTop(true);

                //desactiva la pestaña de configuracion mientras
                this.setFocusable(false);
                this.setEnabled(false);
                //por temas de scope tengo que hacer esto, sino no puedo rreferenciar a la pestaña de configuracion dentro del windowadapter
                JFrame ventanaConfig = this;
                //esto hace que cuando se cierre la ventana formulario, la pantalla de configuracion recupere el foco
                ventana.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        ventanaConfig.setEnabled(true);
                        ventanaConfig.setFocusable(true);
                        tablaCarreras.updateUI();
                    }
                });
                ventana.setVisible(true);
            }
            } else {
                //en caso de no tener ninguna carrera para modificar tira un mensaje de error
                JOptionPane.showMessageDialog(this, "Por favor seleccione la carrera que desea modificar", "Error", JOptionPane.ERROR_MESSAGE);
            }

    }//GEN-LAST:event_modificarCarreraActionPerformed

    private void agregarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarProfesorActionPerformed
        //crea una nueva ventana formulario para cargar los datos del profesor
        JFrame ventana = new FormularioProfesor(conexion,carreras);
        //centra la nueva pestaña y la posiciona por encima de todas
        ventana.setLocationRelativeTo(this);
        ventana.setAlwaysOnTop(true);

        //desactiva la pestaña de configuracion mientras
        this.setFocusable(false);
        this.setEnabled(false);
        //por temas de scope tengo que hacer esto, sino no puedo rreferenciar a la pestaña de configuracion dentro del windowadapter
        JFrame ventanaConfig = this;
        //esto hace que cuando se cierre la ventana formulario, la pantalla de configuracion recupere el foco
        ventana.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                ventanaConfig.setEnabled(true);
                ventanaConfig.setFocusable(true);
                tabProfesores.updateUI();
            }
        });
        ventana.setVisible(true);
    }//GEN-LAST:event_agregarProfesorActionPerformed

    private void modificarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarProfesorActionPerformed
        //su hay algun elemento de la tabla seleccionado se ejecuta el if
        if(tablaProfesores.getSelectedRow() != -1) {
            //crea una nueva instancia de formulario profesor y le pasa los datos del profesor a modificar
            Profesor profe = null;
            for(Profesor profesor: profesores){
                if(profesor.getDni() == tablaProfesores.getValueAt(tablaProfesores.getSelectedRow(),0)){
                    profe = profesor;
                    break;
                }
            }
            if(profe != null) {
                JFrame ventana = new FormularioProfesor(conexion, profe, carreras);

                //centra la nueva pestaña y la posiciona por encima de todas
                ventana.setLocationRelativeTo(this);
                ventana.setAlwaysOnTop(true);

                //desactiva la pestaña de configuracion mientras
                this.setFocusable(false);
                this.setEnabled(false);
                //por temas de scope tengo que hacer esto, sino no puedo rreferenciar a la pestaña de configuracion dentro del windowadapter
                JFrame ventanaConfig = this;
                //esto hace que cuando se cierre la ventana formulario, la pantalla de configuracion recupere el foco
                ventana.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        ventanaConfig.setEnabled(true);
                        ventanaConfig.setFocusable(true);
                        tabProfesores.updateUI();
                    }
                });
                ventana.setVisible(true);
            }
        }else{
            //en caso de no tener nungun profesor para modificar tira un mensaje de error
            JOptionPane.showMessageDialog(this,"Por favor seleccione el profesor que desea modificar","Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_modificarProfesorActionPerformed

    private void eliminarProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarProfesorActionPerformed
        if(0 == JOptionPane.showConfirmDialog(this,"¿Desea proceder?","Confirmación",JOptionPane.YES_NO_OPTION)){
            for(Profesor profesor: profesores){
                if(profesor.getDni() == (int)tablaProfesores.getValueAt(tablaProfesores.getSelectedRow(),0)){
                    profesor.borrarProfesor();
                    tablaProfesores.updateUI();
                    break;
                }
            }
        }
    }//GEN-LAST:event_eliminarProfesorActionPerformed

    private void botonTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTemaActionPerformed
        if(botonTema.getText().equals("Tema Oscuro")){
            ponerTemaOscuro();
            parametrosDeConfiguracion.setTema("Oscuro");
            botonTema.setText("Tema Claro");
        }else {
            ponerTemaClaro();
            parametrosDeConfiguracion.setTema("Claro");
            botonTema.setText("Tema Oscuro");
        }
    }//GEN-LAST:event_botonTemaActionPerformed

    private void hacerBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hacerBackupActionPerformed
        JFileChooser chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int seleccion = chooser.showOpenDialog(null);
                if (seleccion == JFileChooser.APPROVE_OPTION) {
                    File carpetaSeleccionada = chooser.getSelectedFile();
                    conexion.hacerBackup(carpetaSeleccionada.getAbsolutePath());
                }
    }//GEN-LAST:event_hacerBackupActionPerformed

    private void guardarBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarBDActionPerformed
        if(!(bdURL.getText().equals("")||bdUser.getText().equals(""))){
            parametrosDeConfiguracion.setURL(bdURL.getText());
            parametrosDeConfiguracion.setUsuarioSQL(bdUser.getText());
            parametrosDeConfiguracion.setPassSQL(bdPass.getPassword().toString());
        }else{
            JOptionPane.showMessageDialog(this,"Por favor rellene todos los campos para actualizar la base de datos","error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_guardarBDActionPerformed

    private void restaurarDesdeBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restaurarDesdeBackupActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.addChoosableFileFilter(new FileFilter() {
            @Override
            public boolean accept(File file) {
                Pattern patron = Pattern.compile("\\w+\\.sql$");
                return patron.matcher(file.getName()).find();
            }

            @Override
            public String getDescription() {
                return "Archivos SQL (*.sql)";
            }
        });
        int seleccion = chooser.showOpenDialog(this);
        if (seleccion == JFileChooser.APPROVE_OPTION) {
            File carpetaSeleccionada = chooser.getSelectedFile();
            System.out.println(carpetaSeleccionada.getAbsolutePath());
            conexion.restaurarDesdeBackup(carpetaSeleccionada.getAbsolutePath());
        }
    }//GEN-LAST:event_restaurarDesdeBackupActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Carga de tema
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(() -> new Configuracion().setVisible(true));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarCarrera;
    private javax.swing.JButton agregarProfesor;
    private javax.swing.JButton agregarSalon;
    private javax.swing.JPasswordField bdPass;
    private javax.swing.JTextField bdURL;
    private javax.swing.JTextField bdUser;
    private javax.swing.JButton botonTema;
    private javax.swing.JButton eliminarCarrera;
    private javax.swing.JButton eliminarProfesor;
    private javax.swing.JButton guardarBD;
    private javax.swing.JButton hacerBackup;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton modificarCarrera;
    private javax.swing.JButton modificarProfesor;
    private javax.swing.JButton modificarSalon;
    private javax.swing.JTabbedPane panelDePestañas;
    private javax.swing.JButton restaurarDesdeBackup;
    private javax.swing.JLayeredPane tabCarreras;
    private javax.swing.JLayeredPane tabConfiguracion;
    private javax.swing.JLayeredPane tabProfesores;
    private javax.swing.JLayeredPane tabSalones;
    private javax.swing.JTable tablaCarreras;
    private javax.swing.JScrollPane tablaCarrerasScroll;
    private javax.swing.JTable tablaProfesores;
    private javax.swing.JScrollPane tablaProfesoresScroll;
    private javax.swing.JTable tablaSalones;
    private javax.swing.JScrollPane tablaSalonesScroll;
    // End of variables declaration//GEN-END:variables
}
