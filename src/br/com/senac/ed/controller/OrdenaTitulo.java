package br.com.senac.ed.controller;
import java.util.ArrayList;
import java.util.Collections;

public class OrdenaTitulo{
	
	TituloLivro t = new TituloLivro();
	
	public ArrayList<TituloLivro> ordernar (ArrayList<TituloLivro> livro){
		
		Collections.sort(livro, new Comparar());
		return livro;
		
	}
	

}
	


