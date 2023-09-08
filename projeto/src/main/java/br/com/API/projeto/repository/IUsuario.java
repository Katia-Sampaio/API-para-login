package br.com.API.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import br.com.API.projeto.model.Usuario;

public interface IUsuario extends CrudRepository<Usuario, Integer> {

}
