# RedeCinemasApi

Aplicação Back End para Tickets de ingressos de um cinema. Utiliza Maven, banco de dados H2, Java 17 e Apache Tomcat.

![Java](https://img.shields.io/badge/Java-17-blue)
![Maven](https://img.shields.io/badge/Maven-3.9.9-blue)
![Tomcat](https://img.shields.io/badge/Tomcat-10.1.39-yellow)

## Configuração do Projeto

1. **Instalação e Empacotamento**
   - Abra o projeto no seu IDE de preferência.
   - Execute os seguintes comandos no terminal:

     ```sh
     mvn clean install
     mvn clean package
     ```

   - Localize o arquivo gerado `RedeCinemasApi-0.0.1-SNAPSHOT.war`.

2. **Deploy no Apache Tomcat**
   - Copie o arquivo `RedeCinemasApi-0.0.1-SNAPSHOT.war` para a pasta `webapps` do Tomcat.

3. **Configuração do Tomcat**
   - Abra o arquivo `tomcat-users.xml` localizado na pasta `config` do Tomcat.
   - Adicione a seguinte configuração:

     ```xml
     <tomcat-users xmlns="http://tomcat.apache.org/xml"
                   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                   xsi:schemaLocation="http://tomcat.apache.org/xml tomcat-users.xsd"
                   version="1.0">
       <role rolename="manager-gui"/>
       <role rolename="admin-gui"/>
       <user username="admin" password="admin" roles="manager-gui,admin-gui"/>
     </tomcat-users>
     ```

   - O username e senha para acessar o gerenciador do Tomcat em `http://localhost:8080/manager/` serão ambos `admin`.

4. **Iniciar o Servidor**
   - Navegue até a pasta `bin` do Tomcat e execute o arquivo `startup.bat`.
   - Um terminal será aberto com logs do servidor.

5. **Verificação da Aplicação**
   - Acesse `http://localhost:8080/manager/` e verifique se a aplicação `RedeCinemasApi-0.0.1-SNAPSHOT` está iniciada.
   - Se estiver iniciada, a API está funcionando corretamente.

## Endpoints Disponíveis

### Tickets

#### Listar Tickets
- **GET** `http://localhost:8080/RedeCinemasApi-0.0.1-SNAPSHOT/api/tickets`

#### Criar Ticket
- **POST** `http://localhost:8080/RedeCinemasApi-0.0.1-SNAPSHOT/api/tickets`
- Exemplo de payload:

  ```json
  {
      "quantidadePessoas": 2,
      "clientes": [
          {
              "nome": "nomeAleatorio",
              "idade": 10,
              "cpf": "123.456.789-10"
          },
          {
              "nome": "nomeAleatorio2",
              "idade": 62,
              "cpf": "567.890.123-45"
          }
      ]
  }
  ```

#### Atualizar Ticket
- **PUT** `http://localhost:8080/RedeCinemasApi-0.0.1-SNAPSHOT/api/tickets/{id}`

#### Deletar Ticket
- **DELETE** `http://localhost:8080/RedeCinemasApi-0.0.1-SNAPSHOT/api/tickets/{id}`

### Clientes

#### Listar Clientes
- **GET** `http://localhost:8080/RedeCinemasApi-0.0.1-SNAPSHOT/api/clientes`

#### Atualizar Cliente (Entenda o {num} como {id})
- **PUT** `http://localhost:8080/RedeCinemasApi-0.0.1-SNAPSHOT/api/clientes/{num}`
- Exemplo de payload:

  ```json
  {
      "nome": "Nome aleatorio",
      "idade": 43,
      "cpf": "111.111.111-11"
  }
  ```

#### Deletar Cliente
- **DELETE** `http://localhost:8080/RedeCinemasApi-0.0.1-SNAPSHOT/api/clientes/{num}`

---

**Nota:** Não é possível criar clientes diretamente. Os clientes devem ser criados junto com um ticket novo.
