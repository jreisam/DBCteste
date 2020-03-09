# DBC Teste: João Reis Jr
projeto teste para DBC: carrega arquivo .xml, extrai seus campos e os persiste em banco H2. Por fim
        disponibiliza api REST para acesso aos dados.
        
1 - Certifique-se de primeiro ter instalado e configurado as tecnologias:
    Java, Maven, Maven-Wrapper.

2 - Rodar Dev: "`mvn -N io.takari:maven:0.7.7:wrapper` e então `mvnw clean spring-boot:run`. 

3 - Rodar build: "`mvn package`" "`java -jar .\DBCjreis\target\DBCjreis-0.0.1-SNAPSHOT.jar`.

4 - para visualizar o banco: `localhost:8080/h2-console`, login `admin` senha `1234`. 

5 - Swagger: `http://localhost:8888/swagger-ui.html#/`

6 - caso haja erro ao buildar, tente `yarn add webpack --dev` para atualizar o packager.

Tecnologias usadas:
* H2
* SpringBoot / JPA / Swagger
* ReactJSX
 
