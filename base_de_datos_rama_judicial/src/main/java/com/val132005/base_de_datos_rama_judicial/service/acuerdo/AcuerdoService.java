package com.val132005.base_de_datos_rama_judicial.service.acuerdo;

import com.val132005.base_de_datos_rama_judicial.mapper.acuerdo.IAcuerdoMapper;
import com.val132005.base_de_datos_rama_judicial.model.acuerdo.AcuerdoDTO;
import com.val132005.base_de_datos_rama_judicial.model.acuerdo.AcuerdoEntity;
import com.val132005.base_de_datos_rama_judicial.model.common.Estado;
import com.val132005.base_de_datos_rama_judicial.repository.acuerdo.AcuerdoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcuerdoService {

    private AcuerdoRepository acuerdoRepository;
    private IAcuerdoMapper mapperAcuerdo;

    public AcuerdoService(AcuerdoRepository acuerdoRepository, IAcuerdoMapper mapperAcuerdo) {
        this.acuerdoRepository = acuerdoRepository;
        this.mapperAcuerdo = mapperAcuerdo;
    }

    public List<AcuerdoDTO> listarAcuerdos(){
        List<AcuerdoDTO> acuerdosDTOList = mapperAcuerdo.loadDtos(acuerdoRepository.findAll());
        return acuerdosDTOList;

    }

    private String generarId(String prefijoAcuerdo, int anoAcuerdo, long numeroAcuerdo){
        return prefijoAcuerdo + " - " + anoAcuerdo + " - "+ numeroAcuerdo;
    }

    public AcuerdoDTO registrarAcuerdo(AcuerdoDTO acuerdoDTO){
        String idAcuerdo= generarId(acuerdoDTO.getPrefijoAcuerdo(), acuerdoDTO.getAnoAcuerdo(), acuerdoDTO.getNumeroAcuerdo());
        AcuerdoEntity acuerdoEntity = mapperAcuerdo.loadEntity(acuerdoDTO);
        acuerdoEntity.setIdAcuerdo(idAcuerdo);
        AcuerdoDTO acuerdoGuardado = mapperAcuerdo.loadDto(acuerdoRepository.save(acuerdoEntity));
        return acuerdoGuardado;
    }


    private AcuerdoEntity obtenerAcuerdoPorPrefijoAcuerdoAndAnoAcuerdoAndNumeroAcuerdo(String prefijoAcuerdo, int anoAcuerdo, long numeroAcuerdo){
        return acuerdoRepository.findByPrefijoAcuerdoAndAnoAcuerdoAndNumeroAcuerdo(prefijoAcuerdo,anoAcuerdo, numeroAcuerdo)
                .orElseThrow(()->{
                    return new RuntimeException("El acuerdo titulado " + prefijoAcuerdo+" "+anoAcuerdo+" "+numeroAcuerdo  + " no existe");
                });
    }

    public AcuerdoEntity obtenerAcuerdoPorId(String id){
        return acuerdoRepository.findById(id)
                .orElseThrow(()->{
                    return new RuntimeException("El acuerdo con id " + id  + " no existe");
                });
    }

    public AcuerdoDTO consultarAcuerdoPorNombre(String prefijoAcuerdo, int anoAcuerdo, long numeroAcuerdo){
        return mapperAcuerdo.loadDto(obtenerAcuerdoPorPrefijoAcuerdoAndAnoAcuerdoAndNumeroAcuerdo(prefijoAcuerdo, anoAcuerdo, numeroAcuerdo));

    }

    public AcuerdoDTO actualizarAcuerdo(String prefijoAcuerdo, int anoAcuerdo, long numeroAcuerdo, AcuerdoDTO acuerdoDTO){
        AcuerdoEntity acuerdoEntity = obtenerAcuerdoPorPrefijoAcuerdoAndAnoAcuerdoAndNumeroAcuerdo(prefijoAcuerdo, anoAcuerdo, numeroAcuerdo);
        if (acuerdoDTO.getEstado()== null){
            throw new IllegalArgumentException("El estado del acuerdo no puede sel nulo");
        }

        acuerdoEntity.setPrefijoAcuerdo(acuerdoDTO.getPrefijoAcuerdo());
        acuerdoEntity.setAnoAcuerdo(acuerdoDTO.getAnoAcuerdo());
        acuerdoEntity.setNumeroAcuerdo(acuerdoDTO.getNumeroAcuerdo());
        acuerdoEntity.setEstado(Estado.valueOf(acuerdoDTO.getEstado()));
        return mapperAcuerdo.loadDto(acuerdoRepository.save(acuerdoEntity));
    }

    public AcuerdoDTO inactivarAcuerdo(String prefijoAcuerdo, int anoAcuerdo, long numeroAcuerdo){
        AcuerdoEntity acuerdoEntity = obtenerAcuerdoPorPrefijoAcuerdoAndAnoAcuerdoAndNumeroAcuerdo(prefijoAcuerdo, anoAcuerdo, numeroAcuerdo);
        acuerdoEntity.setEstado(Estado.INACTIVO);
        return mapperAcuerdo.loadDto(acuerdoRepository.save(acuerdoEntity));
    }

    public AcuerdoDTO activarAcuerdo(String prefijoAcuerdo, int anoAcuerdo, long numeroAcuerdo){
        AcuerdoEntity acuerdoEntity = obtenerAcuerdoPorPrefijoAcuerdoAndAnoAcuerdoAndNumeroAcuerdo(prefijoAcuerdo, anoAcuerdo, numeroAcuerdo);
        acuerdoEntity.setEstado(Estado.ACTIVO);
        return mapperAcuerdo.loadDto(acuerdoRepository.save(acuerdoEntity));
    }









}
