package Objetos;

public class Alumno extends Persona {
    private final Integer ID_Alumno;
    private final String carrera;

    public Alumno(Integer ID_Persona, String nombre, String apellido, String telefono, Integer ID_Alumno, String carrera) {
        super(ID_Persona, nombre, apellido, telefono);
        this.ID_Alumno = ID_Alumno;
        this.carrera = carrera;
    }

    public Integer getID_Alumno() {
        return ID_Alumno;
    }

    public String getCarrera() {
        return carrera;
    }
}
