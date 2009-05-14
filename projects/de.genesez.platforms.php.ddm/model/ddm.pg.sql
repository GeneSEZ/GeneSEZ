--- -------------------------------------------
--- Verwendente Sprachen
--- -------------------------------------------

DROP LANGUAGE IF EXISTS plpgsql CASCADE;
CREATE LANGUAGE plpgsql;
DROP LANGUAGE IF EXISTS plperl CASCADE;
CREATE LANGUAGE plperl;

--- -------------------------------------------
--- Typdefinitionen
--- -------------------------------------------

-- Basistypen
DROP TYPE IF EXISTS ddm_basetypes CASCADE;
CREATE TYPE ddm_basetypes AS ENUM ('INTEGER', 'BOOLEAN', 'STRING');

-- Kardinalitäten
DROP TYPE IF EXISTS ddm_cardinalities CASCADE;
CREATE TYPE ddm_cardinalities AS ENUM ('0..1', '1', 'N', '1..N');

--- -------------------------------------------
--- Sequenzdefinitionen
--- -------------------------------------------

-- Sequenz fuer die Typ-IDs
DROP SEQUENCE IF EXISTS ddm_type_id_seq CASCADE;
CREATE SEQUENCE ddm_type_id_seq;

-- Sequenz fuer die Klassen-IDs
DROP SEQUENCE IF EXISTS ddm_class_id_seq CASCADE;
CREATE SEQUENCE ddm_class_id_seq;

-- Sequenz fuer die Attribute-IDs
DROP SEQUENCE IF EXISTS ddm_attribute_id_seq CASCADE;
CREATE SEQUENCE ddm_attribute_id_seq;

-- Sequenz fuer die Assoziations-IDs
DROP SEQUENCE IF EXISTS ddm_association_id_seq CASCADE;
CREATE SEQUENCE ddm_association_id_seq;

-- Sequenz fuer die Reverse Assoziations-IDs
DROP SEQUENCE IF EXISTS ddm_reverse_association_id_seq CASCADE;
CREATE SEQUENCE ddm_reverse_association_id_seq;

-- Sequenz fuer die Objekt-IDs
DROP SEQUENCE IF EXISTS ddm_object_id_seq CASCADE;
CREATE SEQUENCE ddm_object_id_seq;

-- Sequenz fuer die Wert-IDs
DROP SEQUENCE IF EXISTS ddm_value_id_seq CASCADE;
CREATE SEQUENCE ddm_value_id_seq;

-- Sequenzen fuer die Referenz-IDs
DROP SEQUENCE IF EXISTS ddm_reference_o2o_id_seq CASCADE;
CREATE SEQUENCE ddm_reference_o2o_id_seq;
DROP SEQUENCE IF EXISTS ddm_reference_o2n_id_seq CASCADE;
CREATE SEQUENCE ddm_reference_o2n_id_seq;
DROP SEQUENCE IF EXISTS ddm_reference_n2o_id_seq CASCADE;
CREATE SEQUENCE ddm_reference_n2o_id_seq;
DROP SEQUENCE IF EXISTS ddm_reference_n2n_id_seq CASCADE;
CREATE SEQUENCE ddm_reference_n2n_id_seq;

--- -------------------------------------------
--- Tabellendefinitionen
--- -------------------------------------------

-- Typen
DROP TABLE IF EXISTS ddm_type CASCADE;
CREATE TABLE ddm_type (
	id INTEGER PRIMARY KEY DEFAULT nextval('ddm_type_id_seq'),
	t_basetype ddm_basetypes NOT NULL,
	t_name VARCHAR(1024) UNIQUE NOT NULL,
	t_description VARCHAR(1024) NOT NULL DEFAULT '',
	t_constraint TEXT NOT NULL,
	t_editable BOOLEAN NOT NULL DEFAULT TRUE
);

