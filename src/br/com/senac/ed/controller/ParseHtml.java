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

public class ParseHtml implements IParseHtml {

	private String html;
	private Document htmlParse;
	
	public ParseHtml(String html){
		this.html = html;
		this.htmlParse = Jsoup.parse(getHtml());
	}
	
	// Retorna os titulos do livro buscado
	public Elements tituloCiaDoLivro(){
	    Elements titulo = getHtmlParse().getElementsByClass("description"); 	
		    // encoding utf-8
		return titulo;
	}
	
	// Retorna os precos do livro buscado
	public Elements precoCiaDoLivro(){
        Elements preco = getHtmlParse().getElementsByClass("sale-price");
        return preco;
    }
	
	// Retorna o autor do livro buscado
	public Elements autorCiaDoLivro(){
		Elements links = getHtmlParse().getElementsByClass("author");
		return links;
	}
	
	// Retorna a tag href dos livros
	public String hrefPrecoCiaDoLivro (){
		Elements href = getHtmlParse().getElementsByClass("photo");
		String hrefText = href.attr("href");
		return hrefText;
	}
	
	public String getHtml(){
		return this.html;
	}
	public Document getHtmlParse(){
		return this.htmlParse;
	}
}