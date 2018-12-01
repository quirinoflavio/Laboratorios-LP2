package sistema;

public class CenarioBonus extends Cenario {
	
	private int bonus;

	/**
	 * Constroi o cenario bonus a partir da descricao e do bonus.
	 * 
	 * @param descricao
	 *            eh a descricao do cenario.
	 * @param bonus eh o bonus oferecido pelo cenario.
	 */
	public CenarioBonus(String descricao, int bonus) {
		super(descricao);
		verificaBonusValido(bonus);
		this.bonus = bonus;
	}
	
	/**
	 * Gera uma representacao textual do cenario bonus.
	 * 
	 * @return retorna a descricao, o estado e o bonus.
	 */
	@Override
	public String toString() {
		return super.toString() + " - " + "R$ " + String.format("%.2f", (this.bonus) / 100.0);
	}
	
	/**
	 * Calcula o rateio e adiciona o bonus.
	 */
	@Override
	public int calculaRateio(double taxa) {
		return super.calculaRateio(taxa) + this.bonus;
	}
	
	/**
	 * Verifica se o bonus passa eh valido.
	 * @param bonus eh o bonus do cenario.
	 */
	public void verificaBonusValido(int bonus) {
		if (bonus <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de cenario: Bonus invalido");
		}
	}
}
