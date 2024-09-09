package com.val132005.base_de_datos_rama_judicial.model.perfil;

import com.val132005.base_de_datos_rama_judicial.model.common.Estado;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "perfiles")
public class PerfilEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPerfil;

    @Column(name = "nombrePerfil", unique = true)
    private String nombrePerfil;

    @Column
    @Enumerated(EnumType.STRING)
    private Estado estado;

}
