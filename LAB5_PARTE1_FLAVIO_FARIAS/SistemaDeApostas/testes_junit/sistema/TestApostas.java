package sistema;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestApostas {

	private Apostas aposta;

	// Teste com o nome do apostador

	/**
	 * Verifica se ao passar nome do apostador nulo lanca uma excecao.
	 */
	@Test(expected = NullPointerException.class)
	public void criarApostaNomeNull() {
		aposta = new Apostas(null, 2000, "VAI ACONTECER");
	}

	/**
	 * Verifica se ao passar nome do apostador vazio lanca uma excecao.
	 */
	@Test(expected = NullPointerException.class)
	public void criarApostaNomeVazio() {
		aposta = new Apostas("", 2000, "VAI ACONTECER");
	}

	/**
	 * Verifica se ao passar nome do apostador apenas com espacos lanca uma excecao.
	 */
	@Test(expected = NullPointerException.class)
	public void criarApostaNomeEspacos() {
		aposta = new Apostas("      ", 2000, "VAI ACONTECER");
	}
	// Testes com o valor da aposta

	/**
	 * Verifica se ao passar valor da aposta negativo lanca uma excecao.
	 */
	@Test(expected = NullPointerException.class)
	public void criarApostaValorNegativo() {
		aposta = new Apostas("Flavio", -250, "VAI ACONTECER");
	}

	/**
	 * Verifica se ao passar valor da aposta zero lanca uma excecao.
	 */
	@Test(expected = NullPointerException.class)
	public void criarApostaValorZero() {
		aposta = new Apostas("Flavio", 0, "VAI ACONTECER");
	}

	// Testes para a previsao

	/**
	 * Verifica se ao passar uma previsao nula lanca uma excecao.
	 */
	@Test(expected = NullPointerException.class)
	public void criarApostaPrevisaoNull() {
		aposta = new Apostas("Flavio", 2000, null);
	}

	/**
	 * Verifica se ao passsar uma previsao invalida lanca uma excecao.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void criarApostaPrevisaoInvalida() {
		aposta = new Apostas("Flavio", 2000, "ACHO QUE VAI ACONTECER");
	}

	/**
	 * Verifica se ao passar uma previsao vazia lanca uma excecao.
	 */
	@Test(expected = NullPointerException.class)
	public void criarApostaPrevisaoVazia() {
		aposta = new Apostas("Flavio", 2000, "");
	}

	/**
	 * Verifica se ao passar uma previsao apenas com espacos lanca uma excecao.
	 */
	@Test(expected = NullPointerException.class)
	public void criarApostaPrevisaoEspacos() {
		aposta = new Apostas("Flavio", 2000, "      ");
	}

	// Testes para outros metodos

	/**
	 * Verifica se o getValor retorna um valor correto.
	 */
	@Test
	public void testGetValor() {
		aposta = new Apostas("Flavio", 2000, "VAI ACONTECER");
		assertTrue(aposta.getValor() == 2000);
	}

	/**
	 * Veerifica se o getPrevisao retorna a previsao correta.
	 */
	@Test
	public void testGetPrevisao() {
		aposta = new Apostas("Flavio", 2000, "VAI ACONTECER");
		assertEquals(aposta.getPrevisao(), "VAI ACONTECER");
	}

	/**
	 * Verifica se o GetNomeApostador retorna o nome correto.
	 */
	@Test
	public void testGetNomeApostador() {
		aposta = new Apostas("Flavio", 2000, "VAI ACONTECER");
		assertEquals(aposta.getNomeApostador(), "Flavio");
	}

	/**
	 * Verifica se o toString retorna a string correta.
	 */
	@Test
	public void testToString() {
		aposta = new Apostas("Flavio", 19256, "VAI ACONTECER");
		assertEquals(aposta.toString(), "Flavio - R$192,56 - VAI ACONTECER");
	}

}