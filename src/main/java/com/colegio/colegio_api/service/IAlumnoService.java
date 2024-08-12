package com.colegio.colegio_api.service;

import com.colegio.colegio_api.model.Alumno;
import java.util.List;

public interface IAlumnoService {
    
    public List <Alumno> getAlumno();
    
    public List <Alumno> buscarPorNombre(String nombre);
    
    public Alumno findAlumno(Long legajo);
    
    public Alumno findAlumnoNombreApellido(String nombre, String apellido);
    
    public void saveAlumno(Alumno alu);
    
    public void deleteAlumno(Long alu);

    public void editAlumno(Long legajoOriginal,
                            Long nuevoLegajo,
                            String nuevoNombre,
                            String nuevoApellido,
                            int nuevoDni,
                            long nuevoCuil,
                            int nuevaEdad,
                            char nuevoGenero);

    public void editAlumno(Alumno alu);
}
