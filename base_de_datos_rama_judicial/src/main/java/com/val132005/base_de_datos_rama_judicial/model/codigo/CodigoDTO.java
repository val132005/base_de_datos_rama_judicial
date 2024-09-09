package com.val132005.base_de_datos_rama_judicial.model.codigo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CodigoDTO {

    @NotNull
    private int numeroCodigo;

    @NotNull

    private String DescripcionCargo;

    @NotNull

    private int grado;

    @NotNull
    private String estado;

}
