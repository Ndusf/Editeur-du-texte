package fr.istic.nyousefian.ACO.commande;

/**
 * Classe Copy qui implémente de l'interafce Command
 * @see Engine
 * @see Command
 * 
 * @YOUSEFIAN Neda  
 * @version 1.0.0
 */ 


import java.util.logging.Logger;
import fr.istic.nyousefian.ACO.receiver.Engine;


public class Copy implements Command{
	
	private final Engine engine;
	
	/*
	 * Constructeur cut avec un paramètre
	 */

	public Copy(Engine engine) {
		this.engine = engine;
	}
	
	/*
	 * @see #Logger
	 */
	@Override
	public void execute() {
		this.engine.copy();
		Logger.getGlobal().info(engine.getClipboardContents());
	}
}
