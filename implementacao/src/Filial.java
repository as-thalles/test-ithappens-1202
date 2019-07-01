public class Filial {
	// Classe que representa a loja/filial
	private int idFilial;
	private String descricao;
	private Estoque estoque;
	
	// Init
	public Filial(int id, String desc, Estoque stk) {
		this.idFilial = id;
		this.descricao = desc;
		this.estoque = stk;
	}
	
	// Gets
	public int getID() {
		return this.idFilial;
	}
	public String getDescricao() {
		return this.descricao;
	}
	public Estoque getEstoque() {
		return this.estoque;
	}
	
	// Changes
	public int changeDesc(String nDesc) {
		this.descricao = nDesc;
		if(this.descricao == nDesc)
			return 1; // ok
		else
			return -1;// not ok
	}
}
