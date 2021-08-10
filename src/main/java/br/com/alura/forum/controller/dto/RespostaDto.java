package br.com.alura.forum.controller.dto;

import br.com.alura.forum.modelo.Resposta;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class RespostaDto implements Serializable {

    private Long id;
    private String mensagem;
    private String NomeAutor;
    private LocalDateTime DataCriacao;

    public RespostaDto(Resposta resposta) {
        this.id = resposta.getId();
        this.mensagem = resposta.getMensagem();
        this.DataCriacao = resposta.getDataCriacao();
        this.NomeAutor = resposta.getAutor().getNome();
    }
}
