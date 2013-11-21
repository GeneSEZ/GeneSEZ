package MyPlugin;

import com.nomagic.magicdraw.ui.notification.Notification;
import com.nomagic.magicdraw.ui.notification.NotificationManager;

public class MessageServiceClass extends NotificationManager
{
	public MessageServiceClass(String title, String text)
	{
		this.openNotificationWindow(new Notification(String.valueOf(System.currentTimeMillis()) , title, text), true);
	}
	
	public MessageServiceClass(String text)
	{
		this.openNotificationWindow(new Notification(String.valueOf(System.currentTimeMillis()) , text), true);
	}
}
