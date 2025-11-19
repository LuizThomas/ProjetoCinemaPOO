public class CartaoCredito implements Pagar {
    private double valor;
    private int parcelas;

    public CartaoCredito(double valor, int parcelas) {
        this.valor = valor;
        this.parcelas = parcelas;
    }

    // Construtor antigo mantido para compatibilidade
    public CartaoCredito(double valor) {
        this.valor = valor;
        this.parcelas = 1;
    }

    @Override
    public void pagar() {
        System.out.println("💳 Processando pagamento via Cartão de Crédito...");
        System.out.println("  - Valor total: R$" + String.format("%.2f", valor));
        System.out.println("  - Parcelado em: " + parcelas + "x");
        
        if (parcelas > 1) {
            double valorParcela = valor / parcelas;
            System.out.println("  - Valor da parcela: R$" + String.format("%.2f", valorParcela));
        }
        
        System.out.println("  - Transação autorizada com sucesso!");
    }

    // Getters
    public double getValor() {
        return valor;
    }

    public int getParcelas() {
        return parcelas;
    }
}