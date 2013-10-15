package org.genesez.adapter.ea.transform;

/* 
 *	Do not place import/include statements above this comment, just below. 
 * 	@FILE-ID : (_17_0_4_1_df50335_1380024548865_144156_3654) 
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralUnlimitedNatural;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.UMLFactory;
import org.sparx.Attribute;

/**
 * Please describe the responsibility of your class in your modeling tool.
 * @author Christian
 */
public class MultiplicityTransformer {
	
	// -- generated attribute, constant + association declarations ----------
	
	private static final Log LOG = LogFactory.getLog(MultiplicityTransformer.class);
	
	private int lower;
	
	private int upper;
	
	// -- generated method stubs for implementations + derived attributes ---
	/**
	 * Method stub for further implementation.
	 */
	public Property transform(Property property, org.sparx.ConnectorEnd connectorEnd) {
		/* PROTECTED REGION ID(java.implementation._17_0_4_1_df50335_1380024632341_159987_3677) ENABLED START */
		
		createLowerUpperCardinality(property, connectorEnd);
		
		return property;
		/* PROTECTED REGION END */
	}
	
	/**
	 * create lower value for multiplicity
	 */
	private LiteralInteger getLiteralInteger(int lower) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363677335004_406825_1910) ENABLED START */
		LiteralInteger literalInteger = UMLFactory.eINSTANCE.createLiteralInteger();
		literalInteger.setValue(lower);
		return literalInteger;
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	private void setCardinality(String cardinality) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363677509656_617682_1926) ENABLED START */
		LOG.debug("Origin: " + cardinality);
		// if string is empty
		if (cardinality.equals("")) {
			LOG.debug("Cardinality is empty");
			lower = 1;
			upper = 1;
		} else if (cardinality.length() == 1) {
			LOG.debug("Cardinality has length of one");
			// single value might be any value >= 0 or *
			upper = evaluateCardinality(cardinality);
			// in case it is *
			if (upper == -1) {
				lower = 0;
			} else {
				lower = upper;
			}
		} else {
			// values that might be 0..*, 1..8, 8..*, etc.
			int counter = 0;
			LOG.debug("Cardinality > 1");
			// split string with ".."
			for (String split : cardinality.split("\\.\\.")) {
				LOG.debug("Split: " + split);
				if (counter++ == 0) {
					LOG.debug("Lower Value = " + split);
					lower = evaluateCardinality(split);
				} else {
					LOG.debug("Upper Value = " + split);
					upper = evaluateCardinality(split);
				}
			}
		}
		
		LOG.debug("Cardinalty: [" + lower + ".." + upper + "]");
		/* PROTECTED REGION END */
	}
	
	/**
	 * Method stub for further implementation.
	 */
	private int evaluateCardinality(String cardinality) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363677677672_483862_1936) ENABLED START */
		// if empty set default to "1"
		if (cardinality.equals("*")) {
			// return unlimited
			return -1;
		} else {
			// return value of string as integer
			return Integer.valueOf(cardinality);
		}
		/* PROTECTED REGION END */
	}
	
	/**
	 * create upper value for multiplicity
	 */
	private LiteralUnlimitedNatural getLiteralUnlimitedNatural(int upper) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363677386473_44938_1918) ENABLED START */
		LiteralUnlimitedNatural unlimitedInteger = UMLFactory.eINSTANCE.createLiteralUnlimitedNatural();
		unlimitedInteger.setValue(upper);
		return unlimitedInteger;
		/* PROTECTED REGION END */
	}
	
	/**
	 * private method to create the multiplicity
	 */
	private void createLowerUpperCardinality(Property property, org.sparx.ConnectorEnd end) {
		/* PROTECTED REGION ID(java.implementation._17_0_5_12d203c6_1363677239565_889873_1901) ENABLED START */
		final String cardinality = end.GetCardinality();
		setCardinality(cardinality);
		
		addLiteralsToProperty(property);
		/* PROTECTED REGION END */
	}
	
	// -- generated association + attribute accessors -----------------------
	
	// -- generated code  ---------------------------------------------------
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(java.class.own.code.implementation._17_0_4_1_df50335_1380024548865_144156_3654) ENABLED START */
	
	private void addLiteralsToProperty(Property property) {
		// lower value
		property.setLowerValue(getLiteralInteger(lower));
		// upper value
		property.setUpperValue(getLiteralUnlimitedNatural(upper));
	}
	
	public Property transform(Property property, Attribute attribute) {
		final String cardinality = attribute.GetLowerBound() + ".." + attribute.GetUpperBound();
		
		setCardinality(cardinality);
		
		addLiteralsToProperty(property);
		return property;
	}
	/* PROTECTED REGION END */
}
