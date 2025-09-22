package com.duoc.atenciones.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.duoc.atenciones.servicios.HistorialMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.duoc.atenciones.modelos.HistorialMedico;

@RestController
@RequestMapping("/historiales")
public class HistorialController {

    @Autowired
    private HistorialMedicoService historialMedicoService;

    //ver todos
    @GetMapping
    public List<HistorialMedico> verTodosLosHistoriales(){
        return historialMedicoService.obtenerTodos();
    }

    //ver por id
    @GetMapping("/{id}")
    public Optional<HistorialMedico> verPorId(@PathVariable Long id){
        return historialMedicoService.obtenerPorId(id);
    }

    //guardar
    @PostMapping
    public HistorialMedico guardarHistorial(@RequestBody HistorialMedico historialMedico){
        return historialMedicoService.guardarHistorial(historialMedico);
    }

    //modificar
    @PutMapping("/{id}")
    public ResponseEntity<HistorialMedico> actualizarHistorial(@PathVariable Long id, @RequestBody HistorialMedico historialMedico){
        return historialMedicoService.actualizarHistorial(id, historialMedico);
    }

    //eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHistorial(@PathVariable Long id){
        return historialMedicoService.eliminarHistorial(id);
    }

}
