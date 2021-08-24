package br.com.alura.forum.modelo;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
public class Usuario implements UserDetails {

    private static final long serialVersionUID = 1L;

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

   // @ManyToOne(fetch = FetchType.EAGER)
   // private List<Perfil> perfils = new ArrayList<>();
    private List<Perfil> perfils= new ArrayList<>();

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.perfils;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
