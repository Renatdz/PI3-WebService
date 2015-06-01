package br.com.senac.ed.controller;

import org.jsoup.select.Elements;

/**
 * @author renato1mendes
 * interface para class ParseHtml 
 * 
 */
public interface IParseHtml {
	
	/**
	 * busca titulos dos livros buscados 
	 * @return Elements
	 */
	public Elements tituloCiaDoLivro(String html);
	
	/**
	 * busca precos dos livros buscados 
	 * @return Elements
	 */
	public Elements precoCiaDoLivro(String html);
		
	/**
	 * busca autores dos livros buscados 
	 * @return Elements
	 */
	public Elements autorCiaDoLivro(String html);
		
	/**
	 * busca href de detalhes dos livros buscados 
	 * @return String
	 */
	public String hrefPrecoCiaDoLivro (String html);

}
