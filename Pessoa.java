package Java.Codigos_alura_java;

public class Pessoa {
    // Características da classe
    private String nome;
    private String tipo_de_conta;
    private float saldo = 2500.00f;

    // Construtor da classe
    public Pessoa(String nome, String tipo_de_conta, float saldo) {
        this.nome = nome;
        this.tipo_de_conta = tipo_de_conta; 
        this.saldo = saldo;
    }

    // Getters e Setters
    public String getNome() { return this.nome; }
    public String getTipo_de_conta() { return this.tipo_de_conta; }
    public float getSaldo() { return this.saldo; }

    public void setNome(String nome) { this.nome = nome; }
    public void setTipo_de_conta(String tipo_de_conta) { this.tipo_de_conta = tipo_de_conta; }
    public void setSaldo(float saldo) { this.saldo = saldo; }

    // Funções
    public void depositar(float valor) { 
        if (valor > 0) {
            this.setSaldo(this.getSaldo() + valor); 
        } else {
            System.out.println("[!] - Valor de depósito inválido. O valor deve ser maior que zero.");
        }
    }

    public void sacar(float valor) {
         if (valor > 0 && valor <= this.getSaldo()) {
            this.setSaldo(this.getSaldo() - valor); 
            System.out.println("[!] - Saque realizado com sucesso! Novo saldo: R$" + this.getSaldo());
        } else {
            System.out.println("[!] - Valor de saque inválido. O valor deve ser maior que zero e menor ou igual ao saldo atual.");
        }
    }

    public void consultarSaldo() { System.out.println("[!] - Saldo atual: R$" + this.getSaldo()); }
}
