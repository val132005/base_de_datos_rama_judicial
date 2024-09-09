package com.val132005.base_de_datos_rama_judicial.repository.seccional;

import com.val132005.base_de_datos_rama_judicial.model.seccional.SeccionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeccionalRepository extends JpaRepository<SeccionalEntity, Long> {
    Optional<SeccionalEntity> findByNombreSeccional(String nombreSeccional);
}
