package com.comfenalco.comfenalcoApp.controller;

import com.comfenalco.comfenalcoApp.entity.Afiliado;
import com.comfenalco.comfenalcoApp.entity.CodigosRetiro;
import com.comfenalco.comfenalcoApp.exception.BadRequestCustom;
import com.comfenalco.comfenalcoApp.service.CodigoService;
import com.comfenalco.comfenalcoApp.service.PuntosRetirosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/codigos")
@CrossOrigin({"*"})
public class CodigoController {
    @Autowired
    private CodigoService codigoService;

    @GetMapping("/listarcodigo/{idDocumento}")
    public ResponseEntity<?> buscarAfiliado(@PathVariable String idDocumento) throws Exception {
        try {
            CodigosRetiro codigosRetiro = codigoService.findByIdMovimiento(idDocumento).orElseThrow(() ->  new BadRequestCustom("No se pudo encontrar el código"));
            return new ResponseEntity<>(codigosRetiro, HttpStatus.OK);

        } catch (BadRequestCustom badMessage) {
            return new ResponseEntity<>(badMessage.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
