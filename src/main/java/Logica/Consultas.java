package logica;

import Objetos.Alumno;
import Objetos.Carrera;
import Objetos.Materia;
import Objetos.Profesor;

import java.sql.*;
import java.util.ArrayList;

public class Consultas {

    String URL = "jdbc:mysql://localhost:3306/Escuela";
    String USR = "root";
    String PSSWD = "";
    Connection conexion;
    public Consultas(){
        try {
            this.conexion = DriverManager.getConnection(URL, USR, PSSWD);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public Consultas(String URL, String user, String password){
        this.URL = URL;
        USR = user;
        PSSWD = password;
        this.conectar();
    }
    private void conectar(){

    }

    private int cargarPersona(String nombre, String apellido,String telefono){
        int claveGenerada = 0;
        try {
            PreparedStatement consulta = conexion.prepareStatement("INSERT INTO `Personas`(`ID_Persona`,`Nombre`, `Apellido`, `Telefono`) VALUES (NULL,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            consulta.setString(1,nombre);
            consulta.setString(2,apellido);
            consulta.setString(3, telefono);
            consulta.executeUpdate();
            ResultSet clavesGeneradas = consulta.getGeneratedKeys();
            while(clavesGeneradas.next()){
                claveGenerada=clavesGeneradas.getInt(1);
            }
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return claveGenerada;
    }

    public void cargarAlumno (int carrera, String nombre, String apellido,String telefono){
        int ultima = this.cargarPersona(nombre, apellido, telefono);
        try {
            PreparedStatement consulta = conexion.prepareStatement("INSERT INTO `Alumnos`(`ID_Alumno`, `ID_Persona`, `Carrera`) VALUES (NULL,?,?)");
            consulta.setInt(1,ultima);
            consulta.setInt(2,carrera);
            consulta.executeUpdate();
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void cargarProfesor(int materia,String nombre, String apellido,String telefono) {
        int ultima = this.cargarPersona(nombre, apellido, telefono);
        try {
            PreparedStatement consulta = conexion.prepareStatement("INSERT INTO `Profesores`(`ID_Profesor`, `ID_Persona`, `Materia`) VALUES (NULL,?,?)");
            consulta.setInt(1, ultima);
            consulta.setInt(2, materia);
            consulta.executeUpdate();
            consulta.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Profesor> consultarProfesores(){
        ArrayList<Profesor> profesores = new ArrayList<>();
        try {
            Statement consulta = conexion.createStatement();
            ResultSet profesor = consulta.executeQuery("SELECT Profesores.ID_Profesor,(SELECT Materias.Nombre_Materia FROM Materias WHERE Profesores.Materia = Materias.ID_Materia), Personas.* FROM Profesores INNER JOIN Personas ON Profesores.ID_Persona = Personas.ID_Persona;");

            while(profesor.next()){
                Integer ID_Profesor = profesor.getInt(1);
                String Materia = profesor.getString(2);
                Integer ID_Persona = profesor.getInt(3);
                String Nombre = profesor.getString(4);
                String Apellido = profesor.getString(5);
                String Telefono = profesor.getString(6);

                profesores.add(new Profesor(ID_Persona,Nombre,Apellido,Telefono,ID_Profesor,Materia));
            }
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return profesores;
    }
    public ArrayList<Materia> consultarMaterias(){
        ArrayList<Materia> materias = new ArrayList<>();
       try{
        Statement consulta = conexion.createStatement();
        ResultSet materia = consulta.executeQuery("SELECT * FROM Materias");

        while(materia.next()){
            Integer ID_Materia = materia.getInt(1);
            String nombreMateria = materia.getString(2);
            materias.add(new Materia(ID_Materia,nombreMateria));
        }
        consulta.close();
    }catch (SQLException e){
        e.printStackTrace();
    }
        System.out.println("Funca las materias");
        return materias;
    }
    public ArrayList<Carrera> consultarCarreras(){
        ArrayList<Carrera>carreras = new ArrayList<>();
        try{
            Statement consulta = conexion.createStatement();
            ResultSet materia = consulta.executeQuery("SELECT * FROM Carrera");

            while(materia.next()){
                Integer ID_Carrera = materia.getInt(1);
                String Nombre_Carrera = materia.getString(2);
                carreras.add(new Carrera(ID_Carrera,Nombre_Carrera));
            }
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return carreras;
    }

    public ArrayList<Alumno> consultarAlumnos(){
        ArrayList<Alumno> alumnos = new ArrayList<>();
        try {
            Statement consulta = conexion.createStatement();
            ResultSet alumno = consulta.executeQuery("SELECT Alumnos.ID_Alumno,(SELECT Carrera.Nombre_Carrera FROM Carrera WHERE Alumnos.Carrera = Carrera.ID_Carrera), Personas.* FROM Alumnos INNER JOIN Personas ON Alumnos.ID_Persona = Personas.ID_Persona");

            while(alumno.next()){
                Integer ID_Alumno = alumno.getInt(1);
                String Carrera = alumno.getString(2);
                Integer ID_Persona = alumno.getInt(3);
                String Nombre = alumno.getString(4);
                String Apellido = alumno.getString(5);
                String Telefono = alumno.getString(6);

                alumnos.add(new Alumno(ID_Persona,Nombre,Apellido,Telefono, ID_Alumno,Carrera));
            }
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return alumnos;
    }

    public void cambiarNombre(int ID_Persona, String nombreNuevo){
        try {
            PreparedStatement consulta = conexion.prepareStatement("UPDATE `Personas` SET `Nombre`=? WHERE ID_Persona = ?");
            consulta.setString(1,nombreNuevo);
            consulta.setInt(2,ID_Persona);
            consulta.executeUpdate();
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void cambiarApellido(int ID_Persona, String apellidoNuevo){
        try {
            PreparedStatement consulta = conexion.prepareStatement("UPDATE `Personas` SET `Apellido`=? WHERE ID_Persona = ?");
            consulta.setString(1,apellidoNuevo);
            consulta.setInt(2,ID_Persona);
            consulta.executeUpdate();
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void cambiarTelefono(int ID_Persona, String telefonoNuevo){
        try {
            PreparedStatement consulta = conexion.prepareStatement("UPDATE `Personas` SET `Telefono`=? WHERE ID_Persona = ?");
            consulta.setString(1,telefonoNuevo);
            consulta.setInt(2,ID_Persona);
            consulta.executeUpdate();
            consulta.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
