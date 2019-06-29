import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		// Inicializando "Bancos de dados" de teste
		ArrayList<Produto> tablePDB_produto = createPoductsInPDB(); // Pseudo database Produto
		ArrayList<Cliente> tablePDB_cliente = createClienteInPDB(); // Pseudo database Cliente
		ArrayList<Filial> tablePDB_filial = createFilialInPDB(); // Pseudo database Filial
		ArrayList<Usuario> tablePDB_usuario = createUsuarioInPDB(); // Pseudo database Filial
		
	}

	private static ArrayList<Produto> createPoductsInPDB() {
		ArrayList<Produto> produtosPDB = new ArrayList<Produto>();
		produtosPDB.add(new Produto(1,	"Arroz 1kg",			3.99f,	"unid"));
		produtosPDB.add(new Produto(2,	"Sal 1kg",				0.99f,	"unid"));
		produtosPDB.add(new Produto(3,	"Abacaxi",				2.99f,	"peso"));
		produtosPDB.add(new Produto(4,	"Uva",					3.49f, 	"peso"));
		produtosPDB.add(new Produto(5,	"Nescau 500g",			5.99f, 	"unid"));
		produtosPDB.add(new Produto(6,	"Biscoito chocolate", 	1.55f, 	"unid"));
		produtosPDB.add(new Produto(7,	"Fone de ouvido", 		59.00f,	"unid"));
		produtosPDB.add(new Produto(8,	"Cabo USB", 			15.00f, "unid"));
		produtosPDB.add(new Produto(9,	"Detergente 600ml",		6.90f, 	"unid"));
		produtosPDB.add(new Produto(10,	"Sabao em barra 500g",	10.39f, "unid"));
		return produtosPDB;
	}
	
	private static ArrayList<Cliente> createClienteInPDB() {
		ArrayList<Cliente> clientePDB = new ArrayList<Cliente>();
		clientePDB.add(new Cliente(1, "Pedro Alves"));
		clientePDB.add(new Cliente(2, "Jose Alencar"));
		clientePDB.add(new Cliente(3, "Paulo Freire"));
		return clientePDB;
	}
	
	private static ArrayList<Filial> createFilialInPDB() {
		ArrayList<Filial> filialPDB = new ArrayList<Filial>();
		filialPDB.add(new Filial(1, "Vinhais"));
		filialPDB.add(new Filial(2, "Cohama"));
		filialPDB.add(new Filial(3, "Rio Anil"));
		filialPDB.add(new Filial(4, "Turu"));
		return filialPDB;
	}
	
	private static ArrayList<Usuario> createUsuarioInPDB() {
		ArrayList<Usuario> usuarioPDB = new ArrayList<Usuario>();
		usuarioPDB.add(new Usuario(1, "Usr 2", "Carregador"));
		usuarioPDB.add(new Usuario(2, "Usr 1", "Gerente de estoque"));
		usuarioPDB.add(new Usuario(3, "Usr 3", "Carregador"));
		return usuarioPDB;
	}


}
