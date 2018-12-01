package lab3;
import org.junit.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Classe de testes para o Contato.
 * 
 * @author Flavio Farias
 *
 */
public class ContatoTest {

	/**
	 * Cria um contato e verifica se as informacoes estao corretas.
	 */
	@Test
	public void testCriaContato() {
		Contato contato = new Contato("Flávio", "Roberto", "12345678");
		assertEquals("Flávio Roberto - 12345678", contato.toString());
	}
	
	/**
	 * Cria dois contatos e verifica se ambos sao iguais apenas pelos nomes.
	 */
	@Test
	public void testContatosIguais() {
		Contato contato1 = new Contato("Flávio", "Roberto", "12345678");
		Contato contato2 = new Contato("Flávio", "Roberto", "87654321");
		assertTrue(contato1.equals(contato2));

	}
	
	/**
	 * Verifica se os contatos sao diferentes.
	 */
	@Test
	public void testContatosDiferentes1() {
		Contato contato3 = new Contato("Hugo", "Cabret", "321456987");
		Contato contato4 = new Contato("Mad", "Max", "987654321");
		assertFalse(contato3.equals(contato4));
	}
	
	/**
	 * Verifica se os contatos sao diferentes, mesmo tendo o mesmo primeiro nome.
	 */
	@Test	
	public void testContatosDiferentes2() {
		Contato contato3 = new Contato("Hugo", "Max", "987654321");
		Contato contato4 = new Contato("Hugo", "Cabret", "987654321");
		assertFalse(contato3.equals(contato4));
	}
	
}