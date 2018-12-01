package lab4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GrupoTest {

	Grupo grupo, grupo2;
	Aluno aluno2, aluno3;
	
	@Before
	public void inicializar() {
		grupo = new Grupo("CC");
		aluno2 = new Aluno("22", "Twtw", "TT");
		aluno3 = new Aluno("77", "SevenK", "SK");
		grupo.adicionarAluno(aluno2);
		grupo.adicionarAluno(aluno3);
	}

	/**
	 * Teste para getNomeGrupo.
	 */
	@Test
	public void testGetNomeGrupo() {
		assertEquals(grupo.getNomeGrupo(), "CC");
	}

	/**
	 * Teste para adicionar aluno no grupo.
	 */
	@Test
	public void testAdicionarAluno() {
		Aluno aluno = new Aluno("1", "Flavio", "CC");
		assertTrue(grupo.adicionarAluno(aluno));
	}
	/**
	 * Teste para imprimir aluno do grupo.
	 */
	@Test
	public void testImprimirAlunosGrupo() {
		assertEquals(grupo.imprimirAlunosGrupo(), "Alunos do grupo CC:\n* 22 - Twtw - TT\n* 77 - SevenK - SK\n");
	}

	/**
	 * Teste para criar um grupo sem nome.
	 */
	@Test(expected = NullPointerException.class)
	public void testCriarGrupoInvalido() {
		grupo2 = new Grupo("    ");
	}
	
	/**
	 * Teste para criar um grupo com nome nulo.
	 */
	@Test(expected = NullPointerException.class)
	public void testCriarGrupoInvalido2() {
		grupo2 = new Grupo(null);
	}
}
