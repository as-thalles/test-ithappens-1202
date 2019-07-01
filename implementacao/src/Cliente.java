public class Cliente {
	// Classe que representa o cliente
	private int idCliente;
	private String nome;
	
	// Init
	public Cliente(int id, String nome) {
		this.idCliente = id;
		this.nome = nome;
	}
	
	// Gets
	public int getID() {
		return this.idCliente;
	}
	public String getNome() {
		return this.nome;
	}
	
	// Changes
	public int changeNome(String nNome) {
		this.nome = nNome;
		if(this.nome == nNome)
			return 1; // ok
		return -1;// not ok
	}
}
