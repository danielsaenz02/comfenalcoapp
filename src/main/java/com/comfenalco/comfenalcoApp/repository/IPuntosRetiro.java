package com.comfenalco.comfenalcoApp.repository;

import com.comfenalco.comfenalcoApp.entity.PuntosRetiros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPuntosRetiro extends JpaRepository<PuntosRetiros,Long> {
}
