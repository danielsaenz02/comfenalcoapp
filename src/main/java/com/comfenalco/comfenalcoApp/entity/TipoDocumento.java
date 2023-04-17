package com.comfenalco.comfenalcoApp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity()
@Table(name = "tipodocumento")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TipoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoDocumento;

    private String nombre;

    private String status;
}
