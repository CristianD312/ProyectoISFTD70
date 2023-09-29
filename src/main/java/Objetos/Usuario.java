package Objetos;

import Pantallas.PantallaLogin;
import Pantallas.PantallaReserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Logica.Conexion;
import javax.swing.JFrame;

public class Usuario {

    private int id_usuario;
    private String nombre;
    private String password;
    private String dni;
     
    
    public Usuario(){
        
    }

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

    public void setNombre(String nombre) {
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
    
    public int obtenerUsuario(String user, String password){
       Conexion conect = new Conexion();
        conect.conectar();
        int id = -1;
        try {
            String sql="SELECT *FROM usuarios WHERE nombre='"+user+"'";
            PreparedStatement st = conect.getConexion().prepareStatement(sql);
            ResultSet rs=st.executeQuery(sql);
            if (rs.next()) {

                String pass = rs.getString("contraseña");
                
                if (password.equals(pass)) {
                    
                    
                    id = rs.getInt("ID_usuario");
                    
                    rs.close();
                    st.close();
                } else {
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                    rs.close();
                    st.close();
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo encontrar al usuario");
            }
            st.close();
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(PantallaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
      return id;
    }
}
