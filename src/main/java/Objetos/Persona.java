package Objetos;

public abstract class Persona {
    private final Integer ID_Persona;
    private final String nombre;
    private final String apellido;
    private final String telefono;

    public Persona(Integer ID_Persona, String nombre, String apellido, String telefono) {
        this.ID_Persona = ID_Persona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public Integer getID_Persona() {
        return ID_Persona;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }
}
