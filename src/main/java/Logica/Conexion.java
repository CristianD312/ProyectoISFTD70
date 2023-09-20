package Logica;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;


public class Conexion {
    private String URL = "jdbc:mysql://localhost:3306/reservas";
    private String USR = "root";
    private String PSSWD = "";
    Connection conexion;
    public Conexion(){
        conectar();
    }
    public Conexion(String URL, String user, String password){
        this.URL = URL;
        USR = user;
        PSSWD = password;
        this.conectar();
    }
    private void conectar(){
        try {
            this.conexion = DriverManager.getConnection(URL, USR, PSSWD);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConexion() {return conexion;}

    public void hacerBackup(String destino) {
        String archivoDestino;
        String comando;
        try {
            if(System.getProperty("os.name").toLowerCase().contains("win")){
                archivoDestino = destino+"\\backup-"+LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) +".sql";
                comando = (PSSWD.equals("")) ? "mysqldump -u "+USR+" -h 127.0.0.1 reservas > "+archivoDestino : "mysqldump -u "+USR+" -p "+PSSWD+" -h 127.0.0.1 reservas > "+archivoDestino;
                System.out.println(archivoDestino);
                System.out.println(comando);
                System.out.println("HACIENDO BACKUP EN WINDOWS");
            Process proceso = Runtime.getRuntime().exec(comando);
            System.out.println(proceso.waitFor());
            }else{
                archivoDestino = destino+"/backup-"+LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))+".sql";
                comando = (PSSWD.equals("")) ? "mysqldump -u "+USR+" -h 127.0.0.1 reservas > "+archivoDestino : "mysqldump -u "+USR+" -p "+PSSWD+" -h 127.0.0.1 reservas > "+archivoDestino;
                System.out.println(archivoDestino);
                System.out.println(comando);
                System.out.println("HACIENDO BACKUP EN LINUX");
                Process process = Runtime.getRuntime().exec(new String[]{"bash","-c",comando});
                System.out.println(process.waitFor());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void restaurarDesdeBackup(String archivoSQL){
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

            try {
                String comando = (PSSWD.equals("")) ? "mysql -u "+USR+" -h 127.0.0.1 reservas < "+archivoSQL : "mysql -u "+USR+" -p "+PSSWD+" -h 127.0.0.1 reservas < "+archivoSQL;
                if(System.getProperty("os.name").toLowerCase().contains("win")){
                    Process proceso = Runtime.getRuntime().exec(comando);
                    System.out.println(proceso.waitFor());
                }else{
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
