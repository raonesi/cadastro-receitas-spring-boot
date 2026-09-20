# Sistema de Cadastro de Receitas

## Dados do trabalho

- **Aluno:** Raone
- **Disciplina:** Desenvolvimento de Sistemas Web II
- **Sistema:** Cadastro de Receitas

## Descricao

Aplicacao Web para cadastrar, listar, editar e excluir receitas. Cada receita possui nome, categoria, ingredientes, modo de preparo, tempo de preparo, rendimento e dificuldade. O sistema aplica validacoes no formulario e persiste os dados em PostgreSQL.

## Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring MVC
- Thymeleaf
- Bean Validation
- Spring Data JPA e Hibernate
- PostgreSQL
- Maven

## Banco de dados

Nome sugerido: `cadastro_receitas`

```sql
CREATE DATABASE cadastro_receitas;
```

As credenciais padrao estao configuradas em `src/main/resources/application.properties` com usuario e senha `postgres`. Altere-as se o seu PostgreSQL usar credenciais diferentes.

## Como executar

1. Instale o Java 17, Maven e PostgreSQL.
2. Crie o banco de dados `cadastro_receitas`.
3. Ajuste a URL, o usuario e a senha em `application.properties`, se necessario.
4. No terminal, entre na pasta do projeto e execute:

```bash
mvn spring-boot:run
```

5. Acesse `http://localhost:8080/receitas` no navegador.

## Estrutura do projeto

```text
controller  -> ReceitaController: rotas e telas
service     -> ReceitaService: regras e operacoes CRUD
repository  -> ReceitaRepository: acesso ao banco de dados
model       -> Receita: entidade e validacoes
```

## Demonstracao para a apresentacao

1. Inicie a aplicacao e abra a tela de receitas.
2. Cadastre uma receita valida.
3. Tente salvar com um campo obrigatorio vazio para exibir as validacoes.
4. Mostre a receita na listagem.
5. Edite a receita e salve novamente.
6. Exclua a receita.
