package sistema;

import java.util.ArrayList;
import java.util.Iterator;

public class Controller {

	private ArrayList<Cenario> cenarios;
	private int caixa;
	private double taxa;

	/**
	 * Construtor da classe Controller. Constroi o controlador que gerencia o caixa,
	 * a taxa e os cenarios.
	 * 
	 * @param caixa
	 *            eh o valor inicial do caixa do sistema.
	 * @param taxa
	 *            eh a taxa cobrada sobre apostas.
	 */
	public Controller(int caixa, double taxa) {
		verificaCaixaValido(caixa);
		verificaTaxaValida(taxa);
		this.cenarios = new ArrayList<Cenario>();
		this.caixa = caixa;
		this.taxa = taxa;
	}

	/**
	 * Recupera o valor atual do caixa.
	 * 
	 * @return retorna um inteiro com o valor atual do caixa.
	 */
	public int getCaixa() {
		return this.caixa;
	}

	/**
	 * Recupera o valor da taxa.
	 * 
	 * @return retorna a taxa do tipo double.
	 */
	public double getTaxa() {
		return this.taxa;
	}

	/**
	 * Recupera um Cenario a partir de seu numero.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 * @return retorna um objeto do tipo Cenario.
	 */
	public Cenario getCenario(int cenario) {
		verificaConsultaCenario(cenario);
		return cenarios.get(cenario - 1);
	}

	/**
	 * Cadastra o cenario, criando um objeto com a descricao passada.
	 * 
	 * @param descricao
	 *            eh a descricao do cenario.
	 * @return retorna a posicao onde o cenario foi cadastrado.
	 */
	public int cadastrarCenario(String descricao) {
		Cenario cenario = new Cenario(descricao);
		cenarios.add(cenario);
		return cenarios.size();
	}

	/**
	 * Exibe a posicao mais o toString() do cenario.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 * @return retorna uma string contendo a posicao mais o to String() de cenario.
	 */
	public String exibirCenario(int cenario) {
		verificaConsultaCenario(cenario);
		return cenario + " - " + getCenario(cenario).toString();
	}

	/**
	 * Itera sobre o ArrayList de cenarios, concatenado o toString de cada cenario.
	 * Exibe toString() de todos os cenarios.
	 * 
	 * @return retorna uma string contendo todos os cenarios.
	 */
	public String exibirCenarios() {
		String todosCenarios = "";
		Iterator<Cenario> itr = cenarios.iterator();
		while (itr.hasNext()) {
			Cenario cenario = itr.next();
			todosCenarios += cenario.toString() + "\n";
		}
		return todosCenarios;
	}

	/**
	 * Cadastra a aposta no cenario. Antes, verifica se o cenario existe.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 * @param apostador
	 *            eh o nome do apostador.
	 * @param valor
	 *            eh o valor da aposta.
	 * @param previsao
	 *            eh a previsao sobre a aposta.
	 */
	public void cadastrarAposta(int cenario, String apostador, int valor, String previsao) {
		verificaApostaCenario(cenario);
		Apostas aposta = new Apostas(apostador, valor, previsao);
		getCenario(cenario).adicionaAposta(aposta);
	}

	/**
	 * Recupera o valor total das apostas sobre determinado cenario.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 * @return retorna o valor total das apostas sobre o cenario.
	 */
	public int valorTotalDeApostas(int cenario) {
		verificaCenarioValorTotal(cenario);
		return getCenario(cenario).getValorTotalDeApostas();
	}

	/**
	 * Recupera a quantidade de apostas em determinado cenario.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 * @return retorna um inteiro que representa a quantidade de apostas sobre
	 *         aquele cenario.
	 */
	public int totalDeApostas(int cenario) {
		verificaTotalApostas(cenario);
		return getCenario(cenario).getQuantidadeDeApostas();
	}

	/**
	 * Exibe todas as apostas de determinado cenario.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 * @return retorna uma string contendo as apostas do cenario.
	 */
	public String exibeApostas(int cenario) {
		return getCenario(cenario).exibeApostas();
	}

	/**
	 * Muda o estado do cenario para 'Finalizado (ocorreu)' ou 'Finalizado (n
	 * ocorreu)'.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 * @param ocorreu
	 *            boolean que representa se ocorreu ou nao.
	 */
	public void fecharAposta(int cenario, boolean ocorreu) {
		verificaFecharAposta(cenario);
		getCenario(cenario).setEstado(ocorreu);
		this.caixa += getCaixaCenario(cenario);
	}

