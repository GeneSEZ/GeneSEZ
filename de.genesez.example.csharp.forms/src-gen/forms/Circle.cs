namespace forms
{
	#region Imports
	using System;
	/* PROTECTED REGION ID(java.mclassifier.other.import.code_14_0_b6f02e1_1211871307421_631477_281) ENABLED START */
	/* TODO put your imports here */

	/* PROTECTED REGION END */
	#endregion

	public class Circle : IForm
	{
		#region Private Fields
		private Point center;
		private double radius;
		#endregion

		#region Properties
		public Point Center
		{
			get
			{
				return this.center;
			}
			set
			{
				this.center = value;
			}
		}
		public double Radius
		{
			get
			{
				return this.radius;
			}
			set
			{
				this.radius = value;
			}
		}
		#endregion

		#region Constructors
		public Circle()
		{
			/* PROTECTED REGION ID(java.moperation.implementation.operation.code._14_0_b6f02e1_1211871354437_848983_304) ENABLED START */
			/* TODO put your own implementation code here */

			/* PROTECTED REGION END */
		}

		#endregion

		#region Your Own Implementations
		/* PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._14_0_b6f02e1_1211871307421_631477_281) ENABLED START */
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
