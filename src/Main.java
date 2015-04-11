import java.util.ArrayList;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import br.com.senac.ed.controller.BuscaAmericanas;
import br.com.senac.ed.controller.BuscaCiaDoLivro;
import br.com.senac.ed.controller.FluxoUrlController;
import br.com.senac.ed.model.Search;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BuscaCiaDoLivro cia = new BuscaCiaDoLivro("O simbolo perdido");
		Search consumoWeb = new Search();
		
		cia.geraURL();
		String retorno = consumoWeb.consumirSite(cia.getURL());
		
		FluxoUrlController fluxoUrl = new FluxoUrlController();
		
		Elements nomes = fluxoUrl.tituloCiaDoLivro(retorno);
//		Elements precos = jcdl.acharPrecoCiaDoLivro(retorno);
		
		for(Element nome : nomes)
			System.out.println(nome.text());
	}
	
	public Main() {
		super();
	}

}