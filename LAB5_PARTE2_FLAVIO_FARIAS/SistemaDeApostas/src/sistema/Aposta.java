package sistema;

public class Aposta {

	private String nomeApostador;
	private String previsao;
	private int valorAposta;
	private Seguro seguro;

	/**
	 * Construtor da aposta simples. O seguro eh null porque esta aposta nao tem
	 * seguro.
	 * 
	 * @param nomeApostador
	 *            eh o nome do apostador.
	 * @param valorAposta
	 *            eh o valor da aposta.
	 * @param previsao
	 *            eh a previsao da aposta.
	 */
	public Aposta(String nomeApostador, int valorAposta, String previsao) {
		verificaNomeVazioNulo(nomeApostador, "aposta");
		verificaApostaValida(valorAposta, "aposta");
		verificaPrevisaoValida(previsao, "aposta");
		this.nomeApostador = nomeApostador;
		this.valorAposta = valorAposta;
		this.previsao = previsao;
		this.seguro = null;
	}

	/**
	 * Construtor da aposta assegurada por valor.
	 * 
	 * @param nomeApostador
	 *            eh o nome do apostador.
	 * @param valorAposta
	 *            eh o valor da aposta.
	 * @param previsao
	 *            eh a previsao da aposta.
	 * @param valorSeguro
	 *            eh o valor do seguro.
	 * @param id
	 *            eh o identificador da aposta.
	 */
	public Aposta(String nomeApostador, int valorAposta, String previsao, int valorSeguro, int id) {
		verificaNomeVazioNulo(nomeApostador, "aposta assegurada por valor");
		verificaApostaValida(valorAposta, "aposta assegurada por valor");
		verificaPrevisaoValida(previsao, "aposta assegurada por valor");
		this.nomeApostador = nomeApostador;
		this.valorAposta = valorAposta;
		this.previsao = previsao;
		this.seguro = new ApostaAsseguradaValor(valorSeguro, id);
	}

	/**
	 * Construtor da aposta assegurada por taxa.
	 * 
	 * @param nomeApostador
	 *            eh o nome do apostador.
	 * @param valorAposta
	 *            eh o valor da aposta.
	 * @param previsao
	 *            eh a previsao da aposta.
	 * @param taxa
	 *            eh a taxa do seguro.
	 * @param id
	 *            eh o identificador da aposta.
	 */
	public Aposta(String nomeApostador, int valorAposta, String previsao, double taxa, int id) {
		verificaNomeVazioNulo(nomeApostador, "aposta assegurada por taxa");
		verificaApostaValida(valorAposta, "aposta assegurada por taxa");
		verificaPrevisaoValida(previsao, "aposta assegurada por taxa");
		this.nomeApostador = nomeApostador;
		this.valorAposta = valorAposta;
		this.previsao = previsao;
		this.seguro = new ApostaAsseguradaTaxa(taxa, id);
	}

	/**
	 * Altera o valor do seguro. Antes, armazena o id da aposta numa variavel para
	 * mante-lo apos a troca.
	 * Cria um novo objeto para o seguro com o valor passado como parametro.
	 * Se o seguro for do tipo ApostaAsseguradaTaxa, agora passara a ser ApostaAsseguradaValor.
	 * @param valor eh o valor do novo seguro.
	 */
	public void alteraSeguroValor(int valor) {
		int id = this.seguro.getId();
		if (temSeguro())
			this.seguro = new ApostaAsseguradaValor(valor, id);
	}

	/**
	 * Altera a taxa do seguro. Antes, armazena o id da aposta numa variavel para
	 * mante-lo apos a troca.
	 * Cria um novo objeto para o seguro com a taxa passada como parametro.
	 * Se o seguro for do tipo ApostaAsseguradaValor, agora passara a ser ApostaAsseguradaTaxa.
	 * @param taxa
	 */
	public void alteraSeguroTaxa(double taxa) {
		int id = this.seguro.getId();
		if (temSeguro())
			this.seguro = new ApostaAsseguradaTaxa(taxa, id);
	}


	/**
	 * Recupera o objeto seguro da aposta.
	 * @return retorna o objeto seguro.
	 */
	public Seguro getSeguro() {
	   return this.seguro;
	}

	/**
	 * Gera uma representacao da aposta com o nome do apostador, valor da aposta (em
	 * reais) e a previsao.
	 * 
	 * @return retorna uma string com a representacao da aposta.
	 */
	public String toString() {
		if (temSeguro()){
		  return this.nomeApostador + " - " + "R$" + String.format("%.2f", (this.valorAposta) / 100.0) + " - "
				+ this.previsao + this.seguro.toString();
		  }
		else{
		  return this.nomeApostador + " - " + "R$" + String.format("%.2f", (this.valorAposta) / 100.0) + " - "
				+ this.previsao;
				}
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
	 * Verifica se a aposta tem seguro.
	 * 
	 * @return retorna true se a aposta tiver seguro, falso caso contrario.
	 */
	public boolean temSeguro() {
		if (this.seguro != null) {
		return true;
		}
		return false;
  }
  
	/**
	 * Verifica se o nome do apostador eh vazio ou nulo
	 * 
	 * @param apostador
	 *            eh o nome do apostador.
	 * @param whoami eh quem esta verificando o parametro.
	 */
	public void verificaNomeVazioNulo(String nome, String whoami) {
		if (nome.trim().equals("") || nome == null)
			throw new IllegalArgumentException(
					"Erro no cadastro de " + whoami + ": Apostador nao pode ser vazio ou nulo");

	}

	/**
	 * Verifica se o valor da aposta eh valido. So eh valido se for maior que zero.
	 * 
	 * @param valor
	 *            eh o valor a ser verificado.
	 * @param whoami eh quem esta verificando o parametro.
	 */
	public void verificaApostaValida(int valor, String whoami) {
		if (valor <= 0)
			throw new IllegalArgumentException(
					"Erro no cadastro de " + whoami + ": Valor nao pode ser menor ou igual a zero");

	}

	/**
	 * Verifica se a previsao eh valida. So eh valida se for uma string nao vazia ou
	 * nao nula.
	 * 
	 * @param previsao
	 *            eh a string da previsao.
	 * @param whoami eh quem esta verificando o parametro.
	 */
	public void verificaPrevisaoValida(String previsao, String whoami) {
		if (previsao.trim().equals("") || previsao == null)
			throw new IllegalArgumentException(
					"Erro no cadastro de " + whoami + ": Previsao nao pode ser vazia ou nula");
		else if (!(previsao.equals("N VAI ACONTECER") || previsao.equals("VAI ACONTECER")))
			throw new IllegalArgumentException("Erro no cadastro de " + whoami + ": Previsao invalida");

	}
}
