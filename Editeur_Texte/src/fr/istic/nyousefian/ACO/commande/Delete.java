package fr.istic.nyousefian.ACO.commande;

/**
 * Classe Delete qui nous permet de supprimer un caractère
 * Implémente de l'interafce Command
 * @see Engine
 * @see Command
 * 
 * @YOUSEFIAN Neda  
 * @version 1.0.0
 */ 
 
import java.util.logging.Logger;
import fr.istic.nyousefian.ACO.receiver.Engine;

public class Delete implements Command{
	private final Engine engine;
	
	/*
	 * Constructeur cut avec un paramètre
	 */

	public Delete(Engine engine) {
		this.engine = engine;
	}
	
	/*
	 * @see #Logger
	 */
	@Override
	public void execute() {
		
		this.engine.delete();
		Logger.getGlobal().info(engine.getBufferContents());
		
	}
}
