package com.comfenalco.comfenalcoApp.repository;

import com.comfenalco.comfenalcoApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {

    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findByEmail(@Param("email") String email);

    @Query(nativeQuery = true,value = "SELECT * from UserComfenalco WHERE identification_Number = ?")
    Optional<User> findByNumeroDocumento(String identificationNumber);
}
