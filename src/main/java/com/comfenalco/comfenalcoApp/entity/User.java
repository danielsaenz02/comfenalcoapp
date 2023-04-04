package com.comfenalco.comfenalcoApp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity()
@Table(name = "usercomfenalco")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true)
    private Date createdAt;

    private String status;
    private String identificationNumber;

    @PrePersist
    private void onCrete(){
        createdAt = new Date();
    }
}
