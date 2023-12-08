package conexão_BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BancoDeDados {

	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;
	
	public void Conectar() {
		String servidor = "jdbc:mysql://localhost:3306/loja";
		String usuario = "root";
		String senha = "99180116";
		String driver = "com.mysql.jdbc.Driver";
		
			try {
				Class.forName(driver);
				this.connection = DriverManager.getConnection(servidor, usuario, senha);
				this.statement = this.connection.createStatement();
			}catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
			}
	}
		public boolean estaConectado() {
			if(this.connection != null) {
				return true;
		}else {
			return false;
			}	
		}
		public void ListarProdutos() {
			try {
				String query = "SELECT * FROM produto order by nome";
				this.resultset = this.statement.executeQuery(query);
				while (this.resultset.next());{
					System.out.println("ID: " + this.resultset.getString("id_produto") + " - nome: " + this.resultset.getString("nome") + " - categoria: " + this.resultset.getString("categoria"));
				}
			}catch(Exception e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}
		public void editarProduto(String id_produto, String nome, String categoria) {
			try {
				String query = "UPDATE produto SET nome = '" + nome + "', categoria = '" + categoria + "' WHERE id_produto = " + id_produto + ";";
				this.statement.executeUpdate(query);
			}catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
			}
			
		}
		public void inserirProduto(String nome, String categoria) {
			try {
				String query = "INSERT INTO (nome, categoria) VALUES ('" + nome + "', '" + categoria + "');";
				this.statement.executeUpdate(query);	
			}catch (Exception e) {
				System.out.println("Erro: " + e.getMessage());
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}