package Objetos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import logica.Conexion;

public class Profesor {
    private int dni;
    private String nombre;
    private String apellido;
    private Carrera carrera;
    
    public Profesor (){}
    public Profesor(Integer dni, String nombre, String apellido, Carrera carrera) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setNombre(Connection con, String nombre) {
        
        try{
            PreparedStatement consulta = con.prepareStatement("UPDATE profesores SET nombre = ? where dni = ?");
            consulta.setString(1,nombre);
            consulta.setInt(2,dni);
            consulta.executeUpdate();
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.nombre = nombre;
    }

    public void setApellido(Connection con, String apellido) {
        try{
            PreparedStatement consulta = con.prepareStatement("UPDATE profesores SET Apellido = ? where dni = ?");
            consulta.setString(1,apellido);
            consulta.setInt(2,dni);
            consulta.executeUpdate();
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.apellido = apellido;
    }

    public void setCarrera(Connection con, Carrera carrera) {
        try{
            PreparedStatement consulta = con.prepareStatement("UPDATE profesores SET fk_id_carrera = ? where dni = ?");
            consulta.setInt(1, carrera.getId_carrera());
            consulta.setInt(2,dni);
            consulta.executeUpdate();
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.carrera = carrera;
    }
}
