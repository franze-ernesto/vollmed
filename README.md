# Vollmed API
API REST desenvolvida em Java com Spring Boot para o gerenciamento de médicos e pacientes em uma clínica médica fictícia. O projeto utiliza boas práticas como DTOs, arquitetura em camadas, validações com Bean Validation e persistência de dados com JPA e MySQL.

## 🛠 Tecnologias utilizadas
- Java 21
- Spring Boot
- Spring Data JPA
- H2
- MySQL
- Lombok
- ModelMapper
- Jakarta Validation
- Maven
- Flyway  

## 📦 Estrutura de pacotes
```
br.com.casa.voll.med
├── config 
├── controller 
├── dto 
├── model 
├── enum 
├── repository 
├── service 
```

## 🔄 Funcionalidades previstas
- [x] Cadastro de médicos
- [x] Atualização de médicos
- [x] Exclusão lógica (soft delete)
- [x] Listagem paginada de médicos
- [x] Busca de médicos por ID
- [x] Validações de entrada (DTOs)
- [x] Integração com banco de dados MySQL

## 💾 Banco de Dados
Por padrão, o projeto utiliza o banco de dados **H2 em memória**.
### ▶️ Acesso ao H2
- Interface web: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb`
- Usuário: `sa`
- Senha: *(em branco)*

### 🔁 Usando MySQL
Caso prefira utilizar o MySQL, renomeie o arquivo `application-mysql.properties` para `application.properties` e atualize com suas credenciais:

properties
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

3. Configure o H2 ou MySQL

4. 📌 Observações

    O projeto está em desenvolvimento contínuo.

    As funcionalidades de pacientes ainda serão integradas.

---



