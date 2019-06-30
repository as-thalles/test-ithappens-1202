import java.util.Scanner;
import java.util.Iterator;
import java.util.Map;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) {
		/*/
		 * Bloco de pré-configurações (bases de dados de teste)
		/*/
		
		// Inicializando base de dados de teste
		ArrayList<Produto> tablePDB_produto = createPoductsInPDB(); // Pseudo database Produto
		ArrayList<Usuario> tablePDB_usuario = createUsuarioInPDB(); // Pseudo database Usuario
		ArrayList<Cliente> tablePDB_cliente = createClienteInPDB(); // Pseudo database Cliente
		ArrayList<Filial> tablePDB_filial = createFilialInPDB(); // Pseudo database Filial
		
		/*/
		 * Bloco de configurações ("login")
		/*/
		
		// Seleção de Usuario ativo da sessão:
		Usuario session_user = selectUser(tablePDB_usuario);
		if(session_user != null)
			System.out.println("Bem vindo(a), " + session_user.getNome() + "\n\n");

		// Seleção da filial ativa da sessão:
		Filial session_fil = selectFilial(tablePDB_filial);
		if(session_fil != null)
			System.out.println("Filial ativa: " + session_fil.getDescricao() + "\n\n");
		
		/*/
		 * Bloco de atividades (menu/operações)
		/*/
		
		// Variáveis de controle de menu
		Scanner scanInput = new Scanner(System.in);
		int main_menu_opt = -1;
		
		// Main menu
		while(main_menu_opt != 0) {
			printMainMenu();
			// Option selection + input filter
			if(scanInput.hasNextInt()) { // Se input for int
				main_menu_opt =	scanInput.nextInt();
				if(main_menu_opt < 0 || main_menu_opt > 3) { // Se opção inválida
					System.out.println("Comando invalido.");
					try {
						TimeUnit.MICROSECONDS.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					main_menu_opt = -1;
					continue;
				}
			} else { // Entrada contém valor não numérico
				System.out.println("Apenas valores numéricos inteiros.");
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
				case 0: // Sair/Fim de execução
					break;
				case 1: // Venda
					break;
				case 2: // Entrada em estoque
					break;
				case 3: // Saída em estoque
					if(saidaEstoque(session_fil, tablePDB_produto) == 1) {
						System.out.println("Removido com sucesso!");
					}
					break;
			}
		}
		scanInput.close();
		System.out.println("Fim de execução.");
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
			System.out.print("\n\n> ID Usuario?:");
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
			System.out.print("\n\n> ID Filial?:");
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
	
	// Main menu
 	private static void printMainMenu() {
		System.out.print("\n\n");
		System.out.println("Operações:");
		System.out.println("1. Venda");
		System.out.println("2. Entrada em estoque");
		System.out.println("3. Saída em estoque");
		System.out.println("0. Sair");
	}
	
 	// Escolher dados para saída de estoque
	private static int saidaEstoque(Filial fil, ArrayList<Produto> pdbProduto) {
		Scanner scanInput = new Scanner(System.in);
		int produtoID = -1;
		int volume = -1;
		// Print tabela de produtos (estoque da filial)
		for(int id : fil.getEstoque().getRelacao().keySet())
			for(Produto pd : pdbProduto)
				if(pd.getID() == id)
					System.out.println(id + ". " + pd.getDescricao() + "\tQtd.: " + fil.getEstoque().getRelacao().get(id));
		// Escolher Produto
		while(produtoID < 0) {
			// Escolha do produto a ser removido
			System.out.print("ID do produto a ser removido: ");
			if(scanInput.hasNextInt()) {
				produtoID = scanInput.nextInt();
				if(!fil.getEstoque().getRelacao().keySet().contains(produtoID)) {
					produtoID = -1;
					System.out.println("ID invalido.");
				}
			}else {
				System.out.println("Apenas valores numericos inteiros.");
				try {
					TimeUnit.MICROSECONDS.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				scanInput.nextLine(); // Clear buffer
				continue;
			}
		}
		// Escolher Volume
		while(volume < 0) {
			System.out.print("Quantidade a ser removida: ");
			if(scanInput.hasNextInt()) {
				volume = scanInput.nextInt();
				if(volume > fil.getEstoque().getRelacao().get(produtoID)) {
					volume = -1;
					System.out.println("Quantidade invalida.");
				}
			}else {
				System.out.println("Apenas valores numericos inteiros.");
				try {
					TimeUnit.MICROSECONDS.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				scanInput.nextLine(); // Clear buffer
				continue;
			}
		}
		return PedidoEstoque.removerEmEstoque(produtoID, volume, fil.getEstoque(), pdbProduto);
	}
	
	/*/
	 * Inicializando as bases de dados
	/*/
	
	private static ArrayList<Produto> createPoductsInPDB() {
		ArrayList<Produto> produtosPDB = new ArrayList<Produto>();
		produtosPDB.add(new Produto(1,	"ARROZ 1KG",			3.99f));
		produtosPDB.add(new Produto(2,	"SAL 1KG",				0.99f));
		produtosPDB.add(new Produto(3,	"CADERNO",				12.99f));
		produtosPDB.add(new Produto(4,	"PILHAS",				4.49f));
		produtosPDB.add(new Produto(5,	"NESCAU 500G",			5.99f));
		produtosPDB.add(new Produto(6,	"BISCOITO DE CHOCOLATE",1.55f));
		produtosPDB.add(new Produto(7,	"FONE DE OUVIDO", 		59.00f));
		produtosPDB.add(new Produto(8,	"CABO USB", 			15.00f));
		produtosPDB.add(new Produto(9,	"DETERGENTE 600ML",		6.90f));
		produtosPDB.add(new Produto(10,	"SABAO EM BARRA 600G",	10.39f));
		return produtosPDB;
	}
	
	private static ArrayList<Cliente> createClienteInPDB() {
		ArrayList<Cliente> clientePDB = new ArrayList<Cliente>();
		clientePDB.add(new Cliente(1, "PEDRO ALVES"));
		clientePDB.add(new Cliente(2, "JOSE ALENCAR"));
		clientePDB.add(new Cliente(3, "PAULO FREIRE"));
		return clientePDB;
	}
	
	private static ArrayList<Filial> createFilialInPDB() {
		ArrayList<Filial> filialPDB = new ArrayList<Filial>();
		filialPDB.add(new Filial(1, "COHAMA",	new Estoque()));
		filialPDB.get(0).getEstoque().entradaProduto(1, 100);
		filialPDB.get(0).getEstoque().entradaProduto(3, 110);
		filialPDB.get(0).getEstoque().entradaProduto(5, 120);
		filialPDB.get(0).getEstoque().entradaProduto(7, 130);
		filialPDB.get(0).getEstoque().entradaProduto(9, 140);
		
		filialPDB.add(new Filial(2, "VINHAIS",	new Estoque()));
		filialPDB.get(1).getEstoque().entradaProduto(1, 150);
		filialPDB.get(1).getEstoque().entradaProduto(2, 160);
		filialPDB.get(1).getEstoque().entradaProduto(3, 170);
		filialPDB.get(1).getEstoque().entradaProduto(5, 180);
		filialPDB.get(1).getEstoque().entradaProduto(8, 190);
		filialPDB.get(1).getEstoque().entradaProduto(10, 100);
		filialPDB.get(1).getEstoque().entradaProduto(4, 110);
		filialPDB.get(1).getEstoque().entradaProduto(6, 120);
		return filialPDB;
	}
	
	private static ArrayList<Usuario> createUsuarioInPDB() {
		ArrayList<Usuario> usuarioPDB = new ArrayList<Usuario>();
		usuarioPDB.add(new Usuario(1, "Ana Carolina", "VENDEDOR"));
		usuarioPDB.add(new Usuario(2, "Pedro Chaves", "GERENTE DE ESTOQUE"));
		usuarioPDB.add(new Usuario(3, "Marcos Silva", "VENDEDOR"));
		return usuarioPDB;
	}

}
