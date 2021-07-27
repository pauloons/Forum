package br.com.alura.forum.modelo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Data
@Entity
public class Usuario implements Serializable {

	//@Column(name = "Id_Usuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	//@Column(name = "NOME")
	private String nome;

	//@Column(name = "EMAIL")
	private String email;

	//@Column(name = "SENHA",nullable = false)
	private String senha;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Usuario usuario = (Usuario) o;

		return id.equals(usuario.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
