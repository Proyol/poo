import java.util.Scanner;

public class Simulador {
    // array de veículos com o total de 20 veiculos
    private static Veiculo[] veiculos = new Veiculo[20];

    public static void main(String[] args) {
        menu();
    }

    // função para pausar a execução da aplicação
    // usada para o usuário poder ler o que tem em tela antes de prosseguir com a
    // continuação do programa
    public static void pausarExecucao() {
        Scanner pausar = new Scanner(System.in);
        pausar.nextLine();
    }

    // função para solicitar o id do veiculo dentro do array
    public static int solicitarID() {
        System.out.print("\nInforme o id do veiculo: ");

        Scanner teclado = new Scanner(System.in);
        int id = teclado.nextInt(); // usuário informa o id

        // retornar o id digitado pelo usuário
        return id;
    }

    // função para mostrar o menu de opções do simulador para o usuário
    public static void menu() {
        int opcao = 0;

        // mostrar o menu enquanto o usuário não informar o opção de sair
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

            // ler a opção do menu
            Scanner teclado = new Scanner(System.in);
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
                calibrarTodasPneusDeTodosVeiculos();
                break;
            }
            case 10: {
                imprimirPista();
                break;
            }
            case 11: {
                sair();
                break;
            }
            default: {
                System.out.println("Opção inválida, tente novamente");
            }
            }

            pausarExecucao();

            // limpar a tela toda vez que o menu é mostrado novamente
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
    }

    public static void incluirVeiculo() {
        int i;

        // incluir veiculos no array
        for (i = 0; i < veiculos.length; i++) {

            // incluir o veiculo caso haja posição disponível
            if (veiculos[i] == null) {
                veiculos[i] = new Veiculo(i);
                veiculos[i].iniciarVeiculo();

                // forçar saida do for
                i = veiculos.length;

                // mostrar mensagem de sucesso para o usuário
                System.out.println("\nVeículo adicionado com sucesso");
            }
        }

        // caso não for encontrado posição disponível, ou seja, i nunca é igual a
        // veiculos.length, avisar o usuário que não possível a inserção do veículo
        if (i < veiculos.length) {
            System.out.println("\nNão foi possível adicionar o veículo");
        }
    }

    public static void excluirVeiculo() {
        // solicitar o id do veiculo a ser excluido pelo usuário
        int id = solicitarID();

        // verificar se o veiculo existe no array
        if (veiculos[id] != null && id >= 0 && id < veiculos.length) {

            // caso tenha encontrado
            veiculos[id] = null;
            System.out.println("\nVeículo removido com sucesso");
        } else {

            // caso NÃO tenha encontrado
            System.out.println("\nNão foi possível remover o veículo");
        }
    }

    public static void abastecerVeiculo() {
        // usuário deve informar a quantidade de combustível a abastecer
        Scanner teclado = new Scanner(System.in);
        double quantidade = teclado.nextFloat();
        teclado.close();

        // solicitar o id do veiculo a ser abastecido
        int id = solicitarID();
        if (veiculos[id] != null) {

            // caso o veiculo for encontrado
            veiculos[id].abastecer(quantidade);
            System.out.println("\nVeículo abastecido com sucesso");
        } else {

            // caso o veiculo NÃO for encontrado
            System.out.println("\nNão foi possível abastecer o veículo");
        }
    }

    public static void movimentarVeiculo() {
        // solicitar o id do veiculo que deve ser movido
        int id = solicitarID();

        // verificar se o veículo foi movimento e validar se sua movimentação foi bem
        // sucedida
        if (veiculos[id] != null && veiculos[id].movimentar()) {

            // veículo se movimentou com sucesso
            System.out.println("\nVeiculo movido com sucesso");
        } else {

            // veículo não conseguiu se movimentar
            System.out.println("\nNão foi possível movimentar o veiculo");
        }
    }

    public static void movimentarTodosVeiculos() {
        // percorrer todos os veículos e eventualmente movimenta-los
        for (Veiculo veiculo : veiculos) {
            if (veiculo != null) {
                veiculo.movimentar();
            }
        }

        System.out.println("\nVeiculos movimentados com sucesso");
    }

    public static void imprimirDadosVeiculos() {
        // percorrer todos os veículos e imprimir todos os seus dados
        for (Veiculo veiculo : veiculos) {
            if (veiculo != null) {
                System.out.println(veiculo);
            }
        }
    }

    public static void esvaziarPneuDeVeiculo() {
        Scanner teclado = new Scanner(System.in);
        int pneu;

        // solicitar o id do veículo a esvaziar os pneus
        int id = solicitarID();

        // verificar se o veículo existe
        if (veiculos[id] != null) {
            System.out.print("\nInforme a pneu a ser esvaziada: ");
            pneu = teclado.nextInt();

            // verificar se a pneu informada é válida
            if (pneu >= 0 && pneu < 4) {
                veiculos[id].esvaziarPneu(pneu);

                // pneu esvaziado com sucesso
                System.out.println("\nPneus esvaziadas com sucesso");
            } else {

                // NÃO foi possível esvaziar os pneus
                System.out.println("\nInforme um valor válido para as Pneus");
            }

        } else {

            // NÃO foi possível esvaziar os pneus
            System.out.println("\nNão foi possível esvaziadar as Pneus");
        }
    }

    public static void calibrarPneusDeVeiculo() {
        Scanner teclado = new Scanner(System.in);
        int pneu;

        // solicitar o id do veículo a calibrar os pneus
        int id = solicitarID();

        // verificar se o veículo existe
        if (veiculos[id] != null) {
            System.out.print("\nInforme a pneu a ser esvaziada: ");
            pneu = teclado.nextInt();

            if (pneu >= 0 && pneu < 4) {
                veiculos[id].esvaziarPneu(pneu);

                // Pneus calibrados com sucesso
                System.out.println("\nPneus calibradas com sucesso");
            } else {
                // NÃO foi possível esvaziar os pneus
                System.out.println("\nInforme um valor válido para as Pneus");
            }
        } else {

            // NÃO foi possível calibrar os pneus
            System.out.println("\nNão foi possível calibrar os pneus");
        }
    }

    public static void calibrarTodasPneusDeTodosVeiculos() {
        // percorrer todos os veículos e calibrar o pneu de cada um
        for (Veiculo veiculo : veiculos) {
            if (veiculo != null) {
                veiculo.calibrarTodasOsPneus();
            }
        }

        System.out.println("\nPneus calibradas com sucesso");
    }

    public static void imprimirPista() {
        // desenhar todos os veiculo dentro do array
        for (Veiculo veiculo : veiculos) {
            if (veiculo != null) {
                veiculo.desenhar();
            }
        }
    }

    public static void sair() {
        // sair da aplicação
        System.exit(1);
    }
}
