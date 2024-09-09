package com.val132005.base_de_datos_rama_judicial.repository.profesion;

import com.val132005.base_de_datos_rama_judicial.model.profesion.ProfesionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfesionRepository extends JpaRepository<ProfesionEntity, Long> {

    Optional<ProfesionEntity> findByNombreProfesion(String nombreProfesion);
}
