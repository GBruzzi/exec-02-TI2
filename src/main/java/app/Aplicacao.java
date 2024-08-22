package app;

import java.util.List;
import java.util.Scanner;

import dao.TimeDAO;
import model.Time;

public class Aplicacao {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        TimeDAO timeDAO = new TimeDAO();
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("\n\n===== MENU =====");
            System.out.println("1 - Listar Times");
            System.out.println("2 - Inserir Time");
            System.out.println("3 - Excluir Time");
            System.out.println("4 - Atualizar Time");
            System.out.println("5 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    List<Time> times = timeDAO.getOrderByCodigo();
                    System.out.println("\n\n==== Times ====");
                    for (Time time : times) {
                        System.out.println(time.toString());
                    }
                    break;

                case 2:
                    System.out.print("Digite o código do time: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Digite o nome do time: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite o número de torcedores: ");
                    int torcida = scanner.nextInt();

                    System.out.print("Digite o número de títulos: ");
                    int titulos = scanner.nextInt();

                    Time novoTime = new Time(codigo, nome, torcida, titulos);
                    if (timeDAO.insert(novoTime)) {
                        System.out.println("Inserção com sucesso -> " + novoTime.toString());
                    } else {
                        System.out.println("Erro ao inserir o time.");
                    }
                    break;

                case 3:
                    System.out.print("Digite o código do time a ser excluído: ");
                    codigo = scanner.nextInt();

                    if (timeDAO.delete(codigo)) {
                        System.out.println("Time excluído com sucesso.");
                    } else {
                        System.out.println("Erro ao excluir o time.");
                    }
                    break;

                case 4:
                    System.out.print("Digite o código do time a ser atualizado: ");
                    codigo = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.print("Digite o novo nome do time: ");
                    nome = scanner.nextLine();

                    System.out.print("Digite o novo número de torcedores: ");
                    torcida = scanner.nextInt();

                    System.out.print("Digite o novo número de títulos: ");
                    titulos = scanner.nextInt();

                    Time timeAtualizado = new Time(codigo, nome, torcida, titulos);
                    if (timeDAO.update(timeAtualizado)) {
                        System.out.println("Atualização com sucesso -> " + timeAtualizado.toString());
                    } else {
                        System.out.println("Erro ao atualizar o time.");
                    }
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }

        scanner.close();
    }
}
