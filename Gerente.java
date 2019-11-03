package ufba.mata55.projetoIncremental;

/**Classe para objeto do tipo Gerente e seus métodos relacionados
* @author Caroline da Silva Morais Alves
* @version 6
*/

public class Gerente extends Funcionario {
	private final float salario = 2000.00F;

	public Gerente(String nome, String cpf, String data, String sexo, String telefone, 
			TipoPessoa tipo) {
		super(nome, cpf, data, sexo, telefone, tipo);
		super.setCargo("Gerente");
	}
		
	public Gerente(String nome, String cpf, TipoPessoa tipo) {
		super(nome, cpf, tipo);
		super.setCargo("Gerente");
	}
	
	/**
	 * Método para o cálculo do salário
	 */
	@Override
	public float calculaSalario() {
		return 0.01F*getVendaMensal()+salario;
	}

	public float getSalario() {
		return salario;
	}
	
}
