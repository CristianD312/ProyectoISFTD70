/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;

import Pantallas.PantallaReserva;
import Pantallas.PantallaLogin;
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
            
            PantallaLogin login = new PantallaLogin();
            login.setVisible(true);
            login.setLocationRelativeTo(null);
        } catch (Exception e) {
        }
        
    }
}
