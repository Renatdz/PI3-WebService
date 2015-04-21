package br.com.senac.ed.controller;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class FluxoUrlController {

	public Elements tituloCiaDoLivro(String html){
		    Document doc = Jsoup.parse(html);
		    Elements titulo = doc.getElementsByClass("name"); 		   
		    return titulo;
	}
	
	public Elements precoCiaDoLivro(String html){
        Document doc = Jsoup.parse(html);
        Elements preco = doc.getElementsByClass("sale-price"); 
        return preco;
    }

	public Elements Detalhe (String html) throws IOException{
	Document doc = Jsoup.parse(html);
	Elements links = doc.getElementsByTag("href");
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
	

