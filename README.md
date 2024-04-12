# API de Cinema - Spring Boot

Esta é uma API de criada para estudos. Tem como objetivo gerenciar informações sobre filmes, salas de cinema e sessões.
Foi desenvolvida usando o framework Spring Boot.

## Funcionalidades

- Cadastro, consulta, atualização e remoção de filmes;
- Cadastro, consulta, atualização e remoção de salas de cinema;
- Cadastro, consulta, atualização e remoção de sessões.

## Requisitos

- Java 17 ou superior.
- Maven
- Banco de Dados (por padrão foi utilizado o banco de dados Oracle, mas pode
  ser configurado em outros banco de dados. Basta fazer a configuração no `src/main/resources/applications.properties`)

## Instalação e Configuração

1. Clone do repositório:

```apache
git clone https://github.com/bbrunabrito/cinema-api-spring.git
```

2. Navegue até o repositório do projeto:

```
cd cinema-api-spring
```

3. Compile o programa usando:

```
mvn clean install
```

4. Execute a aplicação

```
mvn springboot:run
```

## Uso

Você pode usar qualquer cliente HTTP para fazer requisições a API

Caso utilize o PostMan, você pode usar a [CinemaCollectionspostman_collection.json](assets/Cinema Collections.postman_collection.json)
para testar a API.

### Filmes

```
GET localhost:8080/filmes
OU
GET localhost:8080/filmes/{id}
OU
POST localhost:8080/filmes
OU
PUT localhost:8080/filmes/{id}
OU
DELETE localhost:8080/filmes/{id}
```

### Body

```
{
        "id": "78",
        "nome": "Filme",
        "descricao": "Filme teste"
}
```

## Salas

```
GET localhost:8080/salas
OU
GET localhost:8080/salas/{ID}
OU
POST localhost:8080/salas
OU 
PUT localhost:8080/salas/{ID}
OU
DELETE localhost:8080/salas/{ID}
```

### Body

```
{
    "id": "146c",
    "numero": 7
}
```

## Sessões

```
GET localhost:8080/sessoes
OU
GET localhost:8080/sessoes/{ID}
OU
POST localhost:8080/sessoes
OU
PUT localhost:8080/sessoes/{ID}
OU 
DELETE localhost:8080/sessoes/{ID}
```

### Body

```
{
        "id": "5ss",
        "filme": {
            "id": "F25B9E8706CC4382B8F06BF63999AA32",
            "nome": "Donnie Darko",
            "descricao": "Filme de Ficção"
        },
        "sala": {
            "id": "146b",
            "numero": 2
        }
}
```

## Documentação da API

Para acessar a documentação da API basta executar a aplicação e acessar `http://localhost:8080/swagger-ui/index.html#/` no navegador.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE)
