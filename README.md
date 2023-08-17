# acme-store

Esse projeto está sendo desenvolvido para a disciplina de arquitetura e design de software do MBA Full Stack - UNIESP

* ## Contexto Domínio do Problema
* O projeto refere-se a um simulador de ecommerce, onde um cliente poderá realizar compras de produtos, utilizando a modalidade 
de compra com cartão de crédito. Nesse contexto, a compra será realizada pelo cliente informando os dados dos produtos adquiridos
assim como os dados do cartão de crédito utilizado na compra.

### Processo de Compra
* Ao realizar um pedido, o cliente receberá a informação de compra em processamento, o sistema executará fase para avlidar a compra:
1 - O sistema irá realizar uma verificação dos dados do cliente
2 - O sistema irá realizar uma verificação dos dados do cartão do cliente, em um serviço apartado, que retornará a validade ou não 
dos dados do cartão do cliente.
3 - Em caso afirmativo para os porntos 1 ou 2 o sistema irá processar o pedido dando baixa no estoque dos produtos comprados, prepara 
as informações da compra, e envia a mensagem para o cliente informando que a sua compra foi realizada com sucesso.
4 - Em caso negativo para os pontos 1 ou 2, o sistema irá emitir uma mensagem para o cliente informando que a compra não pode ser realizada
pasando para o cliente a melhor mensagem possível à deponder do caso que invalidou a compra que pode ser os seguintes motivos:
* Falta de limite no cartão - Mensagem fria
* Restrição do cartão por falta de pagamento (fatura) - Mensagem morna
* Restrição do cartão por motivos de fraude - Mensagem quente.
Em todos os casos apresentados acima, haverá um registro/notificação desse processo em uma base de dados de suporte a fraude.
