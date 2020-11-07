package fr.istic.nyousefian.ACO.commande;

/**
 * Classe Insert qui nous permet d'insérer une chaîne de caractères
 * Implémente de l'interafce Command
 * @see Engine
 * @see IHM
 * @see Command
 * 
 * @YOUSEFIAN Neda  
 * @version 1.0.0
 */ 
import java.util.logging.Logger;

import fr.istic.nyousefian.ACO.invoker.IHM;
import fr.istic.nyousefian.ACO.receiver.Engine;

public class Insert implements Command {

	private final Engine engine;
	private final IHM ihm;
	
	/*
	 * Constructeur cut avec deux paramètres
	 */ 
	public Insert(IHM ihm, Engine engine) {
		this.engine = engine;
		this.ihm = ihm;
	}
	
	/*
	 * @see #Logger 
	 */
	@Override
	public void execute() {
		this.engine.insert(ihm.getText());
		Logger.getGlobal().info(engine.getBufferContents());
		
	}

}
