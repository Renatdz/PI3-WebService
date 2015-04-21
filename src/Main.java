import java.util.ArrayList;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import br.com.senac.ed.controller.BuscaAmericanas;
import br.com.senac.ed.controller.BuscaCiaDoLivro;
import br.com.senac.ed.controller.FluxoUrlController;
import br.com.senac.ed.controller.OrdenaTitulo;
import br.com.senac.ed.controller.TituloLivro;
import br.com.senac.ed.model.Search;

public class Main {
	public static void main(String[] args) throws Exception {
		

	TituloLivro titulo = new TituloLivro();
	FluxoUrlController fluxo = new FluxoUrlController();

	System.out.println ("Detalhe"+ titulo.detalhes);

	OrdenaTitulo o = new OrdenaTitulo();
	titulo.livro.add("kaak");
	titulo.livro.add("beijo");
	//o.ordernar();
	System.out.println(titulo.livro);
	
	}
	public Main() {
		super();
	}

}
	