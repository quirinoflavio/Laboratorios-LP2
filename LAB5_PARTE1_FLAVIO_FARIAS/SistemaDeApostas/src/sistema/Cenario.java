package sistema;

import java.util.ArrayList;

public class Cenario {

	private String descricao, estado;
	private ArrayList<Apostas> apostas;

	/**
	 * Constroi o cenario a partir da descricao. Antes, verifica se a descricao eh
	 * valida.
	 * 
	 * @param descricao
	 *            eh a descricao do cenario.
	 */
	public Cenario(String descricao) {
		verificaDescricao(descricao);
		this.descricao = descricao;
		this.estado = "Nao finalizado";
		this.apostas = new ArrayList<Apostas>();
	}

	/**
	 * Gera uma representacao textual de todas as apostas do cenario.
	 * 
	 * @return retorna uma string.
	 */
	public String exibeApostas() {
		String todasApostas = "";
		for (Apostas aposta : this.apostas) {
			todasApostas += aposta.toString() + "\n";
		}
		return todasApostas;
	}

	/**
	 * Calcula e retorna o valor total das apostas.
	 * 
	 * @return retorna o valor total das apostas.
	 */
	public int getValorTotalDeApostas() {
		int soma = 0;
		for (Apostas aposta : this.apostas) {
			soma += aposta.getValor();
		}
		return soma;
	}

	/**
	 * Adiciona a aposta no arraylist.
	 * 
	 * @param aposta
	 *            eh a aposta.
	 */
	public void adicionaAposta(Apostas aposta) {
		this.apostas.add(aposta);
	}

	/**
	 * Retorna a quantidade de apostas ja cadastradas no cenario.
	 * 
	 * @return retorna a quantidade de apostas do cenario.
	 */
	public int getQuantidadeDeApostas() {
		return this.apostas.size();
	}

	/**
	 * Gera uma representacao textual do cenario.
	 * 
	 * @return retorna a descricao e o estado.
	 */
	@Override
	public String toString() {
		return this.descricao + " - " + this.estado;
	}

	/**
	 * Calcula e retorna o valor total das apostas perdedoras.
	 * 
	 * @return retorna o valor total das apostas perdedoras.
	 */

	public int calculaValorApostasPerdedoras() {
		int soma = 0;
		if (this.estado.equals("Finalizado (ocorreu)")) {
			for (Apostas aposta : this.apostas) {
				if (aposta.getPrevisao().equals("N VAI ACONTECER")) {
					soma += aposta.getValor();
				}
			}

		} else if (this.estado.equals("Finalizado (n ocorreu)")) {
			for (Apostas aposta : this.apostas) {
				if (aposta.getPrevisao().equals("VAI ACONTECER")) {
					soma += aposta.getValor();
				}
			}

		}
		return soma;
	}

	/**
	 * Calcula e retorna o valor das apostas vencedoras.
	 * 
	 * @return retorna o valor das apostas vencedoras.
	 */
	public int calculaValorApostasVencedoras() {
		return getValorTotalDeApostas() - calculaValorApostasPerdedoras();
	}

	/**
	 * Define o estado do cenario (ocorreu ou n ocorreu).
	 * 
	 * @param ocorreu
	 *            eh um boolean que define o estado do cenario.
	 */
	public void setEstado(boolean ocorreu) {
		if (ocorreu) {
			this.estado = "Finalizado (ocorreu)";
		} else {
			this.estado = "Finalizado (n ocorreu)";
		}
	}

	/**
	 * Verifica se a descricao do cenario eh valida. Lanca uma excecao caso a
	 * decricao nao seja valida.
	 * 
	 * @param descricao
	 *            eh a descricao da aposta.
	 */
	public void verificaDescricao(String descricao) {
		if (descricao.trim().equals("")) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}
	}

	/**
	 * Verifica se o cenario esta fechado.
	 * 
	 * @return returna um boolean que representado o cenario fechado ou aberto.
	 */
	public boolean verificaCenarioFechado() {
		return !this.estado.equals("Nao finalizado");
	}
}
