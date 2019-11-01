package ufba.mata55.projetoIncremental;

/**Classe para objeto do tipo Produto e seus métodos relacionados
* @author Caroline da Silva Morais Alves
* @version 5
*/

public class Produto {
	private String nome;
	private float preco;
	private int codigo;
	
	public Produto(int codigo, String nome, float preco) {
		this.nome = nome;
		this.preco = preco;
		this.codigo= codigo;
	}
	public Produto(String nome, float preco) {
		this.nome = nome;
		this.preco = preco;
		this.codigo = 0;
	}

	/** Métodos gets and sets
	*/
	public String getNome() {
		return nome; 
	}

	public float getPreco() {
		return preco; 
	}

	public int getCodigo() {
		return codigo; 
	}

	public void setNome(String nome) {
		this.nome = nome; 
	}

	public void setPreco(float preco) {
		this.preco = preco; 
	}

	public void setQuant(int codigo) {
		this.codigo = codigo; 
	}

}


