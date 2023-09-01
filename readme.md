#link da documentação da api:
http://localhost:8081/swagger-ui/index.html
#sistema estoque uma api que permite cdastrar, remover, atualizar e deletar produtos 
#tecnologias: 
#ecossistema spring com spring data, lombocke e model mapper e a dependência do swagger open api

#lógica de construção do projeto 
#utilizei um test profile, pois esse foi o principal objetivo desse módulo 
#usei uma classe de configuração para cadastrar dados no sistema sem ter que realizar comandos sql 

#usei uma configuração mapper utilizando um método que retorna um novo mapper. A intenção é facilitar a transferência do DTO para a classe de entidade e vice versa. Ou seja, não precisarei criar códigos para realizar a lógica do DTO para cada método. 
#usei uma arquitetura mais desacoplada, utilizando o service como interface e implementando os métodos na classe serviceImpl 
#testes: 
#testei a classe controller, service e as exceções.
#basicamente o teste em seu conceito é muito simples. Você verifica se os componentes (class, atributs) contém os mesmos valores passados na resposta e se os objetos existem. Em seguida vem o mockito que vai cuidar da comunicação entre as classes e também da injessão falsa de mock. Tem algumas variações, mas a ideia  principal é essa