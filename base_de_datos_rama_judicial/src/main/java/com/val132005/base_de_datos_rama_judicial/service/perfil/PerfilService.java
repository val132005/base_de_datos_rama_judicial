package com.val132005.base_de_datos_rama_judicial.service.perfil;

import com.val132005.base_de_datos_rama_judicial.mapper.perfil.IPerfilMapper;
import com.val132005.base_de_datos_rama_judicial.model.common.Estado;
import com.val132005.base_de_datos_rama_judicial.model.perfil.PerfilDTO;
import com.val132005.base_de_datos_rama_judicial.model.perfil.PerfilEntity;
import com.val132005.base_de_datos_rama_judicial.repository.perfil.PerfilRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService {

    private PerfilRepository perfilRepository;
    private IPerfilMapper mapperPerfil;

    public PerfilService(PerfilRepository perfilRepository, IPerfilMapper mapperPerfil) {
        this.perfilRepository = perfilRepository;
        this.mapperPerfil = mapperPerfil;
    }

    public List<PerfilDTO> listarPerfiles(){
        return mapperPerfil.loadDtos(perfilRepository.findAll());
    }

    public PerfilDTO registrarPerfil(PerfilDTO perfilDTO){
        PerfilEntity perfilEntity = mapperPerfil.loadEntity(perfilDTO);
        return mapperPerfil.loadDto(perfilRepository.save(perfilEntity));
    }

    private PerfilEntity obtenerPerfilPorNombre(String nombrePerfil){
        return perfilRepository.findByNombrePerfil(nombrePerfil)
                .orElseThrow(()->{
                    return new RuntimeException("El perfil con nombre "+nombrePerfil+" no existe");
                });
    }

    public PerfilEntity obtenerPerfilPorId(long id){
        return perfilRepository.findById(id)
                .orElseThrow(()->{
                    return new RuntimeException("El perfil con id "+id+" no existe");
                });
    }

    public PerfilDTO consultarPerfilPorNombre(String nombrePerfil){
        return mapperPerfil.loadDto(obtenerPerfilPorNombre(nombrePerfil));
    }

    public PerfilDTO actualizarPerfil(String nombrePerfil, PerfilDTO perfilDTO){
        PerfilEntity perfilEntity = obtenerPerfilPorNombre(nombrePerfil);
        if (perfilDTO.getEstado()==null){
            throw new IllegalArgumentException("El estado del acuerdo no puede sel nulo");
        }
        perfilEntity.setNombrePerfil(perfilDTO.getNombrePerfil());
        perfilEntity.setEstado(Estado.valueOf(perfilDTO.getEstado()));
        return mapperPerfil.loadDto(perfilRepository.save(perfilEntity));
    }

    public PerfilDTO inactivarPerfil(String nombrePerfil){
        PerfilEntity perfilEntity = obtenerPerfilPorNombre(nombrePerfil);
        perfilEntity.setEstado(Estado.INACTIVO);
        return mapperPerfil.loadDto(perfilRepository.save(perfilEntity));
    }

    public PerfilDTO activarPerfil(String nombrePerfil){
        PerfilEntity perfilEntity = obtenerPerfilPorNombre(nombrePerfil);
        perfilEntity.setEstado(Estado.ACTIVO);
        return mapperPerfil.loadDto(perfilRepository.save(perfilEntity));
    }


}