	/**
	 * Recupera o valor que deve ser destinado ao caixa.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 * @return retorna o valor destiado ao caixa.
	 */
	public int getCaixaCenario(int cenario) {
		verificaGetCaixaCenario(cenario);
		return (int) (getCenario(cenario).calculaValorApostasPerdedoras() * getTaxa());
	}

	/**
	 * Recupera o valor total para rateio em determinado cenario.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 * @return retorna o valor
	 */
	public int getTotalRateioCenario(int cenario) {
		verificaRateioCenario(cenario);
		return getCenario(cenario).calculaValorApostasPerdedoras() - getCaixaCenario(cenario);

	}

	// Verfica parametros
	// Verificar cenario fechado para os outros metodos

	/**
	 * Verifica se o valor do caixa eh valido. So eh valido se for maior ou igual a
	 * zero. Lanca uma excecao se a for menor que zero.
	 * 
	 * @param caixa
	 *            eh o valor do caixa.
	 */
	public void verificaCaixaValido(int caixa) {
		if (caixa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		}
	}

	/**
	 * Verifica se a taxa eh valida. So eh valida se for maior ou igual a zero.
	 * Lanca uma excecao se a for menor que zero.
	 * 
	 * @param taxa
	 *            eh a taxa do sistema.
	 */
	public void verificaTaxaValida(double taxa) {
		if (taxa < 0) {
			throw new IllegalArgumentException("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		}
	}

	/**
	 * Verifica se o numero do cenario eh valido para consulta. So eh valido se for
	 * maior que zero e menor ou igual ao tamanho de cenarios.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 */
	public void verificaConsultaCenario(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario invalido");
		} else if (cenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta de cenario: Cenario nao cadastrado");
		}
	}

	/**
	 * Verifica se o numero do cenario eh valido para aposta. So eh valido se for
	 * maior que zero e menor ou igual ao tamanho de cenarios.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 */
	public void verificaApostaCenario(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario invalido");
		} else if (cenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro no cadastro de aposta: Cenario nao cadastrado");
		}
	}

	/**
	 * Verifica se o numero do cenario eh valido para calcular valor total. So eh
	 * valido se for maior que zero e menor ou igual ao tamanho de cenarios.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 */
	public void verificaCenarioValorTotal(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario invalido");
		} else if (cenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do valor total de apostas: Cenario nao cadastrado");
		}
	}

	/**
	 * Verifica se o numero do cenario eh valido para calcular total de apostas. So
	 * eh valido se for maior que zero e menor ou igual ao tamanho de cenarios.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 */
	public void verificaTotalApostas(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario invalido");
		} else if (cenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do total de apostas: Cenario nao cadastrado");
		}
	}

	/**
	 * Verifica se o numero do cenario eh valido para fechar aposta. So eh valido se
	 * for maior que zero e menor ou igual ao tamanho de cenarios, e se o cenario
	 * ainda estiver aberto.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 */
	public void verificaFecharAposta(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario invalido");
		} else if (cenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario nao cadastrado");
		} else if (getCenario(cenario).verificaCenarioFechado() == true) {
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");
		}
	}

	/**
	 * Verifica se o numero do cenario eh valido para recuperar o caixa. So eh
	 * valido se for maior que zero e menor ou igual ao tamanho de cenarios, e se o
	 * cenario ja estiver fechado.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 */
	public void verificaGetCaixaCenario(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario invalido");
		} else if (cenario > cenarios.size()) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario nao cadastrado");
		} else if (getCenario(cenario).verificaCenarioFechado() == false) {
			throw new IllegalArgumentException("Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		}
	}

	/**
	 * Verifica se o numero do cenario eh valido para calcular rateio. So eh valido
	 * se for maior que zero e menor ou igual ao tamanho de cenarios, e se o cenario
	 * ja estiver fechado.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 */
	public void verificaRateioCenario(int cenario) {
		if (cenario <= 0) {
			throw new IllegalArgumentException("Erro na consulta do total de rateio do cenario: Cenario invalido");
		} else if (cenario > cenarios.size()) {
			throw new IllegalArgumentException(
					"Erro na consulta do total de rateio do cenario: Cenario nao cadastrado");
		} else if (getCenario(cenario).verificaCenarioFechado() == false) {
			throw new IllegalArgumentException(
					"Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		}
	}

}
