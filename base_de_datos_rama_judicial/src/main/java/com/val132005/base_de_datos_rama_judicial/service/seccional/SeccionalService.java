package com.val132005.base_de_datos_rama_judicial.service.seccional;

import com.val132005.base_de_datos_rama_judicial.mapper.seccional.ISeccionalMapper;
import com.val132005.base_de_datos_rama_judicial.model.common.Estado;
import com.val132005.base_de_datos_rama_judicial.model.seccional.SeccionalDTO;
import com.val132005.base_de_datos_rama_judicial.model.seccional.SeccionalEntity;
import com.val132005.base_de_datos_rama_judicial.repository.seccional.SeccionalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeccionalService {

    private SeccionalRepository seccionalRepository;
    private ISeccionalMapper mapperSeccional;

    public SeccionalService(SeccionalRepository seccionalRepository, ISeccionalMapper mapperSeccional) {
        this.seccionalRepository = seccionalRepository;
        this.mapperSeccional = mapperSeccional;
    }

    public List<SeccionalDTO> listarSeccionales(){
        return mapperSeccional.loadDtos(seccionalRepository.findAll());
    }

    public SeccionalDTO registrarSeccional(SeccionalDTO seccionalDTO){
        SeccionalEntity seccionalEntity = mapperSeccional.loadEntity(seccionalDTO);
        return mapperSeccional.loadDto(seccionalRepository.save(seccionalEntity));
    }

    public SeccionalEntity obtenerSeccionalPorNombre(String nombreSeccional){
        return seccionalRepository.findByNombreSeccional(nombreSeccional)
                .orElseThrow(()->{
                    return new RuntimeException("La seccional con nombre "+ nombreSeccional + " no existe");
                });
    }

    public SeccionalEntity obtenerSeccionalPorId(Long id){
        return seccionalRepository.findById(id)
                .orElseThrow(()->{
                    return new RuntimeException("La seccional con id "+ id + " no existe");
                });
    }

    public SeccionalDTO consultarSeccionalPorNombre(String nombreSeccional){
        return mapperSeccional.loadDto(obtenerSeccionalPorNombre(nombreSeccional));
    }

    public SeccionalDTO actualizarSeccional(String nombreSeccional, SeccionalDTO seccionalDTO){
        SeccionalEntity seccionalEntity = obtenerSeccionalPorNombre(nombreSeccional);
        if (seccionalDTO.getEstado()==null){
            throw  new IllegalArgumentException("El estado de la seccional no puede sel nulo");
        }
        seccionalEntity.setNombreSeccional(seccionalDTO.getNombreSeccional());
        seccionalEntity.setEstado(Estado.valueOf(seccionalDTO.getEstado()));
        return mapperSeccional.loadDto(seccionalRepository.save(seccionalEntity));
    }

    public SeccionalDTO inactivarSeccional(String nombreSeccional){
        SeccionalEntity seccionalEntity = obtenerSeccionalPorNombre(nombreSeccional);
        seccionalEntity.setEstado(Estado.INACTIVO);
        return mapperSeccional.loadDto(seccionalRepository.save(seccionalEntity));
    }

    public SeccionalDTO activarSeccional(String nombreSeccional){
        SeccionalEntity seccionalEntity = obtenerSeccionalPorNombre(nombreSeccional);
        seccionalEntity.setEstado(Estado.ACTIVO);
        return mapperSeccional.loadDto(seccionalRepository.save(seccionalEntity));
    }


}
