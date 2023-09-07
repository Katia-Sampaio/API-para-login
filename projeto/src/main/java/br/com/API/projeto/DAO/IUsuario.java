package br.com.API.projeto.DAO;

import org.springframework.data.repository.CrudRepository;

import br.com.API.projeto.model.Usuario;

public interface IUsuario extends CrudRepository<Usuario, Integer> {


}
