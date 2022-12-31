package com.example.jpaBoard.jpa.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "boardJpa")
public class BoardJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String passwd;

    private String title;

    private String content;

}
