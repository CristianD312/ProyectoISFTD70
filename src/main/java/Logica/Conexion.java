package Logica;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class Conexion {
    private static String URL;
    private static String USR;
    private static String PSSWD;
    private static Connection conexion;
    private static void conectar(){
        parametrosDeConfiguracion.cargarParametros();
        USR = parametrosDeConfiguracion.getUsuarioSQL();
        URL = "jdbc:mysql://"+parametrosDeConfiguracion.getURL();
        PSSWD = parametrosDeConfiguracion.getPassSQL();
        try {
            conexion = DriverManager.getConnection(URL, USR, PSSWD);
        }catch (SQLException e){
            e.printStackTrace();
        }
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
                comando = (PSSWD.equals("")) ? "mysqldump -u "+USR+" -h 127.0.0.1 reservas --result-file=\""+archivoDestino+"\"" : "mysqldump -u "+USR+" -p "+PSSWD+" -h 127.0.0.1 reservas --result-file=\""+archivoDestino+"\"";
                System.out.println(archivoDestino);
                System.out.println(comando);
                System.out.println("HACIENDO BACKUP EN WINDOWS");
                Process proceso = Runtime.getRuntime().exec(comando);
                System.out.println(proceso.waitFor());
            }else{
                archivoDestino = destino+"/backup-"+LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))+".sql";
                comando = (PSSWD.equals("")) ? "mysqldump -u "+USR+" -h 127.0.0.1 reservas  > "+archivoDestino : "mysqldump -u "+USR+" -p "+PSSWD+" -h 127.0.0.1 reservas > "+archivoDestino;
                System.out.println(destino+"\\backup-"+LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) +".sql");
                System.out.println("HACIENDO BACKUP EN LINUX");
                Process process = Runtime.getRuntime().exec(new String[]{"bash","-c",comando});
                System.out.println(process.waitFor());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void restaurarDesdeBackup(String archivoSQL){
        try {
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
            System.out.println("Limpio todo");

            try {
                String comando;
                if(System.getProperty("os.name").toLowerCase().contains("win")){
                    comando = (PSSWD.equals("")) ? "mysql -u "+USR+" -h 127.0.0.1 reservas -e \"source "+archivoSQL+"\"" : "mysql -u "+USR+" -p "+PSSWD+" -h 127.0.0.1 reservas -e \"source "+archivoSQL+"\"";
                    Process proceso = Runtime.getRuntime().exec(comando);
                    System.out.println(proceso.waitFor());
                    System.out.println("en teoria lo cargo todo");
                }else{
                    comando = (PSSWD.equals("")) ? "mysql -u "+USR+" -h 127.0.0.1 reservas < "+archivoSQL : "mysql -u "+USR+" -p "+PSSWD+" -h 127.0.0.1 reservas < "+archivoSQL;
                    Process process = Runtime.getRuntime().exec(new String[]{"bash","-c",comando});
                    System.out.println(process.waitFor());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
