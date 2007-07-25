package de.genesez.mapping;

import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

public class Mapping {
	
	//private static String xmlFile = "E:\\workspaceDiplomarbeit\\de.genesez.templates\\mapping\\de\\genesez\\mapping\\templatemapping.xml";
	private static String xmlFile = "..\\de.genesez.templates\\mapping\\de\\genesez\\mapping\\templatemapping.xml";

	
	public static String typeMapping(String _map, String _target) {
		try {
			FileReader fr = new FileReader(xmlFile);
			SAXReader saxReader = new SAXReader(false);
			Document doc = saxReader.read(new InputSource(fr));
			fr.close();
			
			return getMapToValue(doc, _map, _target);			
		} catch (Exception e) {
			System.out.println(e);
		}
		return _map;
	}
	
	
	private static String getMapToValue(Document _doc, String _map, String _target) {
		Element mapping, target;
		List mappings;
		
		mappings = getMappings(getRoot(_doc));
		Iterator it = mappings.iterator();
		while(it.hasNext()) {
			mapping = (Element)it.next();
			if (isSearchedMap(getMap(mapping), _map)) {
				target = getTarget(getTargetDefault(mapping), getTarget(mapping, _target));
				return getValue(target);
			}
		}
		return _map;
	}
	
	
	private static Element getRoot(Document doc) {
		return doc.getRootElement();
	}
	
	
	private static List getMappings(Element root) {
		return root.elements("Mapping");
	}
	
	
	private static Element getMap(Element mapping) {
		return mapping.element("Map");
	}
	
	
	private static Element getTarget(Element targetDefault, Element target) {
		if (target != null) {
			return target;
		} else {
			return targetDefault;
		}
	}
	
	
	private static Element getTargetDefault(Element mapping) {
		return mapping.element("ToDefault");
	}
	
	
	private static Element getTarget(Element mapping, String mapTo) {
		return mapping.element(mapTo);
	}
	
	
	private static String getValue(Element e) {
		return e.getStringValue();
	}
	
	
	private static boolean isSearchedMap(Element map, String searchedMap) {
		return  map.getStringValue().equals(searchedMap);
	}
	
	
}
