package com.comfenalco.comfenalcoApp.service;

import com.comfenalco.comfenalcoApp.entity.CodigosRetiro;
import com.comfenalco.comfenalcoApp.entity.PuntosRetiros;
import com.comfenalco.comfenalcoApp.entity.User;
import com.comfenalco.comfenalcoApp.repository.ICodigoRepository;
import com.comfenalco.comfenalcoApp.repository.IPuntosRetiro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CodigoService {
    @Autowired
    private ICodigoRepository iCodigoRepository;
    public List<CodigosRetiro> getAll(){
        return iCodigoRepository.findAll();
    }

    public CodigosRetiro save(CodigosRetiro codigosRetiro){
        return iCodigoRepository.save(codigosRetiro);
    }

    public CodigosRetiro findById(Long id){
        return iCodigoRepository.findById(id).orElse(null);
    }

    public Optional<CodigosRetiro> findByIdMovimiento (String idMovimiento){ return iCodigoRepository.findByIdMovimiento(idMovimiento);}

}
