package com.val132005.base_de_datos_rama_judicial.repository.formularioCreacionDeCargos;

import com.val132005.base_de_datos_rama_judicial.model.formularioCreacionDeCargos.FormularioCreacionDeCargosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FormularioCreacionDeCargosRepository extends JpaRepository<FormularioCreacionDeCargosEntity, Long> {

    Optional<FormularioCreacionDeCargosEntity> findByIdFormularioCreacionDeCargos(long idFormularioCreacionDeCargos);

}
