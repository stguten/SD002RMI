package application;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;

import interfaces.IConversor;
import model.Historico;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = 999;

        try {
            IConversor cambioService = (IConversor) Naming.lookup("//localhost/cambio");

            while (option != 0) {
                System.out.println("> Bem vindo ao sistema de cambio rapido.");
                System.out.println("> Escolha uma opção abaixo.");
                System.out.println("> 1 - Converter moedas.");
                System.out.println("> 2 - Acessar o historico de cambio do usuario.");
                System.out.print("> ");
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        System.out.println("~> Digite seu nome: ");
                        String nome = scanner.next();

                        System.out.println("~> Digite o valor para ser convertido: ");
                        double valorInicial = scanner.nextDouble();

                        System.out.println("~> Digite a moeda para a qual deseja converter(EUR, BRL ou USD): ");
                        String moedaFinal = scanner.next().toUpperCase();

                        double valorFinal = cambioService.conversorMoedas(nome, valorInicial, moedaFinal);

                        System.out.println("O valor convertido ficou em " + valorFinal + " " + moedaFinal);
                        System.out.println();

                        System.out.println("Deseja continuar? 1 - Sim, 0 - Não");
                        option = scanner.nextInt();
                        break;
                    case 2:
                        System.out.println("Insira o nome do usuario para buscar: ");
                        String nomeHistorico = scanner.next();

                        List<Historico> historicoPessoal = cambioService.getHistoricoConversao(nomeHistorico);

                        System.out.println("Seu historico de conversão:");
                        System.out.println("----------------------");                        
                        for (Historico cambio : historicoPessoal) {
                            System.out.println("Usuário: " + cambio.getUsuario());
                            System.out.println("Moeda Inicial: " + cambio.getMoedaInicial());
                            System.out.println("Valor Inicial: " + cambio.getValorInicial());
                            System.out.println("Moeda Final: " + cambio.getMoedaFinal());
                            System.out.println("Valor Final: " + cambio.getValorFinal());
                            System.out.println("----------------------");
                        }

                        System.out.println();
                        System.out.println("Deseja continuar? 1 - Sim, 0 - Não");
                        option = scanner.nextInt();
                        break;
                }
            }
            scanner.close();

        } catch (MalformedURLException | RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
