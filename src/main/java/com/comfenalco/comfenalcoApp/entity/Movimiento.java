package com.comfenalco.comfenalcoApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity()
@Table(name = "Movimientos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idmovimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @JoinColumn(name = "idcuenta", referencedColumnName = "idcuenta")
    private Cuenta cuenta;

    private Integer numerocuentadestino;

    private double monto;

    private String tipomovimiento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true)
    private Date createdAt;
    @PrePersist
    private void onCrete(){
        createdAt = new Date();
    }
}
