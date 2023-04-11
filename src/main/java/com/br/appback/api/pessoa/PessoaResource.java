package com.br.appback.api.pessoa;

import com.br.appback.dto.PessoaDto;
import com.br.appback.model.entity.Pessoa;
import com.br.appback.utils.Json;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Stateless
@Path("pessoas")
public class PessoaResource {

    @Inject
    private PessoaService pessoaService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(String json) {
        try {
            PessoaDto pessoaDto = Json.fromJson(json, PessoaDto.class);

            Pessoa pessoa = pessoaService.cadastrar(pessoaDto);

            return Response.ok(pessoa).build();

        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.status(400).build();
        }
    }
}
