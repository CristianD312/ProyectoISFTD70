package Objetos;

public class Profesor extends Persona{
    private final Integer ID_Profesor;
    private final String Materia;

    public Profesor(Integer ID_Persona, String nombre, String apellido, String telefono, Integer ID_Profesor, String materia) {
        super(ID_Persona, nombre, apellido, telefono);
        this.ID_Profesor = ID_Profesor;
        Materia = materia;
    }

    public Integer getID_Profesor() {
        return ID_Profesor;
    }

    public String getMateria() {
        return Materia;
    }
}
