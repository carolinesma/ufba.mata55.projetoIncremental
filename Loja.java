package ufba.mata55.projetoIncremental;

import java.util.ArrayList;
import java.util.Iterator;

import ufba.mata55.projetoIncremental.Pessoa.TipoPessoa;

/**Classe para objeto do tipo Loja e seus m�todos relacionados
* @author Caroline da Silva Morais Alves
* @version 6
*/

public class Loja {
	private ArrayList<Pessoa> cadastroPessoas;
	private ArrayList<Produto> cadastroProdutos;
	private static int identificadorCadastroPessoas;
	
	public Loja() {
		this.cadastroPessoas = new ArrayList<Pessoa>();
		this.cadastroProdutos = new ArrayList<Produto>();
	}
	
	/**M�todo para contabilizar a quantidade de cadastros e dar entrada no n�mero 
	 * identificador do cadastro atual de pessoa
	 * @param pessoa
	 */
	private void identificador(Pessoa pessoa) {
		setIdentificadorCadastroPessoas(cadastroPessoas.size());
		pessoa.setIdentificador(getIdentificadorCadastroPessoas());
	}
	
	/**M�todo para adicionar pessoas no ArrayList
	 * e chama m�todo para atualizar identificador
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
	
	/**M�todo para adicionar produtos no ArrayList
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
	
	/**
	 * M�todo para buscar um produto pelo c�digo na lista de cadastro
	 * @param codigo
	 * @return
	 */
	public Produto buscaProduto(int codigo) {
		Iterator<Produto> iterator = cadastroProdutos.iterator();
		Produto produto = new Produto(0,"",0);//inicializa produto para a compara��o do codigo na entrada do la�o
		
		while ((iterator.hasNext())&&(produto.getCodigo()!=codigo)) {
			produto = iterator.next(); }
		return produto;
	}
	
	/**
	 * M�todo para buscar e retornar um funcion�rio na loja por nome
	 * @param nome
	 * @return
	 */
	public Funcionario buscaFuncionarioPorNome(String nome) {
		Funcionario funcionarioEncontrado = null;
		Pessoa pessoa = null;
		Iterator<Pessoa> iterator = cadastroPessoas.iterator();
		
		while (iterator.hasNext()) {
			pessoa = iterator.next(); 
			if((pessoa.getNome().equals(nome))&&(pessoa.getTipo().equals(TipoPessoa.FUNCIONARIO))){
				funcionarioEncontrado = (Funcionario) pessoa;}
		}
		
		if(funcionarioEncontrado==null) {
			System.out.println("Funcionario n�o encontrado"); }
		
		return funcionarioEncontrado;
	}
	
	/**
	 * M�todo para buscar e retornar uma pessoa por cpf
	 * @param cpf
	 * @return
	 */
	public Pessoa buscaPessoaCpf(String cpf) {
		Iterator<Pessoa> iterator = cadastroPessoas.iterator();
		Pessoa pessoa = iterator.next();
		
		while ((iterator.hasNext())&&(pessoa.getCpf().equals(cpf))) {
			pessoa = iterator.next(); }
		
		if(pessoa.getCpf().equals(cpf))
			return pessoa;
		else return pessoa = null;
	}
	
	/**
	 * M�todo auxiliar para visualiza��o dos nomes de funcion�rios cadastrados
	 */
	public void listaFuncionarios() {
		Iterator<Pessoa> iterator = cadastroPessoas.iterator();
		System.out.print("(Funcionarios: ");		
		
		while (iterator.hasNext()) {
			Pessoa pessoa = iterator.next();
			if(pessoa.getTipo()!=TipoPessoa.CLIENTE) {
				System.out.print(pessoa.getNome()+",");} 
		}
		System.out.println(")");
	}
	
	/**
	 * M�todo para exibir sal�rios atualizados com as cosmiss�es para cada funcion�rio
	 * @param loja
	 */
	public void imprimeSalarios(Loja loja) {
		System.out.println("Salarios com comiss�es");
		Iterator<Pessoa> iterator = loja.getCadastroPessoas().iterator();		
		
		while (iterator.hasNext()) {
			Pessoa funcionario = iterator.next();
			if(funcionario.getTipo()!=TipoPessoa.CLIENTE) {
				System.out.println(funcionario.getNome()+"-"+((Funcionario) funcionario).getCargo()+"-"+
						((Funcionario) funcionario).calculaSalario()+"R$");} 
		}
	}
	
	/**
	 * M�todo auxiliar para visualiza��o dos produtos cadastrados
	 */
	public void imprimeProduto() {
		Iterator<Produto> iterator = cadastroProdutos.iterator();
		
		while (iterator.hasNext()) {
			Produto produto = iterator.next();
			System.out.println(produto.getCodigo()+" - "+produto.getNome());}
	}
	
	
	/*******M�todos gets e sets**********/
	
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
