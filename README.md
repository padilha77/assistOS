# AssistOS

**Sistema de gestão para assistências técnicas | Java**

O AssistOS é um projeto pessoal de desenvolvimento de software, criado para simplificar o gerenciamento de clientes, equipamentos e ordens de serviço em assistências técnicas.

O objetivo é construir uma aplicação organizada, funcional e escalável, evoluindo gradualmente de um sistema em Java para uma solução completa de gestão.

## Sobre o projeto

O AssistOS nasceu de uma ideia simples: transformar meus estudos em algo real.

Em vez de desenvolver apenas exercícios isolados, decidi construir um sistema que pudesse acompanhar minha evolução como desenvolvedor, colocando em prática novos conceitos, tecnologias e boas práticas ao longo do caminho.

Minha intenção é ir além de um projeto de portfólio. Quero desenvolver uma aplicação que, futuramente, possa ser utilizada por negócios reais.

## Tecnologias

**Atualmente:**
- Java
- Programação Orientada a Objetos (POO)
- Collections Framework
- Git e GitHub

**Planejadas para as próximas versões:**
- Spring Boot
- PostgreSQL
- Spring Data JPA
- Spring Security
- HTML, CSS e JavaScript
- Docker
- Testes automatizados

## Funcionalidades

O desenvolvimento será dividido em etapas, conforme a evolução do projeto.

**Versão 0.1 — Gerenciamento de clientes (em desenvolvimento)**

- [x] Modelagem da entidade Cliente
- [x] Estrutura inicial de armazenamento em memória
- [x] Métodos de armazenamento e consulta
- [x] Cadastro integrado ao menu, com verificação de ID vazio ou repetido
- [x] Listagem de clientes
- [x] Busca por identificador (ID)
- [x] Atualização de dados pelo ID
- [x] Exclusão de clientes pelo ID
- [x] Menu interativo no terminal, com opção de saída

### Funcionamento atual

Ao executar a classe `com.assistos.Mains`, o sistema abre o menu de clientes com as seguintes opções:

- `1`: Cadastrar cliente.
- `2`: Listar clientes.
- `3`: Excluir cliente pelo ID.
- `4`: Atualizar dados do cliente pelo ID.
- `5`: Buscar cliente pelo ID.
- `0`: Sair.

O cadastro reúne nome, CPF, telefone, email, RG e ID. Na atualização, é possível alterar os dados mantendo o mesmo ID. Campos deixados em branco preservam o valor atual, e o sistema informa quando o cliente não é encontrado.

Os dados são armazenados apenas em memória durante a execução. Ao encerrar o programa, os cadastros são perdidos.

### Melhorias pendentes nesta versão

- Aprimorar as validações de cadastro e aplicá-las também à atualização.
- Tratar entradas inválidas sem encerrar o programa.
- Ajustar a mensagem de exclusão para informar quando o ID não for encontrado.

**Funcionalidades futuras**

- Gerenciamento de equipamentos
- Ordens de serviço
- Orçamentos e aprovação de serviços
- Controle de estoque
- Autenticação e gerenciamento de usuários
- Relatórios e indicadores
- Interface web responsiva
- Persistência em banco de dados

## Arquitetura

O projeto utiliza uma organização por responsabilidades, separando:

- `model`: entidades e representação dos dados.
- `repository`: armazenamento e acesso aos dados.
- `service`: estrutura reservada para as regras de negócio, ainda sem implementação.
- `view`: interação com o usuário.

A estrutura será aprimorada conforme novas tecnologias forem incorporadas.

## Evolução do projeto

Este repositório é um projeto de longo prazo, desenvolvido de forma incremental.

Cada versão representa uma nova etapa de aprendizado e implementação, buscando manter o código organizado, compreensível e preparado para melhorias.

O histórico de commits documentará essa evolução.

## Autor

**João Paulo Ribas Padilha**

Estudante e desenvolvedor em formação, com foco em Java e desenvolvimento backend.

---

*O AssistOS ainda está no começo. A ideia é simples: aprender, construir, melhorar e repetir.*
