public class Usuario {
	// Classe que representa usuário/vendedor/gerente de estoque
	private int idUsuario;
	private String nome;
	
	// Init
	public Usuario(int id, String nome){
		this.idUsuario = id;
		this.nome = nome;
	}
	
	// Gets
	public int getID(){
		return this.idUsuario;
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
