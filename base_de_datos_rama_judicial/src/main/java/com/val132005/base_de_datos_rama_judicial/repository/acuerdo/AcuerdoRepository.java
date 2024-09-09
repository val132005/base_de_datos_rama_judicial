package com.val132005.base_de_datos_rama_judicial.repository.acuerdo;

import com.val132005.base_de_datos_rama_judicial.model.acuerdo.AcuerdoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AcuerdoRepository extends JpaRepository<AcuerdoEntity, String> {

    Optional<AcuerdoEntity> findByPrefijoAcuerdoAndAnoAcuerdoAndNumeroAcuerdo(String prefijoAcuerdo, int anoAcuerdo, long numeroAcuerdo);

}