-- Klassen
DROP TABLE IF EXISTS ddm_class CASCADE;
CREATE TABLE ddm_class (
	id INTEGER PRIMARY KEY DEFAULT nextval('ddm_class_id_seq'),
	c_parent INTEGER REFERENCES ddm_class(id) ON DELETE CASCADE,
	c_name VARCHAR(1024) UNIQUE NOT NULL,
	c_view VARCHAR(1024) UNIQUE NOT NULL,
	c_description VARCHAR(1024)NOT NULL DEFAULT '',
	c_editable BOOLEAN NOT NULL DEFAULT TRUE
);

-- Attribute
DROP TABLE IF EXISTS ddm_attribute CASCADE;
CREATE TABLE ddm_attribute (
	id INTEGER PRIMARY KEY DEFAULT nextval('ddm_attribute_id_seq'),
	a_class INTEGER REFERENCES ddm_class(id) ON DELETE CASCADE NOT NULL,
	a_type INTEGER REFERENCES ddm_type(id) ON DELETE RESTRICT NOT NULL,
	a_name VARCHAR(1024) NOT NULL,
	a_column VARCHAR(1024) NOT NULL,
	a_description VARCHAR(1024) NOT NULL DEFAULT ''
);

-- Assoziationen
DROP TABLE IF EXISTS ddm_association CASCADE;
CREATE TABLE ddm_association (
	id INTEGER PRIMARY KEY DEFAULT nextval('ddm_association_id_seq'),
	s_from INTEGER REFERENCES ddm_class(id) ON DELETE CASCADE NOT NULL,
	s_from_cardinality ddm_cardinalities NOT NULL DEFAULT '1',
	s_to INTEGER REFERENCES ddm_class(id) ON DELETE CASCADE NOT NULL,
	s_to_cardinality ddm_cardinalities NOT NULL DEFAULT '1',
	s_name VARCHAR(1024) NOT NULL,
	s_description VARCHAR(1024) NOT NULL DEFAULT ''
);

-- Reverse Assoziationen
DROP TABLE IF EXISTS ddm_reverse_association CASCADE;
CREATE TABLE ddm_reverse_association (
	id INTEGER PRIMARY KEY DEFAULT nextval('ddm_reverse_association_id_seq'),
	s_association INTEGER REFERENCES ddm_association(id) ON DELETE RESTRICT NOT NULL,
	s_name VARCHAR(1024) NOT NULL
);

-- Objekte
DROP TABLE IF EXISTS ddm_object CASCADE;
CREATE TABLE ddm_object (
	id INTEGER PRIMARY KEY DEFAULT nextval('ddm_object_id_seq'),
	o_class INTEGER REFERENCES ddm_class(id) ON DELETE RESTRICT NOT NULL
);

-- Integer Werte
DROP TABLE IF EXISTS ddm_value_integer CASCADE;
CREATE TABLE ddm_value_integer (
	id INTEGER PRIMARY KEY DEFAULT nextval('ddm_value_id_seq'),
	v_object INTEGER REFERENCES ddm_object(id) ON DELETE CASCADE NOT NULL,
	v_attribute INTEGER REFERENCES ddm_attribute(id) ON DELETE RESTRICT NOT NULL,
	v_value INTEGER
);

-- Zeichenketten
DROP TABLE IF EXISTS ddm_value_string CASCADE;
CREATE TABLE ddm_value_string (
	id INTEGER PRIMARY KEY DEFAULT nextval('ddm_value_id_seq'),
	v_object INTEGER REFERENCES ddm_object(id) ON DELETE CASCADE NOT NULL,
	v_attribute INTEGER REFERENCES ddm_attribute(id) ON DELETE RESTRICT NOT NULL,
	v_value TEXT
);

-- Boolesche Werte
DROP TABLE IF EXISTS ddm_value_boolean CASCADE;
CREATE TABLE ddm_value_boolean (
	id INTEGER PRIMARY KEY DEFAULT nextval('ddm_value_id_seq'),
	v_object INTEGER REFERENCES ddm_object(id) ON DELETE CASCADE NOT NULL,
	v_attribute INTEGER REFERENCES ddm_attribute(id) ON DELETE RESTRICT NOT NULL,
	v_value BOOLEAN
);

