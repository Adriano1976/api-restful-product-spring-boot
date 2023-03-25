# Api Restful Product Control com Spring Boot

## Por que devo trabalhar com o Framework Spring Boot?

Existem várias razões pelas quais você deve aprender a trabalhar com o Spring Boot, um dos frameworks mais populares para o desenvolvimento de aplicativos Java:

* Produtividade: O Spring Boot permite que você crie aplicativos Java de maneira rápida e fácil, com configuração mínima. Isso significa que você pode se concentrar no desenvolvimento de recursos de negócios em vez de configuração de infraestrutura.

* Flexibilidade: O Spring Boot é altamente flexível e pode ser facilmente integrado com outras tecnologias Java, como o Spring Framework, Hibernate, JPA, entre outros. Além disso, o Spring Boot suporta diferentes bancos de dados e sistemas operacionais.

* Eficiência: O Spring Boot é altamente otimizado para desempenho e escalabilidade, permitindo que seus aplicativos sejam executados rapidamente e gerenciem grandes volumes de dados.

* Segurança: O Spring Boot inclui várias funcionalidades de segurança, como autenticação e autorização, que ajudam a proteger seus aplicativos contra ameaças externas.

* Comunidade: O Spring Boot é um framework de código aberto com uma grande comunidade de desenvolvedores ativos. Isso significa que você pode encontrar muitos recursos, tutoriais e exemplos disponíveis online para ajudá-lo a aprender e desenvolver aplicativos.

Em resumo, aprender a trabalhar com o Spring Boot pode ajudá-lo a desenvolver aplicativos Java com facilidade, flexibilidade, eficiência e segurança, permitindo que você se concentre no desenvolvimento de recursos de negócios em vez de configuração de infraestrutura. Além disso, a comunidade ativa do Spring Boot oferece suporte e recursos valiosos para ajudá-lo a se tornar um desenvolvedor mais habilidoso.

Portanto, primeiramente gostaria de agradecer a [Michelli Brito](https://github.com/MichelliBrito) pela sua dedicação em ensinar a programação em seu [Canal do YouTube Michelli Brito](https://www.youtube.com/c/MichelliBrito), pois tenho aprendido muito e adquirindo novos conhecimentos. E também gostaria de agradecer [Professor Gleyson Sampaio](https://www.youtube.com/@gleysonsampaio8689) que ministra algumas aulas na plataforma [Digital Innovation One](https://www.dio.me/)

## Api Restful Product Control com Spring Boot

Vejamos como exemplo esse projeto pelo qual foi idealizado e construido seguindo as instruções da apostila Spring Boot Da API REST aos Microservices – 3ª Edição criada por [Michelli Brito](https://github.com/MichelliBrito). Depois disso, resolvir complementar o projeto com mais algumas funcionalidade como na parte da segurança reforçado com Token e outras mais de forma a colocar em prática alguns conhecimentos adquiridos em apostilas e vídeos aulas. O objetivo desse trabalho era criar uma api de controle de produtos com os métodos de Inserção, Visualização, Alteração e Remoção de dados sobre o produto. Nela são criadas algumas regras de construção de uma api seguindo o modelo arquitetural de Roy Fielding em sua tese de doutorado de 6 regras que devem ser obrigatoriamente seguidas para uma aplicação ser considerada RESTful.

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

## Por que aprender a trabalhar com Intellij IDE?

Existem várias razões pelas quais aprender a trabalhar com o IntelliJ IDEA pode ser benéfico para você como programador. Aqui estão algumas das principais:

* Produtividade: O IntelliJ IDEA é uma IDE altamente produtiva que permite que você escreva código mais rápido e com menos erros. Ele possui recursos avançados, como preenchimento automático de código, refatoração de código, depuração avançada e muito mais, que podem economizar muito tempo e aumentar a eficiência.

* Compatibilidade: O IntelliJ IDEA é compatível com muitas linguagens de programação diferentes, incluindo Java, Kotlin, Python, PHP, JavaScript e outros. Isso significa que você pode usar a mesma IDE para trabalhar em vários projetos, em vez de precisar mudar de IDE para cada linguagem de programação.

* Comunidade: O IntelliJ IDEA é um dos IDEs mais populares no mercado e tem uma grande comunidade de desenvolvedores ativos. Isso significa que há muitos recursos disponíveis online, como fóruns de discussão, blogs e tutoriais, que podem ajudá-lo a aprender e resolver problemas com a IDE.

* Integração: O IntelliJ IDEA pode ser integrado com muitas outras ferramentas de desenvolvimento, como sistemas de controle de versão, sistemas de construção, servidores de aplicativos e muito mais. Isso torna o fluxo de trabalho de desenvolvimento mais suave e eficiente.

* Personalização: O IntelliJ IDEA é altamente personalizável e pode ser configurado para atender às suas necessidades de desenvolvimento específicas. Você pode instalar plugins para adicionar novos recursos e ajustar as configurações para otimizar a IDE para o seu fluxo de trabalho.

Em resumo, aprender a trabalhar com o IntelliJ IDEA pode ajudá-lo a escrever código com mais rapidez e eficiência, permitir que você trabalhe em vários projetos e linguagens de programação, e integrar com outras ferramentas de desenvolvimento. Além disso, sua comunidade ativa e a capacidade de personalizar a IDE tornam o IntelliJ IDEA uma opção atraente para muitos programadores.

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
