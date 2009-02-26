
import java.util.Calendar;
import java.util.GregorianCalendar;

import core.Milestone;
import core.Project;

/**
 * Main class for simple demonstration
 * @author dreamer
 */
public class Main {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Project project = new Project();
		project.setName("Cebit");
		project.setDescription("a popular exhibition");
		
		Calendar m1d = GregorianCalendar.getInstance();
		
		Milestone m1 = new Milestone();
		m1.setName("requirement analysis");
		m1.setDescription("collect requirements");
		m1d.set(2009, 1, 31);
		m1.setDeadline(m1d.getTime());
		
		Milestone m2 = new Milestone();
		m2.setName("prototype");
		m2.setDescription("develop a running prototype showing a minimal set of functional requirements");
		m1d.add(Calendar.MONTH, 1);
		m2.setDeadline(m1d.getTime());
		
		// inverse set automatically :-)
		project.milestone().insert(m1);
		project.milestone().insert(m2);
		
		
	}
}
