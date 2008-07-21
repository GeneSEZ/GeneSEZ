package de.genesez.platforms.java.umlsupport.associations.modified;

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
		Iterator<RightOne> it = l1.<Association<LeftOne, RightOne>>getAssociation(LeftOne.Associations.RIGHT).iterator();
		assertFalse("iterator should not have next", it.hasNext());
		l1.<Association<LeftOne, RightOne>>getAssociation(LeftOne.Associations.RIGHT).insert(r1);
		assertTrue("iterator should have next", it.hasNext());
		RightOne ot = it.next();
		assertEquals("RightOne not found", r1, ot);
		assertEquals("internal inconsistency", ot, l1.<Association<LeftOne, RightOne>>getAssociation(LeftOne.Associations.RIGHT).get());
		assertFalse("iterator should not have next", it.hasNext());
	}

	@Test
	public void removeTest() {
		assertNull("there should be nothing to remove", l1.<Association<LeftOne, RightOne>>getAssociation(LeftOne.Associations.RIGHT).remove(r1));
		l1.<Association<LeftOne, RightOne>>getAssociation(LeftOne.Associations.RIGHT).insert(r1);
		RightOne ot = l1.<Association<LeftOne, RightOne>>getAssociation(LeftOne.Associations.RIGHT).remove(r1);
		assertEquals("RightOne not removed", r1, ot);
		Iterator<RightOne> it = l1.<Association<LeftOne, RightOne>>getAssociation(LeftOne.Associations.RIGHT).iterator();
		assertFalse("iterator should not have next", it.hasNext());
		assertNull("internal reference not nulled", l1.<Association<LeftOne, RightOne>>getAssociation(LeftOne.Associations.RIGHT).get());
	}

	@Test
	public void replaceTest() {
		l1.<Association<LeftOne, RightOne>>getAssociation(LeftOne.Associations.RIGHT).insert(r1);
		RightOne ot = l1.<Association<LeftOne, RightOne>>getAssociation(LeftOne.Associations.RIGHT).insert(r2);
		assertEquals("RightOne not removed", r2, ot);
		Iterator<RightOne> it = l1.<Association<LeftOne, RightOne>>getAssociation(LeftOne.Associations.RIGHT).iterator();
		RightOne ot2 = it.next();
		assertEquals("RightOne not found", r2, ot2);
	}

	@Test
	public void insertTestSym() {
		Iterator<RightOne> it = l1.<Association<LeftOne, RightOne>>getAssociation(LeftOne.Associations.RIGHT_SYM).iterator();
		assertFalse("iterator should not have next", it.hasNext());
		l1.<Association<LeftOne, RightOne>>getAssociation(LeftOne.Associations.RIGHT_SYM).insert(r1);
		assertTrue("iterator should have next", it.hasNext());
		RightOne ot = it.next();
		assertEquals("RightOne not found", r1, ot);
		assertFalse("iterator should not have next", it.hasNext());
		Iterator<LeftOne> lit = r1.<Association<RightOne, LeftOne>>getAssociation(RightOne.Associations.LEFT_SYM).iterator();
		assertTrue("iterator should have next", lit.hasNext());
		LeftOne tl = lit.next();
		assertEquals("RightOne not found backwards", l1, tl);
	}

	@Test
	public void removeTestSym() {
		assertNull("there should be nothing to remove", l1.<Association<LeftOne, RightOne>>getAssociation(LeftOne.Associations.RIGHT_SYM)
				.remove(r1));
		l1.<Association<LeftOne, RightOne>>getAssociation(LeftOne.Associations.RIGHT_SYM).insert(r1);
		RightOne ot = l1.<Association<LeftOne, RightOne>>getAssociation(LeftOne.Associations.RIGHT_SYM).remove(r1);
		assertEquals("RightOne not removed", r1, ot);
		Iterator<RightOne> it = l1.<Association<LeftOne, RightOne>>getAssociation(LeftOne.Associations.RIGHT_SYM).iterator();
		assertFalse("iterator should not have next", it.hasNext());
		Iterator<LeftOne> lit = r1.<Association<RightOne, LeftOne>>getAssociation(RightOne.Associations.LEFT_SYM).iterator();
		assertFalse("iterator should not have next", lit.hasNext());
		l1.<Association<LeftOne, RightOne>>getAssociation(LeftOne.Associations.RIGHT_SYM).insert(r3);
		r3.<Association<RightOne, LeftOne>>getAssociation(RightOne.Associations.LEFT_SYM).remove(l1);
		it = l1.<Association<LeftOne, RightOne>>getAssociation(LeftOne.Associations.RIGHT_SYM).iterator();
		assertFalse("iterator should not have next", it.hasNext());
	}

	@Test
	public void replaceTestSym() {
		r1.<Association<RightOne, LeftOne>>getAssociation(RightOne.Associations.LEFT_SYM).insert(l1);
		RightOne ot = l1.<Association<LeftOne, RightOne>>getAssociation(LeftOne.Associations.RIGHT_SYM).insert(r2);
		assertEquals("RightOne not removed", r2, ot);
		Iterator<RightOne> it = l1.<Association<LeftOne, RightOne>>getAssociation(LeftOne.Associations.RIGHT_SYM).iterator();
		RightOne ot2 = it.next();
		assertEquals("RightOne not found", r2, ot2);
		ot2.<Association<RightOne, LeftOne>>getAssociation(RightOne.Associations.LEFT_SYM).insert(l2);
		it = l1.<Association<LeftOne, RightOne>>getAssociation(LeftOne.Associations.RIGHT_SYM).iterator();
		assertFalse("RightOne not removed", it.hasNext());

	}

	@Test
	public void assocObjectTest() {
		r1.<Association<RightOne, LeftOne>>getAssociation(RightOne.Associations.LEFT_SYM).insert(l1);
		Assoc a1 = new Assoc();
		Assoc a2 = new Assoc();
		r1.<AssociationAC<RightOne, LeftOne, Assoc>>getAssociation(RightOne.Associations.LEFT_SYM).setAssoc(l1, a1);
		assertEquals("association object was lost", a1, r1.<AssociationAC<RightOne, LeftOne, Assoc>>getAssociation(RightOne.Associations.LEFT_SYM).getAssoc(
				l1));
		assertEquals("association object was lost", a1, l1.<AssociationAC<LeftOne, RightOne, Assoc>>getAssociation(LeftOne.Associations.RIGHT_SYM).getAssoc(
				r1));
		assertNull("bad associated object was ignored", r1.<AssociationAC<RightOne, LeftOne, Assoc>>getAssociation(RightOne.Associations.LEFT_SYM).getAssoc(
				l2));
		r1.<AssociationAC<RightOne, LeftOne, Assoc>>getAssociation(RightOne.Associations.LEFT_SYM).setAssoc(l2, a2);
		assertEquals("association was messed up", a1, r1.<AssociationAC<RightOne, LeftOne, Assoc>>getAssociation(RightOne.Associations.LEFT_SYM).getAssoc(l1));
		r1.<AssociationAC<RightOne, LeftOne, Assoc>>getAssociation(RightOne.Associations.LEFT_SYM).insert(l2, a2);
		assertEquals("insert failed", a2, l2.<AssociationAC<LeftOne, RightOne, Assoc>>getAssociation(LeftOne.Associations.RIGHT_SYM).getAssoc(r1));
		assertEquals("insert failed", r1, l2.<Association<LeftOne, RightOne>>getAssociation(LeftOne.Associations.RIGHT_SYM).get());
		assertEquals("insert failed", l2, r1.<Association<RightOne, LeftOne>>getAssociation(RightOne.Associations.LEFT_SYM).get());
		assertEquals("insert failed", a2, r1.<AssociationAC<RightOne, LeftOne, Assoc>>getAssociation(RightOne.Associations.LEFT_SYM).getAssoc(l2));
		assertEquals("access from association class failed", a2
				.getAssociationClassLink().getAssociationEnd(RightOne.Associations.LEFT_SYM), l2);
		assertEquals("access from association class failed", a2
				.getAssociationClassLink().getAssociationEnd(LeftOne.Associations.RIGHT_SYM), r1);
		r1.<AssociationAC<RightOne, LeftOne, Assoc>>getAssociation(RightOne.Associations.LEFT_SYM).setAssoc(l2, a1);
		assertEquals("access from association class failed", a1
				.getAssociationClassLink().getAssociationEnd(RightOne.Associations.LEFT_SYM), l2);
		assertEquals("access from association class failed", a1
				.getAssociationClassLink().getAssociationEnd(LeftOne.Associations.RIGHT_SYM), r1);
		assertNull("association class link was not cleared", a2
				.getAssociationClassLink().getAssociationEnd(RightOne.Associations.LEFT_SYM));
		assertNull("association class link was not cleared", a2
				.getAssociationClassLink().getAssociationEnd(LeftOne.Associations.RIGHT_SYM));

	}

//	@Test(expected = RuntimeException.class)
//	public void badNamedAssocTest() {
//		Assoc a1 = new Assoc();
//		l1.<AssociationAC<LeftOne, RightOne, Assoc>>getAssociation(LeftOne.Associations.BAD_NAME).insert(r1, a1);
//		fail("equal role names should cause Exception");
//	}

	@Test(expected = UnsupportedOperationException.class)
	public void oneIteratorDeleteTest() {
		l1.<Association<LeftOne, RightOne>>getAssociation(LeftOne.Associations.RIGHT).insert(r1);
		Iterator<RightOne> it = l1.<Association<LeftOne, RightOne>>getAssociation(LeftOne.Associations.RIGHT).iterator();
		assertTrue("iterator should have next", it.hasNext());
		it.remove();
		fail("Iterator should throw Exception");
	}
}
