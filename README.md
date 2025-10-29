Trabalho final domodulo entrega 26-10-2025

Tecnologias usadas: Java 17 e Spring boot 3.5.7

Acesso ao banco de dados H2:
http://localhost:8009/h2-console

<img width="1898" height="770" alt="h2" src="https://github.com/user-attachments/assets/954f92e3-db04-47d6-b350-a91fc214a8ea" />

Acesso a documentação do swagger:
http://localhost:8009/swagger-ui/index.html#/

<img width="1882" height="941" alt="swagger" src="https://github.com/user-attachments/assets/e0939628-1f79-4e20-8e22-650075f130ab" />


Fluxo de execução da API pela coleção POSTMAN ou SWAGGER acionar os endpoint's:

1. Passo - Deve listar todos os clientes
   1.1 http://localhost:8009/clientes(Metodo Http: GET)
   

 <img width="1486" height="842" alt="image" src="https://github.com/user-attachments/assets/ec419691-5a31-424c-9082-70d83e856f73" />
 
 
2. Passo - Listar todos os produtos(Metodo Http: GET)
   2.1  http://localhost:8009/produtos

   
<img width="1497" height="918" alt="image" src="https://github.com/user-attachments/assets/5353cd4e-289a-4cab-be21-82c548d48f13" />


3. Passo - Criar pedido(Metodo Http: POST)
   3.1 http://localhost:8009/pedido
   

   <img width="1488" height="975" alt="image" src="https://github.com/user-attachments/assets/cde60a7d-a1c0-4929-bf3b-9a3f4832bb0d" />

5.  Passo - Buscar pedido por ID(Metodo Http: GET)
   4.1 http://localhost:8009/pedido/1

<img width="1477" height="958" alt="image" src="https://github.com/user-attachments/assets/b8977ed5-ab5b-48c9-91c6-06924a07306d" />

5.  Passo - Atualizar pedido por ID(Metodo Http: PUT)
   5.1 http://localhost:8009/pedido
    
<img width="1492" height="968" alt="image" src="https://github.com/user-attachments/assets/c364e0f1-065b-4e1e-a899-ab82a3120bd5" />

6.  Passo - Deletar pedido por ID(Metodo Http: DELETE)
   6.1 http://localhost:8009/pedido/1
   6.2 Buscar pedido deletado
   6.3 http://localhost:8009/pedido/1

7.  Passo - Contagme de pedido por ID(Metodo Http: GET)
   7.1 http://localhost:8009/produtos/contagem

<img width="1479" height="786" alt="image" src="https://github.com/user-attachments/assets/b248989a-d72f-4bc6-893b-6e3ce69b9204" />


   
