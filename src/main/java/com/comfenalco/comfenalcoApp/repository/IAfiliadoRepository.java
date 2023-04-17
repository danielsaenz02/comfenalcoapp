package com.comfenalco.comfenalcoApp.repository;

import com.comfenalco.comfenalcoApp.entity.Afiliado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAfiliadoRepository extends JpaRepository<Afiliado,Long> {
}
