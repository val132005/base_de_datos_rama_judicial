package com.val132005.base_de_datos_rama_judicial.service.codigo;

import com.val132005.base_de_datos_rama_judicial.mapper.codigo.ICodigoMapper;
import com.val132005.base_de_datos_rama_judicial.model.codigo.CodigoDTO;
import com.val132005.base_de_datos_rama_judicial.model.codigo.CodigoEntity;
import com.val132005.base_de_datos_rama_judicial.model.common.Estado;
import com.val132005.base_de_datos_rama_judicial.repository.codigo.CodigoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodigoService {

    private CodigoRepository codigoRepository;
    private ICodigoMapper mapperCodigo;

    public  CodigoService (CodigoRepository codigoRepository, ICodigoMapper mapperCodigo){
        this.codigoRepository = codigoRepository;
        this.mapperCodigo = mapperCodigo;
    }

    public List<CodigoDTO> listarCodigos (){
        return mapperCodigo.loadDtos(codigoRepository.findAll());
    }

    public CodigoDTO registrarCodigo(CodigoDTO codigoDTO){
        CodigoEntity codigoEntity = mapperCodigo.loadEntity(codigoDTO);
        return mapperCodigo.loadDto(codigoRepository.save(codigoEntity));
    }

    private CodigoEntity obtenerCodigoPorNumero(int numeroCodigo){
        return codigoRepository.findByNumeroCodigo(numeroCodigo)
                .orElseThrow(()->{
                    return new RuntimeException("El codigo con numero "+numeroCodigo+" no existe");
                });
    }

    public CodigoEntity obtenerCodigoPorId(long id){
        return codigoRepository.findById(id)
                .orElseThrow(()->{
                    return new RuntimeException("El codigo con id "+id+" no existe");
                });
    }

    public CodigoDTO consultarCodigoPorNumeroDeCodigo(int numeroCodigo){
        return mapperCodigo.loadDto(obtenerCodigoPorNumero(numeroCodigo));
    }

    public CodigoDTO actualizarCodigo(int numeroCodigo, CodigoDTO codigoDTO){
        CodigoEntity codigoEntity = obtenerCodigoPorNumero(numeroCodigo);
        if (codigoDTO.getEstado()==null){
            throw new IllegalArgumentException("El estado del acuerdo no puede sel nulo");
        }
        codigoEntity.setNumeroCodigo(codigoDTO.getNumeroCodigo());
        codigoEntity.setDescripcionCargo(codigoDTO.getDescripcionCargo());
        codigoEntity.setGrado(codigoDTO.getGrado());
        codigoEntity.setEstado(Estado.valueOf(codigoDTO.getEstado()));
        return mapperCodigo.loadDto(codigoRepository.save(codigoEntity));
    }

    public CodigoDTO inactivarCodigo(int numeroCodigo){
        CodigoEntity codigoEntity = obtenerCodigoPorNumero(numeroCodigo);
        codigoEntity.setEstado(Estado.INACTIVO);
        return mapperCodigo.loadDto(codigoRepository.save(codigoEntity));
    }

    public CodigoDTO activarCodigo(int numeroCodigo){
        CodigoEntity codigoEntity = obtenerCodigoPorNumero(numeroCodigo);
        codigoEntity.setEstado(Estado.ACTIVO);
        return mapperCodigo.loadDto(codigoRepository.save(codigoEntity));
    }

}
