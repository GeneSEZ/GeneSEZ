import java.util.LinkedHashMap;
import java.util.Map;

import de.genesez.platforms.java.umlsupport.associations.modified.Association;
import de.genesez.platforms.java.umlsupport.associations.modified.RelatedAssociationRole;
import de.genesez.platforms.java.umlsupport.associations.modified.OneAssociation;
import de.genesez.platforms.java.umlsupport.associations.modified.AssociationRole;

/**
 * @author dreamer
 */
public class MainAssociationHandlingCallback {
	
	private int count = 0;
	private Left l = new Left();
	private Right r = new Right();
	private Right r2 = new Right();
	
	public MainAssociationHandlingCallback(int count) {
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
	
	public static class Left implements AssociationRole {
		public enum Associations implements RelatedAssociationRole {
			TO_RIGHT
		}
		private Map<RelatedAssociationRole, Association<? extends AssociationRole, ? extends AssociationRole>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends AssociationRole,? extends AssociationRole>>();
		{
			association.put(Associations.TO_RIGHT, new OneAssociation<Left, Right>(this, Right.Associations.TO_LEFT));
		}
		public Association<? extends AssociationRole, ? extends AssociationRole> getAssociation(
				RelatedAssociationRole role) {
			if (association.containsKey(role)) return association.get(role);
			throw new RuntimeException("wrong association role specified");
		}
		public Association<Left, Right> getRight() {
			return (Association<Left, Right>) association.get(Associations.TO_RIGHT);
		}
	}
	
	public static class Right implements AssociationRole {
		public enum Associations implements RelatedAssociationRole {
			TO_LEFT
		}
		private Map<RelatedAssociationRole, Association<? extends AssociationRole, ? extends AssociationRole>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends AssociationRole,? extends AssociationRole>>();
		{
			association.put(Associations.TO_LEFT, new OneAssociation<Right, Left>(this, Left.Associations.TO_RIGHT));
		}
		public Association<? extends AssociationRole, ? extends AssociationRole> getAssociation(
				RelatedAssociationRole role) {
			if (association.containsKey(role)) return association.get(role);
			throw new RuntimeException("wrong association role specified");
		}
		public Association<Right, Left> getLeft() {
			return (Association<Right, Left>) association.get(Associations.TO_LEFT);
		}
	}
	
	public static void main(String args[]) {
		MainAssociationHandlingCallback t = new MainAssociationHandlingCallback(999999);
		long start = System.nanoTime();
		t.start();
		long end = System.nanoTime();
		System.out.println("start: " + start);
		System.out.println("end:   " + end);
		System.out.println("duration: " + (end - start));
	}
}
