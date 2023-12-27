public abstract class Conta
{
    private int numero;    // Numero da conta
    private double saldo;  // Saldo atual da conta

    // Construtor da classe
    public Conta(int num , double novoSaldo) {    
      this.saldo = novoSaldo;
      this.numero = num;
    }

    // Efetua depósito de um determinado valor
    public void deposito(double valor) {
        if (valor > 0)
            this.saldo += valor;    
        else
            System.err.println("Não é possível depositar valor negativo!");    
    }

    // Efetua saque de um determinado valor
    public void saque(double valor) {
        if (valor > 0)
            this.saldo -= valor;    
        else
            System.err.println("Não é possível sacar valor negativo!");    
    }

    // Retorna o saldo da Conta
    public double getSaldo() {
      return this.saldo;
    }

    // Retorna o número da Conta
    public int getNumeroConta() {
      return this.numero;
    }
    public void setNumeroConta(int newNumero){
      this.numero = newNumero;
    }
    public void setSaldo(double newSaldo){
      this.saldo = newSaldo;
    }

    // Retorna String de informações da Conta
    public String toString() {
      return "Conta: " + this.numero + ": " + "Saldo = R$" + String.format("%.2f",this.saldo);    
    }

    // Exibe informações da Conta
    public final void print() {
        //Não sobrescreva este método,
        //sobrescreva o método toString()
        System.out.println( this.toString() );    
    }    

    public abstract void atualizaConta();
}