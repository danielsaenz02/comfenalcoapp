package com.comfenalco.comfenalcoApp.service;


import com.comfenalco.comfenalcoApp.entity.TipoAfiliacion;
import com.comfenalco.comfenalcoApp.repository.ITipoAfiliadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoAfiliacionService {
    @Autowired
    private ITipoAfiliadoRepository iTipoAfiliadoRepository;

    public List<TipoAfiliacion> getAll(){
        return iTipoAfiliadoRepository.findAll();
    }

    public TipoAfiliacion save(TipoAfiliacion tipoAfiliacion){
        return iTipoAfiliadoRepository.save(tipoAfiliacion);
    }

    public TipoAfiliacion findById(Long id){
        return iTipoAfiliadoRepository.findById(id).orElse(null);
    }
}
