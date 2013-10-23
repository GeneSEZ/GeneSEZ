package MyPlugin;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import com.nomagic.actions.NMAction;
import com.nomagic.magicdraw.actions.MDAction;
import com.nomagic.magicdraw.ui.dialogs.MDDialogParentProvider;


public class TextAusgeben extends MDAction
{
    public TextAusgeben(String id, String name, KeyStroke stroke, String group)
    {
        super(id, name, stroke, group);
    }

    
    public void actionPerformed(ActionEvent e)
    {
        JOptionPane.showMessageDialog(MDDialogParentProvider.getProvider().getDialogParent(), "This is:"+getName());
    }

}
