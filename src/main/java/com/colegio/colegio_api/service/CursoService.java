package com.colegio.colegio_api.service;

import com.colegio.colegio_api.model.Alumno;
import com.colegio.colegio_api.model.Curso;
import com.colegio.colegio_api.model.Maestro;
import com.colegio.colegio_api.repository.ICursoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService implements ICursoService{

    @Autowired
    private ICursoRepository cursoRepo;
    
    @Override
    public List<Curso> getCurso() {
        List <Curso> listaCursos= cursoRepo.findAll();
        return listaCursos;       
    }

    @Override
    public Curso findCurso(Long id) {
        Curso cur = cursoRepo.findById(id).orElse(null);
        return cur;    
    }

    @Override
    public void saveCurso(Curso cur) {
        cursoRepo.save(cur);    
    }

    @Override
    public void deleteCurso(Long id) {
        cursoRepo.deleteById(id);
    }

    @Override
    public void editCurso(Long idOriginal,
                            Long nuevoId, 
                            String nuevaMateria, 
                            List<Alumno> nuevaListaAlumnos, 
                            Maestro nuevoMaestro) {
        
        Curso cur = this.findCurso(idOriginal);

        cur.setId(nuevoId);
        cur.setMateria(nuevaMateria);
        cur.setListaAlumnos(nuevaListaAlumnos);
        cur.setUnMaestro(nuevoMaestro);

       this.saveCurso(cur);
    }

    @Override
    public void editCurso(Curso cur) {
        this.saveCurso(cur);
    }
    
}
