package ufba.mata55.projetoIncremental;

import java.util.Scanner;
import ufba.mata55.projetoIncremental.Pessoa.TipoPessoa;

/**Classe AppVenda gerenciar a execu��o do procedimento de vendas
* @author Caroline da Silva Morais Alves
* @version 6
*/

public class AppVenda {
	/**
	 * M�todo para inserir a data da venda	
	 * @param entrada
	 * @return
	 */
	public static String data(Scanner entrada) {
		System.out.println("Qual a data de hoje?");
		String data = entrada.nextLine();
		return data;
	}
	
	/**
	 * M�todo para inserir o Cliente da venda
	 * @param entrada
	 * @return
	 */
	public static Cliente insereCliente(Scanner entrada) {
		System.out.println("Qual o nome do cliente?");
		String nomeCliente = entrada.nextLine();
		
		System.out.println("Qual o cpf do cliente?");
		String cpfCliente = entrada.nextLine();
		Cliente cliente = new Cliente(nomeCliente, cpfCliente, TipoPessoa.CLIENTE);
		return cliente;
	}
	
	/**
	 * M�todo para inserir o vendedor na venda
	 * @param entrada
	 * @param loja
	 * @return
	 */
	public static Funcionario insereVendedor(Scanner entrada, Loja loja) {
		Funcionario vendedor = null;
		while(vendedor==null) {
			System.out.println("Qual o nome do vendedor?");
			loja.listaFuncionarios();
			String nome = entrada.nextLine();
			vendedor = loja.buscaFuncionarioPorNome(nome);}
		return vendedor;
	}
	
	/**
	 *M�todo para inserir os produtos na venda 
	 * @param entrada
	 * @param loja
	 * @return
	 */
	public static Produto insereProduto(Scanner entrada, Loja loja) {
		System.out.println("Qual o c�digo do produto?");
    	loja.imprimeProduto();
    	int codigo = entrada.nextInt();
    	entrada.nextLine();
    	Produto produto = loja.buscaProduto(codigo);
		return produto;
	}
	
	/**
	 * M�todo para inserir a quantidade dos produtos na venda
	 * @param entrada
	 * @return
	 */
	public static int insereQuantidade(Scanner entrada) {
		System.out.println("Inserir quantidade?(S/N)");
    	String inserir = entrada.nextLine();
    	int quantidade = 0;
    	
    	if(inserir.equals("S")) {
    		System.out.println("Qual a quantidade?");
    		quantidade = entrada.nextInt();
    		entrada.nextLine();}
		return quantidade;
	}
	
	/**
	 * M�todo para excluir produtos adicionados na venda
	 * @param entrada
	 * @param venda
	 */
	public static void excluirProduto(Scanner entrada, Venda venda) {
		System.out.println("Qual o c�digo do produto que deseja excluir?");
    	int codigo = entrada.nextInt();
    	entrada.nextLine();
    	venda.removeItem(codigo);
	}
	
	/**
	 * M�todo para finalizar a venda, imprime os pridutos e os valor total da venda
	 * tamb�m faz o calculo da comiss�o do vendedor
	 * @param venda
	 * @param vendedor
	 */
	public static void finalizaVenda(Venda venda, Funcionario vendedor) {
		venda.imprimirItens();
    	System.out.println("O valor total: R$" + venda.valorVenda());
    	System.out.println("Vendedor: " + vendedor.getNome());
    	System.out.println();
    	
    	vendedor.comissao(vendedor, venda.valorVenda());
 	}
	
	/**
	 * M�todo para impress�o dos valores dos salarios com as comiss�es
	 * @param loja
	 */
	//teste para verificar o calculo dos salarios
	public static void salario(Loja loja) {
		loja.imprimeSalarios(loja);
	}
	
	/**
	 * M�todo respons�vel por instanciar Venda e chamar e gerenciar o m�todos acima
	 * @param loja
	 */
	public static void appVenda(Loja loja) {
	
		int opcao;
		Scanner entrada = new Scanner(System.in);
		System.out.printf("\tVenda\n\n");
		System.out.println("Entre com os seguintes dados:");
	
		//chamada de m�todos para instanciar venda	
		String data = AppVenda.data(entrada);
		Cliente cliente = insereCliente(entrada);
		loja.addPessoa(cliente);
		Funcionario vendedor = insereVendedor(entrada, loja);
		Venda venda = new Venda(data, vendedor, cliente);
	
	do{
		Menu.venda();
		opcao = entrada.nextInt();
		
        switch(opcao){
        case 0: //finalizar aplica��o
        	System.out.println("Finalizando...");
        	break;
        
        case 1: //adicionar produtos
        	Produto produto = insereProduto(entrada, loja);
        	int quantidade = insereQuantidade(entrada);        	
        	        	
        	if(quantidade>0) {
        		venda.addItem(produto, quantidade);}
        	else
        		venda.addItem(produto);
            break;
        
        case 2: //excluir produtos
        	excluirProduto(entrada, venda);
        	break;
        
        case 3://finalizar venda
        	finalizaVenda(venda, vendedor);
        	salario(loja);
        	//opcao = 0; //finalizar a aplica��o
        	break;
                                 
        default:
            System.out.println("Op��o inv�lida.");
        }
	} while(opcao != 0);
	
	}
}
