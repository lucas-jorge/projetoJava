import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

class GerenciadorFinanceiro {
    private List<Transacao> transacoes;

    public GerenciadorFinanceiro() {
        this.transacoes = new ArrayList<>();
    }

    public void adicionarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    public double calcularSaldo() {
        double saldo = 0;

        for (Transacao transacao : transacoes) {
            if (transacao.getTipo().equals("receita")) {
                saldo += transacao.getValor();
            } else if (transacao.getTipo().equals("despesa")) {
                saldo -= transacao.getValor();
            }
        }

        return saldo;
    }

    public double calcularSaldoProjetado(int dias) {
        double saldo = calcularSaldo();

        LocalDate hoje = LocalDate.now();
        LocalDate dataProjetada = hoje.plusDays(dias);

        for (Transacao transacao : transacoes) {
            if (transacao.getData().isAfter(hoje) && transacao.getData().isBefore(dataProjetada)) {
                if (transacao.getTipo().equals("receita")) {
                    saldo += transacao.getValor();
                } else if (transacao.getTipo().equals("despesa")) {
                    saldo -= transacao.getValor();
                }
            }
        }

        return saldo;
    }
}

class Transacao {
    private String tipo;
    private double valor;
    private LocalDate data;

    public Transacao(String tipo, double valor, LocalDate data) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }
}
