package lab4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AlunoTest {

	private Aluno aluno, aluno2;
	
	@Before 
	public void inicializar() {
		aluno = new Aluno("2", "Flavio", "CC");
	}

	/**
	 * Teste para o toString de aluno.
	 */
	@Test
	public void testToString() {
		assertEquals(aluno.toString(), "2 - Flavio - CC");
	}

	/**
	 * Teste para getNome de aluno.
	 */
	@Test
	public void testGetNome() {
		assertEquals(aluno.getNome(), "Flavio");
	}
	
	/**
	 * Teste para criar aluno com nome vazio.
	 */
	@Test(expected = NullPointerException.class)
	public void testCriarAlunoInvalido(){
	        aluno2 = new Aluno ("   ", "Flavio", "CC");
	}
	
	/**
	 * Teste para criar aluno com matricula vazia.
	 */
	@Test(expected = NullPointerException.class)
	public void testCriarAlunoInvalido2(){
	        aluno2 = new Aluno ("2", "", "CC");
	}
	
	/**
	 * Teste para criar aluno com curso vazio.
	 */
	@Test(expected = NullPointerException.class)
	public void testCriarAlunoInvalido3(){
	        aluno2 = new Aluno ("2", "Flavio", "   ");
	}
	
	/**
	 * Teste para criar aluno com matricula nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testCriarAlunoInvalido4(){
	        aluno2 = new Aluno (null, "Flavio", "CC");
	}
	
	/**
	 * Teste para criar aluno com nome nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testCriarAlunoInvalido5(){
	        aluno2 = new Aluno ("2", null, "CC");
	}
	
	/**
	 * Teste para criar aluno com curso nulo
	 */
	@Test(expected = NullPointerException.class)
	public void testCriarAlunoInvalido6(){
	        aluno2 = new Aluno ("2", "Flavio", null);
	}
	
	
}
