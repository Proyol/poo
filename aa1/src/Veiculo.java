import java.util.*;

public class Veiculo {
    private int id;
    private int n; // número de pneus
    private Roda[] rodas;
    private double combustivel;
    private double valor;
    private boolean ipvaPago;

    public Veiculo() {
        this.id = 0;
        this.n = 0;
        this.combustivel = 0;
        this.valor = 0;
        this.ipvaPago = false;
    }

    public int getId() {
        return this.id;
    }

    private void iniciarPneus() {
        int i;
        Random r = new Random();

        for (i = 0; i < n; i++) {
            this.rodas[i] = new Roda();
            int c = r.nextInt(100);

            if (c % 2 == 0) {
                this.rodas[i].setCalibragem(true);
            }
        }
    }

    public void iniciarVeiculo(int id) {
        this.id = id;

        this.combustivel = 3.5;
        this.valor = 20000;

        this.n = 4;
        this.rodas = new Roda[n];
        iniciarPneus();

        Random r = new Random();
        this.ipvaPago = r.nextInt(100) % 2 == 0 ? true : false;
    }

    public void abastecer(double quantidade) {
        this.combustivel += quantidade;
    }

    private boolean podeMover() {
        boolean rodasCalibradas = true;

        // verificar se todas as rodas estão calibrar
        for (Roda roda : this.rodas) {
            if (!roda.getCalibragem()) {
                rodasCalibradas = false;
            }
        }

        return this.combustivel - 0.55 >= 0 && this.ipvaPago && rodasCalibradas;
    }

    // a função retorna verdadeiro caso o movimento for bem sucedido
    public boolean movimentar() {
        if (podeMover()) {
            this.combustivel -= 0.55;
            return true;
        }

        return false;
    }

    public void esvaziarPneus() {
        for (Roda roda : rodas) {
            roda.setCalibragem(false);
        }
    }

    public void calibrarPneus() {
        for (Roda roda : rodas) {
            roda.setCalibragem(true);
        }
    }

    public void desenhar() {
        System.out.println("    ___  ");
        System.out.println(" __/ |_\\_");
        System.out.println("|  _ " + this.id + "  _‘‘-.");
        System.out.println("’-(_)---(_)--’\n");
    }

    public String toString() {
        String s = "\nid: " + this.id + "\n" + "Valor: " + this.valor + "\n" + "Combustível: " + this.combustivel
                + "\n";

        String ipvaEstaPago = this.ipvaPago ? "Pago\n" : "Não pago\n";
        s += "IPVA: " + ipvaEstaPago;

        int i;
        String rodasCalibradas = "Rodas Calibradas: ";
        for (i = 0; i < n; i++) {
            rodasCalibradas += this.rodas[i].getCalibragem() ? "1 " : "0 ";
        }
        s += rodasCalibradas;
        s += "\n";

        return s;
    }
}
