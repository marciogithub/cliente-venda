Trabalho final domodulo entrega 26-10-2025

Acesso ao banco de dados H2:
http://localhost:8009/h2-console

<img width="1898" height="770" alt="h2" src="https://github.com/user-attachments/assets/954f92e3-db04-47d6-b350-a91fc214a8ea" />

Acesso a documentação do swagger:
http://localhost:8009/swagger-ui/index.html#/

<img width="1882" height="941" alt="swagger" src="https://github.com/user-attachments/assets/e0939628-1f79-4e20-8e22-650075f130ab" />


Fluxo de execução da API pela coleção POSTMAN ou SWAGGER acionar os endpoint's:

1. Passo - Deve listar todos os clientes
   1.1 http://localhost:8009/clientes(Metodo Http: GET)

   [
    {
        "id": 1,
        "nome": "Marcio Correia de Oliveira",
        "email": "marcio.c@gmail.com"
    },
    {
        "id": 2,
        "nome": "João Miguel Primo",
        "email": "jm@gmail.com"
    },
    {
        "id": 3,
        "nome": "Malvina Sousa Lima",
        "email": "malvina.sousa@gmail.com"
    }
]

2. Passo - Listar todos os produtos(Metodo Http: GET)
   2.1  http://localhost:8009/produtos

[
    {
        "id": 1,
        "descricao": "Televisão",
        "valor": 6000.00,
        "estoque": 10
    },
    {
        "id": 2,
        "descricao": "Computador",
        "valor": 3000.00,
        "estoque": 15
    },
    {
        "id": 3,
        "descricao": "Celular",
        "valor": 5000.00,
        "estoque": 20
    }
]

3. Passo - Criar pedido(Metodo Http: POST)
   3.1 http://localhost:8009/pedido
{
    "idCliente": 2,
     "itensPedidoVenda": 
     [ 
        {"idProduto": 1,
        "quantidade": 2
        },
        {"idProduto": 2,
        "quantidade": 2
        }
      ]
}

4.  Passo - Buscar pedido por ID(Metodo Http: GET)
   4.1 http://localhost:8009/pedido/1

   {
    "id": 1,
    "cliente": {
        "id": 2,
        "nome": "João Miguel Primo",
        "email": "jm@gmail.com"
    },
    "itemPedidos": [
        {
            "id": 1,
            "produto": {
                "id": 1,
                "descricao": "Televisão",
                "valor": 6000.00,
                "estoque": 8
            },
            "quantidade": 2
        },
        {
            "id": 2,
            "produto": {
                "id": 2,
                "descricao": "Computador",
                "valor": 3000.00,
                "estoque": 13
            },
            "quantidade": 2
        }
    ],
    "estadoPedido": "CRIADO",
    "valorTotal": 18000.00,
    "data": "2025-10-26T07:52:21.990793"
}

5.  Passo - Atualizar pedido por ID(Metodo Http: PUT)
   5.1 http://localhost:8009/pedido

   {
    "idPedido": 1,
     "itensPedidoVenda": 
     [ 
        {"idProduto": 1,
        "quantidade": 1
        },
        {"idProduto": 2,
        "quantidade": 1
        }
      ]
    
}

6.  Passo - Deletar pedido por ID(Metodo Http: DELETE)
   6.1 http://localhost:8009/pedido/1
   6.2 Buscar pedido deletado
   6.3 http://localhost:8009/pedido/1

   {
    "id": 1,
    "cliente": {
        "id": 2,
        "nome": "João Miguel Primo",
        "email": "jm@gmail.com"
    },
    "itemPedidos": [
        {
            "id": 1,
            "produto": {
                "id": 1,
                "descricao": "Televisão",
                "valor": 6000.00,
                "estoque": 8
            },
            "quantidade": 2
        },
        {
            "id": 2,
            "produto": {
                "id": 2,
                "descricao": "Computador",
                "valor": 3000.00,
                "estoque": 13
            },
            "quantidade": 2
        }
    ],
    "estadoPedido": "CANCELADO",
    "valorTotal": 18000.00,
    "data": "2025-10-26T07:52:21.990793"
}
