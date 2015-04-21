package br.com.senac.ed.controller;

import java.util.Comparator;


public class Comparar implements Comparator <TituloLivro> {

	
	public int compare(TituloLivro livro1, TituloLivro livro2) {
		 
		return livro1.getLivros().compareTo(livro2.getLivros()) ;
	}


}
