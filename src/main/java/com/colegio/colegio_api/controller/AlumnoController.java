package com.colegio.colegio_api.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlumnoController {
     @Autowired
    private IClienteService cliServ;
    
    //listar
    @GetMapping ("/clientes")
    public List <Cliente> getClientes(){
        return cliServ.getClientes();
    }
    
    //crear
    @PostMapping ("/clientes/crear")
    public String saveCliente (@RequestBody Cliente cli){
        cliServ.saveCliente(cli);
        
        return "El cliente se creó correctamente";
    }
    
    //eliminar
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente){
        cliServ.deleteCliente(id_cliente);
        
        return "El cliente se borró correctamente";
    }

    //modificar, pudiendo modificar el id original
    @PutMapping("/clientes/editar/{id_cliente}")
    public Cliente editCliente (@PathVariable Long id_cliente,
            @RequestParam(required = false, name= "codigo_producto") Long nuevaId,
            @RequestParam(required = false, name= "nombre") String nuevoNombre,
            @RequestParam(required = false, name= "marca") String nuevoApellido,
            @RequestParam(required = false, name= "precio") String nuevoDni){
            
        cliServ.editCliente(id_cliente, 
                            nuevaId, 
                            nuevoNombre, 
                            nuevoApellido, 
                            nuevoDni);
        
        Cliente cli = cliServ.findCliente(nuevaId);
        
        return cli;
    }
    
    //modificar, considerando que el id original es intocable
    @PutMapping("/clientes/editar")
    public Cliente editCliente(@RequestBody Cliente cli){
        cliServ.editCliente(cli);
        
        return cliServ.findCliente(cli.getId_cliente());
    }
}
