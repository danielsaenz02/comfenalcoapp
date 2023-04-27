package com.comfenalco.comfenalcoApp.controller;

import com.comfenalco.comfenalcoApp.entity.CategoriaBolsillo;
import com.comfenalco.comfenalcoApp.entity.PuntosRetiros;
import com.comfenalco.comfenalcoApp.entity.TipoDocumento;
import com.comfenalco.comfenalcoApp.service.DocumentoService;
import com.comfenalco.comfenalcoApp.service.PuntosRetirosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/establecimeintos")
@CrossOrigin({"*"})
public class PuntosRetiroController {
    @Autowired
    private PuntosRetirosService puntosRetirosService;

    @GetMapping("/listar")
    public ResponseEntity<List<PuntosRetiros>> getAll(){
        List<PuntosRetiros> puntosRetiros = puntosRetirosService.getAll();
        return new ResponseEntity<List<PuntosRetiros>>(puntosRetiros, HttpStatus.OK);
    }
    @GetMapping("/listar/{idpunto}")
    public ResponseEntity<PuntosRetiros> getByIdPunto(@PathVariable Long idpunto){
        PuntosRetiros puntosRetiros = puntosRetirosService.findById(idpunto);
        return new ResponseEntity<PuntosRetiros>(puntosRetiros, HttpStatus.OK);
    }
}
