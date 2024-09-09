package com.val132005.base_de_datos_rama_judicial.repository.perfil;

import com.val132005.base_de_datos_rama_judicial.model.perfil.PerfilEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerfilRepository extends JpaRepository<PerfilEntity, Long> {

    Optional<PerfilEntity> findByNombrePerfil(String nombrePerfil);

}
