package com.val132005.base_de_datos_rama_judicial.controller.profesion;

import com.val132005.base_de_datos_rama_judicial.model.profesion.ProfesionDTO;
import com.val132005.base_de_datos_rama_judicial.service.profesion.ProfesionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProfesionController {

    private ProfesionService profesionService;

    public ProfesionController(ProfesionService profesionService) {
        this.profesionService = profesionService;
    }


    @GetMapping("/listarProfesion")
    public List<ProfesionDTO> listarProfesion(){
        List<ProfesionDTO> profesionDTOS = profesionService.listarProfesiones();
        return profesionDTOS;
    }

    @PostMapping("/registrarProfesion")
    public ProfesionDTO registrarProfesion(@Valid @RequestBody ProfesionDTO profesionDTO){
        return profesionService.registrarProfesiones(profesionDTO);
    }

    @GetMapping("/consultarProfesionPorNombre")
    public ResponseEntity<ProfesionDTO> consultarProfesionPorNombre (@RequestParam String nombreProfesion){
        ProfesionDTO profesionDTO = profesionService.conultarProfesionPorNombre(nombreProfesion);
        return ResponseEntity.ok(profesionDTO);
    }

    @PutMapping("/actualizarProfesion")
    public ResponseEntity<ProfesionDTO> actualizarProfesion(
            @RequestParam String nombreProfesion,
            @Valid @RequestBody ProfesionDTO profesionDTO){
        ProfesionDTO dto = profesionService.actualizarProfesion(nombreProfesion, profesionDTO);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/inactivarProfesion")
    public ResponseEntity<ProfesionDTO> inactivarProfesion(
            @RequestParam String nombreProfesion){
        ProfesionDTO profesionDTO = profesionService.inactivarProfesion(nombreProfesion);
        return ResponseEntity.ok(profesionDTO);
    }

    @PutMapping("/activarProfesion")
    public ResponseEntity<ProfesionDTO> activarProfesion(
            @RequestParam String nombreProfesion){
        ProfesionDTO profesionDTO = profesionService.activarProfesion(nombreProfesion);
        return ResponseEntity.ok(profesionDTO);
    }




}
