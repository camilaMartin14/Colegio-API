package com.colegio.colegio_api.controller;

import com.colegio.colegio_api.model.Alumno;
import com.colegio.colegio_api.service.IAlumnoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
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
    public List <Alumno> getAlumno(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size){
        return aluServ.getAlumno();
    }

    @GetMapping("/nombresfiltro")
    public String alumnosFiltrados(Model model) {
        model.addAttribute("alumno", new Alumno());
        return "nombresfiltro";
    }

    @GetMapping("/nombre")
    public String buscarPorNombre(@RequestParam String nombre, Model model) {
        model.addAttribute("alumnosPorNombre", aluServ.buscarPorNombre(nombre));
        return "nombresfiltro";
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
