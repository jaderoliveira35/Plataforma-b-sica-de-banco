import java.util.Scanner;

import Java.Codigos_alura_java.Pessoa;

public class Desafio {

    // Métodos
    public static void p(String msg) { System.out.printf(msg); }

    public static String lerTexto(Scanner scanner, String mensagem) {
        p(mensagem);
        return scanner.nextLine();
    }

    public static void main(String[] args) {

        Scanner prompt = new Scanner(System.in);

        byte opcao;
        Pessoa pessoa = null;
        
        do {
            p("\n========================================\n"
                    + "Olá, seja bem-vindo ao desafio do Alura!\n"
                    + "========================================\n"
                    + "[1] Criar uma conta\n"
                    + "[2] Consultar saldo\n"
                    + "[3] Depositar\n"
                    + "[4] Sacar\n"
                    + "[5] Sair\n"
                    + "========================================\n");

            p("[E] - Escolha uma opção: ");
            opcao = prompt.nextByte();
            prompt.nextLine();

            switch (opcao) {
                case 1:
                    // Criar conta
                    p("[!] - Opção 1 selecionada: Criar uma conta\n");
                    String nome = lerTexto(prompt, "Digite o nome do titular da conta: ");
                    String tipo_de_conta = lerTexto(prompt, "Digite o tipo de conta (corrente ou poupança): ");

                    do {
                        if (!tipo_de_conta.equalsIgnoreCase("corrente")
                                && !tipo_de_conta.equalsIgnoreCase("poupança")) {

                            p("[!] - Tipo de conta inválido. Digite 'corrente' ou 'poupança'.\n");
                            tipo_de_conta = lerTexto(prompt, "Digite o tipo de conta: ");
                        }
                    } while (!tipo_de_conta.equalsIgnoreCase("corrente") && !tipo_de_conta.equalsIgnoreCase("poupança"));

                    pessoa = new Pessoa(nome, tipo_de_conta, 2500.00f);

                    p("[!] - Conta criada com sucesso!\n");
                    p("[!] - Nome do titular: " + pessoa.getNome() + "\n");
                    p("[!] - Tipo de conta: " + pessoa.getTipo_de_conta() + "\n");
                    p("[!] - Saldo inicial: R$" + pessoa.getSaldo() + "\n");
                break;

                case 2:
                    // Consultar saldo
                    if (pessoa == null) {
                        p("[!] - Crie uma conta primeiro.\n");
                        break;
                    }
                    p("[!] - Opção 2 selecionada: Consultar saldo\n");
                    p("[!] - Saldo atual: R$" + pessoa.getSaldo() + "\n");    
                break; 

                case 3:
                    // Depositar
                    if (pessoa == null) {
                        p("[!] - Crie uma conta primeiro.\n");
                        break;
                    }
                    p("[!] - Opção 3 selecionada: Depositar\n");

                    p("[!] - Digite o valor a ser depositado: ");
                    float valor_deposito = prompt.nextFloat();
            
                    do {
                        if (valor_deposito <= 0) {
                            p("[!] - Valor de depósito inválido. O valor deve ser maior que zero.\n");
                            p("[!] - Digite o valor a ser depositado: ");
                            valor_deposito = prompt.nextFloat();
                        } else {
                            pessoa.depositar(valor_deposito);
                            p("[!] - Depósito realizado com sucesso! Novo saldo: R$" + pessoa.getSaldo() + "\n");
                        }
                    } while (valor_deposito <= 0); 
                break;

                case 4:
                    // Sacar
                    if (pessoa == null) {
                        p("[!] - Crie uma conta primeiro.\n");
                        break;
                    }
                    p("[!] - Opção 4 selecionada: Sacar\n");
                    p("[!] - Digite o valor a ser sacado: ");
                    float valor_saque = prompt.nextFloat();

                    do {
                        if (valor_saque <= 0 || valor_saque > pessoa.getSaldo()) {
                            p("[!] - Valor de saque inválido. O valor deve ser maior que zero e menor ou igual ao saldo atual.\n");
                            p("[!] - Digite o valor a ser sacado: ");
                            valor_saque = prompt.nextFloat();
                        } else {
                            pessoa.sacar(valor_saque);
                            p("[!] - Saque realizado com sucesso! Novo saldo: R$" + pessoa.getSaldo() + "\n");
                        }
                    } while (valor_saque <= 0 || valor_saque > pessoa.getSaldo());
                break;

                case 5:
                    p("Até logo!\n");
                    break;
                default:
                    p("[!] - Opção inválida. Tente novamente.\n");
            }
        } while (opcao != 5);
    }
}