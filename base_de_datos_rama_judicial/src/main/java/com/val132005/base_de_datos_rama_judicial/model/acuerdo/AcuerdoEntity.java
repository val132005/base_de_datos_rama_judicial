package com.val132005.base_de_datos_rama_judicial.model.acuerdo;

import com.val132005.base_de_datos_rama_judicial.model.common.Estado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "acuerdos")
public class AcuerdoEntity {

    @Id
    @Column(name = "idAcuerdo")
    private String idAcuerdo;

    @Column(name = "prefijoAcuerdo")
    private String prefijoAcuerdo;

    @Column(name = "anoAcuerdo")
    private int anoAcuerdo;

    @Column(name = "numeroAcuerdo")
    private long numeroAcuerdo;

    @Column
    @Enumerated(EnumType.STRING)
    private Estado estado;











}
