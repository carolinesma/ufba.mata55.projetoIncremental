package ufba.mata55.projetoIncremental;
import java.util.Scanner;

import ufba.mata55.projetoIncremental.Pessoa.TipoPessoa;

/**Classe App para gerenciar as funcionalidades da aplicação
* @author Caroline da Silva Morais Alves
* @version 6
*/

public class App {
	
	public static void cadastroLoja(Loja loja) {
		/***** Simulação de Cadastro *****/
		//Para teste aparecerá a lita dos funcionario e produtos no console
		//Funcionarios
		Gerente gerente = new Gerente("Maria", "CPF1", TipoPessoa.FUNCIONARIO);
		Vendedor vendedor1 = new Vendedor("Ana", "CPF2", TipoPessoa.FUNCIONARIO);
		Vendedor vendedor2 = new Vendedor("Laura", "CPF2", TipoPessoa.FUNCIONARIO);
		Caixa caixa = new Caixa("Joana", "CPF3", TipoPessoa.FUNCIONARIO);
		Cliente cliente = new Cliente("Marcia", "CPF4", TipoPessoa.CLIENTE);
		
		loja.addPessoa(gerente);
		loja.addPessoa(vendedor1);
		loja.addPessoa(vendedor2);
		loja.addPessoa(caixa);
		loja.addPessoa(cliente);
		
		//Produtos
		Produto blusa = new Produto(100, "Blusa Verde", 20.00F);
		Produto blusa2 = new Produto(101, "Blusa Azul", 20.00F);
		Produto calca = new Produto(102, "Calça", 50.00F);
		Produto sapato = new Produto(103, "Sapato", 55.00F);
		
		loja.addProduto(blusa);
		loja.addProduto(blusa2);
		loja.addProduto(calca);
		loja.addProduto(sapato);
				
		/****************************************/
	}

	public static void main(String[] args) {
		
		//Inicializando loja
		Loja loja = new Loja();
		cadastroLoja(loja);
		
		Scanner entrada = new Scanner(System.in);
		 AppVenda.appVenda(loja);
		//int opcao;
		
		/*do{
            Menu.menu();
            opcao = entrada.nextInt();
            
            switch(opcao){
            case 0:
            	System.out.println("Finalizando...");
            	break;
            	
            case 1:
                Menu.produtos();
                break;
                
            case 2:
                Menu.pessoas();
                break;
                
            case 3:
                AppVenda.appVenda(loja);
                break;
                            
            default:
                System.out.println("Opção inválida.");
            }
        } while(opcao != 0);*/
		
	entrada.close();
	}
}