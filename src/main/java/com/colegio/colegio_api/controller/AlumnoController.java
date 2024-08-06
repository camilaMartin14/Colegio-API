package com.colegio.colegio_api.controller;

import com.colegio.colegio_api.model.Alumno;
import com.colegio.colegio_api.service.IAlumnoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List <Alumno> getAlumnos(){
        return aluServ.getAlumno();
    }
    
    @GetMapping("/alumnos/{nombrecompleto}")
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

    @PutMapping("/alumnos/editar/{legajoOriginal}")
    public Alumno editAlumno (@PathVariable Long legajoOriginal,
            @RequestParam(required = false, name= "legajo") Long nuevoLegajo,
            @RequestParam(required = false, name= "nombre") String nuevoNombre,
            @RequestParam(required = false, name= "apellido") String nuevoApellido,
            @RequestParam(required = false, name= "dni") int nuevoDni,
            @RequestParam(required = false, name= "cuil") long nuevoCuil,
            @RequestParam(required = false, name= "edad") int nuevaEdad,
            @RequestParam(required = false, name= "genero") char nuevoGenero){
            
        aluServ.editAlumno(legajoOriginal,
                            nuevoLegajo,
                            nuevoNombre,
                            nuevoApellido,
                            nuevoDni,
                            nuevoCuil,
                            nuevaEdad,
                            nuevoGenero);
        
        Alumno alu = aluServ.findAlumno(nuevoLegajo);
        
        return alu;
    }
    
    @PutMapping("/alumnos/editar")
    public Alumno editAlumno(@RequestBody Alumno alu){
        aluServ.editAlumno(alu);
        
        return aluServ.findAlumno(alu.getLegajo());
    }
}
