package lab4;

/**
 * Classe que representa o aluno.
 * @author flaviorpqf
 *
 */
public class Aluno {
	private String matricula, nome, curso;
	
	/**
	 * construtor do aluno.
	 * @param matricula eh a matricula do aluno.
	 * @param nome eh o nome do aluno.
	 * @param curso eh o curso do aluno.
	 */
	public Aluno(String matricula, String nome, String curso) {
		checaParametros(matricula, nome, curso);
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}

	/**
	 * Gera uma representacao textual do aluno
	 * @return retorna uma string com  a matricula, nome e curso do aluno.
	 */
	@Override
	public String toString() {
		return this.matricula+ " - " + this.nome + " - " + this.curso;
		
	}
	/**
	 * Gera o nome do aluno.
	 * @return retorna uma string com o nome do aluno.
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Verifica se o nome, a matricula e o curso passados como paramentro 
	 * sao nulos ou vazios.
	 * @param matricula eh a matricula a ser verificada.
	 * @param nome eh o nome a ser verificado.
	 * @param curso eh o curso a ser verificado.
	 */
	public void checaParametros(String matricula, String nome, String curso) {
		if(matricula.trim().equals("") || matricula == null) {
			throw new NullPointerException("Matricula vazia ou nula.");
		}
		else if (nome.trim().equals("") || nome == null) {
			throw new NullPointerException("Nome vazio ou nulo.");
		}
		else if (curso.trim().equals("") || curso == null) {
			throw new NullPointerException("Curso vazio ou nulo.");
		}
	}
}
		

