/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;


import Pantallas.PantallaLogin;
import Logica.Conexion;


public class main {

    public static void main(String[] args) {
        Conexion conect = new Conexion();
        conect.conectar(); 
        try {
            PantallaLogin login = new PantallaLogin();
            login.setVisible(true);
            login.setLocationRelativeTo(null);
        } catch (Exception e) {
        }
        
    }
}
