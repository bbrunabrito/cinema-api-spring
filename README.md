# API de Cinema - Spring Boot

Esta é uma API de criada para estudos. Tem como objetivo gerenciar informações sobre filmes, salas de cinema e sessões.
Foi desenvolvida usando o framework Spring Boot.

## Funcionalidades

- Cadastro e consulta de filmes;
- Cadastro e consulta de salas de cinema;
- Cadastro e consulta de sessões.

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

Você pode usar qualquer cliente HTTP para fazer requisições a API. Para acessar a documentação da API basta executar a aplicação e acessar `http://localhost:8080/swagger-ui/index.html#/` no navegador.

### Filmes

**GET:**

```
GET http://localhost:8080/filmes
ou
GET http://localhost:8080/filmes/{id}
```

---

**POST:**

```
POST http://localhost:8080/filmes
```

**BODY:**

```
{
        "id": "F25B9E8706CC4382B8F06BF63999AA32",
        "nome": "Donnie Darko",
        "descricao": "Filme de Ficção"
}
```

### Salas de Cinema

**GET:**

```
GET http://localhost:8080/salas
ou
http://localhost:8080/salas/{id}
```

---

**POST:**

```
POST http://localhost:8080/salas
```

**BODY:**

```
{
        "id": "146b",
        "numero": 2
}
```

### Sessões

**GET:**

```
GET http://localhost:8080/sessoes
OU
http://localhost:8080/sessoes/{id}
```

---

**POST:**

```
POST http://localhost:8080/sessoes
```

**BODY:**

```
    {
        "id": "2ss",
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

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE)
