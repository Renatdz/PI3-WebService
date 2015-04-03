package br.com.senac.ed.controller;

public class BuscaAmericanas extends URL{
	
	private String urlDoSite;
	
	public BuscaAmericanas (String nomeLivro){
		super(nomeLivro);
	}

	public void geraURL(){
		String novoNomeLivro = getNomeLivro().replace(" ", "+");
		
		setURL("http://busca.americanas.com.br/busca.php?q="+novoNomeLivro+"&typeclick=1&ranking=1&ac_pos=header");
	}
	
	//getters and setters
	public void setURL(String urlDoSite){
		this.urlDoSite = urlDoSite;
	}
	
	public String getURL(){
		return this.urlDoSite;
	}

}



