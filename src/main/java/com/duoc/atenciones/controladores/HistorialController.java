package com.duoc.atenciones.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.duoc.atenciones.modelos.HistorialMedico;

@RestController
@RequestMapping("/historiales")
public class HistorialController {
    
    private List<HistorialMedico> historialesMedicos= new ArrayList<>();
    public HistorialController() {
        historialesMedicos.add(new HistorialMedico(1L, 1L, "23/03/2024", "Consulta", "Medicina General", "Resfrio comun", "Rigotax, limonada, ibuprofeno y cobefen", "Paciente debe regresar en una semana si no mejora"));
        historialesMedicos.add(new HistorialMedico(2L, 2L, "15/02/2024", "Urgencia", "Traumatologia", "Esguince de tobillo", "Reposo, hielo, vendaje compresivo y elevacion del miembro afectado", "Control en 10 dias"));
        historialesMedicos.add(new HistorialMedico(3L, 3L, "10/01/2024", "Consulta", "Pediatria", "Varicela", "Antihistaminicos, baños de avena y mantener uñas cortas", "Aislamiento por 7 dias"));
        historialesMedicos.add(new HistorialMedico(4L, 4L, "05/03/2024", "Consulta", "Dermatologia", "Acne leve", "Limpieza facial diaria, uso de gel antibacterial y evitar productos grasos", "Reevaluacion en 1 mes"));
        historialesMedicos.add(new HistorialMedico(5L, 5L, "20/02/2024", "Urgencia", "Cardiologia", "Hipertension arterial", "Dieta baja en sal, ejercicio regular y medicacion antihipertensiva", "Control en 1 mes"));
        historialesMedicos.add(new HistorialMedico(6L, 6L, "28/02/2024", "Consulta", "Ginecologia", "Infeccion urinaria", "Antibioticos, aumento de ingesta de agua y evitar irritantes", "Control en 1 semana"));
        historialesMedicos.add(new HistorialMedico(7L, 7L, "12/03/2024", "Consulta", "Oftalmologia", "Conjuntivitis", "Colirios antibioticos, compresas frias y evitar frotarse los ojos", "Reevaluacion en 3 dias"));
        historialesMedicos.add(new HistorialMedico(8L, 8L, "18/03/2024", "Urgencia", "Gastroenterologia", "Gastritis aguda", "Dieta blanda, antiacidos y evitar irritantes", "Control en 2 semanas"));
    }

    //ver todos los historiales medicos
    @GetMapping
    public List<HistorialMedico> obtenerHistorialesMedicos() {
        return historialesMedicos;
    }

    //ver historial medico por id de historial
    @GetMapping("/{id}")
    public HistorialMedico obtenerHistorialPorId(@PathVariable Long id) {
        return historialesMedicos.stream()
                .filter(historial -> historial.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
