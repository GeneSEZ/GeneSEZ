package org.genesez.platform.java.umlsupport.associations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.genesez.platform.java.umlsupport.associations.Association;
import org.junit.Before;
import org.junit.Test;

public class AssocOneTest {

	private Hub hub1;
	private Related or1;
	private Related or2;
	private Related or3;
	private RelatedWithoutAssociation rwoa;

	@Before
	public void setUp() throws Exception {
		hub1 = new Hub();
		or1 = new Related();
		or2 = new Related();
		or3 = new Related();
		rwoa = new RelatedWithoutAssociation();
	}

	@Test
	public void insertTest() {
//		Iterator<Related> it = hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.UNI_TO_ONE).iterator();
		Iterator<Related> it = hub1.getUniToOne().iterator();
		assertFalse("iterator should not have next", it.hasNext());
//		hub1.<Association<Hub, Related>>getAssociation(Hub.Associations.UNI_TO_ONE).insert(or1);
		hub1.getUniToOne().insert(or1);
		assertTrue("iterator should have next", it.hasNext());
		Related ot = it.next();
		assertEquals("related not found", or1, ot);
		assertEquals("internal inconsistency", ot, hub1.getUniToOne().get());
		assertFalse("iterator should not have next", it.hasNext());
	}

	@Test
	public void removeTest() {
		assertNull("there should be nothing to remove", hub1.getUniToOne()
				.remove(or1));
		hub1.getUniToOne().insert(or1);
		Related ot = hub1.getUniToOne().remove(or1);
		assertEquals("related not removed", or1, ot);
		Iterator<Related> it = hub1.getUniToOne().iterator();
		assertFalse("iterator should not have next", it.hasNext());
		assertNull("internal reference not nulled", hub1.getUniToOne().get());
	}

	@Test
	public void replaceTest() {
		hub1.getUniToOne().insert(or1);
		Related ot = hub1.getUniToOne().insert(or2);
		assertEquals("related not removed", or2, ot);
		Iterator<Related> it = hub1.getUniToOne().iterator();
		Related ot2 = it.next();
		assertEquals("related not found", or2, ot2);
	}

	@Test
	public void insertTestSym() {
		Iterator<Related> it = hub1.getBidiOneToOne().iterator();
		assertFalse("iterator should not have next", it.hasNext());
		hub1.getBidiOneToOne().insert(or1);
		assertTrue("iterator should have next", it.hasNext());
		Related ot = it.next();
		assertEquals("related not found", or1, ot);
		assertFalse("iterator should not have next", it.hasNext());
		Iterator<Hub> hit = or1.getBidiOneToOne().iterator();
		assertTrue("iterator should have next", hit.hasNext());
		Hub thub = hit.next();
		assertEquals("related not found backwards", hub1, thub);
	}

	@Test
	public void removeTestSym() {
		assertNull("there should be nothing to remove", hub1.getBidiOneToOne()
				.remove(or1));
		hub1.getBidiOneToOne().insert(or1);
		Related ot = hub1.getBidiOneToOne().remove(or1);
		assertEquals("related not removed", or1, ot);
		Iterator<Related> it = hub1.getBidiOneToOne().iterator();
		assertFalse("iterator should not have next", it.hasNext());
		hub1.getBidiOneToOne().insert(or3);
		or3.getBidiOneToOne().remove(hub1);
		it = hub1.getBidiOneToOne().iterator();
		assertFalse("iterator should not have next", it.hasNext());
	}

	@Test
	public void replaceTestSym() {
		or1.getBidiOneToOne().insert(hub1);
		Related ot = hub1.getBidiOneToOne().insert(or2);
		assertEquals("related not removed", or2, ot);
		Iterator<Related> it = hub1.getBidiOneToOne().iterator();
		Related ot2 = it.next();
		assertEquals("related not found", or2, ot2);
		Hub hub2 = new Hub();
		ot2.getBidiOneToOne().insert(hub2);
		it = hub1.getBidiOneToOne().iterator();
		assertFalse("related not removed", it.hasNext());
	}

	@Test(expected = UnsupportedOperationException.class)
	public void oneIteratorDeleteTest() {
		hub1.getBidiOneToOne().insert(or1);
		Iterator<Related> it = hub1.getBidiOneToOne().iterator();
		assertTrue("iterator should have next", it.hasNext());
		it.remove();
		fail("Iterator should throw Exception");
	}

	@Test(expected = NoSuchElementException.class)
	public void oneIteratorAgainTest() {
		hub1.getBidiOneToOne().insert(or1);
		Iterator<Related> it = hub1.getBidiOneToOne().iterator();
		assertTrue("iterator should have next", it.hasNext());
		it.next();
		it.next();
	}
	
	@Test
	public void getAllTest() {
		hub1.getUniToOne().insert(or1);
		Collection<Related> associated = hub1.getUniToOne().getAll();
		assertEquals("collection should contain 1 associated object", 1, associated.size());
		assertTrue("collection should contain the inserted object", associated.contains(or1));
	}

	@Test(expected = RuntimeException.class)
	public void wrongAssociationRoleSpecified() {
		// use generic accessor method to access association
//		Association<Hub, Related> association = hub1.getUniToOne();
		Association<? extends Object, ? extends Object> association = hub1.getAssociation(Hub.Associations.UNI_TO_ONE);
		Association<Hub, Related> works = (Association<Hub, Related>)association;
		assertNotNull("generic association getter should work", association);
		// use generic accessor with wrong association literal
//		association = hub1.getBidiOneToOne();
		association = hub1.getAssociation(Related.Associations.BIDI_ONE_TO_ONE);
		Association<Hub, Related> dontWorks = (Association<Hub, Related>)association;
		fail("association roles from other classes should cause exceptions");
	}
	
	@Test(expected = RuntimeException.class)
	public void unidirectionalAsBidirectionalDeclared() {
		hub1.getUniToRelatedWoAssociations().insert(rwoa);
		fail("association is unidirectional, not bidirectional");
	}
}
