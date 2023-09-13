package Pantallas;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

public class Configuracion extends javax.swing.JFrame {

    public Configuracion() {
        initComponents();
    }
    private void initComponents() {
        jTabbedPane1 = new JTabbedPane();
        tabSalones = new JLayeredPane();
        labelAgregarSalon = new JLabel();
        labelModificarSalon = new JLabel();
        labelTamano = new JLabel();
        labelSalon = new JLabel();
        comboboxTamano = new JComboBox<>();
        comboboxSalones = new JComboBox<>();
        checkboxProyectorAgregar = new JCheckBox();
        checkboxProyectorModificar = new JCheckBox();
        checkboxTelevisorAgregar = new JCheckBox();
        checkboxTelevisorModificar = new JCheckBox();
        checkboxVGAAgregar = new JCheckBox();
        checkBoxVGAModificar = new JCheckBox();
        checkboxHDMIAgregar = new JCheckBox();
        checkboxHDMIModificar = new JCheckBox();
        checkboxInterlockAgregar = new JCheckBox();
        checkboxInterlockModificar = new JCheckBox();
        checkboxCableAudioAgregar = new JCheckBox();
        checkboxCableAudioModificar = new JCheckBox();
        checkboxConversorAgregar = new JCheckBox();
        checkboxConversorModificar = new JCheckBox();
        botonGuardarNuevoSalon = new JButton();
        botonModificarSalon = new JButton();
        jLayeredPane2 = new JLayeredPane();
        jScrollPane1 = new JScrollPane();
        jTable1 = new JTable();
        jLayeredPane3 = new JLayeredPane();
        jLayeredPane4 = new JLayeredPane();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabSalones.setLayout(new GridLayout(11, 2, 10, 0));

        labelAgregarSalon.setText("Agregar Salón:");
        tabSalones.add(labelAgregarSalon);

        labelModificarSalon.setText("Modificar Salón:");
        tabSalones.add(labelModificarSalon);

        labelTamano.setText("Tamaño:");
        tabSalones.add(labelTamano);

        labelSalon.setText("Salón:");
        tabSalones.add(labelSalon);

        comboboxTamano.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Grande" }));
        tabSalones.add(comboboxTamano);

        comboboxSalones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Salón 1", "Salón 2", "Salón 3", "Salón 4" }));
        tabSalones.add(comboboxSalones);

        checkboxProyectorAgregar.setText("Proyector");
        tabSalones.add(checkboxProyectorAgregar);

        checkboxProyectorModificar.setText("Proyector");
        tabSalones.add(checkboxProyectorModificar);

        checkboxTelevisorAgregar.setText("Televisor");
        tabSalones.add(checkboxTelevisorAgregar);

        checkboxTelevisorModificar.setText("Televisor");
        tabSalones.add(checkboxTelevisorModificar);

        checkboxVGAAgregar.setText("Cable VGA");
        tabSalones.add(checkboxVGAAgregar);

        checkBoxVGAModificar.setText("Cable VGA");
        tabSalones.add(checkBoxVGAModificar);

        checkboxHDMIAgregar.setText("Cable HDMI");
        tabSalones.add(checkboxHDMIAgregar);

        checkboxHDMIModificar.setText("Cable HDMI");
        tabSalones.add(checkboxHDMIModificar);

        checkboxInterlockAgregar.setText("Cable interlock 220v");
        tabSalones.add(checkboxInterlockAgregar);

        checkboxInterlockModificar.setText("Cable interlock 220v");
        tabSalones.add(checkboxInterlockModificar);

        checkboxCableAudioAgregar.setText("Cable de audio");
        tabSalones.add(checkboxCableAudioAgregar);

        checkboxCableAudioModificar.setText("Cable de audio");
        tabSalones.add(checkboxCableAudioModificar);

        checkboxConversorAgregar.setText("Conversor de señal");
        tabSalones.add(checkboxConversorAgregar);

        checkboxConversorModificar.setText("Conversor de señal");
        tabSalones.add(checkboxConversorModificar);

        botonGuardarNuevoSalon.setText("Guardar");
        botonGuardarNuevoSalon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabSalones.add(botonGuardarNuevoSalon);

        botonModificarSalon.setText("Modificar");
        botonModificarSalon.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tabSalones.add(botonModificarSalon);

        jTabbedPane1.addTab("Salones", tabSalones);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLayeredPane2.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Profesores", jLayeredPane2);

        javax.swing.GroupLayout jLayeredPane3Layout = new javax.swing.GroupLayout(jLayeredPane3);
        jLayeredPane3.setLayout(jLayeredPane3Layout);
        jLayeredPane3Layout.setHorizontalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jLayeredPane3Layout.setVerticalGroup(
            jLayeredPane3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 378, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Carreras", jLayeredPane3);

        javax.swing.GroupLayout jLayeredPane4Layout = new javax.swing.GroupLayout(jLayeredPane4);
        jLayeredPane4.setLayout(jLayeredPane4Layout);
        jLayeredPane4Layout.setHorizontalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        jLayeredPane4Layout.setVerticalGroup(
            jLayeredPane4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 378, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Configuración", jLayeredPane4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }
    public static void main(String args[]) {
        // Carga de tema
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new Configuracion().setVisible(true);
            }
        });
    }
    private JButton botonGuardarNuevoSalon;
    private JButton botonModificarSalon;
    private JCheckBox checkboxProyectorAgregar;
    private JCheckBox checkboxInterlockModificar;
    private JCheckBox checkboxCableAudioAgregar;
    private JCheckBox checkboxCableAudioModificar;
    private JCheckBox checkboxConversorAgregar;
    private JCheckBox checkboxConversorModificar;
    private JCheckBox checkboxProyectorModificar;
    private JCheckBox checkboxTelevisorAgregar;
    private JCheckBox checkboxTelevisorModificar;
    private JCheckBox checkboxVGAAgregar;
    private JCheckBox checkBoxVGAModificar;
    private JCheckBox checkboxHDMIAgregar;
    private JCheckBox checkboxHDMIModificar;
    private JCheckBox checkboxInterlockAgregar;
    private JComboBox<String> comboboxTamano;
    private JComboBox<String> comboboxSalones;
    private JLabel labelAgregarSalon;
    private JLabel labelTamano;
    private JLabel jLabel3;
    private JLabel labelModificarSalon;
    private JLabel labelSalon;
    private JLayeredPane tabSalones;
    private JLayeredPane jLayeredPane2;
    private JLayeredPane jLayeredPane3;
    private JLayeredPane jLayeredPane4;
    private JScrollPane jScrollPane1;
    private JTabbedPane jTabbedPane1;
    private JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
