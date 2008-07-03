package de.genesez.platforms.java.umlsupport.associations;

import java.util.HashSet;

import de.genesez.platforms.java.umlsupport.associations.Association;
import de.genesez.platforms.java.umlsupport.associations.ManyAssociation;
import de.genesez.platforms.java.umlsupport.associations.OneAssociation;

public class Hub {
	private Association<Hub, Related> rel1 = new OneAssociation<Hub, Related>(
			this);
	private Association<Hub, Related> rel2Sym = new OneAssociation<Hub, Related>(
			this, Related.class, "hub1");

	private Association<Hub, Related> m1 = new ManyAssociation<Hub, Related>(
			this, new HashSet<Related>());

	private Association<Hub, Related> m2 = new ManyAssociation<Hub, Related>(
			this, new HashSet<Related>(), Related.class, "hub2");

	private Association<Hub, Related> m3 = new ManyAssociation<Hub, Related>(
			this, new HashSet<Related>(), Related.class, "hubs");

	public Association<Hub, Related> rel1() {
		return rel1;
	}

	public Association<Hub, Related> rel2Sym() {
		return rel2Sym;
	}

	public Association<Hub, Related> m1() {
		return m1;
	}

	public Association<Hub, Related> m2one() {
		return m2;
	}

	public Association<Hub, Related> m2m() {
		return m3; 
	}

}
