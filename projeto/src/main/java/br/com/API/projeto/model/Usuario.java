package br.com.API.projeto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
 private Integer id;

@Email(message = "Insira um email válido!")
@NotBlank(message = "O email é obrigatório!")
@Column(name = "email", length = 50, nullable = false)
 private String email;

@NotBlank(message = "A senha é obrigatória!")
@Column(name = "senha", columnDefinition = "TEXT", nullable = false)
 private String senha;


 
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getSenha() {
	return senha;
}
public void setSenha(String senha) {
	this.senha = senha;
}
 
 
}
