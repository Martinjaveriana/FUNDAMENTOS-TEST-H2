package com.Colegios.Database;

import java.sql.*;
import java.io.File;


public class DatabaseConnection {

    private static final String URL = "jdbc:h2:file:./sistema_escolar_db;DB_CLOSE_DELAY=-1";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    // 2. METODO PARA OBTENER CONEXIÓN
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // 3. METODO PARA CREAR TABLAS
    public static void crearTablas() {
        // SQL para tabla COLEGIOS
        String sqlColegios = "CREATE TABLE IF NOT EXISTS colegios (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "nombre VARCHAR(100) NOT NULL)";

        // SQL para tabla ESTUDIANTES (con relación a colegios)
        String sqlEstudiantes = "CREATE TABLE IF NOT EXISTS estudiantes (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "nombre VARCHAR(100) NOT NULL," +
                "edad INT," +
                "colegio_id INT," +
                "FOREIGN KEY (colegio_id) REFERENCES colegios(id))";

        // Ejecutar las creaciones
        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {

            stmt.execute(sqlColegios);
            stmt.execute(sqlEstudiantes);
            System.out.println("✅ Tablas creadas/verificadas correctamente");
            System.out.println("📁 Base de datos: " + new java.io.File("./colegios_db.mv.db").getAbsolutePath());

        } catch (SQLException e) {
            System.err.println("❌ Error al crear tablas: " + e.getMessage());
        }
    }
}


