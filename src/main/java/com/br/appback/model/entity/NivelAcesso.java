package com.br.appback.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity(name = "nivel_acesso")
@Table(name = "nivel_acesso")
public class NivelAcesso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_nivel_acesso")
    private Long id;
}
