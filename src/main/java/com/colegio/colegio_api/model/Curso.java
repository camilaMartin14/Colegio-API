package com.colegio.colegio_api.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Curso {
    
    public long id;
    public String materia;
    public List <Alumno> listaAlumnos;
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
