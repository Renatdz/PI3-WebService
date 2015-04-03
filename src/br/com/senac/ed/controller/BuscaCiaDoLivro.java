package br.com.senac.ed.controller;

import java.util.ArrayList;

public class BuscaCiaDoLivro extends URL {
	

	public BuscaCiaDoLivro (String urlDoSite){
		
		super (urlDoSite);	
	}
	
	public String retornarURL (){
		
		return urlDoSite ;	
	}

}
