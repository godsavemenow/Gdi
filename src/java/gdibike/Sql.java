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
    
    public static void insertUser(String cpf, String nome, String telefone, String imagem, String pais, String estado, String cidade, String bairro, String numero, String cep)  throws SQLException {
        // try {
            Statement st1 = conexao.createStatement();
            Statement st2 = conexao.createStatement();
            String str = "DECLARE texto CLOB; BEGIN ";
            int coisas = (int) Math.ceil(imagem.length() / 1000);
            for (int i = 0; i < coisas; ++i) {
                int start = i * 1000;
                int end = Math.min((i+1)*1000, imagem.length());
                if (i == 0) {
                    str += "texto := '"+imagem.substring(start, end)+"';\n";
                }
                else
                    str += "texto := texto || '"+imagem.substring(start, end)+"';\n";
            }
            str = str + "INSERT INTO usuario (telefone, tempo_mensal, nome, cpf, imagem) "+
                "VALUES('"+telefone+"', 0, '"+nome+"', '"+cpf+"', texto); END;";
            st1.executeUpdate(str);
            st2.executeUpdate("INSERT INTO endereco (usuario,pais,estado,cidade,bairro,numero,cep) "
                    + "VALUES ('"+ cpf +  "','" + pais + "','" + estado + "','" + cidade+ "','" + bairro + "','" + numero + "','" + cep + "')");
            
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

    public static Cadastro[] getCadastros() throws SQLException {
        ArrayList<Cadastro> cadastros = new ArrayList<Cadastro>();
        while (resultado.next()) {
            Cadastro cadastro = new Cadastro();
            cadastro.nome = resultado.getString(1);
            cadastro.cpf = resultado.getString(2);
            cadastro.telefone = resultado.getString(3);
            cadastro.imagem = resultado.getString(4);
            cadastro.endereco = (
                resultado.getString(10) + " número " + resultado.getString(9) + ", "+ resultado.getString(8) + ", " +
                resultado.getString(7) + " - " + resultado.getString(6) + "(" + resultado.getString(5) + ")"
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
