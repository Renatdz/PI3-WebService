import java.util.ArrayList;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sun.javafx.scene.layout.region.Margins.Converter;

import br.com.senac.ed.controller.BuscaAmericanas;
import br.com.senac.ed.controller.BuscaCiaDoLivro;
import br.com.senac.ed.controller.DetalheDoLivro;
import br.com.senac.ed.controller.FluxoUrlController;
import br.com.senac.ed.controller.TituloLivro;
import br.com.senac.ed.model.Search;

public class Main {
	public static void main(String[] args) throws Exception {
		

	TituloLivro titulo = new TituloLivro();
	FluxoUrlController fluxo = new FluxoUrlController();
	DetalheDoLivro d = new DetalheDoLivro();

	
	//ordernar.ordena(titulo.livro);
	System.out.println (titulo.livro);
	}
	
	
	public Main() {
		super();
	}

}