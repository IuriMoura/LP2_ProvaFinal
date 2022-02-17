package imd.modelo;

import java.time.LocalDate;

public abstract class Produto {
	private String nome;
	private double preco;
	private double quantidade;
	private String marca;
	private String descricao;
	private String fornecedor;
	private LocalDate dataDeFabricacao;
	
	public Produto() {}
	
	public Produto(String nome, double preco, double quantidade, String marca, String descricao, 
					String fornecedor, LocalDate dataDeFabricacao) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.marca = marca;
		this.descricao = descricao;
		this.fornecedor = fornecedor;
		this.dataDeFabricacao = dataDeFabricacao;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public LocalDate getDataDeFabricacao() {
		return dataDeFabricacao;
	}

	public void setDataDeFabricacao(LocalDate dataDeFabricacao) {
		this.dataDeFabricacao = dataDeFabricacao;
	}
	
	public abstract String visualizar();

}
