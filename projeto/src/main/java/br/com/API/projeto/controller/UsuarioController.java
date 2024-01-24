package br.com.API.projeto.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.API.projeto.model.Usuario;
import br.com.API.projeto.service.usuarioService;
import io.micrometer.common.util.StringUtils;
import jakarta.validation.Valid;

import java.util.regex.Pattern;

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
	public ResponseEntity<Usuario> criarUsuario(@Valid @RequestBody Usuario usuario) {
		if (!validarSenha(usuario.getSenha())) {
			throw new SenhaInvalidaException("FALSE - Senha inválida");
		}
		return ResponseEntity.status(201).body(UsuarioService.criarusuario(usuario));
	}

	// editar usuario
	@PutMapping
	public ResponseEntity<Usuario> EditarUsuario(@Valid @RequestBody Usuario usuario) {
		if (!validarSenha(usuario.getSenha())) {
			throw new SenhaInvalidaException("FALSE - Senha inválida");
		}
		return ResponseEntity.status(200).body(UsuarioService.editarusuario(usuario));
	}

	// deletar usuario, pelo endpoint
	@DeleteMapping("/{id}")
	public ResponseEntity<?> DeletarUsuario(@PathVariable Integer id) {
		UsuarioService.deletarusuario(id);
		return ResponseEntity.status(204).build(); // n tem corpo
	}

	// validação dos dados
	private static final String REGEX_VALIDACAO_SENHA = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()+-])(?=\\S+$).{9,}$";

	public static boolean validarSenha(String senha) {
		Pattern pattern = Pattern.compile(REGEX_VALIDACAO_SENHA); // compilando a expressão regular
		return pattern.matcher(senha).matches() && caracteresUnicos(senha);
	}

	// método auxiliar que verifica se todos os caracteres na senha são únicos.
	private static boolean caracteresUnicos(String senha) {
		return senha.chars().distinct().count() == senha.length();
	}

	// manipulador de exceções - campos vazios
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {

		Map<String, String> errors = new HashMap<String, String>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);

		});

		return errors;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(SenhaInvalidaException.class)
	public Map<String, String> handleSenhaInvalidaException(SenhaInvalidaException ex) {
		Map<String, String> errors = new HashMap<>();
		errors.put("senha", ex.getMessage());
		return errors;
	}

}
