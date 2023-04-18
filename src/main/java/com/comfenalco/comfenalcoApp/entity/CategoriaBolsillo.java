package com.comfenalco.comfenalcoApp.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity()
@Table(name = "categoriabolsillo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoriaBolsillo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcategoria;

    private String nombre;

    private String icono;


}
