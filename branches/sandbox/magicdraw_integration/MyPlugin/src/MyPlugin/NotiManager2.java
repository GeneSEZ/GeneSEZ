package MyPlugin;

import com.nomagic.magicdraw.ui.notification.Notification;
import com.nomagic.magicdraw.ui.notification.NotificationManager;

public class NotiManager2 extends NotificationManager
{
	public NotiManager2(String titel, String ss)
	{
		this.showNotification(new Notification("ID", titel));
	}
	
	
}
