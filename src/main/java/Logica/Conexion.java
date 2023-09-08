package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private String URL = "jdbc:mysql://localhost:3306/Escuela";
    private String USR = "root";
    private String PSSWD = "";
    Connection conexion;
    public Conexion(){
        conectar();
    }
    public Conexion(String URL, String user, String password){
        this.URL = URL;
        USR = user;
        PSSWD = password;
        this.conectar();
    }
    private void conectar(){
        try {
            this.conexion = DriverManager.getConnection(URL, USR, PSSWD);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConexion() {
        return conexion;
    }
}
