package com.Colegios;

import com.Colegios.Database.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        System.out.println("🚀 Probando conexión H2 embebido...");
        DatabaseConnection.crearTablas();
    }
}