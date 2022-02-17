package imd.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Ferramentas extends Produto{
	private int mesesUtil;
	private String material;
	
	public Ferramentas() {}
	
	public Ferramentas(String nome, double preco, double quantidade, String marca, 
			String descricao, String fornecedor, LocalDate dataDeFabricacao, int mesesUtil, String material) {
		super(nome, preco, quantidade, marca, descricao, 
				fornecedor, dataDeFabricacao);
		this.mesesUtil = mesesUtil;
		this.material = material;
	}

	public int getMesesUtil() {
		return mesesUtil;
	}

	public void setMesesUtil(int mesesUtil) {
		this.mesesUtil = mesesUtil;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	
	public void utilidade() {
		
	}
	
	@Override
	public String visualizar() {
		return "Tipo:   Ferramenta/Material de construção \nNome:   " + 
			    getNome() + "\n" + "Preço:   R$" + getPreco() + "\n" +
			    "Quantidade:   " + getQuantidade() + " unidades\n" +
			    "Marca:   " + getMarca() + "\n" + 
			    "Fornecedor:   " + getFornecedor() + "\n" +
			    "Data de fabricação:   " + getDataDeFabricacao().format(DateTimeFormatter.ofPattern("dd/MMM/yyyy")) + "\n" + 
			    "Validade do produto:   " + this.mesesUtil + " meses\n" +
			    "Material do produto:  " + this.material + "\n" +
			    "Descrição: " + getDescricao();
	}
}
