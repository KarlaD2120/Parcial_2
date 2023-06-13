
package app;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=CompetenciaTirosAlAro";
    private static final String USER = "sa";
    private static final String PASSWORD = "12345678";

    public static void main(String[] args) {
        // Paso 1: Registrar el controlador JDBC
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al registrar el controlador JDBC: " + e.getMessage());
            return;
        }

        Connection connection = null;
        Statement sentencia = null;

        try {
            // Paso 2: Establecer la conexión
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Paso 3: Realizar operaciones con la base de datos

            System.out.println("Conexión exitosa a la base de datos");

        } catch (SQLException e) {
            System.out.println("Error al conectarse a la base de datos: " + e.getMessage());
        } finally {
            // Paso 4: Cerrar la conexión
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }
}
