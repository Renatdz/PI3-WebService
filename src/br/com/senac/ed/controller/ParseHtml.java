package br.com.senac.ed.controller;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * @author vinicius.ribeiro
 * @update renato1mendes
 * 
 * Classe que retorna os dados do html do site. 
 * 
 */


public class ParseHtml {

	// Retorna os titulos do livro buscado
	public Elements tituloCiaDoLivro(String html){
		Document doc = Jsoup.parse(html);
	    Elements titulo = doc.getElementsByClass("description"); 	
		    // encoding utf-8
		return titulo;
	}
	
	// Retorna os preços do livro buscado
	public Elements precoCiaDoLivro(String html){
        Document doc = Jsoup.parse(html);
        Elements preco = doc.getElementsByClass("sale-price");
        
        return preco;
    }
	
	// Retorna o autor do livro buscado
	public Elements autorCiaDoLivro(String html){
		Document doc = Jsoup.parse(html);
		Elements links = doc.getElementsByClass("author");
		
		return links;
	}
	
	// Retorna a tag href dos livros
	public String hrefPrecoCiaDoLivro (String html){
		
		Document doc = Jsoup.parse(html);
		Elements href = doc.getElementsByClass("photo");
		
		String hrefText = href.attr("href");
		
		return hrefText;
	}
	
}