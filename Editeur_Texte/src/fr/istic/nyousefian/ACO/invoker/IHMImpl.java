package fr.istic.nyousefian.ACO.invoker;

/**
 *
 * Implémentation de "Command design pattern" 
 * A simple example of invoker for the Command design pattern.
 *
 * @author nplouzeau & nyousefian
 */
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

import fr.istic.nyousefian.ACO.commande.Command;


public class IHMImpl implements IHM {

	
	private HashMap<String, Command> commands = new HashMap<>();
	private boolean stopLoop = false;
	private InputStream inputStream;
	private BufferedReader bufferedReader;

	@Override 
	public void runInvokerLoop() {
		while (!stopLoop) {
			String userInput = null; 
			try {
				userInput = readUserInput();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (userInput == null) {
				stopLoop = true;
				break;
			}
			
			Command cmdToExecute = commands.get(userInput);
			if (cmdToExecute != null) {
				cmdToExecute.execute();
			}
		}
	}

	@Override
	public void stopLoop() {
		stopLoop = true;
	}

	private String readUserInput() throws IOException {
		 return bufferedReader.readLine();
	}

	/**
	 * Registers a new keyword/command pair
	 *
	 * @param keyword
	 *            a non-null String
	 * @param cmd
	 *            a non-null Command reference
	 * @throws java.lang.IllegalArgumentException
	 *             for null parameters
	 */
	@Override
	public void addCommand(String keyword, Command cmd) {
		if ((keyword == null) || (cmd == null)) {
			throw new IllegalArgumentException("null parameter");
		}
		commands.put(keyword, cmd);
	}

	@Override
	public void setReadStream(InputStream inputStream) {
		if (inputStream == null) {
			throw new IllegalArgumentException("null inputStream");
		}
		this.inputStream = inputStream;
		this.bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
	}

	@SuppressWarnings("resource")
	@Override
	public int getNumber() {
		int Number = new Scanner(System.in).nextInt();
		return Number;
	}

	@Override
	    public String getText() {

			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			return sc.nextLine();
		}
		
	

}
