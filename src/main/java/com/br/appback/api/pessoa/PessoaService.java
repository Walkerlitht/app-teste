package com.br.appback.api.pessoa;

import com.br.appback.dto.PessoaDto;
import com.br.appback.generics.GenericService;
import com.br.appback.model.entity.Endereco;
import com.br.appback.model.entity.Pessoa;
import jakarta.ejb.*;

@TransactionManagement(TransactionManagementType.CONTAINER)
public class PessoaService extends GenericService<Pessoa> {

    public PessoaService() {
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Pessoa cadastrar(PessoaDto pessoaDto) {

        Pessoa pessoa = new Pessoa();

        if (pessoaDto != null) {
            Endereco endereco = new Endereco();

            if (pessoaDto.getEndereco() != null) {

                endereco.setCep(pessoaDto.getEndereco().getCep());
                endereco.setBairro(pessoaDto.getEndereco().getBairro());
                endereco.setEndereco(pessoaDto.getEndereco().getEndereco());
                endereco.setCidade(pessoaDto.getEndereco().getCidade());
                endereco.setNumero(pessoaDto.getEndereco().getNumero());

                pessoa.setEndereco(endereco);

            } else {
                pessoa.setEndereco(new Endereco());
            }
            persist(endereco);

            pessoa.setNome(pessoaDto.getNome());
            pessoa.setMatricula(pessoaDto.getMatricula());

            merge(pessoa);
        }
        return pessoa;
    }
}
