package com.colegio.colegio_api.service;

import com.colegio.colegio_api.model.Alumno;
import com.colegio.colegio_api.model.Curso;
import com.colegio.colegio_api.model.Maestro;
import java.util.List;

public interface ICursoService {
    
    public List <Curso> getCurso();
    
    public Curso findCurso(Long id);
    
    public void saveCurso(Curso cur);
    
    public void deleteCurso(Long id);

    public void editCurso(Long idOriginal,
                            Long nuevoId,
                            String nuevaMateria,
                            List <Alumno> nuevaListaAlumnos,
                            Maestro nuevoMaestro);

    public void editCurso(Curso cur);
}
