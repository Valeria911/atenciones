package com.duoc.atenciones.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.duoc.atenciones.modelos.Paciente;    

@Service
public class PacienteService {
    private List<Paciente> pacientes = new ArrayList<>();
    private Long nextId = 1L;

    // Crear un nuevo paciente
    public Paciente crearPaciente(Paciente paciente) {
        if (paciente.getId() == null || paciente.getId() == 0) {
            throw new IllegalArgumentException("El ID del paciente no puede ser nulo o cero al crear un nuevo paciente.");
        }
        paciente.setId(nextId++);
        pacientes.add(paciente);
        return paciente;
    }

}
