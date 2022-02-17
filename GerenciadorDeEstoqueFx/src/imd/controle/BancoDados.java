package imd.controle;

import java.util.ArrayList;

import imd.modelo.*;

public class BancoDados {
	private ArrayList<Produto> produtos;
	
	public BancoDados() {
		this.produtos = new ArrayList<Produto>();
	}
	
	public ArrayList<Produto> getList() {
		return produtos;
	}
	
	public String adicionarProduto(Produto nome) {
		for(Produto a : this.produtos) {
			if(a.getNome().equals(nome.getNome())) {
				return "Produto " + "'" + nome.getNome() + "'" +  " j� existente";
			}
		}
		produtos.add(nome);
		return "Produto "+ "'" + nome.getNome() + "'" +" adicionado com sucesso!";
	}
	
	public String removerProduto(Produto nome) {
		for(Produto a : this.produtos) {
			if(a.getNome().equals(nome.getNome())) {
				this.produtos.remove(a);
				return "Produto excluido!";
			}
		}
		return "Produto n�o existe!";
	}
	
	public Produto buscarProduto(String nome) {
		for(Produto a : this.produtos) {
			if(a.getNome().equals(nome)) {
				return a;
			}
		}
		return null;
	}
	
	public Produto getProduto(String nome) {
		for(Produto e : this.produtos) {
			if(e.getNome().equals(nome))
				return e;
		}
		return null;
	}
	
}
