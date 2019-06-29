public class Cliente {
	// Classe que representa o cliente
	private int idCliente;
	private String nome;
	
	// Init
	public Cliente(int id, String nome) {
		this.idCliente = id;
		this.nome = nome;
	}
	
	// Get stuff
	public int getID() {
		return this.idCliente;
	}
	public String getNome() {
		return this.nome;
	}
	
	// Change stuff
	public int changeNome(String nNome) {
		this.nome = nNome;
		if(this.nome == nNome)
			return 0; // ok
		else
			return -1;// not ok
	}
}
