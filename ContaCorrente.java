/*
Desenvolva uma aplicação que:

1. Construa a classe ContaCorrente com  4 atributos privados: número conta, saldo, limite do especial, cliente.

2. Regras para a classe ContaCorrente:

    O saldo nunca poderá ser menor do que o valor do limite do especial.
    O limite do especial deverá ser um valor maior ou igual a zero.
*/

package ac1;

public class ContaCorrente {
         
    // Atributos
    private int numeroConta;
    private double saldo;
    private double limiteEspecial;
    private String nomeCliente;


    public double depositar (double valorDeposito) {
        saldo += valorDeposito;
        return saldo;
    }

    // TO STRING, GETTERS AND SETTER
    @Override
    public String toString() {
        return "ContaCorrente [limiteEspecial=" + limiteEspecial + ", nomeCliente=" + nomeCliente + ", numeroConta="
                + numeroConta + ", saldo=" + saldo + "]";
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getLimiteEspecial() {
        return limiteEspecial;
    }

    public void setLimiteEspecial(double limiteEspecial) {
        this.limiteEspecial = limiteEspecial;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
        

}