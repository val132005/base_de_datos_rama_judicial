package com.val132005.base_de_datos_rama_judicial.model.formularioCreacionDeCargos;

import com.val132005.base_de_datos_rama_judicial.model.acuerdo.AcuerdoEntity;
import com.val132005.base_de_datos_rama_judicial.model.codigo.CodigoEntity;
import com.val132005.base_de_datos_rama_judicial.model.common.Estado;
import com.val132005.base_de_datos_rama_judicial.model.perfil.PerfilEntity;
import com.val132005.base_de_datos_rama_judicial.model.profesion.ProfesionEntity;
import com.val132005.base_de_datos_rama_judicial.model.seccional.SeccionalEntity;
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
@Table(name = "formularioCreacionDeCargos")
public class FormularioCreacionDeCargosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idFormularioCreacionDeCargos;

    @Column(name = "cantidadDeCargos")
    private int cantidadDeCargos;

    @Column
    @Enumerated(EnumType.STRING)
    private Estado estado;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idAcuerdo", referencedColumnName = "idAcuerdo")
    private AcuerdoEntity acuerdo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idSeccional", referencedColumnName = "idSeccional")
    private SeccionalEntity seccional;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idPerfil", referencedColumnName = "idPerfil")
    private PerfilEntity perfil;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProfesion", referencedColumnName = "idProfesion")
    private ProfesionEntity profesion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCodigo", referencedColumnName = "idCodigo")
    private CodigoEntity codigo;

    /*

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idGrado", referencedColumnName = "idGrado")
    private GradoEntity idGrado;


     */










}
