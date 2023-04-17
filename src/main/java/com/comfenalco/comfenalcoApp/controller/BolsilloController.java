package com.comfenalco.comfenalcoApp.controller;



import com.comfenalco.comfenalcoApp.entity.Bolsillo;
import com.comfenalco.comfenalcoApp.exception.BadRequestCustom;
import com.comfenalco.comfenalcoApp.service.BolsilloService;
import com.comfenalco.comfenalcoApp.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bolsillo")
@CrossOrigin({"*"})
public class BolsilloController {

    @Autowired
    private BolsilloService bolsilloService;

    @GetMapping("/listar")
    public ResponseEntity<List<Bolsillo>> getAll(){
        List<Bolsillo> bolsillos = bolsilloService.getAll();
        return new ResponseEntity<List<Bolsillo>>(bolsillos, HttpStatus.OK);
    }

    @PostMapping("/create/{idafiliado}")
    public ResponseEntity<?> save(@RequestBody Bolsillo bolsillo, @PathVariable Long idafiliado) throws BadRequestCustom {
        try {
            Bolsillo newBolsillo = bolsilloService.saveBolsillo(bolsillo,idafiliado);
            return new ResponseEntity<>(newBolsillo, HttpStatus.OK);

        }catch ( BadRequestCustom badRequestCustom){
            return new ResponseEntity<>(badRequestCustom.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }
    @GetMapping("/listar/{idafiliado}")
    public ResponseEntity<?> findByIdAfiliado(@PathVariable Long idafiliado){
        List<Bolsillo> bolsillosAfiliado = bolsilloService.findBolsilloByIdAfiliado(idafiliado);
        return new ResponseEntity<List<Bolsillo>>(bolsillosAfiliado,HttpStatus.OK);
    }
}
