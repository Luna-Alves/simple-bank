public class ContaCorrente extends Conta {
    private double limiteChequeEspecial; 

    public ContaCorrente(int num, double novoSaldo, double limiteChequeEspecial) {
        super(num, novoSaldo); 
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public void saque(double valor) {
        double saldoComLimite = getSaldo() + limiteChequeEspecial;

        if (valor > 0 && valor <= saldoComLimite) {
            super.saque(valor);
        } else {
            System.err.println("ContaCorrente.saque(...): Valor de saque inválido!");
        }
    }

    @Override
    public void atualizaConta() {
        System.out.println("ContaCorrente atualizada.");
    }
}
