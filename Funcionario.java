package ufba.mata55.projetoIncremental;

/**Classe abstrata Funcionario 
* @author Caroline da Silva Morais Alves
* @version 6
*/

public abstract class Funcionario extends Pessoa{
	private String[] qualidades;
	private final int quantidadeQualidades = 5;
	private float vendaMensal;
	private String cargo;
	
	public Funcionario(String nome, String cpf, String data, String sexo, String telefone, 
			TipoPessoa tipo) {
		super(nome, cpf, data, sexo, telefone, tipo);
		this.qualidades = new String[quantidadeQualidades];
		this.vendaMensal = 0.0F;
	}
	
	public Funcionario(String nome, String cpf, TipoPessoa tipo) {
		super(nome, cpf, tipo);
		this.qualidades = new String[quantidadeQualidades];
		this.vendaMensal = 0.0F;
		
	}
	
	/*************M�todos para o c�lculo de Sal�rio**************/
	
	/**M�todo abstrato para o calculo de sal�rio das classes filhas
	 * 
	 */
	public abstract float calculaSalario();
	
	/**
	 * M�todo que faz o c�lculo da soma total de vendas por um dado funcion�rio 
	 * para auxiliar no c�lculo do sal�rio
	 * @param valorVenda
	 */
	public void somaVendaMensal(float valorVenda) {
		this.vendaMensal+=valorVenda;
		setVendaMensal(vendaMensal);
	}
	
	/**
	 * M�todo auxiliar para para fazer o calculo da vendaMensal apenas para objetos da Classe
	 * Gerente e Vendedor
	 * @param funcionario
	 * @param valorVenda
	 */
	public void comissao(Funcionario funcionario, float valorVenda) {
		if ((funcionario instanceof Vendedor)||(funcionario instanceof Gerente)) {
			somaVendaMensal(valorVenda);
		}
	}
	
	/*********M�todos relacionados ao parametro qualidade*********************/
	
	/**M�todo para a inser��o de qualidades para o tipo funcion�rio
	* o m�todo insere a qualidade no indice indicado(n) para a posi��o do vetor
	* @param qualidade String
	* @param n int
	**/
	public void inserirQualidade(String qualidade, int n) {
		if (n < this.qualidades.length) {
			this.qualidades[n] = qualidade; }
		else {
			System.out.println("Posi��o maior do que o limite permitido"); }
	}
	
	/**M�todos para a inser��o de qualidades para o tipo funcion�rio
	 * insere a qualidade no proximo espa�o vazio, caso n�o haja espa�o vazio 
	 * insere na �ltima posi��o substituindo a qualidade na posi��o
	* @param qualidade String
	**/
	public void inserirQualidade(String qualidade) {
		int i = 0;
		while ((this.qualidades[i] != null) && i < (this.qualidades.length-1)) {
			i++; } //procura a posi��o para ser inserida a qualidade
				
		this.qualidades[i] = qualidade;
	}

	/**M�todo para exibir o vetor de qualidades na ordem original do vetor
	**/
	public void imprimirQualidades() {
		for (int i = 0; i < this.qualidades.length; i++) {
			System.out.println(qualidades[i]);}
	}
	
	/**M�todo para exibir o vetor de qualidades na ordem do vetor
	 * @param vetor String
	**/
	public void imprimirQualidades(String[] vetor) {
		for (int i = 0; i < vetor.length; i++) {
			System.out.println(vetor[i]);}
	}
	
	/**M�todo para exibir o vetor de qualidades em ordem alfab�tica
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
	
	/**M�todo para zerar o vetor qualidade
	**/
	public void zerarQualidades() {
		for (int i = 0; i < (this.qualidades.length); i++) {
			qualidades[i] = null; }
	}
	
	/*********** M�todos gets e sets ********8******/
	
	public String[] getQualidades() {
		return qualidades;
	}

	public void setQualidades(String[] qualidades) {
		this.qualidades = qualidades;
	}

	public int getQuantidadeQualidades() {
		return quantidadeQualidades;
	}

	public float getVendaMensal() {
		return vendaMensal;
	}

	public void setVendaMensal(float vendaMensal) {
		this.vendaMensal = vendaMensal;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
}
