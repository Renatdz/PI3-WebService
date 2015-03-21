import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.JOptionPane;


/**
 * @author renato1mendes
 *	Classe para buscar os produtos
 */
public class Busca extends Application {

	private AnchorPane pane;
    private TextField txTexto;
    private Button btBuscar, btSair;
    private static Stage stage;
	
    @Override
    
    /**
     * Main da classe (só precisa na principal página, nas outras escrevemos //@Override)
     *
     */
	public void start(Stage stage) throws Exception {        
        initComponents();
        initListeners();
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        // Remove a opção de maximizar a tela
        stage.setResizable(false);
        // Dá um título para a tela
        stage.setTitle("Busca - PI");
        stage.show();
        initLayout();
        Busca.stage = stage;
    }
    
    /**
     * pega o cenário (tela) atual
     *
     */
    public static Stage getStage() {
        return stage;
    }
    
    /**
     * Método para criar os objetos da tela, assim como o tamanho e o css da mesma. 
     *
     */
    private void initComponents() {
        pane = new AnchorPane();
        pane.setPrefSize(400, 300);
        pane.setStyle("-fx-background-color: linear-gradient(from 0% 0% to 100% 100%, blue 0%, silver 100%);");
        txTexto = new TextField();
        txTexto.setPromptText("Pesquise um livro...");
        
        btBuscar = new Button("Buscar");
        btSair   = new Button("Sair");
        
        pane.getChildren().addAll(txTexto, btBuscar, btSair);
    }
    
    /**
     * Método para definir o tamanho e a posicão dos objetos
     *
     */
    private void initLayout() {
    	txTexto.setLayoutX((pane.getWidth() - txTexto.getWidth()) / 2);
    	txTexto.setLayoutY(50);
    	btBuscar.setLayoutX((pane.getWidth() - btBuscar.getWidth()) / 2);
    	btBuscar.setLayoutY(150);
        btSair.setLayoutX((pane.getWidth() - btSair.getWidth()) / 2);
        btSair.setLayoutY(200);
    }
    
    /**
     * Método para criar as acões dos botões
     *
     */
    private void initListeners() {
    	btBuscar.setOnAction(new EventHandler<ActionEvent>() {
        @Override
            public void handle(ActionEvent event) {
                buscar();
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
     * Método para buscar um produto no sistema
     *
     */
    private void buscar() {
    	if (txTexto.getText().equals("")) {
    		JOptionPane.showMessageDialog(null, "Digite o nome de um livro", "Erro", JOptionPane.ERROR_MESSAGE);
        }else{
        	// Desenvolver retorno da frase <Nada encontrado>". 
        }    
    }
    
    /**
     * Método para sair do sistema e voltar a tela de login
     *
     */
    private void sair() {
    	try {
            new Login().start(new Stage());
            Busca.getStage().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
	
}
