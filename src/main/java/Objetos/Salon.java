package Objetos;

import Logica.Conexion;

import java.sql.*;
import java.util.ArrayList;

public class Salon {
    //elemento estatico que guarda todas las instacias de salon:
    private static ArrayList<Salon> salones = new ArrayList<Salon>();
    //Elemento estatico que guarda la conexion con la base de datos:
    private static Connection conexion;
    private Integer id_salon;
    private boolean tamano;
    private boolean proyector;
    private boolean TV;
    private boolean cableVGA;
    private boolean cableHDMI;
    private boolean interlock220V;
    private boolean cableAudio;
    private boolean conversor;

    public Salon(int id_salon, boolean tamano, boolean proyector, boolean TV, boolean cableVGA, boolean cableHDMI, boolean interlock220V, boolean cableAudio, boolean conversor) {
        this.id_salon = id_salon;
        this.tamano = tamano;
        this.proyector = proyector;
        this.TV = TV;
        this.cableVGA = cableVGA;
        this.cableHDMI = cableHDMI;
        this.interlock220V = interlock220V;
        this.cableAudio = cableAudio;
        this.conversor = conversor;
    }
    //carga todos los salones en la base de datos en el arraylist "salones"
    public static void cargarDatos(){
        try{
            salones.clear();
            ResultSet RS = conexion.prepareStatement("SELECT * FROM salones INNER JOIN accesorios ON fk_salon = salones.id_salon").executeQuery();
            while (RS.next()){
                salones.add(new Salon(RS.getInt(1),RS.getBoolean(2),RS.getBoolean(10),RS.getBoolean(9),RS.getBoolean(5),RS.getBoolean(6),RS.getBoolean(4),RS.getBoolean(7),RS.getBoolean(8)));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    //devuelve los valores del arraylist salones
    public static ArrayList<Salon> getSalones() {
        return salones;
    }
    //configura la conexion
    public static void setConexion(Connection conexion) {
        Salon.conexion = conexion;
    }

    //Getters
    public int getId_salon() {
        return id_salon;
    }

    public boolean isTamano() {
        return tamano;
    }

    public boolean isProyector() {
        return proyector;
    }

    public boolean isTV() {
        return TV;
    }

    public boolean isCableVGA() {
        return cableVGA;
    }

    public boolean isCableHDMI() {
        return cableHDMI;
    }

    public boolean isInterlock220V() {
        return interlock220V;
    }

    public boolean isCableAudio() {
        return cableAudio;
    }

    public boolean isConversor() {
        return conversor;
    }

    //setters que se sincronizan con la base de datos
    public void setTamano(boolean tamano) {
        try{
            PreparedStatement consulta = conexion.prepareStatement("UPDATE salones SET Tamaño = ? WHERE id_salon = ?");
            consulta.setBoolean(1,tamano);
            consulta.setInt(2,id_salon);
            consulta.executeUpdate();
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        this.tamano = tamano;
    }

    public void setProyector(boolean proyector) {
        try{
            PreparedStatement consulta = conexion.prepareStatement("UPDATE accesorios SET proyector = ? WHERE fk_salon = ?");
            consulta.setBoolean(1,proyector);
            consulta.setInt(2,id_salon);
            consulta.executeUpdate();
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.proyector = proyector;
    }

    public void setTV( boolean TV) {
        try{
            PreparedStatement consulta = conexion.prepareStatement("UPDATE accesorios SET tv = ? WHERE fk_salon = ?");
            consulta.setBoolean(1,TV);
            consulta.setInt(2,id_salon);
            consulta.executeUpdate();
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.TV = TV;
    }

    public void setCableVGA(boolean cableVGA) {
        try{
            PreparedStatement consulta = conexion.prepareStatement("UPDATE accesorios SET vga = ? WHERE fk_salon = ?");
            consulta.setBoolean(1,cableVGA);
            consulta.setInt(2,id_salon);
            consulta.executeUpdate();
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.cableVGA = cableVGA;
    }

    public void setCableHDMI(boolean cableHDMI) {
        try{
            PreparedStatement consulta = conexion.prepareStatement("UPDATE accesorios SET hdmi = ? WHERE fk_salon = ?");
            consulta.setBoolean(1,cableHDMI);
            consulta.setInt(2,id_salon);
            consulta.executeUpdate();
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.cableHDMI = cableHDMI;
    }

    public void setInterlock220V(boolean interlock220V) {
        try{
            PreparedStatement consulta = conexion.prepareStatement("UPDATE accesorios SET interlock = ? WHERE fk_salon = ?");
            consulta.setBoolean(1,interlock220V);
            consulta.setInt(2,id_salon);
            consulta.executeUpdate();
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.interlock220V = interlock220V;
    }
    public void setCableAudio(boolean cableAudio) {
        try{
            PreparedStatement consulta = conexion.prepareStatement("UPDATE accesorios SET audio = ? WHERE fk_salon = ?");
            consulta.setBoolean(1,cableAudio);
            consulta.setInt(2,id_salon);
            consulta.executeUpdate();
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.cableAudio = cableAudio;
    }
    public void setConversor(boolean conversor) {
        try{
            PreparedStatement consulta = conexion.prepareStatement("UPDATE accesorios SET adp_conversor = ? WHERE fk_salon = ?");
            consulta.setBoolean(1,conversor);
            consulta.setInt(2,id_salon);
            consulta.executeUpdate();
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.conversor = conversor;
    }
    //en caso de que el salon no exista en la base de datos (requiere que se le cargue el valor -1 en id_salon) lo carga
    public void cargarSalon(){
        try {
            if(id_salon.equals(-1)){
                PreparedStatement cargaDeDatos = conexion.prepareStatement("INSERT INTO `salones`(`Tamaño`) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
                cargaDeDatos.setBoolean(1,tamano);
                cargaDeDatos.executeUpdate();
                ResultSet RS = cargaDeDatos.getGeneratedKeys();
                while(RS.next()) {
                    id_salon = RS.getInt(1);
                }
                cargaDeDatos.close();
                cargaDeDatos = conexion.prepareStatement("INSERT INTO `accesorios`(`fk_salon`, `interlock`, `vga`, `hdmi`, `audio`, `adp_conversor`, `tv`, `proyector`) VALUES (?,?,?,?,?,?,?,?)");
                cargaDeDatos.setInt(1,id_salon);
                cargaDeDatos.setBoolean(2,interlock220V);
                cargaDeDatos.setBoolean(3,cableVGA);
                cargaDeDatos.setBoolean(4,cableHDMI);
                cargaDeDatos.setBoolean(5,cableAudio);
                cargaDeDatos.setBoolean(6,conversor);
                cargaDeDatos.setBoolean(7,TV);
                cargaDeDatos.setBoolean(8,proyector);
                cargaDeDatos.executeUpdate();
                cargaDeDatos.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
