package br.com.senac.ed.controller;

import br.com.senac.ed.model.Search;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.swing.JOptionPane;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author vinicius
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
    private ListView<String> listaa = new ListView<String>();
    
    @FXML
    private TableView<String> table = new TableView<String>();
    
   // @FXML
   // private TableColumn;
    
    
    //ArrayList <String> livro = new ArrayList<String>();
   // ArrayList <String> precoString = new ArrayList <String>();
   
    String busca;
	@Override
	/**
	 * 
	 * MÃ©todo para dar as funcoes aos botoes e campos da tela. 
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
	 * Metodo para voltar a tela de login. 
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
	 * Metodo para buscar produtos. 
	 * @throws IOException 
	 */
	private void busca() throws IOException {
        if (txTextoBusca.getText().equals("")) {
        	JOptionPane.showMessageDialog(null, "Busca vazia", "Erro", JOptionPane.ERROR_MESSAGE);
        }else{
        	//adiciona ao histÃ³rico
        	ObservableList<String> itens = FXCollections.observableArrayList (txTextoBusca.getText());
        	itens.addAll(lista.getItems());
        	lista.setItems(itens);
        	
        	//retorna mensagem
        	String mensagem = "Resultados encontrados para: " + txTextoBusca.getText();
        	busca = txTextoBusca.getText();
        	txReturnText.setText(mensagem); 
        	
        	//busca o texto na url
        	BuscaCiaDoLivro cia = new BuscaCiaDoLivro(txTextoBusca.getText());
    		Search consumoWeb = new Search();
    		//concatena a url
    		cia.geraURL();
    		//busca o html
    		String retorno = consumoWeb.consumirSite(cia.getURL());
    		
    		//retira as partes importantes
    		FluxoUrlController fluxoUrl = new FluxoUrlController();
    		TituloLivro titulo = new TituloLivro();
    
    		
    		//criação dos Elements para retornar as informações do http
    		Elements nomes = fluxoUrl.tituloCiaDoLivro(retorno);
    		Elements preco = fluxoUrl.precoCiaDoLivro(retorno);  
    		Elements detalhe = fluxoUrl.Detalhe(retorno);
    		
    		
    		for (Element link : detalhe){
    		 System.out.println(link.attr("abs:href"));
    		 titulo.detalhes.add(link.text());
    		 
    		}
    	
    		
    		
    		//adiciona um titulo à lista
    		for(Element title : nomes){
    			titulo.livro.add(title.text());
    			
    		}
    		System.out.println ("Detalhe"+ titulo.detalhes);
    	  
       		
    	//	for (Element prize : preco){
    		//	titulo.precoString.add(prize.text());
    	//	}
    	
    		try {
	    		for (int x = 0; x <=titulo.livro.size(); x++) {
		    		System.out.println ("Livro: " + titulo.livro.get(x)); 
		    		ObservableList<String> livros = FXCollections.observableArrayList(titulo.livro);
		    		//ObservableList<String> valor = FXCollections.observableArrayList(precoString);
		    		listaa.setItems(livros);
	    		}
    		} catch (IndexOutOfBoundsException e){
    			System.out.println ("----------------------------------------------------------------------------");
    			System.out.println ("É necessário verificar este Array, pois está duplicando");
    		}
    		
        	
	    		
//    		WebView web = new WebView();
//    		web.getEngine().load(retorno);
//    		BuscaViewController.getStage().setScene(web.getScene());
    		  		 
        }    
    } 
    
		
}
