package association.simple;

import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimpleAssociationTest {
	
	Hub hub = null;
	Hub otherHub = null;
	Related related = null;
	Related otherRelated = null;
	Related theEx = null;
	
	@Before
	public void setUp() throws Exception {
		hub = new Hub();
		otherHub = new Hub();
		related = new Related();
		otherRelated = new Related();
		theEx = new Related();
	}
	
	@Test
	public void testUnidirectionalToOne() {
		Assert.assertNull( hub.getUnidirectionalToOne() );
		hub.setUnidirectionalToOne(related);
		Assert.assertNotNull( hub.getUnidirectionalToOne() );
		Assert.assertSame( related, hub.getUnidirectionalToOne() );
		
		hub.setUnidirectionalToOne(null);
		Assert.assertNull( hub.getUnidirectionalToOne() );
	}
	
	@Test
	public void testUnidirectionalToMany() {
		Set<Related> linked = hub.getUnidirectionalToMany();
		Assert.assertEquals( 0, linked.size() );
		hub.addUnidirectionalToMany(related);
		hub.addUnidirectionalToMany(otherRelated);
		Assert.assertEquals( 2, linked.size() );
		Assert.assertTrue( linked.contains(related) );
		Assert.assertTrue( linked.contains(otherRelated) );
		
		hub.removeUnidirectionalToMany(otherRelated);
		Assert.assertEquals( 1, linked.size() );
		Assert.assertTrue( linked.contains(related) );
		Assert.assertFalse( linked.contains(otherRelated) );
	}
	
	@Test
	public void testBidiOneToOne() {
		Assert.assertNull( hub.getBidiOneToOne() );
		Assert.assertNull( related.getBidiOneToOne() );
		hub.setBidiOneToOne(related);
		Assert.assertNotNull( hub.getBidiOneToOne() );
		Assert.assertNotNull( related.getBidiOneToOne() );
		Assert.assertSame(related, hub.getBidiOneToOne() );
		Assert.assertSame(hub, related.getBidiOneToOne() );
		
		hub.setBidiOneToOne(null);
		Assert.assertNull( hub.getBidiOneToOne() );
		Assert.assertNull( related.getBidiOneToOne() );
	}
	
	@Test
	public void testBidiOneToOneWithEx() {
		Assert.assertNull( hub.getBidiOneToOne() );
		Assert.assertNull( related.getBidiOneToOne() );
		Assert.assertNull( theEx.getBidiOneToOne() );
		theEx.setBidiOneToOne(hub);
		Assert.assertNull( related.getBidiOneToOne() );
		Assert.assertNotNull( hub.getBidiOneToOne() );
		Assert.assertNotNull( theEx.getBidiOneToOne() );
		Assert.assertSame(theEx, hub.getBidiOneToOne() );
		Assert.assertSame(hub, theEx.getBidiOneToOne() );
		hub.setBidiOneToOne(related);
		Assert.assertNull( theEx.getBidiOneToOne() );
		Assert.assertNotNull( hub.getBidiOneToOne() );
		Assert.assertNotNull( related.getBidiOneToOne() );
		Assert.assertSame(related, hub.getBidiOneToOne() );
		Assert.assertSame(hub, related.getBidiOneToOne() );
		
		related.setBidiOneToOne(null);
		Assert.assertNull( hub.getBidiOneToOne() );
		Assert.assertNull( related.getBidiOneToOne() );
		Assert.assertNull( theEx.getBidiOneToOne() );
	}
	
	@Test
	public void testBidiManyToMany() {
		Assert.assertEquals( 0, hub.getBidiManyToMany().size() );
		Assert.assertEquals( 0, related.getBidiManyToMany().size() );
		Assert.assertEquals( 0, otherHub.getBidiManyToMany().size() );
		Assert.assertEquals( 0, otherRelated.getBidiManyToMany().size() );
		hub.addBidiManyToMany(related);
		Assert.assertEquals( 1, hub.getBidiManyToMany().size() );
		Assert.assertEquals( 1, related.getBidiManyToMany().size() );
		Assert.assertEquals( 0, otherHub.getBidiManyToMany().size() );
		Assert.assertEquals( 0, otherRelated.getBidiManyToMany().size() );
		Assert.assertTrue( hub.getBidiManyToMany().contains(related) );
		Assert.assertTrue( related.getBidiManyToMany().contains(hub) );
		hub.addBidiManyToMany(otherRelated);
		Assert.assertEquals( 2, hub.getBidiManyToMany().size() );
		Assert.assertEquals( 1, related.getBidiManyToMany().size() );
		Assert.assertEquals( 0, otherHub.getBidiManyToMany().size() );
		Assert.assertEquals( 1, otherRelated.getBidiManyToMany().size() );
		Assert.assertTrue( hub.getBidiManyToMany().contains(related) );
		Assert.assertTrue( hub.getBidiManyToMany().contains(otherRelated) );
		Assert.assertTrue( related.getBidiManyToMany().contains(hub) );
		Assert.assertTrue( otherRelated.getBidiManyToMany().contains(hub) );
		related.addBidiManyToMany(otherHub);
		Assert.assertEquals( 2, hub.getBidiManyToMany().size() );
		Assert.assertEquals( 2, related.getBidiManyToMany().size() );
		Assert.assertEquals( 1, otherHub.getBidiManyToMany().size() );
		Assert.assertEquals( 1, otherRelated.getBidiManyToMany().size() );
		Assert.assertTrue( hub.getBidiManyToMany().contains(related) );
		Assert.assertTrue( hub.getBidiManyToMany().contains(otherRelated) );
		Assert.assertTrue( related.getBidiManyToMany().contains(hub) );
		Assert.assertTrue( related.getBidiManyToMany().contains(otherHub) );
		Assert.assertTrue( otherHub.getBidiManyToMany().contains(related) );
		Assert.assertTrue( otherRelated.getBidiManyToMany().contains(hub) );
		
		related.removeBidiManyToMany(hub);
		Assert.assertEquals( 1, hub.getBidiManyToMany().size() );
		Assert.assertEquals( 1, related.getBidiManyToMany().size() );
		Assert.assertEquals( 1, otherHub.getBidiManyToMany().size() );
		Assert.assertEquals( 1, otherRelated.getBidiManyToMany().size() );
		Assert.assertFalse( hub.getBidiManyToMany().contains(related) );
		Assert.assertTrue( hub.getBidiManyToMany().contains(otherRelated) );
		Assert.assertFalse( related.getBidiManyToMany().contains(hub) );
		Assert.assertTrue( related.getBidiManyToMany().contains(otherHub) );
		Assert.assertTrue( otherHub.getBidiManyToMany().contains(related) );
		Assert.assertTrue( otherRelated.getBidiManyToMany().contains(hub) );
	}
	
	@Test
	public void testUnidirectionalSelfrefToOne() {
		Assert.assertNull( hub.getUnidirectionalSelfrefToOne() );
		Assert.assertNull( otherHub.getUnidirectionalSelfrefToOne() );
		hub.setUnidirectionalSelfrefToOne(otherHub);
		Assert.assertSame( otherHub, hub.getUnidirectionalSelfrefToOne() );
		Assert.assertNull( otherHub.getUnidirectionalSelfrefToOne() );
		
		hub.setUnidirectionalSelfrefToOne(null);
		Assert.assertNull( hub.getUnidirectionalSelfrefToOne() );
		Assert.assertNull( otherHub.getUnidirectionalSelfrefToOne() );
	}
	
	@Test
	public void testBidiSelfrefOneToMany() {
		Assert.assertEquals( 0, related.getBidiSelfrefOneToMany().size() );
		Assert.assertEquals( 0, otherRelated.getBidiSelfrefOneToMany().size() );
		Assert.assertEquals( 0, theEx.getBidiSelfrefOneToMany().size() );
		Assert.assertNull( related.getBidiSelfrefManyToOne() );
		Assert.assertNull( otherRelated.getBidiSelfrefManyToOne() );
		Assert.assertNull( theEx.getBidiSelfrefManyToOne() );
		related.addBidiSelfrefOneToMany(otherRelated);
		Assert.assertEquals( 1, related.getBidiSelfrefOneToMany().size() );
		Assert.assertEquals( 0, otherRelated.getBidiSelfrefOneToMany().size() );
		Assert.assertEquals( 0, theEx.getBidiSelfrefOneToMany().size() );
		Assert.assertNull( related.getBidiSelfrefManyToOne() );
		Assert.assertSame( related, otherRelated.getBidiSelfrefManyToOne() );
		Assert.assertNull( theEx.getBidiSelfrefManyToOne() );
		theEx.setBidiSelfrefManyToOne(related);
		Assert.assertEquals( 2, related.getBidiSelfrefOneToMany().size() );
		Assert.assertEquals( 0, otherRelated.getBidiSelfrefOneToMany().size() );
		Assert.assertEquals( 0, theEx.getBidiSelfrefOneToMany().size() );
		Assert.assertNull( related.getBidiSelfrefManyToOne() );
		Assert.assertSame( related, otherRelated.getBidiSelfrefManyToOne() );
		Assert.assertSame( related, theEx.getBidiSelfrefManyToOne() );
		
		otherRelated.setBidiSelfrefManyToOne(null);
		Assert.assertEquals( 1, related.getBidiSelfrefOneToMany().size() );
		Assert.assertEquals( 0, otherRelated.getBidiSelfrefOneToMany().size() );
		Assert.assertEquals( 0, theEx.getBidiSelfrefOneToMany().size() );
		Assert.assertNull( related.getBidiSelfrefManyToOne() );
		Assert.assertNull( otherRelated.getBidiSelfrefManyToOne() );
		Assert.assertSame( related, theEx.getBidiSelfrefManyToOne() );
		related.removeBidiSelfrefOneToMany(theEx);
		Assert.assertEquals( 0, related.getBidiSelfrefOneToMany().size() );
		Assert.assertEquals( 0, otherRelated.getBidiSelfrefOneToMany().size() );
		Assert.assertEquals( 0, theEx.getBidiSelfrefOneToMany().size() );
		Assert.assertNull( related.getBidiSelfrefManyToOne() );
		Assert.assertNull( otherRelated.getBidiSelfrefManyToOne() );
		Assert.assertNull( theEx.getBidiSelfrefManyToOne() );
	}
	
	@Test
	public void testBidiIfOneToMany() {
		Assert.assertEquals( 0, hub.getBidiIfOneToMany().size() );
		Assert.assertNull( related.getBidiIfManyToOne() );
		Assert.assertNull( otherRelated.getBidiIfManyToOne() );
		hub.addBidiIfOneToMany(related);
		Assert.assertEquals( 1, hub.getBidiIfOneToMany().size() );
		Assert.assertSame( hub, related.getBidiIfManyToOne() );
		Assert.assertNull( otherRelated.getBidiIfManyToOne() );
		otherRelated.setBidiIfManyToOne(hub);
		Assert.assertEquals( 2, hub.getBidiIfOneToMany().size() );
		Assert.assertSame( hub, related.getBidiIfManyToOne() );
		Assert.assertSame( hub, otherRelated.getBidiIfManyToOne() );
		
		hub.removeBidiIfOneToMany(theEx);
		Assert.assertEquals( 2, hub.getBidiIfOneToMany().size() );
		Assert.assertSame( hub, related.getBidiIfManyToOne() );
		Assert.assertSame( hub, otherRelated.getBidiIfManyToOne() );
		
		hub.removeBidiIfOneToMany(related);
		Assert.assertEquals( 1, hub.getBidiIfOneToMany().size() );
		Assert.assertNull( related.getBidiIfManyToOne() );
		Assert.assertSame( hub, otherRelated.getBidiIfManyToOne() );
		otherRelated.setBidiIfManyToOne(null);
		Assert.assertEquals( 0, hub.getBidiIfOneToMany().size() );
		Assert.assertNull( related.getBidiIfManyToOne() );
		Assert.assertNull( otherRelated.getBidiIfManyToOne() );
	}
}
