package fr.istic.nyousefian.ACO.commande;

/**
 * Classe AfficherClipboard qui nous permet d'afficher le contenu de presse-papiers
 * Implémente de l'interafce Command
 * @see Engine
 * @see Command
 * 
 * @YOUSEFIAN Neda  
 * @version 1.0.0
 */ 

import fr.istic.nyousefian.ACO.receiver.Engine;

public class AfficherClipboard implements Command {

	private final Engine engine;
	
	/*
	 * Constructeur AfficherClipboard avec un paramètre
	 */

	public AfficherClipboard(Engine engine) {
		this.engine = engine;
	}
	
	@Override
	public void execute() {
		System.out.println(this.engine.getClipboardContents());

	}

}
