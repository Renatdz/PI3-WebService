package br.com.senac.ed.controller;

import java.util.ArrayList;

public class BuscaAmericanas extends URL {	
	
	private String retorno;
	
	public BuscaAmericanas (String nomeLivro){
		super (nomeLivro);	
	}
	
	public String retornarURL (){	
		return urlDoSite ;	
	}
	@Override
	public void geraUrl(String nomeLivro) {	
		
		retorno = nomeLivro.replace("", "+");
		setUrlDoSite ("http://busca.americanas.com.br/busca.php?q="+retorno+"");
		
	}
	
	public String getUrlDoSite (){
		
		return this.urlDoSite;
	}
	
	public void setUrlDoSite (String urlDoSite){
		
		this.urlDoSite = urlDoSite;
		
	}

	

}
