package com.duoc.atenciones.controladores;

import com.duoc.atenciones.modelos.Paciente;
import com.duoc.atenciones.servicios.PacienteService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(PacienteController.class)
public class PacienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private PacienteService pacienteService;

    @Test
    public void obtenerTodosLosPacientesTest() throws Exception{
        //Arrange
        Paciente paciente1 = new Paciente();
        paciente1.setNombre("Juan");
        paciente1.setApellido("Perez");
        paciente1.setRut("12.345.678-9");
        paciente1.setTelefono("912345678");
        paciente1.setEmail("jp@gmail.com");
        paciente1.setFechaNacimiento("1967-04-23");
        Paciente paciente2 = new Paciente();
        paciente2.setNombre("Maria");
        paciente2.setApellido("Loyola");
        paciente2.setRut("23.456.789-0");
        paciente2.setTelefono("923456789");
        paciente2.setEmail("ml@gmail.com");
        paciente2.setFechaNacimiento("1980-12-05");

        List<Paciente> pacientes = Arrays.asList(paciente1, paciente2);
        when(pacienteService.obtenerPacientes()).thenReturn(pacientes);

        //Act y Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/pacientes"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.aMapWithSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.pacienteList[0].apellido", Matchers.is("Perez")))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.pacienteList[1].apellido", Matchers.is("Loyola")));
    }
}
