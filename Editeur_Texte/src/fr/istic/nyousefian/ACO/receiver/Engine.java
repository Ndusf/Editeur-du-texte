package fr.istic.nyousefian.ACO.receiver;

/**
 * Tp de mini-�diteur de texte
 *  L'interface Engine r�unit les op�rations realisables sur l'objet de type Engine.
 *  @see Selection
 * 
 * @ YOUSEFIAN Neda
 * @version 1.0.0
 */

public interface Engine {
	/**
	 * Cela permet de couper une cha�ne de caract�res
	 */
	public void cut();
	
	/**
	 * Cela permet de copier une cha�ne de caract�res
	 */
	public void copy();
	
	/**
	 * Cela permet de coller une cha�ne de caract�res
	 */
	public void paste();
	
	/**
	 * Cela permet d'ins�rer une cha�ne de caract�res
	 * @param S
	 */
	public void insert(String S);
	/**
	 * Cela permet de supprimer une cha�ne de caract�res
	 */
	public void delete();
	
	/**
	 * Selection d'une cha�ne de caract�res
	 * @return le selection
	 */
	public Selection getSelection();
	
	/**
	 * Renvoie le texte dans le buffer(memoire tampon)
	 * @return contenu de stringBuffer
	 */
	public String getBufferContents();
	
	/**
	 * Renvoie le texte dans le presse-papiers
	 * @return contenu du presse-papiers
	 */
	public String getClipboardContents();

	
}
