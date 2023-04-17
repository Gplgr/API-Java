# API

Implementação de uma API Rest simples com Spring Boot e que se comunica com um banco de dados MySql.

## Pré-requisitos
MySql 5+ (Usada a versão 8.0.32)

Distribuição Java 17+

Maven 3.X.X

## Instalação

Após inicializar o MySQL, crie o banco de Dados mysql

`create database produto`

Em /src/main/resources/application.yml altere usuário, senha e portas para se adequar a sua instalação MySql.

Em uma linha de comando, no diretório principal da API, execute os comandos

`mvn package`
`java -jar target/api-spring-1.0.0.jar`