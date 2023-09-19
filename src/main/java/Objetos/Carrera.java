package Objetos;

import java.sql.*;
import java.util.ArrayList;

public class Carrera {
    private static ArrayList<Carrera> carreras = new ArrayList<>();
    private static Connection conexion;
    private int id_carrera;
    private String nombre;
    public Carrera(int id_carrera, String nombre) {
        this.id_carrera = id_carrera;
        this.nombre = nombre;
    }
    public static void cargarDatos(){
        try {
            carreras.clear();
            Statement consulta = conexion.createStatement();
            ResultSet RS = consulta.executeQuery("SELECT * FROM `carreras` WHERE 1");
            while(RS.next()) {
                carreras.add(new Carrera(RS.getInt(1),RS.getString(2)));
            }
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    //getter del arraylist de carreras
    public static ArrayList<Carrera> getCarreras() {
        return carreras;
    }
    //configura la conexion
    public static void setConexion(Connection conexion) {
        Carrera.conexion = conexion;
    }

    public int getId_carrera() {
        return id_carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        try{
            PreparedStatement consulta = conexion.prepareStatement("UPDATE carreras SET nombre_carrera = ? WHERE id_carrera = ?");
            consulta.setString(1,nombre);
            consulta.setInt(2,id_carrera);
            consulta.executeUpdate();
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.nombre = nombre;
    }

    public void cargarDatosCarrera(){
        try {
            if(id_carrera == -1){
                PreparedStatement consulta = conexion.prepareStatement("INSERT INTO `carreras`(`nombre_carrera`) VALUES (?)",Statement.RETURN_GENERATED_KEYS);
                consulta.setString(1,nombre);
                consulta.executeUpdate();
                ResultSet RS = consulta.getGeneratedKeys();
                carreras.add(this);
                while(RS.next()){
                    id_carrera = RS.getInt(1);
                }

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void borrarCarrera(){
        try{
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM `carreras` WHERE id_carrera = ?");
            consulta.setInt(1,id_carrera);
            consulta.executeUpdate();
            consulta.close();
            carreras.remove(this);
        }catch (SQLException e){
            e.printStackTrace();
        }
        carreras.remove(this);
    }

    @Override
    public String toString() {
        return nombre;
    }
}
