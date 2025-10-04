package com.duoc.atenciones.servicios;

import com.duoc.atenciones.modelos.Paciente;
import com.duoc.atenciones.repositorios.PacienteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PacienteServiceTest {

    @InjectMocks
    private PacienteService pacienteService;

    @Mock
    private PacienteRepository pacienteRepository;

    @Test
    public void guardarPacienteTest(){
        //Arrange
        Paciente paciente = new Paciente();
        paciente.setNombre("Juan");
        paciente.setApellido("Perez");
        paciente.setRut("12.345.678-9");
        paciente.setTelefono("912345678");
        paciente.setEmail("jp@gmail.com");
        paciente.setFechaNacimiento("1967-04-23");

        when(pacienteRepository.save(any())).thenReturn(paciente);

        //Act
        Paciente resultado = pacienteService.guardarPaciente(paciente);

        //Assert
        assertEquals("Perez", resultado.getApellido());
    }
}
