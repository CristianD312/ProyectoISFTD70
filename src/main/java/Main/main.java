/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;

import Pantallas.PantallaReserva;
import logica.Conexion;

/**
 *
 * @author dario
 */
public class main {

    public static void main(String[] args) {
        Conexion conect = new Conexion(null);
        conect.conectar(); 
        try {
            PantallaReserva reservar = new PantallaReserva();
            reservar.setVisible(true);
            reservar.setLocationRelativeTo(null);
        } catch (Exception e) {
        }
        
    }
}
