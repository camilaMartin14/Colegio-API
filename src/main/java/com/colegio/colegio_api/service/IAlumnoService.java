package com.colegio.colegio_api.service;

import com.colegio.colegio_api.model.Alumno;
import java.util.List;
import org.springframework.data.domain.Page;

public interface IAlumnoService {
    
    public List <Alumno> getAlumno(String nombre);
    
    public Alumno findAlumno(Long legajo);
    
    public void saveAlumno(Alumno alu);
    
    public void deleteAlumno(Long alu);

    public void editAlumno(Alumno alu);
}
