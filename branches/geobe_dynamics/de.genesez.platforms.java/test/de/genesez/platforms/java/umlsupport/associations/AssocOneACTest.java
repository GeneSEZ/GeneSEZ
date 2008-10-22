package de.genesez.platforms.java.umlsupport.associations;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertNotNull;
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
		Iterator<RightOne> it = l1.getRight().iterator();
		assertFalse("iterator should not have next", it.hasNext());
		l1.getRight().insert(r1);
		assertTrue("iterator should have next", it.hasNext());
		RightOne ot = it.next();
		assertEquals("RightOne not found", r1, ot);
		assertEquals("internal inconsistency", ot, l1.getRight().get());
		assertFalse("iterator should not have next", it.hasNext());
	}

	@Test
	public void removeTest() {
		assertNull("there should be nothing to remove", l1.getRight().remove(r1));
		l1.getRight().insert(r1);
		RightOne ot = l1.getRight().remove(r1);
		assertEquals("RightOne not removed", r1, ot);
		Iterator<RightOne> it = l1.getRight().iterator();
		assertFalse("iterator should not have next", it.hasNext());
		assertNull("internal reference not nulled", l1.getRight().get());
	}

	@Test
	public void replaceTest() {
		l1.getRight().insert(r1);
		RightOne ot = l1.getRight().insert(r2);
		assertEquals("RightOne not removed", r2, ot);
		Iterator<RightOne> it = l1.getRight().iterator();
		RightOne ot2 = it.next();
		assertEquals("RightOne not found", r2, ot2);
	}

	@Test
	public void insertTestSym() {
		Iterator<RightOne> it = l1.getRightSym().iterator();
		assertFalse("iterator should not have next", it.hasNext());
		l1.getRightSym().insert(r1);
		assertTrue("iterator should have next", it.hasNext());
		RightOne ot = it.next();
		assertEquals("RightOne not found", r1, ot);
		assertFalse("iterator should not have next", it.hasNext());
		Iterator<LeftOne> lit = r1.getLeftSym().iterator();
		assertTrue("iterator should have next", lit.hasNext());
		LeftOne tl = lit.next();
		assertEquals("RightOne not found backwards", l1, tl);
	}

	@Test
	public void removeTestSym() {
		assertNull("there should be nothing to remove", l1.getRightSym()
				.remove(r1));
		l1.getRightSym().insert(r1);
		RightOne ot = l1.getRightSym().remove(r1);
		assertEquals("RightOne not removed", r1, ot);
		Iterator<RightOne> it = l1.getRightSym().iterator();
		assertFalse("iterator should not have next", it.hasNext());
		Iterator<LeftOne> lit = r1.getLeftSym().iterator();
		assertFalse("iterator should not have next", lit.hasNext());
		l1.getRightSym().insert(r3);
		r3.getLeftSym().remove(l1);
		it = l1.getRightSym().iterator();
		assertFalse("iterator should not have next", it.hasNext());
	}

	@Test
	public void replaceTestSym() {
		r1.getLeftSym().insert(l1);
		RightOne ot = l1.getRightSym().insert(r2);
		assertEquals("RightOne not removed", r2, ot);
		Iterator<RightOne> it = l1.getRightSym().iterator();
		RightOne ot2 = it.next();
		assertEquals("RightOne not found", r2, ot2);
		ot2.getLeftSym().insert(l2);
		it = l1.getRightSym().iterator();
		assertFalse("RightOne not removed", it.hasNext());

	}

	@Test
	public void assocObjectTest() {
		r1.getLeftSym().insert(l1);
		Assoc a1 = new Assoc();
		Assoc a2 = new Assoc();
		r1.getLeftSym().setAssoc(l1, a1);
		assertEquals("association object was lost", a1, r1.getLeftSym().getAssoc(
				l1));
		assertEquals("association object was lost", a1, l1.getRightSym().getAssoc(
				r1));
		assertNull("bad associated object was ignored", r1.getLeftSym().getAssoc(
				l2));
		r1.getLeftSym().setAssoc(l2, a2);
		assertEquals("association was messed up", a1, r1.getLeftSym().getAssoc(l1));
		r1.getLeftSym().insert(l2, a2);
		assertEquals("insert failed", a2, l2.getRightSym().getAssoc(r1));
		assertEquals("insert failed", r1, l2.getRightSym().get());
		assertEquals("insert failed", l2, r1.getLeftSym().get());
		assertEquals("insert failed", a2, r1.getLeftSym().getAssoc(l2));
		assertEquals("access from association class failed", a2
				.getAssociationClassLink().getAssociationEnd(RightOne.Associations.LEFT_SYM), l2);
		assertEquals("access from association class failed", a2
				.getAssociationClassLink().getAssociationEnd(LeftOne.Associations.RIGHT_SYM), r1);
		r1.getLeftSym().setAssoc(l2, a1);
		assertEquals("access from association class failed", a1
				.getAssociationClassLink().getAssociationEnd(RightOne.Associations.LEFT_SYM), l2);
		assertEquals("access from association class failed", a1
				.getAssociationClassLink().getAssociationEnd(LeftOne.Associations.RIGHT_SYM), r1);
		assertNull("association class link was not cleared", a2
				.getAssociationClassLink().getAssociationEnd(RightOne.Associations.LEFT_SYM));
		assertNull("association class link was not cleared", a2
				.getAssociationClassLink().getAssociationEnd(LeftOne.Associations.RIGHT_SYM));

	}

	@Test(expected = UnsupportedOperationException.class)
	public void oneIteratorDeleteTest() {
		l1.getRight().insert(r1);
		Iterator<RightOne> it = l1.getRight().iterator();
		assertTrue("iterator should have next", it.hasNext());
		it.remove();
		fail("Iterator should throw Exception");
	}
	
	@Test(expected = RuntimeException.class)
	public void badNamedAssocTest() {
		Assoc a1 = new Assoc();
		// using wrong enum literals to specify association should cause runtime exception
		l1.getBadName().insert(r1, a1);
		fail("wrong association role specified");
	}
}
