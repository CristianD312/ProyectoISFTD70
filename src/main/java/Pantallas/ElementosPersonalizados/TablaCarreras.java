package Pantallas.ElementosPersonalizados;

import Objetos.Carrera;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TablaCarreras extends AbstractTableModel {

    ArrayList<Carrera> carreras;
    String[] columnas = {"ID De Carrera", "Carrera"};

    public TablaCarreras(ArrayList<Carrera> carreras) {
        this.carreras = carreras;
    }

    @Override
    public int getRowCount() {
        return carreras.size();
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
        Carrera carrera = carreras.get(numeroFila);
        switch (numeroColumna) {
            case 0:
                return carrera.getId_carrera();
            case 1:
                return carrera.getNombre();
            default:
                return null;
        }
    }
}