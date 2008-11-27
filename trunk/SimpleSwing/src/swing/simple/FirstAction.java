package swing.simple;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *	@author Georg Beier
 *  Die einfachste Art, eine eigene Applikation zu erzeugen ist,
 *	sie von JFrame abzuleiten.
 **/
public class FirstAction extends JFrame {
    // Hier werden Felder angelegt für Komponenten,
    // die in Ereignisroutinen verwendet werden sollen
    private JTextField aText;
    private JButton doitButton;
    
    // und weitere benötigte Felder
    private boolean reverse = false;
    
    /**
     *	der ganze Aufbau der Grafik kann direkt im Konstruktor erfolgen wie hier.
     *	Eleganter ist, dafür eine Initialisierungs-Methode zu verwenden, die im
     *	Konstruktor nur aufgerufen wird.
     **/
    public FirstAction() {
        // rufe Konstruktor der Superklasse auf (d.h. JFrame)
        super("Simple Action v1.0");
        // initiale Größe und Position des Fensters
        setLocation(400, 200);
        
        // lege die benötigten Komponenten an: Labels, Textfelder, Buttons
        doitButton = new JButton("drehs rum!");
        
        aText = new JTextField("hier kann Text eingegeben werden");
        
        // lege die benötigten Container an. der in der Container-Hierarchie
        // oberste Container wird vom this-Objekt geliefert (geerbt von JFrame)
        // die anderen werden neu angelegt
        Container content = getContentPane();
        Container buttonPane = new JPanel();
        Container maskPane = new JPanel();
        
        // die Container bekommen einen Layout-Manager, der sich um die
        // Position der enthaltenen Komponenten kümmert
        content.setLayout(new BorderLayout());
        buttonPane.setLayout(new FlowLayout());
        maskPane.setLayout(new GridLayout(0,1,10,16));
        
        // die Komponenten werden zu den Container hinzugefügt
        buttonPane.add(doitButton);
        
        maskPane.add(aText);
        
        // beim Hinzufügen können noch Layout-Informationen mitgegeben werden (SOUTH, ...)
        content.add(buttonPane, BorderLayout.SOUTH);
        content.add(maskPane, BorderLayout.CENTER);
        
        // der Button bekommt einen ActionListener, der auf den Knopfdruck reagiert
        doitButton.addActionListener(
        // ActionListener ist ein Interface mit der einzigen Methode actionPerformed()
        // Üblicherweise wird eine anonyme Subklasse gebildet und an den Button "gebunden",
        // die eine Methode zur Durchführung der Button-Aktion aufruft
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    reverseText(e);
                }
            }
        );
    }
    
    public static void main(String[] args) {
        // im mainprogramm wird der Frame erzeugt
        JFrame f = new FirstAction();
        // pack komprimiert den Frame so, dass alle Komponenten gerade gut hineinpassen
        // alternativ kann eine Framegröße mit setSize(...) angegeben werden.
        f.pack();
        // Frame anzeigen
        f.setVisible(true);
        // Das Window-Close Event abfangen und Programm damit beenden
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) { System.exit(0); }
        });
        
    }
    
    /**
     *  Diese Methode behandelt das Button-Ereignis. Die Ereignisbehandlung wird meist nicht
     *  in der Listener-Klasse implementiert, weil
     *      - häufig mehrere Ereignisse gleiche oder ähnliche Aktionen bewirken und deshalb 
     *        in der gleichen Methode behandelt werden sollen
     *      - Aktionen verschiedener Buttons in einer Methode zusammengefasst werden sollen
     *
     * @param e     Das mit dem Ereignis verbundene Event-Objekt enthält oft weitere Information,
     *              die in der Ereignismethode ausgewertet werden kann.
     */
    private void reverseText(ActionEvent e) {
        StringBuffer sb = new StringBuffer(aText.getText());
        sb.reverse();
        aText.setText(sb.toString());
        if(reverse) doitButton.setText("drehs rum!");
        else doitButton.setText("rums dreh!");
        reverse = ! reverse;
    }
}
