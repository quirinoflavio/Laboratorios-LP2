package lab2;

/**
 * 
 * Gerencia os gastos do aluno na cantina, baseado na quantidade de itens e centavos.
 * 
 * @author Flavio Roberto - 117111444
 */
public class ContaCantina {

	private String nomeDaCantina;
	private int numItens = 0;
	private int divida = 0;

	/**
	 * Constroi a cantina a partir do nome informado.
	 * 
	 * @param nomeDaCantina
	 *            nome da cantina.
	 */
	public ContaCantina(String nomeDaCantina) {
		this.nomeDaCantina = nomeDaCantina;
	}

	/**
	 * Resgistra a quantidade de lanches e seu valor.
	 * 
	 * @param qtdItens
	 *            quantidade de itens consumidos.
	 * @param valorCentavos
	 *            valor dos itens.
	 */
	public void cadastraLanche(int qtdItens, int valorCentavos) {
		this.numItens += qtdItens;
		this.divida += valorCentavos;
	}

	/**
	 * Registra pagamentos nas dividas da cantina.
	 * 
	 * @param valorCentavos
	 *            valor do pagamento
	 */
	public void pagaConta(int valorCentavos) {
		this.divida -= valorCentavos;
	}

	/**
	 * Retorna uma String informando o nome da cantida, a quantidade de itens e o
	 * valor da divida.
	 * @return retorna nome da cantina, o numero de itens e a divida.
	 */
	public String toString() {
		return this.nomeDaCantina + " " + this.numItens + " " + divida;
	}
}
