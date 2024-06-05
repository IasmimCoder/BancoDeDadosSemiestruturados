# Projeto de Banco de Dados Semi Estruturados: Cadastro de Empresas Regularizadas

Este projeto foi desenvolvido para a disciplina de Banco de Dados Semi Estruturados. O banco de dados aberto utilizado no projeto é "Cadastro de Empresas Regularizadas", disponível em https://dados.gov.br/dados/conjuntos-dados/dados-cadastrais.  O projeto foi desenvolvido utilizando Java com Spring Boot e PostgreSQL para o banco de dados.

## Funcionalidades do Projeto

### Filtragem de Empresas
A solução proposta no projeto permite ao cliente filtrar empresas com base em diversos critérios para obter informações organizadas de endereço e contato. As opções de filtro incluem:

- Nome da Empresa: Busca empresas pelo nome.
- Código FIP: Busca empresas pelo código FIP.
- Domínio de Mercado: Busca empresas com base no tipo de atuação.

##  Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:

- Spring Boot: 
    - Framework Java utilizado para criar aplicações stand-alone, de produção, prontas para rodar com mínimo esforço de configuração.

- PostgreSQL

    - Sistema de gerenciamento de banco de dados relacional, utilizado para armazenar os dados das empresas, domínios de mercado, endereços e contatos.

- Hibernate

    - Framework ORM (Object-Relational Mapping) utilizado para o mapeamento das classes Java para as tabelas do banco de dados, facilitando as operações de CRUD (Create, Read, Update, Delete).

- Jakarta Persistence API (JPA)

    - API de persistência Java utilizada em conjunto com o Hibernate para realizar o mapeamento objeto-relacional.

- Maven

    - Ferramenta de automação de compilação e gerenciamento de dependências do projeto.

- Docker

    - Plataforma de containers que permite a criação e gerenciamento de ambientes de desenvolvimento e produção isolados e consistentes, utilizada aqui para rodar o PostgreSQL.

### Ferramentas de Desenvolvimento
- IntelliJ IDEA

    - IDE (Integrated Development Environment) utilizada para desenvolver e depurar o código Java.
- Postman

    - Ferramenta utilizada para testar as APIs desenvolvidas no projeto.

### Outras Tecnologias
- Java 17

    - Linguagem de programação utilizada para desenvolver o projeto.
- Git

     - Sistema de controle de versão distribuído utilizado para gerenciar o código-fonte do projeto.
- GitHub

    - Plataforma de hospedagem de código-fonte utilizada para colaborar no desenvolvimento do projeto e armazenar o repositório Git.


## Estrutura do Banco de Dados

### Tabela DominioDeMercado
A tabela DominioDeMercado contém os diferentes tipos de atuação que as empresas cadastradas podem ter. Esta tabela possui os seguintes campos:

- codigo (Integer): Código do domínio de mercado (chave primária).
- descricao (String): Descrição do tipo de atuação.

### Tabela Empresa
A tabela Empresa armazena informações sobre as empresas cadastradas. Esta tabela possui os seguintes campos:

- entcgc (String): CGC da empresa (único e não nulo).

- entcodigofip (String): Código FIP da empresa (chave primária)

- entnome (String): Nome da empresa.

- dataautorizacao (String): Data de autorização da empresa.

- mercodigo (ManyToOne): Relacionamento com a tabela DominioDeMercado.

- endereco (OneToOne): Relacionamento com a tabela Endereco.


### Tabela Endereco

A tabela Endereco armazena informações de endereço das empresas. Esta tabela possui os seguintes campos:

- id (UUID): Identificador único do endereço (chave primária).
- endereco (String): Endereço da empresa.
- bairro (String): Bairro da empresa.
- cidade (String): Cidade da empresa.
- cep (String): CEP da empresa.


### Tabela Contato
A tabela Contato armazena informações de contato das empresas. Esta tabela possui os seguintes campos:

- id (UUID): Identificador único do contato (chave primária).

- telefone (String): Telefone/celular da empresa.

- ddd (String): DDD do telefone/celular da empresa.

- fax (String): Fax da empresa.

## Executando o Projeto

1. Certifique-se de que o Docker está instalado e em execução.

2. Suba o container do PostgreSQL utilizando o Docker Compose.

3. Execute o projeto Spring Boot utilizando seu IDE favorito ou através da linha de comando com mvn spring-boot:run.

4. O aplicativo estará disponível na porta 8080.
