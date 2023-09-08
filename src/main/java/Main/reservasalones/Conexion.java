package Main.reservasalones;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    
    private static final String URL = "jdbc:mysql://localhost:3306/NOMBREBASEDATOS";
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
            JOptionPane.showMessageDialog(null, "Conexion realizada con exito");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar. Error: "+e.toString());
        }
    return conn;
    }
    
}
