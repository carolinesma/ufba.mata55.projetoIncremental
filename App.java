package ufba.mata55.projetoIncremental;
import java.util.Scanner;

/**Classe App para gerenciar as atividade da aplicação
* @author Caroline da Silva Morais Alves
* @version 5
*/

public class App {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int opcao;
		
		do{
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
                AppVenda.appVenda();
                break;
                            
            default:
                System.out.println("Opção inválida.");
            }
        } while(opcao != 0);
		
	entrada.close();
	}
}