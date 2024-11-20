
<!-- EXCEPTION HANDLER, TESTES -->

<h1 align="center">
  TODO List
</h1>

<p align="center">
 <img src="https://img.shields.io/static/v1?label=Tipo&message=Desafio&color=8257E5&labelColor=000000" alt="Desafio" />
</p>

API para gerenciar tarefas (CRUD) que faz parte [desse desafio](https://github.com/simplify-liferay/desafio-junior-backend-simplify) para pessoas desenvolvedoras backend júnior, que se candidatam para a Simplify.


## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Mysql](https://dev.mysql.com/downloads/)

## Práticas adotadas

- SOLID, DRY, YAGNI, KISS
- DTO
- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
- Tratamento de respostas de erro

## Como Executar

- Clonar repositório git
- Construir o projeto:
```
$ ./mvnw clean package
```
- Executar a aplicação:
```
$ java -jar target/todolist-0.0.1-SNAPSHOT.jar
```

A API poderá ser acessada em [localhost:8080](http://localhost:8080).

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [postman](https://www.postman.com/)

Criar Tarefa 
```bash
curl -X POST http://localhost:8080/ \
     -H "Content-Type: application/json" \
     -d '{
           "nome": "Todo 1",
           "descricao": "Desc Todo 1",
           "prioridade": 1,
           "realizado": true,
         }'
```

Resposta:

```bash
{
    "codigo":  1,
    "nome":  "Todo 1",
    "descricao":  "Desc Todo 1",
    "prioridade":  1,
    "realizado":  true
}
```
<br> </br>
<hr>
<br> </br>
Listar Tarefas

```bash
curl -X GET http://localhost:8080/
```

Resposta:
```bash
[
  {
      "codigo":"1",
      "nome":  "Todo 1",
      "descricao":  "Desc Todo 1",
      "prioridade":  1,
      "realizado":  true
  }
]
```

<br> </br>
<hr>
<br> </br>

Atualizar Tarefa por CÓDIGO

Campos:
```bash
 "codigo":        OBRIGATÓRIO
 "nome":          (OPCIONAL)
 "descricao":     (OPCIONAL)
 "prioridade":    (OPCIONAL)
 "realizado":     (OPCIONAL)
 ```

```bash
curl -X PATCH http://localhost:8080/ \
     -H "Content-Type: application/json" \
     -d '{
        "codigo": 1
        "nome": "Todo 1",
        "descricao": "Desc Todo 1",
        "prioridade": 2
         }'
```

Resposta:
```bash
{
        "codigo":  1,
        "nome":  "Todo 1",
        "descricao":  "Desc Todo 1",
        "prioridade":  2,
        "realizado":  false
}
```
<br> </br>
<hr>
<br> </br>

Remover Tarefa por CÓDIGO

Campos:
```bash
"codigo": OBRIGATÓRIO
```

```bash
curl -X DELETE http://localhost:8080/ \
     -H "Content-Type: application/json" \
     -d '{
        "codigo": 4
         }'
```

Resposta:
```bash
No Content
{}
```