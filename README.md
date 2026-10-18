# Academic API

Uma API RESTful simples desenvolvida para o gerenciamento acadêmico, permitindo a criação, leitura, atualização e exclusão (CRUD) de Estudantes e Professores.

## Tecnologias Utilizadas

* **Java**
* **Spring Boot**
* **Banco de Dados H2** (Em memória)

## Como Executar o Projeto

1. Abra a pasta do projeto no VS Code (ou na sua IDE de preferência).
2. Localize e execute o arquivo principal `CrudApplication.java`.
3. A aplicação estará disponível localmente no endereço: `http://localhost:8080`

*Nota: Como o banco de dados H2 roda em memória, os dados são limpos sempre que a aplicação é reiniciada. Para testar, faça sempre um `POST` antes de tentar ler, alterar ou apagar um registro.*

## Endpoints da API

### Estudantes
URL Base: `http://localhost:8080/api/students`

* `POST /` - Cria um novo estudante.
* `GET /` - Retorna a lista de todos os estudantes.
* `GET /{id}` - Retorna os detalhes de um estudante específico.
* `PUT /{id}` - Atualiza os dados de um estudante.
* `DELETE /{id}` - Remove um estudante.

### Professores
URL Base: `http://localhost:8080/api/professors`

* `POST /` - Cria um novo professor.
* `GET /` - Retorna a lista de todos os professores.
* `GET /{id}` - Retorna os detalhes de um professor específico.
* `PUT /{id}` - Atualiza os dados de um professor.
* `DELETE /{id}` - Remove um professor.