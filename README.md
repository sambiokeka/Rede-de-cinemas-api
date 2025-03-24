# RedeCinemasApi

Aplicação backend para Tickets de ingressos de um cinema. Utiliza Maven, banco de dados H2, Java 17 e Apache Tomcat.

![Java](https://img.shields.io/badge/Java-17-blue)
![Maven](https://img.shields.io/badge/Maven-3.6.3-blue)
![Tomcat](https://img.shields.io/badge/Tomcat-9.0.52-yellow)

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
   - Se estiver iniciada, a API está funcionando corretamente ▋
