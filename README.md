# Vollmed API
API REST desenvolvida em Java com Spring Boot para o gerenciamento de médicos, pacientes e agendamento de consutas em uma clínica médica fictícia.

## 🛠 Tecnologias utilizadas
- Java 21
- Spring Boot
- JPA/Hibernate
- MySQL
- Flyway  
- Lombok
- ModelMapper
- Jakarta Validation
- Maven
- Spring Security (com OAuth 2.0 / JWT para autenticação)
- Springdoc OpenAPI (Swagger) para documentação automática da API

## 🧱 Arquitetura e Organização de Pacotes
```
src/main/java/br/com/casa/vollmed
├── application
│   ├── exception              
│   └── service                
│
├── domain
│   ├── model                  
│   ├── repository             
│   └── service
│       └── validation        
│
├── infrastructure
│   └── security              
│
├── interfaces
│   └── web
│       ├── controller       
│       └── dto
│           ├── input          
│           └── output         
│
└── config                     

```
>Este projeto adota uma arquitetura orientada a DDD (Domain-Driven Design), priorizando a separação de responsabilidades entre as camadas, o encapsulamento das regras de negócio no domínio e a aplicação de boas práticas como autenticação via JWT e documentação com Swagger.

## 🔄 Funcionalidades previstas
- [x] CRUD de médicos
- [x] CRUD de pacientes
- [x] Agendamento e consulta de Consultas Médicas
- [x] Integração com banco de dados MySQL

## 🎨 Layout
> O layout da aplicação mobile está disponível neste link: [Figma](https://www.figma.com/design/N4CgpJqsg7gjbKuDmra3EV/Voll.med?node-id=2-1007&p=f)


## 📄 Documentação
> A documentação das funcionalidades da aplicação pode ser acessada neste link: [Trello](https://trello.com/b/O0lGCsKb/api-voll-med)


## 💾 Banco de Dados
### 🔁 Usando MySQL

- spring.datasource.url=jdbc:mysql://localhost:3306/vollmed
- spring.datasource.username=seu_usuario
- spring.datasource.password=sua_senha
- spring.jpa.hibernate.ddl-auto=update

## 🧪 Testes
> Em desenvolvimento – serão adicionados testes unitários e de integração futuramente.

## 🚀 Como executar o projeto
1. Clone o repositório:
git clone https://github.com/franze-ernesto/vollmed.git

2. cd vollmed

3. Configure o MySQL

4. 📌 Observações

    O projeto está em desenvolvimento contínuo.   

## 📝 Licença
Projeto desenvolvido por Anderson Ernesto. Parte da estrutura inicial foi baseada em um curso da [Alura](http://alura.com.br). Este projeto evoluiu com a inclusão de DTOs, validações personalizadas, arquitetura em camadas, segurança e documentação.


---



