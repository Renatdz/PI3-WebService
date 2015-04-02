import br.com.senac.ed.model.Search;


public class Main {
	public static void main(String[] args) {
		
		Search consumoWeb = new Search();
		
		System.out.println(consumoWeb.consumirSite("o+simbolo+perdido"));
		//parametro busca ex: o+simbolo+perdido 
		
	}
	
	public Main() {
		super();
	}

}