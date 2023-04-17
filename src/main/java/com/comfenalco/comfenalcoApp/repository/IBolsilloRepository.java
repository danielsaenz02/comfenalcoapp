package com.comfenalco.comfenalcoApp.repository;

import com.comfenalco.comfenalcoApp.entity.Bolsillo;
import com.comfenalco.comfenalcoApp.service.BolsilloService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBolsilloRepository extends JpaRepository<Bolsillo,Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM Bolsillos where idafiliado = ?")
    List<Bolsillo> findBolsilloByIdafiliado(Long idafiliado);
}
