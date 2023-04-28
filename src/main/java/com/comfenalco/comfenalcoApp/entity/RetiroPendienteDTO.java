package com.comfenalco.comfenalcoApp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class RetiroPendienteDTO {
    private Date fechaExpiracion;
    private String codigoVerificacion;
    private Double monto;
    private String nombrePuntoRetiro;

    private String icono;

    public RetiroPendienteDTO(Date fechaExpiracion, String codigoVerificacion, Double monto, String nombrePuntoRetiro, String icono) {
        this.fechaExpiracion = fechaExpiracion;
        this.codigoVerificacion = codigoVerificacion;
        this.monto = monto;
        this.nombrePuntoRetiro = nombrePuntoRetiro;
        this.icono = icono;
    }

}