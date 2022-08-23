package base;

public class CalculadoraDeJurosComposta implements Iteracao {

    private boolean status = false;

    private double banco, cdi_anual, cdi_mensal, cdi_acumulado = 0;
    private double entrada, mensal, plano;

    public CalculadoraDeJurosComposta(double entrada, double plano) {
        setStatus(true);
        setEntrada(entrada);
        setPlano(plano);
        setBanco(getEntrada());
        operation();
    }

    private void operation() {
        setCdi_anual(getBanco() * getCDI());
        setCdi_mensal(getCdi_anual() / 12);
        setCdi_acumulado(getCdi_acumulado() + getCdi_mensal());
    }

    private boolean getStatus() {
        return status;
    }

    private void setStatus(boolean status) {
        this.status = status;
    }

    private double getCDI() {
        return 0.1315;
    }

    private double getBanco() {
        return banco;
    }

    private void setBanco(double banco) {
        this.banco = banco;
    }

    private double getCdi_anual() {
        return cdi_anual;
    }

    private void setCdi_anual(double cdi_anual) {
        this.cdi_anual = cdi_anual;
    }

    private double getCdi_mensal() {
        return cdi_mensal;
    }

    private void setCdi_mensal(double cdi_mensal) {
        this.cdi_mensal = cdi_mensal;
    }

    private double getCdi_acumulado() {
        return cdi_acumulado;
    }

    private void setCdi_acumulado(double cdi_acumulado) {
        this.cdi_acumulado = cdi_acumulado;
    }

    private double getEntrada() {
        return entrada;
    }

    private void setEntrada(double entrada) {
        this.entrada = entrada;
    }

    private double getMensal() {
        return mensal;
    }

    private void setMensal(double mensal) {
        this.mensal = mensal;
    }

    private double getPlano() {
        return plano;
    }

    private void setPlano(double plano) {
        this.plano = plano;
    }

    @Override
    public void tela() {
        System.out.printf("\nBanco : R$%.2f", getBanco());
        System.out.printf("\nCDI Anual : R$%.2f", getCdi_anual());
        System.out.printf("\nCDI Mensal : R$%.2f", getCdi_mensal());
        System.out.printf("\nMETA Concluída: %.2f", getBanco() / getPlano() * 100);
        System.out.println();
    }

    @Override
    public void depositar(double depositar) {
        if (getStatus()) {
            setMensal(depositar);
            setBanco(getBanco() + getMensal() + getCdi_mensal());
            operation();
        } else {
            System.out.println("Não pode Operar");
            System.out.println("Status: " + getStatus());
        }
    }

    @Override
    public void sacar(double sacar) {
        if (getStatus() && getBanco() >= sacar) {
            setBanco(getBanco() - sacar);
            operation();
        } else {
            if (!getStatus()){
                System.out.println("Não pode Operar");
                System.out.println("Status: " + getStatus());
            } else {
                System.out.println("Não pode Operar");
                System.out.printf("\nLimite de saldo: R$%.2f", getBanco());
            }
        }
    }

    @Override
    public void manter_valor(int manter) {
        if (getBanco() <= getPlano() && getStatus()) {
            for (int i = 0; i < manter; i++) {
                if (getBanco() >= getPlano())
                    break;
                setBanco(getBanco() + getMensal() + getCdi_mensal());
                operation();
            }
        }
    }

    @Override
    public void ligar_desligar(boolean info) {
        setStatus(!getStatus());
    }

    @Override
    public void acumulo() {
        System.out.printf("\nCDI acumulado: R$%.2f", getCdi_acumulado());
        System.out.println();
    }
}
