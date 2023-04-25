package com.comfenalco.comfenalcoApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity()
@Table(name = "afiliadosBeneficiarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Afiliado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idafiliadobeneficiario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @JoinColumn(name = "idtipoafiliacion", referencedColumnName = "idtipoafiliacion")
    private TipoAfiliacion tipoAfiliacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @JoinColumn(name = "idtipodocumento", referencedColumnName = "idtipodocumento")
    private TipoDocumento tipoDocumento;

    private String nombres;

    private String apellidos;

    private String numerodocumentoidentidad;


    @Column(nullable = true)
    private Date fechanacimiento;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true)
    private Date createdAt;
    private String status;

    private String Tipo;

    @PrePersist
    private void onCrete(){
        createdAt = new Date();
    }
}
