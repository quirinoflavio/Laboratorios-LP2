package sistema;

/**
 * Subclasse de EstrategiaOrdenacao que compara cenarios pela quantidade de
 * apostas
 * 
 * @author flaviorpqf
 *
 */
public class EstrategiaOrdenaQtdDeApostas extends EstrategiaOrdenacao {

	/**
	 * Compara dois cenarios pela quantidade de apostas
	 */
	public int compare(Cenario cenario, Cenario outroCenario) {
		if (cenario.getQuantidadeDeApostas() > outroCenario.getQuantidadeDeApostas())
			return -1;
		else if (cenario.getQuantidadeDeApostas() == outroCenario.getQuantidadeDeApostas())
			if (cenario.getId() < outroCenario.getId())
				return -1;
		return 1;
	}
}
