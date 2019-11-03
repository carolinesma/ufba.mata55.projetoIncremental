package ufba.mata55.projetoIncremental;

import java.util.ArrayList;
import java.util.Iterator;

import ufba.mata55.projetoIncremental.Pessoa.TipoPessoa;

/**Classe para objeto do tipo Venda e seus métodos relacionados
* @author Caroline da Silva Morais Alves
* @version 6
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
		this.cliente = new Cliente(nome, cpf, tipo);
		this.funcionario = funcionario;
		this.itens = new ArrayList<ItemVenda>();
	}
	
	/**Método para adicionar itens na lista vendas em uma compra verificando a quantidade
	 * retorna verificação de sucesso de inserção
	 * @param Produto produto, int quantidade
	 * @return
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
	 * @return
	 **/	
	public boolean addItem (Produto produto) {
		if(itens.add(new ItemVenda(produto)))
			return true;
		else return false;
	}
	
	/**Método para remover itens da lista passando o código como parâmetro
	 * chama o método do buscarItem da própria classe
	 * @param int codigo
	 * @return
	 **/	
	public boolean removeItem (int codigo) {
		ItemVenda item = buscarItem(codigo);
		if(item!=null) {
			itens.remove(item);
			System.out.println("Produto removido"); 
			return true;}
		else {
			System.out.println("Código não encontrado"); 
			return false;}
	}
	
	/**
	 * Método para buscar o Item na lista através do código, chama um método da classe item venda
	 * para verificar se o código do item é igual ao do produto equivalente
	 * @param codigo
	 * @return
	 */
	public ItemVenda buscarItem(int codigo) {
		Iterator<ItemVenda> iterator = itens.iterator();
		ItemVenda item = iterator.next();//inicializando para o comparação no laço
		
		while((iterator.hasNext())&&!(item.compararCodigo(item, codigo))) {
			item = iterator.next();}
		
		if(item.getProduto().getCodigo()==codigo)
			return item;
		else return item = null;
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
