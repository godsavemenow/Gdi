package gdibike;

import java.sql.SQLException;

public class Interface {
	public static void select(String constraint) {
		Sql.createConnection();
		Sql.selectBasico(constraint);
		Sql.ImprimirResultado();
		Sql.closeConnection();
	}
	public static Cadastro[] all_users() throws SQLException {
           // try {
		Sql.createConnection();
		Sql.show_all();
		Cadastro[] cadastros = Sql.getCadastros();
		Sql.closeConnection();
		return cadastros;
          //  } catch (Exception e) {
            //    e.printStackTrace();
             //return new Cadastro[0];
            //}
	}
	
	public static void insert(String cpf, String nome, String telefone, String imagem, String pais, String estado, String cidade, String bairro, String numero, String cep) throws SQLException {
		Sql.createConnection();
		Sql.insertUser(cpf, nome, telefone, imagem, pais, estado, cidade, bairro, numero, cep);
		Sql.closeConnection();
	}
}