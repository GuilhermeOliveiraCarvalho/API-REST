* Desafio de Projeto DIO: Criando uma API REST com spring boot e publicando na nuvem com railway

                            Bootcamp DIO: Spring Boot e Angular

  - Essa é uma RESTful API criada para um modelo de uma aplicação bancária
    

 ** Diagrama de Classes

```mermaid
classDiagram
    class User {
      +String name
      +Account account
      +Feature[] features
      +Card card
      +News[] news
    }

    class Account {
      +String number
      +String agency
      +Number balance
      +Number limit
    }

    class Feature {
      +String icon
      +String description
    }

    class Card {
      +String number
      +Number limit
    }

    class News {
      +String icon
      +String description
    }

    User "1" *--> "1" Account
    User "1" *--> "MANY" Feature
    User "1" *--> "1" Card
    User "1" *--> "MANY" News
