package conexão_BD;

public class Controlador_BD {

	public static void main (String[] args) {
		
		BancoDeDados bancoDeDados = new BancoDeDados();
		bancoDeDados.conectar();
		if(bancoDeDados.estaConectado()) {
			bancoDeDados.ListarProdutos();
			//bancoDeDados.inserirProduto("Miojo", "Alimento");
			//bancoDeDados.apagarProduto("2");
			bancoDeDados.Desconectar();
		}else {
			System.out.println("Não foi possível conectar ao banco de dados!!");
		}
		
	}
	
}
