package imd.controle;

import java.net.URL;
import java.util.ResourceBundle;

import imd.modelo.*;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

public class ControlaBusca implements Initializable{
	
	@FXML
	private Accordion accordion;
	
	@FXML
	private TextArea texto;
	
	@FXML
	private ListView<String> listaAlimentoNP;
	
	@FXML
	private ListView<String> listaAlimentoP;
	
	@FXML
	private ListView<String> listaFerramenta;
	
	@FXML
	private ListView<String> listaLiquido;
	
	@FXML
	private ListView<String> listaLimpeza;
	
	private Produto prod;
	
	
	//ativa o botão para voltar para a tela inicial
	@FXML
	public void voltar(ActionEvent event)  {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../visao/TelaPrincipal.fxml"));
			loader.load();
			MudaTela controlador = loader.getController();
			controlador.mudaCenaPrincipal(event);
		}catch (Exception e) {
			System.out.println("Arquivo fxml não encontrado, por favor mudar a localização no codigo"
					+ " fonte 'ControlaAdicionar' na linha 67.");
			//e.printStackTrace();
		}
	}

	//quando inicia a tela carrega uma lista com todos os produtos
	//adicionados e coloca cada tipo de produto no ListView apropriado
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ArrayList<Produto >lista = new ArrayList<Produto>();
		lista = Main.getBancoDados().getList();
		for(Produto a : lista) {
			if(a instanceof AlimentoNaoPerecivel)
				this.listaAlimentoNP.getItems().add(a.getNome());
			if(a instanceof AlimentoPerecivel)
				this.listaAlimentoP.getItems().add(a.getNome());
			if(a instanceof Ferramentas)
				this.listaFerramenta.getItems().add(a.getNome());
			if(a instanceof Liquido)
				this.listaLiquido.getItems().add(a.getNome());
			if(a instanceof Limpeza)
				this.listaLimpeza.getItems().add(a.getNome());
		}
	}
	
	//função que ativa ao clicar em um produto da lista de alimentos não pereciveis
	public void clicaAlimentoNP() {
		String produto = new String();
		produto = this.listaAlimentoNP.getSelectionModel().getSelectedItem();
		
		this.prod = Main.getBancoDados().buscarProduto(produto);
		
		this.texto.setText(prod.visualizar());
	}
	
	//função que ativa ao clicar em um produto da lista de alimentos pereciveis
	public void clicaAlimentoP() {
		String produto = new String();
		produto = this.listaAlimentoP.getSelectionModel().getSelectedItem();
		
		this.prod = Main.getBancoDados().buscarProduto(produto);
		
		this.texto.setText(prod.visualizar());
	}
	
	//função que ativa ao clicar em um produto da lista de ferramentas
	public void clicaFerramentas() {
		String produto = new String();
		produto = this.listaFerramenta.getSelectionModel().getSelectedItem();
		
		this.prod = Main.getBancoDados().buscarProduto(produto);
		
		this.texto.setText(prod.visualizar());
	}
	
	//função que ativa ao clicar em um produto da lista de limpeza
	public void clicaLimpeza() {
		String produto = new String();
		produto = this.listaLimpeza.getSelectionModel().getSelectedItem();
		
		this.prod = Main.getBancoDados().buscarProduto(produto);
		
		this.texto.setText(prod.visualizar());
	}
	
	//função que ativa ao clicar em um produto da lista de liquido
	public void clicaLiquido() {
		String produto = new String();
		produto = this.listaLiquido.getSelectionModel().getSelectedItem();
		
		this.prod = Main.getBancoDados().buscarProduto(produto);
		
		this.texto.setText(prod.visualizar());
	}
	

}
