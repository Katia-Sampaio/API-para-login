package br.com.API.projeto.exception;

public class SenhaException extends RuntimeException {
    public SenhaException(String message) {
        super(message); // contrutor com mensagem de erro
    }
}
