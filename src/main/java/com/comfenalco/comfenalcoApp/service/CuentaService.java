package com.comfenalco.comfenalcoApp.service;


import com.comfenalco.comfenalcoApp.entity.Cuenta;
import com.comfenalco.comfenalcoApp.repository.ICuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaService {

    @Autowired
    private ICuentaRepository iCuentaRepository;

    public List<Cuenta> getAll(){
        return iCuentaRepository.findAll();
    }

    public Cuenta save(Cuenta cuenta){
        return iCuentaRepository.save(cuenta);
    }

    public Cuenta findById(Long id){
        return iCuentaRepository.findById(id).orElse(null);
    }


    public Optional<Cuenta> findCuentaByIdAfiliado(Long idAfiliado){ return iCuentaRepository.findCuentaByIdafiliado(idAfiliado);}
    public Optional<Cuenta> findCuentaByNumeroCuenta(Integer numeroCuenta){ return iCuentaRepository.findCuentaByNumeroCuenta(numeroCuenta);}


}
