Aplicação backend para Tickets de ingressos de um cinema, utiliza maven, banco de dados h2, java 17 e Apache Tomcat
  
Após abrir o projeto, coloque no cmd o comando mvn clean install, e depois mvn clean package, pega o arquivo que tiver esse nome, RedeCinemasApi-0.0.1-SNAPSHOT.war, e copia ele até a pasta onde você extraiu o tomcat, e cola ele dentro da pasta webapps, depois entra no arquivo dentro 
da pasta config do tomcat, chamado tomcat-users.xml, e coloca isso dentro dele :

  "<tomcat-users xmlns="http://tomcat.apache.org/xml"
              xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
              xsi:schemaLocation="http://tomcat.apache.org/xml tomcat-users.xsd"
              version="1.0">
    <role rolename="manager-gui"/>
    <role rolename="admin-gui"/>
    <user username="admin" password="admin" roles="manager-gui,admin-gui"/>
  </tomcat-users>"

O username e senha de quando você for entrar no http://localhost:8080/manager/, vão ser ambos admin.

Agora entra na pasta bin do tomcat e abre o arquivo startup.bat, se der certo vai abrir um cmd que vai se encher de codigos.

Agora entra no http://localhost:8080/manager/ e ve se a aplicação RedeCinemasApi-0.0.1-SNAPSHOT, ta iniciada, se tiver, então apenas significa que a API ta funcionando.

Locais: 

http://localhost:8080/RedeCinemasApi-0.0.1-SNAPSHOT/api/tickets
http://localhost:8080/RedeCinemasApi-0.0.1-SNAPSHOT/api/clientes

Para POST dentro do tickets:
deve se informar a quantidade de pessoas, e depois cadastrar os clientes, com nome idade e cpf (a quantidade de clientes deve ser igual a quantidade de pessoas informadas).
http://localhost:8080/RedeCinemasApi-0.0.1-SNAPSHOT/api/tickets
Ex do que deve ser colocado:
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

Para PUT dentro do tickets é a mesma coisa só que especificando uma chave em especifico no local: 
ex: http://localhost:8080/RedeCinemasApi-0.0.1-SNAPSHOT/api/tickets/1



POST de clients não são possiveis uma vez que é preciso ter um ticket novo para se ter um cliente novo.

Para PUT dentro de clientes, coloque a URL e a chave em especifico na frente, para mudar os campos
http://localhost:8080/RedeCinemasApi-0.0.1-SNAPSHOT/api/tickets/1

Ex do que deve ser colocado:

 {
      "nome": "Nome aleatorio",
      "idade": 43,
      "cpf": "111.111.111-11"
  }


Para ambos o DELETE e GET em especifico são iguais, só colocar a chave em especifico de qual você quer deletar na frente da URL:
http://localhost:8080/RedeCinemasApi-0.0.1-SNAPSHOT/api/tickets/1
http://localhost:8080/RedeCinemasApi-0.0.1-SNAPSHOT/api/clientes/1

    
