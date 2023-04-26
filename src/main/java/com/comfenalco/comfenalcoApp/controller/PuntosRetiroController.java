package com.comfenalco.comfenalcoApp.controller;

import com.comfenalco.comfenalcoApp.entity.PuntosRetiros;
import com.comfenalco.comfenalcoApp.entity.TipoDocumento;
import com.comfenalco.comfenalcoApp.service.DocumentoService;
import com.comfenalco.comfenalcoApp.service.PuntosRetirosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/establecimeintos")
@CrossOrigin({"*"})
public class PuntosRetiroController {
    @Autowired
    private PuntosRetirosService puntosRetirosService;

    @GetMapping("/listar")
    public ResponseEntity<List<PuntosRetiros>> getAllUsers(){
        List<PuntosRetiros> puntosRetiros = puntosRetirosService.getAll();
        return new ResponseEntity<List<PuntosRetiros>>(puntosRetiros, HttpStatus.OK);
    }
}
