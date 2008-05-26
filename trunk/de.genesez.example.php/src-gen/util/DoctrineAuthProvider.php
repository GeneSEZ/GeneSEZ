<?php
/**
 * <html>;   <head>; ;   </head>;   <body>;     <p>;       contains additional utilitiy classes;     </p>;   </body>; </html>; 
 * 
 * @author	dreamer
 * @package	util
 */

require_once 'Auth/Container.php';

/* PROTECTED REGION ID(php.own.imports._14_0_b6f02e1_1208424345859_434700_182) ENABLED START */
// TODO: put your further include + require statements here
/* PROTECTED REGION END */

/**
 * <html>;   <head>;     ;   </head>;   <body>;     <p>;       represents an authentication provider for <b>PEAR::Auth</b> using the db ;       abstraction layer <b>phpdoctrine</b><br>;     </p>;     <p>;       needed, because the authentication framework <b>PEAR::Auth</b> doesn't ;       provide an appropriate authentication provider to work with the db ;       abstraction framework <b>phpdoctrine</b>;     </p>;   </body>; </html>; 
 * 
 * @see		Auth_Container
 * @author	dreamer
 * @package	util
 */
class DoctrineAuthProvider extends Auth_Container  {
	
	
	// -- constructors + destructors ----------------------------------------
	/**
	 * constructs an object of class {@link DoctrineAuthProvider}
	 * @generated	constructor for class {@link DoctrineAuthProvider}
	 * @param	array	$params	
	 */
	public function __construct($params = array()) {
		/* PROTECTED REGION ID(php.constructor._14_0_b6f02e1_1208424606859_435823_280) ENABLED START */
		// TODO: implementation of constructor for class 'DoctrineAuthProvider'
		
		// assumes that connection is made in bootstrap before using authentication
		
		/* PROTECTED REGION END */
	}
	
	
	// -- method implementations --------------------------------------------
	/**
	
	 * @generated	method stub for implementation
	 * @param	string	$username	
	 * @param	string	$password	
	 * @param	boolean	$usingChap	
	 * @return	boolean	
	 */
	public function fetchData($username, $password, $usingChap = false) {
		$returnValue = NULL;
		/* PROTECTED REGION ID(php.implementation._14_0_b6f02e1_1208424719796_880129_287) ENABLED START */
		// TODO: implementation of method 'DoctrineAuthProvider.fetchData(...)'
		
		/*
		$returnValue = false;
		var_dump( $username ) . "<br>";
		var_dump( $password ) . "<br>";
		var_dump( $bla ) . "<br>";
		*/
		
		$query = new Doctrine_Query();
		$query->from('User u')
			->where('u.login = ?', $username)
			->limit(1);
		
		$users = $query->execute();
		
		$returnValue = false;
		if (count($users) == 1) {
			$user = $users[0];
			if ($user->password == $password) {
				$returnValue = true;
			}
		}
		
		// TODO: remove static root user
		if ($username == "root") {
			$returnValue = true;
		}
		
		/* PROTECTED REGION END */
		return $returnValue;
	}
	
	
	
	// -- own code implementation -------------------------------------------
	/* PROTECTED REGION ID(php.class.own.code.implementation._14_0_b6f02e1_1208424345859_434700_182) ENABLED START */
	// TODO: put your further code implementations for class 'DoctrineAuthProvider' here
	/* PROTECTED REGION END */
}
?>
