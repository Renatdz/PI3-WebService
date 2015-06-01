package br.com.senac.ed.controller;

/**
 * @author renato1mendes
 * 
 * Interface para class livro
 * 
 */
public interface ILivro {
	
	/**
	 * pega titulo
	 * @return String
	 */
	public String getTitulo();
	
	/**
	 * seta titulo
	 */
	public void setTitulo(String titulo);

	/**
	 * pega preco
	 * @return String
	 */
	public String getPreco();
	
	/**
	 * seta preco
	 */
	public void setPreco(String preco);

	/**
	 * pega autor
	 * @return String
	 */
	public String getAutor();

	/**
	 * seta autor
	 */
	public void setAutor(String autor);
	
}
