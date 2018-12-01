package sistema;

/**
 * Subclasse de EstrategiaOrdenacao que compara cenarios por nome.
 * 
 * @author flaviorpqf
 *
 */
public class EstrategiaOrdenaPorNome extends EstrategiaOrdenacao{
    
	/**
	 * Compara dois cenarios pelo nome
	 */
	public int compare(Cenario cenario, Cenario outroCenario){
      if(cenario.toString().equals(outroCenario.toString()))
        if(cenario.getId() < outroCenario.getId())   
           return -1;
         else
           return 1;
      return cenario.toString().compareTo(outroCenario.toString());  
    }
}
