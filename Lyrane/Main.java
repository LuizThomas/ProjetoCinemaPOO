import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=========================================");
        System.out.println("     SISTEMA DO CINE LYRANE    ");
        System.out.println("=========================================");

        Cinema cine = new Cinema("Cine Lyrane", "Rua Projetada, 80");
        Filme filme1 = new Filme("Voltando pra Ex 3", "19:00", 45.00);
        Filme filme2 = new Filme("As Branquelas", "21:30", 45.00);
        Filme filme3 = new Filme("Eu amo Lyrane", "16:00", 45.00);
        
        cine.adicionarFilme(filme1);
        cine.adicionarFilme(filme2);
        cine.adicionarFilme(filme3);

        // Criar bilheteria
        Bilhete bilhete = new Bilhete(cine);

        int opcao;
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Ver filmes em cartaz");
            System.out.println("2 - Comprar ingressos");
            System.out.println("3 - Sair");
            System.out.print("Escolha uma opção: ");
            
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    cine.exibirFilmes();
                    break;
                    
                case 2:
                    comprarIngressos(bilhete, scanner);
                    break;
                    
                case 3:
                    System.out.println("Obrigado por usar nosso sistema!");
                    break;
                    
                default:
                    System.out.println("Opção inválida!");
            }
            
        } while (opcao != 3);
        
        scanner.close();
    }

    private static void comprarIngressos(Bilhete bilhete, Scanner scanner) {
        System.out.println("\n=== COMPRA DE INGRESSOS ===");
        
        // Mostrar filmes disponíveis
        bilhete.getCinemaAssociado().exibirFilmes();
        
        // Escolher filme
        System.out.print("\nDigite o número do filme (1, 2, 3...): ");
        int numeroFilme = scanner.nextInt();
        scanner.nextLine();
        
        Filme filmeEscolhido = null;
        try {
            filmeEscolhido = bilhete.getCinemaAssociado().getFilmes().get(numeroFilme - 1);
            System.out.println("Filme escolhido: " + filmeEscolhido.getTitulo());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("❌ Filme não encontrado!");
            return;
        }

        // Escolher quantidade de ingressos
        System.out.print("Quantidade de ingressos: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        if (quantidade <= 0) {
            System.out.println("❌ Quantidade inválida!");
            return;
        }

        // Calcular total
        double total = filmeEscolhido.getPrecoIngresso() * quantidade;
        System.out.println("\n💰 VALOR TOTAL: R$" + String.format("%.2f", total));

        // Escolher forma de pagamento
        System.out.println("\n=== FORMA DE PAGAMENTO ===");
        System.out.println("1 - Cartão de Crédito");
        System.out.println("2 - PIX");
        System.out.print("Escolha a forma de pagamento: ");
        
        int formaPagamento = scanner.nextInt();
        scanner.nextLine();

        Pagar pagamento = null;
        
        switch (formaPagamento) {
            case 1:
                pagamento = processarCartaoCredito(total, scanner);
                break;
                
            case 2:
                System.out.print("Digite sua chave PIX: ");
                String chavePix = scanner.nextLine();
                pagamento = new Pix(total, chavePix);
                break;
                
            default:
                System.out.println("❌ Forma de pagamento inválida!");
                return;
        }

        if (pagamento != null) {
            // Realizar venda
            bilhete.realizarVenda(filmeEscolhido, quantidade, pagamento);
        }
    }

    private static Pagar processarCartaoCredito(double total, Scanner scanner) {
        System.out.println("\n💳 PAGAMENTO NO CARTÃO DE CRÉDITO");
        System.out.println("Valor total: R$" + String.format("%.2f", total));
        
        // Perguntar parcelamento
        System.out.print("Em quantas vezes deseja parcelar (1-6): ");
        int parcelas = scanner.nextInt();
        scanner.nextLine();

        if (parcelas < 1 || parcelas > 6) {
            System.out.println("❌ Número de parcelas inválido! Máximo 6 parcelas.");
            return null;
        }

        // Calcular valor das parcelas
        double valorParcela = total / parcelas;
        
        System.out.println("\n📊 DETALHES DO PARCELAMENTO:");
        System.out.println("Valor total: R$" + String.format("%.2f", total));
        System.out.println("Número de parcelas: " + parcelas);
        System.out.println("Valor de cada parcela: R$" + String.format("%.2f", valorParcela));
        
        System.out.println("\n💳 Processando pagamento...");
        
        return new CartaoCredito(total, parcelas);
    }
}