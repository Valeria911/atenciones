package com.duoc.atenciones.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Paciente> obtenerPacientes() {
        return pacienteService.obtenerPacientes();
    }

    //ver por id
    @GetMapping("/{id}")
    public Optional<Paciente> obtenerPacientePorId(@PathVariable Long id) {
        return pacienteService.obtenerPorId(id);
    }

    @PostMapping
    public Paciente guardarPaciente(@RequestBody Paciente paciente){
        return pacienteService.guardarPaciente(paciente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> editarPaciente(@PathVariable Long id, @RequestBody Paciente paciente){
        return pacienteService.actualizarPaciente(id, paciente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPaciente(@PathVariable Long id){
        return pacienteService.eliminarPaciente(id);
    }

    
}
