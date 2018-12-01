package sistema;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCenario {

	private Cenario cenario, cenario2;
	private Aposta aposta, aposta2;

	/**
	 * Before utilizado em outros testes.
	 */
	@Before
	public void inicializa() {
		cenario2 = new Cenario("Hoje nao vai chover", 1);
		cenario2.cadastraAposta("Nome", 5550, "VAI ACONTECER");
		cenario2.cadastraAposta("Flavio", 1020, "N VAI ACONTECER");
		cenario2.setEstado(false);
	}

	/**
	 * Cria o cenario a partir da descricao.
	 */
	@Test
	public void criarCenarioValido() {
		cenario = new Cenario("Hoje vai chover", 2);
	}

	/**
	 * Teste criar cenario com descricao nula.
	 */
	@Test(expected = NullPointerException.class)
	public void criarCenarioDescricaoNula() {
		cenario = new Cenario(null, 0);
	}

	/**
	 * Testa criar cenario com descricao vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void criarCenarioDescricaoVazia() {
		cenario = new Cenario("", 1);
	}

	/**
	 * Testa criar cenario com descricao apenas com espacos.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void criarCenarioDescricaoEspacos() {
		cenario = new Cenario("    ", 1);
	}

	/**
	 * Testa o toString de Cenario.
	 */
	@Test
	public void cenarioToString() {
		cenario = new Cenario("Este lab foi feito no ultimo dia", 1);
		assertEquals(cenario.toString(), "Este lab foi feito no ultimo dia - Nao finalizado");
	}

	/**
	 * Testa se o exibeApostas gera a saida correta.
	 */
	@Test
	public void testExibeApostas() {
		assertEquals(cenario2.exibeApostas(), "Nome - R$55,50 - VAI ACONTECER\nFlavio - R$10,20 - N VAI ACONTECER\n");
	}

	/**
	 * Testa se retorna o valor correto para o total de apostas.
	 */
	@Test
	public void testGetValorTotalApostas() {
		assertTrue(cenario2.getValorTotalDeApostas() == 6570);
	}

	/**
	 * Testa se o metodo retorna o valor correto para quantidade de apostas.
	 */
	@Test
	public void testGetQuantidadeDeApostas() {
		assertTrue(cenario2.getQuantidadeDeApostas() == 2);
	}

	/**
	 * Verifica se o metodo retorna o valor correto para apostas perdedoras.
	 */
	@Test
	public void testCalculaApostasPerdedoras() {
		assertTrue(cenario2.calculaValorApostasPerdedoras() == 5550);
	}


}
