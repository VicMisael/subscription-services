# Microservicesascan
 Este projeto consiste em um serviço de inscrição com as funcionalidades de cadastro de usuários e subscriptions junto à possibilidade de editar essas subscriptions, sendo as mesmas logadas e persistidas em um banco noSQL
## Rodando a aplicação
Pré Requisitos:
* Java 11 JDK 
* Maven
* Docker
## Como rodar:
```console

mvn -f './subscriptionservice/pom.xml' -B -DskipTests=true clean package
docker-compose up

```