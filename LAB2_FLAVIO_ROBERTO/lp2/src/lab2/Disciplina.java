package lab2;

import java.util.Arrays;

/**
 * Esta classe cria e administra uma disciplina.
 * 
 * @author Flavio Roberto - 117111444.
 *
 */
public class Disciplina {
	private String nome;
	private int horas;
	private double[] notas;
	private int[] pesos;
	private double media;

	/**
	 * Esse método construtor cria uma nova disciplina.
	 * 
	 * @param nome,
	 *            nome da disciplina.
	 */
	public Disciplina(String nome) {
		this.nome = nome;
		this.notas = new double[4];
		this.pesos = new int[0];
	}

	/**
	 * Esse construtor recebe além do nome, o número de notas do aluno.
	 * 
	 * @param nome,
	 *            nome do aluno.
	 * @param numNotas,
	 *            quantidade de notas.
	 */
	public Disciplina(String nome, int numNotas) {
		this.nome = nome;
		this.notas = new double[numNotas];
		this.pesos = new int[0];

	}

	/**
	 * Esse construtor recebe nome, número de notas e um array com o peso de cada
	 * nota.
	 * 
	 * @param nome,
	 *            nome da disciplina.
	 * @param numNotas,
	 *            número de notas da disciplina.
	 * @param array,
	 *            Array com os pesos das notas.
	 */
	public Disciplina(String nome, int numNotas, int array[]) {
		this.nome = nome;
		this.notas = new double[numNotas];
		this.pesos = array;

	}

	/**
	 * Esse método cadastra horas usadas pela disciplina.
	 * 
	 * @param horas,
	 *            quantidade de horas a serem acrescentadas.
	 */
	public void cadastraHoras(int horas) {
		this.horas += horas;
	}

	/**
	 * Esse método cadastra uma nova nota a disciplina.
	 * 
	 * @param nota,
	 *            Qual nota
	 * @param valorNota,
	 *            valor da nota.
	 */
	public void cadastraNota(int nota, double valorNota) {
		this.notas[nota - 1] = valorNota;
	}

	/**
	 * Esse método avalia e retorna se o aluno foi ou não aprovado. @return, true se
	 * aprovado, false se reprovado.
	 * 
	 * @return aprovado() retorna um booleano.
	 * @return MediaPonderada() media ponderada das notas.
	 * @return MediaAritmetica() media aritmetica das notas.
	 */
	public boolean aprovado() {
		if (pesos.length == 0) {
			return MediaAritmetica() >= 7;
		} else {
			return MediaPonderada() >= 7;
		}
	}

	/**
	 * Esse método informa o status da disciplina, nome, horas, média e as notas.
	 */
	public String toString() {
		return this.nome + " " + this.horas + " " + this.media + " " + Arrays.toString(notas);
	}

	/**
	 * Esse método foi criado adicionalmente para calcular a média ponderada, caso
	 * seja necessário.
	 * 
	 * @return media ponderada das notas.
	 */
	public double MediaPonderada() {
		double total = 0;
		for (int i = 0; i < notas.length; i++) {
			total += this.notas[i] * this.pesos[i];
		}
		this.media = total / 10;
		return this.media;
	}

	/**
	 * Esse método foi criado adicionalmente para calcular a média aritmetica,
	 * quando for necessário.
	 * 
	 * @return media aritmetica das notas.
	 */
	public double MediaAritmetica() {
		double total = 0;
		for (int i = 0; i < notas.length; i++) {
			total += notas[i];
		}
		this.media = (total / notas.length);
		return this.media;
	}

}