package com.duoc.atenciones.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistorialMedico {
    private Long id;
    private Long idPaciente;
    private String fechaAtencion;
    private String tipoAtencion;
    private String especialidadMedica;
    private String diagnostico;
    private String tratamiento;
    private String notasAdicionales;

}
