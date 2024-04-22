package com.example.cinema.enums;

public enum SessaoMensagens {
    TABELA_SESSAO_VAZIA("Nenhuma sessão cadastrada"),
    ID_SESSAO_INVALIDO("O ID informado já está cadastrado"),
    ID_SESSAO_VAZIO("O ID não pode ser vazio"),
    ID_SESSAO_FILME_INVALDI("O ID do Filme não foi encontrado"),
    ID_SESSAO_SALA_INVALIDO("O ID da Sala não foi encontrado"),
    ID_SESSAO_SALA_VAZIO("O ID da Sala não pode ser vazio"),
    ID_SESSAO_FILME_VAZIO("O ID do Filme não pode ser vazio"),
    SESSAO_NAO_ENCONTRADA("A sessão não foi encontrada");
    private String mensagem;

    SessaoMensagens(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
