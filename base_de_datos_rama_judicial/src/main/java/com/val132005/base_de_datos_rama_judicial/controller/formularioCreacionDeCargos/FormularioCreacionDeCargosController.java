package com.val132005.base_de_datos_rama_judicial.controller.formularioCreacionDeCargos;

import com.val132005.base_de_datos_rama_judicial.model.formularioCreacionDeCargos.FormularioCreacionDeCargosDTO;
import com.val132005.base_de_datos_rama_judicial.service.formularioCreacionDeCargos.FormularioCreacionDeCargosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class FormularioCreacionDeCargosController {

    private FormularioCreacionDeCargosService service;

    public FormularioCreacionDeCargosController(FormularioCreacionDeCargosService service) {
        this.service = service;
    }

    @GetMapping("/listarFormularioCreacionDeCargos")
    public List<FormularioCreacionDeCargosDTO> listarFormularioCreacionDeCargos(){
        List<FormularioCreacionDeCargosDTO> formulariosCreacionDeCargos = service.listarFormulariosCreacionDeCargos();
        return formulariosCreacionDeCargos;
    }

    @PostMapping("/registrarFormularioCreacionDeCargos")
    public FormularioCreacionDeCargosDTO registrarFormularioCreacionDeCargos(@Valid @RequestBody FormularioCreacionDeCargosDTO dto){
        return service.registrarFormularioCreacionDeCargos(dto);
    }

    @GetMapping("/consultarFormularioCreacionDeCargosPorId")
    public ResponseEntity<FormularioCreacionDeCargosDTO> consultarFormularioCreacionDeCargosPorId (@RequestParam long idFormularioCreacionDeCargos){
        FormularioCreacionDeCargosDTO formularioCreacionDeCargosDTO = service.consultarFormularioCreacionDeCargosPorId(idFormularioCreacionDeCargos);
        return ResponseEntity.ok(formularioCreacionDeCargosDTO);
    }

    @PutMapping("/actualizarFormularioCreacionDeCargos")
    public ResponseEntity<FormularioCreacionDeCargosDTO> actualizarFormularioCreacionDeCargos(
            @RequestParam long idFormularioCreacionDeCargos,
            @Valid @RequestBody FormularioCreacionDeCargosDTO formularioCreacionDeCargosDTO){
        FormularioCreacionDeCargosDTO dto = service.actualizarFormularioCreacionDeCargosPorId(idFormularioCreacionDeCargos, formularioCreacionDeCargosDTO);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/inactivarFormularioCreacionDeCargos")
    public ResponseEntity<FormularioCreacionDeCargosDTO> inactivarFormularioCreacionDeCargos(
            @RequestParam long idFormularioCreacionDeCargos){
        FormularioCreacionDeCargosDTO formularioCreacionDeCargosDTO = service.inactivarFormularioCreacionDeCargos(idFormularioCreacionDeCargos);
        return ResponseEntity.ok(formularioCreacionDeCargosDTO);
    }

    @PutMapping("/activarFormularioCreacionDeCargos")
    public ResponseEntity<FormularioCreacionDeCargosDTO> activarFormularioCreacionDeCargos(
            @RequestParam long idFormularioCreacionDeCargos){
        FormularioCreacionDeCargosDTO formularioCreacionDeCargosDTO = service.activarFormularioCreacionDeCargos(idFormularioCreacionDeCargos);
        return ResponseEntity.ok(formularioCreacionDeCargosDTO);
    }



}
