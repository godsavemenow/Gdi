package gdibike;

import java.sql.*;
import java.util.ArrayList;

public class Sql {
	public static String url = "jdbc:oracle:thin:@oracle12c.cin.ufpe.br:1521:instance01";
    public static String user = "g191if685cc_eq02";
    public static String senha = "czsjexom";

    public static Connection conexao;
    public static Statement stmt;

    public static ResultSet resultado;

    public static void createConnection(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conexao = DriverManager.getConnection(url, user, senha);
            stmt = conexao.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection(){
        try {
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void selectBasico(String constraint){
        String consultaSql = "select " + "*" + " from " + " usuario " + " where cpf=" + constraint;
       
        try {
            resultado = stmt.executeQuery(consultaSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
    public static void insertUser(String cpf, String nome, String telefone, String imagem, String pais, String estado, String cidade, String bairro, String numero, String cep)  {
        try {
            Statement st1 = conexao.createStatement();
            Statement st2 = conexao.createStatement();
            st1.executeUpdate(
                "INSERT INTO usuario telefone, tempo_mensal, nome, cpf, imagem "+
                "VALUES("+telefone+", 0, "+nome+", "+cpf+", "+imagem+")"
            );
            st2.executeUpdate("INSERT INTO endereco (usuario,pais,estado,cidade,bairro,numero,cep) "
                    + "VALUES ("+ cpf +  "," + pais + "," + estado + "," + cidade+ "," + bairro + "," + numero + "," + cep + ")");
        }
    	catch(SQLException e) {
    		e.printStackTrace();
    	}
    }

    public static void ImprimirResultado(){
        while(true){
            try {
                if (resultado.next()){
                    System.out.println(resultado.getString(1));
                }else{
                    break;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static Cadastro[] getCadastros() {
        ArrayList<Cadastro> cadastros = new ArrayList<Cadastro>();
        while (resultado.next()) {
            Cadastro cadastro = new Cadastro();
            cadastro.nome = resultado.getString(0);
            cadastro.cpf = resultado.getString(1);
            cadastro.telefone = resultado.getString(2);
            cadastro.imagem = resultado.getString(3);
            cadastro.endereco = (
                resultado.getString(9) + " número " + resultado.getString(8) + ", "+ resultado.getString(7) + ", " +
                resultado.getString(6) + " - " + resultado.getString(5) + "(" + resultado.getString(4) + ")"
            );
            cadastros.add(cadastro);
        }
        return cadastros.toArray(new Cadastro[cadastros.size()]);
    }

	public static void show_all() {
		String consultaSql = "SELECT usr.nome,"
				+ "usr.cpf,usr.telefone,"
				+ "usr.imagem,adr.pais,"
				+ "adr.estado,adr.cidade,"
				+ "adr.bairro,adr.numero,adr.cep,adr.usuario FROM usuario usr, endereco adr WHERE adr.usuario = usr.cpf";
	       
        try {
            resultado = stmt.executeQuery(consultaSql);
        } catch (SQLException e) {
            e.printStackTrace();
        }		
	}
}
