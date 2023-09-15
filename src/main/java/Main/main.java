/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;

import Objetos.Profesor;

import java.util.ArrayList;

/**
 *
 * @author dario
 */
public class main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Profesor.cargarDatos();
        ArrayList<Profesor> profes = Profesor.getProfesores();
    }
}
