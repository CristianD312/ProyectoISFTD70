package Objetos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Profesor {
    private String dni;
    private String nombre;
    private String apellido;
    private Carrera carrera;
    public Profesor(String dni, String nombre, String apellido, Carrera carrera) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
    }

    public String getDni() {
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

    public void setDni(Connection con, String dni) {
        try{
            PreparedStatement consulta = con.prepareStatement("UPDATE profesores SET dni = ? where dni = ?");
            consulta.setString(1,dni);
            consulta.setString(2,this.dni);
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.dni = dni;
    }

    public void setNombre(Connection con, String nombre) {
        try{
            PreparedStatement consulta = con.prepareStatement("UPDATE profesores SET nombre = ? where dni = ?");
            consulta.setString(1,nombre);
            consulta.setString(2,dni);
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.nombre = nombre;
    }

    public void setApellido(Connection con, String apellido) {
        try{
            PreparedStatement consulta = con.prepareStatement("UPDATE profesores SET apellido = ? where dni = ?");
            consulta.setString(1,apellido);
            consulta.setString(2,dni);
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.apellido = apellido;
    }

    public void setCarrera(Connection con, Carrera carrera) {
        try{
            PreparedStatement consulta = con.prepareStatement("UPDATE profesores SET id_carrera = ? where dni = ?");
            consulta.setInt(1, carrera.getId_carrera());
            consulta.setString(2,dni);
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.carrera = carrera;
    }
}
