-- Generado por Oracle SQL Developer Data Modeler 20.4.1.406.0906
--   en:        2021-05-27 14:19:00 CEST
--   sitio:      Oracle Database 11g
--   tipo:      Oracle Database 11g



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE alumno (
    id                      INTEGER NOT NULL,
    dni                     VARCHAR2(50 CHAR) NOT NULL,
    nombre                  VARCHAR2(50 CHAR) NOT NULL,
    apellido1               VARCHAR2(50 CHAR) NOT NULL,
    apellido2               VARCHAR2(50 CHAR),
    num_expediente          INTEGER,
    num_archivo             VARCHAR2(50 CHAR),
    email_institucional     VARCHAR2(100 CHAR) NOT NULL,
    email_personal          VARCHAR2(100 CHAR),
    telefono                VARCHAR2(20 CHAR),
    movil                   VARCHAR2(20 CHAR),
    direccion_notificacion  VARCHAR2(50 CHAR),
    localidad_notificacion  VARCHAR2(50 CHAR),
    provincia_notificacion  VARCHAR2(50 CHAR),
    cp_notificacion         INTEGER,
    fecha_matricula         VARCHAR2(100 CHAR),
    turno_preferente        VARCHAR2(100 CHAR),
    grupos_asignados        VARCHAR2(255 CHAR),
    nota_media              INTEGER,
    creditos_superados      INTEGER,
    creditos_fb             INTEGER,
    creditos_ob             INTEGER,
    creditos_op             INTEGER,
    creditos_cf             INTEGER,
    creditos_pe             INTEGER,
    creditos_tf             INTEGER
);

ALTER TABLE alumno ADD CONSTRAINT alumno_pk PRIMARY KEY ( id ) USING INDEX TABLESPACE TS_INDICES;

CREATE TABLE asig (
    referencia         INTEGER NOT NULL,
    ofertada           VARCHAR2(20) NOT NULL,
    codigo_1           INTEGER NOT NULL,
    asignatura         VARCHAR2(100 CHAR),
    curso              INTEGER,
    creditos_teoria    INTEGER NOT NULL,
    creditos_practica  INTEGER,
    total_creditos     INTEGER,
    caracter           VARCHAR2(20 CHAR),
    duracion           VARCHAR2(50 CHAR),
    plazas             VARCHAR2(50 CHAR),
    otro_idioma        VARCHAR2(20 CHAR),
    titu_codigo        INTEGER NOT NULL
);

ALTER TABLE asig ADD CONSTRAINT asig_pk PRIMARY KEY ( referencia ) USING INDEX TABLESPACE TS_INDICES;

CREATE TABLE asig_matr (
    matr_curso       INTEGER NOT NULL,
    matr_exp_num     INTEGER NOT NULL,
    asig_referencia  INTEGER NOT NULL,
    grupo_id         INTEGER
);

ALTER TABLE asig_matr
    ADD CONSTRAINT asig_matr_pk PRIMARY KEY ( matr_curso,
                                              matr_exp_num,
                                              asig_referencia ) USING INDEX TABLESPACE TS_INDICES;

CREATE TABLE centro (
    id               INTEGER NOT NULL,
    nombre           VARCHAR2(20 CHAR) NOT NULL,
    direccion        VARCHAR2(20 CHAR) NOT NULL,
    tlf_conserjeria  VARCHAR2(20 CHAR)
);

ALTER TABLE centro ADD CONSTRAINT centro_pk PRIMARY KEY ( id ) USING INDEX TABLESPACE TS_INDICES;

ALTER TABLE centro ADD CONSTRAINT centro_nombre_un UNIQUE ( nombre );

CREATE TABLE clase (
    dia              INTEGER NOT NULL,
    hora_inicio      DATE NOT NULL,
    hora__fin        DATE,
    asig_referencia  INTEGER NOT NULL,
    grupo_id         INTEGER NOT NULL
);

ALTER TABLE clase
    ADD CONSTRAINT clase_pk PRIMARY KEY ( dia,
                                          hora_inicio,
                                          grupo_id ) USING INDEX TABLESPACE TS_INDICES;

