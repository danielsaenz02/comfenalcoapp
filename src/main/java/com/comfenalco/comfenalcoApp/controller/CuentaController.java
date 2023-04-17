package com.comfenalco.comfenalcoApp.controller;

import com.comfenalco.comfenalcoApp.entity.Cuenta;
import com.comfenalco.comfenalcoApp.entity.Movimiento;
import com.comfenalco.comfenalcoApp.exception.BadRequestCustom;
import com.comfenalco.comfenalcoApp.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuenta")
@CrossOrigin({"*"})
public class CuentaController {
    @Autowired
    private CuentaService cuentaService;

    @GetMapping("/listar/{idafiliado}")
    public ResponseEntity<?> findByIdAfiliado(@PathVariable Long idafiliado) throws BadRequestCustom {
        Cuenta cuenta = cuentaService.findCuentaByIdAfiliado(idafiliado).orElseThrow(() -> new BadRequestCustom("Cuenta del afiliado no encontrado"));
        return new ResponseEntity<Cuenta>(cuenta, HttpStatus.OK);
    }
}
