package com.colegio.colegio_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
public class Maestro {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
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
