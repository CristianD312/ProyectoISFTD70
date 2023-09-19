package Objetos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import logica.Conexion;

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
        Conexion conect = new Conexion(null);
        conect.conectar(); 
        try{
            String sql = "UPDATE carreras SET nombre_carrera = ? WHERE id_carrera = ?";
            PreparedStatement consulta = conect.getConn().prepareStatement(sql);
            consulta.setString(1,nombre);
            consulta.setInt(2,id_carrera);
            consulta.executeUpdate();
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.nombre = nombre;
    }
}
