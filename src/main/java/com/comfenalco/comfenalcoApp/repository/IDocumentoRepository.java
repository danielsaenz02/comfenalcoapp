package com.comfenalco.comfenalcoApp.repository;

import com.comfenalco.comfenalcoApp.entity.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDocumentoRepository extends JpaRepository<TipoDocumento,Long> {
}
