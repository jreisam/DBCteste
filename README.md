# DBC - Ticket: João Reis Jr
Projeto teste para a empresa Ticket: Persistir dados de "cidade" / "estado", considerando suas regras de negócios respectivas, disponibilizando insert em batch e apresentando uma single page no front end com comportamento também definido pela prova prática designada.
        
        Input:
            
        Processamento:
             
         Output:
            
        
Para Rodar em "localhost":            
1 - Certifique-se de primeiro ter instalado e configurado as tecnologias:
    Java, Maven, Maven-Wrapper 

2 - Modificar referências `https://dbcjreis-app.herokuapp.com/` para `http://localhost:8080/` em arquivo 
    `./webapp/frontend/mainPage.jsx`

2 - Rodar Dev: `mvn -N io.takari:maven:0.7.7:wrapper` e então `mvnw clean spring-boot:run`

3 - Rodar build: `mvn package` `java -jar {diretório target}\DBCjreis-0.0.1-SNAPSHOT.jar`

4 - para visualizar o banco: `http://localhost:8080/h2-console`, database: `jdbc:h2:mem:testedb` login `admin` senha `1234` 

5 - Swagger: `http://localhost:8080/swagger-ui.html#/`

Para verificação de build "up and running" online, url Heroku: `https://dbcjreis-app.herokuapp.com/`

Tecnologias usadas:
* ReactJSX / Bootstrap
* H2
* SpringBoot / Maven / JPA / Swagger / Lombok
* JUnit / Mockito 
 
 -----------------
 João Robson Reis Jr\
 Senior Developer
 
 09/03/2020