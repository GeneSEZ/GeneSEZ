<?php
require_once 'Mfw/DtoBase.php';
require_once 'UML/OneAssociation.php';
require_once 'UML/ManyAssociation.php';
require_once 'Menu/MenuItem.php';
require_once 'Menu/Menu.php';

class MenuItemTest extends PHPUnit_Framework_TestCase {
	
	public function testConstruction() {
		$item = new Menu_MenuItem('test', 'link.to.test', true);
		$this->assertEquals('test', $item->name, 'name should be equal');
		$this->assertEquals('test', $item->getName(), 'name should be equal');
		$this->assertNotNull($item->menu, 'association object should not be null');
	}
	
	public function testMenu() {
		$menu = new Menu_Menu('menu', 'link');
		$item = new Menu_MenuItem('1st', '1st.link');
		$this->assertNotNull($menu->items, 'association object should not be null');
		$menu->items->insert($item);
		$this->assertEquals('menu', $menu->name);
		$this->assertEquals('menu', $menu->getName());
		$this->assertEquals('link', $menu->link);
		$this->assertEquals('1st', $menu->items->get()->name);
	}
}
?>