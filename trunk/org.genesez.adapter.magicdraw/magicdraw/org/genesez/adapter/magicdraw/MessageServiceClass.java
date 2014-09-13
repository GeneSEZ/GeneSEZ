package org.genesez.adapter.magicdraw;

import com.nomagic.magicdraw.ui.notification.Notification;
import com.nomagic.magicdraw.ui.notification.NotificationManager;
import com.nomagic.magicdraw.ui.notification.NotificationSeverity;
import com.nomagic.magicdraw.ui.notification.config.NotificationViewConfig;

/**
 * Provides methods to output messages
 *
 */
public class MessageServiceClass
{
	static final String NOTIFICATION_ID = "org.genesez.adapter.magicdraw.transformation";
	private NotificationManager manager = NotificationManager.getInstance();
	private boolean hasErrors = false;
	
	public void showError(String text)
	{
		hasErrors = true;
		Notification n = new Notification(NOTIFICATION_ID, null, text);
		n.setContext(Notification.Context.PROJECT);
		n.setSeverity(NotificationSeverity.ERROR);
		NotificationViewConfig evc = manager.getErrorConfig();
		evc.setExpirationTime(-1);
		manager.showNotification(n, evc);
	}
	
	public void transformationStarts() {
		hasErrors = false;
		manager.hideNotifications(NOTIFICATION_ID);
	}
	
	public void transformationError(Exception exception, String output) {
		Notification n = buildNotification(
				"GeneSEZ transformation aborted: " + exception.getMessage(), 
				"See workflow log for further details.", 
				output
		);
		n.setSeverity(NotificationSeverity.ERROR);
		NotificationViewConfig evc = manager.getErrorConfig();
		manager.showNotification(n, evc);
	}
	
	public void transformationFinishes(int exitCode, String workflowLog) {
		Notification n = buildNotification(
				"GeneSEZ transformation finished " + (exitCode == 0 ? "successfully" : "with errors"), 
				"See workflow log for further details.", 
				workflowLog
		);
		n.setSeverity(NotificationSeverity.INFO);
		NotificationViewConfig nvc = manager.getInfoConfig();
		manager.showNotification(n, nvc);
	}
	
	Notification buildNotification(String title, String text, String longText) {
		Notification n = new Notification(
				NOTIFICATION_ID, title, text, longText
		);
		n.setContext(Notification.Context.PROJECT);
		return n;
	}
}
