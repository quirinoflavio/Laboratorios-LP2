package lab2;

/**
 * 
 * Gerencia os laboratios utilizados pelo aluno. Registra o nome do lab, o
 * espaco utilizado e a cota de espaco.
 * 
 * @author Flavio Roberto - 117111444
 *
 */
public class ContaLaboratorio {

	private String nomeLab;
	private int espacoOcupado;
	private int cota;

	/**
	 * Constroi o laboratorio a partir do nome informado. A cota eh por padrao
	 * 2000mb.
	 * 
	 * @param nomeLaboratorio
	 *            o nome do laboratorio.
	 */
	public ContaLaboratorio(String nomeLaboratorio) {
		this.nomeLab = nomeLaboratorio;
		this.cota = 2000;
	}

	/**
	 * Constroi o laboratorio a partir do nome informado e a cota.
	 * 
	 * @param nomeLaboratorio
	 *            o nome do laboratorio.
	 * @param cota
	 *            a cota de espaco disponivel para o aluno.
	 */
	public ContaLaboratorio(String nomeLaboratorio, int cota) {
		this.nomeLab = nomeLaboratorio;
		this.cota = cota;
	}

	/**
	 * Adiciona o espaco consumido naquele momento ao espaco ocupado.
	 * @param mbytes consumir espaco.
	 */
	public void consomeEspaco(int mbytes) {
		this.espacoOcupado += mbytes;
	}

	/**
	 * Libera espaco do espaco ocupado.
	 * @param mbytes liberar espaco.
	 */
	public void liberaEspaco(int mbytes) {
		this.espacoOcupado -= mbytes;
	}

	/**
	 * Retorna, respectivamente, true ou false se o aluno atingiu ou nao a cota.
	 * 
	 * @return retorna true ou false sobre se o aluno atingiu a cota.
	 */
	public boolean atingiuCota() {
		return this.espacoOcupado >= this.cota;
	}

	/**
	 * Retorna uma String contendo o nome do laboratorio, o espaco ocupado e a cota.
	 */
	@Override
	public String toString() {
		return this.nomeLab + " " + this.espacoOcupado + "/" + this.cota;
	}
}
