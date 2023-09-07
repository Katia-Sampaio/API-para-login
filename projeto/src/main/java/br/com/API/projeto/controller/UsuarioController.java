package br.com.API.projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.API.projeto.DAO.IUsuario;
import br.com.API.projeto.model.Usuario;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController{

//injeção de dependencias
@Autowired
private IUsuario dao;

//listagem de usuarios
	@GetMapping
	public List<Usuario> listaUsuarios () {
		return (List<Usuario>) dao.findAll();
	}
//criação de usuario
	@PostMapping
	public  Usuario criarUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioNovo = dao.save(usuario);
		return usuario;
	}
//editar usuario
	@PutMapping
	public  Usuario EditarUsuario(@RequestBody Usuario usuario) {
		Usuario usuarioNovo = dao.save(usuario);
		return usuario;
	}
//deletar usuario, pelo endpoint
	@DeleteMapping("/{id}")
	public Optional<Usuario> DeletarUsuario(@PathVariable Integer id) {
		Optional<Usuario> usuario = dao.findById(id);
		dao.deleteById(id);
		return usuario;
	}	
}
