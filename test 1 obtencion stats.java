package javaapplication25;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class conexion {
 private static final String JDBC_URL = "jdbc:mysql://localhost:3306/reservas";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USUARIO, CONTRASENA)) {
            if (connection != null) {
                System.out.println("Conexión exitosa a la base de datos");

                // Obtener estadísticas de uso de salones
                Map<String, Integer> estadisticas = calcularEstadisticas(connection);

                // imprimir stats
                for (Map.Entry<String, Integer> entry : estadisticas.entrySet()) {
                    System.out.println("Clave: " + entry.getKey() + ", Reservas: " + entry.getValue());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, Integer> calcularEstadisticas(Connection connection) throws SQLException {
        Map<String, Integer> estadisticas = new HashMap<>();

        // consulta SQL para tener info 
        String sql = "SELECT nombre_carrera, materia, COUNT(*) as reservas FROM reservas GROUP BY nombre_carrera, materia";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                String carrera = resultSet.getString("nombre_carrera");
                String materia = resultSet.getString("materia");  // no existe atributo materia x ahora //
                int reservas = resultSet.getInt("reservas");

                // combinar carrera y materia para obtener una clave unica
                String clave = carrera + " - " + materia;

                // Almacenar las stats 
                estadisticas.put(clave, reservas);
            }
        }

        return estadisticas;
    }
}
