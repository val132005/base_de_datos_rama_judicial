package com.val132005.base_de_datos_rama_judicial.service.formularioCreacionDeCargos;

import com.val132005.base_de_datos_rama_judicial.mapper.formularioCreacionDeCargo.IFromularioCreacionDeCargosMapper;
import com.val132005.base_de_datos_rama_judicial.model.acuerdo.AcuerdoEntity;
import com.val132005.base_de_datos_rama_judicial.model.codigo.CodigoEntity;
import com.val132005.base_de_datos_rama_judicial.model.common.Estado;
import com.val132005.base_de_datos_rama_judicial.model.formularioCreacionDeCargos.FormularioCreacionDeCargosDTO;
import com.val132005.base_de_datos_rama_judicial.model.formularioCreacionDeCargos.FormularioCreacionDeCargosEntity;
import com.val132005.base_de_datos_rama_judicial.model.perfil.PerfilEntity;
import com.val132005.base_de_datos_rama_judicial.model.profesion.ProfesionEntity;
import com.val132005.base_de_datos_rama_judicial.model.seccional.SeccionalEntity;
import com.val132005.base_de_datos_rama_judicial.repository.formularioCreacionDeCargos.FormularioCreacionDeCargosRepository;
import com.val132005.base_de_datos_rama_judicial.service.acuerdo.AcuerdoService;
import com.val132005.base_de_datos_rama_judicial.service.codigo.CodigoService;
import com.val132005.base_de_datos_rama_judicial.service.perfil.PerfilService;
import com.val132005.base_de_datos_rama_judicial.service.profesion.ProfesionService;
import com.val132005.base_de_datos_rama_judicial.service.seccional.SeccionalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormularioCreacionDeCargosService {

    private FormularioCreacionDeCargosRepository repository;
    private IFromularioCreacionDeCargosMapper mapperFormulario;

    //Entidades relacionadas
    private AcuerdoService acuerdoService;
    private SeccionalService seccionalService;
    private PerfilService perfilService;

    private ProfesionService profesionService;

    private CodigoService codigoService;

    public FormularioCreacionDeCargosService(FormularioCreacionDeCargosRepository repository, IFromularioCreacionDeCargosMapper mapperFormulario, AcuerdoService acuerdoService, SeccionalService seccionalService, PerfilService perfilService, ProfesionService profesionService, CodigoService codigoService) {
        this.repository = repository;
        this.mapperFormulario = mapperFormulario;
        this.acuerdoService = acuerdoService;
        this.seccionalService = seccionalService;
        this.perfilService = perfilService;
        this.profesionService = profesionService;
        this.codigoService = codigoService;
    }

    public List<FormularioCreacionDeCargosDTO> listarFormulariosCreacionDeCargos(){
        return mapperFormulario.formularioCreacionDeCargosEntitiesToDTOs(repository.findAll());
    }

    public FormularioCreacionDeCargosDTO registrarFormularioCreacionDeCargos(FormularioCreacionDeCargosDTO dto){
        FormularioCreacionDeCargosEntity entity = mapperFormulario.formularioCreacionDeCargosDTOToEntity(dto);
        return mapperFormulario.formularioCreacionDeCargosEntityToDTO(repository.save(entity));
    }

    private FormularioCreacionDeCargosEntity obtenerFormularioCreacionDeCargosPorId(long idFormularioCreacionDeCargos){
        return repository.findByIdFormularioCreacionDeCargos(idFormularioCreacionDeCargos)
                .orElseThrow(()->{
                    return new RuntimeException("El Formulario de cracion de cargos con id "+ idFormularioCreacionDeCargos + "No existe");
                });

    }

    public FormularioCreacionDeCargosDTO consultarFormularioCreacionDeCargosPorId(long idFormularioCreacionDeCargos){
        return mapperFormulario.formularioCreacionDeCargosEntityToDTO(obtenerFormularioCreacionDeCargosPorId(idFormularioCreacionDeCargos));

    }

    public FormularioCreacionDeCargosDTO actualizarFormularioCreacionDeCargosPorId(long idFormularioCreacionDeCargos, FormularioCreacionDeCargosDTO dto){
        FormularioCreacionDeCargosEntity entity = obtenerFormularioCreacionDeCargosPorId(idFormularioCreacionDeCargos);
        if (dto.getEstado()==null){
            throw new IllegalArgumentException("El estado no puede ser Null");
        }
        entity.setIdFormularioCreacionDeCargos(dto.getIdFormularioCreacionDeCargos());
        entity.setCantidadDeCargos(dto.getCantidadDeCargos());
        entity.setEstado(Estado.valueOf(dto.getEstado()));
        AcuerdoEntity acuerdoEntity = acuerdoService.obtenerAcuerdoPorId(dto.getIdAcuerdo());
        entity.setAcuerdo(acuerdoEntity);
        SeccionalEntity seccionalEntity = seccionalService.obtenerSeccionalPorId(dto.getIdSeccional());
        entity.setSeccional(seccionalEntity);
        PerfilEntity perfilEntity = perfilService.obtenerPerfilPorId(dto.getIdPerfil());
        entity.setPerfil(perfilEntity);
        ProfesionEntity profesionEntity = profesionService.obtenerProfesionPorId(dto.getIdProfesion());
        entity.setProfesion(profesionEntity);
        CodigoEntity  codigoEntity = codigoService.obtenerCodigoPorId(dto.getIdCodigo());
        entity.setCodigo(codigoEntity);

        return mapperFormulario.formularioCreacionDeCargosEntityToDTO(repository.save(entity));

    }

    public FormularioCreacionDeCargosDTO inactivarFormularioCreacionDeCargos(long idFormularioCreacionDeCargos){
        FormularioCreacionDeCargosEntity entity = obtenerFormularioCreacionDeCargosPorId(idFormularioCreacionDeCargos);
        entity.setEstado(Estado.INACTIVO);
        return mapperFormulario.formularioCreacionDeCargosEntityToDTO(repository.save(entity));

    }

    public FormularioCreacionDeCargosDTO activarFormularioCreacionDeCargos(long idFormularioCreacionDeCargos){
        FormularioCreacionDeCargosEntity entity = obtenerFormularioCreacionDeCargosPorId(idFormularioCreacionDeCargos);
        entity.setEstado(Estado.ACTIVO);
        return mapperFormulario.formularioCreacionDeCargosEntityToDTO(repository.save(entity));

    }


}
