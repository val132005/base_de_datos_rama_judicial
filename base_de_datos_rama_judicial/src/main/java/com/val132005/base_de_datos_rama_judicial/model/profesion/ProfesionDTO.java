package com.val132005.base_de_datos_rama_judicial.model.profesion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesionDTO {

    @NotNull
    private String nombreProfesion;

    @NotNull
    private String estado;


}
