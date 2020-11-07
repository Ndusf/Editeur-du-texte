package fr.istic.nyousefian.ACO.receiver;

/*
 * Implémentation de Engine permettant l'instanciation d'Engine.
 * 
 * @author Neda Yousefian
 * @version 1.0.0
 */

public class EnginImpl implements Engine {

	/*
	 * Stringbuffer pour stocker le texte	
	 */
	private StringBuffer buffer;  
	
	/*
	 *  presse-papiers
	 */
	private String cboard;
	
	/*
	 * séléctionne 
	 */
	private SelectionImpl selection;

	/*
	 *  Constructeur sans paramètre
	 *  @see StringBuffer
	 */
	public  EnginImpl(){ 
		buffer = new StringBuffer();
		cboard = "";
		selection = new SelectionImpl(buffer);
	}

	/*
	 * @see StringBuffer#substring
	 * @see StringBuffer#delete
	 */
	@Override
	public void cut() {
		int end =  selection.getCursorPosition();
		int start = selection.getMarkeurPosition();
		if(start > end) {
			cboard = buffer.substring(end, start);
			buffer = buffer.delete(end, start);		
		}
		else {
			cboard = buffer.substring(start, end);
			buffer = buffer.delete(start, end);	
		}
	} 

	/* 
	 * @see StringBuffer#substring
	 */
	@Override 
	public void copy() {
		int start = selection.getMarkeurPosition();
		int end   = selection.getCursorPosition() ;
		
		if(start > end) {
			cboard = buffer.substring( end , start );
		} 
		else {
			cboard = buffer.substring(start, end); 		
		}
	}
	
	/*
	 * @see StringBuffer#substring
	 * @see StringBuffer#delete
	 */
	@Override
	public void paste() {
		int start = selection.getMarkeurPosition();
		int end   = selection.getCursorPosition() ;
		if(start > end){
			buffer.delete(end, start );
			buffer.insert(end , getClipboardContents());
			selection.moveCursor(getClipboardContents().length());	
		}
		else {
		buffer.insert(end , getClipboardContents());
		selection.moveCursor(getClipboardContents().length());
		}
	} 
	
	/*
	 * @see StringBuffer#deleteCharAt
	 */
	@Override
	public void delete() {
		int end   = selection.getCursorPosition() ;
		 buffer.deleteCharAt(end-1);
		 selection.moveCursor(-1);		
	}
	
	/*
	 * @see StringBuffer#insert
	 */
	@Override
	public void insert(String S) {
		int index = selection.getCursorPosition();
		buffer.insert(index , S);
		selection.moveCursor(S.length());
	}	 

	@Override
	public Selection getSelection() {
		return selection;
	}

	/*
	 * @see #toString
	 */
	@Override
	public String getBufferContents() {
		/*String BufferContents= "";
		for (int i = 0; i < buffer.length(); i++) {
			BufferContents += buffer.charAt(i);
		}
		return BufferContents;	*/
		return buffer.toString();
	}

	@Override
	public String getClipboardContents() {
		/*String ClipboardContents= "";
		for (int i = 0; i < cboard.length(); i++) {
			ClipboardContents = ClipboardContents +  cboard.charAt(i);
			} 
		return ClipboardContents;*/
		return cboard;
	} 

} 
