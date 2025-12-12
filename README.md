# 🖥️ Cadastro de Hardware API

API RESTful para gerenciamento de configurações de hardware (Setups) e seus respectivos benchmarks de desempenho.

## 📋 Sobre o Projeto

Sistema desenvolvido em Spring Boot para catalogar configurações completas de hardware (processador, placa de vídeo, memória RAM, placa-mãe, fonte) e registrar benchmarks de performance em diferentes jogos/softwares.

### Funcionalidades Principais

- ✅ CRUD completo de Setups (configurações de hardware)
- ✅ CRUD completo de Benchmarks (testes de desempenho)
- ✅ Relacionamento entre Setup e Benchmark (1:N)
- ✅ Documentação automática com Swagger/OpenAPI
- ✅ Validação de dados com Bean Validation
- ✅ Padrão DTO para transferência de dados
- ✅ Migrations com Flyway

---

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.8**
    - Spring Web (REST API)
    - Spring Data JPA (Persistência)
    - Spring Validation (Validação de dados)
- **H2 Database** (Banco em memória)
- **Flyway** (Versionamento de banco de dados)
- **Springdoc OpenAPI** (Documentação Swagger)
- **Lombok** (Redução de boilerplate)
- **Maven** (Gerenciamento de dependências)

---

## 🏗️ Arquitetura

### Estrutura de Camadas

```
Controller (API REST)
    ↓ recebe DTO
    ↓ usa Mapper para converter DTO → Entity
Service (Lógica de Negócio)
    ↓ trabalha com Entity
Repository (Acesso ao Banco)
    ↓ persiste Entity
Database (H2)
```

### Padrão DTO + Mapper

- **DTO (Data Transfer Object)**: Objeto usado para transferir dados entre cliente e servidor
- **Entity**: Objeto que representa uma tabela no banco de dados
- **Mapper**: Responsável por converter DTO ↔ Entity

---

## 📦 Modelo de Dados

### Setup (Configuração de Hardware)

```json
{
  "id": 1,
  "processor": "Intel Core i7-13700K",
  "videoCard": "NVIDIA RTX 4070",
  "motherboard": "ASUS ROG Strix Z790",
  "memory": "32GB DDR5 6000MHz",
  "price": 8500.00,
  "fonte": "Corsair RM850x 850W",
  "benchmarks": []
}
```

### Benchmark (Teste de Desempenho)

```json
{
  "id": 1,
  "softwareName": "Cyberpunk 2077",
  "fpsAvg": 85,
  "graphicsPreset": "Ultra",
  "resolution": "FULLHD_1080P",
  "setupId": 1
}
```

### Resoluções Disponíveis

- `HD_720P` → 1280x720
- `FULLHD_1080P` → 1920x1080
- `QUADHD_1440P` → 2560x1440
- `ULTRAHD_4K` → 3840x2160

---

## 🚀 Como Executar

### Pré-requisitos

- Java 21+
- Maven 3.8+

### Passos

1. **Clone o repositório**
```bash
git clone https://github.com/seu-usuario/cadastro-hardware.git
cd cadastro-hardware
```

2. **Configure as variáveis de ambiente**

Crie um arquivo `.env` ou configure as variáveis:

```properties
DATABASE_URL=jdbc:h2:file:./data/hardware
DATABASE_USERNAME=sa
DATABASE_PASSWORD=
```

3. **Execute a aplicação**

```bash
mvn spring-boot:run
```

4. **Acesse a aplicação**

- API: `http://localhost:8080`
- Swagger UI: `http://localhost:8080/swagger-ui/index.html`
- H2 Console: `http://localhost:8080/h2-console`

---

## 📚 Documentação da API

### Swagger UI

Após iniciar a aplicação, acesse a documentação interativa:

```
http://localhost:8080/swagger-ui/index.html
```

### Endpoints Disponíveis

#### 🖥️ Setups

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/setups` | Lista todos os setups |
| `GET` | `/setups/{id}` | Busca setup por ID |
| `POST` | `/setups` | Cria novo setup |
| `PUT` | `/setups/{id}` | Atualiza setup |
| `DELETE` | `/setups/{id}` | Deleta setup |

#### 📊 Benchmarks

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/benchs` | Lista todos os benchmarks |
| `GET` | `/benchs/{id}` | Busca benchmark por ID |
| `POST` | `/benchs` | Cria novo benchmark |
| `PUT` | `/benchs/{id}` | Atualiza benchmark |
| `DELETE` | `/benchs/{id}` | Deleta benchmark |

