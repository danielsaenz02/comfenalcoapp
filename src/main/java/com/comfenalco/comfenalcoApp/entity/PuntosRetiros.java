package com.comfenalco.comfenalcoApp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity()
@Table(name = "puntosretiro")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PuntosRetiros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpuntoretiro;

    private String nombre;

    private String direccion;

    private String icono;

    private String status;

    private int numerocuenta;

}
