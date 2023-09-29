
package estadistica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    
private String URL = "jdbc:mysql://localhost:3306/reservas";
    private String USR = "root";
    private String PASS = "";
    
    Connection conn = null;
   
    public Conexion(){
       
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
    public Connection conectar() {
        
       try { 
           conn = DriverManager.getConnection(URL,USR,PASS);
           JOptionPane.showMessageDialog(null,"Conexion realizada con exito");
       }    catch (Exception e){
            JOptionPane.showMessageDialog(null,"No se pudo conectar"+e.toString());
           }
       return conn;
    }

   
    }