---

## 📝 Exemplos de Uso

### Criar um Setup

```bash
POST http://localhost:8080/setups
Content-Type: application/json

{
  "processor": "AMD Ryzen 9 7950X",
  "videoCard": "AMD Radeon RX 7900 XTX",
  "motherboard": "MSI MAG X670E",
  "memory": "64GB DDR5 6400MHz",
  "price": 12000.00,
  "fonte": "EVGA SuperNOVA 1000W"
}
```

### Criar um Benchmark

```bash
POST http://localhost:8080/benchs
Content-Type: application/json

{
  "softwareName": "Red Dead Redemption 2",
  "fpsAvg": 92,
  "graphicsPreset": "Ultra",
  "resolution": "QUADHD_1440P",
  "setupId": 1
}
```

### Buscar Setup com Benchmarks

```bash
GET http://localhost:8080/setups/1
```

Resposta:
```json
{
  "id": 1,
  "processor": "AMD Ryzen 9 7950X",
  "videoCard": "AMD Radeon RX 7900 XTX",
  "motherboard": "MSI MAG X670E",
  "memory": "64GB DDR5 6400MHz",
  "price": 12000.00,
  "fonte": "EVGA SuperNOVA 1000W",
  "benchmarks": [
    {
      "id": 1,
      "softwareName": "Red Dead Redemption 2",
      "fpsAvg": 92,
      "graphicsPreset": "Ultra",
      "resolution": "QUADHD_1440P"
    }
  ]
}
```

---

## 🗄️ Banco de Dados

### H2 Console

Acesse o console web do H2:

```
URL: http://localhost:8080/h2-console
JDBC URL: jdbc:h2:file:./data/hardware
Username: sa
Password: (deixe em branco)
```

### Migrations Flyway

As migrations estão em `src/main/resources/db/migrations`:

- `V1__init.sql` - Criação das tabelas iniciais
- `V2__add_column_fonte.sql` - Adiciona coluna "fonte" na tabela tb_setup

---



## 📁 Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── com/gabriel/CadastroDeHardware/
│   │       ├── Benchmark/
│   │       │   ├── BenchmarkController.java
│   │       │   ├── BenchmarkService.java
│   │       │   ├── BenchmarkRepository.java
│   │       │   ├── BenchmarkEntity.java
│   │       │   ├── BenchmarkDTO.java
│   │       │   ├── BenchmarkMapper.java
│   │       │   └── Resolution.java (enum)
│   │       ├── Setup/
│   │       │   ├── SetupController.java
│   │       │   ├── SetupService.java
│   │       │   ├── SetupRepository.java
│   │       │   ├── SetupEntity.java
│   │       │   ├── SetupDTO.java
│   │       │   └── SetupMapper.java
│   │       └── CadastroDeHardwareApplication.java
│   └── resources/
│       ├── application.properties
│       └── db/migrations/
│           ├── V1__init.sql
│           └── V2__add_column_fonte.sql
└── test/
    └── java/
        └── com/gabriel/CadastroDeHardware/
            └── CadastroDeHardwareApplicationTests.java
```

---

## 🔧 Configuração

### application.properties

```properties
# Database H2
spring.datasource.url=${DATABASE_URL}
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=${DATABASE_USERNAME}
spring.datasource.password=${DATABASE_PASSWORD}

# H2 Console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console

# Hibernate
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Flyway
spring.flyway.enabled=true
spring.flyway.locations=classpath:db/migrations
spring.flyway.baseline-on-migrate=true
```

---

## 👨‍💻 Autor

**Gabriel**

- GitHub: https://github.com/gabrielborges-developer
- Email: gabrielborge.developer@gmail.com

---

## 🤝 Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para:

1. Fazer um fork do projeto
2. Criar uma branch para sua feature (`git checkout -b feature/MinhaFeature`)
3. Commit suas mudanças (`git commit -m 'Adiciona MinhaFeature'`)
4. Push para a branch (`git push origin feature/MinhaFeature`)
5. Abrir um Pull Request


---

⭐ Se este projeto te ajudou, considere dar uma estrela no GitHub!