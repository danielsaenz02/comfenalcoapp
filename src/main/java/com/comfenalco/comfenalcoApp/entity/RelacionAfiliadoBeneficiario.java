package com.comfenalco.comfenalcoApp.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity()
@Table(name = "relacionafiliadobeneficiario")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RelacionAfiliadoBeneficiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRelacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @JoinColumn(name = "idafiliado", referencedColumnName = "IdAfiliadoBeneficiario")
    private Afiliado afiliado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @JoinColumn(name = "idbeneficiario", referencedColumnName = "IdAfiliadoBeneficiario")
    private Afiliado beneficiario;
}
