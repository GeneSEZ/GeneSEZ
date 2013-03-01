package core;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_16_0_b6f02e1_1231923224937_24486_549) 
 */
import org.genesez.platform.java.umlsupport.associations.*;

/**
 * Represents the <b><i>amount</i></b> of time spent for something. This 
 * amount is defined as the <u><i>time difference</i></u> of the start to the 
 * end.
 */
public class Duration {
	
	private long time;
	
	private String unit;
	
	/**
	 * Initializing constructor for class '<em><b>Duration</b></em>'.
	 * @param	time	{@link long.getTime()}
	 * @param	unit	{@link String.getUnit()}
	 */
	public Duration(long time, String unit) {
		this.time = time;
		this.unit = unit;
	}
	
	/**
	 * Returns the value of attribute '<em><b>time</b></em>'
	 * @return	
	 */
	public long getTime() {
		return time;
	}
	
	/**
	 * Returns the value of attribute '<em><b>unit</b></em>'
	 * @return	
	 */
	public String getUnit() {
		return unit;
	}
	
	/* PROTECTED REGION ID(java.datatype.own.code.implementation._16_0_b6f02e1_1231923224937_24486_549) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
