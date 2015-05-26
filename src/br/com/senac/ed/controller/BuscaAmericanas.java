package br.com.senac.ed.controller;

/**
 * @author vinicius.ribeiro, renato1mendes
 * 
 * Classe concatena os dados para conex�o no site. 
 * 
 */

public class BuscaAmericanas extends TrataUrlBusca{
	
	private String urlDoSite;
	private String href;
	private String hrefNaoTratada;
	
	public BuscaAmericanas (String nomeLivro){
		super(nomeLivro);
	}

	//Concatena o nome do livro na URL de busca
	
	public void geraURL(){
		String tituloTratado = getNomeLivro().replace(" ", "+");
		
		setURL("http://busca.americanas.com.br/busca.php?q="+tituloTratado+"&typeclick=1&ranking=1&ac_pos=header");
	}

	public String getHref (){
		
		return href;
	}
	
	public void setHref (String href){
		
		this.href = href;
	}
	
	// Trata a Href do site
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



