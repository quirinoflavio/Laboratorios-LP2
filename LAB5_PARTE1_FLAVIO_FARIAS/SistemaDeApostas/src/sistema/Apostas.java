package sistema;

public class Apostas {

	private String nomeApostador, previsao;
	private int valorAposta;

	public Apostas(String nomeApostador, int valorAposta, String previsao) {
		verificaApostadorVazioNulo(nomeApostador);
		verificaApostaValida(valorAposta);
		verificaPrevisaoValida(previsao);
		this.nomeApostador = nomeApostador;
		this.valorAposta = valorAposta;
		this.previsao = previsao;
	}

	/**
	 * Gera uma representacao da aposta com o nome do apostador, valor da aposta (em
	 * reais) e a previsao.
	 * 
	 * @return retorna uma string com a representacao da aposta.
	 */
	public String toString() {
		return this.nomeApostador + " - " + "R$" + String.format("%.2f", (this.valorAposta) / 100.0) + " - "
				+ this.previsao;
	}

	/**
	 * Recupera o valor da aposta.
	 * 
	 * @return retorna um inteiro com o valor da aposta.
	 */
	public int getValor() {
		return this.valorAposta;
	}

	/**
	 * Recupera o nome do apostador.
	 * 
	 * @return retorna uma string que representa o nome do apostador.
	 */
	public String getNomeApostador() {
		return this.nomeApostador;
	}

	/**
	 * Recupera a previsao feita sobre a aposta.
	 * 
	 * @return returna uma string que representa a previsao.
	 */
	public String getPrevisao() {
		return this.previsao;
	}

	/**
	 * Verifica se o nome do apostador eh vazio ou nulo
	 * 
	 * @param apostador
	 *            eh o nome do apostador.
	 */
	public void verificaApostadorVazioNulo(String apostador) {
		if (apostador.trim().equals("") || apostador == null) {
			throw new NullPointerException("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		}
	}

	/**
	 * Verifica se o valor da aposta eh valido. So eh valido se for maior que zero.
	 * 
	 * @param aposta
	 *            eh o valor da aposta.
	 */
	public void verificaApostaValida(int aposta) {
		if (aposta <= 0) {
			throw new NullPointerException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		}
	}

	/**
	 * Verifica se a previsao eh valida. So eh valida se for uma string nao vazia ou
	 * nao nula.
	 * 
	 * @param previsao
	 *            eh a string da previsao.
	 */
	public void verificaPrevisaoValida(String previsao) {
		if (previsao.trim().equals("") || previsao == null) {
			throw new NullPointerException("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		} else if (!(previsao.equals("N VAI ACONTECER") || previsao.equals("VAI ACONTECER"))) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Previsao invalida");
		}
	}
}
