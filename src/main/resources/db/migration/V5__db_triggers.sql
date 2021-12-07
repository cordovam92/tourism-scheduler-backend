CREATE FUNCTION add_passing() RETURNS trigger AS $add_passing$
    BEGIN
        -- Check that f_name, l_name, and pos are given
        IF NEW.f_name is NULL THEN
            RAISE EXCEPTION 'first name cannot be null';
        end if;
        IF NEW.l_name is NULL THEN
            RAISE EXCEPTION 'last name cannot be null';
        end if;
        IF NEW.pos is NULL THEN
            RAISE EXCEPTION 'position cannot be null';
        end if;

        INSERT INTO
            players(first_name, last_name, position)
            VALUES(NEW.f_name, NEW.l_name, NEW.pos);

    END;
$add_passing$ LANGUAGE plpgsql;

CREATE TRIGGER add_passing BEFORE INSERT OR UPDATE on passing
    FOR EACH ROW EXECUTE PROCEDURE add_passing();

CREATE FUNCTION add_rushing() RETURNS trigger AS $add_rushing$
    BEGIN
        -- Check that f_name, l_name, and pos are given
        IF NEW.f_name is NULL THEN
            RAISE EXCEPTION 'first name cannot be null';
        end if;
        IF NEW.l_name is NULL THEN
            RAISE EXCEPTION 'last name cannot be null';
        end if;
        IF NEW.pos is NULL THEN
            RAISE EXCEPTION 'position cannot be null';
        end if;

        INSERT INTO
            players(first_name, last_name, position)
        VALUES(NEW.f_name, NEW.l_name, NEW.pos);

    END;
$add_rushing$ LANGUAGE plpgsql;

CREATE TRIGGER add_rushing BEFORE INSERT OR UPDATE on rushing
    FOR EACH ROW EXECUTE PROCEDURE add_rushing();

CREATE FUNCTION add_receiving() RETURNS trigger AS $add_receiving$
    BEGIN
        -- Check that f_name, l_name, and pos are given
        IF NEW.f_name is NULL THEN
            RAISE EXCEPTION 'first name cannot be null';
        end if;
        IF NEW.l_name is NULL THEN
            RAISE EXCEPTION 'last name cannot be null';
        end if;
        IF NEW.pos is NULL THEN
            RAISE EXCEPTION 'position cannot be null';
        end if;

        INSERT INTO
            players(first_name, last_name, position)
        VALUES(NEW.f_name, NEW.l_name, NEW.pos);

    END;
$add_receiving$ LANGUAGE plpgsql;

CREATE TRIGGER add_receiving BEFORE INSERT OR UPDATE on receiving
    FOR EACH ROW EXECUTE PROCEDURE add_receiving();

CREATE FUNCTION add_defense() RETURNS trigger AS $add_defense$
    BEGIN
        -- Check that f_name, l_name, and pos are given
        IF NEW.f_name is NULL THEN
            RAISE EXCEPTION 'first name cannot be null';
        end if;
        IF NEW.l_name is NULL THEN
            RAISE EXCEPTION 'last name cannot be null';
        end if;
        IF NEW.pos is NULL THEN
            RAISE EXCEPTION 'position cannot be null';
        end if;

        INSERT INTO
            players(first_name, last_name, position)
            VALUES(NEW.f_name, NEW.l_name, NEW.pos);

    END;
    $add_defense$ LANGUAGE plpgsql;

CREATE TRIGGER add_defense BEFORE INSERT OR UPDATE on defense
    FOR EACH ROW EXECUTE PROCEDURE add_defense();