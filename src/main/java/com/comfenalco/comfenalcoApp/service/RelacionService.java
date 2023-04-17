package com.comfenalco.comfenalcoApp.service;

import com.comfenalco.comfenalcoApp.entity.RelacionAfiliadoBeneficiario;
import com.comfenalco.comfenalcoApp.repository.IRelacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelacionService {
    @Autowired
    private IRelacionRepository iRelacionRepository;

    public List<RelacionAfiliadoBeneficiario> getAll(){
        return iRelacionRepository.findAll();
    }

    public RelacionAfiliadoBeneficiario save(RelacionAfiliadoBeneficiario relacionAfiliadoBeneficiario){
        return iRelacionRepository.save(relacionAfiliadoBeneficiario);
    }

    public RelacionAfiliadoBeneficiario findById(Long id){
        return iRelacionRepository.findById(id).orElse(null);
    }
}