-- 1:1 Assoziationen
DROP TABLE IF EXISTS ddm_reference_o2o CASCADE;
CREATE TABLE ddm_reference_o2o (
	id INTEGER PRIMARY KEY DEFAULT nextval('ddm_reference_o2o_id_seq'),
	r_association INTEGER REFERENCES ddm_association(id) ON DELETE RESTRICT NOT NULL,
	r_from INTEGER REFERENCES ddm_object(id) ON DELETE CASCADE NOT NULL,
	r_to INTEGER REFERENCES ddm_object(id) ON DELETE CASCADE NOT NULL
);

-- 1:N Assoziationen
DROP TABLE IF EXISTS ddm_reference_o2n CASCADE;
CREATE TABLE ddm_reference_o2n (
	id INTEGER PRIMARY KEY DEFAULT nextval('ddm_reference_o2n_id_seq'),
	r_association INTEGER REFERENCES ddm_association(id) ON DELETE RESTRICT NOT NULL,
	r_from INTEGER REFERENCES ddm_object(id) ON DELETE CASCADE NOT NULL,
	r_to INTEGER REFERENCES ddm_object(id) ON DELETE CASCADE NOT NULL
);

-- N:1 Assoziationen
DROP TABLE IF EXISTS ddm_reference_n2o CASCADE;
CREATE TABLE ddm_reference_n2o (
	id INTEGER PRIMARY KEY DEFAULT nextval('ddm_reference_n2o_id_seq'),
	r_association INTEGER REFERENCES ddm_association(id) ON DELETE RESTRICT NOT NULL,
	r_from INTEGER REFERENCES ddm_object(id) ON DELETE CASCADE NOT NULL,
	r_to INTEGER REFERENCES ddm_object(id) ON DELETE CASCADE NOT NULL
);

-- N:N Assoziationen
DROP TABLE IF EXISTS ddm_reference_n2n CASCADE;
CREATE TABLE ddm_reference_n2n (
	id INTEGER PRIMARY KEY DEFAULT nextval('ddm_reference_n2n_id_seq'),
	r_association INTEGER REFERENCES ddm_association(id) ON DELETE RESTRICT NOT NULL,
	r_from INTEGER REFERENCES ddm_object(id) ON DELETE CASCADE NOT NULL,
	r_to INTEGER REFERENCES ddm_object(id) ON DELETE CASCADE NOT NULL
);

--- -------------------------------------------
--- Indizes
--- -------------------------------------------

CREATE UNIQUE INDEX ddm_attribute_name_unique ON ddm_attribute (a_class, a_name);
CREATE UNIQUE INDEX ddm_attribute_column_unique ON ddm_attribute (a_class, a_column);
CREATE UNIQUE INDEX ddm_association_unique ON ddm_association (s_from, s_name);
CREATE UNIQUE INDEX ddm_reverse_association_unique ON ddm_reverse_association (s_association);
CREATE UNIQUE INDEX ddm_value_integer_unique ON ddm_value_integer (v_object, v_attribute);
CREATE UNIQUE INDEX ddm_value_string_unique ON ddm_value_string (v_object, v_attribute);
CREATE UNIQUE INDEX ddm_value_boolean_unique ON ddm_value_boolean (v_object, v_attribute);
CREATE UNIQUE INDEX ddm_reference_o2o_from_unique ON ddm_reference_o2o (r_association, r_from);
CREATE UNIQUE INDEX ddm_reference_o2o_to_unique ON ddm_reference_o2o (r_association, r_to);
CREATE UNIQUE INDEX ddm_reference_o2n_to_unique ON ddm_reference_o2n (r_association, r_to);
CREATE UNIQUE INDEX ddm_reference_o2n_unique ON ddm_reference_o2n (r_association, r_from, r_to);
CREATE UNIQUE INDEX ddm_reference_n2o_from_unique ON ddm_reference_n2o (r_association, r_from);
CREATE UNIQUE INDEX ddm_reference_n2o_unique ON ddm_reference_n2o (r_association, r_to, r_from);
CREATE UNIQUE INDEX ddm_reference_n2n_unique ON ddm_reference_n2n (r_association, r_from, r_to);

--- -------------------------------------------
--- Prozeduren
--- -------------------------------------------

