package base;

public class Cliente extends CalculadoraDeJurosComposta {

    public Cliente(double entrada, double plano) {
        super(entrada, plano);
    }

    public static void main(String[] args) {
        Cliente cliente = new Cliente(600, 30000);

        cliente.tela();
        cliente.depositar(100);
        cliente.tela();
        cliente.manter_valor(5);
        cliente.tela();
        cliente.sacar(900);
        cliente.tela();
        cliente.depositar(250);
        cliente.manter_valor(10);
        cliente.tela();
        cliente.manter_valor(15);
        cliente.tela();
        cliente.acumulo();
        cliente.manter_valor(15);
        cliente.tela();
        cliente.depositar(400);
        cliente.manter_valor(15);
        cliente.tela();
        cliente.manter_valor(10);
        cliente.tela();
        cliente.depositar(1000);
        cliente.tela();
        cliente.sacar(1088.44);
        cliente.tela();
        cliente.ligar_desligar(true);
        cliente.acumulo();
    }
}
