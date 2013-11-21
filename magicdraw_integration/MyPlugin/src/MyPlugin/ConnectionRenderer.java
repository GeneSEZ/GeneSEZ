package MyPlugin;

import com.nomagic.magicdraw.properties.Property;
import com.nomagic.magicdraw.properties.PropertyID;
import com.nomagic.magicdraw.uml.symbols.PresentationElement;
import com.nomagic.magicdraw.uml.symbols.PresentationElementColorEnum;
import com.nomagic.magicdraw.uml.symbols.paths.*;

import java.awt.*;


class ConnectionRenderer extends PathRenderer
{
	private PathEndRenderer pathEndRenderer;

	ConnectionRenderer()
	{
		pathEndRenderer = new PathEndRenderer(PathEndAdornment.CIRCLE, PathEndAdornmentModifier.FILLED);
	}



	@Override
	public int getLineWidth(PresentationElement presentationElement)
	{
		return 10;
	}

	@Override
	protected void drawPathAdornment(Graphics g, PathElement pathElement)
	{
		super.drawPathAdornment(g, pathElement);

		Property property = pathElement.getDiagramPresentationElement().getProperty(PropertyID.DIAGRAM_BACKGROUND_COLOR);
		
		if (property != null)
		{
			Object value = property.getValue();
		}
		
		
		Point middlePoint = pathElement.getMiddlePoint();
		int diameter = 60;
		int radius = diameter/2;
		int x = middlePoint.x - radius;
		int y = middlePoint.y - radius;
		
		Color color = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x, y, diameter, diameter*2);
		g.setColor(color);
		g.drawOval(x, y, diameter, diameter*2);
		
		
		
		g.setColor(color.blue);
		g.fill3DRect(x+26/2, y+26/2, 26, 26, true);
		
		g.draw3DRect(x+26/2, y+26/2,26,26, true);

	}
}
