package fr.istic.nyousefian.ACO.receiver;

/*
 * Impl�mentation de Selection permettant l'instanciation de Selection.
 * 
 * @author Neda Yousefian
 * @version 1.0.0
 */


public class SelectionImpl implements Selection {
	
	/*
	 * marqueur 
	 */
	private int markeur;
	
	/*
	 * curseur
	 */
	private int cursor ;
	/*
	 * m�moire tampon
	 */
	private Engine buffer ;
	
	public String str;  
	public StringBuffer variable;

	/*
	 * Constructeur avec un param�tre
	 * @param variable 
	 * @see Engine
	 */
	
	public SelectionImpl(StringBuffer variable) {
		str = new String(""); 
		this.variable = variable;
		this.cursor = 0;// position de curseur est � 0
		this.markeur = 0;	
	} 
 
	@Override
	public void moveCursor(int n) {
			cursor = cursor + n;
	}

	@Override
	public void setMarker() {
		markeur = cursor;
	}
	
	@Override
	public int getCursorPosition() {
		return cursor;
	}

	@Override
	public int getMarkeurPosition() {
		return markeur;
	}

}
