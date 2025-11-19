public class Pix implements Pagar {
    private double valor;
    private String chavePix;

    public Pix(double valor, String chavePix) {
        this.valor = valor;
        this.chavePix = chavePix;
    }

    @Override
    public void pagar() {
        System.out.println("-----------------------------------------");
        System.out.println("📲 Iniciando pagamento PIX...");
        System.out.println("  - Valor a pagar: R$" + String.format("%.2f", valor));
        System.out.println("  - Chave PIX: " + chavePix);
        System.out.println("  - QR Code gerado. Aguardando confirmação...");
        
        // Simulação de tempo de processamento
        // try { Thread.sleep(2000); } catch (InterruptedException e) {} 
        
        System.out.println("✅ Pagamento PIX confirmado com sucesso!");
        System.out.println("-----------------------------------------");
    }

    // Getter para chavePix (útil na Bilhete)
    public String getChavePix() {
        return chavePix;
    }
}