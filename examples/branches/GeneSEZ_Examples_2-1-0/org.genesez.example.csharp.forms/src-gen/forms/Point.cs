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
		private    double x;
		private    double y;
		#endregion
		
		#region Properties
		public  double X
		{

			get { return this.x; }
			set { this.x = value; }
		}
		public  double Y
		{

			get { return this.y; }
			set { this.y = value; }
		}
		#endregion
		
		#region Constructors
	public Point( double x,  double y)
		{
			/* PROTECTED REGION ID(java.moperation.implementation.operation.code._14_0_b6f02e1_1211871240109_473577_277) ENABLED START */
			/* TODO put your own implementation code here */
			this.x = x;
			this.y = y;
			/* PROTECTED REGION END */
		}
		
		#endregion
		
		#region Your Own Implementations
		/* PROTECTED REGION ID(java.mclassifier.implementation.owncode.code._14_0_b6f02e1_1211871095796_723781_254) ENABLED START */
		/* TODO put your own implementation code here */

		public void Move( double dx, double dy )
		{
			this.x += dx;
			this.y += dy;
		}
        		
        public void Rotate(Point c, double phi)
		{
			double phiAsRadian = (phi * Math.PI) / 180;
			double tx = this.x - c.x;
			double ty = this.y - c.y;
			double h = Math.Sqrt( Math.Pow( tx, 2 ) + Math.Pow( ty, 2 ));
			double dx = Math.Cos( phiAsRadian ) * h;
			double dy = Math.Sin( phiAsRadian ) * h;
			this.x = dx + c.x;
			this.y = dy + c.y;
		}

		/* PROTECTED REGION END */
		#endregion
	}

}
