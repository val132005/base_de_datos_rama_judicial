package com.val132005.base_de_datos_rama_judicial.service.profesion;

import com.val132005.base_de_datos_rama_judicial.mapper.profesion.IProfesionMapper;
import com.val132005.base_de_datos_rama_judicial.model.common.Estado;
import com.val132005.base_de_datos_rama_judicial.model.profesion.ProfesionDTO;
import com.val132005.base_de_datos_rama_judicial.model.profesion.ProfesionEntity;
import com.val132005.base_de_datos_rama_judicial.repository.profesion.ProfesionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesionService {

    private ProfesionRepository profesionRepository;
    private IProfesionMapper mapperProfesion;

    public ProfesionService(ProfesionRepository profesionRepository, IProfesionMapper mapperProfesion) {
        this.profesionRepository = profesionRepository;
        this.mapperProfesion = mapperProfesion;
    }

    public List<ProfesionDTO> listarProfesiones(){
        return mapperProfesion.loadDtos(profesionRepository.findAll());
    }

    public ProfesionDTO registrarProfesiones(ProfesionDTO profesionDTO){
        ProfesionEntity profesionEntity = mapperProfesion.loadEntity(profesionDTO);
        return mapperProfesion.loadDto(profesionRepository.save(profesionEntity));
    }

    private ProfesionEntity obtenerProfesionPorNombre(String nombreProfesion){
        return profesionRepository.findByNombreProfesion(nombreProfesion)
                .orElseThrow(()->{
                    return new RuntimeException("La profesion con nombre "+nombreProfesion+" no existe");
                });
    }

    public ProfesionEntity obtenerProfesionPorId(Long id){
        return profesionRepository.findById(id)
                .orElseThrow(()->{
                    return new RuntimeException("La profesion con id "+id+" no existe");
                });
    }

    public ProfesionDTO conultarProfesionPorNombre(String nombreProfesion){
        return mapperProfesion.loadDto(obtenerProfesionPorNombre(nombreProfesion)) ;

    }

    public ProfesionDTO actualizarProfesion(String nombreProfesion, ProfesionDTO profesionDTO){
        ProfesionEntity profesionEntity = obtenerProfesionPorNombre(nombreProfesion);
        if (profesionDTO.getEstado()==null){
            throw new IllegalArgumentException("El estado de la profesion no puede sel nulo");
        }
        profesionEntity.setNombreProfesion(profesionDTO.getNombreProfesion());
        profesionEntity.setEstado(Estado.valueOf(profesionDTO.getEstado()));
        return mapperProfesion.loadDto(profesionEntity);
    }

    public ProfesionDTO inactivarProfesion(String nombreProfesion){
        ProfesionEntity profesionEntity = obtenerProfesionPorNombre(nombreProfesion);
        profesionEntity.setEstado(Estado.INACTIVO);
        return mapperProfesion.loadDto(profesionEntity);
    }

    public ProfesionDTO activarProfesion(String nombreProfesion){
        ProfesionEntity profesionEntity = obtenerProfesionPorNombre(nombreProfesion);
        profesionEntity.setEstado(Estado.ACTIVO);
        return mapperProfesion.loadDto(profesionEntity);
    }


}
