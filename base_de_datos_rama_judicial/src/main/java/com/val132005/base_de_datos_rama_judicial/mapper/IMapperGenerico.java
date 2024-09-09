package com.val132005.base_de_datos_rama_judicial.mapper;

import java.util.List;

public interface IMapperGenerico  <E, D>{

    E loadEntity(D dto);
    D loadDto(E entity);

    List<E> loadEntities(List<D> dtos);
    List<D> loadDtos(List<E> entities);

}
