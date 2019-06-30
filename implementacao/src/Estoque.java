import java.util.Map;
import java.util.HashMap;

public class Estoque {
	// Classe responsável por gerenciamento de estoque
	private Map<Integer, Integer> relacaoPdQt; // Dictionary<ID, Count>
	public Estoque() {
		this.relacaoPdQt = new HashMap<Integer, Integer>();
	}
	
	// Get stuff
	public Map<Integer, Integer> getRelacao() {
		return this.relacaoPdQt;
	}
	
	// Adicionar em estoque
	public int entradaProduto(int prodID, int volume) {
		if(this.relacaoPdQt.containsKey(prodID)) // Se existe em estoque
			this.relacaoPdQt.put(prodID, this.relacaoPdQt.get(prodID)+volume);
		else // Se não, cria
			this.relacaoPdQt.put(prodID, volume);
		return 1; // Worked
	}
	
	// Remover em estoque
	public int saidaProduto(int prodID, int volume) {
		if(this.relacaoPdQt.containsKey(prodID)) {// Se existe em estoque
			if(this.relacaoPdQt.get(prodID)<=0 || this.relacaoPdQt.get(prodID)<volume) {
				return -1; // Pode não
			} else {
				this.relacaoPdQt.put(prodID, this.relacaoPdQt.get(prodID)-volume);
			}
		}else {/*pass*/} // Se não, faz nada
		return 1;
	}
}