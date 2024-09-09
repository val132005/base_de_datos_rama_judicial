package com.val132005.base_de_datos_rama_judicial.model.seccional;

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
@Table(name = "seccionales")
public class SeccionalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSeccional;

    @Column(name = "nombreSeccional", unique = true)
    private String nombreSeccional;

    @Column
    @Enumerated(EnumType.STRING)
    private Estado estado;


}
