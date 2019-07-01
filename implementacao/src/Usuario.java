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
	
	// Gets
	public int getID(){
		return this.idUsuario;
	}
	public String getNome() {
		return this.nome;
	}
	public String getCargo() {
		return this.cargo;
	}
	
	// Changes
	public int changeNome(String nNome) {
		this.nome = nNome;
		if(this.nome == nNome)
			return 1; // ok
		else
			return -1;// not ok
	}
	public int changeCargo(String nCargo) {
		this.cargo = nCargo;
		if(this.cargo == nCargo)
			return 1; // ok
		else
			return -1;// not ok
	}
}
