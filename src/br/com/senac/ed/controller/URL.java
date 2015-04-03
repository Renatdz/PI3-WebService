package br.com.senac.ed.controller;

import java.util.ArrayList;

public abstract class URL {
	
	protected String urlDoSite;
	protected String nomeLivro;
	
	public URL (String nomeLivro){
		
		this.nomeLivro = nomeLivro;
	}
	
	public abstract void geraUrl(String nomeLivro);
	
	public String getNomeLivro(){
		
		return this.nomeLivro;
	}
	
	
}
