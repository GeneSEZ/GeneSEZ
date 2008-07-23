/**
 * 
 */

/**
 * @author dreamer
 *
 */
public class MainComparation {

	private static void perform(int count) {
		MainAssociationHandlingCallback c = new MainAssociationHandlingCallback(count);
		MainAssociationHandlingReflection r = new MainAssociationHandlingReflection(count);
		long cs = System.nanoTime();
		c.start();
		long ce = System.nanoTime();
		long rs = System.nanoTime();
		r.start();
		long re = System.nanoTime();
		System.out.println("reflection: " + rs + " - " + re + " = " + (re - rs));
		System.out.println("callback  : " + cs + " - " + ce + " = " + (ce - cs));
		System.out.println("reflection - callback: " + (re - rs - ce + cs));
		double diff = ((double)(re - rs)) / ((double)(ce - cs));
		System.out.printf("%s %f\n", "reflection / callback: ", diff);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		perform(10000000);
		perform(20000000);
	}
}
