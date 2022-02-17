package imd.controle;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import imd.modelo.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class ControlaAdicionar implements Initializable {
	
	@FXML
	private Label notificacao;
	@FXML
	private TextField textoNome;
	@FXML
	private TextField marca;
	@FXML
	private TextField preco;
	@FXML
	private TextField fornecedor;
	@FXML
	private TextField quantidade;
	@FXML
	private TextArea descricao;
	@FXML
	private TextField util;
	@FXML
	private TextField material;
	@FXML
	private TextField mililitro;
	@FXML
	private DatePicker fabricacao;
	@FXML
	private DatePicker validade;
	@FXML
	private RadioButton botaoBooleano;
	@FXML
	private ChoiceBox<String> tipo;
	
	private String[] tipos = {"Alimento não perecivel", "Alimento perecivel", "Ferramentas", 
			"Limpeza", "Liquido"};
	
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
	
	//ativa o botao de adicionar
	@FXML
	public void adicionar(ActionEvent event) throws IOException {
		LocalDate agora = LocalDate.now();
		String mensagem = new String("");
		int count = 0;
		//chama o evento novamente para resentar o this.prod
		this.getTipo(event);
		if(this.textoNome.getText().isEmpty()) {
			//System.out.println("Por favor digite o nome do produto");
			mensagem += "Por favor digite o nome do produto \n";
			count++;
		}
		if(this.preco.getText().isEmpty()) {
			//System.out.println("Por favor digite o preço do produto");
			mensagem += "Por favor digite o preço do produto \n";
			count++;
		}
		if(this.quantidade.getText().isEmpty()) {
			//System.out.println("Por favor digite a quantidade de produtos");
			mensagem += "Por favor digite a quantidade de produtos \n";
			count++;
		}
		if(this.marca.getText().isEmpty()) {
			//System.out.println("Por favor digite a marca do produto");
			mensagem += "Por favor digite a marca do produto \n";
			count++;
		}
		if(this.descricao.getText().isEmpty()) {
			//System.out.println("Por favor digite a descrição do produto");
			mensagem += "Por favor digite a descrição do produto \n";
			count++;
		}
		if(this.fornecedor.getText().isEmpty()) {
			//System.out.println("Por favor digite o fornecedor do produto");
			mensagem += "Por favor digite o fornecedor do produto \n";
			count++;
		}
		if(this.fabricacao.getValue() == null) {
			//System.out.println("Por favor escolha a data de fabricação do produto");
			mensagem += "Por favor escolha a data de fabricação do produto \n";
			count++;
		}
		//testa se a data de faricação não é depois da data de hoje
		if(this.fabricacao.getValue() != null && this.fabricacao.getValue().isAfter(agora)) {
			//System.out.println("Data de fabricação invalidade, data é depois de hoje");
			mensagem += "Data de fabricação invalidade, data é depois de hoje \n";
			count++;
		}
		if(this.prod instanceof AlimentoNaoPerecivel) {
			if(this.validade.getValue() == null) {
				//System.out.println("Por favor escolha a data de validade do produto");
				mensagem += "Por favor escolha a data de validade do produto \n";
				count++;
			}
		}
		if(this.prod instanceof AlimentoPerecivel) {
			if(this.util.getText().isEmpty()) {
				//System.out.println("Por favor digite a quantidade de meses que o produto ira durar");
				mensagem += "Por favor digite a quantidade de meses que o produto ira durar \n";
				count++;
			}
		}
		if(this.prod instanceof Ferramentas) {
			if(this.util.getText().isEmpty()) {
				//System.out.println("Por favor digite a quantidade de meses que o produto ira durar");
				mensagem += "Por favor digite a quantidade de meses que o produto ira durar \n";
				count++;
			}
			if(this.material.getText().isEmpty()) {
				//System.out.println("Por favor digite o materia do produto");
				mensagem += "Por favor digite o materia do produto \n";
				count++;
			}
		}
		if(this.prod instanceof Limpeza) {
			 if(this.validade.getValue() == null) {
				//System.out.println("Por favor escolha a data de validade do produto");
				mensagem += "Por favor escolha a data de validade do produto \n";
				count++;
			}
		}
		if(this.prod instanceof Liquido) {
			if(this.validade.getValue() == null) {
				//System.out.println("Por favor escolha a data de validade do produto");
				mensagem += "Por favor escolha a data de validade do produto\n";
				count++;
			}
			if(this.mililitro.getText().isEmpty()) {
				//System.out.println("Por favor escolha a litragem em mililiro do produto");
				mensagem += "Por favor escolha a litragem em mililiro do produto \n";
				count++;
			}
		}
		int count2 = 0;
		
		//se todos os campos foram preenchidos, adiciona o produto ao BancoDados
		if(count == 0) {
			//inicia os atributos de produto
			this.prod.setNome(this.textoNome.getText());
			this.prod.setDescricao(this.descricao.getText());
			this.prod.setFornecedor(this.fornecedor.getText());
			this.prod.setMarca(this.marca.getText());
			this.prod.setDataDeFabricacao(this.fabricacao.getValue());
			//só aceita numeros
			try {
				this.prod.setPreco(Double.parseDouble(preco.getText()));
				//testa se é positivo
				if(this.prod.getPreco() <= 0) {
					count2++;
					this.notificacao.setText("Valor do preço incorreto,\npor favor passe um valor positivo");
				}
			} catch (Exception e) {
				this.notificacao.setText("Valor de preço incorreto,\npor favor passe um valor double");
				count2++;
			}
			//só aceita numeros
			try {
				this.prod.setQuantidade(Double.parseDouble(quantidade.getText()));
				//testa se é positivo
				if(this.prod.getQuantidade() <= 0) {
					count2++;
					this.notificacao.setText("Valor da quantidade incorreto,\npor favor passe um valor positivo");
				}
			} catch (Exception e) {
				this.notificacao.setText("Valor da quantidade incorreto,\npor favor passe um valor inteiro");
				count2++;
			}
			//inicia os atributos por tipo de produto
			if(this.prod instanceof AlimentoNaoPerecivel) {
				((AlimentoNaoPerecivel)this.prod).setDataDeValidade(this.validade.getValue());
				//só aceita se a data de validade for depois da de fabricação
				if(this.validade.getValue().isBefore(this.fabricacao.getValue())) {
					this.notificacao.setText("Valor da data de validade é antes da fabricacao");
					count2++;
				}
				//só aceita se a data de validade for depoisd a data de hoje
				if(this.validade.getValue().isBefore(agora)) {
					this.notificacao.setText("Valor da data de validade é antes da data de hoje\nProduto vencido");
					count2++;
				}
			}
			if(this.prod instanceof AlimentoPerecivel) {
				//só aceita numeros
				try {
					((AlimentoPerecivel)this.prod).setMesesUtil(Integer.parseInt(this.util.getText()));
					//testa se é positivo
					if(((AlimentoPerecivel)this.prod).getMesesUtil() <= 0) {
						count2++;
						this.notificacao.setText("Valor da quantidade de meses incorreto,\npor favor passe um valor positivo");
					}
				} catch (Exception e) {
					this.notificacao.setText("Valor da quantidade de meses incorreto,\npor favor passe um valor inteiro");
					count2++;
				}
				((AlimentoPerecivel)this.prod).setCongelado(this.botaoBooleano.isPressed());
			}
			if(this.prod instanceof Ferramentas) {
				//só aceita numeros
				try {
					((Ferramentas)this.prod).setMesesUtil(Integer.parseInt(this.util.getText()));
					//testa se é positivo
					if(((Ferramentas)this.prod).getMesesUtil() <= 0) {
						this.notificacao.setText("Valor da quantidade de meses incorreto,\n por favor passe um valor positivo");
						count2++;
					}
				} catch (Exception e) {
					this.notificacao.setText("Valor da quantidade de meses incorreto,\n por favor passe um valor inteiro");
					count2++;
				}
				((Ferramentas)this.prod).setMaterial(this.material.getText());
			}
			if(this.prod instanceof Limpeza) {
				((Limpeza)this.prod).setDataDeValidade(this.validade.getValue());
				if(this.validade.getValue().isBefore(this.fabricacao.getValue())) {
					this.notificacao.setText("Valor da data de validade é antes da fabricacao");
					count2++;
				}
				//só aceita se a data de validade for depoisd a data de hoje
				if(this.validade.getValue().isBefore(agora)) {
					this.notificacao.setText("Valor da data de validade é antes da data de hoje\nProduto vencido");
					count2++;
				}
			}
			if(this.prod instanceof Liquido) {
				((Liquido)this.prod).setDataDeValidade(this.validade.getValue());
				if(this.validade.getValue().isBefore(this.fabricacao.getValue())) {
					this.notificacao.setText("Valor da data de validade é antes da fabricacao");
					count2++;
				}
				//só aceita se a data de validade for depoisd a data de hoje
				if(this.validade.getValue().isBefore(agora)) {
					this.notificacao.setText("Valor da data de validade é antes da data de hoje\nProduto vencido");
					count2++;
				}
				//só aceita numeros
				try {
					((Liquido)this.prod).setMililitro(Double.parseDouble(this.mililitro.getText()));
					//testa se é positivo
					if(((Liquido)this.prod).getMililitro() <= 0) {
						this.notificacao.setText("Valor de mililitro esta incorreto,\npor favor passe um valor positivo");
						count2++;
					}
				} catch (Exception e) {
					this.notificacao.setText("Valor de mililitro esta incorreto,\npor favor passe um valor double");
					count2++;
				}
				((Liquido)this.prod).setAlcool(this.botaoBooleano.isPressed());
			}
			//só adiciona se passar em todos os try
			if(count2 == 0) {
				this.notificacao.setText(Main.getBancoDados().adicionarProduto(this.prod));
			}
		}
		//mensagem do que falta ser preenchido se faltar algo
		else
			this.notificacao.setText(mensagem);	
	}

	//inicia o seletor de tipos de produto e
	//desabilita todas as caixas ate o usuario selecionar um tipo de produto
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.tipo.getItems().addAll(tipos);
		this.tipo.setOnAction(this::getTipo);
		
		this.botaoBooleano.setDisable(true);
		this.descricao.setDisable(true);
		this.fabricacao.setDisable(true);
		this.fornecedor.setDisable(true);
		this.marca.setDisable(true);
		this.material.setDisable(true);
		this.mililitro.setDisable(true);
		this.preco.setDisable(true);
		this.quantidade.setDisable(true);
		this.textoNome.setDisable(true);
		this.util.setDisable(true);
		this.validade.setDisable(true);
	}
	
	public void getTipo(ActionEvent event) {
		//quando escolhe o tipo habilita as caixas
		this.botaoBooleano.setDisable(false);
		this.descricao.setDisable(false);
		this.fabricacao.setDisable(false);
		this.fornecedor.setDisable(false);
		this.marca.setDisable(false);
		this.material.setDisable(false);
		this.mililitro.setDisable(false);
		this.preco.setDisable(false);
		this.quantidade.setDisable(false);
		this.textoNome.setDisable(false);
		this.util.setDisable(false);
		this.validade.setDisable(false);
		
		//muda quais caixas são necessarias para cada tipo de produto
		String escolha = this.tipo.getValue();
		if(escolha.equals("Alimento não perecivel")) {
			this.prod = new AlimentoNaoPerecivel();
			this.util.setDisable(true);
			this.material.setDisable(true);
			this.mililitro.setDisable(true);
			this.botaoBooleano.setDisable(true);
			this.validade.setDisable(false);
			
			this.mililitro.clear();
			this.material.clear();
			this.util.clear();
			this.botaoBooleano.setSelected(false);
			this.botaoBooleano.setText("");
		}
		if(escolha.equals("Alimento perecivel")) {
			this.prod = new AlimentoPerecivel();
			this.mililitro.setDisable(true);
			this.validade.setDisable(true);
			this.material.setDisable(true);
			this.botaoBooleano.setDisable(false);
			this.botaoBooleano.setText("é congelado?");
			this.util.setDisable(false);
			
			this.mililitro.clear();
			this.validade.setValue(null);
			this.material.clear();
			
		}
		if(escolha.equals("Ferramentas")) {
			this.prod = new Ferramentas();
			this.botaoBooleano.setDisable(true);
			this.mililitro.setDisable(true);
			this.validade.setDisable(true);
			this.util.setDisable(false);
			this.material.setDisable(false);
			
			this.mililitro.clear();
			this.botaoBooleano.setSelected(false);
			this.botaoBooleano.setText("");
			this.validade.setValue(null);
		}
		if(escolha.equals("Limpeza")) {
			this.prod = new Limpeza();
			this.util.setDisable(true);
			this.material.setDisable(true);
			this.mililitro.setDisable(true);
			this.botaoBooleano.setDisable(true);
			this.validade.setDisable(false);
			
			this.util.clear();
			this.material.clear();
			this.mililitro.clear();
			this.botaoBooleano.setSelected(false);
			this.botaoBooleano.setText("");
		}
		if(escolha.equals("Liquido")) {
			this.prod = new Liquido();
			this.util.setDisable(true);
			this.material.setDisable(true);
			this.botaoBooleano.setDisable(false);
			this.botaoBooleano.setText("é alcolico?");
			this.mililitro.setDisable(false);
			this.validade.setDisable(false);
			
			this.util.clear();
			this.material.clear();
		}
	}
}
