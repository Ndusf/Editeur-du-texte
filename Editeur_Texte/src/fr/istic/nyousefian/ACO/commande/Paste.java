package fr.istic.nyousefian.ACO.commande;

/**
 * Classe Paste qui nous permet de faire l'action coller 
 * Implémente de l'interafce Command
 * @see Engine
 * @see Command
 * 
 * @YOUSEFIAN Neda  
 * @version 1.0.0
 */ 
import java.util.logging.Logger;
import fr.istic.nyousefian.ACO.receiver.Engine;

public class Paste implements Command{
	private final Engine engine;

	/*
	 * Constructeur cut avec un paramètre
	 */
	public Paste(Engine engine ) {
		this.engine = engine;
	}
	
	/*
	 * @see #Logger
	 */
	@Override
	public void execute() {
		System.out.println(engine.getSelection().getCursorPosition());
		System.out.println(engine.getSelection().getMarkeurPosition());
		Logger.getGlobal().info(engine.getClipboardContents());

		engine.paste();
		Logger.getGlobal().info(engine.getBufferContents());
		this.engine.paste();
		
	}
}
