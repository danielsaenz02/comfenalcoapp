package com.comfenalco.comfenalcoApp.repository;

import com.comfenalco.comfenalcoApp.entity.TipoAfiliacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITipoAfiliadoRepository extends JpaRepository<TipoAfiliacion, Long> {
}
