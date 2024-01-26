package br.com.API.projeto.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.API.projeto.model.Usuario;
import br.com.API.projeto.repository.IUsuario;

@Service
public class usuarioService {

	// Classe que contem os metodos http
	private IUsuario repository;
	private PasswordEncoder passwordEncoder;

	public usuarioService(IUsuario repository) {
		this.repository = repository;
		this.passwordEncoder = new BCryptPasswordEncoder(); // criptografar senha
	}

	// metodo para listar usuarios
	public List<Usuario> listarUsuario() {
		List<Usuario> lista = (List<Usuario>) repository.findAll();
		return lista;
	}

	// metodo para criar usuarios
	public Usuario criarusuario(Usuario usuario) {
		String encoder = this.passwordEncoder.encode(usuario.getSenha()); // retorna a senha codificada
		usuario.setSenha(encoder);
		Usuario NovoUsuario = repository.save(usuario);
		return NovoUsuario;
	}

	// metodo para editar usuarios
	public Usuario editarusuario(Usuario usuario) {
		String encoder = this.passwordEncoder.encode(usuario.getSenha()); // retorna a senha codificada
		usuario.setSenha(encoder);
		Usuario NovoUsuario = repository.save(usuario);
		return NovoUsuario;
	}

	// metodo para deletar usuarios
	public Boolean deletarusuario(Integer id) {
		repository.deleteById(id);
		return true;
	}

}
