package br.com.senac.ed.controller;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupAmericanas {
  public static void main(String[] args) throws IOException {
    acharTituloAmericanas();
    acharPrecoAmericanas();
  }
  
  private static void acharTituloAmericanas() throws IOException {
    Document doc = Jsoup.connect("http://busca.americanas.com.br/busca.php?q=Pequeno+principe&typeclick=1&ranking=1&ac_pos=header").get();
    Elements titulo = doc.select("title"); // Usando combina��o com Selector
    for (Element title : titulo) {
      System.out.println("O nome do livro �: "+title.text());
    }
    
    
  }
  
  private static void acharPrecoAmericanas() throws IOException {
      Document doc = Jsoup.connect("http://busca.americanas.com.br/busca.php?q=Pequeno+principe&typeclick=1&ranking=1&ac_pos=header").get();
      Elements preco = doc.getElementsByClass(""); // Usando combina��o com Selector
      for (Element prize : preco) {
        System.out.println("Pre�o do livro: "+prize.text());
      }
  }
}

