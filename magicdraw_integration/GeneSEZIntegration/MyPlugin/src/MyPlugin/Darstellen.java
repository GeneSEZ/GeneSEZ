package MyPlugin;



import java.awt.Graphics;

import com.nomagic.magicdraw.uml.symbols.PresentationElement;
import com.nomagic.magicdraw.uml.symbols.PresentationElementRenderer;
import com.nomagic.magicdraw.uml.symbols.PresentationElementRendererProvider;
import com.nomagic.magicdraw.uml.symbols.paths.DependencyView;
import com.nomagic.magicdraw.uml.symbols.shapes.ClassView;


class Darstellen implements PresentationElementRendererProvider
{

	private ConnectionRenderer connectionRenderer;
	private int value;

	
	Darstellen(int value)
	{
		connectionRenderer = new ConnectionRenderer();
		this.value = value;
	}
	
	

	public PresentationElementRenderer getRenderer(PresentationElement presentationElement)
	{
		if (presentationElement instanceof DependencyView)
		{
			return connectionRenderer;
		}

		return null;
	}
	
	
}
