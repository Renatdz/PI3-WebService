package br.com.senac.ed.controller;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
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
	
	public Elements tituloAmericanas(String html) throws IOException{
		Document doc = Jsoup.connect("http://busca.americanas.com.br/busca.php?q=Pequeno+principe&typeclick=1&ranking=1&ac_pos=header").get();
	    Elements titulo = doc.select("title"); 
		return titulo;
	}
	

//	public Elements precoAmericanas (String html){
//		
//		return ;
//	}
	

	
	
	    
	}
	

