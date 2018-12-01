package sistema;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestController {

	private Controller controle, controle2;

	/**
	 * Before utilizado nos outros testes.
	 */
	@Before
	public void inicializa() {
		controle2 = new Controller(20, 0.2);
		controle2.cadastrarCenario("Hoje faltou energia na universidade");
		controle2.cadastrarCenario("O LCC2 esta vazio");
		controle2.cadastrarAposta(2, "Flavio", 6689, "N VAI ACONTECER");
		controle2.cadastrarAposta(2, "Didi", 654, "VAI ACONTECER");
		controle2.cadastrarCenario("Este cenario vai ser fechado sem nenhuma aposta");
		controle2.fecharAposta(3, true);
	}

	/**
	 * Inicia o controle normalmente.
	 */
	@Test
	public void testController() {
		controle = new Controller(50, 1.5);
	}

	/**
	 * Testa o controle com caixa no limite.
	 */
	@Test
	public void testControllerCaixaNoLimite() {
		controle = new Controller(0, 1.5);
	}

	/**
	 * Testa controle com caixa invalido.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testControllerCaixaInvalido() {
		controle = new Controller(-1, 1.5);
	}

	/**
	 * Testa controle cm a taxa no limite.
	 */
	@Test
	public void testControllerTaxaNoLimite() {
		controle = new Controller(50, 0);
	}

	/**
	 * Testa controle com taxa invalida.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testControllerTaxaInvalida() {
		controle = new Controller(50, -2);
	}

	/**
	 * Testa se o getCaixa retorna o valor correto.
	 */
	@Test
	public void testGetCaixa() {
		assertTrue(controle2.getCaixa() == 20);
	}

	/**
	 * Testa se o getTaxa retorna o valor correto.
	 */
	@Test
	public void testGetTaxa() {
		assertTrue(controle2.getTaxa() == 0.2);
	}

	/**
	 * Testa se o getCenario nao retorna erro para um cenario valido.
	 */
	@Test
	public void testGetCenarioValido() {
		controle2.getCenario(1);
	}

	/**
	 * Testa se o getCenario lanca excecao quando o cenario nao estiver cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetCenarioNaoCadastrado() {
		controle2.getCenario(5);
	}

	/**
	 * Testa se o getCenario lanca excecao para um cenario nao valido.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetCenarioInvalido() {
		controle2.getCenario(0);
	}

	/**
	 * Testa se cadastrar cenario funciona corretamente.
	 */
	@Test
	public void testCadastrarCenario() {
		assertTrue(controle2.cadastrarCenario("Bolsonaro vai ser presidente em 2018") == 4);
	}

	/**
	 * Testa cadastrarCenario para um cenario nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testCadastrarCenarioNulo() {
		controle2.cadastrarCenario(null);
	}

	/**
	 * Testa cadastrar cenario para um cenario vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarCenarioVazio() {
		controle2.cadastrarCenario("");
	}

	/**
	 * Testa exibir cenario para um cenario valido.
	 */
	@Test
	public void testExibirCenarioValido() {
		assertEquals(controle2.exibirCenario(2), "2 - O LCC2 esta vazio - Nao finalizado");
	}

	/**
	 * Testa exibir cenario para um cenario invalido.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testExibirCenarioInvalido() {
		controle2.exibirCenario(0);
	}

	/**
	 * Testa exibir cenario para um cenario nao cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testExibirCenarioNaoCadastrado() {
		controle2.exibirCenario(500);
	}

	/**
	 * Testa se exibir cenarios lista todos os cenarios corretamente.
	 */
	@Test
	public void testExibirCenarios() {
		assertEquals(controle2.exibirCenarios(),
				"Hoje faltou energia na universidade - Nao finalizado\nO LCC2 esta vazio - Nao finalizado\n"
						+ "Este cenario vai ser fechado sem nenhuma aposta - Finalizado (ocorreu)\n");
	}

	/**
	 * Testa se cadastrar uma aposta valida nao retorna nenhum erro.
	 */
	@Test
	public void testCadastrarApostaValida() {
		controle2.cadastrarAposta(2, "Flavio", 550, "VAI ACONTECER");
	}

	/**
	 * Testa se retorna erro ao cadastrar uma aposta com cenario invalido.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarApostaCenarioInvalido() {
		controle2.cadastrarAposta(-5, "Flavio", 550, "VAI ACONTECER");
	}

	/**
	 * Testa se retorna erro ao cadastrar uma aposta em um cenario nao cadastrado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarApostaCenarioNaoCadastrado() {
		controle2.cadastrarAposta(7, "Flavio", 550, "VAI ACONTECER");
	}

	/**
	 * Testa valorTotalDeApostas funciona corretamente.
	 */
	@Test
	public void testValorTotalDeApostas() {
		assertTrue(controle2.valorTotalDeApostas(2) == 7343);
	}

	/**
	 * Testa se totalDeApostas funciona corretamente.
	 */
	@Test
	public void testTotalDeApostas() {
		assertTrue(controle2.totalDeApostas(2) == 2);
	}

	/**
	 * Testa se exibeApostas funciona corretamente.
	 */
	@Test
	public void testExibeApostas() {
		assertEquals(controle2.exibeApostas(2), "Flavio - R$66,89 - N VAI ACONTECER\nDidi - R$6,54 - VAI ACONTECER\n");
	}

	/**
	 * Testa se fecharAposta atualiza o caixa ao fechar um cenario.
	 */
	@Test
	public void testFecharAposta() {
		controle2.fecharAposta(2, false);
		assertEquals(controle2.getCaixa(), 150);
	}

	/**
	 * Testa se retorna erro ao fechar um cenario ja fechado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testFecharApostaCenarioJaFechado() {
		controle2.fecharAposta(3, true);
	}

	/**
	 * Testa se o getCaixaCenario retorna o valor correto.
	 */
	@Test
	public void testGetCaixaCenario() {
		controle2.fecharAposta(2, false);
		assertEquals(controle2.getCaixaCenario(2), 130.0, 0.0001);
	}

	/**
	 * Testa se retorna erro ao tentar obter o caixa de um cenario ainda aberto.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetCaixaCenarioAindaAberto() {
		assertEquals(controle2.getCaixaCenario(2), 130.0, 0.0001);
	}

	/**
	 * Testa se o totalRateioCenario retorna o valor correto.
	 */
	@Test
	public void testGetTotalRateioCenario() {
		controle2.fecharAposta(2, false);
		assertEquals(controle2.getTotalRateioCenario(2), 524);
	}

	/**
	 * Testa se retorna erro ao tentar obter o total de rateio de um cenario ainda
	 * fechado.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetTotalRateioCenarioAindaAberto() {
		assertEquals(controle2.getTotalRateioCenario(2), 524);
	}

}
