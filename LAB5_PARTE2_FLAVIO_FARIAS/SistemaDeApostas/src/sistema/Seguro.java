package sistema;

public abstract class Seguro {

	/**
	 * Eh o idenficador unico que cada aposta assegurada tem.
	 */
	private int id;
	
	/**
	 * Construtor da superclasse Seguro que armazena o id da aposta assegurada.
	 * @param id eh o identificador unico da aposta assegurada.
	 */
	public Seguro(int id) {
		this.id = id;
	}
	
	/**
	 * Metodo que deve retornar o valor ou taxa assegurado na aposta.
	 * @return retorna o valor ou taxa assegurado na aposta.
	 */
	public abstract double getSegurado();
	
	/**
	 * Metodo que deve retornar o tipo da aposta.
	 * @return retorna o tipo da aposta.
	 */
	public abstract String getTipo();
	
	/**
	 * Metodo que retorna o id da aposta assegurada.
	 * @return retorna o identificador da aposta.
	 */
	public int getId() {
		return this.id;
	}
	
	public abstract String toString();

}

