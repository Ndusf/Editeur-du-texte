package fr.istic.nyousefian.ACO.Client;

import fr.istic.nyousefian.ACO.commande.AffichageBuffer;
import fr.istic.nyousefian.ACO.commande.AfficherClipboard;
import fr.istic.nyousefian.ACO.commande.Copy;
import fr.istic.nyousefian.ACO.commande.Cut;
import fr.istic.nyousefian.ACO.commande.Delete;
import fr.istic.nyousefian.ACO.commande.Insert;
import fr.istic.nyousefian.ACO.commande.Paste;
import fr.istic.nyousefian.ACO.commande.Quit;
import fr.istic.nyousefian.ACO.commande.Selection;
import fr.istic.nyousefian.ACO.invoker.IHM;
import fr.istic.nyousefian.ACO.invoker.IHMImpl;
import fr.istic.nyousefian.ACO.receiver.EnginImpl;
import fr.istic.nyousefian.ACO.receiver.Engine;
 
/**
 * Tp de mini-�diteur de texte
 *  Classe MainEditeur qui nous permet de d�finir la fonction principale (main)
 *  @see Selection 
 *  @see Engine
 *  @see Selection
 * 
 * @ YOUSEFIAN Neda
 * @version 1.0.0
 */

public class MainEditeur{ 

	// Attribute
    private Engine engine;  
    private IHM ihm; 
    
    public static void main(String lineArgs[]) {

    	MainEditeur client = new MainEditeur();
        client.run();
 
    }

    private void run() {
        engine = new EnginImpl();
        ihm = new IHMImpl();
        ihm.setReadStream(System.in);
        configureCommands();
        ListCommande();
        ihm.runInvokerLoop();
    }

    /*
     * Liste de configuration de commandes des actions utilisateurs
     */
    private void configureCommands() {
    	
    		ihm.addCommand("I", new Insert(ihm, engine));
    	 	ihm.addCommand("C", new Copy(engine));
	        ihm.addCommand("V", new Paste(engine));
	        ihm.addCommand("X", new Cut(engine));
	        ihm.addCommand("D", new Delete(engine));
	        ihm.addCommand("S", new Selection(ihm,engine));
	        ihm.addCommand("ABuf", new AffichageBuffer(engine));
	        ihm.addCommand("APP", new AfficherClipboard(engine));
	        ihm.addCommand("Q", new Quit());
    }
    
    /*
     * Affiche sur la console les commends
     */
    private void ListCommande() {
    	System.out.println("****************Bienvenue sur l'�diteur de texte***************** ");
    	System.out.println("");
    	System.out.println("*			Choisissez les commandes                *");
    	System.out.println("");
    	System.out.println("***************************************************************** ");
    	System.out.println("I\tIns�re un texte");
    	System.out.println("C\tCopie le texte s�lectionn� dans le presse-papiers");
    	System.out.println("V\tColle le texte s�lectionn� dans le presse-papiers");
    	System.out.println("D\tSupprime un caract�re");
    	System.out.println("S\tS�lectionne une partie du texte");
    	System.out.println("X\tCoupe le texte s�lectionn� et le met dans le presse-papiers");
    	System.out.println("ABuf\tAffiche le contenu de la m�moire-tampon");
    	System.out.println("APP\tAffiche le contenu du presse-papiers");
    	System.out.println("Q\tPermet de quitter l'�diteur de texte");
    	System.out.println("***************************************************************** ");
    	System.out.println("*	                        				*");
    	System.out.println("*                  Saisissez un caract�re , S.V.P !             *");
      	System.out.println("*	                        				*");
     	System.out.println("***************************************************************** ");
    }
}
