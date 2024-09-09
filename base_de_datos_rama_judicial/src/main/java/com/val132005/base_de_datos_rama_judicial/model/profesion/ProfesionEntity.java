package com.val132005.base_de_datos_rama_judicial.model.profesion;

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
@Table(name = "profesiones")
public class ProfesionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProfesion;

    @Column(name = "nombreProfesion", unique = true)
    private String nombreProfesion;

    @Column
    @Enumerated(EnumType.STRING)
    private Estado estado;
}
