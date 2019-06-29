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
}