--- ---------------------
--- Anlegen neuer Klassen
--- ---------------------
DROP FUNCTION IF EXISTS create_class() CASCADE;
CREATE FUNCTION create_class() RETURNS TRIGGER AS $$
BEGIN
	PERFORM _create_view(NEW.c_view, NEW.id, NEW.c_parent);
	RETURN NEW;
END;
$$ LANGUAGE plpgsql;

--- ---------------------
--- Modifikationen von Klassen
--- ---------------------
DROP FUNCTION IF EXISTS modify_class() CASCADE;
CREATE FUNCTION modify_class() RETURNS TRIGGER AS $$
BEGIN
	PERFORM _drop_view(OLD.c_view);
	PERFORM _create_view(NEW.c_view, NEW.id, NEW.c_parent);
	RETURN NEW;
END;
$$ LANGUAGE plpgsql;

--- ---------------------
-- Löschen neuer Klassen
--- ---------------------
DROP FUNCTION IF EXISTS delete_class() CASCADE;
CREATE FUNCTION delete_class() RETURNS TRIGGER AS $$
BEGIN
	PERFORM _drop_view(OLD.c_view);
	RETURN OLD;
END;
$$ LANGUAGE plpgsql;

--- ---------------------
--- Pruefung vor dem Anlegen neuer Attribute
--- ---------------------
DROP FUNCTION IF EXISTS check_attribute() CASCADE;
CREATE FUNCTION check_attribute() RETURNS TRIGGER AS $$
	my $name = $_TD->{'new'}{'a_name'};
	my $id = $_TD->{'new'}{'a_class'};

	my @classes = ();
	my @classqueue = ($id);
	my $cid = $id;

	while ($cid) {
		push( @classes, $cid );
		$statement = 'SELECT c_parent FROM ddm_class WHERE id=' . $cid;
		elog(INFO, $statement);
		my $sth = spi_query($statement);
		my $row = spi_fetchrow($sth);
		$cid = $row->{'c_parent'};
	}

	while (-1 < $#classqueue ) {
		my $cid = shift( @classqueue );
		$statement = 'SELECT id FROM ddm_class WHERE c_parent=' . $cid;
		elog(INFO, $statement);
		my $sth = spi_query($statement);
		while ( defined( my $row = spi_fetchrow($sth) ) ) {
			push( @classqueue, $row->{'id'} );
			push( @classes, $row->{'id'} );
		}
	}

	for my $cid (@classes) {
		$statement ='SELECT a.id AS a_id FROM ddm_attribute AS a WHERE a.a_name=\'' . $name . '\' AND a.a_class=' . $cid;
		elog(INFO, $statement);
		my $sth = spi_query($statement);
		while ( defined( my $row = spi_fetchrow($sth) ) ) {
			elog(ERROR, 'Attribute named "' . $name . '" already exists');
			return 'SKIP';
		}
	}

	return;
$$ LANGUAGE plperl;

--- ---------------------
--- Anlegen neuer Attribute
--- ---------------------
DROP FUNCTION IF EXISTS create_attribute() CASCADE;
CREATE FUNCTION create_attribute() RETURNS TRIGGER AS $$
DECLARE
	class RECORD;
BEGIN
	SELECT c_view, c_parent INTO class FROM ddm_class WHERE id=NEW.a_class;
	IF NOT FOUND THEN
		RAISE EXCEPTION 'class % not found', NEW.a_class;
	END IF;
	PERFORM _drop_view(class.c_view);
	PERFORM _create_view(class.c_view, NEW.a_class, class.c_parent);
	RETURN NEW;
END;
$$ LANGUAGE plpgsql;

--- ---------------------
--- Modifikationen von Attributen
--- ---------------------
DROP FUNCTION IF EXISTS modify_attribute() CASCADE;
CREATE FUNCTION modify_attribute() RETURNS TRIGGER AS $$
DECLARE
	class RECORD;
