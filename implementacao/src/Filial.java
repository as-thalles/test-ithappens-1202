public class Filial {
	// Classe que representa a loja/filial
	private int idFilial;
	private String descricao;
	
	// Init
	public Filial(int id, String desc) {
		this.idFilial = id;
		this.descricao = desc;
	}
	
	// Get stuff
	public int getID() {
		return this.idFilial;
	}
	public String getDescricao() {
		return this.descricao;
	}
	
	// Change stuff
	public boolean changeDesc(String nDesc) {
		this.descricao = nDesc;
		if(this.descricao == nDesc)
			return true; // Funcionou
		else
			return false;// Não funcionou
	}
}
