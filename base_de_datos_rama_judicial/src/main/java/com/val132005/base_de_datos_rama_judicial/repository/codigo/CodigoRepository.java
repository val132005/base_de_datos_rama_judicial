package com.val132005.base_de_datos_rama_judicial.repository.codigo;

import com.val132005.base_de_datos_rama_judicial.model.codigo.CodigoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CodigoRepository extends JpaRepository<CodigoEntity, Long> {

    Optional<CodigoEntity> findByNumeroCodigo(int numeroCodigo);

}
