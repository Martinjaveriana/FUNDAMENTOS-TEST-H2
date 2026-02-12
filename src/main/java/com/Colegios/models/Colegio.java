package com.Colegios.models;

import java.util.ArrayList;
import java.util.List;

public class Colegio {

    // Atributos
    private int id;
    private String nombre;
    private List<Estudiante> estudiantes;

    // Constructor 1: Para colegio NUEVO (sin ID)
    public Colegio(String nombre) {
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
    }

    // Constructor 2: Para colegio EXISTENTE (con ID de la BD)
    public Colegio(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.estudiantes = new ArrayList<>();
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public void agregarEstudiante(Estudiante e) {
        this.estudiantes.add(e);
    }

    @Override
    public String toString() {
        return "Colegio ID: " + id + " | " + nombre +
                " | Estudiantes: " + estudiantes.size();
    }
}