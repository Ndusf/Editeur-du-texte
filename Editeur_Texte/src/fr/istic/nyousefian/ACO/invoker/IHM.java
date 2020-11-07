package fr.istic.nyousefian.ACO.invoker;

/**
 *
 * Interface de "Command design pattern" 
 * A simple example of invoker for the Command design pattern.
 *
 * @author nplouzeau & nyousefian
 */
 
import java.io.InputStream;

import fr.istic.nyousefian.ACO.commande.Command;

public interface IHM { 

	public void runInvokerLoop();

    /**
     * Stops the read stream loop now.
     */
    public void stopLoop();

    /**
     * Sets the read stream that be be used by runInvokerLoop
     *
     * @param inputStream the read stream
     * @throws IllegalArgumentException if inputStream is null
     */
    public void setReadStream(InputStream inputStream);


    /**
     * Registers a new keyword/command pair
     *
     * @param keyword a non-null String
     * @param cmd     a non-null Command reference
     * @throws java.lang.IllegalArgumentException for null parameters
     */
    public void addCommand(String keyword, Command cmd);
    
    /**
	 * Get the number inserted in the screen
	 * @return the number inserted
	 */

    public int getNumber();
    
    /**
	 * Get the texte inserted in the screen
	 * @return the text inserted
	 */
    public String getText();


}
