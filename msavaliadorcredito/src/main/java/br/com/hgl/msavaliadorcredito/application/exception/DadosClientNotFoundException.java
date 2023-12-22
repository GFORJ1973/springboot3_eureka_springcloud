package br.com.hgl.msavaliadorcredito.application.exception;

public class DadosClientNotFoundException extends Exception {
    public DadosClientNotFoundException(){
        super("Dados do cliente não encontrados para o CPF informado!");
    }
}
