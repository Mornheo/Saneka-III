ALTER TABLE ASIGNATURA DROP CONSTRAINT FK_ASIGNATURA_TITULACION_CODIGO
ALTER TABLE ASIGNATURASMATRICULA DROP CONSTRAINT FK_ASIGNATURASMATRICULA_ASIGNATURA_REFERENCIA
ALTER TABLE ASIGNATURASMATRICULA DROP CONSTRAINT FK_ASIGNATURASMATRICULA_CURSOACADEMICO
ALTER TABLE ASIGNATURASMATRICULA DROP CONSTRAINT FK_ASIGNATURASMATRICULA_GRUPO_ID
ALTER TABLE CLASE DROP CONSTRAINT FK_CLASE_GRUPO_ID
ALTER TABLE CLASE DROP CONSTRAINT FK_CLASE_ASIGNATURA_REFERENCIA
ALTER TABLE ENCUESTA DROP CONSTRAINT FK_ENCUESTA_EXPEDIENTE_NUMEXPEDIENTE
ALTER TABLE EXPEDIENTE DROP CONSTRAINT FK_EXPEDIENTE_ALUMNO_DNI
ALTER TABLE EXPEDIENTE DROP CONSTRAINT FK_EXPEDIENTE_TITULACION_CODIGO
ALTER TABLE GRUPO DROP CONSTRAINT FK_GRUPO_TITULACION_CODIGO
ALTER TABLE GRUPO DROP CONSTRAINT FK_GRUPO_GRUPOS_ID
ALTER TABLE GRUPOSPORASIGNATURA DROP CONSTRAINT FK_GRUPOSPORASIGNATURA_ASIGNATURA_REFERENCIA
ALTER TABLE GRUPOSPORASIGNATURA DROP CONSTRAINT FK_GRUPOSPORASIGNATURA_GRUPO_ID
ALTER TABLE MATRICULA DROP CONSTRAINT FK_MATRICULA_EXPEDIENTE_NUMEXPEDIENTE
ALTER TABLE USUARIO DROP CONSTRAINT FK_USUARIO_ALUMNO_DNI
ALTER TABLE CENTRO_TITULACION DROP CONSTRAINT FK_CENTRO_TITULACION_titulaciones_CODIGO
ALTER TABLE CENTRO_TITULACION DROP CONSTRAINT FK_CENTRO_TITULACION_centros_ID
ALTER TABLE ENCUESTA_GRUPOSPORASIGNATURA DROP CONSTRAINT FK_ENCUESTA_GRUPOSPORASIGNATURA_CURSOACADEMICO
ALTER TABLE ENCUESTA_GRUPOSPORASIGNATURA DROP CONSTRAINT ENCUESTA_GRUPOSPORASIGNATURAencuestas_FECHADEENVIO
ALTER TABLE ASIGNATURA_TITULACION DROP CONSTRAINT FK_ASIGNATURA_TITULACION_optativas_REFERENCIA
ALTER TABLE ASIGNATURA_TITULACION DROP CONSTRAINT FK_ASIGNATURA_TITULACION_titulaciones_CODIGO
DROP TABLE ALUMNO
DROP TABLE ASIGNATURA
DROP TABLE ASIGNATURASMATRICULA
DROP TABLE CENTRO
DROP TABLE CLASE
DROP TABLE ENCUESTA
DROP TABLE EXPEDIENTE
DROP TABLE GRUPO
DROP TABLE GRUPOSPORASIGNATURA
DROP TABLE MATRICULA
DROP TABLE TITULACION
DROP TABLE USUARIO
DROP TABLE CENTRO_TITULACION
DROP TABLE ENCUESTA_GRUPOSPORASIGNATURA
DROP TABLE ASIGNATURA_TITULACION
