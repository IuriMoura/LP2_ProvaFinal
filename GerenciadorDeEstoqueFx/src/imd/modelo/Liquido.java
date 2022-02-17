package imd.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Liquido extends Produto {
	private LocalDate dataDeValidade;
	private double mililitro;
	private boolean alcool;
	
	public Liquido() {}
	
	public Liquido(String nome, double preco, double quantidade, String marca, String descricao, 
			String fornecedor, LocalDate dataDeFabricacao, LocalDate dataDeValidade, double mililitro, boolean alcool) {
		super(nome, preco, quantidade, marca, descricao, 
				fornecedor, dataDeFabricacao);
		this.mililitro = mililitro;
		this.alcool = alcool;
		this.dataDeValidade = dataDeValidade;
	}

	public LocalDate getDataDeValidade() {
		return dataDeValidade;
	}

	public void setDataDeValidade(LocalDate dataDeValidade) {
		this.dataDeValidade = dataDeValidade;
	}

	public double getMililitro() {
		return mililitro;
	}

	public void setMililitro(double mililitro) {
		this.mililitro = mililitro;
	}

	public boolean isAlcoolico() {
		return alcool;
	}

	public void setAlcool(boolean alcool) {
		this.alcool = alcool;
	}
	
	@Override
	public String visualizar() {
		return "Tipo:   Liquido\nNome:   " + 
			    getNome() + "\n" + "Preço:   R$" + getPreco() + "\n" +
			    "Quantidade:   " + getQuantidade() + " unidades\n" +
			    "Marca:   " + getMarca() + "\n" + 
			    "Fornecedor:   " + getFornecedor() + "\n" +
			    "Litragem da unidade do produto:    " + this.mililitro + " mililitros\n" +
			    "Produto alcoolico ?  " + this.alcool + "\n" +
			    "Data de fabricação:   " + getDataDeFabricacao().format(DateTimeFormatter.ofPattern("dd/MMM/yyyy")) + "\n" + 
			    "Validade do produto:   " + this.dataDeValidade.format(DateTimeFormatter.ofPattern("dd/MMM/yyyy")) + " \n" +
			    "Descrição: " + getDescricao();
	}
}
