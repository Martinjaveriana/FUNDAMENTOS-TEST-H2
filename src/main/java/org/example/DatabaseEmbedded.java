package org.example;

import java.sql.*;
import java.io.File;

public class DatabaseEmbedded {

    public static void main(String[] args) {
        System.out.println("🚀 INICIANDO H2 MODO EMBEBIDO");
        System.out.println("==================================");

        Connection conn = null;
        Statement stmt = null;

        try {
            // PASO 1: Cargar el driver de H2
            Class.forName("org.h2.Driver");
            System.out.println("✅ 1. Driver H2 cargado");

            // PASO 2: Conectar a base de datos EMBEBIDA
            // IMPORTANTE: file: = modo embebido, ./ = carpeta local
            String url = "jdbc:h2:file:./mi_bd_embedded;DB_CLOSE_DELAY=-1";
            conn = DriverManager.getConnection(url, "sa", "");
            System.out.println("✅ 2. Conectado a BD embebida");
            System.out.println("   📁 Archivo: " + new File("./mi_bd_embedded.mv.db").getAbsolutePath());

            // PASO 3: Crear tabla
            stmt = conn.createStatement();
            String sqlCreate = "CREATE TABLE IF NOT EXISTS personas (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "nombre VARCHAR(50), " +
                    "edad INT)";
            stmt.execute(sqlCreate);
            System.out.println("✅ 3. Tabla 'personas' creada");

            // PASO 4: Insertar datos
            String sqlInsert = "INSERT INTO personas (nombre, edad) VALUES " +
                    "('Ana', 20), " +
                    "('Carlos', 22), " +
                    "('María', 21)";
            int insertados = stmt.executeUpdate(sqlInsert);
            System.out.println("✅ 4. Insertados " + insertados + " registros");

            // PASO 5: Consultar datos
            ResultSet rs = stmt.executeQuery("SELECT * FROM personas");
            System.out.println("\n📋 DATOS GUARDADOS:");
            System.out.println("-------------------");
            while (rs.next()) {
                System.out.println("   ID: " + rs.getInt("id") +
                        " | Nombre: " + rs.getString("nombre") +
                        " | Edad: " + rs.getInt("edad"));
            }

            // PASO 6: Cerrar conexión
            rs.close();
            stmt.close();
            conn.close();
            System.out.println("\n✅ 6. Conexión cerrada");

            System.out.println("\n🎉 ¡MODO EMBEBIDO FUNCIONANDO!");
            System.out.println("==================================");

        } catch (Exception e) {
            System.err.println("❌ ERROR: " + e.getMessage());
            e.printStackTrace();
        }
    }
}