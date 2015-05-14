package br.com.senac.ed.controller;

public class BuscaAmericanas extends URL{
	
	private String urlDoSite;
	private String href;
	String hrefNaoTratada;
	
	public BuscaAmericanas (String nomeLivro){
		super(nomeLivro);
	}

	public void geraURL(){
		String novoNomeLivro = getNomeLivro().replace(" ", "+");
		
		setURL("http://busca.americanas.com.br/busca.php?q="+novoNomeLivro+"&typeclick=1&ranking=1&ac_pos=header");
	}
	
	public String getHref (){
		
		return href;
	}
	
	public void setHref (String href){
		
		this.href = href;
	}
	
	public String geraHref (String href){
		hrefNaoTratada = hrefNaoTratada.trim().replace(" ", "+");
		hrefNaoTratada = hrefNaoTratada.trim().replace("<div class='caixacampobranco'>", "");
		hrefNaoTratada = hrefNaoTratada.trim().replace("<span class='resposta'>", "");
		hrefNaoTratada = hrefNaoTratada.trim().replace("</span>", ""); 
		hrefNaoTratada = hrefNaoTratada.trim().replace("<span class='respostadestaque'>", "");
		hrefNaoTratada = hrefNaoTratada.trim().replace("</span>", "");
		hrefNaoTratada = hrefNaoTratada.trim().replace("<br/>", "");
        hrefNaoTratada = hrefNaoTratada.trim().replace("<div style='text-align: right;' class='mopcoes orientacao'>","");
        hrefNaoTratada = hrefNaoTratada.trim().replace("<span>","");
        hrefNaoTratada = hrefNaoTratada.trim().replace("Opções","");
        hrefNaoTratada = hrefNaoTratada.trim().replace(" <img style='position: relative right:0px; src='images/template/mais.png/>","");
        hrefNaoTratada = hrefNaoTratada.trim().replace("</span></div>", "");
        hrefNaoTratada = hrefNaoTratada.trim().replace("</div>", "");      
		
        setHref(hrefNaoTratada);
        return hrefNaoTratada;
	}
	//getters and setters
	public void setURL(String urlDoSite){
		this.urlDoSite = urlDoSite;
	}
	
	public String getURL(){
		return this.urlDoSite;
	}

}



