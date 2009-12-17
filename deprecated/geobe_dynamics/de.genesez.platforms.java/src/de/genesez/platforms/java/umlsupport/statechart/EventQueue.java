/*
 * EventQueue.java
 *
 * Created on 8. Dezember 2004, 15:38
 */

package de.genesez.platforms.java.umlsupport.statechart;

import java.util.*;

/**
 * Singleton Implementierung einer Queue für Events. Events werden der Reihe
 * nach abgearbeitet. Events können auch mit Verzögerung verschickt werden, um
 * Timerfunktionalität zu ermöglichen. Nach Ablauf der Verzögerungszeit werden
 * diese Events auch in die Event-Queue eingereiht.
 * 
 * @author georg beier
 * @version $Revision: 1.2 $
 */
public class EventQueue {

	/**
	 * Die Singleton-Instanz der Event-Queue
	 */
	private static final EventQueue theQ = new EventQueue();

	/**
	 * Thread, in dem das Event Processing stattfindet
	 */
	private Thread processingThread = new Thread() {
		public void run() {
			process();
		}
	};

	/**
	 * Events werden in dieser Collection gespeichert
	 */
	private ArrayList<Event<?>> events = new ArrayList<Event<?>>();
	/**
	 * Timer für verzögerte Events werden in dieser Collection gespeichert
	 */
	private Set<Timer> timers = new HashSet<Timer>();
	/**
	 * Flag-Variable, die angibt, ob Event-Queue gerade abgearbeitet wird
	 */
	private boolean isProcessing = false;
	/**
	 * Abbruch-Flag für Event-Processing-Thread
	 */
	private boolean stopProcessing = false;

	/**
	 * list of error events
	 */
	private LinkedList<Event<?>> errorEvents = new LinkedList<Event<?>>();

	/**
	 * access error events
	 * 
	 * @return list of registered error events, i.e events that were not
	 *         expected
	 */
	public static Event<?> getLastErrorEvent() {
		synchronized (theQ) {
			return theQ.errorEvents.pollLast();
		}
	}

	/**
	 * löscht alle noch nicht in die Queue eingereihten verzögerten Events
	 */
	public static void cancelTimers() {
		synchronized (theQ) {
			while (!theQ.timers.isEmpty()) {
				theQ.timers.iterator().next().cancel();
			}
			theQ.timers.clear();
		}

	}

	/**
	 * wartet, bis die Queue leer ist
	 */
	public static void waitQEmpty() {
		boolean empty = false;
		synchronized (theQ) {
			empty = theQ.events.isEmpty();
			if (empty && ! theQ.isProcessing) {
				return;
			}
			try {
				theQ.wait(0);
			} catch (InterruptedException iex) {
				return;
			} catch (Exception ex) {
			}
		}
	}

	/**
	 * beendet Event-Processing
	 */
	public static void terminate() {
		theQ.stopProcessing = true;
	}

	/**
	 * setzt Event-Processing fort
	 */
	public static void resume() {
		theQ.stopProcessing = false;
	}

	/**
	 * Abfrage, ob Event-Processing angehalten
	 */
	public static boolean hasStoppedProcessing() {
		return theQ.stopProcessing;
	}

	/**
	 * reiht ein Event in die Event-Queue ein
	 * 
	 * @param ev
	 *            das gesendete Event
	 */
	protected static void queue(Event<?> ev) {
		if (theQ.stopProcessing)
			throw new RuntimeException("Event Queue terminated, last unexpected event was " +
					theQ.errorEvents.peekLast());
		theQ.put(ev);
	}

	/**
	 * reiht ein zurückgestelltes Event wieder in die Event-Queue ein
	 * 
	 * @param ev
	 *            das gesendete Event
	 */
	protected static void defer(Event<?> ev) {
		queue(ev);
	}

	/**
	 * Legt einen Timer für ein verzögertes Event an, das nach der
	 * Verzögerungszeit gesendet wird.
	 * 
	 * @param ev
	 *            das gesendete Event
	 * @param delay
	 *            Verzögerungszeit in msec
	 * @return das angelegte Timer-Objekt
	 */
	protected static Timer queueDelayed(Event<?> ev, long delay) {
		if (theQ.stopProcessing)
			throw new RuntimeException("Event Queue terminated");
		final Event<?> delayedEvent = ev;
		final Timer t = new Timer() {
			public void cancel() {
				synchronized (theQ) {
					theQ.timers.remove(this);
				}
				super.cancel();
			}
		};
		TimerTask tt = new TimerTask() {
			public void run() {
				queue(delayedEvent);
				synchronized (theQ) {
					theQ.timers.remove(t);
				}
			}
		};
		synchronized (theQ) {
			theQ.timers.add(t);
		}
		t.schedule(tt, delay);
		return t;
	}

