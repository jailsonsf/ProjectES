<h3 align='center'>
    Projeto de Engenharia de Software 1
</h3>

<h1 align='center'>
    Book Store
</h1>

* [Membros da equipe](#membros)
* [Introdução](#introdução)
* [Requisitos](#requisitos)
  * [Elicitação dos requisitos](#elicitação-dos-requisitos)
  * [Requisitos Funcionais](#requisitos-funcionais)
  * [Requisitos não funcionais](#requisitos-não-funcionais)
* [Projeto](#projeto)
  * [Projeto orientado a objetos](#projeto-orientado-a-objetos)

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

# Requisitos
## Elicitação dos requisitos

### Brainstorming

1. Consultar informações sobre livros
1. Pesquisar livros de uma editora específica
1. Pesquisar livros de um autor específico
1. Reservar livros para compra
1. Cadastrar usuários
1. Cadastrar autores
1. Cadastrar autores
1. Cadastrar livros

## Requisitos funcionais

![Casos de uso](https://raw.githubusercontent.com/jailsonsf/ProjectES/master/docs/assets/CasosDeUso.jpeg)
Fig.1 - Diagrama de Casos de Uso - Funcionalidades do sistema com base em usuário e funcionário.

**Caso de uso:**  | Cadastrar Livro
------------------|----------------
**Ator(es):**     | Funcionário
**Pré-condições:**| Editora e autor do Livro já estarem cadastrados
**Fluxo padrão:** | Inserir os dados do livro, incluindo os identificadores de editora e autor
**Fluxo de exceção 1:** | Dados da editora não estarem presentes no sistema
**Fluxo de exceçao 2:** | Dados do autor não estarem presentes no sistema
**Pós-condições:** | Estar com o livro cadastrado e disponível para consultas
**Prioridade** | Desejável – Necessária – Imprescindível

**Caso de uso:**  | Cadastrar Livro
------------------|----------------
**Fluxo de exceção 1:** | Dados da editora não estarem presentes no sistema
**Descrição** | Ao tentar cadastrar livro sem sucesso por falta dos dados da editora estarem presentes no sistema, o funcionário cadastra a editora para poder seguir com o cadastro do livro
**Fluxo de exceção 2:** | Dados do autor não estarem presentes no sistema
**Descrição** | Ao tentar cadastrar livro sem sucesso por falta dos dados do autor estarem presentes no sistema, o funcionário cadastra o autor para poder seguir com o cadastro do livro

**Caso de Uso** | Cadastrar Editora
----------------|------------------
**Ator(es):** | Funcionário
**Pré-condições:** | Editora não estar cadastrada no sistema
**Fluxo padrão:** | Inserir os dados da editora
**Pós-condições:** | Estar com a editora cadastrada e disponível para consultas
**Prioridade:** | Desejável – Necessária – Imprescindível

**Caso de Uso** | Cadastrar Autor
----------------|----------------
**Autor(es):** | Funcionário
**Pré-condições:** | Autor não estar cadastrado no sistema
**Fluxo padrão:** | Inserir os dados do autor
**Pós-condições:** | Estar com o autor cadastrado e disponível para consultas
**Prioridade:** | Desejável – Necessária – Imprescindível

**Caso de Uso:** | Cadastrar Cliente
----------------|----------------
**Ator(es):** | Funcionário
**Pré-condições:** | Cliente ser um novo usuário e não estar presente no sistema
**Fluxo padrão:** | Inserir os dados do cliente
**Pós-condições:** | O cliente estar cadastro e poder usar o sistema
**Prioridade:** | Desejável – Necessária – Imprescindível

**Caso de Uso:** | Reservar Compra de Livro
----------------|----------------
**Ator(es):** | Usuário
**Pré-condições:** | Livros escolhidos estarem disponíveis
**Fluxo padrão:** | Livros escolhidos estarem disponíveis
**Fluxo de exceção 1:** | Algum livro não estar disponível no momento
**Pós-condições:** | Estar com os livros reservados para o usuário ao chegar na livraria
**Prioridade:** | Desejável – Necessária – Imprescindível

**Caso de uso:**  | Reservar Compra de Livro
------------------|----------------
**Fluxo de exceção 1:** | Algum livro não estar disponível no momento
**Descrição** | Caso algum dos livros escolhidos pelo usuário não estejam disponíveis, o
sistema informa a situação, e o usuário pode optar por outro livro ou
aguardar até que o livro escolhido inicialmente esteja disponível

**Caso de Uso:** | Consultar Livro
----------------|----------------
**Ator(es):** | Usuário
**Pré-condições:** | Livro estar cadastrado no sistema
**Fluxo padrão:** | Inserir o nome do livro
**Pós-condições:** | Retornar as informações do livro e disponibilidade
**Prioridade:** | Desejável – Necessária – Imprescindível

**Caso de Uso:** | Consultar Autor
----------------|----------------
**Ator(es):** | Usuário
**Pré-condições:** | Autor estar cadastrado no sistema
**Fluxo padrão:** | Inserir o nome do autor
**Pós-condições:** | Retornar as informações do Autor e livros escritos pelo autor
**Prioridade:** | Desejável – Necessária – Imprescindível

**Caso de Uso:** | Consultar Editora
----------------|----------------
**Ator(es):** | Usuário
**Pré-condições:** | Editora estar cadastrado no sistema
**Fluxo padrão:** | Inserir o nome da editora
**Pós-condições:** | Retornar as informações da editora e livros publicados por ela
**Prioridade:** | Desejável – Necessária – Imprescindível

## Requisitos não Funcionais

  - **RFN 1** -  Adicionar título de mais pesquisado para livros, editoras e autores.
  **Descrição:**  Disponibilizar como parte da informação a classificação de mais pesquisado.
  **Verificação:** Se a quantidade de pesquisas para um determinado objeto for a maior, ele deve receber o título de mais pesquisado e esse título passa a ser parte das informações sobre esse objeto. Perdendo esse título apenas se for ultrapassado por outro objeto que pertença na mesma categoria.

# Projeto
## Projeto orientado a objetos

![Diagrama de Classes](https://raw.githubusercontent.com/jailsonsf/ProjectES/master/docs/assets/DiagramaDeClasses.jpeg)
Fig. 2 – Diagrama de Classes

No diagrama de classes da Fig. 2 podemos ver as classes existentes no sistema, herança e relacionamentos presentes: O usuário pode consultar as informações sobre livros, editoras e autores.

![Diagrama de Sequência](https://raw.githubusercontent.com/jailsonsf/ProjectES/master/docs/assets/DiagramaDeSequencia.jpeg)
Fig. 3 – Diagrama de Sequência

No diagrama de sequência da Fig. 3 podemos ver o processo presente em uma pesquisa do usuário para buscar um determinado livro, chamando o método consultarLivro() é verificado se o livro que está sendo buscado existe, se sim será retornado ao usuário as informações existentes para o respectivo livro.

![Diagrama de Estado](https://raw.githubusercontent.com/jailsonsf/ProjectES/master/docs/assets/DiagramaEstado.jpeg)
Fig. 4 – Diagrama de Estado

Ao iniciar uma consulta o funcionário pode cadastrar um objeto caso o mesmo ainda não exista no sistema, para que possam ser feitas consultas em busca do objeto.