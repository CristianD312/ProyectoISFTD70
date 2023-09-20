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
            initComponents();
            cargarSalonesBOX(salonesBox);
            cargarCarrerasBOX(carrerasBox);
            cargarProfesoresBOX(profesorBox);
            mostrarReservas();
            UIManager.setLookAndFeel( new FlatDarkLaf() );
        } catch( Exception ex ) {
            
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

        guardarObservacion.setText("Guardar nueva observacion");
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
        
        cargarObservaciones(salonElegido);
        String vacia = "";
        observacionEscrita.setText(vacia);

    }//GEN-LAST:event_guardarObservacionActionPerformed

    private void mostrarAccesoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarAccesoriosActionPerformed
        ComboBoxItemSalones seleccionarSalon = (ComboBoxItemSalones) salonesBox.getSelectedItem();
        int salonElegido = seleccionarSalon.getId();
        
        mostrarAccesorios(salonElegido);
        mostrarObservaciones(salonElegido);

    }//GEN-LAST:event_mostrarAccesoriosActionPerformed

    private void salonesBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salonesBoxActionPerformed

    }//GEN-LAST:event_salonesBoxActionPerformed

    private void reservarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reservarActionPerformed
       
        ComboBoxItemSalones seleccionarSalon = (ComboBoxItemSalones) salonesBox.getSelectedItem();
        int salonElegido = seleccionarSalon.getId();
        
        ComboBoxItemCarreras selectedItem = (ComboBoxItemCarreras) carrerasBox.getSelectedItem();
        int carreraElegida = selectedItem.getId();
        
        ComboBoxItemProfes selectItem = (ComboBoxItemProfes) profesorBox.getSelectedItem();
        int prof = selectItem.getDni();
        
        Date dia=diaBox.getDate();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = formato.format(dia);
        
        Object horario=horarioBox.getSelectedItem();
        String horarioElegido=horario.toString();
        
        Salon nuevoSalon = new Salon();
        nuevoSalon.setId_salon(salonElegido);
        
        Carrera carrera = new Carrera();
        carrera.setId_carrera(carreraElegida);
        
        Profesor profe = new Profesor();
        profe.setDni(prof);
        
        Reserva reservacion = new Reserva();
        reservacion.setSalon( nuevoSalon);
        reservacion.setCarrera(carrera);
        reservacion.setHorarioSalon(horarioElegido);
        reservacion.setFechaSalon(fecha);
        reservacion.setProfesor( profe);
        reservacion.crearReservas(reservacion);
        
    }//GEN-LAST:event_reservarActionPerformed

    private void actualizarReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarReservasActionPerformed
        mostrarReservas();
    }//GEN-LAST:event_actualizarReservasActionPerformed

    private void eliminarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarReservaActionPerformed
        eliminarReservas();
        mostrarReservas();
    }//GEN-LAST:event_eliminarReservaActionPerformed

    private void cargarObservaciones(Object numSalon){
        String observ = observacionEscrita.getText();
        String idSalon = numSalon.toString();
        idSalon = idSalon.trim(); //TRIM SIRVE PARA ELIMINAR ESPACIOS EN BLANCO
       
        int numeroSalon = Integer.parseInt(idSalon);
        
        Salon observacionCargar = new Salon();
        observacionCargar.setObservacion(observ);
        observacionCargar.setId_salon(numeroSalon);
        Salon.guardarObservacion(observacionCargar);
        
    }
    private void mostrarObservaciones(Object numSalon){ 
        Conexion conect = new Conexion(null);
        conect.conectar(); 
        try {
            String sql = "SELECT `id_salon`, `nombre_salon`, `tamaño`, `observaciones` FROM `salones` WHERE `id_salon` ="+numSalon;
            java.sql.Statement statement = conect.getConn().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                String observacion = resultSet.getString("observaciones");
                observacionEscrita.setText(observacion);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la observacion: "+e.toString());
        }
    }
    private void cargarSalonesBOX(JComboBox salonesBox){
        Conexion conect = new Conexion(null);
        conect.conectar(); 
        try {
            String sql = "SELECT id_salon, nombre_salon FROM `salones`";
            java.sql.Statement statement = conect.getConn().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int numSalones = resultSet.getInt("id_salon");
                String nombreSalon = resultSet.getString("nombre_salon");
                //String opciones = numSalones + " " + nombreSalon;
                //salonesBox.addItem(opciones);
                salonesBox.addItem(new ComboBoxItemSalones(numSalones, nombreSalon));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los salones: "+e.toString());
        }
        
    }
    private void cargarCarrerasBOX(JComboBox carrerasBox){
        Conexion conect = new Conexion(null);
        conect.conectar(); 
        try {
            String sql = "SELECT id_carrera, nombre_carrera FROM `carreras`";
            java.sql.Statement statement = conect.getConn().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int idCarrera = resultSet.getInt("id_carrera");
                String nombreCarrera = resultSet.getString("nombre_carrera");
                //String opciones = idCarrera + " " + nombreCarrera;
                carrerasBox.addItem(new ComboBoxItemCarreras(idCarrera, nombreCarrera));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar las carreras: "+e.toString());
        }
    }
    private void cargarProfesoresBOX(JComboBox profesorBox){
        Conexion conect = new Conexion(null);
        conect.conectar(); 
        try {
            String sql = "SELECT dni, nombre, apellido FROM `profesores`";
            java.sql.Statement statement = conect.getConn().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int dnis = resultSet.getInt("dni");
                String nombresProfes = resultSet.getString("nombre");
                String apellidosProfes = resultSet.getString("apellido");
                profesorBox.addItem(new ComboBoxItemProfes(dnis, nombresProfes, apellidosProfes));
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los profesores: "+e.toString());
        }
    }
    
    private void mostrarAccesorios(Object numSalon){
        DefaultTableModel tAccesorios = new DefaultTableModel();
        tAccesorios.addColumn("Accesorios");
        tAccesorios.addColumn("Si/No");
        //tAccesorios.addColumn("No");
        tablaAccesorios.setModel(tAccesorios);
        
        ArrayList<Object> datosBooleanosProyector = new ArrayList<>();
        ArrayList<Object> datosBooleanosTV = new ArrayList<>();
        ArrayList<Object> datosBooleanosVGA = new ArrayList<>();
        ArrayList<Object> datosBooleanosHDMI = new ArrayList<>();
        ArrayList<Object> datosBooleanosI220V = new ArrayList<>();
        ArrayList<Object> datosBooleanosAUDIO = new ArrayList<>();
        ArrayList<Object> datosBooleanosASEÑAL = new ArrayList<>();
        
        String verdadero = "Si";
        String falso = "No";
        
        Conexion conect = new Conexion(null);
        conect.conectar();
        try {
            String sql = "SELECT * FROM `accesorios` WHERE `fk_salon` ="+numSalon;
            java.sql.Statement statement = conect.getConn().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                
                 datosBooleanosProyector.add("Proyector"); // Nombre del accesorio, puedes cambiarlo según tu base de datos
                 datosBooleanosProyector.add(resultSet.getInt("proyector") == 1 ? verdadero : falso); // 1 para "Si", 0 para "No"
                 
                 datosBooleanosTV.add("TV");
                 datosBooleanosTV.add(resultSet.getInt("tv") == 1 ? verdadero : falso);
                 
                 datosBooleanosVGA.add("Cable VGA");
                 datosBooleanosVGA.add(resultSet.getInt("vga") == 1 ? verdadero : falso);
                 
                 datosBooleanosHDMI.add("Cable HDMI");
                 datosBooleanosHDMI.add(resultSet.getInt("hdmi") == 1 ? verdadero : falso);
                 
                 datosBooleanosI220V.add("Cable Interlock 220V");
                 datosBooleanosI220V.add(resultSet.getInt("interlock") == 1 ? verdadero : falso);
                 
                 datosBooleanosAUDIO.add("Cable Audio");
                 datosBooleanosAUDIO.add(resultSet.getInt("audio") == 1 ? verdadero : falso);
                 
                 datosBooleanosASEÑAL.add("Adaptador de Señal");
                 datosBooleanosASEÑAL.add(resultSet.getInt("adp_conversor") == 1 ? verdadero : falso);
                
                tAccesorios.addRow(datosBooleanosProyector.toArray());
                tAccesorios.addRow(datosBooleanosTV.toArray());
                tAccesorios.addRow(datosBooleanosVGA.toArray());
                tAccesorios.addRow(datosBooleanosHDMI.toArray());
                tAccesorios.addRow(datosBooleanosI220V.toArray());
                tAccesorios.addRow(datosBooleanosAUDIO.toArray());
                tAccesorios.addRow(datosBooleanosASEÑAL.toArray());
            }
        } catch (Exception e) {
        }
        
        
        try {
            String sql = "SELECT `tamaño` FROM `salones` WHERE `id_salon` ="+numSalon+";";
            java.sql.Statement statement = conect.getConn().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
               String tamaño = resultSet.getString("tamaño");
               tamañoText.setText(tamaño);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar el tamaño del salon: "+e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void mostrarReservas(){
      DefaultTableModel tReservas = new DefaultTableModel();
      tReservas.addColumn("ID Reserva");
      tReservas.addColumn("Usuario");
      tReservas.addColumn("Salón");
      tReservas.addColumn("Fecha");
      tReservas.addColumn("Horario");
      tReservas.addColumn("Carrera");
      tReservas.addColumn("Profesor");
      tablaReservas.setModel(tReservas);
      
      String [] datosReserva = new String[7];
      Conexion conect = new Conexion(null);
      conect.conectar();
      
      try {
        String sql = "SELECT reservas.id_reserva, usuarios.nombre, salones.id_salon, salones.nombre_salon, reservas.fecha_reserva, reservas.horario, carreras.nombre_carrera, profesores.nombre, profesores.apellido\n" +
        "FROM `reservas` \n" +
        "INNER JOIN usuarios ON reservas.fk_usuario=usuarios.ID_usuario\n" +
        "INNER JOIN salones ON reservas.fk_salon=salones.id_salon\n" +
        "INNER JOIN carreras ON reservas.carrera=carreras.id_carrera\n" +
        "INNER JOIN profesores ON reservas.profesor=profesores.dni;";
        PreparedStatement statement = conect.getConn().prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
              datosReserva[0] = resultSet.getString(1);
              datosReserva[1] = resultSet.getString(2);
              datosReserva[2] = resultSet.getString(3)+"- "+resultSet.getString(4);
              datosReserva[3] = resultSet.getString(5);
              datosReserva[4] = resultSet.getString(6);
              datosReserva[5] = resultSet.getString(7);
              datosReserva[6] = resultSet.getString(8)+" "+resultSet.getString(9);
              tReservas.addRow(datosReserva);
          }
        resultSet.close(); statement.close();
        tablaReservas.setModel(tReservas);
        
      } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Error al mostrar las reservas correctamente: "+e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
    private void eliminarReservas(){
         int filaSelecionada = tablaReservas.getSelectedRow();
         String conversionIdReserva = (String) tablaReservas.getValueAt(filaSelecionada, 0);
         int idReserva = Integer.parseInt(conversionIdReserva);
         Conexion conect = new Conexion(null);
        conect.conectar();
        try {
            String sql = "DELETE FROM `reservas` WHERE id_reserva = ?;";
            PreparedStatement statement = conect.getConn().prepareStatement(sql);
            statement.setInt(1, idReserva); 
            statement.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la reserva: "+e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
         
    }
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
