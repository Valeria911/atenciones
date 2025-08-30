package com.duoc.atenciones.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paciente {
    private Long id;
    private String nombre;
    private String apellido;
    private String rut;
    private String fechaNacimiento; // Formato: "yyyy-MM-dd"
    private String email;
    private String telefono;


}
