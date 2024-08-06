package com.colegio.colegio_api.service;

import com.colegio.colegio_api.model.Alumno;
import com.colegio.colegio_api.repository.IAlumnoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class AlumnoService implements IAlumnoService{
    
    private List<Alumno> listaAlumnos;
        
    @Autowired
    private IAlumnoRepository aluRepo;

    @Override
    public List<Alumno> getAlumno() {
        List <Alumno> listaAlumnos= aluRepo.findAll();
        return listaAlumnos;    
    }
    
    @Override
    public Alumno findAlumno(Long legajo) {
        Alumno alu = aluRepo.findById(legajo).orElse(null);
        return alu;    
    }
    

    @Override
    public Alumno findAlumnoNombreApellido(String nombre, String apellido) {
    for (Alumno alumno : listaAlumnos) {
            if (alumno.getNombre().equalsIgnoreCase(nombre) &&
                alumno.getApellido().equalsIgnoreCase(apellido)) {
                return alumno;
            }
        }
        return null;
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
    public void editAlumno(Long legajoOriginal, 
                            Long nuevoLegajo, 
                            String nuevoNombre, 
                            String nuevoApellido, 
                            int nuevoDni,
                            int nuevoCuil, 
                            int nuevaEdad, 
                            char nuevoGenero) {
        
    Alumno alu = this.findAlumno(legajoOriginal);

        alu.setLegajo(nuevoLegajo);
        alu.setNombre(nuevoNombre);
        alu.setApellido(nuevoApellido);
        alu.setDni(nuevoDni);
        alu.setCuil(nuevoCuil);
        alu.setEdad(nuevaEdad);
        alu.setGenero(nuevoGenero);



       this.saveAlumno(alu);
    }

    @Override
    public void editAlumno(Alumno alu) {
        this.saveAlumno(alu);
    }

}
