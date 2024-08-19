package com.colegio.colegio_api.controller;

import com.colegio.colegio_api.model.Alumno;
import com.colegio.colegio_api.service.IAlumnoService;
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
public class AlumnoController {
    @Autowired
    private IAlumnoService aluServ;
    
    
    @GetMapping ("/alumnos/{nombre}")
    public List <Alumno> getAlumno(@PathVariable String nombre){
        return aluServ.getAlumno(nombre);
    }
    
    @PostMapping ("/alumnos/crear")
    public String saveAlumno(@RequestBody Alumno alu){
        aluServ.saveAlumno(alu);
        
        return "El alumno se guardó correctamente";
    }
    
    @DeleteMapping("/alumnos/eliminar/{legajo}")
    public String deleteAlumno(@PathVariable Long legajo){
        aluServ.deleteAlumno(legajo);
        
        return "El alumno se borró correctamente";
    }

    @PutMapping("/alumnos/editar")
    public Alumno editAlumno(@RequestBody Alumno alu){
        aluServ.editAlumno(alu);
        
        return aluServ.findAlumno(alu.getLegajo());
    }
}
