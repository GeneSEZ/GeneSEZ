package MyPlugin;

import com.nomagic.magicdraw.core.Application;
import com.nomagic.magicdraw.ui.notification.Notification;
import com.nomagic.magicdraw.ui.notification.NotificationManager;
import com.nomagic.magicdraw.ui.notification.NotificationSeverity;
import com.nomagic.ui.SimpleBaseDialog;
import com.nomagic.ui.YesNoCancelDlg;

public class NotiManager extends NotificationManager
{
	public NotiManager(String titel, String ss)
	{
		this.openNotificationWindow(new Notification("ID", titel, ss), true);
		this.openNotificationWindow(new Notification("ID", titel, ss, NotificationSeverity.ERROR),true);
		
		SimpleBaseDialog dlg = new YesNoCancelDlg(Application.getInstance().getMainFrame(), "Fehler", true, "", true);

        Notification notification = new Notification("ID", titel, ss, NotificationSeverity.ERROR);
        
        Application.getInstance().getGUILog().showError("Fehler");

        this.getInstance().showNotification(notification, dlg);
        dlg.setVisible(true);
        
	}
	
	
}
