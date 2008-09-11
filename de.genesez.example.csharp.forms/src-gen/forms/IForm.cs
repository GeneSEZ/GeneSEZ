namespace forms
{
	#region Imports
	using System;
	/* PROTECTED REGION ID(java.mclassifier.other.import.code_14_0_b6f02e1_1212580097593_990285_125) ENABLED START */
	/* TODO put your imports here */

	/* PROTECTED REGION END */
	#endregion

	public interface IForm
	{
		#region Public Methods
		void Move( ref double dx, ref double dy );
		void Rotate( ref double phi );
		void Rotate( ref double phi, ref double dx, ref double dy );
		#endregion

		/* PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._14_0_b6f02e1_1212580097593_990285_125) ENABLED START */
		/* TODO put your own implementation code here */

		/* PROTECTED REGION END */
	}
}