BEGIN
	SELECT c_view INTO class FROM ddm_class WHERE id=OLD.a_class;
	IF NOT FOUND THEN
		RAISE EXCEPTION 'class % not found', OLD.a_class;
	END IF;
	PERFORM _drop_view(class.c_view);
	SELECT c_view, c_parent INTO class FROM ddm_class WHERE id=NEW.a_class;
	IF NOT FOUND THEN
		RAISE EXCEPTION 'class % not found', NEW.a_class;
	END IF;
	PERFORM _create_view(class.c_view, NEW.a_class, class.c_parent);
	RETURN NEW;
END;
$$ LANGUAGE plpgsql;

--- ---------------------
--- Löschen von Attributen
--- ---------------------
DROP FUNCTION IF EXISTS delete_attribute() CASCADE;
CREATE FUNCTION delete_attribute() RETURNS TRIGGER AS $$
DECLARE
	class RECORD;
BEGIN
	SELECT c_view, c_parent INTO class FROM ddm_class WHERE id=OLD.a_class;
	IF NOT FOUND THEN
		RAISE EXCEPTION 'class % not found', OLD.a_class;
	END IF;
	PERFORM _drop_view(class.c_view);
	PERFORM _create_view(class.c_view, OLD.a_class, class.c_parent);
	RETURN OLD;
END;
$$ LANGUAGE plpgsql;

--- -------------------------------------------
--- Private Prozeduren
--- -------------------------------------------

--- ---------------------
--- Löschen existierender Views
--- ---------------------
DROP FUNCTION IF EXISTS _drop_view(c_view varchar);
CREATE FUNCTION _drop_view(c_view varchar) RETURNS void AS $$
DECLARE
	drop_view TEXT;
BEGIN
	drop_view := 'DROP VIEW '
		|| c_view;
	RAISE DEBUG '%', drop_view;
	EXECUTE drop_view;
	RETURN;
END;
$$ LANGUAGE plpgsql;

--- ---------------------
--- Anlegen neuer Views
--- ---------------------
DROP FUNCTION IF EXISTS _create_view(c_view varchar, c_id integer, c_parent integer);
CREATE FUNCTION _create_view(c_view varchar, c_id integer, c_parent integer) RETURNS void AS $$
	my ($view, $id, $parent) = @_;
	my $statement;
	my %attributes;
	my @classes = ($id);

	while ($parent) {
		push( @classes, $parent );
		$statement = 'SELECT c_parent FROM ddm_class WHERE id=' . $parent;
		elog(INFO, $statement);
		my $sth = spi_query($statement);
		my $row = spi_fetchrow($sth);
		$parent = $row->{'c_parent'};
	}

	for my $cid (@classes) {
		$statement ='SELECT a.id AS a_id, a_type, a_column, t_basetype FROM ddm_attribute AS a, ddm_type AS t WHERE a.a_type=t.id AND a.a_class=' . $cid;
		elog(INFO, $statement);
		my $sth = spi_query($statement);
		while ( my $row = spi_fetchrow($sth) ) {
			elog(WARNING, $row->{'a_column'});
			if ( ! exists( $attributes{$row->{'a_column'}} ) ) {
				$attributes{$row->{'a_column'}} = $row;
			}
		}
	}

	$statement = 'CREATE VIEW ' . $view . ' AS SELECT id';
	while ( my ($a_column, $attr) = each( %attributes ) ) {
		my $table;
		if ( 'STRING' eq $attr->{'t_basetype'} ) {
			$table = 'ddm_value_string';
		} elsif ( 'INTEGER' eq $attr->{'t_basetype'} ) {
			$table = 'ddm_value_integer';
		} elsif ( 'BOOLEAN' eq $attr->{'t_basetype'} ) {
			$table = 'ddm_value_boolean';
		}
		$statement .= ', (SELECT v_value FROM ' . $table . ' WHERE v_object=ddm_object.id AND v_attribute=' . $attr->{'a_id'} . ') AS ' . $a_column;
	}
	$statement .= ' FROM ddm_object WHERE o_class='. $id;
	elog(INFO, $statement);
	spi_exec_query($statement, 1);
	$statement = 'SELECT _create_insert_rule(\'' . $view . '\',' . $id . ')';
	elog(INFO, $statement);
	spi_exec_query($statement, 1);
	$statement = 'SELECT _create_update_rule(\'' . $view . '\',' . $id . ')';
	elog(INFO, $statement);
	spi_exec_query($statement, 1);
	$statement = 'SELECT _create_delete_rule(\'' . $view . '\')';
	elog(INFO, $statement);
	spi_exec_query($statement, 1);
