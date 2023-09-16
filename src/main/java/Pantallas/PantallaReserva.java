/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pantallas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.Conexion;
import java.util.Date;



/**
 *
 * @author Mobi
 */
public class PantallaReserva extends javax.swing.JFrame {
    
    /**
     * Creates new form PantallaReserva
     */
    public PantallaReserva() {
        initComponents();
        cargarSalonesBOX(salonesBox);
        cargarCarrerasBOX(carrerasBox);
        cargarProfesoresBOX(profesorBox);
        
        
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
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAccesorios = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        mostrarAccesorios = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        observacionEscrita = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        mostrarObservacion = new javax.swing.JButton();
        guardarObservacion = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
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

        jButton1.setText("RESERVAR");

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

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable2);

        mostrarAccesorios.setText("Mostrar");
        mostrarAccesorios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarAccesoriosActionPerformed(evt);
            }
        });

        jLabel8.setText("ACCESORIOS");

        observacionEscrita.setColumns(20);
        observacionEscrita.setRows(5);
        jScrollPane3.setViewportView(observacionEscrita);

        jLabel9.setText("Observaciones:");

        mostrarObservacion.setText("Mostrar");
        mostrarObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarObservacionActionPerformed(evt);
            }
        });

        guardarObservacion.setText("Guardar");
        guardarObservacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarObservacionActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00-10:00", "10:00-12:00", "12:00-14:00", "14:00-16:00", "16:00-18:00", "18:00-20:00", "20:00-22:00" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(mostrarObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(guardarObservacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(18, 18, 18)
                                        .addComponent(mostrarAccesorios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(34, 34, 34)
                                        .addComponent(carrerasBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6))
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(profesorBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(47, 47, 47)
                                        .addComponent(salonesBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(30, 30, 30))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 932, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jScrollPane2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(salonesBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(mostrarAccesorios))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mostrarObservacion)
                            .addComponent(guardarObservacion))
                        .addGap(18, 22, Short.MAX_VALUE)
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
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(96, 96, 96)
                        .addComponent(jButton1)))
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

    private void salonesBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salonesBoxActionPerformed

    }//GEN-LAST:event_salonesBoxActionPerformed

    private void mostrarAccesoriosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarAccesoriosActionPerformed
        Object numeroSalon = salonesBox.getSelectedItem();
        //int numeroSalon = Integer.parseInt(accesoriosSalon.getText());
        mostrarAccesorios(numeroSalon);
       
    }//GEN-LAST:event_mostrarAccesoriosActionPerformed

    private void guardarObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarObservacionActionPerformed
        Object numeroSalon = salonesBox.getSelectedItem();
        cargarObservaciones(numeroSalon);
        String vacia = "";
        observacionEscrita.setText(vacia);
        
    }//GEN-LAST:event_guardarObservacionActionPerformed

    private void mostrarObservacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mostrarObservacionActionPerformed
        Object numeroSalon = salonesBox.getSelectedItem();
        mostrarObservaciones(numeroSalon);
        
        
    }//GEN-LAST:event_mostrarObservacionActionPerformed

    private void cargarObservaciones(Object numSalon){
        String observacion = observacionEscrita.getText();
        //int idSalon = Integer.parseInt((String) numSalon); //SIRVE PARA TOMAR EL VALOR DEL OBJETO Y GUARDARLO EN UNA VARIABLE DE TIPO INT
        Conexion conect = new Conexion(null);
        conect.conectar(); 
        try {
            String sql = "UPDATE `salones` SET `observaciones` = ? WHERE `id_salon` = "+numSalon;
            PreparedStatement statement = conect.getConn().prepareStatement(sql);
            statement.setString(1, observacion);
            JOptionPane.showMessageDialog(null, "Observacion cargada con exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la observacion: "+e.toString());
        }
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
                String opciones = numSalones + " " + nombreSalon;
                salonesBox.addItem(opciones);
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
                String opciones = idCarrera + " " + nombreCarrera;
                carrerasBox.addItem(opciones);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar las carreras: "+e.toString());
        }
    }
    private void cargarProfesoresBOX(JComboBox profesoresBox){
        Conexion conect = new Conexion(null);
        conect.conectar(); 
        try {
            String sql = "SELECT nombre FROM `profesores`";
            java.sql.Statement statement = conect.getConn().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                String nombresProfes = resultSet.getString("nombre");
                profesoresBox.addItem(nombresProfes);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.toString());
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
    }
    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> carrerasBox;
    private javax.swing.JMenu configuracion;
    private javax.swing.JMenu estadistica;
    private javax.swing.JButton guardarObservacion;
    private javax.swing.JMenu iniciarSesion;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton mostrarAccesorios;
    private javax.swing.JButton mostrarObservacion;
    private javax.swing.JTextArea observacionEscrita;
    private javax.swing.JComboBox<String> profesorBox;
    private javax.swing.JComboBox<String> salonesBox;
    private javax.swing.JMenu soporteAyuda;
    private javax.swing.JTable tablaAccesorios;
    // End of variables declaration//GEN-END:variables

    
}
