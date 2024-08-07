package com.colegio.colegio_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Curso {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    public long id;
    public String materia;
    @OneToMany
    public List <Alumno> listaAlumnos = new ArrayList<>();;
    @OneToOne
    public Maestro unMaestro;

    public Curso() {
    }

    public Curso(long id, String materia, List<Alumno> listaAlumnos, Maestro unMaestro) {
        this.id = id;
        this.materia = materia;
        this.listaAlumnos = listaAlumnos;
        this.unMaestro = unMaestro;
    }
    
}
