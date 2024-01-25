import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorFinanceiro {
    private List<Transacao> transacoes;

    public GerenciadorFinanceiro() {
        transacoes = new ArrayList<>();
    }

    public void adicionarTransacao(Transacao transacao) {
        transacoes.add(transacao);
    }

    public double calcularSaldo() {
        double saldo = 0;
        for (Transacao transacao : transacoes) {
            if (transacao.getTipo().equals("receita")) {
                saldo += transacao.getValor();
            } else {
                saldo -= transacao.getValor();
            }
        }
        return saldo;
    }

    public double calcularSaldoProjetado(int dias) {
        double saldoProjetado = calcularSaldo();
        LocalDate dataLimite = LocalDate.now().plusDays(dias);

        for (Transacao transacao : transacoes) {
            if (transacao.getData().isAfter(LocalDate.now()) && transacao.getData().isBefore(dataLimite)) {
                if (transacao.getTipo().equals("receita")) {
                    saldoProjetado += transacao.getValor();
                } else {
                    saldoProjetado -= transacao.getValor();
                }
            }
        }
        return saldoProjetado;
    }
}
