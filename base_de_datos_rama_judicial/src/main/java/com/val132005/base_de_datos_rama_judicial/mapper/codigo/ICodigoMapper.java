package com.val132005.base_de_datos_rama_judicial.mapper.codigo;

import com.val132005.base_de_datos_rama_judicial.mapper.IMapperGenerico;
import com.val132005.base_de_datos_rama_judicial.model.codigo.CodigoDTO;
import com.val132005.base_de_datos_rama_judicial.model.codigo.CodigoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ICodigoMapper extends IMapperGenerico<CodigoEntity, CodigoDTO> {
    @Override
    @Mapping(target = "idCodigo", ignore = true)
    CodigoEntity loadEntity(CodigoDTO dto);

    @Override
    CodigoDTO loadDto(CodigoEntity entity);

    @Override
    List<CodigoEntity> loadEntities(List<CodigoDTO> dtos);

    @Override
    List<CodigoDTO> loadDtos(List<CodigoEntity> entities);




}
