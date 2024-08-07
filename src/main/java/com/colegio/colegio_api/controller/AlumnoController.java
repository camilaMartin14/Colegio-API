package com.colegio.colegio_api.controller;

import com.colegio.colegio_api.model.Alumno;
import com.colegio.colegio_api.service.IAlumnoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlumnoController {
     @Autowired
    private IAlumnoService aluServ;
    
    @GetMapping ("/alumnos")
    public Page <Alumno> getAlumnos(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        return aluServ.getAlumnos(page, size);
    }
    
    @GetMapping("/alumnos/{nombrecompleto}")
public ResponseEntity<Alumno> findAlumnoNombreApellido(@PathVariable String nombrecompleto) {
    if (nombrecompleto == null || nombrecompleto.trim().isEmpty()) {
        return ResponseEntity.badRequest().body(null);
    }

    String[] partesNombre = nombrecompleto.split(" ", 2);
    if (partesNombre.length < 2) {
        return ResponseEntity.badRequest().body(null);
    }

    String nombre = partesNombre[0].trim();
    String apellido = partesNombre[1].trim();

    if (nombre.isEmpty() || apellido.isEmpty()) {
        return ResponseEntity.badRequest().body(null);
    }

    Alumno alumno = aluServ.findAlumnoNombreApellido(nombre, apellido);
    if (alumno != null) {
        return ResponseEntity.ok(alumno);
    } else {
        return ResponseEntity.notFound().build();
    }
}

    
    /*@GetMapping("/alumnos/{nombrecompleto}")
    public ResponseEntity<Alumno> findAlumnoNombreApellido(@PathVariable String nombrecompleto) {
        String[] partesNombre = nombrecompleto.split(" ", 2);
        if (partesNombre.length < 2) {
            return ResponseEntity.badRequest().body(null);
        }

        String nombre = partesNombre[0];
        String apellido = partesNombre[1];
        
        Alumno alumno = aluServ.findAlumnoNombreApellido(nombre, apellido);
        if (alumno != null) {
            return ResponseEntity.ok(alumno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

    
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
