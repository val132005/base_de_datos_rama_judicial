package com.val132005.base_de_datos_rama_judicial.controller.codigo;

import com.val132005.base_de_datos_rama_judicial.model.codigo.CodigoDTO;
import com.val132005.base_de_datos_rama_judicial.service.codigo.CodigoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class CodigoController {

    private CodigoService codigoService;

    public CodigoController(CodigoService codigoService) {
        this.codigoService = codigoService;
    }

    @GetMapping("/listarCodigos")
    public List<CodigoDTO> listarCodigos(){
        List<CodigoDTO> codigos = codigoService.listarCodigos();
        return codigos;
    }

    @PostMapping("/registrarCodigo")
    public CodigoDTO registrarCodigo(@Valid @RequestBody CodigoDTO codigoDTO){
        return codigoService.registrarCodigo(codigoDTO);
    }

    @GetMapping("/consultarCodigoPorNumeroDeCodigo")
    public ResponseEntity<CodigoDTO> consultarCodigoPorNumeroDeCodigo (@RequestParam int numeroCodigo){
        CodigoDTO codigoDTO = codigoService.consultarCodigoPorNumeroDeCodigo(numeroCodigo);
        return ResponseEntity.ok(codigoDTO);
    }

    @PutMapping("/actualizarCodigo")
    public ResponseEntity<CodigoDTO> actualizarCodigo(
            @RequestParam int numeroCodigo,
            @Valid @RequestBody CodigoDTO codigo){
        CodigoDTO codigoDTO = codigoService.actualizarCodigo(numeroCodigo, codigo);
        return ResponseEntity.ok(codigoDTO);
    }

    @PutMapping("/inactivarCodigo")
    public ResponseEntity<CodigoDTO> inactivarCodigo(
            @RequestParam int numeroDeCodigo){
        CodigoDTO codigoDTO = codigoService.inactivarCodigo(numeroDeCodigo);
        return ResponseEntity.ok(codigoDTO);
    }

    @PutMapping("/activarCodigo")
    public ResponseEntity<CodigoDTO> activarCodigo(
            @RequestParam int numeroDeCodigo){
        CodigoDTO codigoDTO = codigoService.activarCodigo(numeroDeCodigo);
        return ResponseEntity.ok(codigoDTO);
    }


}
