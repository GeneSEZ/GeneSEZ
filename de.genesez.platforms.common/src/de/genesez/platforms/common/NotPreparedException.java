package de.genesez.platforms.common;

/**
 * The NotPreparedException is thrown, if preProcessing() wasn't called before
 * postProcessing() (only if preparation needed)
 * 
 * @author Dominik Wetzel
 * 
 */
public class NotPreparedException extends RuntimeException {
	private static final long serialVersionUID = -1871632509826762886L;

	public NotPreparedException(){
		super();
	}
	
	public NotPreparedException(String message) {
		super(message);
	}
}