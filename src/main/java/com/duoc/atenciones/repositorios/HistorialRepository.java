package com.duoc.atenciones.repositorios;

import com.duoc.atenciones.modelos.HistorialMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialRepository extends JpaRepository<HistorialMedico, Long> {
}
