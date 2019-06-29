import java.util.Map;
import java.util.HashMap;
public class Estoque {
	// Classe responsável por gerenciamento de estoque
	private Map<Produto, Integer> estoque = new HashMap<Produto, Integer>(); // Dictionary<Produto, Count)
	public Estoque() {};
	
	// Get stuff
	public Map<Produto, Integer> getEstoque() {
		return estoque;
	}
	
	// Adicionar produto
	public void entradaProduto(Produto prod, int volume) {
		if(this.estoque.containsKey(prod)) // Se já existe atualiza
			this.estoque.put(prod, this.estoque.get(prod)+volume);
		else // Se não, cria
			this.estoque.put(prod, volume);
	}
	
	
}