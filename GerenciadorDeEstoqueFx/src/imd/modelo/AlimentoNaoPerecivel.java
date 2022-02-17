package imd.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AlimentoNaoPerecivel extends Produto {
	private LocalDate dataDeValidade;
	
	public AlimentoNaoPerecivel() {}
	
	public AlimentoNaoPerecivel(String nome, double preco, double quantidade, String marca, 
			String descricao, String fornecedor, LocalDate dataDeFabricacao, LocalDate dataDeValidade) {
		super(nome, preco, quantidade, marca, descricao, 
					fornecedor, dataDeFabricacao);
		this.dataDeValidade = dataDeValidade;
	}

	public LocalDate getDataDeValidade() {
		return dataDeValidade;
	}

	public void setDataDeValidade(LocalDate dataDeValidade) {
		this.dataDeValidade = dataDeValidade;
	}
	
	@Override
	public String visualizar() {
		return "Tipo:   Alimento Não Perecivel\nNome:   " + 
	    getNome() + "\n" + "Preço:   R$" + getPreco() + "\n" +
	    "Quantidade:   " + getQuantidade() + " unidades\n" +
	    "Marca:   " + getMarca() + "\n" + 
	    "Fornecedor:   " + getFornecedor() + "\n" +
	    "Data de fabricação:   " + getDataDeFabricacao().format(DateTimeFormatter.ofPattern("dd/MMM/yyyy")) + "\n" + 
	    "Data de validade:   " + this.dataDeValidade.format(DateTimeFormatter.ofPattern("dd/MMM/yyyy")) + "\n" +
	    "Descrição:   " + getDescricao();
	}
	
	
}