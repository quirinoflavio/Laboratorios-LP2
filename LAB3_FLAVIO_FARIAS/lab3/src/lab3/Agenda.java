package lab3;

/**
 * Classe responsavel por gerenciar a agenda de contatos. Cadastrando, listando e exibindo os contatos.
 * 
 * @author Flavio Farias
 *
 */
public class Agenda {

	private Contato[] contato;
	
	/**
	 * Constroi a agenda de 100 contatos.
	 */
	public Agenda() {
		this.contato = new Contato[100];
	}
	
	/**
	 * Cadastra o contato ma agenda a partir dos argumentos posicao, nome, sobrenome e telefone.
	 * Caso o nome seja invalido, chama o IllegalArgumentException.
	 * 
	 * @param posicao posicao do contato na agenda.
	 * @param nome nome do contato.
	 * @param sobrenome sobrenome do contato.
	 * @param telefone telefone do contato.
	 * @return retorna true se o contato for criado e false caso nao.
	 */
	public boolean cadastrarContato(int posicao, String nome, String sobrenome, String telefone) {
		if (posicao <= 100 && posicao >= 1) {
			if (nome.trim().equals("") || nome == null || sobrenome.trim().equals("") 
				|| sobrenome == null || telefone.trim().equals("") || telefone == null) {
				throw new IllegalArgumentException();
			}
			contato[posicao-1] = new Contato(nome, sobrenome, telefone);
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Lista os contatos salvos na agenda. Os contatos sao concatenados numa variavel. No final, retorna a variavel.
	 * 
	 * @return retorna uma lista de contatos salvos na agenda.
	 */
	public String listarContato() {
		String listaDeContatos = "";
		for(int i=0;i<100; i++) {
			if (contato[i] != null) {
				listaDeContatos += (i+1) + " - " + contato[i].getNome() + "\n";
			}
		}
		return listaDeContatos;
	}
	
	/**
	 * Exibe o contato de acordo com a posicao.
	 * 
	 * @param posicao posicao do contato na agenda.
	 * @return retorna o toString do contato daquela posicao.
	 */
	public String exibirContato(int posicao) {
		if (contato[posicao-1] == null) {
			return "POSIÇÃO INVÁLIDA!\n";
		}
		return contato[posicao-1].toString() + "\n";
	}



}
