public class Filial {
	// Classe que representa a loja/filial
	private int idFilial;
	private String descricao;
	private Estoque estoque;
	
	// Init
	public Filial(int id, String desc, Estoque estoque) {
		this.idFilial = id;
		this.descricao = desc;
		this.estoque = estoque;
	}
	
	// Get stuff
	public int getID() {
		return this.idFilial;
	}
	public String getDescricao() {
		return this.descricao;
	}
	public Estoque getEstoque() {
		return this.estoque;
	}
	
	// Change stuff
	public int changeDesc(String nDesc) {
		this.descricao = nDesc;
		if(this.descricao == nDesc)
			return 0; // ok
		else
			return -1;// not ok
	}
}
