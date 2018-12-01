package sistema;

import java.util.Comparator;

/**
 * Classe de estrategia de ordenacao. Tem o metodo abstract compare que sera
 * implementado pelas classes filhas
 * 
 * @author flaviorpqf
 *
 */
public abstract class EstrategiaOrdenacao implements Comparator<Cenario> {
	public abstract int compare(Cenario cenario, Cenario outraCenario);
}
