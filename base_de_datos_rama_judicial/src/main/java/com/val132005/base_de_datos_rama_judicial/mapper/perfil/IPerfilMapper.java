package com.val132005.base_de_datos_rama_judicial.mapper.perfil;

import com.val132005.base_de_datos_rama_judicial.mapper.IMapperGenerico;
import com.val132005.base_de_datos_rama_judicial.model.perfil.PerfilDTO;
import com.val132005.base_de_datos_rama_judicial.model.perfil.PerfilEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)

public interface IPerfilMapper extends IMapperGenerico<PerfilEntity, PerfilDTO> {
    @Override
    @Mapping(target = "idPerfil", ignore = true)
    PerfilEntity loadEntity(PerfilDTO dto);

    @Override
    PerfilDTO loadDto(PerfilEntity entity);

    @Override
    List<PerfilEntity> loadEntities(List<PerfilDTO> dtos);

    @Override
    List<PerfilDTO> loadDtos(List<PerfilEntity> entities);

}