CREATE TABLE encuesta (
    fecha_de_envio  DATE NOT NULL,
    exp_num         INTEGER NOT NULL
);

ALTER TABLE encuesta ADD CONSTRAINT encuesta_pk PRIMARY KEY ( fecha_de_envio ) USING INDEX TABLESPACE TS_INDICES;

CREATE TABLE encuesta_gpa (
    encuesta_fecha_de_envio  DATE NOT NULL,
    gpa_c                    INTEGER NOT NULL,
    gpa_asig_referencia      INTEGER NOT NULL,
    gpa_id                   INTEGER NOT NULL
);

ALTER TABLE encuesta_gpa
    ADD CONSTRAINT encuesta_gpa_pk PRIMARY KEY ( encuesta_fecha_de_envio,
                                                 gpa_c,
                                                 gpa_asig_referencia,
                                                 gpa_id ) USING INDEX TABLESPACE TS_INDICES;

CREATE TABLE exp (
    num          INTEGER NOT NULL,
    activo       CHAR(2 BYTE),
    nota_media   INTEGER,
    titu_codigo  INTEGER NOT NULL,
    alumno_id    INTEGER NOT NULL
);

ALTER TABLE exp ADD CONSTRAINT exp_pk PRIMARY KEY ( num ) USING INDEX TABLESPACE TS_INDICES;

CREATE TABLE gpa (
    c                INTEGER NOT NULL,
    oferta           CHAR(2 BYTE),
    asig_referencia  INTEGER NOT NULL,
    grupo_id         INTEGER NOT NULL
);

ALTER TABLE gpa
    ADD CONSTRAINT gpa_pk PRIMARY KEY ( c,
                                        asig_referencia,
                                        grupo_id ) USING INDEX TABLESPACE TS_INDICES;

CREATE TABLE grupo (
    id                    INTEGER NOT NULL,
    curso                 INTEGER NOT NULL,
    letra                 VARCHAR2(20 CHAR) NOT NULL,
    turno_manana_tarde    VARCHAR2(20 CHAR) NOT NULL,
    ingles                CHAR(2 BYTE) NOT NULL,
    visible               CHAR(2 BYTE),
    asignar               VARCHAR2(20 CHAR),
    plazas                INTEGER,
    titu_codigo           INTEGER NOT NULL,
    plazas_nuevo_ingreso  INTEGER,
    sustituye_ingles      VARCHAR2(3 BYTE),
    grupo_id              INTEGER
);

ALTER TABLE grupo ADD CONSTRAINT grupo_pk PRIMARY KEY ( id ) USING INDEX TABLESPACE TS_INDICES;

ALTER TABLE grupo ADD CONSTRAINT grupo_curso_letra_un UNIQUE ( curso,
                                                               letra );

CREATE TABLE matr (
    curso                INTEGER NOT NULL,
    estado               VARCHAR2(20 CHAR),
    num_archivo          INTEGER,
    turno_pref           VARCHAR2(20 CHAR),
    fecha                VARCHAR2(30 BYTE) NOT NULL,
    nuevo_ingreso        CHAR(2 BYTE),
    listado_asignaturas  VARCHAR2(50 CHAR),
    exp_num              INTEGER NOT NULL
);

ALTER TABLE matr ADD CONSTRAINT matr_pk PRIMARY KEY ( curso,
                                                      exp_num ) USING INDEX TABLESPACE TS_INDICES;

CREATE TABLE opt (
    referencia  INTEGER NOT NULL,
    mencion     VARCHAR2(50 CHAR)
);

ALTER TABLE opt ADD CONSTRAINT opt_pk PRIMARY KEY ( referencia ) USING INDEX TABLESPACE TS_INDICES;

CREATE TABLE titu (
    codigo    INTEGER NOT NULL,
    nombre    VARCHAR2(100 CHAR),
    creditos  INTEGER
);

