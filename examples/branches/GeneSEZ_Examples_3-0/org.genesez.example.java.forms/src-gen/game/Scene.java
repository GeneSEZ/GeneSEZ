package game;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_6_7ac024e_1365527379559_267511_2357) 
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
import forms.Circle;
import forms.Point;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class Scene implements AssociationRole {
	
	/** Defines an identifier for each association, used by the association handling library */
	public enum Associations implements RelatedAssociationRole {
		SHIP
	}
	
	/** Stores the association management objects */
	private Map<RelatedAssociationRole, Association<? extends Object, ? extends Object>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends Object, ? extends Object>>();
	
	/** Stores the linked object of association '<em><b>ship</b></em>' */
	private Ship ship;
	
	private static WhiteBoard board;
	
	/**
	 * Constructor for class '<em><b>Scene</b></em>'.
	 */
	public Scene() {
		/* PROTECTED REGION ID(java.constructor._17_0_6_7ac024e_1365595814426_735000_1993) ENABLED START */
		board = new WhiteBoard();
		this.buildScene();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	private void buildScene() {
		/* PROTECTED REGION ID(java.implementation._17_0_6_7ac024e_1365599115645_205255_2077) ENABLED START */
		Circle c;
		c = new Circle(new Point(10, 10), 10);
		//c.repaint(Color.BLACK);
		Ship ship;
		ship = new Ship();
		ship.move(300, 300);
		ship.repaint(Color.GRAY, true);
		new ShipThread(ship).start();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public static WhiteBoard getBoard() {
		/* PROTECTED REGION ID(java.implementation._17_0_6_7ac024e_1365602177157_668595_2080) ENABLED START */
		return board;
		/* PROTECTED REGION END */
	}
	
	// initialization block for association management objects
	{
		association.put(Associations.SHIP, new OneAssociation<Scene, Ship>(this, new Accessor<Ship>() {
			public Ship get() {
				return ship;
			}
			
			public void set(Ship referenced) {
				ship = referenced;
			}
		}, Ship.Associations.SCENE));
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
	 * Provides access to the association '<em><b>ship</b></em>' to {@link Ship}.
	 */
	@SuppressWarnings("unchecked")
	public Association<Scene, Ship> ship() {
		return (Association<Scene, Ship>) association.get(Associations.SHIP);
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_6_7ac024e_1365527379559_267511_2357) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
