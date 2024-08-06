package com.colegio.colegio_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
public class Alumno {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    public long legajo;
    public String nombre;
    public String apellido;
    public int dni;
    public int cuil;
    public int edad;
    public char genero;

    public Alumno() {
    }

    public Alumno(long legajo, String nombre, String apellido, int dni, int cuil, int edad, char genero) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.cuil = cuil;
        this.edad = edad;
        this.genero = genero;
    }
    
}
