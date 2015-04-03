import br.com.senac.ed.model.Search;
import br.com.senac.ed.model.Login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main {
	public static void main(String[] args) throws Exception {
		
		Search consumoWeb = new Search();
		
		System.out.println(consumoWeb.consumirSite("o+simbolo+perdido"));
		//parametro busca ex: o+simbolo+perdido 
		
	}
	
	public Main() {
		super();
	}

}