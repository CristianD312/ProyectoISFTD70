package Objetos;


import Logica.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class Profesor {
    //elemento estatico que guarda todas las instancias de la clase:
    private static ArrayList<Profesor> profesores = new ArrayList<>();
    //Elemento estatico que guarda la conexion
    private static Connection conexion;

    private Integer dni;
    private String nombre;
    private String apellido;
    private Carrera carrera;
    public Profesor(Integer dni, String nombre, String apellido, Carrera carrera) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
    }
    //Clase estatica que carga todos los profesores de la base de datos en el arraylist "profesores"
    public static void cargarDatos(){
        setConexion();
        try {
            profesores.clear();
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
            conexion.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    //getter de el arraylist profesores
    public static ArrayList<Profesor> getProfesores(){
        return profesores;
    }
    //configura la conexion
    private static void setConexion(){
        conexion = Conexion.getConexion();
    }
    //Permite cargar profesores nuevos
    public static void addProfesor(Profesor profesor){
        profesores.add(profesor);
    }
    //getters de el objeto
    public Integer getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Carrera getCarrera() {
        return carrera;
    }
    //setters del objeto que se sincronizan con la base de datos
    public void setDni(Integer dni) {
        setConexion();
        try{
            PreparedStatement consulta = conexion.prepareStatement("UPDATE profesores SET dni = ? where dni = ?");
            consulta.setInt(1,dni);
            consulta.setInt(2,this.dni);
            consulta.executeUpdate();
            consulta.close();
            conexion.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.dni = dni;
    }

    public void setNombre( String nombre) {
        setConexion();
        try{
            PreparedStatement consulta = conexion.prepareStatement("UPDATE profesores SET nombre = ? where dni = ?");
            consulta.setString(1,nombre);
            consulta.setInt(2,dni);
            consulta.executeUpdate();
            consulta.close();
            conexion.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        setConexion();
        try{
            PreparedStatement consulta = conexion.prepareStatement("UPDATE profesores SET Apellido = ? where dni = ?");
            consulta.setString(1,apellido);
            consulta.setInt(2,dni);
            consulta.executeUpdate();
            consulta.close();
            conexion.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.apellido = apellido;
    }

    public void setCarrera(Carrera carrera) {
        setConexion();
        try{
            PreparedStatement consulta = conexion.prepareStatement("UPDATE profesores SET fk_id_carrera = ? where dni = ?");
            consulta.setInt(1, carrera.getId_carrera());
            consulta.setInt(2,dni);
            consulta.executeUpdate();
            consulta.close();
            conexion.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.carrera = carrera;
    }
    //en caso de que el profesor no exista en la base de datos este metodo lo carga
    public void cargarDatosProfesor(){
        setConexion();
        try {
            PreparedStatement consultaExistencia = conexion.prepareStatement("SELECT EXISTS (SELECT 1 FROM profesores WHERE dni = ?)");
            consultaExistencia.setInt(1,dni);
            int bol = 0;
             ResultSet RS = consultaExistencia.executeQuery();
             while(RS.next()){
                 bol =RS.getInt(1);
             }
            if(bol != 1){
                PreparedStatement cargaDeDatos = conexion.prepareStatement("INSERT INTO `profesores`(`dni`, `nombre`, `Apellido`, `fk_id_carrera`) VALUES (?,?,?,?)");
                cargaDeDatos.setInt(1,dni);
                cargaDeDatos.setString(2,nombre);
                cargaDeDatos.setString(3,apellido);
                cargaDeDatos.setInt(4,carrera.getId_carrera());
                cargaDeDatos.executeUpdate();
                cargaDeDatos.close();
                profesores.add(this);
            }
            consultaExistencia.close();
            conexion.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void borrarProfesor(){
        setConexion();
        try {
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM `profesores` WHERE dni = ?");
            consulta.setInt(1,dni);
            consulta.executeUpdate();
            consulta.close();
            profesores.remove(this);
            conexion.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profesor profesor = (Profesor) o;
        return Objects.equals(dni, profesor.dni);
    }


    @Override
    public String toString() {
        return apellido+", "+nombre;
    }
}
