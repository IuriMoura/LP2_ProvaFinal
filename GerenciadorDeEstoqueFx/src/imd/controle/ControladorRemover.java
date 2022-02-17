package imd.controle;


import imd.modelo.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControladorRemover {
	
	@FXML
	private TextField nome;
	
	@FXML
	private TextArea texto;
	
	@FXML
	private Label label;
	
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
	
	//ativa o botão excluir
	@FXML
	public void exclui(ActionEvent event) {
		int count = 0;
		if(this.nome.getText().isEmpty()) {
			label.setText("Por favor digite o nome\ndo produto");
			count++;
		}
		this.prod = Main.getBancoDados().buscarProduto(this.nome.getText());
		if(this.prod == null) {
			//impede mostrar a mensagem se o label esta vazio
			if(count == 0)
				this.label.setText("Produto não existente");
			this.texto.setText("");
		}
		else {
			this.texto.setText(this.prod.visualizar());
			Main.getBancoDados().removerProduto(prod);
			this.label.setText("Produto removido!");
		}
	}
	
	//ativa o botão buscar
	@FXML
	public void busca(ActionEvent event) {
		int count = 0;
		if(this.nome.getText().isEmpty()) {
			label.setText("Por favor digite o nome\ndo produto");
			count++;
		}
		this.prod = Main.getBancoDados().buscarProduto(this.nome.getText());
		if(this.prod == null) {
			//impede mostrar a mensagem se o label esta vazio
			if(count == 0)
				this.label.setText("Produto não existente");
			this.texto.setText("");
		}
		else {
			this.texto.setText(this.prod.visualizar());
			this.label.setText("Produto encontrado!");
		}
	}
	
}
