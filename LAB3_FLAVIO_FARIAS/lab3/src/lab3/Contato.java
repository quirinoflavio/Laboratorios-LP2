package lab3;

/**
 * Classe contato, responsavel por construir e fornecer dados do contato.
 * 
 * @author Flavio Farias
 *
 */
public class Contato {
	
	private String nome;
	private String sobrenome;
	private String telefone;
	
	/**
	 * Constroi o contato a partir do nome, sobrenome e telefone.
	 * 
	 * @param nome eh nome do contato
	 * @param sobrenome eh sobrenome do contato
	 * @param telefone eh o telefone do contato
	 */
	public Contato(String nome, String sobrenome, String telefone) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.telefone = telefone;
	}


	/**
	 * Retorna o nome do contato.
	 * 
	 * @return retorna o nome + sobrenome.
	 */
	public String getNome() {
		return this.nome + " " + this.sobrenome;
	}

	/**
	 * Retorna uma representacao textual do contato do tipo nome + sobrenome + telefone.
	 * 
	 * @return retorna o nome, sobrenome e telefone.
	 */
	public String toString() {
		return this.nome + " " + this.sobrenome + " - " + this.telefone;
	}   

	/**
	 * hashCode
	 */
	 @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((sobrenome == null) ? 0 : sobrenome.hashCode());
		return result;
	}


	 /**
	  * Sobreescreve o metodo equals para que dois contatos 
	  * sejam iguais se os nomes forem iguais.
	  */
	 @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contato other = (Contato) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sobrenome == null) {
			if (other.sobrenome != null)
				return false;
		} else if (!sobrenome.equals(other.sobrenome))
			return false;
		return true;
	}
}




