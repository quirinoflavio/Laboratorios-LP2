package sistema;

import easyaccept.EasyAccept;

public class Facade {

	private Controller controle;

	public static void main(String[] args) {


		args = new String[] { "sistema.Facade", "testes_aceitacao/us1_test.txt", "testes_aceitacao/us2_test.txt",
				"testes_aceitacao/us3_test.txt", "testes_aceitacao/us4_test.txt", "testes_aceitacao/us5_test.txt",
				"testes_aceitacao/us6_test.txt", "testes_aceitacao/us7_test.txt" };
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
	 * Cadastra cenario bonus e retorma a numeracao do cenario cadastrado.
	 * 
	 * @param descricao
	 *            eh a descricao do cenario.
	 * @param bonus
	 *            eh o bonus oferecido pelo cenario.
	 * @return retorna a numeracao do cenario criado.
	 */
	public int cadastrarCenario(String descricao, int bonus) {
		return controle.cadastrarCenario(descricao, bonus);
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

	public String exibirCenarioOrdenado(int cenario) {
		return controle.exibirCenarioOrdenado(cenario);
	}
	
	public void alterarOrdem(String tipo) {
		controle.alterarOrdem(tipo);
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

	/**
	 * Cadastra a aposta assegurada por valor.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 * @param apostador
	 *            eh o nome do apostador.
	 * @param valor
	 *            eh o valor da aposta.
	 * @param previsao
	 *            eh a previsao da aposta.
	 * @param valorSeguro
	 *            eh o valor do seguro.
	 * @param custo
	 *            eh o custo do seguro.
	 * @return retorna o identificador da aposta, que eh justamente o indice
	 */
	public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int valorSeguro,
			int custo) {
		return controle.cadastrarApostaSeguraValor(cenario, apostador, valor, previsao, valorSeguro, custo);
	}

	public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxa,
			int custo) {
		return controle.cadastrarApostaSeguraTaxa(cenario, apostador, valor, previsao, taxa, custo);
	}

	public int alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
		return controle.alteraSeguroValor(cenario, apostaAssegurada, valor);
	}

	public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
		return controle.alteraSeguroTaxa(cenario, apostaAssegurada, taxa);

	}

	public String getSegurado() {
		return controle.getCenario(6).getAposta(6).getSeguro().getTipo();
	}

}
