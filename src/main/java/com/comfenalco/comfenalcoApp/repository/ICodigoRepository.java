package com.comfenalco.comfenalcoApp.repository;

import com.comfenalco.comfenalcoApp.entity.CodigosRetiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICodigoRepository extends JpaRepository<CodigosRetiro, Long> {
    @Query(nativeQuery = true,value = "SELECT * from CodigosRetiro WHERE idmovimiento = ?")
    Optional<CodigosRetiro> findByIdMovimiento(String idmovimiento);
}
