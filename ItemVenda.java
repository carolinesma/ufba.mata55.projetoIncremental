package ufba.mata55.projetoIncremental;

/**Classe para objeto do tipo ItemVenda e seus métodos relacionados
* @author Caroline da Silva Morais Alves
* @version 6
*/

public class ItemVenda {

	private Produto produto;
	private int quantidade;
	
	public ItemVenda(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}
	
	public ItemVenda(Produto produto) {
		this.produto = produto;
		this.quantidade = 1;
	}
	
	/**
	 * Método para comprar o código do produto do item de venda com um código desejado
	 * método auxiliar no método de exclusão de item de venda
	 * @param item
	 * @param codigo
	 * @return
	 */
	
	public boolean compararCodigo(ItemVenda item, int codigo) {
		if (item.produto.getCodigo()==codigo) {
			return true; }
		else {
			return false;
		}
	}
	
	/** Métodos gets e sets
	*/
	public Produto getProduto() {
		return produto; }

	public int getQuantidade() {
		return quantidade; }

	public void setProduto(Produto produto) {
		this.produto = produto; }

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade; }
}
