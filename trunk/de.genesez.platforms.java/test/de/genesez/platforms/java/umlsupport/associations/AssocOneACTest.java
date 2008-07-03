package de.genesez.platforms.java.umlsupport.associations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class AssocOneACTest {

	private LeftOne l1, l2;
	private RightOne r1, r2, r3;

	@Before
	public void setUp() throws Exception {
		l1 = new LeftOne();
		l2 = new LeftOne();
		r1 = new RightOne();
		r2 = new RightOne();
		r3 = new RightOne();
	}

	@Test
	public void insertTest() {
		Iterator<RightOne> it = l1.right().iterator();
		assertFalse("iterator should not have next", it.hasNext());
		l1.right().insert(r1);
		assertTrue("iterator should have next", it.hasNext());
		RightOne ot = it.next();
		assertEquals("RightOne not found", r1, ot);
		assertEquals("internal inconsistency", ot, l1.right().get());
		assertFalse("iterator should not have next", it.hasNext());
	}

	@Test
	public void removeTest() {
		assertNull("there should be nothing to remove", l1.right().remove(r1));
		l1.right().insert(r1);
		RightOne ot = l1.right().remove(r1);
		assertEquals("RightOne not removed", r1, ot);
		Iterator<RightOne> it = l1.right().iterator();
		assertFalse("iterator should not have next", it.hasNext());
		assertNull("internal reference not nulled", l1.right().get());
	}

	@Test
	public void replaceTest() {
		l1.right().insert(r1);
		RightOne ot = l1.right().insert(r2);
		assertEquals("RightOne not removed", r2, ot);
		Iterator<RightOne> it = l1.right().iterator();
		RightOne ot2 = it.next();
		assertEquals("RightOne not found", r2, ot2);
	}

	@Test
	public void insertTestSym() {
		Iterator<RightOne> it = l1.rightSym().iterator();
		assertFalse("iterator should not have next", it.hasNext());
		l1.rightSym().insert(r1);
		assertTrue("iterator should have next", it.hasNext());
		RightOne ot = it.next();
		assertEquals("RightOne not found", r1, ot);
		assertFalse("iterator should not have next", it.hasNext());
		Iterator<LeftOne> lit = r1.leftSym().iterator();
		assertTrue("iterator should have next", lit.hasNext());
		LeftOne tl = lit.next();
		assertEquals("RightOne not found backwards", l1, tl);
	}

	@Test
	public void removeTestSym() {
		assertNull("there should be nothing to remove", l1.rightSym()
				.remove(r1));
		l1.rightSym().insert(r1);
		RightOne ot = l1.rightSym().remove(r1);
		assertEquals("RightOne not removed", r1, ot);
		Iterator<RightOne> it = l1.rightSym().iterator();
		assertFalse("iterator should not have next", it.hasNext());
		Iterator<LeftOne> lit = r1.leftSym().iterator();
		assertFalse("iterator should not have next", lit.hasNext());
		l1.rightSym().insert(r3);
		r3.leftSym().remove(l1);
		it = l1.rightSym().iterator();
		assertFalse("iterator should not have next", it.hasNext());
	}

	@Test
	public void replaceTestSym() {
		r1.leftSym().insert(l1);
		RightOne ot = l1.rightSym().insert(r2);
		assertEquals("RightOne not removed", r2, ot);
		Iterator<RightOne> it = l1.rightSym().iterator();
		RightOne ot2 = it.next();
		assertEquals("RightOne not found", r2, ot2);
		ot2.leftSym().insert(l2);
		it = l1.rightSym().iterator();
		assertFalse("RightOne not removed", it.hasNext());

	}

	@Test
	public void assocObjectTest() {
		r1.leftSym().insert(l1);
		Assoc a1 = new Assoc();
		Assoc a2 = new Assoc();
		r1.leftSym().setAssoc(l1, a1);
		assertEquals("association object was lost", a1, r1.leftSym().getAssoc(
				l1));
		assertEquals("association object was lost", a1, l1.rightSym().getAssoc(
				r1));
		assertNull("bad associated object was ignored", r1.leftSym().getAssoc(
				l2));
		r1.leftSym().setAssoc(l2, a2);
		assertEquals("association was messed up", a1, r1.leftSym().getAssoc(l1));
		r1.leftSym().insert(l2, a2);
		assertEquals("insert failed", a2, l2.rightSym().getAssoc(r1));
		assertEquals("insert failed", r1, l2.rightSym().get());
		assertEquals("insert failed", l2, r1.leftSym().get());
		assertEquals("insert failed", a2, r1.leftSym().getAssoc(l2));
		assertEquals("access from association class failed", a2
				.getAssociationClassLink().getAssociationEnd("leftSym"), l2);
		assertEquals("access from association class failed", a2
				.getAssociationClassLink().getAssociationEnd("rightSym"), r1);
		r1.leftSym().setAssoc(l2, a1);
		assertEquals("access from association class failed", a1
				.getAssociationClassLink().getAssociationEnd("leftSym"), l2);
		assertEquals("access from association class failed", a1
				.getAssociationClassLink().getAssociationEnd("rightSym"), r1);
		assertNull("association class link was not cleared", a2
				.getAssociationClassLink().getAssociationEnd("leftSym"));
		assertNull("association class link was not cleared", a2
				.getAssociationClassLink().getAssociationEnd("rightSym"));

	}

	@Test(expected = RuntimeException.class)
	public void badNamedAssocTest() {
		Assoc a1 = new Assoc();
		l1.badName().insert(r1, a1);
		fail("equal role names should cause Exception");
	}

	@Test(expected = UnsupportedOperationException.class)
	public void oneIteratorDeleteTest() {
		l1.right().insert(r1);
		Iterator<RightOne> it = l1.right().iterator();
		assertTrue("iterator should have next", it.hasNext());
		it.remove();
		fail("Iterator should throw Exception");
	}

}
