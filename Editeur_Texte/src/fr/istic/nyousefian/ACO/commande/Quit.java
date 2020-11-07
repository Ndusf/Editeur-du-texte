package fr.istic.nyousefian.ACO.commande;

/**
 * Classe Quit qui nous permet de quitter l'API
 * Implémente de l'interafce Command
 * 
 * @YOUSEFIAN Neda  
 * @version 1.0.0
 */ 

public class Quit implements Command {
	
	@Override
	public void execute() {
		System.exit(0);
		
	}

} 
