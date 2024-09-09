package com.val132005.base_de_datos_rama_judicial.mapper.formularioCreacionDeCargo;

import com.val132005.base_de_datos_rama_judicial.model.formularioCreacionDeCargos.FormularioCreacionDeCargosDTO;
import com.val132005.base_de_datos_rama_judicial.model.formularioCreacionDeCargos.FormularioCreacionDeCargosEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")

public interface IFromularioCreacionDeCargosMapper {

    IFromularioCreacionDeCargosMapper INSTANCE = Mappers.getMapper(IFromularioCreacionDeCargosMapper.class);

    @Mapping(source = "acuerdo.idAcuerdo", target = "idAcuerdo")
    @Mapping(source = "seccional.idSeccional", target = "idSeccional")
    @Mapping(source = "perfil.idPerfil", target = "idPerfil")
    @Mapping(source = "profesion.idProfesion", target = "idProfesion")
    @Mapping(source = "codigo.idCodigo", target = "idCodigo")

    FormularioCreacionDeCargosDTO formularioCreacionDeCargosEntityToDTO(FormularioCreacionDeCargosEntity formularioCreacionDeCargosEntity);
    @Mapping(source = "idAcuerdo", target = "acuerdo.idAcuerdo")
    @Mapping(source = "idSeccional", target = "seccional.idSeccional")
    @Mapping(source = "idPerfil", target = "perfil.idPerfil")
    @Mapping(source = "idProfesion", target = "profesion.idProfesion")
    @Mapping(source = "idCodigo", target = "codigo.idCodigo")
    FormularioCreacionDeCargosEntity formularioCreacionDeCargosDTOToEntity(FormularioCreacionDeCargosDTO formularioCreacionDeCargosDTO);

    List<FormularioCreacionDeCargosDTO> formularioCreacionDeCargosEntitiesToDTOs(List<FormularioCreacionDeCargosEntity> formularioCreacionDeCargosEntities);

    List<FormularioCreacionDeCargosEntity> formularioCreacionDeCargosDTOsToEntities(List<FormularioCreacionDeCargosDTO> formularioCreacionDeCargosDTOs);

}

