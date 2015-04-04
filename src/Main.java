import br.com.senac.ed.controller.BuscaAmericanas;
import br.com.senac.ed.controller.BuscaCiaDoLivro;
import br.com.senac.ed.model.Search;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BuscaCiaDoLivro cia = new BuscaCiaDoLivro("O simbolo perdido");
		Search consumoWeb = new Search();
		
		cia.geraURL();
		String retorno = consumoWeb.consumirSite(cia.getURL());
		

		
		System.out.println(retorno);
		System.out.println();
		System.out.println("=========================");
		System.out.println();

		
		
	}
	
	public Main() {
		super();
	}

}