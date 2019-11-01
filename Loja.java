package ufba.mata55.projetoIncremental;

import java.util.ArrayList;

/**Classe para objeto do tipo Loja e seus métodos relacionados
* @author Caroline da Silva Morais Alves
* @version 5
*/

public class Loja {
	private ArrayList<Pessoa> cadastroPessoas;
	private ArrayList<Produto> cadastroProdutos;
	private static int identificadorCadastroPessoas;
	
	public Loja() {
		this.cadastroPessoas = new ArrayList<Pessoa>();
		this.cadastroProdutos = new ArrayList<Produto>();
	}
	
	/**Método para contabilizar a quantidade de cadastros e dar entrada no número 
	 * identificador do cadastro atual de pessoa
	 * @param pessoa
	 */
	private void identificador(Pessoa pessoa) {
		setIdentificadorCadastroPessoas(cadastroPessoas.size());
		pessoa.setIdentificador(getIdentificadorCadastroPessoas());
	}
	
	/**Método para adicionar pessoas no ArrayList
	 * e chama método para atualizar identificador
	 * @param pessoa
	 * @return
	 */
	public boolean addPessoa(Pessoa pessoa) {
		if (this.cadastroPessoas.add(pessoa)) {
			identificador(pessoa);
			return true; }
		else
			return false;
	}
	
	/**Método para adicionar produtos no ArrayList
	 * 
	 * @param produto
	 * @return
	 */
	public boolean addProduto(Produto produto) {
		if (this.cadastroProdutos.add(produto))
			return true;
		else
			return false;
	}
	
	/**Métodos gets e sets
	 * 
	 */
	public ArrayList<Pessoa> getCadastroPessoas() {
		return cadastroPessoas;
	}

	public ArrayList<Produto> getCadastroProdutos() {
		return cadastroProdutos;
	}
	
	public static int getIdentificadorCadastroPessoas() {
		return identificadorCadastroPessoas;
	}

	public void setCadastroPessoas(ArrayList<Pessoa> cadastroPessoas) {
		this.cadastroPessoas = cadastroPessoas;
	}

	public void setCadastroProdutos(ArrayList<Produto> cadastroProdutos) {
		this.cadastroProdutos = cadastroProdutos;
	}
	
	public static void setIdentificadorCadastroPessoas(int identificadorCadastroPessoas) {
		Loja.identificadorCadastroPessoas = identificadorCadastroPessoas;
	}

}
