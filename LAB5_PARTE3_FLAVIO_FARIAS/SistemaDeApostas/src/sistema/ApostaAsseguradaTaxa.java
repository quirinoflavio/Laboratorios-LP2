package sistema;

public class ApostaAsseguradaTaxa extends Seguro{

	private double taxa;
	private String tipo;
	
	
	/**
	 * Construtor da ApostaAsseguradaTaxa.
	 * @param taxaAssegurada eh a taxa a ser  assegurada.
	 * @param id eh o identificador da aposta.
	 */
	public ApostaAsseguradaTaxa(double taxaAssegurada, int id) {
		super(id);
		this.taxa = taxaAssegurada;
		this.tipo = "TAXA";
	}


	public double getSegurado() {
		return this.taxa;
	}
	
	
	public String getTipo() {
		return this.tipo;
	}

	@Override
	public String toString() {
		return "Assegurada (TAXA)";
	}
}
