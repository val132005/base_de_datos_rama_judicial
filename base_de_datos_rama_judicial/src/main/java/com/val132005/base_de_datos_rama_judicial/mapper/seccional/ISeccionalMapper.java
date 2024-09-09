package com.val132005.base_de_datos_rama_judicial.mapper.seccional;

import com.val132005.base_de_datos_rama_judicial.mapper.IMapperGenerico;
import com.val132005.base_de_datos_rama_judicial.model.seccional.SeccionalDTO;
import com.val132005.base_de_datos_rama_judicial.model.seccional.SeccionalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)

public interface ISeccionalMapper extends IMapperGenerico<SeccionalEntity, SeccionalDTO> {

    @Override
    @Mapping(target = "idSeccional", ignore = true)
    SeccionalEntity loadEntity(SeccionalDTO dto);

    @Override
    SeccionalDTO loadDto(SeccionalEntity entity);

    @Override
    List<SeccionalEntity> loadEntities(List<SeccionalDTO> dtos);

    @Override
    List<SeccionalDTO> loadDtos(List<SeccionalEntity> entities);



}
