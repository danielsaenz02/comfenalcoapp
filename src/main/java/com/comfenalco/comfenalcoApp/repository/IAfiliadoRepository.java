package com.comfenalco.comfenalcoApp.repository;

import com.comfenalco.comfenalcoApp.entity.Afiliado;
import com.comfenalco.comfenalcoApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAfiliadoRepository extends JpaRepository<Afiliado,Long> {
    @Query(nativeQuery = true,value = "SELECT * from AfiliadosBeneficiarios WHERE numeroDocumentoIdentidad = ?")
    Optional<Afiliado> findByNumeroDocumento(String numeroDocumentoIdentidad);


}
