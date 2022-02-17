package imd.controle;


import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;

public class MudaTela {
	private Stage stage;
	private Scene cena;
	private Parent raiz;
	
	@FXML
	public void mudaCenaPrincipal(ActionEvent event) throws IOException {
		this.raiz = FXMLLoader.load(getClass().getResource("../visao/TelaPrincipal.fxml"));
		this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		this.stage.setTitle("Gerenciador de Estoque");
		this.cena = new Scene(this.raiz);
		this.stage.setScene(this.cena);
		this.stage.show();
	}
	@FXML
	public void mudaCenaAdicionar(ActionEvent event) throws IOException {
		this.raiz = FXMLLoader.load(getClass().getResource("../visao/Adicionar.fxml"));
		this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		stage.setTitle("Adicionar Produto - Gerenciador de Estoque");
		this.cena = new Scene(this.raiz);
		this.stage.setScene(this.cena);
		this.stage.show();
	}
	@FXML
	public void mudaCenaRemover(ActionEvent event) throws IOException {
		this.raiz = FXMLLoader.load(getClass().getResource("../visao/Remover.fxml"));
		this.stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
		
		stage.setTitle("Remover Produto - Gerenciador de Estoque");
		this.cena = new Scene(this.raiz);
		this.stage.setScene(this.cena);
		this.stage.show();
	}
	
	@FXML
	public void mudaCenaProcurar(ActionEvent event) throws IOException {
		this.raiz = FXMLLoader.load(getClass().getResource("../visao/Buscar.fxml"));
		this.stage = (Stage)((Node)event.getSource()).getScene().getWindow(); 
		
		stage.setTitle("Procurar Produto - Gerenciador de Estoque");
		this.cena = new Scene(this.raiz);
		this.stage.setScene(this.cena);
		this.stage.show();
	}
	
	@FXML
	public void mudaTelaTeste(ActionEvent event) throws IOException {
		this.raiz = FXMLLoader.load(getClass().getResource("../visao/Teste.fxml"));
		this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		
		this.stage.setTitle("Gerenciador de Estoque");
		this.cena = new Scene(this.raiz);
		this.stage.setScene(this.cena);
		this.stage.show();
	}
}
