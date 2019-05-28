package gdibike;

public class Interface {
	public static void select(String constraint) {
		Sql.createConnection();
		Sql.selectBasico(constraint);
		Sql.ImprimirResultado();
		Sql.closeConnection();
	}
	public static Cadastro[] all_users() {
		Sql.createConnection();
		Sql.show_all();
		Cadastro[] cadastros = Sql.getCadastros();
		Sql.closeConnection();
		return cadastros;
	}
	
	public static void insert(String cpf, String nome, String telefone, String imagem, String pais, String estado, String cidade, String bairro, String numero, String cep) {
		Sql.createConnection();
		Sql.insertUser(cpf, nome, telefone, imagem, pais, estado, cidade, bairro, numero, cep);
		Sql.closeConnection();
	}
}