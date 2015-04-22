package br.com.senac.ed.controller;

import br.com.senac.ed.model.Search;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Priority;




import javax.swing.JOptionPane;
import javax.swing.ListCellRenderer;

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
    private Label txReturnText, txAutor, txPreco;
    
    @FXML
    private Button btBuscar, btSair,btOrderCres,btOrderDecres;
    
    @FXML
    private ListView<String> listaHistorico = new ListView<String>();
    
    @FXML
    private ListView<String> lista = new ListView<String>();
   
    private String busca;
    private TituloLivro titulo = new TituloLivro();
    private ObservableList<String> titulos = FXCollections.observableArrayList();  
    private ObservableList<String> precos = FXCollections.observableArrayList();
  
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
    	btOrderCres.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ordenarCres();
            }
        });
    	btOrderDecres.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ordenarDecres();
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
        	//adiciona ao historico
        	ObservableList<String> itens = FXCollections.observableArrayList (txTextoBusca.getText());
        	itens.addAll(listaHistorico.getItems());
        	listaHistorico.setItems(itens);
        	
        	//limpa a lista de resultados.
        	titulos.clear();
        	lista.getItems().clear();
        	
        	
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
    		
    		//criação dos Elements para retornar as informações do http
    		Elements nomes = fluxoUrl.tituloCiaDoLivro(retorno);
    		Elements preco = fluxoUrl.precoCiaDoLivro(retorno);  
    		Elements detalhe = fluxoUrl.Detalhe(retorno);
    		
    		//adiciona um titulo à lista
    		for (Element title : nomes)
    			titulo.livro.add(title.text());
       		
    		for (Element prize : preco)
    			titulo.precoString.add(prize.text());
    		
    		for (Element link : detalhe)
    			titulo.detalhes.add(link.text());
    		
    		while(titulo.livro.size() != titulo.precoString.size()){
    			titulo.precoString.add("R$ 43:59");
    		}
    		
    		while(titulo.livro.size() != titulo.detalhes.size()){
    			titulo.detalhes.add("Frank Muller");
    		}
    		
    		final List<Livro> livros = new ArrayList<Livro>();
    			
    		for (int i = 0; i < titulo.livro.size(); i++) {
    			Livro livro = new Livro();
    			livro.setTitulo(titulo.livro.get(i));
    			livro.setPreco(titulo.precoString.get(i));
    			livro.setAutor(titulo.detalhes.get(i));
    			
    			livros.add(livro);
			}
    		
    		//apaga os indices inicio e fim do conteudo.
    		livros.remove(0);
    		livros.remove(livros.size()-1);
    		
    		for(int i = 0; i < livros.size(); i++)
    			titulos.add(livros.get(i).getTitulo());
    		
    		lista.setItems(titulos);
    		
    		lista.getSelectionModel().selectedItemProperty().addListener(
	            new ChangeListener<String>() {
	                public void changed(ObservableValue<? extends String> ov, 
	                    String old_val, String new_val) {   
	                	for(int i = 0; i < livros.size(); i++){
	                		if(new_val == livros.get(i).getTitulo()){
	                			txAutor.setText(livros.get(i).getPreco());
	                			txPreco.setText(livros.get(i).getAutor());
	                			break;
	                		}
	                	}    
	                }
	            }
	        );
    		
    		
    	
    		
 
        }    
    }
	
	
	/**
	 * 
	 * Metodo para ordenar a listView de forma crescente. 
	 * 
	 */
	private void ordenarCres() {
		
		OrdenaTitulo ordenador = new OrdenaTitulo();
		
		ordenador.ordernarCrescente(titulos);
		
		lista.setItems(titulos);
		
	}
	
	/**
	 * 
	 * Metodo para ordenar a listView de forma decrescente. 
	 *  
	 */
	private void ordenarDecres() {
		
		OrdenaTitulo ordenador = new OrdenaTitulo();
		
		ordenador.ordenarDecrescente(titulos);
		
		lista.setItems(titulos);
		
	}
	
}