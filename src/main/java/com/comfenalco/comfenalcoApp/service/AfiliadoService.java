package com.comfenalco.comfenalcoApp.service;

import com.comfenalco.comfenalcoApp.entity.Afiliado;
import com.comfenalco.comfenalcoApp.entity.User;
import com.comfenalco.comfenalcoApp.repository.IAfiliadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AfiliadoService {
    @Autowired
    private IAfiliadoRepository iAfiliadoRepository;

    public List<Afiliado> getAll(){
        return iAfiliadoRepository.findAll();
    }

    public Afiliado save(Afiliado afiliado){
        return iAfiliadoRepository.save(afiliado);
    }

    public Afiliado findById(Long id){
        return iAfiliadoRepository.findById(id).orElse(null);
    }


}
