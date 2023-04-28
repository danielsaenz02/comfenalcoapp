package com.comfenalco.comfenalcoApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity()
@Table(name = "codigosretiro")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CodigosRetiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcodigoretiro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @JoinColumn(name = "idmovimiento", referencedColumnName = "idmovimiento")
    private Movimiento movimiento;

    private  String codigoverificacion;

    private Date fechaexpiracion;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true)
    private Date fechacreacion;

    @PrePersist
    private void onCrete(){
        fechacreacion = new Date();
    }
}
