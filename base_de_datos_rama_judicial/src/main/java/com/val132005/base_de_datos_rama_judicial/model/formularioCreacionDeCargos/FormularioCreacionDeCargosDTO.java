package com.val132005.base_de_datos_rama_judicial.model.formularioCreacionDeCargos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FormularioCreacionDeCargosDTO {

    @NotNull
    private long idFormularioCreacionDeCargos;

    @NotNull
    private int cantidadDeCargos;

    @NotNull
    private String estado;

    @NotNull
    private String idAcuerdo;


    @NotNull
    private Long idSeccional;


    @NotNull
    private Long idPerfil;


    @NotNull
    private Long idProfesion;


    @NotNull
    private Long idCodigo;



}
