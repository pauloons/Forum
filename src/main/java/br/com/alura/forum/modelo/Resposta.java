package br.com.alura.forum.modelo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Data
@Entity
@Table
public class Resposta implements Serializable {

	//@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private String mensagem;
	@ManyToOne
	private Topico topico;
	private LocalDateTime dataCriacao = LocalDateTime.now();
	@ManyToOne
	private Usuario autor;
	private Boolean solucao = false;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Resposta resposta = (Resposta) o;
		return id.equals(resposta.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
