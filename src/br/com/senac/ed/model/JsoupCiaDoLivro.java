package br.com.senac.ed.model;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class JsoupCiaDoLivro {
  
	public Elements acharTituloCiaDoLivro(String html){
	    Document doc = Jsoup.parse(html);
	    Elements titulo = doc.select("title"); // Usando combina��o com Selector
	   
	    return titulo;
	}
    
    public Elements acharPrecoCiaDoLivro(String html){
        Document doc = Jsoup.parse(html);
        Elements preco = doc.getElementsByClass("sale-price"); // Usando combina��o com Selector
        
        return preco;
    }
    
}

