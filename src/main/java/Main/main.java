/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;

import Logica.Conexion;
import Logica.parametrosDeConfiguracion;
import Objetos.Carrera;
import Objetos.Profesor;
import Objetos.Salon;
import Pantallas.Configuracion.Configuracion;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author dario
 */
public class main {

    public static void main(String[] args) {
        //Carga los datos en el array interno de la clase
        Carrera.cargarDatos();
        Profesor.cargarDatos();
        Salon.cargarDatos();

        new Configuracion().setVisible(true);


    }
}
