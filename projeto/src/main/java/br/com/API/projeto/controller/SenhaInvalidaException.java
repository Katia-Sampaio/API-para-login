package br.com.API.projeto.controller;

public class SenhaInvalidaException extends RuntimeException{ //classe de exeção
    public SenhaInvalidaException(String message) {
        super(message); //contrutor com mensagem de erro
    }
}
