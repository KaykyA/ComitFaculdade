package Lojinha.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Utils.Utils;


public class Lojinha {

	private static Scanner input = new Scanner(System.in);
	private static ArrayList<Produto> produtos;
	private static Map<Produto, Integer> carrinho;
	
	
	public static void main (String[]args ) {
		
		produtos = new ArrayList<>();
		carrinho = new HashMap<>();
		menu();
	}
	
	private static void menu() {
		
		System.out.println("------------------------------------");
		System.out.println("------------ Lojinha KA ------------");
		System.out.println("------------------------------------");
		System.out.println("*********Selecione uma ação*********");
		System.out.println("------------------------------------");
		System.out.println("| 1 - Cadastrar |");
		System.out.println("| 2 - Listar    |");
		System.out.println("| 3 - Comprar   |");
		System.out.println("| 4 - Carrinho  |");
		System.out.println("| 5 - Sair      |");
		
		try {
		int opcao = input.nextInt();
		
		switch (opcao) {
		case 1: 
			CadastrarProdutos();
			break;
	
		case 2:
			ListarProdutos();
			break;
			
		case 3:
			ComprarProdutos();
			break;
			
		case 4:
			VerCarrinho();
			break;
			
		case 5:
			System.out.println("Volte Sempre");
			System.exit(0);
			default:
				menu();
				break;
	    }			
		
	}catch(NumberFormatException e){
		
	}
	System.out.println("Algo está errado!");
	}
		private static void CadastrarProdutos() {
			
			
			System.out.println("Nome do produto: ");
			String nome = input.next();
			try {	
			System.out.println("Preço do produto");
			Double preco = input.nextDouble();
			
			Produto produto = new Produto(nome, preco);
			produtos.add(produto);
			
			System.out.println(produto.getNome() + "Cadastrado com sucesso");
			menu();
			}
		catch(ArithmeticException e){
		System.out.println("Algo está errado!");
	}
		}
	private static void ListarProdutos() {
		
		try {
			if(produtos.size() > 0) {
				System.out.println("Lista de produtos \n");
				
				for (Produto p : produtos) {
					System.out.println(p);
				}
				
			}else {
				System.out.println("Nenhum produto cadastrado");
			}
			     menu();

		}catch(NullPointerException e) {
			System.out.println("Algo esta errado!");
			
		}		
				
	}	
	
		private static void ComprarProdutos() {
			//Vereficando o tamanho da lista.
				if (produtos.size() > 0) {
					System.out.println("Codigo do produto \n");
					
					System.out.println("---------Produtos disponiveis---------");
					
				for (Produto p : produtos) {
					System.out.println("p + \n");
				}	
				//caso exista produto ele insere o codigo.
				//armazenado na id.
				int id = Integer.parseInt(input.next());
				boolean Npresente = false;
				
				
				//aqui checa se o produto existe na id
				for (Produto p : produtos) {
					if (p.getId() == id) {
						int quantidade = 0;
						try {
							quantidade = carrinho.get(p);
							carrinho.put(p, quantidade +1);
							
						}catch(NullPointerException e) {
							carrinho.put(p, 1);
					    }
						System.out.println(p.getNome() + "Adicionado ao carrinho");
						Npresente = true;
						// aqui é para adicionar ou não o produto 
						if(Npresente) {
							System.out.println("Deseja adcionar outro produto ao carrinho ?");
							System.out.println("Digite 1 para sim, ou 0 para finalizar \n");
							int opcao = Integer.parseInt(input.next());
							
						if (opcao == 1) {
							ComprarProdutos();
						}else {
							FinalizarCompra();
						}
					  }
				        }else {
					System.out.println("Produto não encontrado");
					menu();
				      }
			        }
		                }else {
			        System.out.println("Não existe produtos cadastrados");
			        menu();
		       }
	      }
		// a cada produto vai mostrar quantidade e os produtos
		private static void VerCarrinho() {
			System.out.println("---Produtos no seu carrinho---");
			if (carrinho.size() > 0) {
				for (Produto p : carrinho.keySet()) {
					System.out.println("Produto: " + p + "\nQauntidade: " + carrinho.get(p));
				}
			}else {
				System.out.println("Carrinho vazio");
			}
			menu();
		}
		
		private static void FinalizarCompra() {
			Double ValorDaCompra = 0.0;
			System.out.println("Seus produtos");
			
			for (Produto p : carrinho.keySet()) {
				int quantidade = carrinho.get(p);
				ValorDaCompra += p.getPreco() * quantidade;
				System.out.println(p);
				System.out.println("Quantidade: " + quantidade);
			}
			System.out.println("O valor da sua compra é: " + Utils.doubleToString(ValorDaCompra));
			carrinho.clear();
			System.out.println("Obrigado por comprar!!");
			menu();
		}
}