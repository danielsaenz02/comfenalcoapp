package com.comfenalco.comfenalcoApp.repository;

import com.comfenalco.comfenalcoApp.entity.RelacionAfiliadoBeneficiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRelacionRepository extends JpaRepository<RelacionAfiliadoBeneficiario,Long> {
}
