package com.comfenalco.comfenalcoApp.controller;


import com.comfenalco.comfenalcoApp.entity.TipoDocumento;
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
@RequestMapping("/api/documento")
@CrossOrigin({"*"})
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    @GetMapping("/listar")
    public ResponseEntity<List<TipoDocumento>> getAll(){
        List<TipoDocumento> tipoDocumentos = documentoService.getAll();
        return new ResponseEntity<List<TipoDocumento>>(tipoDocumentos, HttpStatus.OK);
    }
}
