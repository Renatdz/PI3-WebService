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
	public Elements tituloCiaDoLivro();
	
	/**
	 * busca precos dos livros buscados 
	 * @return Elements
	 */
	public Elements precoCiaDoLivro();
		
	/**
	 * busca autores dos livros buscados 
	 * @return Elements
	 */
	public Elements autorCiaDoLivro();
		
	/**
	 * busca href de detalhes dos livros buscados 
	 * @return String
	 */
	public String hrefPrecoCiaDoLivro();

}
