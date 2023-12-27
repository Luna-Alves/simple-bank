# Banco Simples

## Requisitos:

* Desenvolver um método principal (main) em uma classe diferente para testar o uso de algumas instâncias da classe Conta;
* Utilizando a classe Conta como classe base, escrever duas classes derivadas denominadas ContaPoupanca e ContaCorrente;
* Um objeto da classe ContaPoupanca, além dos atributos de um objeto da classe Conta, deve possuir um membro de dados referente 
  aos juros da aplicação e um método que adicione os rendimentos ao saldo da conta;
* Um objeto da classe ContaCorrente, além dos atributos de um objeto Conta, deve possuir uma variável que define o limite de cheque especial;
* Sobrescrever os métodos da classe Conta, conforme necessário em ambas as classes derivadas;
* Criar uma classe Banco, cujo objeto contém uma lista de objetos da classe Conta. As contas na lista podem ser instâncias da classe Conta, 
  da classe ContaPoupanca ou da classe ContaCorrente. Criar algumas contas de teste (algumas de cada tipo);
* Escrever um método de atualização na classe Banco. Ele deve percorrer cada conta, atualizando-as da seguinte forma: as contas poupanças      recebem juros adicionais (por meio do método que já foi desenvolvido) e exibem seu saldo atual; as contas correntes exibem seu saldo atual   e mensagem de aviso se estiverem em condição de cheque especial;
* A classe Banco requer métodos para abertura e fechamento de contas, assim como para o pagamento de boletos/títulos.
