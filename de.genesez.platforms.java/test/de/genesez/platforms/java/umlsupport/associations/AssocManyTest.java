package de.genesez.platforms.java.umlsupport.associations;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class AssocManyTest {


	private Hub hub1, hub2, hub3;
	private Related or1;
	private Related or2;
	private Related or3;
	Set<Hub> hubs;
	Set<Related> rels;

	@Before
	public void setUp() throws Exception {
		hub1 = new Hub();
		hub2 = new Hub();
		hub3 = new Hub();
		or1 = new Related();
		or2 = new Related();
		or3 = new Related();
		hubs = new HashSet<Hub>();
		rels = new HashSet<Related>();
	}
	
	@Test
	public void insertTest() {
		Iterator<Related> it = hub1.m1().iterator();
		assertFalse("iterator should not have next", it.hasNext());
		assertNull("content not nulled", hub1.m1().get());
		hub1.m1().insert(or1);
		hub1.m1().insert(or2);
		hub1.m1().insert(or3);
		hub1.m1().insert(or3);
		hub1.m1().insert(or1);
		it = hub1.m1().iterator();
		assertTrue("iterator should have next", it.hasNext());
		for(Related r: hub1.m1()){
			rels.add(r);
		}
		assertTrue("related not in association", rels.contains(or1));
		assertTrue("related not in association", rels.contains(or2));
		assertTrue("related not in association", rels.contains(or3));
		assertEquals("wrong association size", 3, rels.size());
		assertEquals("internal inconsistency", it.next(), hub1.m1().get());
	}

	@Test
	public void removeTest() {
		assertNull("there should be nothing to remove", hub1.m1().remove(or1));
		hub1.m1().insert(or1);
		Related ot = hub1.m1().remove(or1);
		assertEquals("related not removed", or1, ot);
		Iterator<Related> it = hub1.m1().iterator();
		assertFalse("iterator should not have next", it.hasNext());
		assertNull("content not nulled", hub1.m1().get());
	}

	
	@Test
	public void insertTestSym() {
		Iterator<Related> it = hub1.m2one().iterator();
		assertFalse("iterator should not have next", it.hasNext());
		hub1.m2one().insert(or1);
		or2.hub2().insert(hub1);
		or3.hub2().insert(hub1);
		it = hub1.m2one().iterator();
		assertTrue("iterator should have next", it.hasNext());
		for(Related r: hub1.m2one()){
			rels.add(r);
		}
		assertTrue("related not in association", rels.contains(or1));
		assertTrue("related not in association", rels.contains(or2));
		assertTrue("related not in association", rels.contains(or3));
		assertEquals("wrong association size", 3, rels.size());

		Iterator<Hub> hit = or1.hub2().iterator();
		assertTrue("iterator should have next", hit.hasNext());
		Hub thub = hit.next();
		assertEquals("related not found backwards", hub1, thub);
	}

	@Test
	public void removeTestSym() {
		hub1.m2one().insert(or1);
		or2.hub2().insert(hub1);
		or3.hub2().insert(hub1);
		or1.hub2().remove(hub1);
		hub1.m2one().remove(or3);
		for(Related r: hub1.m2one()){
			rels.add(r);
		}
		assertFalse("related not removed from association", rels.contains(or1));
		assertFalse("related not removed from association", rels.contains(or3));
		assertTrue("related not in association", rels.contains(or2));
		assertFalse("not removed on one side", or3.hub2().iterator().hasNext());

	}

	@Test
	public void replaceTestSym() {
		hub1.m2one().insert(or1);
		or2.hub2().insert(hub1);
		or3.hub2().insert(hub1);
		or1.hub2().insert(hub2);
		hub2.m2one().insert(or3);
		for(Related r: hub1.m2one()){
			rels.add(r);
		}
		assertFalse("related not replaced in association", rels.contains(or1));
		assertFalse("related not replaced in association", rels.contains(or3));
		assertTrue("related not in association", rels.contains(or2));
		
	}
	
	@Test
	public void manyManyAllTest() {
		hub1.m2m().insert(or1);
		hub3.m2m().insert(or3);
		or1.hubs().insert(hub2);
		or1.hubs().insert(hub3);
		for(Related r: hub3.m2m()){
			rels.add(r);
		}
		assertTrue("related not in association", rels.contains(or1));
		assertFalse("unrelated in association", rels.contains(or2));
		assertTrue("related not in association", rels.contains(or3));
		assertEquals("wrong association size", 2, rels.size());
		
	}
/*	*/
}
