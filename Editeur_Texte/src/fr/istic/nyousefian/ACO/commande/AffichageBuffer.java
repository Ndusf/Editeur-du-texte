package fr.istic.nyousefian.ACO.commande;

/**
 * Classe AffichageBuffer qui nous permet d'afficher le contenu de buffer
 * Implémente de l'interafce Command
 * @see Engine
 * @see Command
 * 
 * @YOUSEFIAN Neda  
 * @version 1.0.0
 */ 
import fr.istic.nyousefian.ACO.receiver.Engine;

public class AffichageBuffer implements Command {

	private final Engine engine;
	
	/*
	 * Constructeur AffichageBuffer avec un paramètre
	 */

	public AffichageBuffer(Engine engine) {
		this.engine = engine;
	}
	
	@Override
	public void execute() {
		
		System.out.println(engine.getBufferContents());

	}

}
