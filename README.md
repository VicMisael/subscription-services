# Microservicesascan
![Java11](https://img.shields.io/badge/Java-11-orange)
![DockerCompose](https://img.shields.io/badge/-Docker%20Compose-blue)
![SQL](https://img.shields.io/badge/-Postgres-lightgrey)
![node](https://img.shields.io/badge/-NodeJS-green)
 
 Este projeto consiste em um serviço de inscrição com as funcionalidades de cadastro de usuários e registros de subscriptions junto à possibilidade de edição, sendo as mesmas logadas e persistidas no postgreSQL e em Banco NoSQL.

## Rodando a aplicação
Pré Requisitos:
* [Java 11 JDK](https://adoptium.net/download) 
* [Maven 3.8.6](https://maven.apache.org/install.html)
* [Docker](https://docs.docker.com/get-docker/)
## Como rodar:
```console
git clone https://github.com/VicMisael/Microservicesascan
cd Microservicesascan
mvn -f './subscriptionservice/pom.xml' -B -DskipTests=true clean package
docker-compose up

```