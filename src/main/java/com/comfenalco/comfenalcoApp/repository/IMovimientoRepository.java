package com.comfenalco.comfenalcoApp.repository;

import com.comfenalco.comfenalcoApp.entity.Movimiento;
import com.comfenalco.comfenalcoApp.entity.RetiroPendienteDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IMovimientoRepository extends JpaRepository<Movimiento,Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM Movimientos where idcuenta = ? and status='C'")
    List<Movimiento> findMovimientoByIdafiliado(Long idcuenta);

    @Query("SELECT new com.comfenalco.comfenalcoApp.entity.RetiroPendienteDTO(cr.fechaexpiracion, cr.codigoverificacion, m.monto, pr.nombre ,pr.icono) " +
            "FROM CodigosRetiro cr " +
            "JOIN cr.movimiento m " +
            "JOIN m.puntosRetiros pr " +
            "WHERE m.status = 'P' AND m.cuenta.idcuenta = :idCuenta")
    List<RetiroPendienteDTO> findRetiroPendiente(@Param("idCuenta") Long idCuenta);

}
