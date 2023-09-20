
package Logica;

public class ComboBoxItemSalones {
    
    private int id;
    private String nombre;

    public ComboBoxItemSalones(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return id+"- "+nombre;
    }
}

