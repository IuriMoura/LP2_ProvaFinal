package imd.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AlimentoPerecivel extends Produto {
	private int mesesUtil;
	private boolean congelado;
	
	public AlimentoPerecivel() {}
	
	public AlimentoPerecivel(String nome, double preco, double quantidade, String marca, 
			String descricao, String fornecedor, LocalDate dataDeFabricacao, int mesesUtil, boolean congelado) {
		super(nome, preco, quantidade, marca, descricao, 
				fornecedor, dataDeFabricacao);
		this.mesesUtil = mesesUtil;
		this.congelado = congelado;
	}

	public int getMesesUtil() {
		return mesesUtil;
	}

	public void setMesesUtil(int mesesUtil) {
		this.mesesUtil = mesesUtil;
	}

	public boolean isCongelado() {
		return congelado;
	}

	public void setCongelado(boolean congelado) {
		this.congelado = congelado;
	}
	
	public void podre() {
		
	}
	
	@Override
	public String visualizar() {
		return "Tipo:   Alimento Perecivel\nNome:   " + 
			    getNome() + "\n" + "Preço:   R$" + getPreco() + "\n" +
			    "Quantidade:   " + getQuantidade() + " unidades\n" +
			    "Marca:   " + getMarca() + "\n" + 
			    "Fornecedor:   " + getFornecedor() + "\n" +
			    "Data de fabricação:   " + getDataDeFabricacao().format(DateTimeFormatter.ofPattern("dd/MMM/yyyy")) + "\n" + 
			    "Validade do produto:   " + this.mesesUtil + " meses\n" +
			    "Produto congelado ?  " + this.congelado + "\n" +
			    "Descrição: " + getDescricao();
	}
}
