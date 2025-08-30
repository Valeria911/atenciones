package com.duoc.atenciones.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.atenciones.modelos.Paciente;
import com.duoc.atenciones.servicios.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    
    private List<Paciente> pacientes = new ArrayList<>();

    //creacion de datos de pacientes
    public PacienteController(PacienteService pacienteService) {
        pacientes.add(new Paciente(1L, "Juan", "Perez", "12345678-9", "1980-01-012", "juanperez@ymail.com", "987654321"));
        pacientes.add(new Paciente(2L, "Maria", "Gonzalez", "98765432-1", "1990-05-15", "mariag@ymail.com", "9990008743"));
        pacientes.add(new Paciente(3L, "Carlos", "Ramirez", "11223344-5", "1975-09-30", "carlosr@ymail.com", "912345678"));
        pacientes.add(new Paciente(4L, "Ana", "Lopez", "55667788-0", "1985-12-20", "analopez@yahoo.net", "923456789"));
        pacientes.add(new Paciente(5L, "Luis", "Martinez", "66778899-1", "1992-03-10", "luizm@hotmail.com", "934567890"));
        pacientes.add(new Paciente(6L, "Sofia", "Hernandez", "77889900-2", "1988-07-25", "sofiahh@hotmail.com", "945678901"));
        pacientes.add(new Paciente(7L, "Diego", "Sanchez", "88990011-3", "1978-11-05", "diego.sanchezœ@gmail.com", "956789012"));
        pacientes.add(new Paciente(8L, "Elena", "Torres", "99001122-4", "1995-04-18", "elenatorres@outlook.com", "967890123"));
    }

    //ver todos los pacientes
    @GetMapping
    public List<Paciente> obtenerPacientes() {
        return pacientes;
    }

    //ver por id
    @GetMapping("/{id}")
    public Paciente obtenerPacientePorId(@PathVariable Long id) {
        return pacientes.stream()
                .filter(paciente -> paciente.getId().equals(id))
                .findFirst()
                .orElse(null);
    }



    
}
