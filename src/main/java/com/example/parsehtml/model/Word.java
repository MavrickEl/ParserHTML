package com.example.parsehtml.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "word")
public class Word {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "word")
    private String word;

    @Column(name = "amount")
    private int amount;
}
