package Objetos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Reserva {
    
    private int id_reserva;
    private Usuario usuario;
    private Salon salon;
    private String fechaSalon;
    private Carrera carrera;
    private Profesor profesor;

    public Reserva(int id_reserva, Usuario usuario, Salon salon, String fechaSalon, Carrera carrera,
            Profesor profesor) {
        this.id_reserva = id_reserva;
        this.usuario = usuario;
        this.salon = salon;
        this.fechaSalon = fechaSalon;
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

    public void setUsuario(Connection con, Usuario usuario) {
        try{
            PreparedStatement consulta = con.prepareStatement("UPDATE reservas SET usuario = ? WHERE id_reservas = ?");
            //consulta.setInt(1,usuario.getId_usuario());
            consulta.setInt(2,id_reserva);
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.usuario = usuario;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Connection con, Salon salon) {
        try{
            PreparedStatement consulta = con.prepareStatement("UPDATE reservas SET salon = ? WHERE id_reservas = ?");
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

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Connection con, Carrera carrera) {
        try{
            PreparedStatement consulta = con.prepareStatement("UPDATE reservas SET carrera = ? WHERE id_reservas = ?");
            consulta.setInt(1,carrera.getId_carrera());
            consulta.setInt(2,id_reserva);
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.carrera = carrera;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Connection con, Profesor profesor) {
        try{
            PreparedStatement consulta = con.prepareStatement("UPDATE reservas SET profesor = ? WHERE id_reservas = ?");
            consulta.setString(1,profesor.getNombre()+" "+profesor.getApellido());
            consulta.setInt(2,id_reserva);
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.profesor = profesor;
    }

    

    



}
