# safeway-teste-dev-jr

## AJUSTES REALIZADOS:
- Corrigindo os erros de funcionamento do código;
- Ajustando a hierarquia do código com a arquitetura DDD - Design Driven Domain;
- Encapsulamento da entidade de Venda(Service e dto);
- Encapsulmento da Entidade de Produto(Service e dto) e criação do metodo criar Produto;
- Encapsulmento da Entidade de Cliente(Service e dto) e criação do metodo criar Cliente;
- Testes unitários da entidade Cliente com Mockito;

## Erros Encontrados na Aplicação ##

- O valor do preço dos produtos estão sem a taxa da regra de negócio;
- No perfil de Usuário - Empresa não está totalizando o valor total das vendas e nem comissão;
- Falta acrescentar ao cliente finalizar a venda ele ver o resumo;
- Comissão por vendas ao listar as vendas feitas;
- Falta adicionar exceptions para possiveis erros como: "Cadastros de clientes, produtos ou empresa já existentes no sistema", "Usuário inválido" e outros mais;

## Observações ##

- O tempo esgotou, mas eu tinha que finalizar:
    - Cenários de testes;
    - Adicionar validações de nome, cpf, e alguns outros dados;
    - Filtros de vendas por nome,quantidade, valor e etc;
    - Adicionar templates com o Thymeleaf para ter uma melhor experiência do usuário;
