package br.com.senac.ed.controller;

import java.util.ArrayList;

public abstract class URL {
	
	protected String urlDoSite;
	
	public URL (String urlDoSite){
		
		this.urlDoSite = urlDoSite;
	}
	
	ArrayList <Object> livros = new ArrayList <Object>();
	ArrayList <Object> precos = new ArrayList <Object>();
	
	
	
}
