package Objetos;

import Logica.ComboBoxItemSalones;
import Logica.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Salon {
    //elemento estatico que guarda todas las instacias de salon:
    private static ArrayList<Salon> salones = new ArrayList<>();
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

    public Salon(){}
    
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
        cargarSalon();
    }
    //carga todos los salones en la base de datos en el arraylist "salones"
    public static void cargarDatos(){
        try{
            setConexion();
            salones.clear();
            ResultSet RS = conexion.prepareStatement("SELECT * FROM salones INNER JOIN accesorios ON fk_salon = salones.id_salon").executeQuery();
            while (RS.next()){
                salones.add(new Salon(RS.getInt(1),RS.getString(2), RS.getString(3), RS.getString(4),RS.getBoolean(6),RS.getBoolean(7),RS.getBoolean(8),RS.getBoolean(9),RS.getBoolean(10),RS.getBoolean(11),RS.getBoolean(12)));
            }
            conexion.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    //devuelve los valores del arraylist salones
    public static ArrayList<Salon> getSalones() {
        return salones;
    }
    //configura la conexion
    private static void setConexion(){
        conexion = Conexion.getConexion();
    }

    //Getters
    
    public void setId_salon(int id_salon) {
        this.id_salon = id_salon;
    }
    
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
        setConexion();
        try{
            PreparedStatement consulta = conexion.prepareStatement("UPDATE salones SET Tamaño = ? WHERE id_salon = ?");
            consulta.setString(1,tamano);
            consulta.setInt(2,id_salon);
            consulta.executeUpdate();
            consulta.close();
            conexion.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        this.tamano = tamano;
    }

    public void setProyector(boolean proyector) {
        setConexion();
        try{
            PreparedStatement consulta = conexion.prepareStatement("UPDATE accesorios SET proyector = ? WHERE fk_salon = ?");
            consulta.setBoolean(1,proyector);
            consulta.setInt(2,id_salon);
            consulta.executeUpdate();
            consulta.close();
            conexion.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.proyector = proyector;
    }

    public void setTV( boolean TV) {
        setConexion();
        try{
            PreparedStatement consulta = conexion.prepareStatement("UPDATE accesorios SET tv = ? WHERE fk_salon = ?");
            consulta.setBoolean(1,TV);
            consulta.setInt(2,id_salon);
            consulta.executeUpdate();
            consulta.close();
            conexion.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.TV = TV;
    }

    public void setCableVGA(boolean cableVGA) {
        setConexion();
        try{
            PreparedStatement consulta = conexion.prepareStatement("UPDATE accesorios SET vga = ? WHERE fk_salon = ?");
            consulta.setBoolean(1,cableVGA);
            consulta.setInt(2,id_salon);
            consulta.executeUpdate();
            consulta.close();
            conexion.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.cableVGA = cableVGA;
    }

    public void setCableHDMI(boolean cableHDMI) {
        setConexion();
        try{
            PreparedStatement consulta = conexion.prepareStatement("UPDATE accesorios SET hdmi = ? WHERE fk_salon = ?");
            consulta.setBoolean(1,cableHDMI);
            consulta.setInt(2,id_salon);
            consulta.executeUpdate();
            consulta.close();
            conexion.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.cableHDMI = cableHDMI;
    }

    public void setInterlock220V(boolean interlock220V) {
        setConexion();
        try{
            PreparedStatement consulta = conexion.prepareStatement("UPDATE accesorios SET interlock = ? WHERE fk_salon = ?");
            consulta.setBoolean(1,interlock220V);
            consulta.setInt(2,id_salon);
            consulta.executeUpdate();
            consulta.close();
            conexion.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.interlock220V = interlock220V;
    }
    public void setCableAudio(boolean cableAudio) {
        setConexion();
        try{
            PreparedStatement consulta = conexion.prepareStatement("UPDATE accesorios SET audio = ? WHERE fk_salon = ?");
            consulta.setBoolean(1,cableAudio);
            consulta.setInt(2,id_salon);
            consulta.executeUpdate();
            consulta.close();
            conexion.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.cableAudio = cableAudio;
    }
    public void setConversor(boolean conversor) {
        setConexion();
        try{
            PreparedStatement consulta = conexion.prepareStatement("UPDATE accesorios SET adp_conversor = ? WHERE fk_salon = ?");
            consulta.setBoolean(1,conversor);
            consulta.setInt(2,id_salon);
            consulta.executeUpdate();
            consulta.close();
            conexion.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.conversor = conversor;
    }

    public void setNombre(String nombre) {
        setConexion();
        try{
            PreparedStatement consulta = conexion.prepareStatement("UPDATE salones SET nombre_salon = ? WHERE id_salon = ?");
            consulta.setString(1,nombre);
            consulta.setInt(2,id_salon);
            consulta.executeUpdate();
            consulta.close();
            conexion.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.nombre = nombre;
    }

    public void setObservaciones(String observaciones) {
        setConexion();
        try{
            PreparedStatement consulta = conexion.prepareStatement("UPDATE salones SET observaciones = ? WHERE id_salon = ?");
            consulta.setString(1,observaciones);
            consulta.setInt(2,id_salon);
            consulta.executeUpdate();
            consulta.close();
            conexion.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.observaciones = observaciones;
    }

    //en caso de que el salon no exista en la base de datos (requiere que se le cargue el valor -1 en id_salon) lo carga
    public void cargarSalon(){
        setConexion();
        try {
            if(id_salon.equals(-1)){
                PreparedStatement cargaDeDatos = conexion.prepareStatement("INSERT INTO `salones`(`nombre_salon`, `tamaño`, `observaciones`) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
                cargaDeDatos.setString(1,nombre);
                cargaDeDatos.setString(2,tamano);
                cargaDeDatos.setString(3,observaciones);
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
                salones.add(this);
                conexion.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void borrarSalon(){ //tentativo, no implementado
        setConexion();
        try{
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM `salones` WHERE id_salon = ?; DELETE FROM `accesorios` WHERE fk_salon = ?");
            consulta.setInt(1,id_salon);
            consulta.setInt(2,id_salon);
            consulta.executeUpdate();
            consulta.close();
            conexion.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salon salon = (Salon) o;
        return Objects.equals(id_salon, salon.id_salon);
    }


    @Override
    public String toString() {
        return nombre;
    }
    
    public void cargarSalonesBOX(JComboBox salonesBox){
        Conexion conect = new Conexion();
        conect.conectar(); 
        try {
            String sql = "SELECT id_salon, nombre_salon FROM `salones`";
            java.sql.Statement statement = conect.getConexion().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                int numSalones = resultSet.getInt("id_salon");
                String nombreSalon = resultSet.getString("nombre_salon");
                //String opciones = numSalones + " " + nombreSalon;
                //salonesBox.addItem(opciones);
                salonesBox.addItem(new ComboBoxItemSalones(numSalones, nombreSalon));
            }
            statement.close();
            resultSet.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los salones: "+e.toString());
        }
        
    }
    
    public static void guardarObservacion (Salon observa){
        Conexion conect = new Conexion();
        conect.conectar(); 
        try {
            String sql ="UPDATE `salones` SET `observaciones`= ? WHERE `id_salon` = ?";
            PreparedStatement statement = conect.getConexion().prepareStatement(sql);
            statement.setString(1, observa.getObservaciones());
            statement.setInt(2, observa.getId_salon());
            statement.executeUpdate();
            statement.close();
            JOptionPane.showMessageDialog(null, "Observacion cargada con exito");
            statement.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la observacion: "+e.toString());
        }
    }
    
    public void mostrarObservaciones(int numSalon, JTextField observacionEscrita){ 
        Conexion conect = new Conexion();
        conect.conectar(); 
        try {
            String sql = "SELECT `id_salon`, `nombre_salon`, `tamaño`, `observaciones` FROM `salones` WHERE `id_salon` ="+numSalon;
            java.sql.Statement statement = conect.getConexion().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                String observacion = resultSet.getString("observaciones");
                observacionEscrita.setText(observacion);
            }
            statement.close();
            resultSet.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la observacion: "+e.toString());
        }
    }
    
    public void mostrarAccesorios(int numSalon, JTable tablaAccesorios, JTextField tamañoText){
        DefaultTableModel tAccesorios = new DefaultTableModel();
        tAccesorios.addColumn("Accesorios");
        tAccesorios.addColumn("Si/No");
        //tAccesorios.addColumn("No");
        tablaAccesorios.setModel(tAccesorios);
        
        ArrayList<Object> datosBooleanosProyector = new ArrayList<>();
        ArrayList<Object> datosBooleanosTV = new ArrayList<>();
        ArrayList<Object> datosBooleanosVGA = new ArrayList<>();
        ArrayList<Object> datosBooleanosHDMI = new ArrayList<>();
        ArrayList<Object> datosBooleanosI220V = new ArrayList<>();
        ArrayList<Object> datosBooleanosAUDIO = new ArrayList<>();
        ArrayList<Object> datosBooleanosASEÑAL = new ArrayList<>();
        
        String verdadero = "Si";
        String falso = "No";
        
        Conexion conect = new Conexion();
        conect.conectar();
        try {
            String sql = "SELECT * FROM `accesorios` WHERE `fk_salon` ="+numSalon;
            java.sql.Statement statement = conect.getConexion().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                
                 datosBooleanosProyector.add("Proyector"); // Nombre del accesorio, puedes cambiarlo según tu base de datos
                 datosBooleanosProyector.add(resultSet.getInt("proyector") == 1 ? verdadero : falso); // 1 para "Si", 0 para "No"
                 
                 datosBooleanosTV.add("TV");
                 datosBooleanosTV.add(resultSet.getInt("tv") == 1 ? verdadero : falso);
                 
                 datosBooleanosVGA.add("Cable VGA");
                 datosBooleanosVGA.add(resultSet.getInt("vga") == 1 ? verdadero : falso);
                 
                 datosBooleanosHDMI.add("Cable HDMI");
                 datosBooleanosHDMI.add(resultSet.getInt("hdmi") == 1 ? verdadero : falso);
                 
                 datosBooleanosI220V.add("Cable Interlock 220V");
                 datosBooleanosI220V.add(resultSet.getInt("interlock") == 1 ? verdadero : falso);
                 
                 datosBooleanosAUDIO.add("Cable Audio");
                 datosBooleanosAUDIO.add(resultSet.getInt("audio") == 1 ? verdadero : falso);
                 
                 datosBooleanosASEÑAL.add("Adaptador de Señal");
                 datosBooleanosASEÑAL.add(resultSet.getInt("adp_conversor") == 1 ? verdadero : falso);
                
                tAccesorios.addRow(datosBooleanosProyector.toArray());
                tAccesorios.addRow(datosBooleanosTV.toArray());
                tAccesorios.addRow(datosBooleanosVGA.toArray());
                tAccesorios.addRow(datosBooleanosHDMI.toArray());
                tAccesorios.addRow(datosBooleanosI220V.toArray());
                tAccesorios.addRow(datosBooleanosAUDIO.toArray());
                tAccesorios.addRow(datosBooleanosASEÑAL.toArray());
            }
            statement.close();
            resultSet.close();
        } catch (Exception e) {
        }
        try {
            String sql = "SELECT `tamaño` FROM `salones` WHERE `id_salon` ="+numSalon+";";
            java.sql.Statement statement = conect.getConexion().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
               String tamaño = resultSet.getString("tamaño");
               tamañoText.setText(tamaño);
            }
            statement.close();
            resultSet.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar el tamaño del salon: "+e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
