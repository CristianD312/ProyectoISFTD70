/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;


public class ComboBoxItemProfes {
    
    private int dni;
    private String nombresProfes;
    private String apellidosProfes;

    public ComboBoxItemProfes(int dni, String nombresProfes, String apellidosProfes) {
        this.dni = dni;
        this.nombresProfes = nombresProfes;
        this.apellidosProfes = apellidosProfes;
    }
    
    public int getDni(){
        return dni;
    }
    
    @Override
    public String toString() {
        return nombresProfes+" "+apellidosProfes;
    }
    
}
