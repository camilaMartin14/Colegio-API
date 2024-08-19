package com.colegio.colegio_api.service;

import com.colegio.colegio_api.model.Alumno;
import com.colegio.colegio_api.repository.IAlumnoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlumnoService implements IAlumnoService{

    @Autowired
    private IAlumnoRepository aluRepo;
    
    @Override
    public List<Alumno> getAlumno(String nombre) {
        
        List <Alumno> listaAlumnos= aluRepo.findAll();
        List <Alumno> listaFiltrados = new ArrayList();
        
        for (Alumno alumno : listaAlumnos) {
            if(alumno.nombre.equals(nombre)){
                listaFiltrados.add(alumno);
                return listaFiltrados;
            }
        }
        return listaAlumnos;    
    }
    
    @Override
    public Alumno findAlumno(Long legajo) {
        Alumno alu = aluRepo.findById(legajo).orElse(null);
        return alu;    
    } 
    
    @Override
    public void saveAlumno(Alumno alu) {
        aluRepo.save(alu);    
    }

    @Override
    public void deleteAlumno(Long legajo) {
        aluRepo.deleteById(legajo);
    }

    @Override
    public void editAlumno(Alumno alu) {
        this.saveAlumno(alu);
    }
}
