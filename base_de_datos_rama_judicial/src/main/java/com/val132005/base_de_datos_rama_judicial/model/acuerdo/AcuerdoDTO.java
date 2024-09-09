package com.val132005.base_de_datos_rama_judicial.model.acuerdo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AcuerdoDTO {

    @NotNull
    private String prefijoAcuerdo;

    @NotNull

    private int anoAcuerdo;

    @NotNull
    private long numeroAcuerdo;

    @NotNull
    private String estado;



}
