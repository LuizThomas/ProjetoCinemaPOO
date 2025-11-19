import java.util.ArrayList;
import java.util.List;

public class Cinema {

    private String nome;
    private String endereco;
    private List<Filme> filmes;

    public Cinema(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        this.filmes = new ArrayList<>();
    }

    public void adicionarFilme(Filme filme) {
        filmes.add(filme);
    }

    public void exibirFilmes() {
        System.out.println("🎬 Filmes disponíveis:");
        for (Filme f : filmes) {
            System.out.println("- " + f.getTitulo() + " (" + f.getHorario() + ")");
        }
    }

    public void processarPagamento(Pagar pagamento) {
        pagamento.pagar();
        System.out.println("💰 Pagamento processado com sucesso no cinema " + nome);
    }

    public String getNome() { return nome; }
    public String getEndereco() { return endereco; }
    public List<Filme> getFilmes() { return filmes; }
}