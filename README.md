<h2 align='center'>
    Projeto de Engenharia de Software 1
</h2>

<h1 align='center'>
    Book Store
</h1>

# Índice

* [Membros da equipe](#membros)
* [Introdução](#introdução)
* [Diretorios](#diretórios)
* [Tecnologias](#requisitos)
* [Guia](#guia-de-usuário)
* [Api](#api)

# Membros

  * [Adriel Wanderson](https://github.com/adrielwanderson)
  * [Jailson Soares](https://github.com/jailsonsf)
  * [Paulo Vitor]()

# Introdução
Projeto com o objetivo de trazer facilidade aos clientes de livrarias, dando a eles a
possibilidade de conferir a disponibilidade de estoque e diversidade de livros antes de ir à loja fazer
suas compras. O sistema permite que o usuário pesquise livros com base na editora ou autor, e
assim verificar além de outras informações, o estoque do livro naquele momento, evitando que o
cliente vá até a loja atrás de um livro e não o encontre disponível.

# Diretórios
  ```bash
    ├─doc
    └─src
      └─bookstore
        ├─src
        │   ├─main
        │   │   ├─java
        │   │   │   └─com
        │   │   │     └─bookstore
        │   │   │       ├─controllers
        │   │   │       ├─models
        │   │   │       └─repository
        │   │   └─resources
        │   └─test
        │     └─java
        │       └─com
        │         └─bookstore
        └─target
          ├─classes
          ├─generated-sources
          ├─generated-test-sources
          ├─maven-archiver
          ├─maven-status
          ├─surefire-reports
          └─test-classes
  ```

# Requisitos

  * Java
  * Maven

# Guia de Usuário

  * Rodar a API:
    ```bash
      cd src/bookstore
    ```
  * E em seguida:
    ```bash
      make start
    ```
  * Ou se preverir rodar pelo arquivo .jar:
    ```bash
      make run
    ```

# Api

  * Para verificar o funcionamente da API podemos usar o [Postman](https://www.getpostman.com/) e importar o arquivo BookStore.postman_collection.json presente na pasta `src/bookstore/src/test`.