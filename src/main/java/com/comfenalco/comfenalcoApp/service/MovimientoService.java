package com.comfenalco.comfenalcoApp.service;


import com.comfenalco.comfenalcoApp.entity.Cuenta;
import com.comfenalco.comfenalcoApp.entity.Movimiento;
import com.comfenalco.comfenalcoApp.entity.RetiroPendienteDTO;
import com.comfenalco.comfenalcoApp.exception.BadRequestCustom;
import com.comfenalco.comfenalcoApp.repository.ICuentaRepository;
import com.comfenalco.comfenalcoApp.repository.IDocumentoRepository;
import com.comfenalco.comfenalcoApp.repository.IMovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimientoService {
    @Autowired
    private IMovimientoRepository iMovimientoRepository;
    @Autowired
    private ICuentaRepository iCuentaRepository;

    public List<Movimiento> getAll(){
        return iMovimientoRepository.findAll();
    }



    public Movimiento saveMovimiento(Movimiento movimiento, Long idafiliado) throws BadRequestCustom{
        try{
            Cuenta cuentaAfiliado = iCuentaRepository.findCuentaByIdafiliado(idafiliado).orElseThrow(() ->  new BadRequestCustom("La cuenta de usuario no existe "));
            Cuenta cuentaDestino = iCuentaRepository.findCuentaByNumeroCuenta(movimiento.getNumerocuentadestino()).orElseThrow(() ->  new BadRequestCustom("El número de la cuenta destino no existe"));
            if (movimiento.getMonto() < cuentaAfiliado.getSaldo()){
                cuentaAfiliado.setSaldo(cuentaAfiliado.getSaldo()-movimiento.getMonto());
                cuentaDestino.setSaldo(cuentaDestino.getSaldo()+ movimiento.getMonto());
                movimiento.setStatus("C");
                return iMovimientoRepository.save(movimiento);

            }else if (cuentaAfiliado.getSaldo() == 0){
                throw new BadRequestCustom("No tiene sucificiente saldo para transferir a otras cuentas.");

            }else {
                throw new BadRequestCustom("El saldo que intenta transferir es mayor al saldo de su cuenta.");
            }


    } catch (BadRequestCustom e) {
            throw new RuntimeException(e);
        }
    }
    public Movimiento saveMovimientoRetiro(Movimiento movimiento, Long idafiliado) throws BadRequestCustom{
        try{
            Cuenta cuentaAfiliado = iCuentaRepository.findCuentaByIdafiliado(idafiliado).orElseThrow(() ->  new BadRequestCustom("La cuenta de usuario no existe "));
            if (movimiento.getMonto() < cuentaAfiliado.getSaldo()){
                   movimiento.setStatus("P");
                return iMovimientoRepository.save(movimiento);

            }else if (cuentaAfiliado.getSaldo() == 0){
                throw new BadRequestCustom("No tiene sucificiente saldo para retirar.");

            }else {
                throw new BadRequestCustom("El saldo que intenta retirar es mayor al saldo de su cuenta.");
            }


        } catch (BadRequestCustom e) {
            throw new RuntimeException(e);
        }
    }

        public Movimiento findById(Long id){
        return iMovimientoRepository.findById(id).orElse(null);
    }

    public List<Movimiento> findMovimientoByIdAfiliado(Long idAfiliado){ return iMovimientoRepository.findMovimientoByIdafiliado(idAfiliado);}

    public List<RetiroPendienteDTO> findRetiroByIdCuenta(Long idcuenta) {
        List<RetiroPendienteDTO> retiroPendiente = iMovimientoRepository.findRetiroPendiente(idcuenta);
        return retiroPendiente;
    }

}
