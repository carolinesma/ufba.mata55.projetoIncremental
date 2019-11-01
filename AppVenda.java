package ufba.mata55.projetoIncremental;

import java.util.Scanner;
import ufba.mata55.projetoIncremental.Pessoa.TipoPessoa;

/**Classe AppVenda para definir a execução do procedimento para vendas
* @author Caroline da Silva Morais Alves
* @version 5
*/

public class AppVenda {
	
	public static void appVenda() {
	int opcao;
	Scanner entrada = new Scanner(System.in);
	System.out.printf("\tVenda\n\n");
	System.out.println("Entre com os seguintes dados:");
	
	//Data
	System.out.println("Qual a data de hoje?");
	String data = entrada.nextLine();
	
	//Dados cliente
	System.out.println("Qual o nome do cliente?");
	String nomeCliente = entrada.nextLine();
	
	System.out.println("Qual o cpf do cliente?");
	String cpfCliente = entrada.nextLine();
	Pessoa cliente = new Cliente(nomeCliente, cpfCliente, TipoPessoa.CLIENTE);
	
	//Dados Vendedor
	System.out.println("Qual o nome do vendedor?");
	String nomeVendedor = entrada.nextLine();
	
	System.out.println("Qual o cpf do vendedor?");
	String cpfVendedor = entrada.nextLine();
	Funcionario vendedor = new Funcionario(nomeVendedor, cpfVendedor, TipoPessoa.FUNCIONARIO);
	
	//instancia venda
	Venda venda = new Venda(data, vendedor, cliente);
	
	do{
		Menu.venda();
		opcao = entrada.nextInt();
		
        switch(opcao){
        case 0:
        	System.out.println("Finalizando...");
        	break;
        
        case 1: //dados do produto
        	System.out.println("Qual o código do produto?");
        	int codigo = entrada.nextInt();
        	entrada.nextLine();
        	
        	System.out.println("Qual o nome do produto?");
        	String nome = entrada.nextLine();
        	
        	System.out.println("Qual o valor do produto?");
        	float preco = entrada.nextFloat();
        	entrada.nextLine();
        	
        	System.out.println("Inserir quantidade?(S/N");
        	String inserir = entrada.nextLine();
        	
        	if(inserir.equals("S")) {
        		System.out.println("Qual a quantidade?");
        		int quantidade = entrada.nextInt();
        		entrada.nextLine();
            	venda.addItem(new Produto(codigo, nome, preco), quantidade);}
        	else
        		venda.addItem(new Produto(codigo, nome, preco));
            break;
        
        case 2:
        	venda.imprimirItens();
        	System.out.println("O valor total: R$" + venda.valorVenda());
        	System.out.println("Vendedor: " + vendedor.getNome());
        	System.out.println();
        	opcao = 0; //finalizar a aplicação
        	break;
                                 
        default:
            System.out.println("Opção inválida.");
        }
	} while(opcao != 0);
	
	}
}
