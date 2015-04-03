package br.com.senac.ed.controller;

public class BuscaCiaDoLivro extends URL {

	private String urlDoSite;
	
	public BuscaCiaDoLivro (String nomeLivro){
		super(nomeLivro);
	}

	@Override
	public void geraURL(){
		String novoNomeLivro = getNomeLivro().replace(" ", "+");
		
		setURL("http://www.ciadoslivros.com.br/pesquisa?t="+novoNomeLivro+"&f=&sr=GERAL");
	}

	//getters and setters
	public void setURL(String urlDoSite){
		this.urlDoSite = urlDoSite;
	}
	
	public String getURL(){
		return this.urlDoSite;
	}

}