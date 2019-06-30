public class Produto {
	// Classe que representa produto de estoque
	private int idProduto;
	private String descricao;
	private float preco;

	// Init
	public Produto(int id, String desc, float preco) {
		this.idProduto = id;
		this.descricao = desc;
		this.preco = preco;
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
	
	// Change stuff
	public int changeDesc(String nDesc) {
		this.descricao = nDesc;
		if(this.descricao == nDesc)
			return 0; // ok
		else
			return -1;// not ok
	}
	public int changePreco(float nPreco) {
		this.preco = nPreco;
		if(this.preco == nPreco)
			return 0; // ok
		else
			return -1;// not ok
	}
}
