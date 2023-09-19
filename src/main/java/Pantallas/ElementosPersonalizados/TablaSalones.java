package Pantallas.ElementosPersonalizados;

import Objetos.Salon;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TablaSalones extends AbstractTableModel {

    ArrayList<Salon> salones;
    String[] columnas = {"ID salon", "Nombre", "Tamaño", "Proyector", "Televisor", "Cable HDMI" ,"Cable VGA" ,"Conversor de señal" ,"Cable de audio","Cable Interlock"};

    public TablaSalones(ArrayList<Salon> salones) {
        this.salones = salones;
    }

    @Override
    public int getRowCount() {
        return salones.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int columna) {
        return columnas[columna];
    }

    @Override
    public Object getValueAt(int numeroFila, int numeroColumna) {
        Salon salon = salones.get(numeroFila);
        switch (numeroColumna) {
            case 0:
                return salon.getId_salon();
            case 1:
                return  salon.getNombre();
            case 2:
                return salon.getTamano();
            case 3:
                if(salon.isProyector()){return "Si";}
                return "No";
            case 4:
                if(salon.isTV()){return "Si";}
                return "No";
            case 5:
                if(salon.isCableHDMI()){return "Si";}
                return "No";
            case 6:
                if(salon.isCableVGA()){return "Si";}
                return "No";
            case 7:
                if(salon.isConversor()){return "Si";}
                return "No";
            case 8:
                if(salon.isCableAudio()){return "Si";}
                return "No";
            case 9:
                if(salon.isInterlock220V()){return "Si";}
                return "No";
            default:
                return null;
        }
    }

    public Salon getObjectAt(int index) {
        return salones.get(index);
    }
}