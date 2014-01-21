CREATE TABLE t_user(
    usr_id SERIAL,
    usr_username VARCHAR(30) NOT NULL UNIQUE,
    usr_password CHAR(32) NOT NULL,
    CONSTRAINT t_usr_pk PRIMARY KEY(usr_id)
);

CREATE TABLE t_group(
    grp_id SERIAL,
    grp_name VARCHAR(30) NOT NULL,
    grp_desc VARCHAR(255),
    CONSTRAINT t_group_pk PRIMARY KEY(grp_id)
);

CREATE TABLE t_user_group(
    usr_id INTEGER REFERENCES t_user(usr_id),
    grp_id INTEGER REFERENCES t_group(grp_id)
);

CREATE VIEW v_user_group AS
    SELECT u.usr_username, u.usr_password, g.grp_name
    FROM t_user_group ug
    JOIN t_user u ON u.usr_id = ug.usr_id
    JOIN t_group g ON g.grp_id = ug.grp_id;
