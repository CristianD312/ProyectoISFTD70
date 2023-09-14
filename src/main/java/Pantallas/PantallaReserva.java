/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pantallas;

import java.sql.ResultSet;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import logica.Conexion;



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
        horario = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Proyector", null},
                {"TV", null},
                {"Cabke VGA", null},
                {"Cable HDMI", null},
                {"Cable Interlock 220V", null},
                {"Cable Audio", null}
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
        jScrollPane1.setViewportView(jTable1);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(profesorBox, 0, 165, Short.MAX_VALUE)
                                    .addComponent(horario)))
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(carrerasBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(salonesBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(39, 39, 39)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 966, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(salonesBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(carrerasBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(profesorBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addComponent(jLabel5)
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(horario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 623, Short.MAX_VALUE))
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

    private void cargarSalonesBOX(JComboBox salonesBox){
        Conexion conect = new Conexion(null);
        conect.conectar(); 
        try {
            String sql = "SELECT id_salon FROM `salones`";
            java.sql.Statement statement = conect.getConn().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int numSalones = resultSet.getInt("id_salon");
                salonesBox.addItem(numSalones);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.toString());
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
            JOptionPane.showMessageDialog(null, "Error: "+e.toString());
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
    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> carrerasBox;
    private javax.swing.JMenu configuracion;
    private javax.swing.JMenu estadistica;
    private javax.swing.JTextField horario;
    private javax.swing.JMenu iniciarSesion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox<String> profesorBox;
    private javax.swing.JComboBox<String> salonesBox;
    private javax.swing.JMenu soporteAyuda;
    // End of variables declaration//GEN-END:variables
}
