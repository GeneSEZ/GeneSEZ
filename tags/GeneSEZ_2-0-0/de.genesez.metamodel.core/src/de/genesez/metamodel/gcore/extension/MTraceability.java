package de.genesez.metamodel.gcore.extension;

import de.genesez.metamodel.gcore.MModel;

/**
 * @author dreamer
 */
public class MTraceability extends MExtensionImpl<MTraceability.TStereotype, MTraceability.TTag> {
	
	public enum TStereotype implements MExtension.Stereotype {
		TRACEABILITY("http://genesez.de/metamodel/traceability");
		
		private String name;
		
		private TStereotype(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
		public String getXmiGuid() {
			return name;
		}
	}
	
	public enum TTag implements MExtension.Tag {
		SCENARIO_TRACE("scenario.trace", "uri"),
		SCENARIO_STEP_TRACE("scenario.step.trace", "uri"),
		REQUIREMENT_TRACE("requirement.trace", "uri");
		
		private String name;
		private String type;
		
		private TTag(String name, String type) {
			this.name = name;
			this.type = type;
		}
		
		public String getName() {
			return name;
		}
		
		public String getType() {
			return type;
		}
	}
	
	public void init(MModel model) {
		super.init(model);
		stereotypes.put(TStereotype.TRACEABILITY, createStereotype(model, TStereotype.TRACEABILITY));
		tags.put(TTag.REQUIREMENT_TRACE, createTag(stereotypes.get(TStereotype.TRACEABILITY), TTag.REQUIREMENT_TRACE));
		tags.put(TTag.SCENARIO_TRACE, createTag(stereotypes.get(TStereotype.TRACEABILITY), TTag.SCENARIO_TRACE));
		tags.put(TTag.SCENARIO_STEP_TRACE, createTag(stereotypes.get(TStereotype.TRACEABILITY), TTag.SCENARIO_STEP_TRACE));
	}
}
