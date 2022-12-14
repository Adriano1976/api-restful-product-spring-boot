# Api Restful Product Control com Spring Boot

Primeiramente gostaria de agradecer a [Michelli Brito](https://github.com/MichelliBrito) pela sua dedicação em ensinar a programação em seu [Canal do YouTube Michelli Brito](https://www.youtube.com/c/MichelliBrito), pois tenho aprendido muito e adquirindo novos conhecimentos. E também gostaria de agradecer [Professor Gleyson Sampaio](https://www.youtube.com/@gleysonsampaio8689) que ministra algumas aulas na plataforma [Digital Innovation One](https://www.dio.me/)

Esse projeto foi idealizado e construido seguindo as instruções da apostila Spring Boot Da API REST aos Microservices – 3ª Edição criada por [Michelli Brito](https://github.com/MichelliBrito). Depois disso, resolvir complementar o projeto com mais algumas funcionalidade como na parte da segurança reforçado com Token e outras mais de forma a colocar em prática alguns conhecimentos adquiridos em apostilas e vídeos aulas. O objetivo desse trabalho era criar uma api de controle de produtos com os métodos de Inserção, Visualização, Alteração e Remoção de dados sobre o produto. Nela são criadas algumas regras de construção de uma api seguindo o modelo arquitetural de Roy Fielding em sua tese de doutorado de 6 regras que devem ser obrigatoriamente seguidas para uma aplicação ser considerada RESTful.

* A primeira regra diz que uma aplicação, neste caso uma API, deve ser cliente/servidor a fim de separar as responsabilidades.
* A segunda regra diz que essa aplicação não guardar estado no servidor, para que cada requisição que o cliente envia ao servidor tenha informações relevantes e únicas para a resposta, assim independe qual servidor irá responder esse cliente caso a aplicação esteja escalada em múltiplos servidores, garantindo escalabilidade e disponibilidade.
* A terceira regra define que a aplicação deve ter a capacidade de realizar cache para reduzir o tráfego de dados entre cliente e servidor. 
* A quarta regra diz que a aplicação deve ter uma interface uniforme, onde sua modelagem deve conter recursos bem definidos, apresentar hipermídias, utilizar corretamente os métodos HTTP e códigos de retorno.
* A quinta regra diz que o sistema deve ser construído em camadas, ou seja, a possibilidade de escalar a aplicação em múltiplos servidores.
* A última regra diz que a aplicação deve ter a capacidade de evoluir sem a quebra da mesma, ou seja, código sob demanda.

## Modelo Maturidade Richardson

Leonard Richardson propôs um modelo de maturidade composto por quatro níveis e a API que alcançar esses quatro níveis pode sim ser considerada uma API RESTful.

* API no nível 0 - Quando utiliza o protocolo HTTP apenas como mecanismo de comunicação e não como semântica de seus verbos.
* API no nível 1 - Ela utiliza os recursos de maneira correta, definindo bem e de forma única cada recurso e utilizando os substantivos para representar os objetos.
* API no nível 2 - Utiliza o protocolo HTTP de forma semântica com seus métodos e também define os tipos de retorno para cada resposta possível de uma requisição. 
* API no nível 3 - possui as HATEOAS que são as hipermídias que mostram o seu estado atual e seu relacionamento com os elementos ou estados futuros, ou seja, a capacidade de um documento se relacionar com os demais.

## Criando uma API REST com Spring Boot

* Criando conexão com banco de dados
* Criando o Model e o Repository
* Criando o Controller
* Implementando os métodos GET ALL e GET ONE
* Implementando os métodos POST, DELETE e PUT
* Inserindo as HATEOAS

# Tecnologias utilizadas
- Intellij Ide
- Java 17
- Spring Boot
- Spring Web
- Spring Devtools
- Spring Security / jwt
- JPA / Hibernate
- H2
- Postgresql
- Webjars / Bootstrap / Webjars-locator
- Swagger-ui / Suagger2
- Maven

# Como executar o projeto

## Back end
Pré-requisitos: Java 17

```bash
# Clonar repositório
git clone https://github.com/Adriano1976/api-restful-product-spring-boot.git

# Entrar na pasta do projeto gestao-festa
cd backend

# Executar o Projeto
./mvnw spring-boot:run
```

# Front End com Swagger

Depois de executar o projeto via terminal ou via IDE, você poderá fazer os testes com os recursos disponibilizados pelo Swagger de acordo com o projeto atual.

![Spring Boot REST API - Lista de Produtos e Usuários](https://user-images.githubusercontent.com/17755195/199840504-b9cf4851-a675-431f-aede-b4c76dfb45e8.png)

* http://localhost:8080/swagger-ui.html

# Salvando um usuário

Para incluir um usuário vamos executar um POST: http://localhost:8080/users passando o json no body, conforme conteúdo abaixo:

```bash
http://localhost:8080/users

{
  "id": 0,
  "name": "ADRIANO SANTOS",
  "password": "jwt123",
  "roles": [
    "USERS"
  ],
  "username": "adrianosantos"
}
```

# Gerando o token

Com o nosso usuário devidamente inserido na base de dados, é hora de gerar o token com base nos dados passados pelo Login de acesso.
Execute a aplicação para testar o login nesse endereço POST: http://localhost:8080/login conforme instrução abaixo:

```bash
{ "username":"adrianosantos", "password":"jwt123"}
```

# Testando o Token Gerado

```bash
https://jwt.io/
```

# Autor do Projeto

Adriano Santos

https://www.linkedin.com/in/adrianosantos-dev/
