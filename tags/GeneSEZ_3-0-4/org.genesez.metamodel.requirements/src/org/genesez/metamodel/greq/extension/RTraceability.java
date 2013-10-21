package org.genesez.metamodel.greq.extension;

import org.genesez.metamodel.greq.RModel;

public class RTraceability extends RExtensionImpl<RTraceability.TAnnotation, RTraceability.TTag> {
	
	public enum TAnnotation implements RExtension.Annotation {
		TRACEABILITY("http://genesez.org/metamodel/traceability");
		
		private String uri;
		
		private TAnnotation(String uri) {
			this.uri = uri;
		}
		
		public String getUri() {
			return uri;
		}
	}
	
	public enum TTag implements RExtension.Tag {
		REQUIREMENT_TRACE("requirement.trace"),
		SCENARIO_TRACE("scenario.trace"),
		SCENARIO_STEP_TRACE("scenario.step.trace");
		
		private String name;
		
		private TTag(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
	}
	
	public void init(RModel model) {
		super.init(model);
		annotations.put(TAnnotation.TRACEABILITY, createAnnotation(model, TAnnotation.TRACEABILITY));
		tags.put(TTag.REQUIREMENT_TRACE, createTag(annotations.get(TAnnotation.TRACEABILITY), TTag.REQUIREMENT_TRACE));
		tags.put(TTag.SCENARIO_TRACE, createTag(annotations.get(TAnnotation.TRACEABILITY), TTag.SCENARIO_TRACE));
		tags.put(TTag.SCENARIO_STEP_TRACE, createTag(annotations.get(TAnnotation.TRACEABILITY), TTag.SCENARIO_STEP_TRACE));
	}
}
