package fr.istic.nyousefian.ACO.receiver;

/**
 *  L'interface Selection réunit les opérations realisables sur l'objet de type Selection.
 *  @see Engine
 * 
 * @ YOUSEFIAN Neda
 * @version 1.0.0
 */


public interface Selection {
	
	/**
	 * Cela permet de déplacer le curseur à un entier en paramètre 
	 * @param n
	 */
	public void moveCursor(int n);
	
	/**
	 * Cela permet de modifier la position du marqueur
	 */
	public void setMarker();
	
	/**
	 * Cela permet de définir la position du curseur
	 * @return la position du curseur
	 */
	public int getCursorPosition();
	
	/**
	 * @return la position du marqueur
	 */
	public int getMarkeurPosition();
	
}
