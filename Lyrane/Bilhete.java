public class Bilhete {
    private Cinema cinemaAssociado;

    public Bilhete(Cinema cinemaAssociado) {
        this.cinemaAssociado = cinemaAssociado;
        System.out.println("🎟️ Bilheteria aberta para o cinema: " + cinemaAssociado.getNome());
    }

    public void realizarVenda(Filme filme, int quantidadeIngressos, Pagar formaPagamento) {
        
        System.out.println("\n--- INICIANDO VENDA NA BILHETERIA ---");

        if (!cinemaAssociado.getFilmes().contains(filme)) {
            System.out.println("❌ Erro: Filme não está em cartaz neste cinema.");
            return;
        }

        double totalIngressos = filme.getPrecoIngresso() * quantidadeIngressos;
        
        System.out.println("📋 RESUMO DA COMPRA:");
        System.out.println("  Filme: " + filme.getTitulo());
        System.out.println("  Horário: " + filme.getHorario());
        System.out.println("  Ingressos: " + quantidadeIngressos + "x R$" + filme.getPrecoIngresso());
        System.out.println("  Total: R$" + String.format("%.2f", totalIngressos));
        
        // Processar pagamento
        cinemaAssociado.processarPagamento(formaPagamento);
        
        System.out.println("🎉 VENDA CONCLUÍDA COM SUCESSO!");
        System.out.println("🎬 Aproveite o filme!");
    }

    // Getter para acesso ao cinema
    public Cinema getCinemaAssociado() {
        return cinemaAssociado;
    }
}