import java.util.ArrayList;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import br.com.senac.ed.controller.BuscaAmericanas;
import br.com.senac.ed.controller.BuscaCiaDoLivro;
import br.com.senac.ed.model.ExtractData;
import br.com.senac.ed.model.JsoupCiaDoLivro;
import br.com.senac.ed.model.Search;

public class Main {
	public static void main(String[] args) throws Exception {
		
		BuscaCiaDoLivro cia = new BuscaCiaDoLivro("O simbolo perdido");
		Search consumoWeb = new Search();
		
		cia.geraURL();
		String retorno = consumoWeb.consumirSite(cia.getURL());
		
		JsoupCiaDoLivro jcdl = new JsoupCiaDoLivro();
		
		Elements nomes = jcdl.acharTituloCiaDoLivro(retorno);
		Elements precos = jcdl.acharPrecoCiaDoLivro(retorno);
		
		for(Element nome : nomes)
			System.out.println(nome.text());
		
		for(Element preco : precos)
			System.out.println(preco.text()); 
		
//		ExtractData data = new ExtractData(retorno);
//		
//		ArrayList<String> s = data.extract();
//		
//		System.out.println(s.size());
		
	}
	
	public Main() {
		super();
	}

}