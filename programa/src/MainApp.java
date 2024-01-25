import java.time.LocalDate;

public class MainApp {
    public static void main(String[] args) {
        GerenciadorFinanceiro gerenciador = new GerenciadorFinanceiro();

        // Adicionar transações de teste
        gerenciador.adicionarTransacao(new Transacao("receita", 1000, LocalDate.now()));
        gerenciador.adicionarTransacao(new Transacao("despesa", 500, LocalDate.now().plusDays(2)));
        gerenciador.adicionarTransacao(new Transacao("receita", 200, LocalDate.now().plusDays(5)));
        gerenciador.adicionarTransacao(new Transacao("despesa", 300, LocalDate.now().plusDays(10)));

        // Mostrar saldo atual
        System.out.println("Saldo Atual: " + gerenciador.calcularSaldo());

        // Mostrar saldo projetado
        System.out.println("Saldo projetado para 3 dias: " + gerenciador.calcularSaldoProjetado(3));
        System.out.println("Saldo projetado para 7 dias: " + gerenciador.calcularSaldoProjetado(7));
        System.out.println("Saldo projetado para 30 dias: " + gerenciador.calcularSaldoProjetado(30));
    }
}
