/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Pantallas.Configuracion;

import Objetos.Salon;

import javax.swing.*;

/**
 *
 * @author dario
 */
public class FormularioSalon extends javax.swing.JFrame {
    Salon salon;
    /**
     * Creates new form ModificarProfesor
     */
    public FormularioSalon(Salon salon) {
        this.salon = salon;
        initComponents();
        // en caso de usar este constructor estoy modificando un salon, el siguiente codigo carga los datos del mismo dentro de las checkbox:
            comboBoxTamano.setSelectedItem(salon.getTamano());
            proyector.setSelected(this.salon.isProyector());
            TV.setSelected(this.salon.isTV());
            cableVGA.setSelected(this.salon.isCableVGA());
            cableHDMI.setSelected(this.salon.isCableHDMI());
            cableAudio.setSelected(this.salon.isCableAudio());
            interlock220V.setSelected(this.salon.isInterlock220V());
            conversor.setSelected(this.salon.isConversor());
            nombre.setText(this.salon.getNombre());
            observaciones.setText(this.salon.getObservaciones());
            //cuando apretas la "x" cierra unicamente la ventana del formulario
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public FormularioSalon() {
        //en caso de utilizar este constructor se esta cargando un salon nuevo y carga el formulario sin nada selecciondo
        initComponents();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        guardar = new javax.swing.JButton();
        comboBoxTamano = new javax.swing.JComboBox<>();
        proyector = new javax.swing.JCheckBox();
        TV = new javax.swing.JCheckBox();
        cableHDMI = new javax.swing.JCheckBox();
        cableVGA = new javax.swing.JCheckBox();
        interlock220V = new javax.swing.JCheckBox();
        cableAudio = new javax.swing.JCheckBox();
        conversor = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        observaciones = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modificar Profesor");

        guardar.setText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        comboBoxTamano.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Grande" }));
        comboBoxTamano.setPreferredSize(new java.awt.Dimension(200, 25));

        proyector.setText("Proyector");
        proyector.setPreferredSize(new java.awt.Dimension(200, 25));
        proyector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proyectorActionPerformed(evt);
            }
        });

        TV.setText("Televisor");
        TV.setPreferredSize(new java.awt.Dimension(200, 25));

        cableHDMI.setText("Cable HDMI");
        cableHDMI.setPreferredSize(new java.awt.Dimension(200, 25));
        cableHDMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cableHDMIActionPerformed(evt);
            }
        });

        cableVGA.setText("Cable VGA");
        cableVGA.setPreferredSize(new java.awt.Dimension(200, 25));

        interlock220V.setText("Cable interlock 220v");
        interlock220V.setPreferredSize(new java.awt.Dimension(200, 25));

        cableAudio.setText("Cable de audio");
        cableAudio.setPreferredSize(new java.awt.Dimension(200, 25));

        conversor.setText("Conversor de señal");
        conversor.setPreferredSize(new java.awt.Dimension(200, 25));

        jLabel1.setText("Tamaño:");

        observaciones.setColumns(20);
        observaciones.setLineWrap(true);
        observaciones.setRows(5);
        observaciones.setWrapStyleWord(true);

        jLabel2.setText("Nombre:");

        jLabel3.setText("Observaciones:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(observaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(interlock220V, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cableAudio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(conversor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                                    .addComponent(jLabel1)
                                    .addComponent(comboBoxTamano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addComponent(guardar))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(cableHDMI, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(proyector, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(cableVGA, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4))
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 6, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboBoxTamano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(proyector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cableHDMI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cableVGA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(interlock220V, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cableAudio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(conversor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(observaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(guardar)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        //en caso de que salon sea diferente de null, es decir, que le pase un salon al formulario para modificar, este algoritmo modifica los valores del objeto existente y los sincroniza con la base de datos
        if(salon != null){
            salon.setTamano(comboBoxTamano.getSelectedItem().toString());
            salon.setProyector(proyector.isSelected());
            salon.setTV(TV.isSelected());
            salon.setCableHDMI(cableHDMI.isSelected());
            salon.setCableVGA(cableVGA.isSelected());
            salon.setInterlock220V(interlock220V.isSelected());
            salon.setCableAudio(cableAudio.isSelected());
            salon.setConversor(conversor.isSelected());
            salon.setObservaciones(observaciones.getText());
            salon.setNombre(nombre.getText());
        }else{
            //caso contrario crea un salon nuevo con ina id no valida(-1) y lo carga a la base de datos
            salon = new Salon(-1,nombre.getText(),comboBoxTamano.getSelectedItem().toString(),observaciones.getText(),interlock220V.isSelected(),cableVGA.isSelected(),cableHDMI.isSelected(),cableAudio.isSelected(),conversor.isSelected(),TV.isSelected(),proyector.isSelected());
            salon.cargarSalon();
        }
        //cierra el formulario
        this.dispose();
    }//GEN-LAST:event_guardarActionPerformed

    private void proyectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proyectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_proyectorActionPerformed

    private void cableHDMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cableHDMIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cableHDMIActionPerformed

    /**
     * @param args the command line arguments
     */
    




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox TV;
    private javax.swing.JCheckBox cableAudio;
    private javax.swing.JCheckBox cableHDMI;
    private javax.swing.JCheckBox cableVGA;
    private javax.swing.JComboBox<String> comboBoxTamano;
    private javax.swing.JCheckBox conversor;
    private javax.swing.JButton guardar;
    private javax.swing.JCheckBox interlock220V;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextArea observaciones;
    private javax.swing.JCheckBox proyector;
    // End of variables declaration//GEN-END:variables
    }

