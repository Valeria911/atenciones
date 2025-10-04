package com.duoc.atenciones.servicios;

import java.util.List;
import java.util.Optional;

import com.duoc.atenciones.repositorios.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.duoc.atenciones.modelos.HistorialMedico;

@Service
public class HistorialService {

    @Autowired
    private HistorialRepository historialRepository;

    //ver todos
    public List<HistorialMedico> obtenerTodos(){
        return historialRepository.findAll();
    }

    //ver por id
    public Optional<HistorialMedico> obtenerPorId(Long id){
        return historialRepository.findById(id);
    }

    //crear
    public HistorialMedico guardarHistorial(HistorialMedico historialMedico){
        return historialRepository.save(historialMedico);
    }

    //modificar
    public HistorialMedico actualizarHistorial(Long id, HistorialMedico historialMedico){
        return historialRepository.findById(id).map(historial -> {
            historial.setIdPaciente(historialMedico.getIdPaciente());
            historial.setFechaAtencion(historialMedico.getFechaAtencion());
            historial.setTipoAtencion(historialMedico.getTipoAtencion());
            historial.setEspecialidadMedica(historialMedico.getEspecialidadMedica());
            historial.setDiagnostico(historialMedico.getDiagnostico());
            historial.setTratamiento(historialMedico.getTratamiento());
            return ResponseEntity.ok(historialRepository.save(historial));
        }).orElse(ResponseEntity.notFound().build()).getBody();
    }

    //eliminar
    public ResponseEntity<Void> eliminarHistorial(Long id){
        if (historialRepository.existsById(id)){
            historialRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } return ResponseEntity.notFound().build();
    }
}
