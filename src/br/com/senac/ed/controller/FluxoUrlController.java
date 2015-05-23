package br.com.senac.ed.controller;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


public class FluxoUrlController {

	//bring me the title
	public Elements tituloCiaDoLivro(String html){
		Document doc = Jsoup.parse(html);
	    Elements titulo = doc.getElementsByClass("description"); 	
		    // encoding utf-8
		return titulo;
	}
	
	//bring me the price
	public Elements precoCiaDoLivro(String html){
        Document doc = Jsoup.parse(html);
        Elements preco = doc.getElementsByClass("sale-price");
        
        return preco;
    }
	
	//bring me the author
	public Elements autorCiaDoLivro(String html){
		Document doc = Jsoup.parse(html);
		Elements links = doc.getElementsByClass("author");
		
		return links;
	}
	
	//bring me the detail
	public String hrefPrecoCiaDoLivro (String html){
		
		Document doc = Jsoup.parse(html);
		Elements href = doc.getElementsByClass("photo");
		
		String hrefText = href.attr("href");
		
		return hrefText;
	}
	
	//bring me the 
	//title, 
	//price, 
	//author, 
	//detail 
	//for americanas
	
	public Elements tituloAmericanas(String html) throws IOException{
		Document doc = Jsoup.connect(html).get();
	    Elements titulo = doc.select("title");
	    
		return titulo;
	}

}