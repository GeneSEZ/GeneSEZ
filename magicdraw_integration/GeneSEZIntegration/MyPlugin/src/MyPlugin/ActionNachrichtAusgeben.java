




package MyPlugin;

import java.awt.event.ActionEvent;

import com.nomagic.magicdraw.actions.MDAction;


public class ActionNachrichtAusgeben extends MDAction
{
	private int nachrichtenArt;
	
	public ActionNachrichtAusgeben(String id, String name, int nachrichtenArt)
	{
		super(id, name, null, null);
		this.nachrichtenArt = nachrichtenArt;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(nachrichtenArt == 1)
		{
			new NotiManager("Nachricht", "Inhalt der Nachricht");
		}
		else
		{
			new NotiManager2("PopUp-Nachricht", "Inhalt der Nachricht");
		}
	}
	
}
