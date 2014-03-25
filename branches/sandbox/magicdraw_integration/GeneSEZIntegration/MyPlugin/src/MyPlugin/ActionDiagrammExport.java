package MyPlugin;

import java.awt.event.ActionEvent;
import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.emfuml2xmi.v4.EmfUml2XmiPlugin;



class ActionDiagrammExport extends MDAction
{

	public ActionDiagrammExport(String id, String name)
	{
		super(id, name, null, null);
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		try 
		{
			javax.swing.JOptionPane.showMessageDialog(null, "Diagramm wird jetzt nach " + System.getProperty("user.dir") + " exportiert... ");
			EmfUml2XmiPlugin.getInstance().exportXMI(Application.getInstance().getProject(), System.getProperty("user.dir"));
			
			javax.swing.JOptionPane.showMessageDialog(null, "Diagram wurde exportiert");
			
			Runtime.getRuntime().exec("explorer.exe " + System.getProperty("user.dir"));
		} 
		catch (Exception e1)
		{
			javax.swing.JOptionPane.showMessageDialog(null, "Catch");
			e1.printStackTrace();
		}
	}

}