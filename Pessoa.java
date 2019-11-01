package ufba.mata55.projetoIncremental;

/**Classe abstrata Pessoa para refer�ncia das classes Cliente e Funcion�rio
 * e seus m�todos relacionados
* @author Caroline da Silva Morais Alves
* @version 5
*/

public abstract class Pessoa {
	
	enum TipoPessoa {
		FUNCIONARIO("Funcion�rio"),
		CLIENTE("Cliente");
		
		private String tipo;
		
		TipoPessoa(String tipo){
			this.tipo = tipo; }
		
		public String getTipoPessoa() {
			return tipo; }
	}
	
	private TipoPessoa tipo;
	private String nome, cpf, data, sexo, telefone, status;
	private int identificador; //numero �nico para identificar o cadastro de funcion�rios e clientes
		
	public Pessoa(String nome, String cpf, String data, String sexo, String telefone, 
			TipoPessoa tipo) {
		this.nome = nome;
		this.cpf = cpf;
		this.data = data;
		this.sexo = sexo;
		this.telefone = telefone;
		this.tipo = tipo;
		this.status = "Ativo";
	}
	
	public Pessoa(String nome, String cpf, TipoPessoa tipo) {
		this.nome = nome;
		this.cpf = cpf;
		this.tipo = tipo;
		this.status = "Ativo";
	}
	
	/**M�todo para verificar se o cadastro � de funcionario para habilitar 
	* as chamadas dos m�todos correspondentes apenas a funcion�rios
	* @param pessoa Pessoa
	**/
	public boolean ehFuncionario(Pessoa pessoa) {
		if (pessoa.tipo.equals(TipoPessoa.FUNCIONARIO)){
			return true; }
		else {
			System.out.println("O Cadastro n�o � de funcion�rio");
			return false; }
	}
	
	/** M�todos get
	 **/
	public String getNome() {
		return nome; 
	}
	public String getCpf() {
		return cpf; 
	}
	public String getData() {
		return data; 
	}
	public String getSexo() {
		return sexo; 
	}
	public String getTelefone() {
		return telefone; 
	}
	public TipoPessoa getTipo() {
		return tipo; 
	}
	public String getStatus() {
		return status; 
	}
	public int getIdentificador() {
		return identificador; 
	}
	
	/**Metodos set
	 */
	public void setNome(String nome) {
		this.nome = nome; 
	}
	public void setCpf(String cpf) {
		this.cpf = cpf; 
	}
	public void setData(String data) {
		this.data = data; 
	}
	public void setSexo(String sexo) {
		this.sexo = sexo; 
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone; 
	}
	public void setTipo(TipoPessoa tipo) {
		this.tipo = tipo; 
	}
	public void setStatus(String status) {
		this.status = status; 
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador; 
	}
}
