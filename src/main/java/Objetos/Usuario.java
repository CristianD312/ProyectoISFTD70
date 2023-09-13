package Objetos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Usuario {

    private int id_usuario;
    private String nombre;
    private String password;
    private String dni;
      

    public Usuario(int id_usuario, String nombre, String password, String dni) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.password = password;
        this.dni = dni;
        
    }

    public int getId_usuario() {

        return id_usuario;
    }

    public void setId_usuario(int id_usuario) { 
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(Connection con, String nombre) {
        try {
            PreparedStatement consulta = con.prepareStatement("UPDATE usuarios SET nombre = ? where id_usuario = ?");
            consulta.setString(1, nombre);
            consulta.setInt(2, id_usuario);
            consulta.executeUpdate();
            consulta.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(Connection con , String password) {
         try {
            PreparedStatement consulta = con.prepareStatement("UPDATE usuarios SET contraseña = ? where id_usuario = ?");
            consulta.setString(1, password);
            consulta.setInt(2, id_usuario);
            consulta.executeUpdate();
            consulta.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        this.password = password;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(Connection con , String dni) {
         try {
            PreparedStatement consulta = con.prepareStatement("UPDATE usuarios SET dni = ? where fk_dni = ?");
            consulta.setString(1, dni);
            consulta.setInt(2, id_usuario);
            consulta.executeUpdate();
            consulta.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.dni = dni;
    }

}
