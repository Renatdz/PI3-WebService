package br.com.senac.ed.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



/**
 * @author renato1mendes
 * @update vinicius.ribeiro
 * Classe para montar a tela de busca do sistema. 
 * 
 */

//bug da lib do javafx que o eclipse nao reconhece.
@SuppressWarnings("restriction")
public class BuscaViewController extends Application {
	
	private static Stage stage;
	
	@Override
	
	/**
     * Método para carregar o fxml e criar o cenário.
     *
     */
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("../view/fxmls/busca.fxml"));
        Scene scene = new Scene(parent);
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Tela de Busca");
        stage.show();
        BuscaViewController.stage = stage;
    }
	
	/**
     * Método para pegar o Stage (cenário)
     *
     */
	public static Stage getStage() {
        return stage;
    }  
}