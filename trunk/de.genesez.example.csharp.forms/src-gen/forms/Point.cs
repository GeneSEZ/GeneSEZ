namespace forms
{
	#region Imports
	using System;
	/* PROTECTED REGION ID(java.mclassifier.other.import.code_14_0_b6f02e1_1211871095796_723781_254) ENABLED START */
	/* TODO put your imports here */

	/* PROTECTED REGION END */
	#endregion

	public class Point : IForm
	{
		#region Private Fields
		private double x;
		private double y;
		#endregion

		#region Properties
		public double X
		{
			get
			{
				return this.x;
			}
			set
			{
				this.x = value;
			}
		}
		public double Y
		{
			get
			{
				return this.y;
			}
			set
			{
				this.y = value;
			}
		}
		#endregion

		#region Constructors
		public Point()
		{
			/* PROTECTED REGION ID(java.moperation.implementation.operation.code._14_0_b6f02e1_1211871240109_473577_277) ENABLED START */
			/* TODO put your own implementation code here */
            this.x = 0.0;
            this.y = 0.0;
			/* PROTECTED REGION END */
		}

		#endregion

		#region Your Own Implementations
		/* PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._14_0_b6f02e1_1211871095796_723781_254) ENABLED START */
		/* TODO put your own implementation code here */

        public void Move(double dx, double dy)
        {
            throw new NotImplementedException();
        }

        public void Rotate(double phi)
        {
            throw new NotImplementedException();
        }

        public void Rotate(double phi, double dx, double dy)
        {
            throw new NotImplementedException();
        }

		/* PROTECTED REGION END */
		#endregion
    }
}
