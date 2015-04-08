package br.com.senac.ed.controller;


import br.com.senac.ed.controller.*;
import br.com.senac.ed.model.JsoupCiaDoLivro;
import br.com.senac.ed.model.Search;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.web.WebView;
import javafx.scene.web.WebViewBuilder;
import javafx.stage.Stage;

import javax.swing.JOptionPane;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author renato1mendes
 * Classe controle para montar a tela de busca do sistema. 
 */
public class BuscaFunctionController implements Initializable {
	
	//variaveis para o fxml
    @FXML
    private TextField txTextoBusca;
    
    @FXML
    private Label txReturnText;
    
    @FXML
    private Button btBuscar, btSair;
    
    @FXML
    private ListView<String> lista = new ListView<String>();
    
    @FXML
    private ListView<String> listResult = new ListView<String>();
    
    @FXML
    private TableView<String> table = new TableView<String>();
    
    @FXML
    private TableColumn nome, preco;
    
    @FXML
    private WebView web;
    
   
    
	@Override
	/**
	 * 
	 * Método para dar as funcoes aos botoes e campos da tela. 
	 */
    public void initialize(URL urls, ResourceBundle resources) {
    	btBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
                public void handle(ActionEvent event) {
                    try {
						busca();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                }
            });
    	btSair.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                sair();
            } 
        });
    }
	
	/**
	 * 
	 * Método para voltar a tela de login. 
	 */
	private void sair(){
		try {
            new LoginViewController().start(new Stage());
            BuscaViewController.getStage().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * 
	 * Método para buscar produtos. 
	 * @throws IOException 
	 */
	private void busca() throws IOException {
        if (txTextoBusca.getText().equals("")) {
        	JOptionPane.showMessageDialog(null, "Busca vazia", "Erro", JOptionPane.ERROR_MESSAGE);
        }else{
        	//adiciona ao histórico
        	ObservableList<String> itens = FXCollections.observableArrayList (txTextoBusca.getText());
        	itens.addAll(lista.getItems());
        	lista.setItems(itens);
        	
        	//retorna mensagem
        	String mensagem = "Resultados encontrados para: " + txTextoBusca.getText();
        	txReturnText.setText(mensagem); 
        	
        	//busca o texto na url
        	BuscaCiaDoLivro cia = new BuscaCiaDoLivro(txTextoBusca.getText());
    		Search consumoWeb = new Search();
    		//concatena a url
    		cia.geraURL();
    		//busca o html
    		String retorno = consumoWeb.consumirSite(cia.getURL());
    		
    		//retira as partes importantes
    		JsoupCiaDoLivro jcdl = new JsoupCiaDoLivro();
    		
    		//list para inserir na tabela
    		ObservableList<String> precos = FXCollections.observableArrayList();
    		
    		Elements nomes = jcdl.acharTituloCiaDoLivro(retorno);
    		Elements preco = jcdl.acharPrecoCiaDoLivro(retorno);
//        	
//    		for(Element price : preco)
//    			precos.add(price.text());
    		
//    		for(Element title : nomes)
//    			precos.add(title.text());
    		
    		for(Element title : nomes)
    			System.out.println(title.text());
    		
    		for (Element prize : preco)
    			System.out.println (prize.text());
    		
    		WebView web = new WebView();
    		web.getEngine().load(retorno);
    		BuscaViewController.getStage().setScene(web.getScene());
    		   		 
        }    
    } 
    
		
}
