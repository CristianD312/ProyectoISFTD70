package Objetos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Carrera {
    private int id_carrera;
    private String nombre;
    public Carrera(int id_carrera, String nombre) {
        this.id_carrera = id_carrera;
        this.nombre = nombre;
    }

    public int getId_carrera() {
        return id_carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(Connection con, String nombre) {
        try{
            PreparedStatement consulta = con.prepareStatement("UPDATE carreras SET nombre = ? WHERE id_carrera = ?");
            consulta.setString(1,nombre);
            consulta.setInt(2,id_carrera);
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.nombre = nombre;
    }
}
