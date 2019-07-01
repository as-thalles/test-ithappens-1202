import java.util.Map;
import java.util.HashMap;
public class ItensPedido {
	// Similar a Estoque, mas para PedidoEstoque
	private Map<Integer, Integer> lista_itemCount; // Dictionary<ID, Count>
	private Map<Integer, String> lista_itemStatus; // Dictionary<ID, String>
	
	public ItensPedido() {
		this.lista_itemCount = new HashMap<Integer, Integer>();
		this.lista_itemStatus = new HashMap<Integer, String>();
	}
	
	// Gets
	public Map<Integer, Integer> getItemCount(){
		return this.lista_itemCount;
	}
	public Map<Integer, String> getItemStatus(){
		return this.lista_itemStatus;
	}
	
	// Add
	public void addToCart(int id, int volume, String status) {
		this.lista_itemCount.put(id, volume);
		this.lista_itemStatus.put(id, status);
	}
}
