package de.genesez.platforms.java.umlsupport.associations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class AssocManyACTest {


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
		Iterator<RightMany> it = left1.getRight().iterator();
		assertFalse("iterator should not have next", it.hasNext());
		assertNull("content not nulled", left1.getRight().get());
		left1.getRight().insert(or1);
		left1.getRight().insert(or2);
		left1.getRight().insert(or3);
		left1.getRight().insert(or3);
		left1.getRight().insert(or1);
		it = left1.getRight().iterator();
		assertTrue("iterator should have next", it.hasNext());
		for(RightMany r: left1.getRight()){
			rels.add(r);
		}
		assertTrue("related not in association", rels.contains(or1));
		assertTrue("related not in association", rels.contains(or2));
		assertTrue("related not in association", rels.contains(or3));
		assertEquals("wrong association size", 3, rels.size());
		assertEquals("internal inconsistency", it.next(), left1.getRight().get());
	}

	@Test
	public void removeTest() {
		assertNull("there should be nothing to remove", left1.getRight().remove(or1));
		left1.getRight().insert(or1);
		RightMany ot = left1.getRight().remove(or1);
		assertEquals("related not removed", or1, ot);
		Iterator<RightMany> it = left1.getRight().iterator();
		assertFalse("iterator should not have next", it.hasNext());
		assertNull("content not nulled", left1.getRight().get());
	}

	
	@Test
	public void insertTestSym() {
		Iterator<RightMany> it = left1.getRightSym().iterator();
		assertFalse("iterator should not have next", it.hasNext());
		left1.getRightSym().insert(or1);
		or2.getLeftSym().insert(left1);
		or3.getLeftSym().insert(left1);
		it = left1.getRightSym().iterator();
		assertTrue("iterator should have next", it.hasNext());
		for(RightMany r: left1.getRightSym()){
			rels.add(r);
		}
		assertTrue("related not in association", rels.contains(or1));
		assertTrue("related not in association", rels.contains(or2));
		assertTrue("related not in association", rels.contains(or3));
		assertEquals("wrong association size", 3, rels.size());

		Iterator<LeftMany> hit = or1.getLeftSym().iterator();
		assertTrue("iterator should have next", hit.hasNext());
		LeftMany tleft = hit.next();
		assertEquals("related not found backwards", left1, tleft);
	}

	@Test
	public void removeTestSym() {
		left1.getRightSym().insert(or1);
		or2.getLeftSym().insert(left1);
		or3.getLeftSym().insert(left1);
		or1.getLeftSym().remove(left1);
		left1.getRightSym().remove(or3);
		for(RightMany r: left1.getRightSym()){
			rels.add(r);
		}
		assertFalse("related not removed from association", rels.contains(or1));
		assertFalse("related not removed from association", rels.contains(or3));
		assertTrue("related not in association", rels.contains(or2));
		assertFalse("not removed on one side", or3.getLeftSym().iterator().hasNext());

	}

	@Test
	public void replaceTestSym() {
		left1.getRightSym().insert(or1);
		or2.getLeftSym().insert(left1);
		or3.getLeftSym().insert(left1);
		or1.getLeftSym().insert(left2);
		left2.getRightSym().insert(or3);
		for(RightMany r: left1.getRightSym()){
			rels.add(r);
		}
		assertFalse("related not replaced in association", rels.contains(or1));
		assertFalse("related not replaced in association", rels.contains(or3));
		assertTrue("related not in association", rels.contains(or2));
		
	}
	
	@Test
	public void manyManyAllTest() {
		left1.getRightMany().insert(or1);
		left3.getRightMany().insert(or3);
		or1.getLeftSymMany().insert(left2);
		or1.getLeftSymMany().insert(left3);
		for(RightMany r: left3.getRightMany()){
			rels.add(r);
		}
		assertTrue("related not in association", rels.contains(or1));
		assertFalse("unrelated in association", rels.contains(or2));
		assertTrue("related not in association", rels.contains(or3));
		assertEquals("wrong association size", 2, rels.size());
		
	}

	@Test
	public void assocObjectTest() {
		or1.getLeftSym().insert(left1);
		Assoc a1 = new Assoc();
		Assoc a2 = new Assoc();
		or1.getLeftSym().setAssoc(left1, a1);
		assertEquals("association object was lost", a1, or1.getLeftSym().getAssoc(
				left1));
		assertEquals("association object was lost", a1, left1.getRightSym().getAssoc(
				or1));
		assertNull("bad associated object was ignored", or1.getLeftSym().getAssoc(
				left2));
		or1.getLeftSym().setAssoc(left2, a2);
		assertEquals("association was messed up", a1, or1.getLeftSym().getAssoc(left1));
		or1.getLeftSym().insert(left2, a2);
		assertEquals("insert failed", a2, left2.getRightSym().getAssoc(or1));
		assertEquals("insert failed", or1, left2.getRightSym().get());
		assertEquals("insert failed", left2, or1.getLeftSym().get());
		assertEquals("insert failed", a2, or1.getLeftSym().getAssoc(left2));
		assertEquals("access from association class failed", a2
				.getAssociationClassLink().getAssociationEnd(RightMany.Associations.LEFT_SYM), left2);
		assertEquals("access from association class failed", a2
				.getAssociationClassLink().getAssociationEnd(LeftMany.Associations.RIGHT_SYM), or1);
		or1.getLeftSym().setAssoc(left2, a1);
		assertEquals("access from association class failed", a1
				.getAssociationClassLink().getAssociationEnd(RightMany.Associations.LEFT_SYM), left2);
		assertEquals("access from association class failed", a1
				.getAssociationClassLink().getAssociationEnd(LeftMany.Associations.RIGHT_SYM), or1);
		assertNull("association class link was not cleared", a2
				.getAssociationClassLink().getAssociationEnd(RightMany.Associations.LEFT_SYM));
		assertNull("association class link was not cleared", a2
				.getAssociationClassLink().getAssociationEnd(LeftMany.Associations.RIGHT_SYM));
		a1 = new Assoc();
		a2 = new Assoc();
		or2.getLeftSymMany().insert(left3, a1);
		assertEquals("insert failed", a1, or2.getLeftSymMany().getAssoc(left3));
		assertEquals("insert failed", a1, left3.getRightMany().getAssoc(or2));
		or2.getLeftSymMany().insert(left3, a2);
		assertEquals("reinsert failed", a2, or2.getLeftSymMany().getAssoc(left3));
		assertEquals("reinsert failed", a2, left3.getRightMany().getAssoc(or2));
		Assoc a3 = new Assoc();
		Assoc a4 = or2.getLeftSymMany().setAssoc(left1, a3);
		assertEquals("setAssoc with invalid other corrupted assoc", a2, left3.getRightMany().getAssoc(or2));
		assertEquals("setAssoc with invalid other corrupted assoc", a2, or2.getLeftSymMany().getAssoc(left3));
		assertNull("setAssoc with invalid other failed", a4);
		a4 = or2.getLeftSymMany().setAssoc(left3, a3);
		assertEquals("setAssoc with valid other corrupted assoc", a3, a4);
		assertEquals("setAssoc with valid other failed", a3, or2.getLeftSymMany().getAssoc(left3));
		assertEquals("setAssoc with valid other failed", a3, left3.getRightMany().getAssoc(or2));
	}
}
