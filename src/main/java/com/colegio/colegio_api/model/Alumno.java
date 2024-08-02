package com.colegio.colegio_api.model;

import lombok.Getter;
import lombok.Setter;

public class Alumno {
    
    @Getter@Setter
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setCuil(int cuil) {
        this.cuil = cuil;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }
    
}
