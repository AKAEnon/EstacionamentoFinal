package sos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        List<Vagas> listaVagas = new ArrayList<>();
        Estacionamento estacionamento = new Estacionamento(listaVagas);
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        while (executando) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar vaga");
            System.out.println("2 - Registrar entrada de veículo");
            System.out.println("3 - Registrar saída de veículo");
            System.out.println("4 - Gerar relatório de vagas ocupadas");
            System.out.println("5 - Ver histórico de veículo");
            System.out.println("6 - Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> {
                    System.out.print("Número da vaga: ");
                    int numero = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Tamanho da vaga (pequeno/médio/grande): ");
                    String tamanho = scanner.nextLine();
                    listaVagas.add(new Vagas(numero, tamanho, true));
                    System.out.println("Vaga cadastrada.");
                }
                case 2 -> {
                    System.out.print("Placa do veículo: ");
                    String placa = scanner.nextLine();
                    System.out.print("Modelo do veículo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Tamanho do veículo (pequeno/médio/grande): ");
                    String tamanho = scanner.nextLine();
                    System.out.print("Hora de entrada: ");
                    int horaEntrada = scanner.nextInt();
                    System.out.print("Minuto de entrada: ");
                    int minEntrada = scanner.nextInt();
                    Veiculo veiculo = new Veiculo(placa, modelo, tamanho, horaEntrada, minEntrada);
                    estacionamento.registrarEntradaVeiculo(veiculo);
                }
                case 3 -> {
                    System.out.print("Placa do veículo: ");
                    String placa = scanner.nextLine();
                    System.out.print("Hora de saída: ");
                    int horaSaida = scanner.nextInt();
                    System.out.print("Minuto de saída: ");
                    int minSaida = scanner.nextInt();
                    estacionamento.registrarSaidaVeiculo(placa, horaSaida, minSaida);
                }
                case 4 -> estacionamento.gerarRelatorioVagasOcupadas();
                case 5 -> {
                    System.out.print("Placa do veículo: ");
                    String placa = scanner.nextLine();
                    estacionamento.mostrarHistoricoVeiculo(placa);
                }
                case 6 -> executando = false;
                default -> System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }
}
