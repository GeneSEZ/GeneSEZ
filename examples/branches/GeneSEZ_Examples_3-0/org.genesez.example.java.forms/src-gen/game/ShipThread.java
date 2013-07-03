package game;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_6_7ac024e_1366477167003_317743_1555) 
 */
import java.awt.Color;
import java.util.LinkedHashMap;
import java.util.Map;

import org.genesez.platform.java.umlsupport.associations.Accessor;
import org.genesez.platform.java.umlsupport.associations.Association;
import org.genesez.platform.java.umlsupport.associations.AssociationRole;
import org.genesez.platform.java.umlsupport.associations.OneAssociation;
import org.genesez.platform.java.umlsupport.associations.RelatedAssociationRole;

import teaching.WhiteBoard;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class ShipThread extends Thread implements AssociationRole {
	
	/** Defines an identifier for each association, used by the association handling library */
	public enum Associations implements RelatedAssociationRole {
		SHIPTHREAD
	}
	
	/** Stores the association management objects */
	private Map<RelatedAssociationRole, Association<? extends Object, ? extends Object>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends Object, ? extends Object>>();
	
	/** Stores the linked object of association '<em><b>shipthread</b></em>' */
	private Ship shipthread;
	
	private Ship ship;
	
	private WhiteBoard board;
	
	/**
	 * Constructor for class '<em><b>ShipThread</b></em>'.
	 */
	public ShipThread(Ship ship) {
		/* PROTECTED REGION ID(java.constructor._17_0_6_7ac024e_1366477478514_272670_1993) ENABLED START */
		this.ship = ship;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public void run() {
		/* PROTECTED REGION ID(java.implementation._17_0_6_7ac024e_1366477259337_871181_1586) ENABLED START */
		while (true) { //TODO: Abbruchbedingung...wenn Programm beendet wird
			try {
				ship.move();
				ship.repaint(Color.GRAY, true);
				sleep(50);
			} catch (InterruptedException ex) {
				System.err.print("Interrupted Exception");
			}
		}
		/* PROTECTED REGION END */
	}
	
	// initialization block for association management objects
	{
		association.put(Associations.SHIPTHREAD, new OneAssociation<ShipThread, Ship>(this, new Accessor<Ship>() {
			public Ship get() {
				return shipthread;
			}
			
			public void set(Ship referenced) {
				shipthread = referenced;
			}
		}, Ship.Associations.SHIP));
	}
	
	/**
	 * Provides generic access to association objects, used by the association handling library
	 * @see org.genesez.platform.java.umlsupport.associations.AssociationRole#getAssociation(org.genesez.platform.java.umlsupport.associations.modified.RelatedAssociationRole)
	 */
	public Association<? extends Object, ? extends Object> getAssociation(RelatedAssociationRole role) {
		if (association.containsKey(role))
			return association.get(role);
		throw new RuntimeException("the class doesn't have the association you specified!");
	}
	
	/**
	 * Provides access to the association '<em><b>shipthread</b></em>' to {@link Ship}.
	 */
	@SuppressWarnings("unchecked")
	public Association<ShipThread, Ship> shipthread() {
		return (Association<ShipThread, Ship>) association.get(Associations.SHIPTHREAD);
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_6_7ac024e_1366477167003_317743_1555) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
