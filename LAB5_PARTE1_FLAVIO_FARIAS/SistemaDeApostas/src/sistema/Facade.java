package sistema;

import easyaccept.EasyAccept;

public class Facade {

	private Controller controle;

	public static void main(String[] args) {

		args = new String[] { "sistema.Facade", "testes_aceitacao/us1_test.txt", "testes_aceitacao/us2_test.txt",
				"testes_aceitacao/us3_test.txt", "testes_aceitacao/us4_test.txt" };
		EasyAccept.main(args);
	}

	/**
	 * Inicializa o sistem com um valor e taxa.
	 * 
	 * @param caixa
	 *            eh o valor disponivel no caixa.
	 * @param taxa
	 *            eh a taxa cobrada sobre as apostas.
	 */
	public void inicializa(int caixa, double taxa) {
		controle = new Controller(caixa, taxa);
	}

	/**
	 * Cadastra cenario e retorma a numeracao do cenario cadastrado.
	 * 
	 * @param descricao
	 *            eh a descricao do cenario.
	 * @return retorna a numeracao do cenario criado.
	 */
	public int cadastrarCenario(String descricao) {
		return controle.cadastrarCenario(descricao);
	}

	/**
	 * Exibe o cenario (numeracao, descricao e estado).
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 * @return retorna uma string contendo a numeracao, descricao e estado do
	 *         cenario.
	 */
	public String exibirCenario(int cenario) {
		return controle.exibirCenario(cenario);
	}

	/**
	 * Gera uma lista textual com todos os cenarios cadastrados.
	 * 
	 * @return retorna uma string contendo todos os cenarios cadastrados no sistema.
	 */
	public String exibirCenarios() {
		return controle.exibirCenarios();
	}

	/**
	 * Recupera o valor em caixa do sistema.
	 * 
	 * @return retorna o valor disponivel no caixa do sistema.
	 */
	public int getCaixa() {
		return controle.getCaixa();
	}

	/**
	 * Cadastra uma aposta com as informacoes passadas como parametro.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 * @param apostador
	 *            eh o nome do apostador.
	 * @param valor
	 *            eh o valor da aposta.
	 * @param previsao
	 *            eh a previsao sobre o cenario.
	 */
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		controle.cadastrarAposta(cenario, apostador, valor, previsao);

	}

	/**
	 * Recupera o valor total das apostas sobre o cenario passado como parametro.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 * @return retorna a soma do valor de todas as apostas sobre o cenario.
	 */
	public int valorTotalDeApostas(int cenario) {
		return controle.valorTotalDeApostas(cenario);
	}

	/**
	 * Recupera a quantidade de apostas feitas sobre o cenario.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 * @return retorna o numero de apostas feitas sobre o cenario.
	 */
	public int totalDeApostas(int cenario) {
		return controle.totalDeApostas(cenario);
	}

	/**
	 * Exibe as apostas feitas sobre o cenario.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 * @return retorna uma string contendo as apostas.
	 */
	public String exibeApostas(int cenario) {
		return controle.exibeApostas(cenario);
	}

	/**
	 * Encerra o cenario indicando se occorreu ou nao.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 * @param ocorreu
	 *            boolean indicando se ocorreu ou nao.
	 */
	public void fecharAposta(int cenario, boolean ocorreu) {
		controle.fecharAposta(cenario, ocorreu);
	}

	/**
	 * Retorna o valor (de um cenario ja fechado) que sera destinado ao caixa.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 * @return retorna o valor destinado ao caixa.
	 */
	public int getCaixaCenario(int cenario) {
		return controle.getCaixaCenario(cenario);
	}

	/**
	 * Retornao o valor (de um cenario ja fechado) que sera destinado aos
	 * vencedores.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 * @return retorna o valor destinado aos vencedores.
	 */
	public int getTotalRateioCenario(int cenario) {
		return controle.getTotalRateioCenario(cenario);
	}

}
