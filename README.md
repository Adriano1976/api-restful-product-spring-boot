# Api Restful Product Control com Spring Boot

Primeiramente gostaria de agradecer a [Michelli Brito](https://github.com/MichelliBrito) pela sua dedicação em ensinar a programação em seu [Canal do YouTube Michelli Brito](https://www.youtube.com/c/MichelliBrito), pois tenho aprendido muito e adquirindo novos conhecimentos.

Esse projeto foi idealizado e construido seguindo as instruções da apostila Spring Boot Da API REST aos Microservices – 3ª Edição criada por [Michelli Brito](https://github.com/MichelliBrito), pois tem como objetivo criar uma api de controle de produtos com os métodos de Inserção, Visualização, Alteração e Remoção de dados sobre o produto. Nela são criadas algumas regras de construção de uma api seguindo o modelo arquitetural de Roy Fielding em sua tese de doutorado de 6 regras que devem ser obrigatoriamente seguidas para uma aplicação ser considerada RESTful.

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
