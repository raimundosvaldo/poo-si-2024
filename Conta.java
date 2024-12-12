package pacote1;

public class Conta {

	private int numero;
	private Cliente titular;
	private double saldo;
	private int senha;
	private Lancamento[] historico;
	private int ultimoLancamento;

	public Conta(int numero, Cliente titular, double saldo, int senha) {
		this.numero = numero;
		this.titular = titular;
		this.saldo = saldo;
		this.senha = senha;
		this.historico = new Lancamento[11];
	}

	public int getNumero() {
		return this.numero;
	}

	public Cliente getTitular() {
		return this.titular;
	}

	public double verificaSaldo(int senha) {
		if (senha == this.senha) {
			return this.saldo;
		}
		return -1;
	}

	public boolean creditaValor(double valor, String descricao) {
		if (valor >= 0) {
			this.saldo += valor;
			this.registraLancamento(valor, descricao);
			return true;
		}
		return false;
	}

	public boolean debitaValor(double valor, int senha, String descricao) {
		if (this.senha == senha && valor <= this.saldo && valor > 0) {
			this.saldo -= valor;
			this.registraLancamento(-valor, descricao);
			return true;
		}
		return false;
	}

	private void registraLancamento(double valor, String descricao) {
		if (this.ultimoLancamento == this.historico.length) {
			for (int i = 0; i < this.historico.length; i++) {
				this.historico[i] = this.historico[i + 1];
			}
		} else {
			this.ultimoLancamento++;
		}
		this.historico[this.ultimoLancamento] = new Lancamento(descricao, valor);

	}

}
