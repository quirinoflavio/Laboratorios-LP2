package lab4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Classe responsavel por controlar o sistema. Gerencia os alunos e os grupos.
 * @author flaviorpqf
 *
 */
public class Controle {
	
	private HashMap<String, Aluno> mapaMatriculaAlunos;
	private HashSet<Grupo> grupos;
	private ArrayList<Aluno> alunosQueRespondem;
	
	/**
	 * Contrutor da classe Controle. Gerencia o programa.
	 */
	public Controle() {
		this.mapaMatriculaAlunos = new HashMap<String, Aluno>();
		this.grupos = new HashSet<Grupo>();
		this.alunosQueRespondem = new ArrayList<Aluno>();
	}
	
	/**
	 * Cadastra o aluno a partir da matricula, nome e curso.
	 * verifica antes se o aluno ja esta cadastrado.
	 * @param matricula eh a matricula do aluno.
	 * @param nome eh o nome do aluno.
	 * @param curso eh o curso do aluno.
	 * @return se o aluno for cadastrado, retorna true, caso contrario, retorna false.
	 */
	public boolean cadastrarAluno(String matricula, String nome, String curso) {
		if (!this.mapaMatriculaAlunos.containsKey(matricula)) {
			Aluno aluno = new Aluno(matricula, nome, curso);
			this.mapaMatriculaAlunos.put(matricula, aluno);
			return true;
			}
		return false;
	}
	
	/**
	 * Gera uma representacao textual do aluno.
	 * @param matricula eh a matricula do aluno
	 * @return retorna uma string com as informacoes do aluno.
	 */
	public String exibirAluno(String matricula) {	
		return this.mapaMatriculaAlunos.get(matricula).toString() + "\n";
	}
	
	/**
	 * verifica se o aluno existe.
	 * @param matricula eh a matricula do aluno.
	 * @return retorna true se o aluno exista, e false caso nao.
	 */
	public boolean existeAluno(String matricula) {
		checaParametro(matricula);	
		return (this.mapaMatriculaAlunos.containsKey(matricula));
	}
	
	/**
	 * Gera o objeto Aluno a partir da matricula.
	 * @param matricula eh a matricula do aluno.
	 * @return retorna um objeto do tipo Aluno.
	 */
	public Aluno getAluno(String matricula) {	
		checaParametro(matricula);
		return this.mapaMatriculaAlunos.get(matricula); 
	}
	
	/**
	 * Cria um grupo a partir do nome.
	 * @param nomeGrupo eh o nome do grupo a ser criado.
	 * @return retorna um boolean confirmando ou nao a criacao do grupo.
	 */
	public boolean criarGrupo(String nomeGrupo) {
		if(!existeGrupo(nomeGrupo)) {
			return grupos.add(new Grupo(nomeGrupo));
		}
		return false;
	}

	/**
	 * Recupera o grupo a partir do nome passado como paramentro.
	 * @param nomeGrupo eh o nome do grupo.
	 * @return retorna um objeto do tipo Grupo.
	 */
	public Grupo getGrupo(String nomeGrupo) {
		Grupo saida = null;
		for (Grupo grupo : this.grupos) {
			if (grupo.getNomeGrupo().equalsIgnoreCase(nomeGrupo)) {
				saida = grupo;
			}
		}
		return saida;
	}
	
	/**
	 * Adiciona o aluno informado ao grupo passado como parametro.
	 * @param aluno eh o aluno.
	 * @param grupo eh o nome do grupo.
	 * @return retorna um boolean confirmando ou nao a acao.
	 */
	public boolean alocarAluno(String matricula, String grupo) {
		checaParametro(matricula);
		checaParametro(grupo);
		for (Grupo g : this.grupos) {
			if (grupo.toLowerCase().equalsIgnoreCase(g.getNomeGrupo().toLowerCase())){
				return g.adicionarAluno(getAluno(matricula));
			}
		}
		return false;
	}	
	
	/**
	 * Verifica se o grupo passado como parametro existe.
	 * @param grupo eh o nome do grupo.
	 * @return retorna um boolean confirmando se o grupo existe ou nao.
	 */
	public boolean existeGrupo(String grupo) {
		checaParametro(grupo);	
		for (Grupo g : this.grupos) {
			if (grupo.toLowerCase().equals(g.getNomeGrupo().toLowerCase())){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Gera uma string com os alunos do grupo passado como parametro.
	 * @param grupo eh o nome do grupo.
	 * @return retorna a string com os alunos do grupo.
	 */
	public String imprimirGrupo(String nomeGrupo) {
		return getGrupo(nomeGrupo).imprimirAlunosGrupo();
	}
	
	/**
	 * Registra no arraylist os alunos que respodem.
	 * @param aluno eh o aluno a ser registrado.
	 * @return retorna true ou false para a acao.
	 */
	public boolean registrarAlunoQueResponde(String matricula) {
		return alunosQueRespondem.add(getAluno(matricula));
	}
	
	/**
	 * Gera uma string para os alunos que respoderam no quadro, na ordem do registro.
	 * @return retorna a string contendo os alunos que responderam no quadro.
	 */
	public String imprimirAlunosQueRespondem() {
		String saida = "Alunos:\n";
		for (Aluno aluno : alunosQueRespondem) {
			saida += (alunosQueRespondem.indexOf(aluno)+1) + ". " + aluno.toString()+ "\n";
		}
		return saida;
	}
	
	/**
	 * Checa se o parametro passado eh vazio ou nulo.
	 * @param parametro eh o parametro a ser verificado.
	 */
	public void checaParametro(String parametro) {
		if(parametro.trim().equals("") || parametro == null ) {
			throw new NullPointerException("Parâmetro nulo ou vazio.");
		}
	}
}
