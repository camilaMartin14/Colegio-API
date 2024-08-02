package com.colegio.colegio_api.model;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Maestro {
    
    public long legajo;
    public String nombre;
    public String apellido;
    public int dni;

    public Maestro() {
    }

    public Maestro(long legajo, String nombre, String apellido, int dni) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }
    
}
