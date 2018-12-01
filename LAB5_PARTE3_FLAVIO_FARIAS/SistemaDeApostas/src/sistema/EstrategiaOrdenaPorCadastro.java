package sistema;

/**
 * Subclasse de EstrategiaOrdenacao que compara cenarios pelo cadastro.
 * 
 * @author flaviorpqf
 *
 */
public class EstrategiaOrdenaPorCadastro extends EstrategiaOrdenacao {
	
	/**
	 * Compara dois cenarios pela ordem de cadastro.
	 */
	public int compare(Cenario cenario, Cenario outroCenario){
		if(cenario.getId() < outroCenario.getId())
			return -1;
		return 1;
  }
}
