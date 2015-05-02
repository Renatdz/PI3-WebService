package br.com.senac.ed.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GravacaoHistorico {
	
	public void gravarHistorico (ArrayList<Object> historico) throws IOException{
			
		FileWriter file = new FileWriter("c:\\Users\\Claudia Pereira\\git\\PI\\src\\br\\com\\senac\\historico.txt");
		PrintWriter gravar = new PrintWriter(file);
		
		gravar.printf("Historico de gravação :\t");
		gravar.println(historico);
		
		file.close();

	}
}
