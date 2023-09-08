package Objetos;

public class Carrera {
    private final Integer ID_Carrera;
    private final String Nombre_Carrera;

    public Carrera(Integer ID_Carrera, String nombre_Carrera) {
        this.ID_Carrera = ID_Carrera;
        Nombre_Carrera = nombre_Carrera;
    }

    public Integer getID_Carrera() {
        return ID_Carrera;
    }

    public String getNombre_Carrera() {
        return Nombre_Carrera;
    }
}
