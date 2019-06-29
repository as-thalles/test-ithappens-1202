public class Produto {
	// Classe que representa produto de estoque
	private int idProduto;
	private String descricao;
	private float preco;
	private String peso_unid; // Se vende por peso ou unidade

	// Init
	public Produto(int id, String desc, float preco, String peso_unid) {
		this.idProduto = id;
		this.descricao = desc;
		this.preco = preco;
		this.peso_unid = peso_unid;
	}
	
	// Get stuff
	public int getID() {
		return this.idProduto;
	}
	public String getDescricao() {
		return this.descricao;
	}
	public float getPreco() {
		return this.preco;
	}
	public String getPesoUnid() {
		return this.peso_unid;
	}
	// Change stuff
	public boolean changeDesc(String nDesc) {
		this.descricao = nDesc;
		if(this.descricao == nDesc)
			return true; // Funcionou
		else
			return false;// N�o funcionou
	}
	public boolean changePreco(float nPreco) {
		this.preco = nPreco;
		if(this.preco == nPreco)
			return true;
		else
			return false;
	}
}