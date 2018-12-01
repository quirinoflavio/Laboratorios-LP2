package lab3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Classe de testes da agenda
 * @author Flavio Farias
 *
 */
public class AgendaTest {
	
	private Agenda agenda;
	
	/**
	 * Before
	 */
	@Before
	public void inicializar() {
		agenda = new Agenda();
		
	}
	/**
	 * Inicia a agenda.
	 */
	@Test
	public void testIniciarAgenda() {
		assertNotNull(agenda);
	}
	
	/**
	 *Verifica se os contatos foram criados. 
	 */
	@Test
	public void testCadastrarContato() {
		assertEquals(true, agenda.cadastrarContato(1, "Flávio", "Roberto", "12345678"));
		assertEquals(true, agenda.cadastrarContato(2, "Flavio", "Roberto", "123456789"));
		
	}
	/**
	 * Verifica se ao receber uma posicao invalida, o programa realiza o cadastro.
	 */
	@Test
	public void testCadastroPosicaoInvalida() {
		assertEquals(false, agenda.cadastrarContato(0, "Contato", "Telebrás", "321654987"));
		assertEquals(false, agenda.cadastrarContato(101, "Telefone", "Microsoft", "123654987"));
	}
	
	/**
	 * Testa se a agenda substitui o contato.
	 */
	@Test
	public void testSubstituirContato() {
		assertEquals(true, agenda.cadastrarContato(1, "Flávio", "Roberto", "12345678"));
		assertEquals(true, agenda.cadastrarContato(1, "Victor", "Ferraz", "123456789"));
		assertEquals(agenda.exibirContato(1), "Victor Ferraz - 123456789\n");
	}
	
	/**
	 * Verifica se o listarContato da agenda retorna a String esperada.
	 */
	@Test
	public void testListarContato() {
		Agenda agenda2 = new Agenda();
		agenda2.cadastrarContato(2, "Flávio", "Roberto", "000000");
		agenda2.cadastrarContato(100, "Hugo", "Braga", "12345678");
		assertEquals(agenda2.listarContato(), "2 - Flávio Roberto\n100 - Hugo Braga\n"); 
	}
	
	/**
	 * Verifica se o exibirContato da agenda retorna a String esperada.
	 */
	@Test
	public void testExibirContato() {
		agenda.cadastrarContato(25, "Diego", "Costa", "12345678");
		assertEquals(agenda.exibirContato(25), "Diego Costa - 12345678\n");
	}
	
	

}
