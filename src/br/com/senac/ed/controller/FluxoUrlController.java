package br.com.senac.ed.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class FluxoUrlController {

	public Elements tituloCiaDoLivro(String html){
		Document doc = Jsoup.parse(html);
	    Elements titulo = doc.getElementsByClass("description"); 	
		    // encoding utf-8
		return titulo;
	}
	
	public Elements precoCiaDoLivro(String html){
        Document doc = Jsoup.parse(html);
        Elements preco = doc.getElementsByClass("sale-price");
        
        return preco;
    }
	
	public String hrefPrecoCiaDoLivro (String html){
		
		Document doc = Jsoup.parse(html);
		Elements href = doc.getElementsByClass("photo");
		
		String hrefText = href.attr("href");
		
		return hrefText;
	}
	
	public Elements detalheCiaDoLivro(String html){
		Document doc = Jsoup.parse(html);
		Elements links = doc.getElementsByClass("author");
		
		return links;
	}
	
	public Elements tituloAmericanas(String html) throws IOException{
		Document doc = Jsoup.connect(html).get();
	    Elements titulo = doc.select("title");
	    
		return titulo;
	}
	

//	public Elements precoAmericanas (String html){
//		
//		return ;
//	}
	

}