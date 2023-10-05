/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Main;


import Logica.parametrosDeConfiguracion;
import Pantallas.PantallaLogin;
import Logica.Conexion;


public class main {

    public static void main(String[] args) {
        parametrosDeConfiguracion.cargarParametros();
        try {
            PantallaLogin login = new PantallaLogin();
            login.setVisible(true);
            login.setLocationRelativeTo(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}
