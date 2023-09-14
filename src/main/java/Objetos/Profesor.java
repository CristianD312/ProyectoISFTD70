package Objetos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Profesor {
    private Integer dni;
    private String nombre;
    private String apellido;
    private Carrera carrera;
    public Profesor(Integer dni, String nombre, String apellido, Carrera carrera) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
    }

    public Integer getDni() {
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

    public void setDni(Connection con, Integer dni) {
        try{
            PreparedStatement consulta = con.prepareStatement("UPDATE profesores SET dni = ? where dni = ?");
            consulta.setInt(1,dni);
            consulta.setInt(2,this.dni);
            consulta.executeUpdate();
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
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
    public void cargarDatosProfesor(Connection con){
        try {
            PreparedStatement consultaExistencia = con.prepareStatement("SELECT EXISTS (SELECT 1 FROM profesores WHERE dni = ?)");
            consultaExistencia.setInt(1,dni);
            int bol = 0;
             ResultSet RS = consultaExistencia.executeQuery();
             while(RS.next()){
                 bol =RS.getInt(1);
             }
            if(bol != 1){
                PreparedStatement cargaDeDatos = con.prepareStatement("INSERT INTO `profesores`(`dni`, `nombre`, `Apellido`, `fk_id_carrera`) VALUES (?,?,?,?)");
                cargaDeDatos.setInt(1,dni);
                cargaDeDatos.setString(2,nombre);
                cargaDeDatos.setString(3,apellido);
                cargaDeDatos.setInt(4,carrera.getId_carrera());
                cargaDeDatos.executeUpdate();
                cargaDeDatos.close();
            }
            consultaExistencia.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
