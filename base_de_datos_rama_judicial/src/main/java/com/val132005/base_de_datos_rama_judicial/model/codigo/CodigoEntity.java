package com.val132005.base_de_datos_rama_judicial.model.codigo;

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
@Table(name = "codigos")
public class CodigoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCodigo;

    @Column(name = "numeroCodigo", unique = true)
    private int numeroCodigo;

    @Column(name = "DescripcionCargo")

    private String DescripcionCargo;

    @Column(name = "grado")

    private int grado;

    @Column
    @Enumerated(EnumType.STRING)
    private Estado estado;


}
