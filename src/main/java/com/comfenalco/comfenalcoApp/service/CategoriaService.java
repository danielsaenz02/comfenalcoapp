package com.comfenalco.comfenalcoApp.service;

import com.comfenalco.comfenalcoApp.entity.CategoriaBolsillo;
import com.comfenalco.comfenalcoApp.entity.TipoAfiliacion;
import com.comfenalco.comfenalcoApp.repository.ICategoriaRepository;
import com.comfenalco.comfenalcoApp.repository.ITipoAfiliadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private ICategoriaRepository iCategoriaRepository;

    public List<CategoriaBolsillo> getAll(){
        return iCategoriaRepository.findAll();
    }
}
