package com.comfenalco.comfenalcoApp.service;

import com.comfenalco.comfenalcoApp.entity.Afiliado;
import com.comfenalco.comfenalcoApp.entity.PuntosRetiros;
import com.comfenalco.comfenalcoApp.repository.IPuntosRetiro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PuntosRetirosService {
    @Autowired
    private IPuntosRetiro iPuntosRetiro;
    public List<PuntosRetiros> getAll(){
        return iPuntosRetiro.findAll();
    }

    public PuntosRetiros save(PuntosRetiros puntosRetiros){
        return iPuntosRetiro.save(puntosRetiros);
    }

    public PuntosRetiros findById(Long id){
        return iPuntosRetiro.findById(id).orElse(null);
    }
}
