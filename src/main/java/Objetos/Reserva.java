package Objetos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import logica.Conexion;

public class Reserva {
    
    private int id_reserva;
    private Usuario usuario;
    private Salon salon;
    private String fechaSalon;
    private String horarioSalon;
    private Carrera carrera;
    private Profesor profesor;
    
    public Reserva (){}

    public Reserva(int id_reserva, Usuario usuario, Salon salon, String fechaSalon, String horarioSalon, Carrera carrera,
            Profesor profesor) {
        this.id_reserva = id_reserva;
        this.usuario = usuario;
        this.salon = salon;
        this.fechaSalon = fechaSalon;
        this.horarioSalon = horarioSalon;
        this.carrera = carrera;
        this.profesor = profesor;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Connection conn, Usuario usuario) {
        try{
            PreparedStatement consulta = conn.prepareStatement("UPDATE reservas SET usuario = ? WHERE id_reservas = ?");
            consulta.setInt(1,usuario.getId_usuario());
            consulta.setInt(2,id_reserva);
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.usuario = usuario;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon( Salon salon) {
        Conexion conect = new Conexion(null);
        conect.conectar(); 
        try{
            String sql = "UPDATE reservas SET salon = ? WHERE id_reservas = ?";
            PreparedStatement consulta = conect.getConn().prepareStatement(sql);
            consulta.setInt(1,salon.getId_salon());
            consulta.setInt(2,id_reserva);
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.salon = salon;
    }

    public String getFechaSalon() {
        return fechaSalon;
    }

    public void setFechaSalon(String fechaSalon) {
        this.fechaSalon = fechaSalon;
    }
    
    public String getHorarioSalon(){
        return horarioSalon;
    }
    
    public void setHorarioSalon(String horarioSalon){
         this.horarioSalon = horarioSalon;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        Conexion conect = new Conexion(null);
        conect.conectar();
        try{
            String sql = "UPDATE reservas SET carrera = ? WHERE id_reservas = ?";
            PreparedStatement consulta = conect.getConn().prepareStatement(sql);
            consulta.setString(1,carrera.getNombre());
            consulta.setInt(2,id_reserva);
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.carrera = carrera;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        Conexion conect = new Conexion(null);
        conect.conectar();
        try{
            String sql = "UPDATE reservas SET profesor = ? WHERE id_reservas = ?";
            PreparedStatement consulta = conect.getConn().prepareStatement(sql);
            consulta.setInt(1,profesor.getDni());
            consulta.setInt(2,id_reserva);
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.profesor = profesor;
    }

  public void crearReservas(Reserva reserva){
        Conexion conect = new Conexion(null);
        conect.conectar(); 
        try {
            String sql = "INSERT INTO `reservas`(`id_reserva`, `fk_usuario`, `fk_salon`, `fecha_reserva`, `horario`, `carrera`, `profesor`) VALUES (NULL, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conect.getConn().prepareStatement(sql);
            statement.setInt(1, 1);
            statement.setInt(2, reserva.getSalon().getId_salon());
            statement.setString(3, reserva.getFechaSalon());
            statement.setString(4, reserva.getHorarioSalon());
            statement.setInt(5, reserva.getCarrera().getId_carrera());
            statement.setInt(6, reserva.getProfesor().getDni());
            statement.executeUpdate();
            statement.close();
            JOptionPane.showMessageDialog(null, "Anduvo todo flama perro");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la reserva: "+e.toString());
        }
    }
    

    



}
