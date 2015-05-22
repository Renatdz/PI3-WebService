package br.com.senac.ed.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.senac.ed.model.BancoDeDados;

public class Historico {

	public void adicionaNoArquivo(String palavra) throws IOException{	
		GravaEmArquivo gravar = new GravaEmArquivo();
		gravar.write(palavra);
	}
	
	public void adicionaNoBanco(String palavra){
		BancoDeDados banco = new BancoDeDados();
		banco.connect();
		if(banco.isConnected()){
			banco.insertHistoric(palavra);
		
			banco.disconnect();
		}
	}
	
	public List<String> listaDoBanco(){
		List<String> lista = new ArrayList<String>();

		BancoDeDados banco = new BancoDeDados();
		banco.connect();
		if(banco.isConnected()){
			lista = banco.listHistoric();
		
			banco.disconnect();
			
			return lista;
		}	
		
		return null;
	}
	
}
