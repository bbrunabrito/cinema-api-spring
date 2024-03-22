package com.example.cinema.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "TB_SESSAO")
public class Sessao {
    @Id
    @Column(name = "ID_SESSAO")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_FILME", referencedColumnName = "ID_FILME")
    private Filme idFilme;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_SALA", referencedColumnName = "ID_SALA")
    private Sala idSala;
}
