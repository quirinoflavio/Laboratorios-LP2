package lab2;

/**              
 * 
 * Acompanha as saude fisica e mental do aluno e retorna a saude geral de acordo
 * com o estado fisico e mental.
 * 
 * @author Flavio Roberto - 117111444
 *
 */
public class Saude {
	private String saudeMental = "boa";
	private String saudeFisica = "boa";

	/**
	 * Constroi a saude do aluno.
	 */
	public Saude() {

	}

	/**
	 * Define o estado de saude mental do aluno. Pode ser classificada em "boa" ou
	 * "fraca".
	 * 
	 * @param valor
	 *            estado de saude mental: "boa" ou "fraca".
	 */
	public void defineSaudeMental(String valor) {
		this.saudeMental = valor;
	}

	/**
	 * Define o estado de saude fisica do aluno. Pode ser classificada em "boa" ou
	 * "fraca".
	 * 
	 * @param valor
	 *            estado de saude fisica: "boa" ou "fraca".
	 */
	public void defineSaudeFisica(String valor) {
		this.saudeFisica = valor;
	}

	/**
	 * Define o estado de saude geral de acordo com os estados de saude metal e
	 * fisica.
	 * 
	 * @return retorna um valor de saude beseado na observacao da saude mental e
	 *         fisica.
	 */
	public String geral() {
		if (saudeFisica == saudeMental && saudeFisica.equals("boa")) {
			return "boa";
		} else if (saudeFisica == saudeMental && saudeFisica.equals("fraca")) {
			return "fraca";
		} else {
			return "ok";
		}
	}
}
