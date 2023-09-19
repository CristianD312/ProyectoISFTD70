package Objetos;

import java.sql.*;
import java.util.ArrayList;

public class Salon {
    //elemento estatico que guarda todas las instacias de salon:
    private static ArrayList<Salon> salones = new ArrayList<Salon>();
    //Elemento estatico que guarda la conexion con la base de datos:
    private static Connection conexion;
    private Integer id_salon;
    private String tamano;
    private String nombre;
    private boolean proyector;
    private boolean TV;
    private boolean cableVGA;
    private boolean cableHDMI;
    private boolean interlock220V;
    private boolean cableAudio;
    private boolean conversor;
    private String observaciones;

    public Salon(int id_salon, String nombre ,String tamano, String observaciones, boolean interlock220V, boolean cableVGA, boolean cableHDMI, boolean cableAudio, boolean conversor, boolean TV, boolean proyector ) {
        this.id_salon = id_salon;
        this.tamano = tamano;
        this.proyector = proyector;
        this.TV = TV;
        this.cableVGA = cableVGA;
        this.cableHDMI = cableHDMI;
        this.interlock220V = interlock220V;
        this.cableAudio = cableAudio;
        this.conversor = conversor;
        this.nombre = nombre;
        this.observaciones = observaciones;
    }
    //carga todos los salones en la base de datos en el arraylist "salones"
    public static void cargarDatos(){
        try{
            salones.clear();
            ResultSet RS = conexion.prepareStatement("SELECT * FROM salones INNER JOIN accesorios ON fk_salon = salones.id_salon").executeQuery();
            while (RS.next()){
                salones.add(new Salon(RS.getInt(1),RS.getString(2), RS.getString(3), RS.getString(4),RS.getBoolean(6),RS.getBoolean(7),RS.getBoolean(8),RS.getBoolean(9),RS.getBoolean(10),RS.getBoolean(11),RS.getBoolean(12)));
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

    public String getTamano() {
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

    public String getNombre() {
        return nombre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    //setters que se sincronizan con la base de datos
    public void setTamano(String tamano) {
        try{
            PreparedStatement consulta = conexion.prepareStatement("UPDATE salones SET Tamaño = ? WHERE id_salon = ?");
            consulta.setString(1,tamano);
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

    public void setNombre(String nombre) {
        try{
            PreparedStatement consulta = conexion.prepareStatement("UPDATE salones SET nombre_salon = ? WHERE fk_salon = ?");
            consulta.setString(1,nombre);
            consulta.setInt(2,id_salon);
            consulta.executeUpdate();
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.nombre = nombre;
    }

    public void setObservaciones(String observaciones) {
        try{
            PreparedStatement consulta = conexion.prepareStatement("UPDATE salones SET observaciones = ? WHERE fk_salon = ?");
            consulta.setString(1,observaciones);
            consulta.setInt(2,id_salon);
            consulta.executeUpdate();
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.observaciones = observaciones;
    }

    //en caso de que el salon no exista en la base de datos (requiere que se le cargue el valor -1 en id_salon) lo carga
    public void cargarSalon(){
        try {
            if(id_salon.equals(-1)){
                PreparedStatement cargaDeDatos = conexion.prepareStatement("INSERT INTO `salones`(`nombre_salon`, `tamaño`, `observaciones`) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
                cargaDeDatos.setString(2,nombre);
                cargaDeDatos.setString(2,tamano);
                cargaDeDatos.setString(2,observaciones);
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
    public void borrarSalon(){
        try{
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM `salones` WHERE id_salon = ?; DELETE FROM `accesorios` WHERE fk_salon = ?");
            consulta.setInt(1,id_salon);
            consulta.setInt(2,id_salon);
            consulta.executeUpdate();
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return nombre;
    }
}