	/**
	 * Konstruktor ist protected, um Erzeugung ausserhalb der Klasse zu
	 * verhindern
	 */
	protected EventQueue() {
		processingThread.start();
	}

	/**
	 * Event am Ende in Queue einstellen und ggf. Abarbeitung der Queue starten
	 * 
	 * @param ev
	 *            das Event
	 */
	private synchronized void put(Event<?> ev) {
		events.add(ev);
		if (!isProcessing) {
			notifyAll();
		}
	}

	/**
	 * Alle Events aus der Queue abarbeiten, bis die Queue leer ist.
	 */
	private void process() {
		Event<?> e;
		while (!stopProcessing) {
			e = null;
			synchronized (this) {
				if (!events.isEmpty()) {
					isProcessing = true;
					e = events.remove(0);
				}
			}
			try {
				if (e != null)
					e.deliver();
			} catch (RuntimeException rex) {
//				System.err.println("Exeption during event processing:\n" + rex);
				errorEvents.add(e);
				stopProcessing = true;
				// break;
				// throw rex;
			}
			synchronized (this) {
				if (events.isEmpty()) {
					isProcessing = false;
					notifyAll();
					 try {
					 wait(20);
					 } catch (InterruptedException ex) {
					 ex.printStackTrace();
					 }
				}
			}
		}
	}

	/**
	 * Abstrakte Klasse, die als Basisklasse für spezifische Events in den
	 * Anwendungsklassen mit State Machine verwendet werden soll.
	 */
	public static abstract class Event<EV> {

		/**
		 * Zielobjekt, an das das Event gesendet werden soll
		 */
		public abstract EventReceiver<EV> getReceiver();

		/**
		 * Eine identifizierende enum, mit der die Events in der Empfängerklasse
		 * einfach in einem <CODE>switch(event.getEventId())</CODE> Statement
		 * unterschieden werden können.
		 */
		protected EV eventId;

		/**
		 * initialisierender Konstruktor
		 * 
		 * @param id
		 *            eindeutige Event ID für den <U>Typ</U> des Events
		 */
		protected Event(EV id) {
			eventId = id;
		}

		/**
		 * Verschickt das Event asynchron, indem es in die Event-Queue
		 * eingereiht wird.
		 */
		public void send() {
			EventQueue.queue(this);
		}

		/**
		 * Stelle das Event zurück, indem es wieder am Anfang in die Event-Queue
		 * eingereiht wird.
		 */
		public void defer() {
			EventQueue.defer(this);
		}

		/**
		 * Verschickt das Event mit der angegebenen Verzögerungszeit. Das
		 * sendende Objekt kann eine Referenz auf das erzeugte Timer-Objekt
		 * speichern, damit es ggf. mit <CODE>cancel()</CODE> gelöscht werden
		 * kann. Dadurch kann das Event vor Zustellung abgefangen werden,
		 * beispielsweise wenn eine Timeout-Bedingung nicht mehr benötigt wird.
		 * 
		 * @param delay
		 *            Verzögerung in msec
		 * @return
		 */
		public Timer sendDelayed(int delay) {
			return EventQueue.queueDelayed(this, delay);
		}

		/**
		 * Stellt ein Event ohne Verwendung der Event-Queue sofort zu. Ist i.A.
		 * nur sinnvoll, wenn Sender und Empfänger das gleiche Objekt sind, d.h.
		 * wenn ein Objekt seine State Machine als Resultat einer
		 * Bedingungsprüfung in einen Folgezustand weiterschalten will.
		 */
		public void sendImmediate() {
			deliver();
		}

		/**
		 * Zugriff auf EventId
		 * 
		 * @return die ID
		 */
		public EV getEventId() {
			return eventId;
		}

		/**
		 * stellt das Event an den Empfänger zu
		 */
		protected void deliver() {
			getReceiver().takeEvent(this);
		}

		@Override
		public String toString() {
			return getClass().getSimpleName() + " -> " + 
				getReceiver().getClass().getSimpleName();
		}
	}
}
