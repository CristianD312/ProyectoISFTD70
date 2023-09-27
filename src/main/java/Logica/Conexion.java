/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
/**
 *
 * @author Mobi
 */
public class Conexion {
   private static final String URL = "jdbc:mysql://localhost:3306/reservas";
    private static final String USUARIO = "root";
    private static final String PASS=""; 

    Connection conn = null;

    public Conexion(Connection conn) {
        this.conn = conn;
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    public Connection conectar(){
        try {
            conn=DriverManager.getConnection(URL, USUARIO, PASS);
            //JOptionPane.showMessageDialog(null, "Conexion realizada con exito master");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar master. Error: "+e.toString());
        }
    return conn;
    } 
    
}
