# DBC Teste: João Reis Jr
Projeto teste para DBC: Carregar arquivo .xml, extrair seus dados e os persistir em banco H2. Por fim,
        disponibilizar api REST para acesso aos mesmos.
        
        Input:
            Arquivo XML carregado através de uma single-page feita em uma única pagina ReactJSX devido 
            ao propósito simples de upload de arquivo, tendo seu conteúdo lido e analisado por endpoint
             com sua estrutura de modelos respectiva, levando em considerção a disposição dos dados para
             criação de seus relacionamentos.
        Processamento:
            Todos os dados do arquivo XML extraídos para objetos DTO, parsing e persistência ocorrendo através 
            de camadas organizadas. 
         Output:
            Banco em memória (H2) salvando todos os dados do arquivo XML e apresentando os dados de alguns
            campos (grupo "BcMsg") em lista na singe-page. Detalhes ou os dados completos, estão disponíveis
             em seu Swagger https://dbcjreis-app.herokuapp.com/swagger-ui.html. 
         Teste:
            Testes disponíveis para validação do arquivo XML e de modelo BcMsg.
Para Rodar em "localhost":            
1 - Certifique-se de primeiro ter instalado e configurado as tecnologias:
    Java, Maven, Maven-Wrapper 

2 - Modificar referências `https://dbcjreis-app.herokuapp.com/` para `http://localhost:8080/` em arquivo 
    `./webapp/frontend/mainPage.jsx`

2 - Rodar Dev: `mvn -N io.takari:maven:0.7.7:wrapper` e então `mvnw clean spring-boot:run`

3 - Rodar build: `mvn package` `java -jar {diretório target}\DBCjreis-0.0.1-SNAPSHOT.jar`

4 - para visualizar o banco: `http://localhost:8080/h2-console`, login `admin` senha `1234` 

5 - Swagger: `http://localhost:8080/swagger-ui.html#/`

6 - caso haja erro ao buildar, tente `yarn add webpack --dev` para atualizar o packager

Para verificação de build "up and running" online, url Heroku: `https://dbcjreis-app.herokuapp.com/`\

Tecnologias usadas:
* ReactJSX / Bootstrap
* H2
* SpringBoot / Maven / JPA / Swagger
* JUnit / Mockito 
 
 -----------------
 João Robson Reis Jr\
 Senior Developer
 
 09/03/2020