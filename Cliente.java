package ufba.mata55.projetoIncremental;

/**Classe para objetos do tipo Cliente e seus métodos relacionados
* @author Caroline da Silva Morais Alves
* @version 6
*/
public class Cliente extends Pessoa{
	
	public Cliente(String nome, String cpf, String data, String sexo, String telefone, 
			TipoPessoa tipo) {
		super(nome, cpf, data, sexo, telefone, tipo);
	}
	
	public Cliente(String nome, String cpf, TipoPessoa tipo) {
		super(nome, cpf, tipo);
	}

}