END;
$$ LANGUAGE plperl;

--- ---------------------
--- Anlegen neuer Rules zum Erzeugen von Objekten
--- ---------------------
DROP FUNCTION IF EXISTS _create_insert_rule(c_view varchar, c_id integer);
CREATE FUNCTION _create_insert_rule(c_view varchar, c_id integer) RETURNS void AS $$
	my ($view, $id) = @_;
	my $statement;
	my %attributes;
	my @classes = ();
	my $cid = $id;

	while ($cid) {
		push( @classes, $cid );
		$statement = 'SELECT c_parent FROM ddm_class WHERE id=' . $cid;
		elog(INFO, $statement);
		my $sth = spi_query($statement);
		my $row = spi_fetchrow($sth);
		$cid = $row->{'c_parent'};
	}

	for my $cid (@classes) {
		$statement ='SELECT a.id AS a_id, a_type, a_column, t_basetype FROM ddm_attribute AS a, ddm_type AS t WHERE a.a_type=t.id AND a.a_class=' . $cid;
		elog(INFO, $statement);
		my $sth = spi_query($statement);
		while ( my $row = spi_fetchrow($sth) ) {
			elog(WARNING, $row->{'a_column'});
			if ( ! exists( $attributes{$row->{'a_column'}} ) ) {
				$attributes{$row->{'a_column'}} = $row;
			}
		}
	}

	$statement = 'CREATE RULE insert_' . $view . '  AS ON INSERT TO ' . $view . ' DO INSTEAD ( ';

	while ( my ($a_column, $attr) = each( %attributes ) ) {
		my $table;
		if ( 'STRING' eq $attr->{'t_basetype'} ) {
			$table = 'ddm_value_string';
		} elsif ( 'INTEGER' eq $attr->{'t_basetype'} ) {
			$table = 'ddm_value_integer';
		} elsif ( 'BOOLEAN' eq $attr->{'t_basetype'} ) {
			$table = 'ddm_value_boolean';
		}
		$statement .= 'INSERT INTO ' . $table . ' (v_object, v_attribute, v_value) VALUES(currval(\'ddm_object_id_seq\'),' . $attr->{'a_id'} . ', NEW.' . $a_column . ');';
	}
	$statement .= '  );';
	elog(INFO, $statement);
	spi_exec_query($statement, 1);
END;
$$ LANGUAGE plperl;

--- ---------------------
--- Anlegen neuer Rules zum Aktualisieren von Objekten
--- ---------------------
DROP FUNCTION IF EXISTS _create_update_rule(c_view varchar, c_id integer);
CREATE FUNCTION _create_update_rule(c_view varchar, c_id integer) RETURNS void AS $$
	my ($view, $id) = @_;
	my $statement;
	my %attributes;
	my @classes = ();
	my $cid = $id;

	while ($cid) {
		push( @classes, $cid );
		$statement = 'SELECT c_parent FROM ddm_class WHERE id=' . $cid;
		elog(INFO, $statement);
		my $sth = spi_query($statement);
		my $row = spi_fetchrow($sth);
		$cid = $row->{'c_parent'};
	}

	for my $cid (@classes) {
		$statement ='SELECT a.id AS a_id, a_type, a_column, t_basetype FROM ddm_attribute AS a, ddm_type AS t WHERE a.a_type=t.id AND a.a_class=' . $cid;
		elog(INFO, $statement);
		my $sth = spi_query($statement);
		while ( my $row = spi_fetchrow($sth) ) {
			elog(INFO, $row->{'a_column'});
			if ( ! exists( $attributes{$row->{'a_column'}} ) ) {
				$attributes{$row->{'a_column'}} = $row;
			}
		}
	}

	$statement = 'CREATE RULE update_' . $view . '  AS ON UPDATE TO ' . $view . ' DO INSTEAD ( ';

	while ( my ($a_column, $attr) = each( %attributes ) ) {
		my $table;
		if ( 'STRING' eq $attr->{'t_basetype'} ) {
			$table = 'ddm_value_string';
		} elsif ( 'INTEGER' eq $attr->{'t_basetype'} ) {
			$table = 'ddm_value_integer';
		} elsif ( 'BOOLEAN' eq $attr->{'t_basetype'} ) {
			$table = 'ddm_value_boolean';
		}
		$statement .= 'SELECT _update_attribute( \'' . $table . '\', NEW.id, ' . $attr->{'a_id'} . ', OLD.' . $attr->{'a_column'} . ', NEW.' . $attr->{'a_column'} . ');';
	}
	$statement .= '  );';
	elog(INFO, $statement);
	spi_exec_query($statement, 1);
