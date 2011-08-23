package de.genesez.platforms.common.naming;

public interface ContextManager {
	
	public String getActualContext();
	
	public void setActualContext(String actualContext);
	
	public void revertActualContext();
	
}
