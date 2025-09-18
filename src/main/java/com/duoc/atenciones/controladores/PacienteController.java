package com.duoc.atenciones.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.duoc.atenciones.modelos.Paciente;
import com.duoc.atenciones.servicios.PacienteService;

@RestController
public class PacienteController {

    private PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService){
        this.pacienteService = pacienteService;
    }
    //ver todos los pacientes
    @GetMapping("/pacientes")
    public List<Paciente> obtenerPacientes() {
        return pacienteService.obtenerPacientes();
    }

    //ver por id
    @GetMapping("/pacientes/{id}")
    public Optional<Paciente> obtenerPacientePorId(@PathVariable Long id) {
        return pacienteService.obtenerPorId(id);
    }

    @PostMapping
    public Paciente guardarPaciente(@RequestBody Paciente paciente){
        return pacienteService.guardarPaciente(paciente);
    }

    @PutMapping("/pacientes/{id}")
    public ResponseEntity<Paciente> editarPaciente(@PathVariable Long id, @RequestBody Paciente paciente){
        return pacienteService.actualizarPaciente(id, paciente);
    }

    @DeleteMapping("/pacientes/{id}")
    public ResponseEntity<Void> eliminarPaciente(@PathVariable Long id){
        return pacienteService.eliminarPaciente(id);
    }

    
}
