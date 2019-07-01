import java.util.Scanner;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		/*/
		 * Bloco de pre-configuracoes (bases de dados de teste)
		/*/
		
		// Inicializando base de dados de teste
		ArrayList<Produto> tablePDB_produto = createPoductsInPDB(); // Pseudo database Produto
		ArrayList<Usuario> tablePDB_usuario = createUsuarioInPDB(); // Pseudo database Usuario
		ArrayList<Cliente> tablePDB_cliente = createClienteInPDB(); // Pseudo database Cliente
		ArrayList<Filial> tablePDB_filial = createFilialInPDB(tablePDB_produto); // Pseudo database Filial
		
		/*/
		 * Bloco de atividades (menu/operacoes)
		/*/
		
		// Variaveis de controle de menu
		Scanner scanInput = new Scanner(System.in);
		int main_menu_opt = -1;
		
		// Main menu
		while(main_menu_opt != 0) {
			printMainMenu();
			// Option selection + input filter
			if(scanInput.hasNextInt()) { // Se input for int
				main_menu_opt =	scanInput.nextInt();
				if(main_menu_opt < 0 || main_menu_opt > 4) { // Se opcao invalida
					System.out.println("Comando invalido.");
					try {
						TimeUnit.MICROSECONDS.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					main_menu_opt = -1;
					continue;
				}
			} else { // Entrada contem valor nao numerico
				System.out.println("Apenas valores numericos inteiros.");
				try {
					TimeUnit.MICROSECONDS.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				scanInput.nextLine();
				main_menu_opt = -1;
				continue;
			}
			// Actions
			switch(main_menu_opt) {
				case 0: // Sair/Fim de execucao
					break;
				case 1: // Venda
					if(vendaDeProdutos(tablePDB_filial, tablePDB_usuario, tablePDB_cliente, tablePDB_produto) == -1)
						System.out.println("Algo deu errado.");
					else
						System.out.println("Venda efetuada com sucesso!");
					break;
				case 2: // Entrada em estoque
					if(entradaEstoque(tablePDB_filial, tablePDB_produto) == -1)
						System.out.println("Algo deu errado.");
					else
						System.out.println("Adicionado com sucesso!");
					break;
				case 3: // Saída em estoque
					if(saidaEstoque(tablePDB_filial, tablePDB_produto) == -1)
						System.out.println("Algo deu errado.");
					else
						System.out.println("Removido com sucesso!");
					break;
				case 4:
					// Seleção da filial ativa da sessão:
					Filial fil = selectFilial(tablePDB_filial);
					if(fil == null) { break; }
					// Listando
					for(int id : fil.getEstoque().getRelacao().keySet())
						for(Produto pd : tablePDB_produto)
							if(pd.getID() == id)
								System.out.println(pd.getID() + ". " + pd.getDescricao()
								+ " \tQtd.: " + fil.getEstoque().getRelacao().get(id));
					break;
			}
		}
		scanInput.close();
		System.out.println("Fim de execucao.");
	}

	// Usuario ativo da sessão:
	private static Usuario selectUser(ArrayList<Usuario> tableUsr) {
		Scanner scanInput = new Scanner(System.in);
		int usrID = -1;
		System.out.println(">> Identificação do Usuário");
		// Print usuarios
		for(Usuario usr : tableUsr)
			System.out.println(usr.getID() + ". " + usr.getNome());
		// Recebe ID usuário
		while(usrID == -1) {
			System.out.print("\n> ID Usuario?:");
			if(scanInput.hasNextInt()) { // Input numérico
				usrID = scanInput.nextInt();
				for(Usuario usr : tableUsr) // Itera para validar
					if( usr.getID() == usrID ) // ID válido
						return usr;
			}
			System.out.println("ID invalido.");
			try {
				TimeUnit.MICROSECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			scanInput.nextLine(); // Clear buffer
			usrID = -1; // Reset status
		}
		return null;
	}
	
	// Filial ativa da sessão:
	private static Filial selectFilial(ArrayList<Filial> tableFil) {
		Scanner scanInput = new Scanner(System.in);
		int filID = -1;
		System.out.println(">> Identificação da filial/loja");
		// Print usuarios
		for(Filial fil : tableFil)
			System.out.println(fil.getID() + ". " + fil.getDescricao());
		// Recebe ID usuário
		while(filID == -1) {
			System.out.print("\n> ID Filial?:");
			if(scanInput.hasNextInt()) { // Input numérico
				filID = scanInput.nextInt();
				for(Filial fil: tableFil) // Itera para validar
					if( fil.getID() == filID ) // ID válido
						return fil;
			}
			System.out.println("ID invalido.");
			try {
				TimeUnit.MICROSECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			scanInput.nextLine(); // Clear buffer
			filID = -1; // Reset status
		}
		return null;
	}
	
	// Cliente ativo da sessão:
	private static Cliente selectCliente(ArrayList<Cliente> tableClt) {
		Scanner scanInput = new Scanner(System.in);
		int cltID = -1;
		System.out.println(">> Identificação do Usuário");
		// Print usuarios
		for(Cliente clt : tableClt)
			System.out.println(clt.getID() + ". " + clt.getNome());
		// Recebe ID usuário
		while(cltID == -1) {
			System.out.print("\n> ID Usuario?:");
			if(scanInput.hasNextInt()) { // Input numérico
				cltID = scanInput.nextInt();
				for(Cliente clt: tableClt) // Itera para validar
					if( clt.getID() == cltID ) // ID válido
						return clt;
			}
			System.out.println("ID invalido.");
			try {
				TimeUnit.MICROSECONDS.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			scanInput.nextLine(); // Clear buffer
			cltID = -1; // Reset status
		}
		return null;
	}
	
	// Main menu
 	private static void printMainMenu() {
		System.out.print("\n\n");
		System.out.println(">> Operações:");
		System.out.println("1. Venda");
		System.out.println("2. Entrada em estoque");
		System.out.println("3. Saída em estoque");
		System.out.println("4. Exibir estoque");
		System.out.println("0. Sair");
	}

 	// Escolher dados para saida de estoque
	private static int saidaEstoque(ArrayList<Filial> pdbFilial, ArrayList<Produto> pdbProduto) {
		Scanner scanInput = new Scanner(System.in);
		int produtoID = -1, volume = -1;
		
		// Seleção da filial ativa da sessão:
		Filial fil = selectFilial(pdbFilial);
		if(fil == null) { return -1; }
				
		// Print tabela de produtos (estoque da filial)
		System.out.println("> Estoque atual da filial:");
 		for(int id : fil.getEstoque().getRelacao().keySet())
			for(Produto pd : pdbProduto)
				if(pd.getID() == id)
					System.out.println(id + ". " + pd.getDescricao() + "\tQtd.: " + fil.getEstoque().getRelacao().get(id));
		
		// Escolher Produto
		while(produtoID == -1) {
			// Escolha do produto a ser removido
			System.out.print("ID do produto a ser removido: ");
			if(scanInput.hasNextInt()) { // Se entrata for int
				produtoID = scanInput.nextInt();
				// Se existe no estoque
				if(!fil.getEstoque().getRelacao().keySet().contains(produtoID)) {
					produtoID = -1;
					System.out.println("ID invalido.");
					continue;
				}
			} else { // Entrada foi char/String
				System.out.println("Apenas valores numericos inteiros.");
				try {
					TimeUnit.MICROSECONDS.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				scanInput.nextLine(); // Clear buffer
				produtoID = -1;
				continue;
			}
		}
		// Escolher Volume
		while(volume == -1) {
			System.out.print("Quantidade a ser removida: ");
			if(scanInput.hasNextInt()) { // Se entrata for int
				volume = scanInput.nextInt();
				// Se valor é válido
				if(volume > fil.getEstoque().getRelacao().get(produtoID)) {
					volume = -1;
					System.out.println("Quantidade invalida.");
					continue;
				}
			}else { // Entrada foi char/string
				System.out.println("Apenas valores numericos inteiros.");
				try {
					TimeUnit.MICROSECONDS.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				scanInput.nextLine(); // Clear buffer
				volume = -1;
				continue;
			}
		}
		return PedidoEstoque.removerEmEstoque(produtoID, volume, fil.getEstoque(), pdbProduto);
	}
	
	private static int entradaEstoque(ArrayList<Filial> pdbFilial, ArrayList<Produto> pdbProduto) {
		Scanner scanInput = new Scanner(System.in);
		boolean existe = false;
		int produtoID = -1, volume = -1;
		char yn = 'a';
		
		// Seleção da filial ativa da sessão:
		Filial fil = selectFilial(pdbFilial);
		if(fil == null) { return -1; }
		
		// Print tabela de produtos (geral)
		for(Produto pd : pdbProduto)
			System.out.println(pd.getID() + ". \t" + pd.getDescricao());
		
		// Escolher Produto
		while(produtoID == -1) {
			// Escolha do produto a ser adicionado
			System.out.print("ID do produto a ser adicionado: ");
			if(scanInput.hasNextInt()) { // Se input é int
				produtoID = scanInput.nextInt();
				for(Produto pd : pdbProduto) // Checar se ID existe
					if(pd.getID() == produtoID) {
						existe = true;
						break;
					}
				if(!existe) { // Se não existe, inválido
					produtoID = -1;
					System.out.println("ID invalido.");
					continue;
				}
			} else { // Entrada foi char/string
				System.out.println("Apenas valores numericos inteiros.");
				try {
					TimeUnit.MICROSECONDS.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				scanInput.nextLine(); // Clear buffer
				produtoID = -1;
				continue;
			}
		}
		// Escolher Volume
		while(volume == -1) {
			System.out.print("Quantidade a ser adicionada: ");
			if(scanInput.hasNextInt()) { // Se input é int
				volume = scanInput.nextInt();
				break;
			} else { // Entrada foi char/string
				System.out.println("Apenas valores numericos inteiros.");
				try {
					TimeUnit.MICROSECONDS.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				scanInput.nextLine(); // Clear buffer
				volume = -1;
				continue;
			}
		}
		return PedidoEstoque.adicionarEmEstoque(produtoID, volume, fil.getEstoque(), pdbProduto);
	}
	
	private static int vendaDeProdutos(ArrayList<Filial> pdbFilial, ArrayList<Usuario> pdbUsuario, ArrayList<Cliente> pdbCliente, ArrayList<Produto> pdbProduto) {
		// Selecao de Usuario:
		Usuario session_user = selectUser(pdbUsuario);
		if(session_user != null)
			System.out.println("Usuario: " + session_user.getNome() + "\n");
		else
			return -1;
		// Selecao de cliente ativo da sessao:
		Cliente session_clt = selectCliente(pdbCliente);
		if(session_clt != null)
			System.out.println("Cliente ativo: " + session_clt.getNome() + "\n");
		else
			return -1;
		// Selecao da filial ativa da sessao:
		Filial session_fil = selectFilial(pdbFilial);
		if(session_fil != null)
			System.out.println("Filial ativa: " + session_fil.getDescricao() + "\n");
		else
			return -1;
		// Observacao de entrega:
		Scanner scanInput = new Scanner(System.in);
		String obs = scanInput.nextLine();
		
		// Registra novo pedido
		PedidoEstoque pedido = new PedidoEstoque(session_fil, session_user, session_clt, obs);

		// Listar Estoque da filial
		for(int id : session_fil.getEstoque().getRelacao().keySet())
			for(Produto pd : pdbProduto)
				if(pd.getID()==id)
					System.out.println(pd.getID() + ". " + pd.getDescricao()
					+ "\tQtd.: " + session_fil.getEstoque().getRelacao().get(id));
		
		// Preenche pedido
		int produtoID = -1;
		System.out.println("Para interromper insercao: 0");
		while(produtoID != 0) {
			if(scanInput.hasNextInt()) {
				produtoID = scanInput.nextInt();
				//TBD
				if(pedido.adicionarAoPedido(produtoID, qtd, session_fil.getEstoque(), pdbProduto) == -1)
					return -1;
			} else { // Entrada foi char/String
				System.out.println("Apenas valores numericos inteiros.");
				try {
					TimeUnit.MICROSECONDS.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				scanInput.nextLine(); // Clear buffer
				produtoID = -1;
				continue;
			}
		}
		
		// Realizar pedido
		return 1;
	}
	
	/*/
	 * Inicializando as bases de dados
	/*/
	
	
	
	private static ArrayList<Filial> createPDB_Filial() {
		ArrayList<Filial> pdbFilial = new ArrayList<Filial>();
		pdbFilial.add(new Filial(1, "COHAMA"));
		/*
		PedidoEstoque.adicionarEmEstoque(1, 100, filialPDB.get(0).getEstoque(), pdbProduto);
		PedidoEstoque.adicionarEmEstoque(3, 110, filialPDB.get(0).getEstoque(), pdbProduto);
		PedidoEstoque.adicionarEmEstoque(5, 120, filialPDB.get(0).getEstoque(), pdbProduto);
		PedidoEstoque.adicionarEmEstoque(7, 130, filialPDB.get(0).getEstoque(), pdbProduto);
		PedidoEstoque.adicionarEmEstoque(9, 140, filialPDB.get(0).getEstoque(), pdbProduto);
		*/
		pdbFilial.add(new Filial(2, "VINHAIS"));
		/*
		PedidoEstoque.adicionarEmEstoque(1, 150, filialPDB.get(1).getEstoque(), pdbProduto);
		PedidoEstoque.adicionarEmEstoque(3, 160, filialPDB.get(1).getEstoque(), pdbProduto);
		PedidoEstoque.adicionarEmEstoque(5, 170, filialPDB.get(1).getEstoque(), pdbProduto);
		PedidoEstoque.adicionarEmEstoque(8, 180, filialPDB.get(1).getEstoque(), pdbProduto);
		PedidoEstoque.adicionarEmEstoque(10, 190, filialPDB.get(1).getEstoque(), pdbProduto);
		PedidoEstoque.adicionarEmEstoque(4, 100, filialPDB.get(1).getEstoque(), pdbProduto);
		PedidoEstoque.adicionarEmEstoque(6, 120, filialPDB.get(1).getEstoque(), pdbProduto);
		*/
		return pdbFilial;
	}
	
	private static ArrayList<Produto> createPDB_Poducts() {
		ArrayList<Produto> pdbProduto = new ArrayList<Produto>();
		pdbProduto.add(new Produto(1,	"ARROZ 1KG",			3.99f));
		pdbProduto.add(new Produto(2,	"SAL 1KG",				0.99f));
		pdbProduto.add(new Produto(3,	"CADERNO",				12.99f));
		pdbProduto.add(new Produto(4,	"PILHAS",				4.49f));
		pdbProduto.add(new Produto(5,	"NESCAU 500G",			5.99f));
		pdbProduto.add(new Produto(6,	"BISCOITO DE CHOCOLATE",1.55f));
		pdbProduto.add(new Produto(7,	"FONE DE OUVIDO", 		59.00f));
		pdbProduto.add(new Produto(8,	"CABO USB", 			15.00f));
		pdbProduto.add(new Produto(9,	"DETERGENTE 600ML",		6.90f));
		pdbProduto.add(new Produto(10,	"SABAO EM BARRA 600G",	10.39f));
		return pdbProduto;
	}
	
	private static ArrayList<Cliente> createPDB_Cliente() {
		ArrayList<Cliente> pdbCliente = new ArrayList<Cliente>();
		pdbCliente.add(new Cliente(1, "PEDRO CABRAL"));
		pdbCliente.add(new Cliente(2, "JOSE ALENCAR"));
		pdbCliente.add(new Cliente(3, "PAULO FREIRE"));
		return pdbCliente;
	}
	
	private static ArrayList<Usuario> createPDB_Usuario() {
		ArrayList<Usuario> pdbUsuario = new ArrayList<Usuario>();
		pdbUsuario.add(new Usuario(1, "Ana Carolina"));
		pdbUsuario.add(new Usuario(2, "Pedro Chaves"));
		pdbUsuario.add(new Usuario(3, "Marcos Silva"));
		pdbUsuario.add(new Usuario(4, "Erika Barros"));
		return pdbUsuario;
	}

}
