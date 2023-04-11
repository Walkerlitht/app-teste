package com.br.appback.dto;

import com.br.appback.model.entity.Endereco;
import com.br.appback.model.entity.NivelAcesso;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class PessoaDto {

    private Long id;
    private String nome;
    private String matricula;
    private NivelAcesso nivelAcesso;
    private Endereco endereco;
}