ALTER TABLE titu ADD CONSTRAINT titu_pk PRIMARY KEY ( codigo ) USING INDEX TABLESPACE TS_INDICES;

CREATE TABLE titu_centro (
    titu_codigo  INTEGER NOT NULL,
    centro_id    INTEGER NOT NULL
);

ALTER TABLE titu_centro ADD CONSTRAINT titu_centro_pk PRIMARY KEY ( titu_codigo,
                                                                    centro_id ) USING INDEX TABLESPACE TS_INDICES;

ALTER TABLE asig_matr
    ADD CONSTRAINT asig_matr_asig_fk FOREIGN KEY ( asig_referencia )
        REFERENCES asig ( referencia );

ALTER TABLE asig_matr
    ADD CONSTRAINT asig_matr_grupo_fk FOREIGN KEY ( grupo_id )
        REFERENCES grupo ( id );

ALTER TABLE asig_matr
    ADD CONSTRAINT asig_matr_matr_fk FOREIGN KEY ( matr_curso,
                                                   matr_exp_num )
        REFERENCES matr ( curso,
                          exp_num );

ALTER TABLE asig
    ADD CONSTRAINT asig_titu_fk FOREIGN KEY ( titu_codigo )
        REFERENCES titu ( codigo );

ALTER TABLE clase
    ADD CONSTRAINT clase_asig_fk FOREIGN KEY ( asig_referencia )
        REFERENCES asig ( referencia );

ALTER TABLE clase
    ADD CONSTRAINT clase_grupo_fk FOREIGN KEY ( grupo_id )
        REFERENCES grupo ( id );

ALTER TABLE encuesta
    ADD CONSTRAINT encuesta_exp_fk FOREIGN KEY ( exp_num )
        REFERENCES exp ( num );

ALTER TABLE encuesta_gpa
    ADD CONSTRAINT encuesta_gpa_encuesta_fk FOREIGN KEY ( encuesta_fecha_de_envio )
        REFERENCES encuesta ( fecha_de_envio );

ALTER TABLE encuesta_gpa
    ADD CONSTRAINT encuesta_gpa_gpa_fk FOREIGN KEY ( gpa_c,
                                                     gpa_asig_referencia,
                                                     gpa_id )
        REFERENCES gpa ( c,
                         asig_referencia,
                         grupo_id );

ALTER TABLE exp
    ADD CONSTRAINT exp_alumno_fk FOREIGN KEY ( alumno_id )
        REFERENCES alumno ( id );

ALTER TABLE exp
    ADD CONSTRAINT exp_titu_fk FOREIGN KEY ( titu_codigo )
        REFERENCES titu ( codigo );

ALTER TABLE gpa
    ADD CONSTRAINT gpa_asig_fk FOREIGN KEY ( asig_referencia )
        REFERENCES asig ( referencia );

ALTER TABLE gpa
    ADD CONSTRAINT gpa_grupo_fk FOREIGN KEY ( grupo_id )
        REFERENCES grupo ( id );

ALTER TABLE grupo
    ADD CONSTRAINT grupo_grupo_fk FOREIGN KEY ( grupo_id )
        REFERENCES grupo ( id );

ALTER TABLE grupo
    ADD CONSTRAINT grupo_titu_fk FOREIGN KEY ( titu_codigo )
        REFERENCES titu ( codigo );

ALTER TABLE matr
    ADD CONSTRAINT matr_exp_fk FOREIGN KEY ( exp_num )
        REFERENCES exp ( num );

ALTER TABLE opt
    ADD CONSTRAINT opt_asig_fk FOREIGN KEY ( referencia )
        REFERENCES asig ( referencia );

ALTER TABLE titu_centro
    ADD CONSTRAINT titu_centro_centro_fk FOREIGN KEY ( centro_id )
        REFERENCES centro ( id );

ALTER TABLE titu_centro
    ADD CONSTRAINT titu_centro_titu_fk FOREIGN KEY ( titu_codigo )
        REFERENCES titu ( codigo );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                            14
-- CREATE INDEX                             0
-- ALTER TABLE                             35
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0
