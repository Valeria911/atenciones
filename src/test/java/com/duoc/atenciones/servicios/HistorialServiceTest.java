package com.duoc.atenciones.servicios;

import com.duoc.atenciones.modelos.HistorialMedico;
import com.duoc.atenciones.repositorios.HistorialRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class HistorialServiceTest {

    @InjectMocks
    private HistorialService historialService;

    @Mock
    private HistorialRepository historialRepository;

    @Test
    public void guardarHistorialTest(){
        //Arrange
        HistorialMedico historial = new HistorialMedico();
        historial.setEspecialidadMedica("Neurologia");

        when(historialRepository.save(any())).thenReturn(historial);

        //Act
        HistorialMedico resultado = historialService.guardarHistorial(historial);

        //Assert
        assertEquals("Neurologia", resultado.getEspecialidadMedica());
    }
}


