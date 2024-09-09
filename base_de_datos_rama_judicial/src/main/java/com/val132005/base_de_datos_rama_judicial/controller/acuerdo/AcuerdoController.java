package com.val132005.base_de_datos_rama_judicial.controller.acuerdo;

import com.val132005.base_de_datos_rama_judicial.model.acuerdo.AcuerdoDTO;
import com.val132005.base_de_datos_rama_judicial.service.acuerdo.AcuerdoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AcuerdoController {

    private AcuerdoService acuerdoService;

    public AcuerdoController(AcuerdoService acuerdoService) {
        this.acuerdoService = acuerdoService;
    }

    @GetMapping("/listarAcuerdos")
    public List<AcuerdoDTO> listarAcuerdos(){
        List<AcuerdoDTO> acuerdos = acuerdoService.listarAcuerdos();
        return acuerdos;
    }

    @PostMapping("/registrarAcuerdo")
    public AcuerdoDTO registrarAcuerdo(@Valid @RequestBody AcuerdoDTO acuerdoDTO){
        return acuerdoService.registrarAcuerdo(acuerdoDTO);
    }

    @GetMapping("/consultarAcuerdoPorTitulo")
    public ResponseEntity<AcuerdoDTO> consultarAcuerdoPorNombre (
            @RequestParam String prefijoAcuerdo,
            @RequestParam int anoAcuerdo,
            @RequestParam long numeroAcuerdo){
        AcuerdoDTO acuerdoDTO = acuerdoService.consultarAcuerdoPorNombre(prefijoAcuerdo, anoAcuerdo, numeroAcuerdo);
        return ResponseEntity.ok(acuerdoDTO);
    }

    @PutMapping("/actualizarAcuerdoPorTitulo")
    public ResponseEntity<AcuerdoDTO> actualizarAcuerdoPorTitulo(
            @RequestParam String prefijoAcuerdo,
            @RequestParam int anoAcuerdo,
            @RequestParam long numeroAcuerdo,
            @Valid @RequestBody AcuerdoDTO acuerdo){
        AcuerdoDTO acuerdoDTO = acuerdoService.actualizarAcuerdo(prefijoAcuerdo, anoAcuerdo, numeroAcuerdo, acuerdo);
        return ResponseEntity.ok(acuerdoDTO);
    }

    @PutMapping("/inactivarAcuerdoPorTitulo")
    public ResponseEntity<AcuerdoDTO> inactivarAcuerdoPorTitulo(
            @RequestParam String prefijoAcuerdo,
            @RequestParam int anoAcuerdo,
            @RequestParam long numeroAcuerdo){
        AcuerdoDTO acuerdoDTO = acuerdoService.inactivarAcuerdo(prefijoAcuerdo, anoAcuerdo, numeroAcuerdo);
        return ResponseEntity.ok(acuerdoDTO);
    }

    @PutMapping("/activarAcuerdoPorTitulo")
    public ResponseEntity<AcuerdoDTO> activarAcuerdoPorTitulo(
            @RequestParam String prefijoAcuerdo,
            @RequestParam int anoAcuerdo,
            @RequestParam long numeroAcuerdo){
        AcuerdoDTO acuerdoDTO = acuerdoService.activarAcuerdo(prefijoAcuerdo, anoAcuerdo, numeroAcuerdo);
        return ResponseEntity.ok(acuerdoDTO);
    }







}




