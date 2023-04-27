package com.comfenalco.comfenalcoApp.controller;


import com.comfenalco.comfenalcoApp.entity.Cuenta;
import com.comfenalco.comfenalcoApp.entity.Movimiento;
import com.comfenalco.comfenalcoApp.exception.BadRequestCustom;
import com.comfenalco.comfenalcoApp.exception.ConflictException;
import com.comfenalco.comfenalcoApp.service.CuentaService;
import com.comfenalco.comfenalcoApp.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movimiento")
@CrossOrigin({"*"})
public class MovimientoController {

    @Autowired
    private MovimientoService movimientoService;


    @GetMapping("/listar")
    public ResponseEntity<List<Movimiento>> getAll(){
        List<Movimiento> movimientos  = movimientoService.getAll();
        return new ResponseEntity<List<Movimiento>>(movimientos, HttpStatus.OK);
    }

    @PostMapping("/create/{idafiliado}")
    public ResponseEntity<?> save(@RequestBody Movimiento movimiento, @PathVariable Long idafiliado) throws BadRequestCustom {
        try{
           Movimiento newMovimiento=  movimientoService.saveMovimiento(movimiento,idafiliado);
           return new ResponseEntity<>(newMovimiento,HttpStatus.OK);

        }catch ( BadRequestCustom badRequestCustom){
            return new ResponseEntity<>(badRequestCustom.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }
    @PostMapping("/retiro/{idafiliado}")
    public ResponseEntity<?> saveRetiro(@RequestBody Movimiento movimiento, @PathVariable Long idafiliado) throws BadRequestCustom {
        try{
            Movimiento newMovimiento=  movimientoService.saveMovimientoRetiro(movimiento,idafiliado);
            return new ResponseEntity<>(newMovimiento,HttpStatus.OK);

        }catch ( BadRequestCustom badRequestCustom){
            return new ResponseEntity<>(badRequestCustom.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }
    @GetMapping("/listar/{idafiliado}")
    public ResponseEntity<?> findByIdAfiliado(@PathVariable Long idafiliado){
        List<Movimiento> movimientosAfiliado = movimientoService.findMovimientoByIdAfiliado(idafiliado);
        return new ResponseEntity<List<Movimiento>>(movimientosAfiliado,HttpStatus.OK);
    }
}
