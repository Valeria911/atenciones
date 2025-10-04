package com.duoc.atenciones.controladores;

import com.duoc.atenciones.modelos.HistorialMedico;
import com.duoc.atenciones.servicios.HistorialService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.assertj.MockMvcTester;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@WebMvcTest(HistorialController.class)
public class HistorialControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private HistorialService historialService;

    @Test
    public void obtenerTodosLosHistorialesTest() throws Exception {
        //Arrange
        HistorialMedico historial1 = new HistorialMedico();
        historial1.setTratamiento("Paracetamol");
        HistorialMedico historial2 = new HistorialMedico();
        historial2.setTratamiento("Azitromicina");
        List<HistorialMedico> historiales = Arrays.asList(historial1, historial2);
        when(historialService.obtenerTodos()).thenReturn(historiales);

        //Act y Assert
        mockMvc.perform(MockMvcRequestBuilders.get("/historiales"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.aMapWithSize(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.historialMedicoList[0].tratamiento", Matchers.is("Paracetamol")))
                .andExpect(MockMvcResultMatchers.jsonPath("$._embedded.historialMedicoList[1].tratamiento", Matchers.is("Azitromicina")));

    }

}
