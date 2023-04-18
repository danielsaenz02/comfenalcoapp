package com.comfenalco.comfenalcoApp.repository;

import com.comfenalco.comfenalcoApp.entity.CategoriaBolsillo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriaRepository extends JpaRepository<CategoriaBolsillo,Long> {
}
