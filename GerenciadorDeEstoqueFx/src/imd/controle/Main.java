package imd.controle;
	

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;


public class Main extends Application {
	
	private Stage primaryStage;
	private AnchorPane principal;
	private static BancoDados bd;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Gerenciador de Estoque");
		
		initMainStage();
	}
	
	private void initMainStage() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("../visao/TelaPrincipal.fxml"));
			this.principal = (AnchorPane) loader.load();
			
			Scene cena = new Scene(this.principal);
			this.primaryStage.setScene(cena);
			this.primaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public static BancoDados getBancoDados() {
		return bd;
	}

	public static void main(String[] args) {
		bd = new BancoDados();
		launch(args);
	}
}
