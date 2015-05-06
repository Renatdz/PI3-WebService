/**
 * 
 */
package br.com.senac.ed.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Classe para escrever e ler um arquivo.
 * @author Renato Mendes
 * @version 1.0
 */
public class gravaHistoric {
	
	private String texto = "";
	private static final String nomeArq = "files/historico.txt";
	
	/**
	 * Lê o arquivo para e retorna uma string de texto.
	 * @return String this.texto
	 * @throws IOException 
	 */
	public String read() throws IOException { 
		
		try { 
			
			BufferedReader br;
			br = new BufferedReader(new FileReader(getNomeArq()));
			
			System.out.print("\nConteúdo do arquivo historico:\n");
			
			while (br.ready()) {
				this.texto += br.readLine()+"\n";  //adiciona as linhas lidas a texto.
			} 
			
			System.out.print(this.texto+"\n");
			
			br.close(); //fecha o arquivo
			
		} catch (IOException e) {
			String erro = "Erro na abertura do arquivo: "+e.getMessage()+".\n";
			System.out.print(erro);
		} 
		
		return this.texto;
	}
	
	
	/**
	 * Escreve o arquivo com os dados do parâmetro.
	 * @param linha
	 */
	public void write(String linha) throws IOException {
		
		String aux = read();
		linha.concat(aux);
		
		BufferedWriter bw;
		bw = new BufferedWriter(new FileWriter(getNomeArq()));
		
		if(this.texto != "")
			bw.write(this.texto); //adiciona o texto antigo
		
		//adiciona ao arquivo
		bw.write(linha + "\n"); 
		bw.write("+-----------------------------------------------------------------------------------------+\n");
		
		bw.close(); //fecha o arquivo
		
		System.out.print("\nHistórico foi gravada com sucesso em \"historico.txt\".\n");
	}

	//getters and setters
	private static String getNomeArq() {
		return nomeArq;
	} 
	
}

