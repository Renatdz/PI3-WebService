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
 * Classe para logar no sistema de busca 
 */
public class Login extends Application {
    
    private AnchorPane pane;
    private TextField txLogin;
    private PasswordField txSenha;
    private Button btEntrar, btSair;
    private static Stage stage;
 
    /**
     * Main da classe (só precisa na principal página, nas outras escrevemos //@Override)
     *
     */
    public static void main(String [] args){
    	launch(args);
    }
       
    /**
     * Método que inicia a tela (cenário)
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
        stage.setTitle("Login - PI");
        stage.show();
        initLayout();
        Login.stage = stage;
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
        txLogin = new TextField();
        txLogin.setPromptText("Digite seu login...");
        
        txSenha = new PasswordField();
        txSenha.setPromptText("Digite aqui sua senha");
        
        btEntrar = new Button("Entrar");
        btSair = new Button("Sair");
        
        pane.getChildren().addAll(txLogin, txSenha, btEntrar, btSair);
    }
    
    
    /**
     * Método para definir o tamanho e a posicão dos objetos
     *
     */
    private void initLayout() {
        txLogin.setLayoutX((pane.getWidth() - txLogin.getWidth()) / 2);
        txLogin.setLayoutY(50);
        txSenha.setLayoutX((pane.getWidth() - txSenha.getWidth()) / 2);
        txSenha.setLayoutY(100);
        btEntrar.setLayoutX((pane.getWidth() - btEntrar.getWidth()) / 2);
        btEntrar.setLayoutY(150);
        btSair.setLayoutX((pane.getWidth() - btSair.getWidth()) / 2);
        btSair.setLayoutY(200);
    }
    
    /**
     * Método para criar as acões dos botões
     *
     */
    private void initListeners() {
        btSair.setOnAction(new EventHandler<ActionEvent>() {
        @Override
            public void handle(ActionEvent event) {
                fecharAplicacao();
            } 
        });
        
        btEntrar.setOnAction(new EventHandler<ActionEvent>() {
        @Override
            public void handle(ActionEvent event) {
                logar();
            }
        });

    }
    
    /**
     * Método para fechar a tela
     *
     */
    private void fecharAplicacao() {
        System.exit(0);
    }
    
    
    /**
     * Método que verifica se o login está correto e redireciona para a próxima página
     *
     */
    private void logar() {
        if (txLogin.getText().equals("admin") && txSenha.getText().equals("casadocodigo")) {
        	try {
                new Busca().start(new Stage());
                Login.getStage().close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Login e/ou senhainválidos", "Erro", JOptionPane.ERROR_MESSAGE);
        }    
    } 
    
}