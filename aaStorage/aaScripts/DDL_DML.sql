--database: aaStorage\aaDatabases\aaExobot.sqlite
DROP TABLE IF EXISTS aaUsuario;
DROP TABLE IF EXISTS aaExobot;
DROP TABLE IF EXISTS aaMunicion;
DROP TABLE IF EXISTS aaAccionEvento;

CREATE TABLE IF NOT EXISTS aaAccionEvento (
    aaIdEvento    INTEGER PRIMARY KEY AUTOINCREMENT,
    aaFecha       DATETIME DEFAULT CURRENT_TIMESTAMP,
    aaDescripcion TEXT NOT NULL,
    aaEstado      TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS aaMunicion (
    aaIdMunicion  INTEGER PRIMARY KEY AUTOINCREMENT,
    aaNombre      TEXT NOT NULL,
    aaTipo        TEXT NOT NULL
);


CREATE TABLE IF NOT EXISTS aaExobot (
    aaIdExobot    INTEGER PRIMARY KEY AUTOINCREMENT,
    aaTipoExobot  TEXT NOT NULL,
    aaTipoArma    TEXT NOT NULL,
    aaEntreno     TEXT DEFAULT 'NO',
    aaNoAccion    INTEGER DEFAULT 0
);


CREATE TABLE IF NOT EXISTS aaUsuario (
    aaIdUsuario   INTEGER PRIMARY KEY AUTOINCREMENT,
    aaCedula      TEXT UNIQUE NOT NULL,
    aaUsuario     TEXT NOT NULL,
    aaClave       TEXT NOT NULL
);


INSERT INTO aaUsuario (aaCedula, aaUsuario, aaClave) 
VALUES ('1724077829', 'patmic', '123'); 

INSERT INTO aaMunicion (aaNombre, aaTipo) 
VALUES ('Laser', 'Energía');

SELECT * FROM aaUsuario; 
SELECT * FROM aaMunicion;