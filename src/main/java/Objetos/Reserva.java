package Objetos;

import Pantallas.PantallaLogin;
import Pantallas.PantallaReserva;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import Logica.Conexion;

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

    public void setUsuario(Usuario usuario) {
        /*
        Connection conect = Conexion.getConexion();
        try{
            String sql = "UPDATE reservas SET usuario = ? WHERE id_reservas = ?";
            PreparedStatement consulta = conect.prepareStatement(sql);
            consulta.setInt(1,usuario.getId_usuario());
            consulta.setInt(2,id_reserva);
            consulta.executeUpdate();
            consulta.close();
            conect.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
         */
        this.usuario = usuario;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon( Salon salon) {
        /*
        Connection conect = Conexion.getConexion();
        try{
            String sql = "UPDATE reservas SET salon = ? WHERE id_reservas = ?";
            PreparedStatement consulta = conect.prepareStatement(sql);
            consulta.setInt(1,salon.getId_salon());
            consulta.setInt(2,id_reserva);
        }catch (SQLException e){
            e.printStackTrace();
        }
         */
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
        /*
        Connection conect = Conexion.getConexion();
        try{
            String sql = "UPDATE reservas SET carrera = ? WHERE id_reservas = ?";
            PreparedStatement consulta = conect.prepareStatement(sql);
            consulta.setString(1,carrera.getNombre());
            consulta.setInt(2,id_reserva);
        }catch (SQLException e){
            e.printStackTrace();
        }
         */
        this.carrera = carrera;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        /*
        Connection conect = Conexion.getConexion();
        try{
            String sql = "UPDATE reservas SET profesor = ? WHERE id_reservas = ?";
            PreparedStatement consulta = conect.prepareStatement(sql);
            consulta.setInt(1,profesor.getDni());
            consulta.setInt(2,id_reserva);
        }catch (SQLException e){
            e.printStackTrace();
        }
         */
        this.profesor = profesor;
    }

  public void crearReservas(Reserva reserva){
      Connection conect = Conexion.getConexion();
        try {
            String sql = "INSERT INTO `reservas`(`id_reserva`, `fk_usuario`, `fk_salon`, `fecha_reserva`, `horario`, `carrera`, `profesor`) VALUES (NULL, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conect.prepareStatement(sql);
            statement.setInt(1, reserva.getUsuario().getId_usuario());
            statement.setInt(2, reserva.getSalon().getId_salon());
            statement.setString(3, reserva.getFechaSalon());
            statement.setString(4, reserva.getHorarioSalon());
            statement.setInt(5, reserva.getCarrera().getId_carrera());
            statement.setInt(6, reserva.getProfesor().getDni());
            statement.executeUpdate();
            statement.close();
            conect.close();
            JOptionPane.showMessageDialog(null, "Reserva creada con exito");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la reserva: "+e.toString());
        }
    }
  
  public void mostrarReservas(JTable tablaReservas){
      DefaultTableModel tReservas = new DefaultTableModel();
      tReservas.addColumn("ID Reserva");
      tReservas.addColumn("Usuario");
      tReservas.addColumn("Salón");
      tReservas.addColumn("Fecha");
      tReservas.addColumn("Horario");
      tReservas.addColumn("Carrera");
      tReservas.addColumn("Profesor");
      tablaReservas.setModel(tReservas);
      
      TableRowSorter<DefaultTableModel> ordenarTabla = new TableRowSorter<>(tReservas);
      tablaReservas.setRowSorter(ordenarTabla);
      String [] datosReserva = new String[7];
      Connection conect = Conexion.getConexion();
      
      try {
        String sql = "SELECT reservas.id_reserva, usuarios.nombre, salones.id_salon, salones.nombre_salon, reservas.fecha_reserva, reservas.horario, carreras.nombre_carrera, profesores.nombre, profesores.apellido\n" +
        "FROM `reservas` \n" +
        "INNER JOIN usuarios ON reservas.fk_usuario=usuarios.ID_usuario\n" +
        "INNER JOIN salones ON reservas.fk_salon=salones.id_salon\n" +
        "INNER JOIN carreras ON reservas.carrera=carreras.id_carrera\n" +
        "INNER JOIN profesores ON reservas.profesor=profesores.dni;";
        PreparedStatement statement = conect.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
              datosReserva[0] = resultSet.getString(1);
              datosReserva[1] = resultSet.getString(2);
              datosReserva[2] = resultSet.getString(3)+"- "+resultSet.getString(4);
              datosReserva[3] = resultSet.getString(5);
              datosReserva[4] = resultSet.getString(6);
              datosReserva[5] = resultSet.getString(7);
              datosReserva[6] = resultSet.getString(8)+" "+resultSet.getString(9);
              tReservas.addRow(datosReserva);
          }
        resultSet.close();
        statement.close();
        conect.close();
        tablaReservas.setModel(tReservas);
      } catch (Exception e) {
          JOptionPane.showMessageDialog(null, "Error al mostrar las reservas correctamente: "+e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
  
    public void eliminarReservas(JTable tablaReservas){
         int filaSelecionada = tablaReservas.getSelectedRow();
         String conversionIdReserva = (String) tablaReservas.getValueAt(filaSelecionada, 0);
         int idReserva = Integer.parseInt(conversionIdReserva);
        Connection conect = Conexion.getConexion();
        try {
            String sql = "DELETE FROM `reservas` WHERE id_reserva = ?;";
            PreparedStatement statement = conect.prepareStatement(sql);
            statement.setInt(1, idReserva); 
            statement.executeUpdate();
            JOptionPane.showMessageDialog(null, "Reserva eliminada correctamente");
            statement.close();
            conect.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la reserva: "+e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
         
    }
    
    public static int compararReservas(String horarioElegido, String fechaElegida, int salonElegido){
        Connection conect = Conexion.getConexion();
        int reservar = 1; //donde 0 es no reservar
        try {
            String sql = "SELECT * FROM `reservas`";
            PreparedStatement statement = conect.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                String horarioComparar = resultSet.getString("horario");
                String diaComparar = resultSet.getString("fecha_reserva");
                int salonComparar = resultSet.getInt("fk_salon");
                //String salonComparar = resultSet.getString("salon")
                if((horarioComparar.equals(horarioElegido))&&(diaComparar.equals(fechaElegida))&&(salonComparar==salonElegido)){
                    JOptionPane.showMessageDialog(null, "El salón seleccionado, ya esta reservado en el dia y el horario que elegiste.", "Error de reservación", JOptionPane.ERROR_MESSAGE);
                    reservar = 0;
                }
            }
            resultSet.close();
            statement.close();
            conect.close();
            
        } catch (Exception e) {
        } return reservar;
    }
    
    
}