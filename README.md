# sistemasefaz

Tecnologias da aplicação:
*  Eclipse IDE
*  Servidor Apache Tomcat v7.0
*  JRE 1.8.0_65
*  Banco de dados MySQL 
*  Camada de persistência Hibernate + JPA
*  Framework Java Server Faces

Pré-requisitos:
*  Possuir um banco de dados MySQL local, chamado: desafiosefazdb ->
 comando DDL: *CREATE DATABASE desafiosefazdb;*
*  Adicionar as credenciais de acesso ao SGBD no arquivo **src\META-INF\persistence.xml** dentro da propriedade **user** e **password**(caso não possua senha, deixar o value vazio).
*  Executar o arquivo **src/br/com/sistemasefaz/dao/PopulaBanco.java** para que o Hibernate se responsabilize pela estruturação das tabelas e seu povoamento.
*  Usar as credenciais de acesso: **admin/admin** para se logar no sistema.
*  Usar a URL **http://localhost:8080/sistemasefaz/login.xhtml** para iniciar a aplicação.
