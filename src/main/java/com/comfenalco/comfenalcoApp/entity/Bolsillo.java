package com.comfenalco.comfenalcoApp.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity()
@Table(name = "bolsillos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bolsillo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idbolsillo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @JoinColumn(name = "idafiliado", referencedColumnName = "id")
    private User user;

    private String nombre;

    private double saldo;

    private double metabolsillo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true)
    private Date createdAt;

    @PrePersist
    private void onCrete(){
        createdAt = new Date();
    }

}
