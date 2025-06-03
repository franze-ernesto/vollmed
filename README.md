# Vollmed API
API REST desenvolvida em Java com Spring Boot para o gerenciamento de médicos e pacientes em uma clínica médica fictícia. O projeto utiliza boas práticas como DTOs, arquitetura em camadas, validações com Bean Validation, persistência de dados com JPA e MySQL e Spring Security com JWT.

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

## 📦 Estrutura de pacotes
```
br.com.casa.voll.med
├── config 
├── controller 
├── dto
├── enums
├── exception 
├── model 
├── repository
├── security
├── service
├── user
```

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



