public class Filme {
    private String titulo;
    private String horario;
    private double precoIngresso;

    public Filme(String titulo, String horario, double precoIngresso) {
        this.titulo = titulo;
        this.horario = horario;
        this.precoIngresso = precoIngresso;
    }

    // Getters necessários para a classe Cinema (ou Main)
    public String getTitulo() { return titulo; }
    public String getHorario() { return horario; }
    public double getPrecoIngresso() { return precoIngresso; }
    
    // Você pode adicionar mais métodos aqui, como 'comprarIngresso()'
}