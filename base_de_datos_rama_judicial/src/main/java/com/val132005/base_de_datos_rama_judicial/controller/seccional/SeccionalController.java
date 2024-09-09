package com.val132005.base_de_datos_rama_judicial.controller.seccional;

import com.val132005.base_de_datos_rama_judicial.model.seccional.SeccionalDTO;
import com.val132005.base_de_datos_rama_judicial.service.seccional.SeccionalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SeccionalController {

    private SeccionalService seccionalService;

    public SeccionalController(SeccionalService seccionalService) {
        this.seccionalService = seccionalService;
    }


    @GetMapping("/listarSeccionales")
    public List<SeccionalDTO> listarSeccionales(){
        List<SeccionalDTO> seccionalDTOS = seccionalService.listarSeccionales();
        return seccionalDTOS;
    }

    @PostMapping("/registrarSeccional")
    public SeccionalDTO registrarSeccional(@Valid @RequestBody SeccionalDTO seccionalDTO){
        return seccionalService.registrarSeccional(seccionalDTO);
    }

    @GetMapping("/consultarSeccionalPorNombre")
    public ResponseEntity<SeccionalDTO> consultarSeccionalPorNombre (@RequestParam String nombreSeccional){
        SeccionalDTO seccionalDTO = seccionalService.consultarSeccionalPorNombre(nombreSeccional);
        return ResponseEntity.ok(seccionalDTO);
    }

    @PutMapping("/actualizarSeccional")
    public ResponseEntity<SeccionalDTO> actualizarSeccional(
            @RequestParam String nombreSeccional,
            @Valid @RequestBody SeccionalDTO seccionalDTO){
        SeccionalDTO dto = seccionalService.actualizarSeccional(nombreSeccional, seccionalDTO);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/inactivarSeccional")
    public ResponseEntity<SeccionalDTO> inactivarSeccional(
            @RequestParam String nombreSeccional){
        SeccionalDTO seccionalDTO = seccionalService.inactivarSeccional(nombreSeccional);
        return ResponseEntity.ok(seccionalDTO);
    }

    @PutMapping("/activarSeccional")
    public ResponseEntity<SeccionalDTO> activarSeccional(
            @RequestParam String nombreSeccional){
        SeccionalDTO seccionalDTO = seccionalService.activarSeccional(nombreSeccional);
        return ResponseEntity.ok(seccionalDTO);
    }



}
