package de.genesez.platforms.common.workflow.xpand2;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import de.genesez.platforms.common.typemapping.TypeMapper;

/**
 * GeneSEZ specific Generator Class supporting the GeneSEZ type mapping
 * 
 * @author	nico herbig
 * @author	tobias haubold (last)
 * @date	2008-02-19
 */
public class Generator extends org.openarchitectureware.xpand2.Generator {
	
	/**
	 * constructs the GeneSEZ Generator
	 */
	public Generator() {
		super();
	}
	
	/**
	 * setter for the type mapping file
	 * @param	typeMappingFile		name of the file used by the generator for type mapping
	 */
	public void setTypeMappingFile(final String typeMappingFile) {
		TypeMapper.initTypeMapper(typeMappingFile);
    }

	/**
	 * overridden adder for advice templates which filters empty strings
	 * @see org.openarchitectureware.xpand2.Generator#addAdvice(java.lang.String)
	 */
	@Override
	public void addAdvice(String advice) {
		if ( advice.length() > 0 ) {
			super.addAdvice(advice);
		}
	}

	/**
	 * overridden adder for a comma separated list of advice templates which filters empty strings
	 * @see org.openarchitectureware.xpand2.Generator#addAdvices(java.lang.String)
	 */
	@Override
	public void addAdvices(String advices) {
		if ( advices.length() > 0 ) {
			List<String> filtered = split(advices);
			for (String s : filtered) {
				addAdvice(s);
			}
		}
	}

	/**
	 * overridden adder for advice scripts which filters empty strings
	 * @see org.openarchitectureware.xpand2.Generator#addExtensionAdvice(java.lang.String)
	 */
	@Override
	public void addExtensionAdvice(String extensionAdvice) {
		if ( extensionAdvice.length() > 0 ) {
			super.addExtensionAdvice(extensionAdvice);
		}
	}

	/**
	 * overridden adder for a comma separated list of advice scripts which filters empty strings
	 * @see org.openarchitectureware.xpand2.Generator#addExtensionAdvices(java.lang.String)
	 */
	@Override
	public void addExtensionAdvices(String extensionAdvices) {
		if ( extensionAdvices.length() > 0 ) {
			List<String> filtered = split(extensionAdvices);
			for (String s : filtered) {
				addExtensionAdvice(s);
			}
		}
	}
	
	/**
	 * splits a comma or semicolon separated list into a list an trims the values
	 * @param list	a comma or semicolon separated list
	 * @return		a list of strings
	 */
	private List<String> split(String list) {
		List<String> result = new ArrayList<String>();
		StringTokenizer tokenizer = new StringTokenizer(list, ",;");
		while (tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			result.add( token.trim() );
		}
		return result;
	}
}
