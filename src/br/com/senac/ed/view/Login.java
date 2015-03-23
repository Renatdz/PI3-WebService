package br.com.senac.ed.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * @author renato1mendes
 * Classe para logar no sistema de buscas 
 */
public class Login extends Application {
	
	private static Stage stage;
	
	@Override
	
	/**
     * Método para carregar o fxml e criar o cenário.
     *
     */
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("fxmls/login.fxml"));
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Tela de Login");
        stage.show();
        Login.stage = stage;
    }
	
	/**
     * Main da classe
     *
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Método para pegar o Stage (cenário)
     *
     */
    public static Stage getStage() {
        return stage;
    }  
}