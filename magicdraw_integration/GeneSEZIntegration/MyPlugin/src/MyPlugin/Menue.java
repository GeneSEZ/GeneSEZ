package MyPlugin;

import java.awt.event.ActionEvent;

import javax.swing.JOptionPane;

import com.nomagic.magicdraw.ui.browser.Node;
import com.nomagic.magicdraw.ui.browser.Tree;
import com.nomagic.magicdraw.ui.browser.actions.DefaultBrowserAction;
import com.nomagic.magicdraw.ui.dialogs.MDDialogParentProvider;
import com.nomagic.magicdraw.uml.BaseElement;

public class Menue extends DefaultBrowserAction
{
	public Menue()
	{
		super("", "ExampleAction", null, null);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Tree tree = getTree();
		String text="Selected elements:";
		for (int i = 0; i < tree.getSelectedNodes().length; i++)
		{
			Node node = tree.getSelectedNodes()[i];
			Object userObject = node.getUserObject();
			
			if (userObject instanceof BaseElement)
			{
				BaseElement element = (BaseElement) userObject;
				text += "\n"+element.getHumanName();
			}
		}
		
		JOptionPane.showMessageDialog(MDDialogParentProvider.getProvider().getDialogParent(), text);
	}
}