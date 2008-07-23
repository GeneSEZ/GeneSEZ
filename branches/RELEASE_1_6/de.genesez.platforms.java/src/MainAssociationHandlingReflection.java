import de.genesez.platforms.java.umlsupport.associations.Association;
import de.genesez.platforms.java.umlsupport.associations.OneAssociation;

/**
 * 
 */

/**
 * @author dreamer
 *
 */
public class MainAssociationHandlingReflection {
	
	private int count = 0;
	private Left l = new Left();
	private Right r = new Right();
	private Right r2 = new Right();
	
	public MainAssociationHandlingReflection(int count) {
		this.count = count;
	}
	
	public void start() {
		for (int i = 0; i < count; i++) {
			if (i % 2 == 0) {
				l.getRight().insert(r);
			} else {
				l.getRight().insert(r2);
			}
		}
	}
	
	public static class Left {
		private Association<Left, Right> toRight = new OneAssociation<Left, Right>(this, Right.class, "getLeft");
		public Association<Left, Right> getRight() {
			return toRight;
		}
	}
	
	public static class Right {
		private Association<Right, Left> toLeft = new OneAssociation<Right, Left>(this, Left.class, "getRight");
		public Association<Right, Left> getLeft() {
			return toLeft;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MainAssociationHandlingReflection t = new MainAssociationHandlingReflection(999999);
		long start = System.nanoTime();
		t.start();
		long end = System.nanoTime();
		System.out.println("start: " + start);
		System.out.println("end:   " + end);
		System.out.println("duration: " + (end - start));
	}
}
