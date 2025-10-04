package com.duoc.atenciones.repositorios;

import com.duoc.atenciones.modelos.Paciente;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PacienteRepositoryTest {

    @Autowired
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

        //Act
        Paciente resultado = pacienteRepository.save(paciente);

        //Assert
        assertNotNull(resultado.getId());
        assertEquals("Juan", resultado.getNombre());
    }
}
