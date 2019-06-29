public class Usuario {
	// Classe que representa usuário/vendedor/gerente de estoque
	private int idUsuario;
	private String nome;
	private String cargo;
	
	// Init
	public Usuario(int id, String nome, String cargo){
		this.idUsuario = id;
		this.nome = nome;
		this.cargo = cargo;
	}
	
	// Get stuff
	public int getID(){
		return this.idUsuario;
	}
	public String getNome() {
		return this.nome;
	}
	public String getCargo() {
		return this.cargo;
	}
}
