package javaapplication25;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;


public class NewClass{
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/reservas";
        String usuario = "root";
        String contrasena = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, usuario, contrasena)) {
            if (connection != null) {
                System.out.println("Conexión exitosa a la base de datos");

                // obtener estadísticas de uso de salones desde la base de datos
                Map<String, Integer> estadisticasSalones = obtenerEstadisticasSalones(connection);

                // mostrar estadísticas
                System.out.println("Estadísticas de uso de salones por materia y carrera:");
                for (Map.Entry<String, Integer> entry : estadisticasSalones.entrySet()) {
                    System.out.println(entry.getKey() + ": " + entry.getValue() + " reservas");
                }

                // encontrar el salón más usado y el menos usado
                String salonMasUsado = encontrarMasUsado(estadisticasSalones);
                String salonMenosUsado = encontrarMenosUsado(estadisticasSalones);

                System.out.println("Salón más usado: " + salonMasUsado);
                System.out.println("Salón menos usado: " + salonMenosUsado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Integer> obtenerEstadisticasSalones(Connection connection) throws SQLException {
        Map<String, Integer> estadisticasSalones = new HashMap<>();

        String consultaSQL = "SELECT nombre_carrera, materia, COUNT(*) as reservas FROM reservas GROUP BY nombre_carrera, materia";
        try (PreparedStatement preparedStatement = connection.prepareStatement(consultaSQL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String carrera = resultSet.getString("nombre_carrera");
                String materia = resultSet.getString("materia");        // atributo materia sin definir //
                int reservas = resultSet.getInt("reservas");

                String clave = carrera + " - " + materia;
                estadisticasSalones.put(clave, reservas);
            }
        }

        return estadisticasSalones;
    }

    private static String encontrarMasUsado(Map<String, Integer> estadisticasSalones) {
        int maxReservas = -1;
        String salonMasUsado = null;

        for (Map.Entry<String, Integer> entry : estadisticasSalones.entrySet()) {
            if (entry.getValue() > maxReservas) {
                maxReservas = entry.getValue();
                salonMasUsado = entry.getKey();
            }
        }

        return salonMasUsado;
    }

    private static String encontrarMenosUsado(Map<String, Integer> estadisticasSalones) {
        int minReservas = Integer.MAX_VALUE;
        String salonMenosUsado = null;

        for (Map.Entry<String, Integer> entry : estadisticasSalones.entrySet()) {
            if (entry.getValue() < minReservas) {
                minReservas = entry.getValue();
                salonMenosUsado = entry.getKey();
            }
        }

        return salonMenosUsado;
    }
