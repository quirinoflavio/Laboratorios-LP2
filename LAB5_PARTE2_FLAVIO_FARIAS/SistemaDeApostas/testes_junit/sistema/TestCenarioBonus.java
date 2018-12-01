package sistema;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCenarioBonus {

	private CenarioBonus cenario, cenario2;
	private Aposta aposta, aposta2;
	
	/**
	 * Cria o cenario com bonus valido.
	 * Nao espera nenhum erro.
	 */
	@Test
	public void criarCenarioBonusValido() {
		cenario = new CenarioBonus("Hoje nao vai chover", 50);
	}

	/**
	 * Teste criar cenario com bonus nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void criarCenarioBonusZero() {
		cenario = new CenarioBonus("45 vai ser um dos numeros sorteados na mega-sena", 0);
	}



}
