import java.util.Map;
import java.util.HashMap;
public class ItensPedido {
	// Classe que representa itens de pedido
	private Map<Integer, Integer> lista_pedido; // Dictionary<ID, Count>
	public ItensPedido() {
		this.lista_pedido = new HashMap<Integer, Integer>();
	}
	
	// Get stuff
	public Map<Integer, Integer> getLPedido() {
		return this.lista_pedido;
	}
	
	// Adicionar em Lista
	public void adcLista(int prodID, int volume) {
		if(this.lista_pedido.containsKey(prodID)) // Se existe em estoque
			this.lista_pedido.put(prodID, this.lista_pedido.get(prodID)+volume);
		else // Se não, cria
			this.lista_pedido.put(prodID, volume);
	}
	// Remover em Lista
	public void decLista(int prodID, int volume) {
		if(this.lista_pedido.containsKey(prodID)) {// Se existe em estoque
			if(this.lista_pedido.get(prodID)<=0 || this.lista_pedido.get(prodID)<volume) {
				this.lista_pedido.put(prodID, 0);
			}else {
				this.lista_pedido.put(prodID, this.lista_pedido.get(prodID)-volume);
			}
		}else {/*pass*/} // Se não, faz nada
	}
}
