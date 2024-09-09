package com.val132005.base_de_datos_rama_judicial.mapper.acuerdo;


import com.val132005.base_de_datos_rama_judicial.mapper.IMapperGenerico;
import com.val132005.base_de_datos_rama_judicial.model.acuerdo.AcuerdoDTO;
import com.val132005.base_de_datos_rama_judicial.model.acuerdo.AcuerdoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface IAcuerdoMapper extends IMapperGenerico<AcuerdoEntity, AcuerdoDTO> {
    @Override
    @Mapping(target = "idAcuerdo", ignore = true)
    AcuerdoEntity loadEntity(AcuerdoDTO dto);

    @Override
    AcuerdoDTO loadDto(AcuerdoEntity entity);

    @Override
    List<AcuerdoEntity> loadEntities(List<AcuerdoDTO> dtos);

    @Override
    List<AcuerdoDTO> loadDtos(List<AcuerdoEntity> entities);






}
