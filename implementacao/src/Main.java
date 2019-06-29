import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		// Inicializando "Bancos de dados" de teste
		ArrayList<Usuario> tablePDB_usuario = createUsuarioInPDB(); // Pseudo database Usuario
		ArrayList<Cliente> tablePDB_cliente = createClienteInPDB(); // Pseudo database Cliente
		ArrayList<Produto> tablePDB_produto = createPoductsInPDB(); // Pseudo database Produto
		ArrayList<Filial> tablePDB_filial = createFilialInPDB(); // Pseudo database Filial
	}

	private static ArrayList<Produto> createPoductsInPDB() {
		ArrayList<Produto> produtosPDB = new ArrayList<Produto>();
		produtosPDB.add(new Produto(1,	"ARROZ 1KG",			3.99f,	"UNID"));
		produtosPDB.add(new Produto(2,	"SAL 1KG",				0.99f,	"UNID"));
		produtosPDB.add(new Produto(3,	"ABACAXI",				2.99f,	"PESO"));
		produtosPDB.add(new Produto(4,	"UVA",					3.49f, 	"PESO"));
		produtosPDB.add(new Produto(5,	"NESCAU 500G",			5.99f, 	"UNID"));
		produtosPDB.add(new Produto(6,	"BISCOITO DE CHOCOLATE",1.55f, 	"UNID"));
		produtosPDB.add(new Produto(7,	"FONE DE OUVIDO", 		59.00f,	"UNID"));
		produtosPDB.add(new Produto(8,	"CABO USB", 			15.00f, "UNID"));
		produtosPDB.add(new Produto(9,	"DETERGENTE 600ML",		6.90f, 	"UNID"));
		produtosPDB.add(new Produto(10,	"SABAO EM BARRA 600G",	10.39f, "UNID"));
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
		filialPDB.add(new Filial(1, "VINHAIS",	new Estoque()));
		filialPDB.add(new Filial(2, "COHAMA",	new Estoque()));
		filialPDB.add(new Filial(3, "RIO ANIL", new Estoque()));
		filialPDB.add(new Filial(4, "TURU", 	new Estoque()));
		return filialPDB;
	}
	
	private static ArrayList<Usuario> createUsuarioInPDB() {
		ArrayList<Usuario> usuarioPDB = new ArrayList<Usuario>();
		usuarioPDB.add(new Usuario(1, "Usr 2", "VENDEDOR"));
		usuarioPDB.add(new Usuario(2, "Usr 1", "GERENTE DE ESTOQUE"));
		usuarioPDB.add(new Usuario(3, "Usr 3", "VENDEDOR"));
		return usuarioPDB;
	}

	
}
