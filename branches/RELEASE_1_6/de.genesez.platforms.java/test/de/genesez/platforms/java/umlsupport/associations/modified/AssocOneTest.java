package de.genesez.platforms.java.umlsupport.associations.modified;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

public class AssocOneTest {

	private Hub hub1;
	private Related or1;
	private Related or2;
	private Related or3;

	@Before
	public void setUp() throws Exception {
		hub1 = new Hub();
		or1 = new Related();
		or2 = new Related();
		or3 = new Related();
	}

	@Test
	public void insertTest() {
		Iterator<Related> it = hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.UNI_TO_ONE).iterator();
		assertFalse("iterator should not have next", it.hasNext());
		hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.UNI_TO_ONE).insert(or1);
		assertTrue("iterator should have next", it.hasNext());
		Related ot = it.next();
		assertEquals("related not found", or1, ot);
		assertEquals("internal inconsistency", ot, hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.UNI_TO_ONE).get());
		assertFalse("iterator should not have next", it.hasNext());
	}

	@Test
	public void removeTest() {
		assertNull("there should be nothing to remove", hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.UNI_TO_ONE)
				.remove(or1));
		hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.UNI_TO_ONE).insert(or1);
		Related ot = hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.UNI_TO_ONE).remove(or1);
		assertEquals("related not removed", or1, ot);
		Iterator<Related> it = hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.UNI_TO_ONE).iterator();
		assertFalse("iterator should not have next", it.hasNext());
		assertNull("internal reference not nulled", hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.UNI_TO_ONE).get());
	}

	@Test
	public void replaceTest() {
		hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.UNI_TO_ONE).insert(or1);
		Related ot = hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.UNI_TO_ONE).insert(or2);
		assertEquals("related not removed", or2, ot);
		Iterator<Related> it = hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.UNI_TO_ONE).iterator();
		Related ot2 = it.next();
		assertEquals("related not found", or2, ot2);
	}

	@Test
	public void insertTestSym() {
		Iterator<Related> it = hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.BIDI_ONE_TO_ONE).iterator();
		assertFalse("iterator should not have next", it.hasNext());
		hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.BIDI_ONE_TO_ONE).insert(or1);
		assertTrue("iterator should have next", it.hasNext());
		Related ot = it.next();
		assertEquals("related not found", or1, ot);
		assertFalse("iterator should not have next", it.hasNext());
		Iterator<Hub> hit = or1.<Association<Related, Hub>>getAssociation(Related.Associations.BIDI_ONE_TO_ONE).iterator();
		assertTrue("iterator should have next", hit.hasNext());
		Hub thub = hit.next();
		assertEquals("related not found backwards", hub1, thub);
	}

	@Test
	public void removeTestSym() {
		assertNull("there should be nothing to remove", hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.BIDI_ONE_TO_ONE)
				.remove(or1));
		hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.BIDI_ONE_TO_ONE).insert(or1);
		Related ot = hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.BIDI_ONE_TO_ONE).remove(or1);
		assertEquals("related not removed", or1, ot);
		Iterator<Related> it = hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.BIDI_ONE_TO_ONE).iterator();
		assertFalse("iterator should not have next", it.hasNext());
		hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.BIDI_ONE_TO_ONE).insert(or3);
		or3.<Association<Related, Hub>>getAssociation(Related.Associations.BIDI_ONE_TO_ONE).remove(hub1);
		it = hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.BIDI_ONE_TO_ONE).iterator();
		assertFalse("iterator should not have next", it.hasNext());
	}

	@Test
	public void replaceTestSym() {
		or1.<Association<Related, Hub>>getAssociation(Related.Associations.BIDI_ONE_TO_ONE).insert(hub1);
		Related ot = hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.BIDI_ONE_TO_ONE).insert(or2);
		assertEquals("related not removed", or2, ot);
		Iterator<Related> it = hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.BIDI_ONE_TO_ONE).iterator();
		Related ot2 = it.next();
		assertEquals("related not found", or2, ot2);
		Hub hub2 = new Hub();
		ot2.<Association<Related, Hub>>getAssociation(Related.Associations.BIDI_ONE_TO_ONE).insert(hub2);
		it = hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.BIDI_ONE_TO_ONE).iterator();
		assertFalse("related not removed", it.hasNext());
	}

	@Test(expected = UnsupportedOperationException.class)
	public void oneIteratorDeleteTest() {
		hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.BIDI_ONE_TO_ONE).insert(or1);
		Iterator<Related> it = hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.BIDI_ONE_TO_ONE).iterator();
		assertTrue("iterator should have next", it.hasNext());
		it.remove();
		fail("Iterator should throw Exception");
	}

	@Test(expected = NoSuchElementException.class)
	public void oneIteratorAgainTest() {
		hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.BIDI_ONE_TO_ONE).insert(or1);
		Iterator<Related> it = hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.BIDI_ONE_TO_ONE).iterator();
		assertTrue("iterator should have next", it.hasNext());
		it.next();
		it.next();
	}

//	@Test(expected = RuntimeException.class)
//	public void misspelledAssociationGetterTest() {
//		new ManyAssociation<Association<Hub, Related>>(
//				hub1, new HashSet<Related>(), "getToSchnubs");
//	}

}
