import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Banco {
    private List<Conta> contas;

    public Banco() {
        this.contas = new ArrayList<>();
    }

    public void abrirConta(Conta novaConta) {
        contas.add(novaConta);
        System.out.println("Conta aberta com sucesso!");
    }

    public void fecharConta(int numeroConta) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                contas.remove(conta);
                System.out.println("Conta fechada com sucesso!");
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    public void pagarBoleto(int numeroConta, double valor) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta() == numeroConta) {
                if (conta.getSaldo() >= valor) {
                    conta.saque(valor);
                    System.out.println("Boleto pago com sucesso!");
                } else {
                    System.out.println("Saldo insuficiente para pagar o boleto.");
                }
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }

    public void atualizarContas() {
        for (Conta conta : contas) {
            System.out.println("Atualizando conta: " + conta.getNumeroConta());

            if (conta instanceof ContaPoupanca) {
                ContaPoupanca contaPoupanca = (ContaPoupanca) conta;
                contaPoupanca.atualizaConta();
                System.out.println("Saldo atual: R$" + String.format("%.2f", contaPoupanca.getSaldo()));
            } else if (conta instanceof ContaCorrente) {
                ContaCorrente contaCorrente = (ContaCorrente) conta;
                System.out.println("Saldo atual: R$" + String.format("%.2f", contaCorrente.getSaldo()));

                if (contaCorrente.getSaldo() < 0) {
                    System.out.println("Atenção: Conta em condição de cheque especial!");
                }
            } else {
                System.out.println("Saldo atual: R$" + String.format("%.2f", conta.getSaldo()));
            }

            System.out.println();
        }
    }

    public ContaPoupanca criarContaPoupanca(Scanner scanner) {
        System.out.print("Número da conta poupança: ");
        int numero = scanner.nextInt();
        System.out.print("Saldo inicial: ");
        double saldo = scanner.nextDouble();
        System.out.print("Taxa de juros: ");
        double taxaJuros = scanner.nextDouble();

        ContaPoupanca novaConta = new ContaPoupanca(numero, saldo, taxaJuros);
        abrirConta(novaConta);
        return novaConta;
    }

    public ContaCorrente criarContaCorrente(Scanner scanner) {
        System.out.print("Número da conta corrente: ");
        int numero = scanner.nextInt();
        System.out.print("Saldo inicial: ");
        double saldo = scanner.nextDouble();
        System.out.print("Limite de cheque especial: ");
        double limiteChequeEspecial = scanner.nextDouble();

        ContaCorrente novaConta = new ContaCorrente(numero, saldo, limiteChequeEspecial);
        abrirConta(novaConta);
        return novaConta;
    }

    public void interacaoUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Criar uma conta poupança:");
        ContaPoupanca contaPoupanca = criarContaPoupanca(scanner);

        System.out.println("\nCriar uma conta corrente:");
        ContaCorrente contaCorrente = criarContaCorrente(scanner);

        realizarOperacoes(scanner, contaPoupanca);
        realizarOperacoes(scanner, contaCorrente);

        atualizarContas();

        System.out.print("\nDeseja imprimir todas as contas? (Digite 'S' para Sim): ");
        String imprimirContas = scanner.next();
        if (imprimirContas.equalsIgnoreCase("S")) {
            imprimirTodasAsContas();

            fecharConta(scanner);
            pagarBoleto(1, 100.0);
            atualizarContas();
            scanner.close();
        }
    }

    private void realizarOperacoes(Scanner scanner, Conta conta) {
        System.out.println("\nOperações para a conta " + conta.getNumeroConta() + ":");
        System.out.print("Depósito: ");
        double deposito = scanner.nextDouble();
        conta.deposito(deposito);

        System.out.print("Saque: ");
        double saque = scanner.nextDouble();
        conta.saque(saque);

        System.out.print("Pagar boleto: ");
        double valorBoleto = scanner.nextDouble();
        pagarBoleto(conta.getNumeroConta(), valorBoleto);
    }

    private void imprimirTodasAsContas() {
        System.out.println("\nInformações de todas as contas:");

        for (Conta conta : contas) {
            System.out.println(conta.toString());
        }
    }

    private void fecharConta(Scanner scanner) {
        System.out.print("\nDigite o número da conta que deseja fechar: ");
        int numeroConta = scanner.nextInt();
        fecharConta(numeroConta);
    }
}
