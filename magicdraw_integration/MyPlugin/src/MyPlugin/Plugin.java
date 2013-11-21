package MyPlugin;


import java.awt.Color;

import javax.swing.ImageIcon;

import com.nomagic.actions.AMConfigurator;
import com.nomagic.actions.ActionsCategory;
import com.nomagic.actions.ActionsManager;
import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.actions.ActionsConfiguratorsManager;
import com.nomagic.magicdraw.actions.BrowserContextAMConfigurator;
import com.nomagic.magicdraw.actions.MDActionsCategory;
import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.openapi.uml.SessionManager;
import com.nomagic.magicdraw.properties.ColorProperty;
import com.nomagic.magicdraw.properties.PropertyID;
import com.nomagic.magicdraw.properties.PropertyManager;
import com.nomagic.magicdraw.ui.browser.Tree;
import com.nomagic.magicdraw.uml.DiagramType;





public class Plugin extends com.nomagic.magicdraw.plugins.Plugin
{
	ActionNotificationErstellen createAnnotationAction;
	
	@Override
	public boolean close() 
	{
		//javax.swing.JOptionPane.showMessageDialog(null, "MagicDraw wird jetzt beendet");
		
		return true;
	}

	@Override
	public void init() 
	{
		new MessageServiceClass("Titel", "Nachricht");
		new MessageServiceClass("Titel");
		
		
		javax.swing.JOptionPane.showMessageDialog(null, "MagicDraw wurde gestartet." + "\n"+ "\n"  +"Pluginname:  " + this.getDescriptor().getName()+ "\n"+"Version: " + this.getDescriptor().getVersion() +"\n"+"Ersteller: " + this.getDescriptor().getProvider());
		
		
		
		
	    ActionsConfiguratorsManager manager = ActionsConfiguratorsManager.getInstance();
		
	    
	    ActionZoom action = new ActionZoom("+");
	    action.setLargeIcon(new ImageIcon(getClass().getResource("icon.gif") ) );
		manager.addMainToolbarConfigurator(new Toolbar(action));
		
		ActionZoom action2 = new ActionZoom("-");
	    action2.setLargeIcon(new ImageIcon(getClass().getResource("icon2.gif") ) );
		manager.addMainToolbarConfigurator(new Toolbar(action2));
		
		
		ActionKlasseErstellenAusgeben action3 = new ActionKlasseErstellenAusgeben("5", "Testklasse Erstellen");
		action3.setLargeIcon( new ImageIcon(getClass().getResource("icon.gif")));
		action3.setDescription("Erstelle Klasse");
        Diagram diagram = new Diagram(action3);
        
        manager.addDiagramToolbarConfigurator(DiagramType.UML_CLASS_DIAGRAM, diagram);
		

		manager.addMainMenuConfigurator(new MainMenue(new ActionProjektNameModelNameAnzeigen("1", "Abfrage")));
		manager.addMainMenuConfigurator(new MainMenue(new ActionKlassenUndAttributeAusgeben("4", "Attribute ausgeben")));	
		manager.addMainMenuConfigurator(new MainMenue(new ActionNamensaenderungListener("3", "Namen ändern / Listener")));
		
		manager.addMainMenuConfigurator(new MainMenue(new ActionKlasseErstellenAusgeben("5", "Testklasse Erstellen")));
		manager.addMainMenuConfigurator(new MainMenue(getSubMenuActionsPaint()));
		
		manager.addMainMenuConfigurator(new MainMenue(new ActionDiagrammExport ("7", "Diagram Exportieren")));
		manager.addMainMenuConfigurator(new MainMenue(getSubMenuNachricht()));
		manager.addMainMenuConfigurator(new MainMenue(getSubMenuActionsZeichenfläche()));
		
		manager.addMainMenuConfigurator(new MainMenue(new ActionNotificationErstellen ("10", "Rahmen erstellen")));
	}
	
	
	
	
	private NMAction getSubMenuNachricht()
	{
		ActionsCategory category = new ActionsCategory(null, "Nachrichten");
		category.setNested(true);
		category.addAction(new ActionNachrichtAusgeben(null, "Normale Nachicht", 1));
		category.addAction(new ActionNachrichtAusgeben(null, "PopUp Nachricht", 2));

		return category;
	}
	
	
	
	private NMAction getSubMenuActionsPaint()
	{
		ActionsCategory category = new ActionsCategory(null, "Zeichenfläche");
		
		category.setNested(true);
		category.addAction(new ActionZeichenflaecheAendern(null, "Größe ändern", 1));
		category.addAction(new ActionZeichenflaecheAendern(null, "Farbe ändern", 2));
		category.addAction(new ActionZeichenflaecheAendern(null, "schließen", 3));

		return category;
	}
	
	private NMAction getSubMenuActionsZeichenfläche()
	{
		ActionsCategory category = new ActionsCategory(null, "Farbig hervorheben");
		
		category.setNested(true);
		category.addAction(new ActionAussehenaendern(null, "Klassen ohne Attribute hervorheben", 0));
		category.addAction(new ActionAussehenaendern(null, "Aussehen Verbindung ändern", 9));

		return category;
	}
	

	
	@Override
	public boolean isSupported() 
	{
		return true;
	}
	

}
