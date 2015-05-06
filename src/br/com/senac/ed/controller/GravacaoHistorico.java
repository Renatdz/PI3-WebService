package br.com.senac.ed.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GravacaoHistorico {
	public String nomeArq = "../historico.txt";
	public String texto = "";
	 public void gravarHistorico (ArrayList<Object> historico) throws IOException{
			
		FileWriter file = new FileWriter(nomeArq);
		PrintWriter gravar = new PrintWriter(file);
		
		gravar.printf("Historico de grava��o :\t");
		gravar.println(historico);
		
		file.close();

	}
	public String read() throws IOException { 
		
		try { 
			
			BufferedReader br;
			br = new BufferedReader(new FileReader(nomeArq));
			
			while (br.ready()) {
				this.texto += br.readLine()+"\n";  //adiciona as linhas lidas a texto.
			} 
			
			
			
			br.close();
		
	} catch (IOException e) {
		String erro = "Erro na abertura do arquivo: "+e.getMessage()+".\n";
	}
		return this.texto;
}
}


