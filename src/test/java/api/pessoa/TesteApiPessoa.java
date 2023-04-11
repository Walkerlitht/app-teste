package api.pessoa;

import com.br.appback.api.pessoa.PessoaResource;
import com.br.appback.api.pessoa.PessoaService;
import com.br.appback.dto.PessoaDto;
import com.br.appback.model.entity.Endereco;
import com.br.appback.model.entity.NivelAcesso;
import com.br.appback.model.entity.Pessoa;
import com.br.appback.utils.Json;
import com.google.gson.Gson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.inject.Inject;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class TesteApiPessoa {

    @Inject
    private PessoaService pessoaService;

    @BeforeEach
    public void before() {
        pessoaService = new PessoaService();
    }


    @Test
    public void testeCadastroPessoa() {

        NivelAcesso nivelAcesso = new NivelAcesso();

        Endereco endereco = new Endereco();
        endereco.setEndereco("Rua");
        endereco.setNumero("186");
        endereco.setBairro("Aventuras");
        endereco.setCidade("Joinvas");
        endereco.setCep("186014244");

        PessoaDto pessoa = new PessoaDto();
        pessoa.setNome("Luis");
        pessoa.setMatricula("13669012");
        pessoa.setNivelAcesso(nivelAcesso);
        pessoa.setEndereco(endereco);

        Pessoa pessoaCadastrada = pessoaService.cadastrar(pessoa);

        Assertions.assertNotNull(pessoaCadastrada);
        Assertions.assertEquals(pessoa, pessoaCadastrada);
        Assertions.assertEquals(pessoa.getEndereco(), endereco);
    }
}
