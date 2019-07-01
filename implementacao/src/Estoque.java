import java.util.Map;
import java.util.HashMap;

public class Estoque {
	// Classe que representa o estoque
	private Map<Integer, Integer> relacaoPdQt; // Dictionary< ID, Qtd >
	
	// Init
	public Estoque() {
		this.relacaoPdQt = new HashMap<Integer, Integer>();
	}
	
	// Gets
	public Map<Integer, Integer> getRelacao() {
		return this.relacaoPdQt;
	}
	
	// Adicionar ao estoque
	protected int entradaProduto(int idProduto, int volume) {
		if(this.relacaoPdQt.containsKey(idProduto)) // Se existe em estoque
			this.relacaoPdQt.put(idProduto, this.relacaoPdQt.get(idProduto)+volume); // Incrementa
		else // Se n�o, cria
			this.relacaoPdQt.put(idProduto, volume);
		return 1; // ok
	}
	
	// Remover em estoque
	protected int saidaProduto(int idProduto, int volume) {
		if(this.relacaoPdQt.containsKey(idProduto)) { // Se existe em estoque
			// Se existe 0 ou se tem menos do que manda tirar, n�o pode.
			if(this.relacaoPdQt.get(idProduto)<=0 || this.relacaoPdQt.get(idProduto)<volume)
				return -1; // N�o pode
			else // Se quantidades ok
				this.relacaoPdQt.put(idProduto, this.relacaoPdQt.get(idProduto)-volume); // Remove
		} 
		// Tentando remover quem n�o existe
		return -1;
	}
}