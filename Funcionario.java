package ufba.mata55.projetoIncremental;

/**Classe para objeto do tipo Funcionario que herda do tipo Pessoa e seus métodos relacionados
* @author Caroline da Silva Morais Alves
* @version 5
*/

public class Funcionario extends Pessoa{
	private String[] qualidades;
	private final int quantidadeQualidades = 5;
	
	public Funcionario(String nome, String cpf, String data, String sexo, String telefone, 
			TipoPessoa tipo) {
		super(nome, cpf, data, sexo, telefone, tipo);
		this.qualidades = new String[quantidadeQualidades];
	}
	
	public Funcionario(String nome, String cpf, TipoPessoa tipo) {
		super(nome, cpf, tipo);
		this.qualidades = new String[quantidadeQualidades];
		
	}
	
	/**Método para a inserção de qualidades para o tipo funcionário
	 * o método insere a qualidade no indice indicado(n) para a posição do vetor
	* @param qualidade String
	* @param n int
	**/
	public void inserirQualidade(String qualidade, int n) {
		if (n < this.qualidades.length) {
			this.qualidades[n] = qualidade; }
		else {
			System.out.println("Posição maior do que o limite permitido"); }
	}
	
	/**Métodos para a inserção de qualidades para o tipo funcionário
	 * insere a qualidade no proximo espaço vazio, caso não haja espaço vazio 
	 * insere na última posição substituindo a qualidade na posição
	* @param qualidade String
	**/
	public void inserirQualidade(String qualidade) {
		int i = 0;
		while ((this.qualidades[i] != null) && i < (this.qualidades.length-1)) {
			i++; } //procura a posição para ser inserida a qualidade
				
		this.qualidades[i] = qualidade;
	}

	/**Método para exibir o vetor de qualidades na ordem original do vetor
	**/
	public void imprimirQualidades() {
		for (int i = 0; i < this.qualidades.length; i++) {
			System.out.println(qualidades[i]);}
	}
	
	/**Método para exibir o vetor de qualidades na ordem do vetor
	 * @param vetor String
	**/
	public void imprimirQualidades(String[] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			System.out.println(vetor[i]);}
	}
	
	/**Método para exibir o vetor de qualidades em ordem alfabética
	**/
	public void ImprimirQualidadesAlf() {
		String[] ordenado; 
		ordenado = new String[quantidadeQualidades];
		int min;
		String aux;
		
		// Copia o vetor qualidades para o vetor ordenado		
		for (int i = 0; i < (this.qualidades.length); i++) {
			ordenado[i] = qualidades[i]; }
		// Ordena o vetor ordenado
		for (int i = 0; i < (ordenado.length-1); i++) {
			min = i;
			for (int j = (i+1); j < (ordenado.length); j++) {
				if (ordenado[j].compareTo(ordenado[i]) < 0) {
					min = j; }
			}	
			if (ordenado[i].compareTo(ordenado[min]) != 0) {
				aux = ordenado[i];
				ordenado[i] = ordenado[min];
				ordenado[min] = aux; }
		}
		
		imprimirQualidades(ordenado);
	}
	
	/**Método para zerar o vetor qualidade
	**/
	public void zerarQualidades() {
		for (int i = 0; i < (this.qualidades.length); i++) {
			qualidades[i] = null; }
	}
	
	/**Métodos gets e sets
	 * 
	 */
	public String[] getQualidades() {
		return qualidades;
	}

	public void setQualidades(String[] qualidades) {
		this.qualidades = qualidades;
	}
}
