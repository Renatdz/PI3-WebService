package br.com.senac.ed.controller;

import br.com.senac.ed.model.Search;

import java.awt.Color;
import java.awt.Rectangle;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Observable;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.stage.Stage;
import javafx.util.Callback;

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
    private Label txReturnText;
    
    @FXML
    private Button btBuscar, btSair,btOrderCres,btOrderDecres;
    
    @FXML
    private ListView<String> listaHistorico = new ListView<String>();
    
    @FXML
    private ListView<String> lista = new ListView<String>();
   
    private String busca;
    private TituloLivro titulo = new TituloLivro();
    
  
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
        	//adiciona ao histÃ³rico
        	ObservableList<String> itens = FXCollections.observableArrayList (txTextoBusca.getText());
        	itens.addAll(listaHistorico.getItems());
        	listaHistorico.setItems(itens);
        	
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
    		
    		
    		for (Element link : detalhe)
    			 titulo.detalhes.add(link.text());    	
    		
    		//adiciona um titulo à lista
    		for (Element title : nomes)
    			titulo.livro.add(title.text());
       		
    		for (Element prize : preco)
    			titulo.precoString.add(prize.text());
 
    		OrdenaTitulo ordenador = new OrdenaTitulo();
    		
    		//setando titulo ordenado
    		titulo.setTitulos(ordenador.ordernarCrescente(titulo.livro)); 
    		
    		ObservableList<String> livros = FXCollections.observableArrayList(titulo.livro);
    		//ObservableList<String> valor = FXCollections.observableArrayList(titulo.precoString);
    		lista.setItems(livros);
    		
    		ObservableList names = FXCollections.observableArrayList();
    		
    		names.addAll(
    	             "Adam", "Alex", "Alfred", "Albert",
    	             "Brenda", "Connie", "Derek", "Donny", 
    	             "Lynne", "Myrtle", "Rose", "Rudolph", 
    	             "Tony", "Trudy", "Williams", "Zach"
    	        );
    		
    		lista.setEditable(true);
    		lista.setCellFactory(ComboBoxListCell.forListView(names));              
 
        }    
    }
	
	
	/**
	 * 
	 * Metodo para ordenar a listView de forma crescente. 
	 * 
	 */
	private void ordenarCres() {
		
		OrdenaTitulo ordenador = new OrdenaTitulo();
		
		ObservableList<String> titulos = FXCollections.observableArrayList(ordenador.ordernarCrescente(titulo.getTitulos()));
		
		lista.setItems(titulos);
		
	}
	
	/**
	 * 
	 * Metodo para ordenar a listView de forma decrescente. 
	 *  
	 */
	private void ordenarDecres() {
		
		OrdenaTitulo ordenador = new OrdenaTitulo();
		
		ObservableList<String> titulos = FXCollections.observableArrayList(ordenador.ordenarDecrescente(titulo.getTitulos()));
		
		lista.setItems(titulos);
		
	}
	
}