package com.comfenalco.comfenalcoApp.repository;

import com.comfenalco.comfenalcoApp.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICuentaRepository extends JpaRepository<Cuenta, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM Cuentas where idafiliado = ?")
    Optional<Cuenta> findCuentaByIdafiliado(Long idafiliado);

    @Query(nativeQuery = true, value = "SELECT * FROM Cuentas where numerocuenta = ?")
    Optional<Cuenta> findCuentaByNumeroCuenta(Integer numerocuenta);
}
