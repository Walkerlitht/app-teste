package com.br.appback.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "matricula")
    private String matricula;

    @OneToOne
    @JoinColumn(name = "id_nivel_acesso")
    private NivelAcesso nivelAcesso;

    @Column(name = "id_nivel_acesso")
    private Long idNivelAcesso;

    @OneToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    @Column(name = "id_endereco")
    private Long idEndereco;

    @PostPersist
    private void prePersist() {

        if (endereco.getId() != null) {
            this.idEndereco = endereco.getId();
        }
    }
}
