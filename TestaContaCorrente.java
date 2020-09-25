/*
3. Crie uma classe chamada TesteContaCorrente com o método main.

4. Dentro do main construir um menu com as seguintes opções.

    -Cadastrar uma nova conta corrente. O número da conta deverá ser único. Todas as contas deverão ser armazenadas em uma lista.
    -Depositar. Nesta opção o usuário informa o número da conta e o valor do depósito. Se o número da conta existir, fazer o depósito. Se não existir, apresentar uma mensagem de erro.
    -Saque. Nesta opção o usuário faz um saque informando o número da conta e o valor do saque. Se o número da conta não existir, apresentar uma mensagem de erro, caso contrário fazer o saque respeitando o valor do saldo e o limite da conta.
    -Ver saldo. Informar o número da conta, e se existir, mostra o saldo. Caso o número da conta não exista, mostrar uma mensagem de erro.
    -Mostrar o somatório de todos os saldos dos clientes que não usaram o especial.
    -Sair.
*/

package ac1;

import java.util.Scanner;
import java.util.ArrayList;

public class TestaContaCorrente {

    public static ArrayList <ContaCorrente> contas = new ArrayList <ContaCorrente>(); //statico pro main ver
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        ContaCorrente cc;
        int continuar = 1;
        int i = 1;
        double verificarLimitePositivo;
        int numeroInformado;
        
        do{
            System.out.println("-----------NOBANK-----------");
            System.out.println("- Digite a opção desejada -");
            System.out.println(" 1 CADASTRAR CORRENTE CORRENTE ");
            System.out.println(" 2 DEPOSITAR ");
            System.out.println(" 3 SAQUE ");
            System.out.println(" 4 VER SALDO ");
            System.out.println(" 5 SOMA SALDOS POSITIVOS ");
            System.out.println(" 6 SAIR ");
            System.out.println("----------------------------");
            int opcao = Integer.parseInt(s.nextLine());
    
            
            switch(opcao){
                case 1:
                    System.out.println("----------------------------");
                    System.out.println(" 1 CADASTRAR CORRENTE CORRENTE ");
                    cc = new  ContaCorrente();                    
                    cc.setNumeroConta(i);
                    System.out.println("Digite seu nome: ");
                    cc.setNomeCliente(s.nextLine());
                    cc.setSaldo(0.0);
                    System.out.println("Digite o limite especial: ");
                    verificarLimitePositivo = Double.parseDouble(s.nextLine());
                    while (verificarLimitePositivo < 0) {
                        System.out.println("Limite deve ser maior ou igual a zero.");
                        System.out.println("Digite o limite especial: ");
                        verificarLimitePositivo = Double.parseDouble(s.nextLine());
                    }
                    cc.setLimiteEspecial(verificarLimitePositivo);
                    System.out.println("Voltar ao MENU? (1-Sim 2-Não)");
                    continuar = Integer.parseInt(s.nextLine());
                    i++;
                    contas.add(cc);
                    System.out.println("----------------------------");
                    break;

                case 2:
                    System.out.println("----------------------------");
                    System.out.println(" 2 DEPOSITAR ");
                    System.out.println("Informe o número da conta: ");
                    numeroInformado = Integer.parseInt(s.nextLine()); 
                    cc = pesquisaCC(numeroInformado);
                    if (cc != null ) {
                        System.out.println("Informe o valor para depósito: ");
                        cc.depositar(Double.parseDouble(s.nextLine()));
                        System.out.println("Saldo atual: " + cc.getSaldo());
                    } else {
                        System.out.println("Conta inválida");
                    }
                    System.out.println("Voltar ao MENU? (1-Sim 2-Não)");
                    continuar = Integer.parseInt(s.nextLine());
                    System.out.println("----------------------------");
                    break;

                case 3:
                    System.out.println("----------------------------");
                    System.out.println(" 3 SAQUE ");
                    System.out.println("Informe o número da conta: ");
                    numeroInformado = Integer.parseInt(s.nextLine()); 
                    cc = pesquisaCC(numeroInformado);
                    System.out.println("Informe o valor para saque: ");
                    double sacar = Double.parseDouble(s.nextLine());
                    if(cc != null){
                        if ((cc.getSaldo() - sacar) > ((cc.getLimiteEspecial())*-1)) {
                            double novoSaldo = cc.getSaldo() - sacar;
                            cc.setSaldo(novoSaldo);
                            System.out.println("Saldo atual: " + cc.getSaldo());
                        } else {
                            System.out.println("Você não tem limite suficiente");
                        }
                    } else {
                        System.out.println("Conta inválida");
                    }
                    System.out.println("Voltar ao MENU? (1-Sim 2-Não)");
                    continuar = Integer.parseInt(s.nextLine());
                    System.out.println("----------------------------");
                    break;
                    
                case 4:
                    System.out.println("----------------------------");
                    System.out.println(" 4 VER SALDO  ");
                    System.out.println("Informe o número da conta: ");
                    numeroInformado = Integer.parseInt(s.nextLine()); 
                    cc = pesquisaCC(numeroInformado);
                    if(cc != null){
                        System.out.println("Seu saldo é de R$" + cc.getSaldo());
                    } else {
                        System.out.println("Conta inválida");
                    }

                    System.out.println("Voltar ao MENU? (1-Sim 2-Não)");
                    continuar = Integer.parseInt(s.nextLine());
                    System.out.println("----------------------------");
                    break;

                case 5:
                    System.out.println("----------------------------");
                    System.out.println(" 5 SOMA SALDOS POSITIVOS ");
                    double somaSaldos =0;
                    for (ContaCorrente conta : contas) {
                        if (conta.getSaldo() > 0)
                        somaSaldos += conta.getSaldo();
                    }
                    System.out.println("A soma de saldos positivos é" + somaSaldos);
                    System.out.println("Voltar ao MENU? (1-Sim 2-Não)");
                    continuar = Integer.parseInt(s.nextLine());
                    System.out.println("----------------------------");
                    break;

                case 6:
                    System.out.println("----------------------------");
                    System.out.println("--OBRIGADA POR USAR NOBANK--");
                    System.out.println("----------------------------");
                    continuar = 2;
                    break;

                default:
                    System.out.println("OPÇÃO INVÁLIDA");
                    break;
            } // case

        } while (continuar == 1);

    }
    
    public static ContaCorrente pesquisaCC (int numeroConta) {
        //percorrer a lista, devolvendo o numero ou null
        
        for(int i = 0; i < contas.size(); i++){ 

            ContaCorrente aux = contas.get(i);
            if(numeroConta == aux.getNumeroConta()){
                return contas.get(i);
            }       
        }
        return null;

    }

}
