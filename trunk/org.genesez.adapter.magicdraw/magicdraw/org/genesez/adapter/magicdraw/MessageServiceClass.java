package org.genesez.adapter.magicdraw;

import com.nomagic.magicdraw.ui.notification.Notification;
import com.nomagic.magicdraw.ui.notification.NotificationManager;

/**
 * Provides methods to output messages
 *
 */
@SuppressWarnings("deprecation")
public class MessageServiceClass extends NotificationManager
{
	public void showSimpleMessage(String text)
	{
		this.openNotificationWindow(new Notification(String.valueOf(System.currentTimeMillis()) , text), true);
	}
}
