package de.genesez.app.potsensor;/* PROTECTED REGION ID(java.mclassifier.other.import.code_12_5_8a7027a_1184788436265_449095_937) ENABLED START *//* TODO put your imports here */import java.lang.String;import de.genesez.j2meframework.sensor.MeasureSensor;/* PROTECTED REGION END *//** * This class represents the pressure sensor form the whz in zwickau germany. * @author nicher */public class PotSensor extends MeasureSensor {		// ////////////////////////////////////////////////////////////////////////	// generated variable, constant and association declarations	// ////////////////////////////////////////////////////////////////////////		/** @see {@link getIsAutoMeasureMode} */	private Boolean isAutoMeasureMode = false;	private Boolean autoMeasureStop = false;	private int autoMeasureCycleTime = 10000;		// ////////////////////////////////////////////////////////////////////////	// generated constructor implementations	// ////////////////////////////////////////////////////////////////////////		/**	 * @param  address  	 * @param  gradient  	 * @param  offset  	 */	public PotSensor(String address, float gradient, float offset) {		/* PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1188991660230_164612_1324) ENABLED START */		/* TODO put your own implementation code here */		super(address, gradient, offset);		/* PROTECTED REGION END */	}		// ////////////////////////////////////////////////////////////////////////	// generated derived attribute method implementations	// ////////////////////////////////////////////////////////////////////////		// ////////////////////////////////////////////////////////////////////////	// generated association method implementations	// ////////////////////////////////////////////////////////////////////////		// ////////////////////////////////////////////////////////////////////////	// generated abstract method declaration	// ////////////////////////////////////////////////////////////////////////		// ////////////////////////////////////////////////////////////////////////	// generated normal method implementations	// ////////////////////////////////////////////////////////////////////////		/**	 * This method reads from the whz pressure sensor which is connected by the i2c bus system.	 */	public void measure() {				/* PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1184788568835_800356_1085) ENABLED START */		/* TODO put your own implementation code here */		/* PROTECTED REGION END */	}		/**	 * Starts the manual measure measure mode in a Thread.	 */	public void manualMeasure() {				/* PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1184939798112_183751_634) ENABLED START */		/* TODO put your own implementation code here */		/* PROTECTED REGION END */	}		/**	 * Starts the auto measure mode in a thread.	 */	public void autoMeasure() {				/* PROTECTED REGION ID(java.moperation.implementation.operation.code._12_5_8a7027a_1184939024358_452624_613) ENABLED START */		/* TODO put your own implementation code here */		/* PROTECTED REGION END */	}		// ////////////////////////////////////////////////////////////////////////	// generated getter and setter method implementations	// ////////////////////////////////////////////////////////////////////////		/**	 * Starts / stops the auto measure mode.	 */	public Boolean getIsAutoMeasureMode() {		return isAutoMeasureMode;	}		/** @see {@link getIsAutoMeasureMode} */	public void setIsAutoMeasureMode(Boolean _isAutoMeasureMode) {		isAutoMeasureMode = _isAutoMeasureMode;	}		public Boolean getAutoMeasureStop() {		return autoMeasureStop;	}		public void setAutoMeasureStop(Boolean _autoMeasureStop) {		autoMeasureStop = _autoMeasureStop;	}		public int getAutoMeasureCycleTime() {		return autoMeasureCycleTime;	}		public void setAutoMeasureCycleTime(int _autoMeasureCycleTime) {		autoMeasureCycleTime = _autoMeasureCycleTime;	}		// ////////////////////////////////////////////////////////////////////////	// own implementations	// ////////////////////////////////////////////////////////////////////////		/* PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._12_5_8a7027a_1184788436265_449095_937) ENABLED START */	/* TODO put your own implementation code here */	/* PROTECTED REGION END */}