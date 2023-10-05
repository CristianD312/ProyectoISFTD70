package Logica;

import javax.swing.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class Conexion {
    private static String URL;
    private static String PORT;
    private static String BD;
    private static String USR;
    private static String PSSWD;
    private static Connection conexion;
    
    public static void conectar(){
        parametrosDeConfiguracion.cargarParametros();
        USR = parametrosDeConfiguracion.getUsuarioSQL();
        URL = parametrosDeConfiguracion.getURL();
        PORT = parametrosDeConfiguracion.getPuerto();
        BD = parametrosDeConfiguracion.getBD();
        PSSWD = parametrosDeConfiguracion.getPassSQL();
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://"+URL+":"+PORT+"/"+BD, USR, PSSWD);

            System.out.println("Conectando con"+" jdbc:mysql://"+URL+":"+PORT+"/"+BD+"...");

        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error conectando a la base de datos","Error de conexión",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

        System.out.println("Conexión Correcta");

    }

    public static Connection getConexion() {
        try {
            if(conexion == null){
                conectar();
            }
            if(conexion.isClosed()) {
                conectar();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return conexion;

    }
    // De acá en adelante es un despelote, pero anda
    public static void hacerBackup(String destino) {
        String archivoDestino;
        String comando;
        try {
            if(System.getProperty("os.name").toLowerCase().contains("win")){
                System.out.println(destino);
                archivoDestino = destino+"\\backup-"+LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) +".sql";
                comando = (PSSWD.equals("")) ? "mysqldump -u "+USR+" -h "+URL+" "+BD+" --result-file=\""+archivoDestino+"\"" : "mysqldump -u "+USR+" -p "+PSSWD+" -h "+URL+" "+BD+" --result-file=\""+archivoDestino+"\"";
                Process proceso = Runtime.getRuntime().exec(comando);
            }else{
                archivoDestino = destino+"/backup-"+LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))+".sql";
                comando = (PSSWD.equals("")) ? "mysqldump -u "+USR+" -h "+URL+" "+BD+" > "+archivoDestino : "mysqldump -u "+USR+" -p "+PSSWD+" -h "+URL+" "+BD+" > "+archivoDestino;
                Process process = Runtime.getRuntime().exec(new String[]{"bash","-c",comando});
                System.out.println(process.waitFor());
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Comandos sql no encontrados","Error",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    public static void restaurarDesdeBackup(String archivoSQL){
        conectar();
        try {
            System.out.println("Vaciando BD...");
            //Esta consulta SI O SI en este orden, no funca sino
            String[] consultas = new String[]{"DROP TABLE IF EXISTS accesorios;",
                    "DROP TABLE IF EXISTS reservas;",
                    "DROP TABLE IF EXISTS salones;",
                    "DROP TABLE IF EXISTS usuarios;",
                    "DROP TABLE IF EXISTS permisos;",
                    "DROP TABLE IF EXISTS profesores;",
                    "DROP TABLE IF EXISTS carreras;"};
            for(String drop: consultas) {
                PreparedStatement consulta = conexion.prepareStatement(drop);
                consulta.executeUpdate();
            }
            System.out.println("BD vacía");

            try {
                String comando;
                if(System.getProperty("os.name").toLowerCase().contains("win")){
                    comando = (PSSWD.equals("")) ? "mysql -u "+USR+" -h "+URL+" "+BD+" -e \"source "+archivoSQL+"\"" : "mysql -u "+USR+" -p "+PSSWD+" -h "+URL+" "+BD+" -e \"source "+archivoSQL+"\"";
                    Process proceso = Runtime.getRuntime().exec(comando);
                    System.out.println(proceso.waitFor());
                    System.out.println("en teoria lo cargo todo");
                }else{
                    comando = (PSSWD.equals("")) ? "mysql -u "+USR+" -h "+URL+" "+BD+" < "+archivoSQL : "mysql -u "+USR+" -p "+PSSWD+" -h "+URL+" "+BD+" < "+archivoSQL;
                    Process process = Runtime.getRuntime().exec(new String[]{"bash","-c",comando});
                    System.out.println(process.waitFor());
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Comandos sql no encontrados","Error",JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
