package ufba.mata55.projetoIncremental;

/**Classe para objeto do tipo Vendedor e seus métodos relacionados
* @author Caroline da Silva Morais Alves
* @version 6
*/

public class Vendedor extends Funcionario {
	private final float salario = 850.00F;
	
	public Vendedor(String nome, String cpf, String data, String sexo, String telefone, 
			TipoPessoa tipo) {
		super(nome, cpf, data, sexo, telefone, tipo);
		super.setCargo("Vendedor");
	}
		
	public Vendedor(String nome, String cpf, TipoPessoa tipo) {
		super(nome, cpf, tipo);
		super.setCargo("Vendedor");
	}
	
	/**
	 * Método para o cálculo do salário
	 */
	@Override
	public float calculaSalario() {
		return 0.02F*getVendaMensal()+salario;
	}

	public float getSalario() {
		return salario;
	}

}
