package br.com.senac.ed.controller;
import java.util.ArrayList;
import java.util.Collections;

public class OrdenarTitulo {	
	
	TituloLivro titulo = new TituloLivro();
	
		for(int j=0;j< titulo.livro.size();j++){
		
			for(int i=j+1;i<titulo.livro.size();i++){
				if((titulo.livro.get(i)).compareToIgnoreCase(titulo.livro.get(j))<0){
				
					String t = titulo.livro.get(j);
					titulo.livro.set(j, titulo.livro.get(i));
					titulo.livro.set(i, titulo.livro.get(i));
			}
		}
		
	
	}
}
	

}
	


