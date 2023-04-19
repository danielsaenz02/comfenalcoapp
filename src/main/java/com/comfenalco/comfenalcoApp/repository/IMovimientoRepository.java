package com.comfenalco.comfenalcoApp.repository;

import com.comfenalco.comfenalcoApp.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovimientoRepository extends JpaRepository<Movimiento,Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM Movimientos where idcuenta = ?")
    List<Movimiento> findMovimientoByIdafiliado(Long idcuenta);
}
