# Escopo do Projeto: Aplicação To-Do List

## O que Vamos Fazer

Desenvolver uma aplicação web para gerenciamento de tarefas (To-Do List). A aplicação permitirá que os usuários criem, editem, removam e marquem tarefas como concluídas. Além disso, a aplicação deve ser responsiva, garantindo uma experiência de usuário consistente em dispositivos móveis e desktops.

## Escopo Funcional

### O que o sistema deve fazer:
- **Criar Tarefas**: Permitir que os usuários criem novas tarefas com título, descrição e prazo.
- **Editar Tarefas**: Permitir que os usuários editem as informações das tarefas existentes.
- **Excluir Tarefas**: Permitir que os usuários removam tarefas indesejadas.
- **Marcar como Concluída**: Permitir que os usuários marquem tarefas como concluídas ou pendentes.
- **Filtragem e Pesquisa**: Possibilitar a filtragem e pesquisa de tarefas com base em critérios como status e data de criação.
- **Autenticação de Usuários**: Implementar um sistema de login e registro para que cada usuário tenha sua própria lista de tarefas.

## Escopo Não Funcional

### Como o sistema deve desempenhar as funções:
- **Performance**: A aplicação deve carregar em menos de 2 segundos para qualquer ação do usuário.
- **Segurança**: Implementar criptografia para as credenciais dos usuários e proteger as listas de tarefas com autenticação.
- **Usabilidade**: Interface intuitiva com design simples e direto para fácil navegação e uso.
- **Responsividade**: A aplicação deve ser totalmente responsiva, funcionando bem em dispositivos móveis, tablets e desktops.
- **Escalabilidade**: Arquitetura preparada para suportar até 10.000 usuários simultâneos.
- **Manutenibilidade**: Código modular e bem documentado para facilitar futuras melhorias e manutenção.

## Objetivos SMART

- **S**: Específico - Lançar a versão inicial da aplicação To-Do List com funcionalidades básicas de gerenciamento de tarefas.
- **M**: Mensurável - Atingir 1.000 usuários registrados nos primeiros três meses após o lançamento.
- **A**: Atingível - Usar tecnologias e frameworks já dominados pela equipe, como [Nome do Framework/Tech Stack].
- **R**: Relevante - Facilitar o gerenciamento de tarefas diárias para melhorar a produtividade dos usuários.
- **T**: Temporal - Concluir o desenvolvimento da versão inicial dentro de 4 meses.

## Cronograma

### Diagrama de Gantt

```mermaid
gantt
    title Cronograma do Projeto To-Do List
    dateFormat  YYYY-MM-DD
    section Planejamento
    Definição de Requisitos       :done,  des1, 2024-09-01, 2024-09-07
    Design da Interface           :done,  des2, 2024-09-08, 2024-09-14
    section Desenvolvimento
    Desenvolvimento do Backend    :active, dev1, 2024-09-15, 2024-10-05
    Desenvolvimento do Frontend   : dev2, 2024-09-22, 2024-10-12
    Integração e Testes           : dev3, 2024-10-13, 2024-10-19
    section Lançamento
    Ajustes Finais                : 2024-10-20, 2024-10-26
    Lançamento da Aplicação       : milestone, 2024-10-27, 1d
```

- **Mês 1**: Planejamento e design da aplicação.
- **Mês 2**: Desenvolvimento das funcionalidades principais (CRUD de tarefas).
- **Mês 3**: Implementação de autenticação e testes.
- **Mês 4**: Testes finais, ajustes e lançamento.

### Diagrama de Fluxo
```mermaid
flowchart TD
    A[Usuário] --> B[Login]
    B --> C[Dashboard]
    C --> D[Visualizar Tarefas]
    C --> E[Criar Nova Tarefa]
    C --> F[Editar Tarefa]
    C --> G[Excluir Tarefa]
    D --> H[Filtrar Tarefas]
    D --> I[Marcar como Concluída]
    I --> D
```

### 2. Diagrama de Classe


```mermaid
classDiagram
    class Usuario {
        +String id
        +String nome
        +String email
        +String senha
        +login()
        +logout()
    }

    class Tarefa {
        +String id
        +String titulo
        +String descricao
        +Date dataCriacao
        +Date prazo
        +Boolean concluida
        +criar()
        +editar()
        +excluir()
        +marcarComoConcluida()
    }

    Usuario "1" -- "*" Tarefa : possui
```

### 3. Diagrama de Caso de Uso
```mermaid
    erDiagram
    Usuario {
        string id
        string nome
        string email
        string senha
    }

    Tarefa {
        string id
        string titulo
        string descricao
        date dataCriacao
        date prazo
        boolean concluida
    }

    Usuario ||--|{ Tarefa : possui
```
## Análise de Risco

- **Risco 1**: Atraso no desenvolvimento devido a mudanças de requisitos - Mitigação: Definição clara dos requisitos desde o início e comunicação constante com stakeholders.
- **Risco 2**: Problemas de desempenho em dispositivos móveis - Mitigação: Testes de usabilidade contínuos em diferentes dispositivos durante o desenvolvimento.
- **Risco 3**: Brechas de segurança na autenticação - Mitigação: Uso de boas práticas de segurança e testes de penetração.

## Recursos

- **Equipe**: Desenvolvedores, Designer UX/UI, Gerente de Projeto.
- **Ferramentas**: [Nome das Ferramentas - ex: Visual Studio Code, GitHub, etc.].
- **Orçamento**: Recursos alocados para servidores, licenças de software e testes de usuário.

## Resultado Esperado

Ao final do projeto, espera-se entregar uma aplicação To-Do List funcional e intuitiva, com todas as funcionalidades descritas no escopo funcional, oferecendo uma experiência de usuário satisfatória e segura. A aplicação deve estar pronta para ser lançada ao público dentro do prazo estabelecido e atender às expectativas dos usuários em termos de desempenho e usabilidade.