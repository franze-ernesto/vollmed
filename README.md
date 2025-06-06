# Vollmed API – Gerenciamento de Clínica Médica com Spring Boot
API REST desenvolvida em Java com Spring Boot para gerenciamento de médicos, pacientes e agendamentos em uma clínica médica fictícia. O projeto simula um ambiente real de uma clínica com autenticação JWT, validações personalizadas e arquitetura baseada em DDD.

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

> Este projeto adota uma arquitetura orientada a DDD (Domain-Driven Design), priorizando a separação de responsabilidades entre as camadas, o encapsulamento das regras de negócio no domínio e a aplicação de boas práticas como autenticação via JWT e documentação com Swagger.

---

## 🔄 Funcionalidades previstas

- [x] Cadastro, edição, listagem e exclusão de médicos  
- [x] Cadastro, edição, listagem e exclusão de pacientes  
- [x] Agendamento e cancelamento de consultas médicas  
- [x] Integração com banco de dados MySQL via JPA/Hibernate  

---

## 🎨 Layout

O layout da aplicação mobile está disponível neste link:  
🔗 [Figma](https://www.figma.com/design/N4CgpJqsg7gjbKuDmra3EV/Voll.med?node-id=2-1007&p=f)

---

## 📄 Documentação e Planejamento

A documentação das funcionalidades da aplicação pode ser acessada neste link:  
🔗 [Trello](https://trello.com/b/O0lGCsKb/api-voll-med)

---

## 🧪 Testes

🔧 Em desenvolvimento:  
Testes unitários e de integração serão adicionados em breve.

---

## 🚀 Como executar o projeto
### 📦 Clonando o projeto e gerando o `.jar`

```bash
# Clone o repositório:
git clone https://github.com/franze-ernesto/vollmed.git

# Acesse o diretório:
cd vollmed

# Gere o .jar:
./mvnw clean package

```

🧪 Executando o .jar localmente
```
java -jar target/voll.med-0.0.1-SNAPSHOT.jar

```

🐳 Execução com Docker
📦 Construindo e executando localmente
# Crie a imagem Docker:
```
docker build -t voll.med.app .
```
# Execute o container:
```
docker run -p 8080:8080 voll.med.app
```
☁️ Executando via Docker Hub (sem necessidade de build local)
```
docker run -p 8080:8080 ernestofranze/vollmed-api:latest
```

## 💾 Configuração do Banco de Dados (MySQL)
```
yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/vollmed
    username: seu_usuario
    password: sua_senha
  jpa:
    hibernate:
      ddl-auto: update
  jackson:
    serialization:
      indent_output: true
```

## 📝 Licença

Projeto desenvolvido por **Anderson Ernesto**. Parte da estrutura inicial foi baseada em um curso da [Alura](http://alura.com.br), com evoluções que incluem:
```
- Separação de DTOs por entrada e saída

- Regras de negócio isoladas e validadas dinamicamente

- Arquitetura orientada a DDD (Domain-Driven Design)

- Segurança com Spring Security e autenticação via JWT

- Documentação via Swagger com Springdoc OpenAPI
```    


Este projeto é para fins educacionais.

---



