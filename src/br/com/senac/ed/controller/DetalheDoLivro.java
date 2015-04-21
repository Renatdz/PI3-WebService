package br.com.senac.ed.controller;

import org.jsoup.Jsoup;

import java.io.IOException;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class DetalheDoLivro {
		
		TituloLivro t = new TituloLivro();
	
		public Elements detalhesCiaDoLivro(String html){
		    Document doc = Jsoup.parse(html);
		    Elements detalhes = doc.getElementsByClass("href"); 		   
		    return detalhes;
	}
}
