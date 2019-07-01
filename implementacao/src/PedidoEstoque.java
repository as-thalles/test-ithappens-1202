import java.util.ArrayList;

public class PedidoEstoque extends Estoque {
	// Classe responsável pelas >operações< de entrada/saída de estoque
	private static boolean constaEmDB(int idProduto, ArrayList<Produto> pdbProduto) {
		for(Produto it : pdbProduto) {
			if(it.getID() == idProduto)
				return true;
		}
		return false;
	}
	
	private static boolean constaEmEstoque(int idProduto, Estoque stk) {
		return stk.getRelacao().keySet().contains(idProduto);
	}
	
	public static int adicionarEmEstoque(int idProduto, int volume, Estoque stk, ArrayList<Produto> pdbProduto) {
		if(constaEmDB(idProduto, pdbProduto)) {
			return stk.entradaProduto(idProduto, volume);
		}
		return -1;
	}
	
	public static int removerEmEstoque(int idProduto, int volume, Estoque stk, ArrayList<Produto> pdbProduto) {
		if(constaEmDB(idProduto, pdbProduto))
			if(constaEmEstoque(idProduto, stk))
				return stk.saidaProduto(idProduto, volume);
		return -1;
	}
	
	/*
	 * Criacao obsoleta
	 * 
	private static int rotinaCriacaoProduto(ArrayList<Produto> pdbProduto) {
		Scanner scanInput = new Scanner(System.in);
		String descricao = "Placeholder"; // Descrição do produto
		char yn = 'a'; // Yes/No
		float preco = -1f; // Preço do produto
		System.out.print("Deseja criar novo produto? (Y/N): ");
		yn = scanInput.next().charAt(0);
		if(yn == 'Y' || yn == 'y' || yn == 'N' || yn == 'n') { // Quer prosseguir com a criação.
			yn='n';
			while(!(yn=='Y' || yn=='y')) { // Recebe descricao do produto
				System.out.print("Descricao do produto: ");
				descricao = scanInput.nextLine();
				System.out.println("Descricao: " + descricao);
				System.out.print("Confirma? (Y/N): ");
				yn = scanInput.next().charAt(0);
			}
			yn='n';
			while(!(yn=='Y' || yn=='y')) { // Recebe preco unitario do produto
				System.out.print("Valor do produto: ");
				if(scanInput.hasNextFloat()) {
					preco = scanInput.nextFloat();
				}else {
					System.out.println("Valor invalido.");
					try {
						TimeUnit.MICROSECONDS.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					scanInput.nextLine(); // Clear buffer
					continue;
				}
				System.out.println("Valor: " + preco);
				System.out.print("Confirma? (Y/N): ");
				yn = scanInput.next().charAt(0);
			}
			if (scanInput != null) { scanInput.close(); }
			return criaProdutoEmPDB(descricao, preco, pdbProduto);
		}
		if (scanInput != null) { scanInput.close(); }
		return -1;
	}
	
	private static int criaProdutoEmPDB(String desc, float val, ArrayList<Produto> pdbProduto) {
		int maxid=0;
		Produto newPD = null;
		for(Produto pd : pdbProduto) // Get max ID
			if(maxid < pd.getID())
				maxid = pd.getID();
		newPD = new Produto(maxid+1, desc, val);
		if(newPD != null) {
			pdbProduto.add( newPD );
			return 1;
		}
		return -1;
	}
	*/
}
