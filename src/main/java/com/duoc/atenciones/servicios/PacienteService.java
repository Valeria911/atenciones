package com.duoc.atenciones.servicios;

import java.util.List;
import java.util.Optional;

import com.duoc.atenciones.repositorios.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.duoc.atenciones.modelos.Paciente;    

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    //Obtener todos los pacientes
    public List<Paciente> obtenerPacientes(){
        return pacienteRepository.findAll();
    }

    //Obtener un paciente por id
    public Optional<Paciente> obtenerPorId(Long id){
        return  pacienteRepository.findById(id);
    }

    //Guardar un nuevo paciente
    public Paciente guardarPaciente(Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    //Editar o modificar un paciente por id
    public ResponseEntity<Paciente> actualizarPaciente(Long id, Paciente datos){
        return pacienteRepository.findById(id).map(paciente -> {
            paciente.setNombre(datos.getNombre());
            paciente.setApellido(datos.getApellido());
            paciente.setRut(datos.getRut());
            paciente.setFechaNacimiento(datos.getFechaNacimiento());
            paciente.setEmail(datos.getEmail());
            paciente.setTelefono(datos.getTelefono());
            return ResponseEntity.ok(pacienteRepository.save(paciente));
        }).orElse(ResponseEntity.notFound().build());
    }

    //Eliminar un paciente por id
    public ResponseEntity<Void> eliminarPaciente(Long id){
        if (pacienteRepository.existsById(id)){
            pacienteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
