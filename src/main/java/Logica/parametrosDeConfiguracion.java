package Logica;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class parametrosDeConfiguracion {

    private static Properties configuracion;
    private static String archivo = "config.cfg";
    public static void cargarParametros() {
        try {
            configuracion = new Properties();
            configuracion.load(new FileInputStream("config.cfg"));
        } catch (Exception e){
            System.out.println("El archivo de configuracion no existe");
            System.out.println("Creando...");
            regenerarConfiguracion();
        }
    }
    private static void regenerarConfiguracion(){
        try {
            configuracion = new Properties();
            setTema("Claro");
            setURL("localhost:3306/reservas");
            setUsuarioSQL("root");
            setPassSQL("");
            setRutaBackup("/example");
            setInterfazConfiguracion("config1");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static String getTema(){
        return configuracion.getProperty("tema");
    }
    public static String getURL(){
        return configuracion.getProperty("servidorSQL");
    }
    public static String getUsuarioSQL(){
        return configuracion.getProperty("usuarioSQL");
    }
    public static String getPassSQL(){
        return configuracion.getProperty("passSQL");
    }
    public static String getRutaBackup(){
        return configuracion.getProperty("rutaBackup");
    }
    public static String getInterfazConfiguracion(){
        return configuracion.getProperty("interfazConfig");
    }
    public static void setTema(String tema){
            configuracion.setProperty("tema",tema);
            guardarCambios();
    }
    public static void setURL(String URL){
        configuracion.setProperty("servidorSQL",URL);
        guardarCambios();
    }
    public static void setUsuarioSQL(String usuario){
        configuracion.setProperty("usuarioSQL",usuario);
        guardarCambios();
    }
    public static void setPassSQL(String passSQL){
        configuracion.setProperty("passSQL",passSQL);
        guardarCambios();
    }
    public static void setRutaBackup(String ruta){
        configuracion.setProperty("rutaBackup",ruta);
        guardarCambios();
    }
    public static void setInterfazConfiguracion(String interfazConfiguracion){
        configuracion.setProperty("interfazConfig",interfazConfiguracion);
        guardarCambios();
    }
    public static void guardarCambios(){
        try {
            configuracion.store(new FileOutputStream(archivo),null);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
