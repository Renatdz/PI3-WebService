package br.com.senac.ed.controller;


public class BuscaCiaDoLivro extends TrataUrlBusca {

	private String urlDoSite;
	private String href;
	private String hrefNaoTratada;
	
	public BuscaCiaDoLivro (String nomeLivro){
		super(nomeLivro);
	}

	@Override
	public void geraURL(){
		String tituloTratado = getNomeLivro().replace(" ", "+");
		
		setURL("http://www.ciadoslivros.com.br/pesquisa?t="+tituloTratado+"&f=&sr=GERAL");
	}
	
	public void geraHref (String href){
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
        hrefNaoTratada = hrefNaoTratada.trim().replace("href=", "");
		
        setHref(hrefNaoTratada);
	}
	
	public String getHref (){
		
		return href;
	}
	
	public void setHref (String href){
		
		this.href = href;
	}

	//getters and setters
	public void setURL(String urlDoSite){
		this.urlDoSite = urlDoSite;
	}
	
	public String getURL(){
		return this.urlDoSite;
	}

}