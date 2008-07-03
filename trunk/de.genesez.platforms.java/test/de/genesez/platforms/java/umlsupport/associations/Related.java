package de.genesez.platforms.java.umlsupport.associations;

import java.util.HashSet;

import de.genesez.platforms.java.umlsupport.associations.Association;
import de.genesez.platforms.java.umlsupport.associations.ManyAssociation;
import de.genesez.platforms.java.umlsupport.associations.OneAssociation;

public class Related {

	private Association<Related, Hub> hub1 = new OneAssociation<Related, Hub>(
			this, Hub.class, "rel2Sym");

	private Association<Related, Hub> hub2 = new OneAssociation<Related, Hub>(
			this, Hub.class, "m2one");

	private Association<Related, Hub> toHubs = new ManyAssociation<Related, Hub>(
			this, new HashSet<Hub>(), Hub.class, "m2m");

	public Association<Related, Hub> hub1() {
		return hub1;
	}

	public Association<Related, Hub> hub2() {
		return hub2;
	}

	public Association<Related, Hub> hubs() {
		return toHubs;
	}

}
