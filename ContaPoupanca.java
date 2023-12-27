public class ContaPoupanca extends Conta {
    private double taxaJuros;

    public ContaPoupanca(int numero, double saldo, double taxaJuros) {
        super(numero, saldo);
        this.taxaJuros = taxaJuros;
    }

    @Override
    public void atualizaConta() {
        adicionarRendimentos();
    }

    private void adicionarRendimentos() {
        double rendimento = getSaldo() * taxaJuros / 100;
        deposito(rendimento);
        System.out.println("Juros adicionados à conta poupança. Novo saldo: R$" + String.format("%.2f", getSaldo()));
    }
}
