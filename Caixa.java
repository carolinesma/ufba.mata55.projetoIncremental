package ufba.mata55.projetoIncremental;

/**Classe para objeto do tipo Caixa, classe filha de funcion�rio, e seus m�todos relacionados
* @author Caroline da Silva Morais Alves
* @version 6
*/

public class Caixa extends Funcionario {
	private final float salario = 1000.00F;
	
	public Caixa(String nome, String cpf, String data, String sexo, String telefone, 
			TipoPessoa tipo) {
		super(nome, cpf, data, sexo, telefone, tipo);
		super.setCargo("Caixa");
		}
		
		public Caixa(String nome, String cpf, TipoPessoa tipo) {
			super(nome, cpf, tipo);
			super.setCargo("Caixa");
		}
		
		/**
		 * M�teodo para o c�lculo do sal�rio, descrito na classe funcionario
		 */
		@Override
		public float calculaSalario() {
			return salario;
		}
}
