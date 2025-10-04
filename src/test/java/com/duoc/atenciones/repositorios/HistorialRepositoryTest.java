package com.duoc.atenciones.repositorios;

import com.duoc.atenciones.modelos.HistorialMedico;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class HistorialRepositoryTest {

    @Autowired
    private HistorialRepository historialRepository;

    @Test
    public void guardarHistorialTest(){
        //Arrange
        HistorialMedico historial = new HistorialMedico();
        historial.setDiagnostico("Cefalea");

        //Act
        HistorialMedico resultado = historialRepository.save(historial);

        //Assert
        assertNotNull(resultado.getId());
        assertEquals("Cefalea", resultado.getDiagnostico());
    }
}

