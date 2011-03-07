namespace forms
{
	#region Imports
	using System;
	/* PROTECTED REGION ID(java.mclassifier.other.import.code_14_0_b6f02e1_1211871374078_396988_308) ENABLED START */
	/* TODO put your imports here */

	/* PROTECTED REGION END */
	#endregion
	
	public class Line : IForm
	{
		#region Private Fields
		private    Point start;
		private    Point end;
		#endregion
		
		#region Properties
		public  Point Start
		{

			get { return this.start; }
			set { this.start = value; }
		}
		public  Point End
		{

			get { return this.end; }
			set { this.end = value; }
		}
		#endregion
		
		#region Constructors
	public Line( Point start,  Point end)
		{
			/* PROTECTED REGION ID(java.moperation.implementation.operation.code._14_0_b6f02e1_1211871400078_573707_331) ENABLED START */
			/* TODO put your own implementation code here */
			this.start = start;
			this.end = end;
			/* PROTECTED REGION END */
		}
		
		#endregion
		
		#region Your Own Implementations
		/* PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._14_0_b6f02e1_1211871374078_396988_308) ENABLED START */
		/* TODO put your own implementation code here */

		public void Move( double dx, double dy )
		{
			this.start.Move( dx, dy );
			this.end.Move( dx, dy );
		}

        public void Rotate(Point c, double phi)
        {
            this.start.Rotate(c, phi);
            this.end.Rotate(c, phi);
        }

		/* PROTECTED REGION END */
		#endregion
	}

}
