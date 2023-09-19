package Logica;

import Objetos.Carrera;
import Objetos.Profesor;
import Objetos.Salon;

import java.sql.*;
import java.util.ArrayList;

public class Conexion {
    private String URL = "jdbc:mysql://localhost:3306/tst";
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

    public Connection getConexion() {return conexion;}
}
