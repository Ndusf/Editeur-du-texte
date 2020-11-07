package fr.istic.nyousefian.ACO.commande;

/**
 * Classe Selection qui nous permet de sélectionner une chaîne de caractères
 * Implémente de l'interafce Command
 * @see Engine
 * @see Selection
 * @see IHM
 * @see Command
 * 
 * @YOUSEFIAN Neda  
 * @version 1.0.0
 */ 
import java.util.logging.Logger;

import fr.istic.nyousefian.ACO.invoker.IHM;
import fr.istic.nyousefian.ACO.receiver.Engine;

public class Selection implements Command{
	
	private final Engine engine;
	private IHM ihm;
	
	/*
	 * Constructeur cut avec deux paramètres
	 */
	public Selection(IHM ihm, Engine engine) {
		this.engine = engine;
		this.ihm = ihm ; 
	}
	
	/*
	 * @see #Logger
	 */
	@Override
	public void execute() {
		int posCursor = ihm.getNumber();
		int longer = ihm.getNumber(); 
		
		Logger.getGlobal().info(Integer.toString(posCursor)); 
		Logger.getGlobal().info(Integer.toString(longer));
	
		engine.getSelection().getCursorPosition();
		engine.getSelection().getMarkeurPosition();
	}
	
}
