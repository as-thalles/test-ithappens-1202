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
	
	// Gets
	public int getID() {
		return this.idProduto;
	}
	public String getDescricao() {
		return this.descricao;
	}
	public float getPreco() {
		return this.preco;
	}
	
	// Changes
	public int changeDesc(String nDesc) {
		this.descricao = nDesc;
		if(this.descricao == nDesc)
			return 1; // ok
		return -1;// not ok
	}
	public int changePreco(float nPreco) {
		this.preco = nPreco;
		if(this.preco == nPreco)
			return 1; // ok
		return -1;// not ok
	}
}
