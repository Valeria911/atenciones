package com.duoc.atenciones.controladores;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.duoc.atenciones.servicios.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.duoc.atenciones.modelos.HistorialMedico;

@RestController
@RequestMapping("/historiales")
public class HistorialController {

    @Autowired
    private HistorialService historialService;

    //ver todos
    @GetMapping
    public CollectionModel<EntityModel<HistorialMedico>> verTodosLosHistoriales(){
        List<HistorialMedico> historiales = historialService.obtenerTodos();

        List<EntityModel<HistorialMedico>> historialResources = historiales.stream()
                .map(historialMedico -> EntityModel.of(historialMedico,
                        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).verHistorialPorId(historialMedico.getId())).withSelfRel()
                ))
                .collect(Collectors.toList());

        WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).verTodosLosHistoriales());
        CollectionModel<EntityModel<HistorialMedico>> resources = CollectionModel.of(historialResources, linkTo.withRel("historiales"));

        return resources;
    }

    /* public List<HistorialMedico> verTodosLosHistoriales(){
        return historialMedicoService.obtenerTodos();
    }*/

    //ver por id
    @GetMapping("/{id}")
    public EntityModel<HistorialMedico> verHistorialPorId(@PathVariable Long id){
        Optional<HistorialMedico> historial = historialService.obtenerPorId(id);

        if (historial.isPresent()) {
            return EntityModel.of(historial.get(),
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).verHistorialPorId(id)).withSelfRel(),
                    WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).verTodosLosHistoriales()).withRel("todos-los-historiales"));
        } else {
            throw new HistorialNotFoundException("Historial no encontrado con id: " + id);
        }
    }

   /* public Optional<HistorialMedico> verPorId(@PathVariable Long id){
        return historialMedicoService.obtenerPorId(id);
    }*/

    //guardar
    @PostMapping
    public EntityModel<HistorialMedico> guardarHistorial(@RequestBody HistorialMedico historialMedico){
        HistorialMedico historialGuardado = historialService.guardarHistorial(historialMedico);
        return EntityModel.of(historialGuardado,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).verHistorialPorId(historialGuardado.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).verTodosLosHistoriales()).withRel("todos-los-historiales"));
    }

   /* public HistorialMedico guardarHistorial(@RequestBody HistorialMedico historialMedico){
        return historialMedicoService.guardarHistorial(historialMedico);
    }*/

    //modificar
    @PutMapping("/{id}")
    public EntityModel<HistorialMedico> actualizarHistorial(@PathVariable Long id, @RequestBody HistorialMedico historialMedico){
        HistorialMedico historialActualizado = historialService.actualizarHistorial(id, historialMedico);
        return  EntityModel.of(historialActualizado,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).verHistorialPorId(id)).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).verTodosLosHistoriales()).withRel("todos-los-historiales"));
    }

    /* public ResponseEntity<HistorialMedico> actualizarHistorial(@PathVariable Long id, @RequestBody HistorialMedico historialMedico){
        return historialMedicoService.actualizarHistorial(id, historialMedico);
    }*/

    //eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHistorial(@PathVariable Long id){
        return historialService.eliminarHistorial(id);
    }

}
