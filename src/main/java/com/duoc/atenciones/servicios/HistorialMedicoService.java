package com.duoc.atenciones.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.duoc.atenciones.modelos.HistorialMedico;

@Service
public class HistorialMedicoService {
    private List<HistorialMedico> historialesMedicos = new ArrayList<>();
    private Long nextId = 1L;

    // Crear un nuevo historial médico
    public HistorialMedico crearHistorialMedico(HistorialMedico historialMedico) {
        if (historialMedico.getId() == null || historialMedico.getId() == 0) {
            throw new IllegalArgumentException("El ID del historial médico no puede ser nulo o cero.");
        }
        historialMedico.setId(nextId++);
        historialesMedicos.add(historialMedico);
        return historialMedico;
    }
}
