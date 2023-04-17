package com.comfenalco.comfenalcoApp.service;


import com.comfenalco.comfenalcoApp.entity.TipoDocumento;
import com.comfenalco.comfenalcoApp.repository.IDocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentoService {

    @Autowired
    private IDocumentoRepository iDocumentoRepository;

    public List<TipoDocumento> getAll(){
        return iDocumentoRepository.findAll();
    }

    public TipoDocumento save(TipoDocumento tipoDocumento){
        return iDocumentoRepository.save(tipoDocumento);
    }

    public TipoDocumento findById(Long id){
        return iDocumentoRepository.findById(id).orElse(null);
    }
}
