package de.genesez.platforms.java.umlsupport.associations;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class AssocManyTestAC {


	private LeftMany left1, left2, left3;
	private RightMany or1;
	private RightMany or2;
	private RightMany or3;
	Set<LeftMany> lefts;
	Set<RightMany> rels;

	@Before
	public void setUp() throws Exception {
		left1 = new LeftMany();
		left2 = new LeftMany();
		left3 = new LeftMany();
		or1 = new RightMany();
		or2 = new RightMany();
		or3 = new RightMany();
		lefts = new HashSet<LeftMany>();
		rels = new HashSet<RightMany>();
	}
	
	@Test
	public void insertTest() {
		Iterator<RightMany> it = left1.right().iterator();
		assertFalse("iterator should not have next", it.hasNext());
		assertNull("content not nulled", left1.right().get());
		left1.right().insert(or1);
		left1.right().insert(or2);
		left1.right().insert(or3);
		left1.right().insert(or3);
		left1.right().insert(or1);
		it = left1.right().iterator();
		assertTrue("iterator should have next", it.hasNext());
		for(RightMany r: left1.right()){
			rels.add(r);
		}
		assertTrue("related not in association", rels.contains(or1));
		assertTrue("related not in association", rels.contains(or2));
		assertTrue("related not in association", rels.contains(or3));
		assertEquals("wrong association size", 3, rels.size());
		assertEquals("internal inconsistency", it.next(), left1.right().get());
	}

	@Test
	public void removeTest() {
		assertNull("there should be nothing to remove", left1.right().remove(or1));
		left1.right().insert(or1);
		RightMany ot = left1.right().remove(or1);
		assertEquals("related not removed", or1, ot);
		Iterator<RightMany> it = left1.right().iterator();
		assertFalse("iterator should not have next", it.hasNext());
		assertNull("content not nulled", left1.right().get());
	}

	
	@Test
	public void insertTestSym() {
		Iterator<RightMany> it = left1.rightSym().iterator();
		assertFalse("iterator should not have next", it.hasNext());
		left1.rightSym().insert(or1);
		or2.leftSym().insert(left1);
		or3.leftSym().insert(left1);
		it = left1.rightSym().iterator();
		assertTrue("iterator should have next", it.hasNext());
		for(RightMany r: left1.rightSym()){
			rels.add(r);
		}
		assertTrue("related not in association", rels.contains(or1));
		assertTrue("related not in association", rels.contains(or2));
		assertTrue("related not in association", rels.contains(or3));
		assertEquals("wrong association size", 3, rels.size());

		Iterator<LeftMany> hit = or1.leftSym().iterator();
		assertTrue("iterator should have next", hit.hasNext());
		LeftMany tleft = hit.next();
		assertEquals("related not found backwards", left1, tleft);
	}

	@Test
	public void removeTestSym() {
		left1.rightSym().insert(or1);
		or2.leftSym().insert(left1);
		or3.leftSym().insert(left1);
		or1.leftSym().remove(left1);
		left1.rightSym().remove(or3);
		for(RightMany r: left1.rightSym()){
			rels.add(r);
		}
		assertFalse("related not removed from association", rels.contains(or1));
		assertFalse("related not removed from association", rels.contains(or3));
		assertTrue("related not in association", rels.contains(or2));
		assertFalse("not removed on one side", or3.leftSym().iterator().hasNext());

	}

	@Test
	public void replaceTestSym() {
		left1.rightSym().insert(or1);
		or2.leftSym().insert(left1);
		or3.leftSym().insert(left1);
		or1.leftSym().insert(left2);
		left2.rightSym().insert(or3);
		for(RightMany r: left1.rightSym()){
			rels.add(r);
		}
		assertFalse("related not replaced in association", rels.contains(or1));
		assertFalse("related not replaced in association", rels.contains(or3));
		assertTrue("related not in association", rels.contains(or2));
		
	}
	
	@Test
	public void manyManyAllTest() {
		left1.rightMany().insert(or1);
		left3.rightMany().insert(or3);
		or1.leftSymMany().insert(left2);
		or1.leftSymMany().insert(left3);
		for(RightMany r: left3.rightMany()){
			rels.add(r);
		}
		assertTrue("related not in association", rels.contains(or1));
		assertFalse("unrelated in association", rels.contains(or2));
		assertTrue("related not in association", rels.contains(or3));
		assertEquals("wrong association size", 2, rels.size());
		
	}

	@Test
	public void assocObjectTest() {
		or1.leftSym().insert(left1);
		Assoc a1 = new Assoc();
		Assoc a2 = new Assoc();
		or1.leftSym().setAssoc(left1, a1);
		assertEquals("association object was lost", a1, or1.leftSym().getAssoc(
				left1));
		assertEquals("association object was lost", a1, left1.rightSym().getAssoc(
				or1));
		assertNull("bad associated object was ignored", or1.leftSym().getAssoc(
				left2));
		or1.leftSym().setAssoc(left2, a2);
		assertEquals("association was messed up", a1, or1.leftSym().getAssoc(left1));
		or1.leftSym().insert(left2, a2);
		assertEquals("insert failed", a2, left2.rightSym().getAssoc(or1));
		assertEquals("insert failed", or1, left2.rightSym().get());
		assertEquals("insert failed", left2, or1.leftSym().get());
		assertEquals("insert failed", a2, or1.leftSym().getAssoc(left2));
		assertEquals("access from association class failed", a2
				.getAssociationClassLink().getAssociationEnd("leftSym"), left2);
		assertEquals("access from association class failed", a2
				.getAssociationClassLink().getAssociationEnd("rightSym"), or1);
		or1.leftSym().setAssoc(left2, a1);
		assertEquals("access from association class failed", a1
				.getAssociationClassLink().getAssociationEnd("leftSym"), left2);
		assertEquals("access from association class failed", a1
				.getAssociationClassLink().getAssociationEnd("rightSym"), or1);
		assertNull("association class link was not cleared", a2
				.getAssociationClassLink().getAssociationEnd("leftSym"));
		assertNull("association class link was not cleared", a2
				.getAssociationClassLink().getAssociationEnd("rightSym"));
		a1 = new Assoc();
		a2 = new Assoc();
		or2.leftSymMany().insert(left3, a1);
		assertEquals("insert failed", a1, or2.leftSymMany().getAssoc(left3));
		assertEquals("insert failed", a1, left3.rightMany().getAssoc(or2));
		or2.leftSymMany().insert(left3, a2);
		assertEquals("reinsert failed", a2, or2.leftSymMany().getAssoc(left3));
		assertEquals("reinsert failed", a2, left3.rightMany().getAssoc(or2));
		Assoc a3 = new Assoc();
		Assoc a4 = or2.leftSymMany().setAssoc(left1, a3);
		assertEquals("setAssoc with invalid other corrupted assoc", a2, left3.rightMany().getAssoc(or2));
		assertEquals("setAssoc with invalid other corrupted assoc", a2, or2.leftSymMany().getAssoc(left3));
		assertNull("setAssoc with invalid other failed", a4);
		a4 = or2.leftSymMany().setAssoc(left3, a3);
		assertEquals("setAssoc with valid other corrupted assoc", a3, a4);
		assertEquals("setAssoc with valid other failed", a3, or2.leftSymMany().getAssoc(left3));
		assertEquals("setAssoc with valid other failed", a3, left3.rightMany().getAssoc(or2));
	}
}
