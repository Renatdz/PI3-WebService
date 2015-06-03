package br.com.senac.ed.controller;

import br.com.senac.ed.model.ConsomeWeb;

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
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ListView;
import javax.swing.JOptionPane;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author Renato Mendes
 * @Updated Renato Mendes
 * Classe controle para montar a tela de busca do sistema. 
 */

//bug da lib do javafx que o eclipse nao reconhece.
@SuppressWarnings("restriction")

public class BuscaFunctionController implements Initializable {
	
	//VARIAVEIS DO LINKADAS AO FXML
    @FXML
    private TextField txTextoBusca;
    
    @FXML
    private Label txReturnText, txAutor, txPreco;
    
    @FXML
    private Button btBuscar, btSair;
    
    @FXML
    private ChoiceBox<String> cbSort, cbHistoric;
    
    @FXML
    private ListView<String> listaHistorico = new ListView<String>();
    
    @FXML
    private ListView<String> lista = new ListView<String>();
   
    //VARIAVEIS AUXILIARES DE BUSCA
    private List<String> tituloAux = new ArrayList<String>();
    private List<String> precoAux  = new ArrayList<String>();
    private List<String> autorAux  = new ArrayList<String>();
    private ObservableList<String> titulosLista = FXCollections.observableArrayList();  
    
   
	/**
	 * 
	 * Metodo para dar as funcoes aos botoes e campos da tela. 
	 * 
	 */
    public void initialize(URL urls, ResourceBundle resources) {
    	//VERIFICA SE OS CHOICE BOX ESTAO VAZIOS
    	assert cbSort     != null : "fx:id=\"cbSort\" was not injected: check your FXML file 'busca.fxml'.";
    	assert cbHistoric != null : "fx:id=\"cbSort\" was not injected: check your FXML file 'busca.fxml'.";
    	
    	//CRIANDO AS OPCOES PARA OS CHOICE BOX
    	final ObservableList<String> ordenacao = FXCollections.observableArrayList();
    	ordenacao.addAll("Buble","Sort");
    	final ObservableList<String> armazenamento = FXCollections.observableArrayList();
    	armazenamento.addAll("Banco","Arquivo");
    	
    	//SETANDO OS CHOICE BOX
    	cbSort.setItems(ordenacao);
    	cbHistoric.setItems(armazenamento);
    	
    	//ACOES DOS BOTOES 	
    	cbSort.getSelectionModel().selectedIndexProperty().addListener(new
    			ChangeListener<Number>() {
					public void changed(ObservableValue<? extends Number> ov,
							Number value, Number new_value) {
							ordenarPor(ordenacao.get(new_value.intValue()));
					}
    	});
    	
    	cbHistoric.getSelectionModel().selectedIndexProperty().addListener(new
    			ChangeListener<Number>() {
					public void changed(ObservableValue<? extends Number> ov,
							Number value, Number new_value) {
								try {
									armazenarPor(armazenamento.get(new_value.intValue()));
								} catch (IOException e) {
									System.err.println(e.getMessage());
								}
					}
    	});
    	
    	btBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
					busca();
				} catch (IOException e) {
					e.getMessage();
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
	 * 
	 */
	private void sair(){
		try {
            new LoginViewController().start(new Stage());
            BuscaViewController.getStage().close();
        } catch (Exception e) {
            e.getMessage();
        }
	}
	
	/**
	 * 
	 * Metodo para buscar produtos. 
	 * @throws IOException 
	 * 
	 */
	private void busca() throws IOException {
        if (txTextoBusca.getText().equals("")) {
        	JOptionPane.showMessageDialog(null, "Busca vazia", "Erro", JOptionPane.ERROR_MESSAGE);
        }else{
        	//LIMPA LISTA DO FX
        	lista.getItems().clear();
        	
        	//ADICIONA A LISTA DO HISTORICO
        	ObservableList<String> itens = FXCollections.observableArrayList (txTextoBusca.getText());
        	itens.addAll(listaHistorico.getItems());
        	listaHistorico.setItems(itens);
        	
        	//RETORNA MENSAGEM DE RESULTADO
        	String mensagem = "Resultados encontrados para: " + txTextoBusca.getText();
        	txReturnText.setText(mensagem); 
	        	
        	//CONCATENA URL E ADICIONA O TEXTO A URL
        	BuscaCiaDoLivro cia = new BuscaCiaDoLivro(txTextoBusca.getText());
    		//BuscaAmericanas americanas = new BuscaAmericanas(txTextoBusca.getText());
    		cia.geraURL();
    		//americanas.geraURL();
    
    		//BUSCA HTML EM CIA DOS LIVROS E AMERICANAS
    		ConsomeWeb consumoWeb = new ConsomeWeb();
    		String retornoPaginaCia = consumoWeb.consumirSite(cia.getURL());
    		//String retornoPaginaAmericanas = consumoWeb.consumirSite(americanas.getURL());
	    		
    		//FAZ O PARSE DO HTML E RETORNA TITULO/PRECO/AUTOR
    		ParseHtml parseHTML = new ParseHtml(retornoPaginaCia);
    		Elements nomesCiaDoLivro   = parseHTML.tituloCiaDoLivro();
    		Elements precoCiaDoLivro   = parseHTML.precoCiaDoLivro();  
    		Elements detalheCiaDoLivro = parseHTML.autorCiaDoLivro();
	    		
    		//ADICIONA TITULO/PRECO/AUTOR AS LISTAS
    		for (Element title : nomesCiaDoLivro)
    			tituloAux.add(title.text());
       		
    		for (Element prize : precoCiaDoLivro)
    			precoAux.add(prize.text());
    		
    		for (Element link : detalheCiaDoLivro)
    			autorAux.add(link.text());
	
    		//RESOLVE BUG QUE RETORNA STRING RESULTS
    		tituloAux.remove(0);
    		tituloAux.remove(tituloAux.size()-1);
    			
	    	//CRIA UMA LISTA DE LIVROS
			final List<Livro> livros = new ArrayList<Livro>();	
    		for (int i = 0; i < tituloAux.size(); i++) {
    			Livro livro = new Livro();
    			livro.setTitulo(tituloAux.get(i));
    			livro.setPreco(precoAux.get(i));
    			livro.setAutor(autorAux.get(i));
    			
    			livros.add(livro);
			}

    		//ADICIONA OS TITULOS EM UM OBSERVABLE LIST
    		for(int i = 0; i < livros.size(); i++)
    			titulosLista.add(livros.get(i).getTitulo());
    		
    		//SETA OS TITULOS NA LISTA DO FX.
    		lista.setItems(titulosLista);
    		
    		//ACAO PARA QUANDO HOUVER UM CLIQUE EM UM LIVRO, MOSTRAR OS DETALHES.
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
	 * Metodo para ordenar a listView com o algoritmo que o usuario escolher. 
	 * 
	 */
	private void ordenarPor(String ordenacao) {
		Ordenacao ordenar = new Ordenacao();
		
		if(ordenacao != null && ordenacao == "Buble")
			ordenar.ordenarComBuble(titulosLista);
		else
			ordenar.ordenarComSort(titulosLista);
		
		lista.setItems(titulosLista);
	}
	
	/**
	 * 
	 * Metodo armazenar o historico em qual local o usuario escolher 
	 * @throws IOException 
	 * 
	 */
	private void armazenarPor(String armazenamento) throws IOException {
		Historico historico = new Historico();
		
		if(armazenamento != null && armazenamento == "Banco"){
			historico.adicionaNoBanco(txTextoBusca.getText());
		}else{
			if(txTextoBusca.getText() != null){
				historico.adicionaNoArquivo(txTextoBusca.getText());
			}
		}
	}
	
}