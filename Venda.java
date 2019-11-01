package ufba.mata55.projetoIncremental;

import java.util.ArrayList;
import java.util.Iterator;

import ufba.mata55.projetoIncremental.Pessoa.TipoPessoa;

/**Classe para objeto do tipo Venda e seus métodos relacionados
* @author Caroline da Silva Morais Alves
* @version 5
*/

public class Venda {
	private String data;
	private ArrayList<ItemVenda> itens;
	private Pessoa cliente; 
	private Pessoa funcionario;

	public Venda(String data, Pessoa funcionario, Pessoa cliente) {
		this.data = data;
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.itens = new ArrayList<ItemVenda>();
	}
	
	public Venda(String data, Pessoa funcionario, Pessoa cliente, String cpf, String nome, 
			TipoPessoa tipo) {
		this.data = data;
		this.cliente = new Pessoa(nome, cpf, tipo);
		this.funcionario = funcionario;
		this.itens = new ArrayList<ItemVenda>();
	}
	
	/**Método para adicionar itens na lista vendas em uma compra verificando a quantidade
	 * retorna verificação de sucesso de inserção
	 * @param Produto produto, int quantidade
	 **/
	public boolean addItem (Produto produto, int quantidade) {
		if(quantidade>0) {
			itens.add(new ItemVenda(produto, quantidade)); 
			return true; }
		else {
			System.out.println("Erro no valor quantidade");
			return false; }
	}
	
	/**Método para adicionar itens sem especificação de quantidade
	 * @param Produto produto
	 **/	
	public void addItem (Produto produto) {
		itens.add(new ItemVenda(produto));
	}
	
	/**Método para remover itens da lista passando o código como parâmetro
	 * faz a comparação do código atraves de um método da classe ItemVenda
	 * @param int codigo
	 **/	
	public void removeItem (int codigo) {
		int i=0;
		boolean produtoEncontrado = false;
		while ((i < itens.size())&&(produtoEncontrado == false)) {
			ItemVenda excluir = this.itens.get(i);
			if (excluir.buscarCodigo(excluir, codigo)) { // compara o codigo do item excluir com o codigo passado por parâmetro
				produtoEncontrado = true; }
			i++; }
		if(produtoEncontrado) {
			itens.remove(i-1);
			System.out.println("Produto removido"); }
		else {
			System.out.println("Codigo não encontrado"); }
	}
	
	/**Método para calcular o valor total da venda
	 * 
	 * @return
	 */
	public float valorVenda() {
		float total = 0;
    	
		Iterator<ItemVenda> iterator = itens.iterator();
		while (iterator.hasNext()) {
			ItemVenda item = iterator.next();
			total += ((item.getProduto().getPreco() * item.getQuantidade())); }
		//System.out.println(total);
		
		return total;
	}
	
	/**Método para imprimir itens de venda
	 * 
	 */
	public void imprimirItens() {
		int i = 0;
    	Iterator<ItemVenda> iterator = itens.iterator();
    	System.out.println("n----cod----prod----quant----preço");
		while (iterator.hasNext()) {
			ItemVenda item = iterator.next();
			System.out.printf("%d -- %s\n", i, item.getProduto().getCodigo()+" -- "+ 
					item.getProduto().getNome()+" -- "+ item.getQuantidade()+" -- R$"+
					item.getProduto().getPreco());
			i++; }
	}
	
	/** Métodos gets and sets
	*/
	public String getData() {
		return data; }
	
	public Pessoa getCliente() {
		return cliente; }

	public Pessoa getFuncionario() {
		return funcionario; }

	public ArrayList<ItemVenda> getitens() {
		return itens; }

	public void setData(String data) {
		this.data = data; }

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente; }

	public void setFuncionario(Pessoa funcionario) {
		this.funcionario = funcionario; }

	public void setItens(ArrayList<ItemVenda> itens) {
		this.itens = itens; }
}
