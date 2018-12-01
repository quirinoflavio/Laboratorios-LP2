package sistema;

public class ApostaAsseguradaValor extends Seguro {

	private int valor;
	private String tipo;
	
	/**
	 * Construtor da ApostaAsseguradaValor.
	 * @param valorAssegurado eh o valor a ser assegurado.
	 * @param id eh o identificador da aposta.
	 */
	public ApostaAsseguradaValor(int valorAssegurado, int id) {
		super(id);
		this.valor = valorAssegurado;
		this.tipo = "VALOR";
	}

	
	public double getSegurado() {
		return this.valor;
	}
	
	public String getTipo() {
		return this.tipo;
	}
	
	
 @Override
	public String toString() {
		return " - Assegurada (VALOR)" + " - R$" + String.format("%.2f", (this.valor) / 100.0);
	}
	
}
