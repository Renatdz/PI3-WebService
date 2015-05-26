package br.com.senac.ed.controller;

import br.com.senac.ed.controller.LoginViewController;
import br.com.senac.ed.controller.BuscaViewController;

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
 * @author Renato Mendes
 * @update Vinicius Reis
 * Classe controle para montar a tela de login do sistema. 
 * 
 */

//bug da lib do javafx que o eclipse nao reconhece.
@SuppressWarnings("restriction")
public class LoginFunctionController implements Initializable {
	
	//variaveis para o fxml
    @FXML
    private TextField txLogin;
    @FXML
    private PasswordField txSenha;
    @FXML
    private Button btEntrar, btSair;
    
	@Override
	
	/**
	 * 
	 * Método para dar as funcoes aos botoes e campos da tela. 
	 */
    public void initialize(URL urls, ResourceBundle resources) {
    	btEntrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
                public void handle(ActionEvent event) {
                    logar();
                }
            });
    	btSair.setOnAction(new EventHandler<ActionEvent>() {
            @Override
	            public void handle(ActionEvent event) {
	                fecharAplicacao();
	            } 
        });
    }
	
	/**
	 * 
	 * Método para fechar a janela de aplicacao. 
	 */
	private void fecharAplicacao(){
		System.exit(0);
	}
	
	/**
	 * 
	 * Método para logar no sistema. 
	 */
	private void logar() {
        if (txLogin.getText().equals("admin") && txSenha.getText().equals("admin")) {
        	try {
                new BuscaViewController().start(new Stage());
                LoginViewController.getStage().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Login e/ou senhainválidos", "Erro", JOptionPane.ERROR_MESSAGE);
        }    
    } 
    
}
