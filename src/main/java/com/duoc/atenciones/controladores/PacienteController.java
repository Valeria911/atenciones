package com.duoc.atenciones.controladores;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.duoc.atenciones.modelos.Paciente;
import com.duoc.atenciones.servicios.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    //ver todos los pacientes
    @GetMapping
    public CollectionModel<EntityModel<Paciente>> obtenerTodosLosPacientes(){
        List<Paciente> pacientes = pacienteService.obtenerPacientes();

        List<EntityModel<Paciente>> pacienteResources = pacientes.stream()
                .map(paciente -> EntityModel.of(paciente,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).obtenerPacientePorId(paciente.getId())).withSelfRel()
                )).collect(Collectors.toList());

        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).obtenerTodosLosPacientes());
        CollectionModel<EntityModel<Paciente>> resources = CollectionModel.of(pacienteResources, linkTo.withRel("pacientes"));

        return resources;
    }

   /* public List<Paciente> obtenerPacientes() {
        return pacienteService.obtenerPacientes();
    }*/

    //ver por id
    @GetMapping("/{id}")
    public EntityModel<Paciente> obtenerPacientePorId(@PathVariable Long id){
        Optional<Paciente> paciente = pacienteService.obtenerPorId(id);

        if (paciente.isPresent()) {
            return EntityModel.of(paciente.get(),
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).obtenerPacientePorId(id)).withSelfRel(),
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).obtenerTodosLosPacientes()).withRel("todos-los-pacientes"));
        } else {
            throw new PacienteNotFoundException("Paciente no encontrado con id: " + id);
        }
    }

    /*public Optional<Paciente> obtenerPacientePorId(@PathVariable Long id) {
        return pacienteService.obtenerPorId(id);
    }*/

    //Guardar paciente
    @PostMapping
    public EntityModel<Paciente> guardarPaciente(@RequestBody Paciente paciente){
        Paciente pacienteGuardado = pacienteService.guardarPaciente(paciente);
        return EntityModel.of(pacienteGuardado,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).obtenerPacientePorId(pacienteGuardado.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).obtenerTodosLosPacientes()).withRel("todos-los-pacientes"));
    }

   /* public Paciente guardarPaciente(@RequestBody Paciente paciente){
        return pacienteService.guardarPaciente(paciente);
    }*/

    //modificar paciente
    @PutMapping("/{id}")
    public EntityModel<Paciente> actualizarPaciente(@PathVariable Long id, @RequestBody Paciente paciente){
        Paciente pacienteActualizado = pacienteService.actualizarPaciente(id, paciente);
        return EntityModel.of(pacienteActualizado,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).obtenerPacientePorId(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).obtenerTodosLosPacientes()).withRel("todos-los-paientes"));
    }

   /* public ResponseEntity<Paciente> editarPaciente(@PathVariable Long id, @RequestBody Paciente paciente){
        return pacienteService.actualizarPaciente(id, paciente);
    }*/

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPaciente(@PathVariable Long id){
        return pacienteService.eliminarPaciente(id);
    }

    
}
