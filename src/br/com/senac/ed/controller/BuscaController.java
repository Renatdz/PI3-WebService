package br.com.senac.ed.controller;

import br.com.senac.ed.view.Busca;
import br.com.senac.ed.view.Login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.JOptionPane;

/**
 * @author renato1mendes
 * Classe controle para montar a tela de busca do sistema. 
 */
public class BuscaController implements Initializable {
	
	//variaveis para o fxml
    @FXML
    private TextField txTextoBusca;
    
    @FXML
    private Button btBuscar, btSair;
    
	@Override
	
	/**
	 * 
	 * Método para dar as funcoes aos botoes e campos da tela. 
	 */
    public void initialize(URL urls, ResourceBundle resources) {
    	btBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
                public void handle(ActionEvent event) {
                    busca();
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
            new Login().start(new Stage());
            Busca.getStage().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	/**
	 * 
	 * Método para buscar produtos. 
	 */
	private void busca() {
        if (txTextoBusca.getText().equals("")) {
        	JOptionPane.showMessageDialog(null, "Busca vazia", "Erro", JOptionPane.ERROR_MESSAGE);
        }else{
            //fazer lógica
        }    
    } 
    
}
