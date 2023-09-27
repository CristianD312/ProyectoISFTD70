package Objetos;

import Logica.ComboBoxItemCarreras;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import Logica.Conexion;

public class Carrera {
    private int id_carrera;
    private String nombre;
    
    public Carrera(){}
    
    public Carrera(int id_carrera, String nombre) {
        this.id_carrera = id_carrera;
        this.nombre = nombre;
    }

    public int getId_carrera() {
        return id_carrera;
    }
    
    public void setId_carrera(int id_carrera){
        this.id_carrera = id_carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre() {
        Conexion conect = new Conexion();
        conect.conectar(); 
        try{
            String sql = "UPDATE carreras SET nombre_carrera = ? WHERE id_carrera = ?";
            PreparedStatement consulta = conect.getConexion().prepareStatement(sql);
            consulta.setString(1,nombre);
            consulta.setInt(2,id_carrera);
            consulta.executeUpdate();
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.nombre = nombre;
    }
    
    public void cargarCarrerasBOX(JComboBox carrerasBox){
        Conexion conect = new Conexion();
        conect.conectar(); 
        try {
            String sql = "SELECT id_carrera, nombre_carrera FROM `carreras`";
            java.sql.Statement statement = conect.getConexion().createStatement();
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
}
