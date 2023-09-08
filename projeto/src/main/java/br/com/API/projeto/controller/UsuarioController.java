package br.com.API.projeto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.API.projeto.model.Usuario;
import br.com.API.projeto.service.usuarioService;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {

	private usuarioService UsuarioService;

	public UsuarioController(usuarioService UsuarioService) {
		this.UsuarioService = UsuarioService;
	}

	// listagem de usuarios
	@GetMapping
	public ResponseEntity<List<Usuario>> listaUsuarios() {
		return ResponseEntity.status(200).body(UsuarioService.listarUsuario());
	}

	// criação de usuario
	@PostMapping
	public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
		return ResponseEntity.status(201).body(UsuarioService.criarusuario(usuario));
	}

	// editar usuario
	@PutMapping
	public ResponseEntity<Usuario> EditarUsuario(@RequestBody Usuario usuario) {
		return ResponseEntity.status(200).body(UsuarioService.editarusuario(usuario));
	}

	// deletar usuario, pelo endpoint
	@DeleteMapping("/{id}")
	public ResponseEntity<?> DeletarUsuario(@PathVariable Integer id) {
		UsuarioService.deletarusuario(id);
		return ResponseEntity.status(204).build(); // n tem corpo
	}

}
