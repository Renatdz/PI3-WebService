package br.com.senac.ed.controller;

import java.io.IOException;
import java.io.ObjectInputStream.GetField;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupCiaDoLivro {
  public static void main(String[] args) throws IOException {
    acharTituloCiaDoLivro();
    acharPrecoCiaDoLivro();
  }
  
  private static void acharTituloCiaDoLivro() throws IOException {
    Document doc = Jsoup.connect("http://www.ciadoslivros.com.br/pesquisa?t=pequeno+principe&f=&sr=GERAL").get();
    Elements titulo = doc.getElementsByClass("name"); // Usando combina��o com Selector
    for (Element title : titulo) {
     System.out.println("O nome do livro �: "+title.text());
     
    }
  }
      
    private static void acharPrecoCiaDoLivro() throws IOException {
        Document doc = Jsoup.connect("http://www.ciadoslivros.com.br/pesquisa?t=pequeno+principe&f=&sr=GERAL").get();
        Elements preco = doc.getElementsByClass("sale-price"); // Usando combina��o com Selector
        for (Element prize : preco) {
          System.out.println(prize.text());
        }
    }
    
  //  System.out.println ("Livro: "+ title.text() + "\t Pre�o: " + prize.text());
}

