package com.colegio.colegio_api.model;

import lombok.Getter;
import lombok.Setter;

public class Alumno {
    
    @Getter@Setter
    public long legajo;
    public String name;
    public String apellido;
    public int dni;
    public int cuil;
    public int edad;
    public char genero;

    public Alumno() {
    }

    public Alumno(long legajo, String name, String apellido, int dni, int cuil, int edad, char genero) {
        this.legajo = legajo;
        this.name = name;
        this.apellido = apellido;
        this.dni = dni;
        this.cuil = cuil;
        this.edad = edad;
        this.genero = genero;
    }
    
}
