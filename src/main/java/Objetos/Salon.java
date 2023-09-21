package Objetos;

import Logica.ComboBoxItemSalones;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JComboBox;
import logica.Conexion;
import Pantallas.PantallaReserva;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Salon {
    private int id_salon;
    private String tamano;
    private boolean proyector;
    private boolean TV;
    private boolean cableVGA;
    private boolean cableHDMI;
    private boolean interlock220V;
    private boolean cableAudio;
    private boolean conversor;
    private String observacion;
    
    public Salon(){}

    public Salon(int id_salon, String tamano, boolean proyector, boolean TV, boolean cableVGA, boolean cableHDMI, boolean interlock220V, boolean cableAudio, boolean conversor, String observacion) {
        this.id_salon = id_salon;
        this.tamano = tamano;
        this.proyector = proyector;
        this.TV = TV;
        this.cableVGA = cableVGA;
        this.cableHDMI = cableHDMI;
        this.interlock220V = interlock220V;
        this.cableAudio = cableAudio;
        this.conversor = conversor;
        this.observacion = observacion;
    }

    public int getId_salon() {
        return id_salon;
    }
    
    public void setId_salon(int id_salon) {
        this.id_salon = id_salon;
    }

    public String getTamano() {
        return tamano;
    }

    public boolean isProyector() {
        return proyector;
    }

    public boolean isTV() {
        return TV;
    }

    public boolean isCableVGA() {
        return cableVGA;
    }

    public boolean isCableHDMI() {
        return cableHDMI;
    }

    public boolean isInterlock220V() {
        return interlock220V;
    }

    public boolean isCableAudio() {
        return cableAudio;
    }

    public boolean isConversor() {
        return conversor;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public void setProyector(Connection con, boolean proyector) {
        try{
            PreparedStatement consulta = con.prepareStatement("UPDATE accesorios SET proyector = ? WHERE fk_salon = ?");
            consulta.setBoolean(1,proyector);
            consulta.setInt(2,id_salon);
            consulta.close();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.proyector = proyector;
    }

    public void setTV(Connection con, boolean TV) {
        try{
            PreparedStatement consulta = con.prepareStatement("UPDATE accesorios SET tv = ? WHERE fk_salon = ?");
            consulta.setBoolean(1,TV);
            consulta.setInt(2,id_salon);
            consulta.executeUpdate();
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.TV = TV;
    }

    public void setCableVGA(Connection con, boolean cableVGA) {
        try{
            PreparedStatement consulta = con.prepareStatement("UPDATE accesorios SET vga = ? WHERE fk_salon = ?");
            consulta.setBoolean(1,cableVGA);
            consulta.setInt(2,id_salon);
            consulta.executeUpdate();
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.cableVGA = cableVGA;
    }

    public void setCableHDMI(Connection con, boolean cableHDMI) {
        try{
            PreparedStatement consulta = con.prepareStatement("UPDATE accesorios SET hdmi = ? WHERE fk_salon = ?");
            consulta.setBoolean(1,cableHDMI);
            consulta.setInt(2,id_salon);
            consulta.executeUpdate();
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.cableHDMI = cableHDMI;
    }

    public void setInterlock220V(Connection con,boolean interlock220V) {
        try{
            PreparedStatement consulta = con.prepareStatement("UPDATE accesorios SET interlock = ? WHERE fk_salon = ?");
            consulta.setBoolean(1,interlock220V);
            consulta.setInt(2,id_salon);
            consulta.executeUpdate();
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.interlock220V = interlock220V;
    }

    public void setCableAudio(Connection con, boolean cableAudio) {
        try{
            PreparedStatement consulta = con.prepareStatement("UPDATE accesorios SET audio = ? WHERE fk_salon = ?");
            consulta.setBoolean(1,cableAudio);
            consulta.setInt(2,id_salon);
            consulta.executeUpdate();
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.cableAudio = cableAudio;
    }

    public void setConversor(Connection con, boolean conversor) {
        try{
            PreparedStatement consulta = con.prepareStatement("UPDATE accesorios SET adp_conversor = ? WHERE fk_salon = ?");
            consulta.setBoolean(1,conversor);
            consulta.setInt(2,id_salon);
            consulta.executeUpdate();
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.conversor = conversor;
    }
    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    public void cargarSalonesBOX(JComboBox salonesBox){
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
    
    public static void guardarObservacion (Salon observa){
        Conexion conect = new Conexion(null);
        conect.conectar(); 
        try {
            String sql ="UPDATE `salones` SET `observaciones`= ? WHERE `id_salon` = ?";
            PreparedStatement statement = conect.getConn().prepareStatement(sql);
            statement.setString(1, observa.getObservacion());
            statement.setInt(2, observa.getId_salon());
            statement.executeUpdate();
            statement.close();
            JOptionPane.showMessageDialog(null, "Observacion cargada con exito");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la observacion: "+e.toString());
        }
    }
    
    public void mostrarObservaciones(int numSalon, JTextField observacionEscrita){ 
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
    
    
    
    
    
    
}

