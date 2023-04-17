package com.comfenalco.comfenalcoApp.service;


import com.comfenalco.comfenalcoApp.entity.Bolsillo;
import com.comfenalco.comfenalcoApp.entity.Cuenta;
import com.comfenalco.comfenalcoApp.exception.BadRequestCustom;
import com.comfenalco.comfenalcoApp.repository.IBolsilloRepository;
import com.comfenalco.comfenalcoApp.repository.ICuentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BolsilloService {

    @Autowired
    private IBolsilloRepository iBolsilloRepository;
    @Autowired
    private ICuentaRepository iCuentaRepository;

    public List<Bolsillo> getAll(){
        return iBolsilloRepository.findAll();
    }

    public Bolsillo save(Bolsillo bolsillo){
        return iBolsilloRepository.save(bolsillo);
    }

    public Bolsillo saveBolsillo(Bolsillo bolsillo, Long idafiliado) throws BadRequestCustom {
        try{
            Cuenta cuentaAfiliado = iCuentaRepository.findCuentaByIdafiliado(idafiliado).orElseThrow(() ->  new BadRequestCustom("La cuenta de usuario no existe "));
            if(bolsillo.getSaldo()<cuentaAfiliado.getSaldo()){
                cuentaAfiliado.setSaldo(cuentaAfiliado.getSaldo()- bolsillo.getSaldo());
                return iBolsilloRepository.save(bolsillo);
            } else if (cuentaAfiliado.getSaldo() == 0){
                throw new BadRequestCustom("No tiene sucificiente saldo para transferir a su bolsillo.");

            } else {
                throw new BadRequestCustom("El saldo que intenta guardar en su bolsillo es mayor al saldo de su cuenta principal.");

            }
        }catch (BadRequestCustom e){
            throw new RuntimeException(e);
        }
    }

    public Bolsillo findById(Long id){
        return iBolsilloRepository.findById(id).orElse(null);
    }

    public List<Bolsillo> findBolsilloByIdAfiliado(Long idAfiliado){ return iBolsilloRepository.findBolsilloByIdafiliado(idAfiliado);}
}