END;
$$ LANGUAGE plperl;

--- ---------------------
--- Anlegen neuer Rules zum Löschen von Objekten
--- ---------------------
DROP FUNCTION IF EXISTS _create_delete_rule(c_view varchar);
CREATE FUNCTION _create_delete_rule(c_view varchar) RETURNS void AS $$
DECLARE
	create_rule TEXT;
BEGIN
	create_rule := 'CREATE RULE delete_'
		|| c_view
		|| '  AS ON DELETE TO '
		|| c_view
		|| ' DO INSTEAD DELETE FROM ddm_object WHERE id=OLD.id;';
	RAISE DEBUG '%', create_rule;
	EXECUTE create_rule;
	RETURN;
END;
$$ LANGUAGE plpgsql;

--- ---------------------
--- Aktualsieren von Attributen
--- ---------------------
DROP FUNCTION IF EXISTS _update_attribute(value_table varchar, o_id integer, a_id integer, old_value anyelement, new_value anyelement);
CREATE FUNCTION _update_attribute(value_table varchar, o_id integer, a_id integer, old_value anyelement, new_value anyelement) RETURNS void AS $$
DECLARE
	update_statement TEXT;
BEGIN
	IF new_value IS NULL THEN
		update_statement := 'DELETE FROM '
			|| value_table
			|| ' WHERE v_object = '
			|| o_id
			|| ' AND v_attribute = '
			|| a_id;
	ELSIF old_value IS NULL THEN
		update_statement := 'INSERT INTO '
			|| value_table
			|| '(v_object, v_attribute, v_value) VALUES('
			|| o_id
			|| ', '
			|| a_id
			|| ', '''
			|| new_value
			|| ''')';
	ELSE
		update_statement := 'UPDATE '
			|| value_table
			|| ' SET v_value = '''
			|| new_value
			|| ''' WHERE v_object = '
			|| o_id
			|| ' AND v_attribute = '
			|| a_id;
	END IF;
	RAISE WARNING '%', update_statement;
	EXECUTE update_statement;
	RETURN;
END;
$$ LANGUAGE plpgsql;

--- -------------------------------------------
--- Trigger
--- -------------------------------------------

CREATE TRIGGER ddm_class_create AFTER INSERT ON ddm_class FOR EACH ROW EXECUTE PROCEDURE create_class();
CREATE TRIGGER ddm_class_modify AFTER UPDATE ON ddm_class FOR EACH ROW EXECUTE PROCEDURE modify_class();
CREATE TRIGGER ddm_class_delete BEFORE DELETE ON ddm_class FOR EACH ROW EXECUTE PROCEDURE delete_class();

CREATE TRIGGER ddm_attribute_check BEFORE INSERT OR UPDATE ON ddm_attribute FOR EACH ROW EXECUTE PROCEDURE check_attribute();
CREATE TRIGGER ddm_attribute_create AFTER INSERT ON ddm_attribute FOR EACH ROW EXECUTE PROCEDURE create_attribute();
CREATE TRIGGER ddm_attribute_modify AFTER UPDATE ON ddm_attribute FOR EACH ROW EXECUTE PROCEDURE modify_attribute();
CREATE TRIGGER ddm_attribute_delete AFTER DELETE ON ddm_attribute FOR EACH ROW EXECUTE PROCEDURE delete_attribute();
