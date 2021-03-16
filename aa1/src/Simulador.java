import java.io.Console;
import java.util.Scanner;

public class Simulador {
    private static Scanner teclado = new Scanner(System.in);
    private static Veiculo[] veiculos = new Veiculo[20];

    public static void main(String[] args) {
        menu();
    }

    public static void pausarExecucao() {
        Scanner pausar = new Scanner(System.in);
        String pausa = pausar.nextLine();
    }

    public static int solicitarID() {
        System.out.print("\nInforme o id do carro: ");
        int id = teclado.nextInt();

        return id;
    }

    public static void menu() {

        int opcao = 0;

        while (opcao != 11) {
            System.out.println("1) Incluir veículo");
            System.out.println("2) Remover veículo");
            System.out.println("3) Abastecer veículo");
            System.out.println("4) Movimentar veículo");
            System.out.println("5) Movimentar todos os veículos");
            System.out.println("6) Imprimir todos os dados de todos os veículos");
            System.out.println("7) Esvaziar pneu de veiculo");
            System.out.println("8) Calibrar pneu de veiculo");
            System.out.println("9) Calibrar todos os pneus dos veiculos");
            System.out.println("10) Imprimir pista");
            System.out.println("11) Sair");
            System.out.print("Opção: ");

            opcao = teclado.nextInt();

            switch (opcao) {
            case 1: {
                incluirVeiculo();
                break;
            }
            case 2: {
                excluirVeiculo();
                break;
            }
            case 3: {
                abastecerVeiculo();
                break;
            }
            case 4: {
                movimentarVeiculo();
                break;
            }
            case 5: {
                movimentarTodosVeiculos();
                break;
            }
            case 6: {
                imprimirDadosVeiculos();
                break;
            }
            case 7: {
                esvaziarPneuDeVeiculo();
                break;
            }
            case 8: {
                calibrarPneusDeVeiculo();
                break;
            }
            case 9: {
                calibrarTodosPneus();
                break;
            }
            case 10: {
                imprimirPista();
                break;
            }
            case 11: {
                System.exit(1);
                break;
            }
            default: {
                System.out.println("Opção inválida, tente novamente");
                pausarExecucao();
            }
            }

            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

    public static void incluirVeiculo() {
        int i;

        for (i = 0; i < veiculos.length; i++) {
            if (veiculos[i] == null) {
                veiculos[i] = new Veiculo();
                veiculos[i].iniciarVeiculo(i);
                i = veiculos.length;
                System.out.println("\nVeículo adicionado com sucesso");
            }
        }
        if (i < veiculos.length) {
            System.out.println("\nNão foi possível adicionar o veículo");
        }

        pausarExecucao();
    }

    public static void excluirVeiculo() {
        int id = solicitarID();

        if (veiculos[id] != null && id >= 0 && id < veiculos.length) {
            veiculos[id] = null;
            System.out.println("\nVeículo removido com sucesso");
        } else {
            System.out.println("\nNão foi possível remover o veículo");
        }
        pausarExecucao();
    }

    public static void abastecerVeiculo() {
        double quantidade = teclado.nextFloat();
        int id = solicitarID();
        if (veiculos[id] != null) {
            veiculos[id].abastecer(quantidade);
            System.out.println("\nVeículo abastecido com sucesso");
        } else {
            System.out.println("\nNão foi possível abastecer o veículo");
        }
        pausarExecucao();
    }

    public static void movimentarVeiculo() {
        int id = solicitarID();
        if (veiculos[id] != null && veiculos[id].movimentar()) {
            System.out.println("\nVeiculo movido com sucesso");
        } else {
            System.out.println("\nNão foi possível movimentar o veiculo");
        }
        pausarExecucao();
    }

    public static void movimentarTodosVeiculos() {
        for (Veiculo veiculo : veiculos) {
            if (veiculo != null) {
                veiculo.movimentar();
            }
        }
        System.out.println("\nVeículos movidos com sucesso");
        pausarExecucao();
    }

    public static void imprimirDadosVeiculos() {
        for (Veiculo veiculo : veiculos) {
            if (veiculo != null) {
                System.out.println(veiculo);
            }
        }
        pausarExecucao();
    }

    public static void esvaziarPneuDeVeiculo() {
        int id = solicitarID();
        if (veiculos[id] != null) {
            veiculos[id].esvaziarPneus();
            System.out.println("\nRodas esvaziadas com sucesso");
        } else {
            System.out.println("\nNão foi possível esvaziadar as rodas");
        }
        pausarExecucao();
    }

    public static void calibrarPneusDeVeiculo() {
        int id = solicitarID();
        if (veiculos[id] != null) {
            veiculos[id].calibrarPneus();
            System.out.println("\nPneus Calibradas com sucesso");
        } else {
            System.out.println("\nNão foi possível calibrar os pneus");
        }
        pausarExecucao();
    }

    public static void calibrarTodosPneus() {
        for (Veiculo veiculo : veiculos) {
            if (veiculo != null) {
                veiculo.calibrarPneus();
            }
        }
        System.out.println("\nPneus dos veiculos calibrados com sucesso");
        pausarExecucao();
    }

    public static void imprimirPista() {
        for (Veiculo veiculo : veiculos) {
            if (veiculo != null) {
                veiculo.desenhar();
            }
        }
        pausarExecucao();
    }
}
