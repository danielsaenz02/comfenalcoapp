package com.comfenalco.comfenalcoApp.controller;

import com.comfenalco.comfenalcoApp.entity.CategoriaBolsillo;
import com.comfenalco.comfenalcoApp.entity.TipoDocumento;
import com.comfenalco.comfenalcoApp.service.CategoriaService;
import com.comfenalco.comfenalcoApp.service.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/categoria")
@CrossOrigin({"*"})
public class CategoriaBolsilloController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listar")
    public ResponseEntity<List<CategoriaBolsillo>> getAllUsers(){
        List<CategoriaBolsillo> categorias = categoriaService.getAll();
        return new ResponseEntity<List<CategoriaBolsillo>>(categorias, HttpStatus.OK);
    }
}