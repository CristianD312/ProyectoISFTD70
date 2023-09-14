package Pantallas;

import Objetos.Profesor;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class TablaProfesores extends AbstractTableModel {

    ArrayList<Profesor> profesores;
    String[] columnas = {"DNI","Nombre","Apellido","Carrera"};

    public TablaProfesores(ArrayList<Profesor> profesores) {
        this.profesores = profesores;
    }
    @Override
    public int getRowCount(){
        return profesores.size();
    }
    @Override
    public int getColumnCount(){
        return columnas.length;
    }
    @Override
    public String getColumnName(int columna){
        return columnas[columna];
    }
    @Override
    public Object getValueAt(int numeroFila,int numeroColumna){
        Profesor profesor = profesores.get(numeroFila);
        switch (numeroColumna) {
            case 0:
                return profesor.getDni();
            case 1:
                return profesor.getNombre();
            case 2:
                return profesor.getApellido();
            case 3:
                return profesor.getCarrera().getNombre();
            default:
                return null;
        }
    }
    public Profesor getObjectAt(int index){
        return profesores.get(index);
    }

}
