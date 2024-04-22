package com.example.cinema.enums;

public enum FilmeMensagens {
    TABELA_FILMES_VAZIA("Não há filmes cadastrados."),
    ID_FILME_INVALIDO("O ID informado já esta cadastrado."),
    ID_FILME_VAZIO("O ID não pode ser vazio"),
    FILME_NAO_ENCONTRADO("Filme informado não encontrado."),
    NOME_FILME_VAZIO("O nome não pode ser vazio.");
    private String mensagem;
    FilmeMensagens(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
