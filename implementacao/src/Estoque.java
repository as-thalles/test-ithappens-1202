import java.util.Map;
import java.util.HashMap;

public class Estoque {
	// Classe responsável por gerenciamento de estoque
	private Map<Integer, Integer> estoque; // Dictionary<ID, Count>
	public Estoque() {
		this.estoque = new HashMap<Integer, Integer>();
	}
	
	// Get stuff
	public Map<Integer, Integer> getEstoque() {
		return this.estoque;
	}
	
	// Adicionar em estoque
	public void entradaProduto(int prodID, int volume) {
		if(this.estoque.containsKey(prodID)) // Se existe em estoque
			this.estoque.put(prodID, this.estoque.get(prodID)+volume);
		else // Se não, cria
			this.estoque.put(prodID, volume);
	}
	// Remover em estoque
	public void saidaProduto(int prodID, int volume) {
		if(this.estoque.containsKey(prodID)) {// Se existe em estoque
			if(this.estoque.get(prodID)<=0 || this.estoque.get(prodID)<volume) {
				this.estoque.put(prodID, 0);
			}else {
				this.estoque.put(prodID, this.estoque.get(prodID)-volume);
			}
		}else {/*pass*/} // Se não, faz nada
	}
}