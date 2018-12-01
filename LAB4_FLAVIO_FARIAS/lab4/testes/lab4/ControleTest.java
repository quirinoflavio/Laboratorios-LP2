package lab4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ControleTest {

	Controle controle = new Controle();
	Aluno aluno = new Aluno("123", "Flavio", "CC");
	Grupo grupo = new Grupo("CC");
	
	
	@Before
	public void inicializar() {
		controle.cadastrarAluno("456", "Flavio", "CC");
		controle.criarGrupo("CC");
		controle.alocarAluno("456", "CC");
		controle.registrarAlunoQueResponde("456");
	}
	
	/**
	 * Verifica se retorna true ao cadastrar um aluno.
	 */
	@Test
	public void testCadastrarAluno() {
		assertTrue(controle.cadastrarAluno("117", "Hugo", "CC"));
	}

	/**
	 * Teste para cadastrar um aluno com campos vazios.
	 */
	@Test (expected = NullPointerException.class)
	public void testCadastrarAlunoInvalido() {
		controle.cadastrarAluno("", "", "");
	}
	
	/**
	 * Teste para cadastrar um aluno com campos nulos.
	 */
	@Test (expected = NullPointerException.class)
	public void testCadastrarAlunoInvalido2() {
		controle.cadastrarAluno(null, null, null);
	}
	
	/**
	 * testa o exibir aluno.
	 */
	@Test
	public void testExibirAluno() {
		assertEquals(controle.exibirAluno("456"), "456 - Flavio - CC\n");
	}

	/**
	 * Teste para exibir um aluno com a matricula vazia.
	 */
	@Test (expected = NullPointerException.class)
	public void testExibirAlunoInvalido() {
		controle.exibirAluno("");
	}
	
	/**
	 * Teste para exibir aluno com matricula nula.
	 */
	@Test (expected = NullPointerException.class)
	public void testExibirAlunoInvalido2() {
		controle.exibirAluno(null);
	}
	
	/**
	 * Teste para verificar se existe o aluno.
	 */
	@Test
	public void testExisteAluno() {
		assertTrue(controle.existeAluno("456"));
	}
	
	/**
	 * Teste para verificar se existe aluno com matricula vazia.
	 */
	@Test (expected = NullPointerException.class)
	public void testExisteAlunoInvalido() {
		controle.existeAluno("");
	}
	
	/**
	 * Teste para verificar se existe aluno com matricula nula.
	 */
	@Test (expected = NullPointerException.class)
	public void testExisteAlunoInvalido2() {
		controle.existeAluno(null);
	}

	/**
	 * Teste para criar grupo.
	 */
	@Test
	public void testCriarGrupo() {
		assertTrue(controle.criarGrupo("Computacao"));
	}
	
	/**
	 * Teste para criar grupo com nome vazio.
	 */
	@Test(expected = NullPointerException.class)
	public void testCriarGrupoInvalido() {
		controle.criarGrupo("");
	}
	
	/**
	 * Teste para criar grupo com nome nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testCriarGrupoInvalido2() {
		controle.criarGrupo(null);
	}

	/**
	 * Teste para alocar aluno.
	 */
	@Test
	public void testAlocarAlunos() {
		assertTrue(controle.alocarAluno("1", "CC"));
	}
	
	/**
	 * Teste para alocar aluno com os parametros vazios. 
	 */
	@Test (expected = NullPointerException.class)
	public void testAlocarAlunoInvalido() {
		controle.alocarAluno("", "");
	}
	
	/**
	 * Teste para alocar aluno com os parametros nulos.
	 */
	@Test (expected = NullPointerException.class)
	public void testAlocarAlunoInvalido2() {
		controle.alocarAluno(null, null);
	}

	/**
	 * Teste para verificar se existe o grupo.
	 */
	@Test
	public void testExisteGrupo() {
		assertTrue(controle.existeGrupo("CC"));
	}
	
	/**
	 * Teste para verificar se existe grupo com nome vazio.
	 */
	@Test (expected = NullPointerException.class)
	public void testExisteGrupoInvalido() {
		controle.existeGrupo("");
	}
	
	/**
	 * Teste para verificar se existe grupo com nome nulo.
	 */
	@Test (expected = NullPointerException.class)
	public void testexisteGrupoInvalido2() {
		controle.existeGrupo(null);
	}

	/**
	 * Teste para registrar aluno que responde.
	 */
	@Test
	public void testRegistrarAlunoQueRespode() {
		assertTrue(controle.registrarAlunoQueResponde("123"));
	}
	
	/**
	 * Teste para registrar aluno que responde com matricula vazia.
	 */
	@Test(expected = NullPointerException.class)
	public void testRegistrarAlunoQueRespodeInvalido() {
		controle.registrarAlunoQueResponde("");
	}
	
	/**
	 * Teste para registrar aluno que responde com matricula nula.
	 */
	@Test(expected = NullPointerException.class)
	public void testRegistrarAlunoQueRespodeInvalido2() {
		controle.registrarAlunoQueResponde(null);
	}

	/**
	 * Teste para imprimir alunos que respondem.
	 */
	@Test
	public void testImprimirAlunosQueRespondem() {
		assertEquals(controle.imprimirAlunosQueRespondem(), "Alunos:\n1. 456 - Flavio - CC\n");
	}
	

}
