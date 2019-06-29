import java.util.Map;
import java.util.HashMap;
public class Estoque {
	// Classe respons�vel por gerenciamento de estoque
	private Map<Produto, Integer> estoque = new HashMap<Produto, Integer>(); // Dictionary<Produto, Count)
	public Estoque() {};
	
	// Get stuff
	public Map<Produto, Integer> getEstoque() {
		return estoque;
	}
	
	// Adicionar produto
	public void entradaProduto(Produto prod, int volume) {
		if(this.estoque.containsKey(prod)) // Se j� existe atualiza
			this.estoque.put(prod, this.estoque.get(prod)+volume);
		else // Se n�o, cria
			this.estoque.put(prod, volume);
	}
	
	
}