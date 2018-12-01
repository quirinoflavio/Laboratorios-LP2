package sistema;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collections;

public class Controller {

	private ArrayList<Cenario> cenarios;
	private int caixa;
	private double taxa;
	private EstrategiaOrdenacao estrategia;

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
		verificaInicializarValido(caixa, "Caixa");
		verificaInicializarValido(taxa, "Taxa");
		this.cenarios = new ArrayList<Cenario>();
		this.caixa = caixa;
		this.taxa = taxa;
		this.estrategia = new EstrategiaOrdenaPorCadastro();
	}
 public ArrayList<Cenario> getArray(){
   return this.cenarios;
 }
 
 public void alterarOrdem(String tipo){
   switch(tipo.toLowerCase()){
     case "nome":
       setEstrategia(new EstrategiaOrdenaPorNome());
     		break;
     case "apostas":
       setEstrategia(new EstrategiaOrdenaQtdDeApostas());
       break;
     case "cadastro":
       setEstrategia(new EstrategiaOrdenaPorCadastro());
       break;
     default: 
    	 verificaAlterarOrdem(tipo);
     }
     Collections.sort(cenarios, this.estrategia);
 }
 
 	public void setEstrategia(EstrategiaOrdenacao estrategia){
 		this.estrategia = estrategia;
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
	 * Define o caixa. Antes, verifica se o caixa eh valido.
	 * 
	 * @param valor
	 *            eh o novo valor do caixa.
	 */
	public void setCaixa(int valor) {
		verificaSetCaixaValido(valor);
		this.caixa = valor;
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
	public Cenario getCenario(int cenarioId) {
		verificaCenarioConsulta(cenarioId, "cenario");
		for (Cenario cenario : this.cenarios){
		  if(cenario.getId() == cenarioId)
		    return cenario;
		}
		return null;
	}

	/**
	 * Cadastra o cenario, criando um objeto com a descricao passada.
	 * 
	 * @param descricao
	 *            eh a descricao do cenario.
	 * @return retorna a posicao onde o cenario foi cadastrado.
	 */
	public int cadastrarCenario(String descricao) {
		Cenario cenario = new Cenario(descricao, getQuantidadeDeCenarios()+1);
		cenarios.add(cenario);
		return getQuantidadeDeCenarios();
	}
  
  private int getQuantidadeDeCenarios(){
    return this.cenarios.size();
  }

	/**
	 * Cadastra o cenario com bonus, criando um objeto com a descricao e o bonus
	 * passados.
	 * 
	 * @param descricao
	 *            eh a descricao do cenario.
	 * @param bonus
	 *            eh o bonus oferecido pelo cenario
	 * @return retorna a posicao onde o cenario foi cadastrado.
	 */
	public int cadastrarCenario(String descricao, int bonus) {
		Cenario cenario = new CenarioBonus(descricao, bonus, getQuantidadeDeCenarios()+1);
		cenarios.add(cenario);
		setCaixa(this.caixa - bonus);
		return getQuantidadeDeCenarios();
	}

	/**
	 * Exibe a posicao mais o toString() do cenario.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 * @return retorna uma string contendo a posicao mais o to String() de cenario.
	 */
	public String exibirCenario(int cenarioId) {
		verificaCenarioConsulta(cenarioId, "cenario");
		Cenario cenario = getCenario(cenarioId);
		return cenario.getId() + " - " + cenario.toString();
	}

	public String exibirCenarioOrdenado(int indice){
		verificaCenarioConsulta(indice, "cenario ordenado");
		Cenario cenario = cenarios.get(indice-1);
		return cenario.getId() + " - " + cenario.toString();
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
			todosCenarios += cenario.toString() + System.lineSeparator();
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
		verificaCenarioCadastro(cenario, "aposta");
		getCenario(cenario).cadastraAposta(apostador, valor, previsao);
	}

	/**
	 * Recupera o valor total das apostas sobre determinado cenario.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 * @return retorna o valor total das apostas sobre o cenario.
	 */
	public int valorTotalDeApostas(int cenario) {
		verificaApostaConsulta(cenario, "valor total de apostas");
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
		verificaApostaConsulta(cenario, "total de apostas");
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
	 * ocorreu)'. Adiciona ao caixa o valor do cenario destinado ao caixa. Remove do
	 * caixa o valor do seguro.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 * @param ocorreu
	 *            boolean que representa se ocorreu ou nao.
	 */
	public void fecharAposta(int cenarioIndice, boolean ocorreu) {
		verificaFecharAposta(cenarioIndice);
		Cenario cenario = getCenario(cenarioIndice);
		cenario.setEstado(ocorreu);
		this.caixa += getCaixaCenario(cenarioIndice);
		this.caixa -= cenario.calculaValorAssegurado();
	}

	/**
	 * Recupera o valor que deve ser destinado ao caixa.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 * @return retorna o valor destiado ao caixa.
	 */
	public int getCaixaCenario(int cenario) {
		verificaCenarioValidoFechado(cenario, "caixa do cenario");
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
		verificaCenarioValidoFechado(cenario, "total de rateio do cenario");
		return getCenario(cenario).calculaRateio(getTaxa());

	}

	/**
	 * Cadastra a aposta assegurada por valor. Passa como identificador da aposta a
	 * posicao da aposta no arraylist.
	 * 
	 * @param cenario
	 *            eh o indice do cenario.
	 * @param apostador
	 *            eh o nome do apostador.
	 * @param valor
	 *            eh o valor da aposta.
	 * @param previsao
	 *            eh a previsao da aposta.
	 * @param valorSeguro
	 *            eh o valor do seguro.
	 * @param custo
	 *            eh o custo do seguro.
	 */
	public int cadastrarApostaSeguraValor(int cenario, String apostador, int valor, String previsao, int valorSeguro,
			int custo) {
		verificaCenarioCadastro(cenario, "aposta assegurada por valor");
		setCaixa(getCaixa() + custo);
		return getCenario(cenario).cadastraAposta(apostador, valor, previsao, valorSeguro);
	}

	/**
	 * Cadastra a aposta assegurada por taxa. Passa como identificador da aposta a
	 * posicao da aposta no arralist.
	 * 
	 * @param cenario
	 *            eh o indice do cenario.
	 * @param apostador
	 *            eh o nome do apostador.
	 * @param valor
	 *            eh o valor da aposta.
	 * @param previsao
	 *            eh a previsao da aposta.
	 * @param taxa
	 *            eh a taxa do seguro.
	 * @param custo
	 *            eh o custo do seguro.
	 */
	public int cadastrarApostaSeguraTaxa(int cenario, String apostador, int valor, String previsao, double taxa,
			int custo) {
		verificaCenarioCadastro(cenario, "aposta assegurada por taxa");
		setCaixa(getCaixa() + custo);
		return getCenario(cenario).cadastraAposta(apostador, valor, previsao, taxa);
	}

	/**
	 * Recupera o cenario passado e chama o metodo para alterar o seguro.
	 * 
	 * @param indiceCenario
	 *            eh o indice do cenario.
	 * @param apostaAssegurada
	 *            eh o indice da apostaAssegurada.
	 * @param valor
	 *            eh o valor do novo seguro.
	 * @return 
	 */
	public int alteraSeguroValor(int idCenario, int apostaAssegurada, int valor) {
		return getCenario(idCenario).alteraSeguroValor(apostaAssegurada, valor);
	}

	/**
	 * Recupera o cenario passado e cham o metodo para alterar o seguro.
	 * 
	 * @param indiceCenario
	 *            eh o indice do cenario.
	 * @param apostaAssegurada
	 *            eh o indice da apostaAssegurada.
	 * @param taxa
	 *            eh a taxa do novo seguro.
	 */
	public int alteraSeguroTaxa(int idCenario, int apostaAssegurada, double taxa) {
		return getCenario(idCenario).alteraSeguroTaxa(apostaAssegurada, taxa);
	}

	// Verfica parametros - a partir daqui apenas ha metodos para verificar parametros.

	private void verificaAlterarOrdem(String tipo) {
		if(tipo == null || tipo.trim().equals(""))
			throw new NullPointerException("Erro ao alterar ordem: Ordem nao pode ser vazia ou nula");
		else
			throw new IllegalArgumentException("Erro ao alterar ordem: Ordem invalida");
	}
	
	/**
	 * Verifica se o valor eh valido. So eh valido se for maior ou igual a zero.
	 * Lanca uma excecao se for menor que zero.
	 * 
	 * @param valor
	 *            eh o valor a ser verificado.
	 * @param whoami
	 *            eh quem esta verificando o parametro.
	 */
	public void verificaInicializarValido(double valor, String whoami) {
		if (valor < 0)
			throw new IllegalArgumentException("Erro na inicializacao: " + whoami + " nao pode ser inferior a 0");
	}

	/**
	 * Verifica se o valor do caixa eh maior ou igual do que o bonus para evitar um
	 * caixa negativo.
	 * 
	 * @param caixa
	 *            eh o valor do caixa
	 */
	public void verificaSetCaixaValido(int valor) {
		if (valor < 0)
			throw new IllegalArgumentException("Erro: Caixa negativo");

	}

	/**
	 * Verifica se o indice do cenario passado eh valido.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 * @param whoami
	 *            eh quem esta verificando o indice.
	 * @param whoami
	 *            eh quem esta verificando o parametro.
	 */
	public void verificaApostaConsulta(int cenario, String whoami) {
		if (cenario <= 0)
			throw new IllegalArgumentException("Erro na consulta do " + whoami + ": Cenario invalido");
		else if (cenario > cenarios.size())
			throw new IllegalArgumentException("Erro na consulta do " + whoami + ": Cenario nao cadastrado");
	}

	/**
	 * Verifica se o numero do cenario eh valido para consulta. So eh valido se for
	 * maior que zero e menor ou igual ao tamanho de cenarios.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 * @param whoami
	 *            eh quem esta verificando o parametro.
	 */
	public void verificaCenarioConsulta(int cenario, String whoami) {
		if (cenario <= 0)
			throw new IllegalArgumentException("Erro na consulta de " + whoami + ": Cenario invalido");
		else if (cenario > cenarios.size())
			throw new IllegalArgumentException("Erro na consulta de " + whoami + ": Cenario nao cadastrado");

	}

	/**
	 * Verifica se o numero do cenario eh valido. So eh valido se for maior que zero
	 * e menor ou igual ao tamanho de cenarios.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 * @param whoami
	 *            eh quem esta verificando o parametro.
	 * 
	 */
	public void verificaCenarioCadastro(int cenario, String whoami) {
		if (cenario <= 0)
			throw new IllegalArgumentException("Erro no cadastro de " + whoami + ": Cenario invalido");
		else if (cenario > cenarios.size())
			throw new IllegalArgumentException("Erro no cadastro de " + whoami + ": Cenario nao cadastrado");

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
		if (cenario <= 0)
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario invalido");
		else if (cenario > cenarios.size())
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario nao cadastrado");
		else if (getCenario(cenario).verificaCenarioFechado() == true)
			throw new IllegalArgumentException("Erro ao fechar aposta: Cenario ja esta fechado");

	}

	/**
	 * Verifica se o numero do cenario eh valido. So eh valido se for maior que zero
	 * e menor ou igual ao tamanho de cenarios. Verifica tambem se o cenario esta
	 * fechado.
	 * 
	 * @param cenario
	 *            eh o numero do cenario.
	 * @param whoami
	 *            eh quem esta verificando o parametro.
	 */
	public void verificaCenarioValidoFechado(int cenario, String whoami) {
		if (cenario <= 0)
			throw new IllegalArgumentException("Erro na consulta do " + whoami + ": Cenario invalido");
		else if (cenario > cenarios.size())
			throw new IllegalArgumentException("Erro na consulta do " + whoami + ": Cenario nao cadastrado");
		else if (getCenario(cenario).verificaCenarioFechado() == false)
			throw new IllegalArgumentException("Erro na consulta do " + whoami + ": Cenario ainda esta aberto");

	}

}
