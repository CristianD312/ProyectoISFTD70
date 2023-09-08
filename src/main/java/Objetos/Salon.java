package Objetos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Salon {
    private int id_salon;
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

    public void setTamano(Connection con, boolean tamano) {
        try{
            PreparedStatement consulta = con.prepareStatement("UPDATE salones SET tamaño = ? WHERE id_salon = ?");
            consulta.setBoolean(1,tamano);
            consulta.setInt(2,id_salon);
            consulta.close();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

        this.tamano = tamano;
    }

    public void setProyector(Connection con, boolean proyector) {
        try{
            PreparedStatement consulta = con.prepareStatement("UPDATE accesorios SET proyector = ? WHERE salon = ?");
            consulta.setBoolean(1,proyector);
            consulta.setInt(2,id_salon);
            consulta.close();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.proyector = proyector;
    }

    public void setTV(Connection con, boolean TV) {
        try{
            PreparedStatement consulta = con.prepareStatement("UPDATE accesorios SET tv = ? WHERE salon = ?");
            consulta.setBoolean(1,TV);
            consulta.setInt(2,id_salon);
            consulta.close();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.TV = TV;
    }

    public void setCableVGA(Connection con, boolean cableVGA) {
        try{
            PreparedStatement consulta = con.prepareStatement("UPDATE accesorios SET cable_vga = ? WHERE salon = ?");
            consulta.setBoolean(1,cableVGA);
            consulta.setInt(2,id_salon);
            consulta.close();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.cableVGA = cableVGA;
    }

    public void setCableHDMI(Connection con, boolean cableHDMI) {
        try{
            PreparedStatement consulta = con.prepareStatement("UPDATE accesorios SET cable_hdmi = ? WHERE salon = ?");
            consulta.setBoolean(1,cableHDMI);
            consulta.setInt(2,id_salon);
            consulta.close();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.cableHDMI = cableHDMI;
    }

    public void setInterlock220V(Connection con,boolean interlock220V) {
        try{
            PreparedStatement consulta = con.prepareStatement("UPDATE accesorios SET cable_interlock220v = ? WHERE salon = ?");
            consulta.setBoolean(1,interlock220V);
            consulta.setInt(2,id_salon);
            consulta.close();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.interlock220V = interlock220V;
    }

    public void setCableAudio(Connection con, boolean cableAudio) {
        try{
            PreparedStatement consulta = con.prepareStatement("UPDATE accesorios SET cable_audio = ? WHERE salon = ?");
            consulta.setBoolean(1,cableAudio);
            consulta.setInt(2,id_salon);
            consulta.close();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.cableAudio = cableAudio;
    }

    public void setConversor(Connection con, boolean conversor) {
        try{
            PreparedStatement consulta = con.prepareStatement("UPDATE accesorios SET conversor_señal = ? WHERE salon = ?");
            consulta.setBoolean(1,conversor);
            consulta.setInt(2,id_salon);
            consulta.close();
            con.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
        this.conversor = conversor;
    }
}
