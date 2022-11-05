package com.example.chatexample.entity;


import javax.persistence.*;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private Long idAuto;

    @Column(unique = true, nullable = false)
    private String id;

    private String pw;
}
