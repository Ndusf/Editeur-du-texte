package fr.istic.nyousefian.ACO.receiver;

/**
 * Tp de mini-éditeur de texte
 *  L'interface Engine réunit les opérations realisables sur l'objet de type Engine.
 *  @see Selection
 * 
 * @ YOUSEFIAN Neda
 * @version 1.0.0
 */

public interface Engine {
	/**
	 * Cela permet de couper une chaîne de caractères
	 */
	public void cut();
	
	/**
	 * Cela permet de copier une chaîne de caractères
	 */
	public void copy();
	
	/**
	 * Cela permet de coller une chaîne de caractères
	 */
	public void paste();
	
	/**
	 * Cela permet d'insérer une chaîne de caractères
	 * @param S
	 */
	public void insert(String S);
	/**
	 * Cela permet de supprimer une chaîne de caractères
	 */
	public void delete();
	
	/**
	 * Selection d'une chaîne de caractères
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
