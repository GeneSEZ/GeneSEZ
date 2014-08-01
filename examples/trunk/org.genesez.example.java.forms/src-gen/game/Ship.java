package game;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_6_7ac024e_1365674512783_608870_1931) 
 */
import java.awt.Color;
import java.util.LinkedHashMap;
import java.util.Map;

import org.genesez.platform.java.umlsupport.associations.Accessor;
import org.genesez.platform.java.umlsupport.associations.Association;
import org.genesez.platform.java.umlsupport.associations.AssociationRole;
import org.genesez.platform.java.umlsupport.associations.OneAssociation;
import org.genesez.platform.java.umlsupport.associations.RelatedAssociationRole;

import forms.Figure;
import forms.Point;

/**
 * Please describe the responsibility of your class in your modeling tool.
 */
public class Ship extends Figure implements AssociationRole {
	
	/** Defines an identifier for each association, used by the association handling library */
	public enum Associations implements RelatedAssociationRole {
		SCENE, SHIP
	}
	
	/** Stores the association management objects */
	private Map<RelatedAssociationRole, Association<? extends Object, ? extends Object>> association = new LinkedHashMap<RelatedAssociationRole, Association<? extends Object, ? extends Object>>();
	
	/** Stores the linked object of association '<em><b>scene</b></em>' */
	private Scene scene;
	
	/** Stores the linked object of association '<em><b>ship</b></em>' */
	private ShipThread ship;
	
	private long lifePoints;
	
	private Color color;
	
	private double speed;
	
	private double angle;
	
	/**
	 * Constructor for class '<em><b>Ship</b></em>'.
	 */
	public Ship() {
		/* PROTECTED REGION ID(java.constructor._17_0_6_7ac024e_1365682760697_63597_2049) ENABLED START */
		this.color = Color.GRAY;
		this.speed = 0.001;
		this.angle = 0;
		buildShip();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Constructor for class '<em><b>Ship</b></em>'.
	 */
	public Ship(Color color) {
		/* PROTECTED REGION ID(java.constructor._17_0_6_7ac024e_1365682786042_79604_2053) ENABLED START */
		this.color = color;
		buildShip();
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	private void buildShip() {
		/* PROTECTED REGION ID(java.implementation._17_0_6_7ac024e_1365683050555_766905_2058) ENABLED START */
		Point pointsShip[] = { new Point(2, 2), new Point(4, 2), new Point(4, 4), new Point(6, 4), new Point(6, 2), new Point(8, 0), new Point(12, 0), new Point(14, 2), new Point(14, 4), new Point(16, 4), new Point(16, 2), new Point(18, 2), new Point(18, 14), new Point(16, 14), new Point(16, 10), new Point(14, 10), new Point(12, 16), new Point(8, 16), new Point(6, 10), new Point(4, 10), new Point(4, 14), new Point(2, 14), new Point(2, 2) };
		forms().insert(new forms.Polygon(pointsShip));
		forms().insert(new forms.Circle(new Point(10, 24), 10));
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	public void move() {
		/* PROTECTED REGION ID(java.implementation._17_0_6_7ac024e_1366477758979_46703_2002) ENABLED START */
		double dx = speed * Math.sin(angle);
		double dy = speed * Math.sin(angle);
		this.move(1, 1);
		//Xneu = xalt + distance * sin(winkel)
		//yalt = yalt + distance * sin(winkel)
		/* PROTECTED REGION END */
	}
	
	/**
	 * Returns the value of attribute '<em><b>lifePoints</b></em>'.
	 */
	public long getLifePoints() {
		return this.lifePoints;
	}
	
	/**
	 * Sets the value of attribute '<em><b>lifePoints</b></em>'.
	 * @param	lifePoints	the value to set.
	 */
	public void setLifePoints(long lifePoints) {
		this.lifePoints = lifePoints;
	}
	
	/**
	 * Returns the value of attribute '<em><b>color</b></em>'.
	 */
	public Color getColor() {
		return this.color;
	}
	
	/**
	 * Returns the value of attribute '<em><b>speed</b></em>'.
	 */
	public double getSpeed() {
		return this.speed;
	}
	
	/**
	 * Sets the value of attribute '<em><b>speed</b></em>'.
	 * @param	speed	the value to set.
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	/**
	 * Returns the value of attribute '<em><b>angle</b></em>'.
	 */
	public double getAngle() {
		return this.angle;
	}
	
	/**
	 * Sets the value of attribute '<em><b>angle</b></em>'.
	 * @param	angle	the value to set.
	 */
	public void setAngle(double angle) {
		this.angle = angle;
	}
	
	// initialization block for association management objects
	{
		association.put(Associations.SCENE, new OneAssociation<Ship, Scene>(this, new Accessor<Scene>() {
			public Scene get() {
				return scene;
			}
			
			public void set(Scene referenced) {
				scene = referenced;
			}
		}, Scene.Associations.SHIP));
		association.put(Associations.SHIP, new OneAssociation<Ship, ShipThread>(this, new Accessor<ShipThread>() {
			public ShipThread get() {
				return ship;
			}
			
			public void set(ShipThread referenced) {
				ship = referenced;
			}
		}, ShipThread.Associations.SHIPTHREAD));
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
	 * Provides access to the association '<em><b>scene</b></em>' to {@link Scene}.
	 */
	@SuppressWarnings("unchecked")
	public Association<Ship, Scene> scene() {
		return (Association<Ship, Scene>) association.get(Associations.SCENE);
	}
	
	/**
	 * Provides access to the association '<em><b>ship</b></em>' to {@link ShipThread}.
	 */
	@SuppressWarnings("unchecked")
	public Association<Ship, ShipThread> ship() {
		return (Association<Ship, ShipThread>) association.get(Associations.SHIP);
	}
	
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_6_7ac024e_1365674512783_608870_1931) ENABLED START */
	// TODO: put your own implementation code here
	/* PROTECTED REGION END */
}
