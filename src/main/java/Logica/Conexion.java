package Logica;

import Objetos.Carrera;
import Objetos.Profesor;

import java.sql.*;
import java.util.ArrayList;

public class Conexion {
    private String URL = "jdbc:mysql://localhost:3306/reservas";
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

    public ArrayList<Profesor> cargarProfesores(){
        ArrayList<Profesor> profesores = new ArrayList<>();
        try {
            Statement consulta = conexion.createStatement();
            ResultSet RS = consulta.executeQuery("SELECT * FROM `profesores` WHERE 1");
            while(RS.next()){
                Carrera carrera = null;
                Statement consulta2 = conexion.createStatement();
                ResultSet RS1 = consulta2.executeQuery("SELECT * FROM carreras WHERE id_carrera ="+RS.getInt(4));
                while(RS1.next()) {
                carrera = new Carrera(RS1.getInt(1),RS1.getString(2));
                }
                consulta2.close();
                profesores.add(new Profesor(RS.getInt(1),RS.getString(2),RS.getString(3),carrera));
            }
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return profesores;
    }

    public ArrayList<Carrera> cargarCarreras(){
        ArrayList<Carrera> carreras = new ArrayList<>();
        try {
            Statement consulta = conexion.createStatement();
            ResultSet RS = consulta.executeQuery("SELECT * FROM `carreras` WHERE 1");
                while(RS.next()) {
                    carreras.add(new Carrera(RS.getInt(1),RS.getString(2)));
                }
                consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return carreras;
    }
}
