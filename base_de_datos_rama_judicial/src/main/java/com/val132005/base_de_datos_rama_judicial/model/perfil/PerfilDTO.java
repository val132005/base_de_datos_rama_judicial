package com.val132005.base_de_datos_rama_judicial.model.perfil;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PerfilDTO {
    @NotNull
    private String nombrePerfil;

    @NotNull
    private String estado;
}
