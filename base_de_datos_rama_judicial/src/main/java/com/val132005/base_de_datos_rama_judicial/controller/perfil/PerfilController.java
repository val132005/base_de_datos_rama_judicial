package com.val132005.base_de_datos_rama_judicial.controller.perfil;

import com.val132005.base_de_datos_rama_judicial.model.perfil.PerfilDTO;
import com.val132005.base_de_datos_rama_judicial.service.perfil.PerfilService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PerfilController {

    private PerfilService perfilService;

    public PerfilController(PerfilService perfilService) {
        this.perfilService = perfilService;
    }

    @GetMapping("/listarPerfiles")
    public List<PerfilDTO> listarPerfiles(){
        List<PerfilDTO> perfilDTOS = perfilService.listarPerfiles();
        return perfilDTOS;
    }

    @PostMapping("/registrarPerfil")
    public PerfilDTO registrarPerfil(@Valid @RequestBody PerfilDTO perfilDTO){
        return perfilService.registrarPerfil(perfilDTO);
    }

    @GetMapping("/consultarPerfilPorNombre")
    public ResponseEntity<PerfilDTO> consultarPerfilPorNombre (@RequestParam String nombrePerfil){
        PerfilDTO perfilDTO = perfilService.consultarPerfilPorNombre(nombrePerfil);
        return ResponseEntity.ok(perfilDTO);
    }

    @PutMapping("/actualizarPerfil")
    public ResponseEntity<PerfilDTO> actualizarPerfil(
            @RequestParam String nombrePerfil,
            @Valid @RequestBody PerfilDTO perfilDTO){
        PerfilDTO dto = perfilService.actualizarPerfil(nombrePerfil, perfilDTO);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/inactivarPerfil")
    public ResponseEntity<PerfilDTO> inactivarPerfil(
            @RequestParam String nombrePerfil){
        PerfilDTO perfilDTO = perfilService.inactivarPerfil(nombrePerfil);
        return ResponseEntity.ok(perfilDTO);
    }

    @PutMapping("/activarPerfil")
    public ResponseEntity<PerfilDTO> activarPerfil(
            @RequestParam String nombrePerfil){
        PerfilDTO perfilDTO = perfilService.activarPerfil(nombrePerfil);
        return ResponseEntity.ok(perfilDTO);
    }

}
