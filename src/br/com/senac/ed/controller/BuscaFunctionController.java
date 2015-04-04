package br.com.senac.ed.controller;


import br.com.senac.ed.controller.*;
import br.com.senac.ed.model.Search;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.swing.JOptionPane;

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
        	
        	
        	//retorna mensagem
        	String mensagem = "Resultados encontrados para: " + txTextoBusca.getText();
        	txReturnText.setText(mensagem); 
        	
        	//busca o texto na url
        	BuscaCiaDoLivro cia = new BuscaCiaDoLivro(txTextoBusca.getText());
    		Search consumoWeb = new Search();
    		
    		cia.geraURL();
    		String retorno = consumoWeb.consumirSite(cia.getURL());
        	
            System.out.println(retorno); 
        }    
    } 
    
}
