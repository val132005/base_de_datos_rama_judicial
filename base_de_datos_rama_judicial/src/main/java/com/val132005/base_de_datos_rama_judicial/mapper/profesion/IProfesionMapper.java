package com.val132005.base_de_datos_rama_judicial.mapper.profesion;

import com.val132005.base_de_datos_rama_judicial.mapper.IMapperGenerico;
import com.val132005.base_de_datos_rama_judicial.model.profesion.ProfesionDTO;
import com.val132005.base_de_datos_rama_judicial.model.profesion.ProfesionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)

public interface IProfesionMapper  extends IMapperGenerico<ProfesionEntity, ProfesionDTO> {

    @Override
    @Mapping(target = "idProfesion", ignore = true)
    ProfesionEntity loadEntity(ProfesionDTO dto);

    @Override
    ProfesionDTO loadDto(ProfesionEntity entity);

    @Override
    List<ProfesionEntity> loadEntities(List<ProfesionDTO> dtos);

    @Override
    List<ProfesionDTO> loadDtos(List<ProfesionEntity> entities);



}
