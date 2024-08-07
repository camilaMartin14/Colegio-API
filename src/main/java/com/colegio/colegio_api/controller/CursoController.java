package com.colegio.colegio_api.controller;

import com.colegio.colegio_api.model.Curso;
import com.colegio.colegio_api.service.ICursoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CursoController {
    @Autowired
    private ICursoService curServ;
    
    @GetMapping ("/cursos")
    public List <Curso> getCursos(){
        return curServ.getCurso();
    }

    @PostMapping ("/cursos/crear")
    public String saveCurso (@RequestBody Curso cur){
        curServ.saveCurso(cur);
        
        return "El curso se creó correctamente";
    }
    
    @DeleteMapping("/cursos/eliminar/{id}")
    public String deleteCurso(@PathVariable Long id){
        curServ.deleteCurso(id);
        
        return "El curso se borró correctamente";
    }
    
    @PutMapping("/cursos/editar")
    public Curso editCurso(@RequestBody Curso cur){
        curServ.editCurso(cur);
        
        return curServ.findCurso(cur.getId());
    }
}
