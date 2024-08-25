### Documentação da Api

Visão geral<br><br>

Esta Api permite realizar operações CRUD(Create, Read, Update, Delete) para gerenciar clientes de uma empresa.
<br><br>
Api é construída com o Spring Boot e se conecta a um Banco de Dados PostgreSQL.
<br><br>
Lembrando, de sempre inserir a porta, username e password no 'application.properties'.



 Comandos a serem executados no Postman | Função                                              |
:---------------------------------------|-----------------------------------------------------|
| GET /clientes                          | Lista todos os clientes                             |
| GET /clientes/{id}                     | Retorna detalhes de um cliente específico pelo UUID |
| POST /clientes                          | Cria um novo cliente                                |
| PUT /clientes/{id}                          | Atualiza um cliente existente pelo UUID             |
| DELETE /clientes/{id}                         | Exclui um cliente pelo UUID                         |


