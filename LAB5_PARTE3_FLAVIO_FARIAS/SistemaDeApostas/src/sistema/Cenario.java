package sistema;

import java.util.ArrayList;

public class Cenario {

	private String descricao;
	private String estado;
	private ArrayList<Aposta> apostas;
	private int id;

	/**
	 * Constroi o cenario a partir da descricao. Antes, verifica se a descricao eh
	 * valida.
	 * 
	 * @param descricao
	 *            eh a descricao do cenario.
	 */
	public Cenario(String descricao, int id) {
		verificaDescricao(descricao);
		this.descricao = descricao;
		this.estado = "Nao finalizado";
		this.apostas = new ArrayList<Aposta>();
		this.id = id;
	}

  public int getId(){
    return this.id;
  }
	/**
	 * Chama o metodo de aposta para alterar o seguro.
	 * 
	 * @param indiceAposta
	 *            eh o indice da aposta.
	 * @param valor
	 *            eh o valor do novo seguro.
	 */
	public int alteraSeguroValor(int indiceAposta, int valor) {
		return getAposta(indiceAposta).alteraSeguroValor(valor);
	}

	/**
	 * Chama o metodo de aposta para alterar o seguro.
	 * 
	 * @param indiceAposta
	 *            eh o indice da aposta.
	 * @param taxa
	 *            eh a taxa do novo seguro.
	 * @return 
	 */
	public int alteraSeguroTaxa(int indiceAposta, double taxa) {
		return getAposta(indiceAposta).alteraSeguroTaxa(taxa);
	}

	/**
	 * Recupera uma aposta a partir do indice.
	 * 
	 * @param apostaIndice
	 *            eh o indice da aposta.
	 * @return retorna um objeto Aposta.
	 */
	public Aposta getAposta(int apostaIndice) {
		return apostas.get(apostaIndice - 1);
	}

	/**
	 * Gera uma representacao textual de todas as apostas do cenario.
	 * 
	 * @return retorna uma string.
	 */
	public String exibeApostas() {
		String todasApostas = "";
		for (Aposta aposta : this.apostas) {
			todasApostas += aposta.toString() + "\n";
		}
		return todasApostas;
	}

	/**
	 * Cria a aposta e adiciona no arraylist.
	 * 
	 * @param apostador
	 *            eh o nome do apostador.
	 * @param valor eh o valor da aposta.
	 * @param previsao eh a previsao da aposta.
	 */
	public void cadastraAposta(String apostador, int valor, String previsao) {
		this.apostas.add(new Aposta(apostador, valor, previsao));
	}
	
		/**
	 * Cria a aposta assegurada por taxa e adiciona no arraylist.
	 * O id da aposta sera sua posicao no arraylist.
	 * @param apostador
	 *            eh o nome do apostador.
	 * @param valor eh o valor da aposta.
	 * @param previsao eh a previsao da aposta.
	 * @param taxa eh a taxa do seguro.
	 */
	public int cadastraAposta(String apostador, int valor, String previsao, double taxa) {
		this.apostas.add(new Aposta(apostador, valor, previsao, taxa, this.apostas.size()));
		return this.apostas.size();
	}
	
		/**
	 * Cria a aposta assegurada por valor e adiciona no arraylist.
	 * O id da aposta sera sua posicao no arraylist
	 * @param apostador
	 *            eh o nome do apostador.
	 * @param valor eh o valor da aposta.
	 * @param previsao eh a previsao da aposta.

	 * @param valorSeguro eh o valor do seguro
	 */
	public int cadastraAposta(String apostador, int valor, String previsao, int valorSeguro) {
		this.apostas.add(new Aposta(apostador, valor, previsao, valorSeguro, this.apostas.size()));
		return this.apostas.size();
	}

	/**
	 * Calcula e retorna o valor total das apostas perdedoras.
	 * 
	 * @return retorna o valor total das apostas perdedoras.
	 */
	public int calculaValorApostasPerdedoras() {
		int soma = 0;
		for (Aposta aposta : this.apostas) {
			if ((this.estado.equals("Finalizado (ocorreu)")) && aposta.getPrevisao().equals("N VAI ACONTECER")) {
				soma += aposta.getValor();
			} else if (this.estado.equals("Finalizado (n ocorreu)") && (aposta.getPrevisao().equals("VAI ACONTECER"))) {
				if (aposta.getPrevisao().equals("VAI ACONTECER")) {
					soma += aposta.getValor();
				}
			}
		}
		return soma;
	}

	/**
	 * Calcula o valor total dos seguros. Percorre as apostas verificando quem
	 * perdeu e tem seguro, dai adiciona o valor do seguro na soma.
	 * 
	 * @return retorna uma soma contendo o valor que deve ser retornado aos
	 *         apostadores.
	 */
	public int calculaValorAssegurado() {
		int soma = 0;
		for (Aposta aposta : this.apostas) {
			if ((this.estado.equals("Finalizado (ocorreu)")) && aposta.getPrevisao().equals("N VAI ACONTECER")) {
				if (aposta.temSeguro() && aposta.getSeguro().getTipo().equals("TAXA")) {
					soma += (aposta.getValor() * ((ApostaAsseguradaTaxa) aposta.getSeguro()).getSegurado());
				} else if (aposta.temSeguro() && aposta.getSeguro().getTipo().equals("VALOR")) {
					soma += ((ApostaAsseguradaValor) aposta.getSeguro()).getSegurado();
				}
			} else if ((this.estado.equals("Finalizado (n ocorreu)")) && aposta.getPrevisao().equals("VAI ACONTECER")) {
				if (aposta.getPrevisao().equals("VAI ACONTECER")) {
					if (aposta.temSeguro() && aposta.getSeguro().getTipo().equals("VALOR")) {
						soma += ((ApostaAsseguradaValor) aposta.getSeguro()).getSegurado();
					} else if (aposta.temSeguro() && aposta.getSeguro().getTipo().equals("TAXA")) {
						soma += (aposta.getValor() * ((ApostaAsseguradaTaxa) aposta.getSeguro()).getSegurado());
					}
				}
			}
		}
		return soma;
	}

	/**
	 * Calcula o rateio de acordo com a taxa passada e o valor das apostas
	 * perdedoras
	 * 
	 * @param taxa
	 *            eh a taxa do sistema
	 * @return retorna um int que representa o valor do rateio.
	 */
	public int calculaRateio(double taxa) {
		return (calculaValorApostasPerdedoras() - (int) (calculaValorApostasPerdedoras() * taxa));
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
	 * Retorna a descricao do cenario
	 * 
	 * @return retorna a descricao do cenario
	 */
	public String getDescricao() {
		return this.descricao;
	}

	/**
	 * Retorna o estado do cenario.
	 * 
	 * @return retorna o estado do cenario.
	 */
	public String getEstado() {
		return this.estado;
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
	 * Calcula e retorna o valor total das apostas.
	 * 
	 * @return retorna o valor total das apostas.
	 */
	public int getValorTotalDeApostas() {
		int soma = 0;
		for (Aposta aposta : this.apostas) {
			soma += aposta.getValor();
		}
		return soma;
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
