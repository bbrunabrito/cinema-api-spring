package com.example.cinema.enums;

public enum SalaMensagens {
    TABELA_SALA_VAZIA("Não existe salas cadastradas."),
    ID_SALA_INVALIDO("o ID informado já está cadastrado"),
    ID_SALA_VAZIO("O ID não pode ser vazio"),
    NUMERO_SALA_VAZIO("O numero da sala não pode ser vazio"),
    SALA_NAO_ENCONTRADA("A sala não foi encontrada");


    private String mensagem;

    SalaMensagens(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
