package com.comfenalco.comfenalcoApp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity()
@Table(name = "tipoafiliacion")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TipoAfiliacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtipoafiliacion;

    private String nombre;

    private String status;
}
