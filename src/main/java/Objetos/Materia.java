package Objetos;

public class Materia {
    private final Integer ID_Materia;
    private final String Nombre;

    public Materia(Integer ID_Materia, String nombre) {
        this.ID_Materia = ID_Materia;
        Nombre = nombre;
    }

    public Integer getID_Materia() {
        return ID_Materia;
    }

    public String getNombre() {
        return Nombre;
    }
}
