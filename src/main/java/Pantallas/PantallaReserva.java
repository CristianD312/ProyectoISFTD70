/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pantallas;

import Logica.ComboBoxItemProfes;
import Logica.ComboBoxItemCarreras;
import Logica.ComboBoxItemSalones;
import Objetos.Carrera;
import Objetos.Profesor;
import Objetos.Reserva;
import Objetos.Salon;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Conexion;
import java.util.Date;
import javax.swing.UIManager;
import javax.swing.table.TableModel;



/**
 *
 * @author Mobi
 */
public class PantallaReserva extends javax.swing.JFrame {
    /**
     * Creates new form PantallaReserva
     */
    public PantallaReserva() {
        try {
            Reserva reservacion = new Reserva();
            Carrera carrera = new Carrera();
            Salon salon = new Salon();
            Profesor profesores = new Profesor();
            
            initComponents();
            salon.cargarSalonesBOX(salonesBox);
            carrera.cargarCarrerasBOX(carrerasBox);
            profesores.cargarProfesoresBOX(profesorBox);
            reservacion.mostrarReservas(tablaReservas);
            UIManager.setLookAndFeel( new FlatDarkLaf() );
        } catch( Exception ex ) {
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        salonesBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        carrerasBox = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        profesorBox = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        reservar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAccesorios = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaReservas = new javax.swing.JTable();
        diaBox = new com.toedter.calendar.JDateChooser();
        mostrarAccesorios = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        guardarObservacion = new javax.swing.JButton();
        horarioBox = new javax.swing.JComboBox<>();
        observacionEscrita = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        actualizarReservas = new javax.swing.JButton();
        eliminarReserva = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        tamañoText = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        iniciarSesion = new javax.swing.JMenu();
        configuracion = new javax.swing.JMenu();
        estadistica = new javax.swing.JMenu();
        soporteAyuda = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 743));

        jPanel1.setMaximumSize(new java.awt.Dimension(1280, 720));
        jPanel1.setPreferredSize(new java.awt.Dimension(1280, 720));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("RESERVACIONES");

        jLabel2.setText("SALON:");

        salonesBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salonesBoxActionPerformed(evt);
            }
        });

        jLabel3.setText("CARRERA:");

        jLabel4.setText("PROFESOR:");

        jLabel5.setText("DIA:");

        jLabel6.setText("HORARIO:");

        reservar.setText("RESERVAR");
        reservar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reservarActionPerformed(evt);
            }
        });

        tablaAccesorios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Proyector", null},
                {"TV", null},
                {"Cable VGA", null},
                {"Cable HDMI", null},
                {"Cable Interlock 220V", null},
                {"Cable Audio", null},
                {"Adaptador de Señal", null}
            },
            new String [] {
                "Accesorios", "Si/No"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaAccesorios);
        if (tablaAccesorios.getColumnModel().getColumnCount() > 0) {
            tablaAccesorios.getColumnModel().getColumn(0).setResizable(false);
            tablaAccesorios.getColumnModel().getColumn(1).setResizable(false);
        }

        tablaReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Reserva", "Usuario", "Salon", "Fecha", "Horario", "Carrera", "Profesor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaReservas);

        mostrarAccesorios.setText("Mostrar");
        mostrarAccesorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarAccesoriosActionPerformed(evt);
            }
        });

        jLabel8.setText("INFORMACION:");

        jLabel9.setText("Observaciones:");

        guardarObservacion.setText("Guardar nueva observación");
        guardarObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarObservacionActionPerformed(evt);
            }
        });

        horarioBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00-10:00", "10:00-12:00", "12:00-14:00", "14:00-16:00", "16:00-18:00", "18:00-20:00", "20:00-22:00" }));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("RESERVAS");

        actualizarReservas.setText("Actualizar");
        actualizarReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarReservasActionPerformed(evt);
            }
        });

        eliminarReserva.setText("Eliminar");
        eliminarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarReservaActionPerformed(evt);
            }
        });

        jLabel10.setText("TAMAÑO:");

        tamañoText.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(reservar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(observacionEscrita, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(guardarObservacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(salonesBox, 0, 140, Short.MAX_VALUE)
                                    .addComponent(mostrarAccesorios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tamañoText, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(diaBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(profesorBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(carrerasBox, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(horarioBox, 0, 140, Short.MAX_VALUE))))
                        .addGap(30, 30, 30))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(actualizarReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(eliminarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(49, 49, 49))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(salonesBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actualizarReservas)
                    .addComponent(eliminarReserva))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(mostrarAccesorios))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel10))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(tamañoText, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(observacionEscrita, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(guardarObservacion)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(carrerasBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(profesorBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(diaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(horarioBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                        .addComponent(reservar))
                    .addComponent(jScrollPane2))
                .addGap(31, 31, 31))
        );

        iniciarSesion.setText("Iniciar Sesion");
        jMenuBar1.add(iniciarSesion);

        configuracion.setText("Configuracion");
        jMenuBar1.add(configuracion);

        estadistica.setText("Estadistica");
        jMenuBar1.add(estadistica);

        soporteAyuda.setText("Soporte/Ayuda");
        jMenuBar1.add(soporteAyuda);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarObservacionActionPerformed
        ComboBoxItemSalones seleccionarSalon = (ComboBoxItemSalones) salonesBox.getSelectedItem();
        int salonElegido = seleccionarSalon.getId();
        
        String observ = observacionEscrita.getText();
        Salon observacionCargar = new Salon();
        
        observacionCargar.setObservacion(observ);
        observacionCargar.setId_salon(salonElegido);
        
        Salon.guardarObservacion(observacionCargar);
        
        String vacia = "";
        observacionEscrita.setText(vacia);

    }//GEN-LAST:event_guardarObservacionActionPerformed

    private void mostrarAccesoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarAccesoriosActionPerformed
        ComboBoxItemSalones seleccionarSalon = (ComboBoxItemSalones) salonesBox.getSelectedItem();
        int salonElegido = seleccionarSalon.getId();
        
        Salon salon = new Salon();
        
        salon.mostrarAccesorios(salonElegido, tablaAccesorios, tamañoText);
        salon.mostrarObservaciones(salonElegido, observacionEscrita);

    }//GEN-LAST:event_mostrarAccesoriosActionPerformed

    private void salonesBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salonesBoxActionPerformed

    }//GEN-LAST:event_salonesBoxActionPerformed

    private void reservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservarActionPerformed
        //OBTENER VALORES DE LOS COMBOBOX
        ComboBoxItemSalones seleccionarSalon = (ComboBoxItemSalones) salonesBox.getSelectedItem();
        int salonElegido = seleccionarSalon.getId();
        
        ComboBoxItemCarreras seleccionarCarrera = (ComboBoxItemCarreras) carrerasBox.getSelectedItem();
        int carreraElegida = seleccionarCarrera.getId();
        
        ComboBoxItemProfes seleccionarProfes = (ComboBoxItemProfes) profesorBox.getSelectedItem();
        int prof = seleccionarProfes.getDni();
        
        //OBTENER DIA DEL JDATE Y DARLE FORMATO
        Date dia=diaBox.getDate();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = formato.format(dia);
        
        //OBTENER HORARIO DEL BOX Y GUARDARLO EN UNA STRING
        Object horario=horarioBox.getSelectedItem();
        String horarioElegido=horario.toString();
        
        //CREACION DE OBJETOS SALON, CARRERA Y PROFESOR PARA SETEAR SU INFORMACION
        Salon nuevoSalon = new Salon();
        nuevoSalon.setId_salon(salonElegido);
        
        Carrera carrera = new Carrera();
        carrera.setId_carrera(carreraElegida);
        
        Profesor profe = new Profesor();
        profe.setDni(prof);
        
        //CREACION DE LA RESERVA
        Reserva reservacion = new Reserva();
        reservacion.setSalon( nuevoSalon);
        reservacion.setCarrera(carrera);
        reservacion.setHorarioSalon(horarioElegido);
        reservacion.setFechaSalon(fecha);
        reservacion.setProfesor( profe);
        
        reservacion.crearReservas(reservacion);
        reservacion.mostrarReservas(tablaReservas);
        
        
    }//GEN-LAST:event_reservarActionPerformed

    private void actualizarReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarReservasActionPerformed
        Reserva reservacion = new Reserva();
        
        reservacion.mostrarReservas(tablaReservas);
    }//GEN-LAST:event_actualizarReservasActionPerformed

    private void eliminarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarReservaActionPerformed
        Reserva reservacion = new Reserva();
        
        reservacion.eliminarReservas(tablaReservas);
        reservacion.mostrarReservas(tablaReservas);
        
    }//GEN-LAST:event_eliminarReservaActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizarReservas;
    private javax.swing.JComboBox<String> carrerasBox;
    private javax.swing.JMenu configuracion;
    private com.toedter.calendar.JDateChooser diaBox;
    private javax.swing.JButton eliminarReserva;
    private javax.swing.JMenu estadistica;
    private javax.swing.JButton guardarObservacion;
    private javax.swing.JComboBox<String> horarioBox;
    private javax.swing.JMenu iniciarSesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton mostrarAccesorios;
    private javax.swing.JTextField observacionEscrita;
    private javax.swing.JComboBox<String> profesorBox;
    private javax.swing.JButton reservar;
    private javax.swing.JComboBox<String> salonesBox;
    private javax.swing.JMenu soporteAyuda;
    private javax.swing.JTable tablaAccesorios;
    private javax.swing.JTable tablaReservas;
    private javax.swing.JTextField tamañoText;
    // End of variables declaration//GEN-END:variables

    
}
